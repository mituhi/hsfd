package com.qz.zframe.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qz.zframe.common.entity.Res;
import com.qz.zframe.common.entity.Role;

@Mapper
public interface ResDao {

	/**
	 * 新增资源信息
	 * @param res
	 */
	void addRes(Res res);

	/**
	 * 批量获取资源信息
	 * @param res
	 * @return
	 */
	List<Res> findResList(Res res);

	/**
	 * 删除资源表数据
	 * @param resIds
	 * @return
	 */
	int deleteResInBatch(List<String> resIds);

	/**
	 * 删除角色资源关系表数据
	 * @param resIds
	 */
	void deleteRoleResRelaByResIds(List<String> resIds);

	/**
	 * 修改资源信息
	 * @param res
	 */
	void updateResMsg(Res res);

	/**
	 * 批量获取角色下的资源信息
	 * @param roleId
	 * @return
	 */
	List<Res> findRoleResList(@Param("roleId") String roleId);

	/**
	 * 批量获取角色资源关系信息
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> findRoleResRelaList(Map<String, Object> params);

	/**
	 * 新增角色资源关系
	 * @param params
	 */
	void addRoleResRela(Map<String, Object> params);

	/**
	 * 删除角色资源关系
	 * @param params
	 * @return
	 */
	int deleteRoleResRela(Map<String, Object> params);

	/**
	 * 通过角色id列表批量获取角色的资源信息
	 * @param roleIds
	 * @return
	 */
	List<Res> findRoleResByRoleIdsList(List<String> roleIds);

	/**
	 * 获取资源信息
	 * @param userId
	 * @return
	 */
	List<Res> findTreeMenuInfoListByUserId(@Param("userId") String userId);

	/**
	 * 获取资源信息
	 * @param roleId
	 * @return
	 */
	List<Res> findTreeMenuInfoListByRoleId(@Param("roleId") String roleId);

	/**
	 * 清空角色资源
	 * @param roleId
	 */
	void clearRoleRes(@Param("roleId") String roleId);

	/**
	 * 分页查询菜单信息
	 * @param resValue
	 * @param resName
	 * @param firstIndex
	 * @param lastIndex
	 * @return
	 */
	List<Role> findResPage(@Param("resValue") String resValue, @Param("resName") String resName, 
			@Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

	/**
	 * 查询菜单数量
	 * @param resValue
	 * @param resName
	 * @return
	 */
	Integer findCountRes(@Param("resValue") String resValue, @Param("resName") String resName);

	/**
	 * 根据id查询菜单信息
	 * @param resId
	 * @return
	 */
	Res queryResInfo(@Param("resId") String resId);

	/**
	 * 根据条件查询关联菜单数量
	 * @param map
	 * @return
	 */
    int findCountByMsg(@Param("map") Map<String, Object> map);

	/**
	 * 根据菜单id获取按钮信息
	 * @param map
	 * @return
	 */
	List<Res> findResByMap(@Param("map") Map<String, Object> map);
}
