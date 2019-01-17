package com.qz.zframe.common.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.dao.ResDao;
import com.qz.zframe.common.entity.MenuTreeComparatorRes;
import com.qz.zframe.common.entity.MenuTreeNodeResult;
import com.qz.zframe.common.entity.Res;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.service.ResService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.isc.IscConstants;
import com.qz.zframe.isc.enums.IscResTypeEnum;
import com.qz.zframe.isc.service.menuTree.context.MenuTreeNodeContext;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResServiceImpl implements ResService {
	private static final Logger logger = LoggerFactory.getLogger(ResServiceImpl.class);
	
	@Autowired
	private ResDao resDao;
	
	@Autowired
    private RoleService roleService;
	 
	@Autowired
	private ResService resService;

	@Autowired
	private CurrentUserService currentUserService;

    /**
     * 新增资源
     *
     * @param res 资源对象
     * @return Res
     */
    @Override
    public PageResultEntity addRes(Res res) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        // 校验参数
    	if (StringUtils.isBlank(res.getResName())) {
    		pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("资源名称为空!");
			return pageResultEntity;
        }
        if (StringUtils.isBlank(res.getResValue())) {
        	pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("资源值为空!");
			return pageResultEntity;
        }

        String resId = UUID.randomUUID().toString().replaceAll("-", "");
        res.setResId(resId);
        res.setResType(getResType(res.getResType()));
        res.setOrderNo(getOrderNo(res.getOrderNo()));

        // 资源路径
        String resPath = "/" + resId;
        if (StringUtils.isNotBlank(res.getResPid())) {
            Res pRes = getRes(res.getResPid());
            resPath = pRes.getResPath() + resPath;
        }
        res.setResPath(resPath);

        resDao.addRes(res);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }
    
    /**
     * 获取资源类型
     *
     * @param resType 资源类型
     * @return String
     */
    private static String getResType(String resType) {
        if (StringUtils.isNotBlank(resType)) {
            resType = IscResTypeEnum.DEFAULT.getCode();
        }
        return resType;
    }
    
    /**
     * 获取排序号
     *
     * @param orderNo 排序号
     * @return Integer
     */
    private static Integer getOrderNo(Integer orderNo) {
        if (orderNo == null) {
            orderNo = IscConstants.ORDER_NO_DEFAULT;
        }
        return orderNo;
    }

    /**
     * 根据资源id获取资源信息
     *
     * @param resId 资源id
     * @return Res
     */
    private Res getRes(String resId) {
        Res res = new Res();
        res.setResId(resId);
        List<Res> resList = findResList(res);
        if (CollectionUtils.isNotEmpty(resList)) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 批量获取资源信息
     *
     * @param res 资源对象
     * @return List
     */
    @Override
    public List<Res> findResList(Res res) {
        return resDao.findResList(res);
    }

    /**
     * 批量删除资源信息
     * <p>
     * 处理逻辑：
     * 1.删除资源表数据
     * 2.删除角色资源关系表数据
     * </p>
     *
     * @param resIds 资源id列表
     */
    @Override
    public PageResultEntity deleteResInBatch(List<String> resIds) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        if (CollectionUtils.isNotEmpty(resIds)) {
            // 先判断资源下是否包含下级资源，如果包含下级，则不允许删除
            Res res;
            for (int i = 0, size = resIds.size(); i < size; i++) {
                res = new Res();
                res.setResPid(resIds.get(i));
                List<Res> subResList = findResList(res);
                if (CollectionUtils.isNotEmpty(subResList)) {
                	pageResultEntity.setCode(ErrorCode.ERROR);
        			pageResultEntity.setMsg("包含下级资源，不能删除!");
        			return pageResultEntity;
                }
            }
            // 1.删除资源表数据
            int i = resDao.deleteResInBatch(resIds);
            if (i > 0) {
                // 2.删除角色资源关系表数据
            	resDao.deleteRoleResRelaByResIds(resIds);
            }
            pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
        }
        pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("传入参数为空!");
		return pageResultEntity;
    }

    /**
     * 修改资源信息
     *
     * @param res 资源对象
     */
    @Override
    public PageResultEntity updateRes(Res res) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        resDao.updateResMsg(res);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }

    /**
     * 批量获取角色下的资源信息
     *
     * @param roleId 角色id
     * @return List
     */
    @Override
    public List<Res> findRoleResList(String roleId) {
        return resDao.findRoleResList(roleId);
    }

    /**
     * 关联角色资源
     * <p>
     * 处理逻辑：
     * 1.判断是否已经关联过
     * 2.关联角色资源
     * 3.递归上级资源关联，通过资源路径递归关联上级
     * </p>
     *
     * @param roleId 角色id
     * @param resId  资源id
     */
    @Override
    public void relaRoleRes(String roleId, String resId) {
        if (StringUtils.isBlank(roleId) || StringUtils.isBlank(resId)) {
            return;
        }
        // 关联角色资源
        relaRoleResInternal(roleId, resId);
        // 递归上级资源关联
        Res res = getRes(resId);
        // /a/b/c，先去除最后一个“/”以及后面的内容（去除自己），然后去除第一个“/”
        String resPath = res.getResPath();
        resPath = resPath.substring(0, resPath.lastIndexOf("/"));
        if (StringUtils.isNotBlank(resPath)) {
            resPath = resPath.substring(1);
            String[] resIds = resPath.split("/");
            // 迭代关联角色资源
            Arrays.stream(resIds).forEach(resIdTemp -> relaRoleResInternal(roleId, resIdTemp));
        }
    }

    /**
     * 关联角色资源
     *
     * @param roleId 角色id
     * @param resId  资源id
     */
    private void relaRoleResInternal(String roleId, String resId) {
        // 判断是否已经关联过
        // 批量获取角色资源关系信息
        Map<String, Object> params = new HashMap<>(3);
        params.put("roleId", roleId);
        params.put("resId", resId);
        List<Map<String, Object>> resList = resDao.findRoleResRelaList(params);
        if (CollectionUtils.isNotEmpty(resList)) {
            logger.warn("角色ID：{}，与资源ID：{}已经关联过！", roleId, resId);
            return;
        }
        params.put("relaId", UUID.randomUUID().toString().replaceAll("-", ""));
        resDao.addRoleResRela(params);
    }

    /**
     * 取消关联角色资源
     * <p>
     * 处理逻辑：
     * 1.删除该资源的角色资源关系
     * 2.删除该资源的所有下级资源的角色资源关系
     * </p>
     *
     * @param roleId 角色id
     * @param resId  资源id
     */
    @Override
    public PageResultEntity removeRelaRoleRes(String roleId, String resId) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        if (StringUtils.isNotBlank(roleId) && StringUtils.isNotBlank(resId)) {
            Map<String, Object> params = new HashMap<>(2);
            params.put("roleId", roleId);
            params.put("resId", resId);
            // 1.删除该资源的角色资源关系
            int i = resDao.deleteRoleResRela(params);
            // 2.删除该资源的所有下级资源的角色资源关系
            if (i > 0) {
                // 根据资源id获取资源信息
                Res res = getRes(resId);
                if (res != null) {
                    // 获取该资源的所有下级资源（不包含自己）
                    // 资源路径后面加"/"，查询不包含自己的下级资源
                    List<Res> subResList = listResByPath(res.getResPath() + "/");
                    if (CollectionUtils.isNotEmpty(subResList)) {
                        // 只获取下级资源id列表，根据资源id列表批量删除
                        List<String> subResIds = subResList.stream().map(subRes -> res.getResId()).collect(Collectors.toList());
                        resDao.deleteRoleResRelaByResIds(subResIds);
                    }
                }
            }
            pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
        }
        pageResultEntity.setCode(ErrorCode.ERROR);
		pageResultEntity.setMsg("传入参数为空!");
		return pageResultEntity;
    }

    /**
     * 根据资源路径批量获取资源信息
     *
     * @param resPath 资源路径
     * @return List
     */
    private List<Res> listResByPath(String resPath) {
        if (StringUtils.isNotBlank(resPath)) {
            Res res = new Res();
            res.setResPath(resPath);
            return findResList(res);
        }
        return Collections.emptyList();
    }

    /**
     * 批量获取用户的资源信息
     * <p>
     * 处理逻辑：
     * 1.批量获取用户的角色信息
     * 2.批量获取角色的资源信息
     * 3.用户的资源信息去重
     * </p>
     *
     * @param userId 用户id
     * @return List
     */
    @Override
    public List<Res> listUserRes(String userId) {
        // 批量获取用户的角色信息
        List<Role> roles = roleService.findUserRoleList(userId);
        if (CollectionUtils.isNotEmpty(roles)) {
            List<String> roleIds = roles.stream().map(role -> role.getRoleId()).collect(Collectors.toList());
            // 根据角色id列表批量获取角色的资源信息
            List<Res> resList = resDao.findRoleResByRoleIdsList(roleIds);
            // 根据资源id去重
            return resList.stream().collect(
                    Collectors.collectingAndThen(
                            Collectors.toCollection(() -> new TreeSet<Res>(Comparator.comparing(Res::getResId))),
                            ArrayList::new));
        }
        return Collections.emptyList();
    }

    /**
     * 获取资源树 用户角色参数二选一
     *
     * @param userId 用户id 多角色
     * @param roleId 角色id
     * @return
     */
    @Override
    public List<Res> queryTreeMenuInfoList(String userId, String roleId) {
        if (StringUtils.isNotBlank(userId)) {
            return resDao.findTreeMenuInfoListByUserId(userId);
        } else if (StringUtils.isNotBlank(roleId)) {
            return resDao.findTreeMenuInfoListByRoleId(roleId);
        } else {
            return Collections.emptyList();
        }
    }


    /**
     * 获取资源树对象- layui
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    @Override
    public List<Res> getMenuTreeData(String userId, String roleId) {
        MenuTreeNodeContext menuTreeNodeContext = new MenuTreeNodeContext();
        if (StringUtils.isNotBlank(userId)) {
            menuTreeNodeContext.setUserId(userId);
        }
        if (StringUtils.isNotBlank(roleId)) {
            menuTreeNodeContext.setRoleId(roleId);
        }
        MenuTreeNodeResult resultMessage = buildTreeNodeData(menuTreeNodeContext);
        if (resultMessage.isSuccess()) {
            return resultMessage.getResList();
        }
        return new ArrayList<>();
    }
    
    private MenuTreeNodeResult buildTreeNodeData(MenuTreeNodeContext menuTreeNodeContext) {
        Assert.notNull(menuTreeNodeContext, "查询创建树形节点列表参数不能为空");
        List<Res> iscResList = queryMenuInfoList(menuTreeNodeContext);

        List<Res> treeNodeList = getMenuTreeNodeList(iscResList);

        return new MenuTreeNodeResult(Boolean.TRUE, treeNodeList);
    }
    
    /**
    *
    * @param menuTreeNodeContext
    * @return
    */
   private List<Res> queryMenuInfoList(MenuTreeNodeContext menuTreeNodeContext) {

       //可扩展，根据用户筛选权限菜单
       String userId = menuTreeNodeContext.getUserId();
       String roleId = menuTreeNodeContext.getRoleId();
       try {
           return resService.queryTreeMenuInfoList(userId,roleId);
       }catch (Exception e){
           logger.error("查询组织异常：{{}}",e);
           return new ArrayList<>();
       }
   }

   /**
    * 获取顶级菜单节点
    * @param menuModelList
    * @return
    */
   private List<Res> getMenuTreeNodeList(List<Res> menuModelList) {
       List<Res> resultList = new ArrayList<>();
       Res res = null;
       for (Res menuModel : menuModelList) {
           String parentId = menuModel.getResPid();
           if (isTopParent(parentId)) {
        	   res = new Res();
               copyEasyUiTreeNode(res, menuModel);
               resultList.add(res);
               recurisiveChildNode(res, menuModelList);
           }
       }
       Collections.sort(resultList, new MenuTreeComparatorRes());
       return resultList;
   }
   
   private void recurisiveChildNode(Res res, List<Res> menuModelList) {
       List<Res> childNodeList = res.getChildren();
       String parentId = res.getResId();
       Res childres;
       for (Res menuModel : menuModelList) {
           String menuParentId = menuModel.getResPid();
           if (isParentOrganizeId(parentId, menuParentId)) {
        	   childres = new Res();
               copyEasyUiTreeNode(childres, menuModel);
               childNodeList.add(childres);
               //递归调用
               recurisiveChildNode(childres, menuModelList);
           }
       }
       Collections.sort(childNodeList, new MenuTreeComparatorRes());
   }

   /**
    * 判断当前节点的ID和父组织的ID是否相等，判定当前是否是否为当前节点的子节点
    * @param parentId 节点的ID
    * @param menuParentId 父节点id
    * @return
    */
   private boolean isParentOrganizeId(String parentId, String menuParentId) {
       return parentId.equals(menuParentId);
   }

   private void copyEasyUiTreeNode(Res res, Res menuModel) {
       BeanUtils.copyProperties(menuModel, res);
       res.setOrderNo(menuModel.getOrderNo());
       res.setChildren(menuModel.getChildren());
   }

   /**
    * 是否是顶级组织
    *
    * @return
    */

   private boolean isTopParent(String parentId) {
       return StringUtils.isBlank(parentId);
   }

    /**
     * 批量关联角色资源信息
     *
     * @param roleId 角色id
     * @param resIds 资源id列表
     */
    @Override
    public void relaRoleResBatch(String roleId, List<String> resIds) {
        if (CollectionUtils.isNotEmpty(resIds)) {
            resIds.stream().forEach(resId -> relaRoleRes(roleId, resId));
        }
    }

    /**
     * 清空角色资源
     *
     * @param roleId 角色id
     */
    @Override
    public PageResultEntity clearRoleRes(String roleId) {
    	PageResultEntity pageResultEntity = new PageResultEntity();
        resDao.clearRoleRes(roleId);
        pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
    }

	@Override
	public PageResultEntity queryResPage(String resValue, String resName, Integer pageNum, Integer pageSize) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex = (pageNum - 1) * pageSize;
		//到第几条数据结束
		int lastIndex = pageNum * pageSize;
    	List<Role> roles = resDao.findResPage(resValue, resName, firstIndex, lastIndex);
    	if (roles == null || roles.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			Integer num = resDao.findCountRes(resValue, resName);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(roles);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	@Override
	public Res findAllResList() {
		Res res = new Res();
        Res result = new Res();
		res.setResType("01");
		List<Res> fiRes = findResList(res);//根节点
        if (fiRes != null && !fiRes.isEmpty()) {
            result = fiRes.get(0);
            res.setResType("02");
            List<Res> seRes = findResList(res);//一级菜单
            res.setResType("03");
            List<Res> thRes = findResList(res);//二级菜单
            if (thRes != null && !thRes.isEmpty() && seRes != null && !seRes.isEmpty()) {
                for (Res ser : seRes) {
                    List<Res> list = new ArrayList<Res>();
                    for (Res thr : thRes) {
                        if (ser.getResId().equals(thr.getResPid())) {
                            list.add(thr);
                        }
                    }
                    ser.setChildren(list);
                }
            }
            result.setChildren(seRes);
        }
		return result;
	}

	@Override
	@CodeConvert({
		@CodeType(codeType="RES_TYPE", nameField="resType", titleField="resTypeText")
	})
	public Res queryResInfo(String resId) throws Exception {
		if (StringUtils.isBlank(resId)) {
			throw new Exception("请选择菜单");
		}
		Res res = resDao.queryResInfo(resId);
		if (res != null && StringUtils.isNotBlank(res.getResPid())) {
			Res resPid = resDao.queryResInfo(res.getResPid());
			if (resPid != null) {
				res.setResPidName(resPid.getResName());
			}
		}
		return res;
	}

    @Override
    public ResultEntity queryPermissions(String resId) {
        ResultEntity resultEntity = new ResultEntity();
        if (StringUtils.isBlank(resId)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("菜单id不能为空!");
            return resultEntity;
        }
        String userId = currentUserService.getId();
        List<Role> roles = roleService.findUserRoleList(userId);
        if (roles != null && !roles.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("resId", resId);
            map.put("roles", roles);
            int num = resDao.findCountByMsg(map);
            if (num > 0) {
                resultEntity.setCode(ErrorCode.SUCCESS);
                resultEntity.setMsg("有访问权限!");
                return resultEntity;
            }else{
                resultEntity.setCode(ErrorCode.ERROR);
                resultEntity.setMsg("没有访问权限!");
                return resultEntity;
            }
        }else{
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("用户没有绑定角色!");
            return resultEntity;
        }
    }

    /**
     * 根据菜单id获取按钮信息
     * @param resId
     * @return
     */
    @Override
    public ResultEntity queryButton(String resId) {
        ResultEntity resultEntity = new ResultEntity();
        if (StringUtils.isBlank(resId)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("菜单id不能为空!");
            return resultEntity;
        }
        String userId = currentUserService.getId();
        //获取当前登录人角色
        List<Role> roles = roleService.findUserRoleList(userId);
        if (roles != null && !roles.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("resId", resId);
            map.put("roles", roles);
            List<Res> resList = resDao.findResByMap(map);
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setData(resList);
            return resultEntity;
        }else{
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("用户没有绑定角色!");
            return resultEntity;
        }
    }
}
