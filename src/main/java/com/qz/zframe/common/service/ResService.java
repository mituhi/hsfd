package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.Res;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;

public interface ResService {
	
	/**
     * 新增资源信息
     *
     * @param res 资源对象
     * @return Res
     */
    PageResultEntity addRes(Res res);

    /**
     * 批量获取资源信息
     *
     * @param res 资源对象
     * @return List
     */
    List<Res> findResList(Res res);

    /**
     * 批量删除资源信息
     *
     * @param resIds 资源id列表
     * @return 
     */
    PageResultEntity deleteResInBatch(List<String> resIds);

    /**
     * 修改资源信息
     *
     * @param res 资源对象
     * @return 
     */
    PageResultEntity updateRes(Res res);

    /**
     * 批量获取角色下的资源信息
     *
     * @param roleId 角色id
     * @return List
     */
    List<Res> findRoleResList(String roleId);

    /**
     * 关联角色资源
     *
     * @param roleId 角色id
     * @param resId  资源id
     */
    void relaRoleRes(String roleId, String resId);

    /**
     * 取消关联角色资源
     *
     * @param roleId 角色id
     * @param resId  资源id
     * @return 
     */
    PageResultEntity removeRelaRoleRes(String roleId, String resId);

    /**
     * 批量获取用户的资源信息
     *
     * @param userId 用户id
     * @return List
     */
    List<Res> listUserRes(String userId);


    /**
     * 获取资源树 用户角色参数二选一
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    List<Res> queryTreeMenuInfoList(String userId, String roleId);

    /**
     * 获取菜单树
     *
     * @param userId
     * @param roleId
     * @return
     */
    public List<Res> getMenuTreeData(String userId, String roleId);

    /**
     * 批量关联角色资源
     *
     * @param roleId 角色id
     * @param resIds 资源id列表
     */
    void relaRoleResBatch(String roleId, List<String> resIds);

    /**
     * 清空角色资源
     *
     * @param roleId 角色id
     * @return 
     */
    PageResultEntity clearRoleRes(String roleId);

    /**
     * 分页查询菜单信息
     * @param resValue
     * @param resName
     * @param pageNum
     * @param pageSize
     * @return
     */
	PageResultEntity queryResPage(String resValue, String resName, Integer pageNum, Integer pageSize);
	
	/**
     * 获取完整资源树
     *
     * @return List
     */
    Res findAllResList();

    /**
     * 根据id查询菜单信息
     * @param resId
     * @return
     * @throws Exception 
     */
	Res queryResInfo(String resId) throws Exception;

    /**
     * 根据菜单id获取用户是否有进入菜单的权限
     * @param resId
     * @return
     */
    ResultEntity queryPermissions(String resId);

    /**
     * 根据菜单id获取按钮信息
     * @param resId
     * @return
     */
    ResultEntity queryButton(String resId);
}
