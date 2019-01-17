package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.DoList;
import com.qz.zframe.common.entity.DoRoleRela;
import com.qz.zframe.common.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoListDao {

    /**
     * 新增待办信息
     * @param doList
     * @return
     */
    int addDoList(DoList doList);

    /**
     * 新增待办角色关联信息
     * @param doRoleRelas
     * @return
     */
    int addDoRoleRelas(@Param("list") List<DoRoleRela> doRoleRelas);

    /**
     * 删除待办角色关联信息
     * @param doRoleRelas
     * @return
     */
    int deleteDoRoleRelas(@Param("doRoleRelas") List<DoRoleRela> doRoleRelas);

    /**
     * 根据待办id查询关联角色
     * @param doId
     * @return
     */
    List<DoRoleRela> findDoRoleRelaByRelaId(@Param("doId") String doId);

    /**
     * 根据任务id查询待办信息
     * @param taskId
     * @return
     */
    DoList findDoListByTaskId(@Param("taskId") String taskId);

    /**
     * 根据角色id查询待办信息
     * @param roles
     * @return
     */
    List<DoList> findDoListByRole(@Param("roles") List<Role> roles);

	/**
	 * 根据待办关联ID删除角色
	 * 
	 * @param @param pickingId    参数
	 * @return void    返回类型
	 * @throws
	 */
	void deleteByDoId(String pickingId);
}
