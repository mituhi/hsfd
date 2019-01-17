package com.qz.zframe.common.dao;

import java.util.List;

import com.qz.zframe.common.entity.Common;
import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.entity.SpFileUpload;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonDao {
	
	/**
     * 删除文件上传信息
     *
     * @param spFileUpload 文件上传对象
     */
	void deleteFileUpload(SpFileUpload spFileUpload);

	/**
     * 批量获取文件上传信息
     *
     * @param spFileUpload 文件上传对象
     * @return List
     */
	List<SpFileUpload> findfileUploadList(SpFileUpload spFileUpload);

	/**
     * 新增文件上传信息
     *
     * @param spFileUpload 文件上传对象
     */
	void addFileUpload(SpFileUpload spFileUpload);

	/**
	 * 根据fileId查询文件上传信息
	 * @param fileId
	 * @return
	 */
	SpFileUpload findByFileId(@Param("fileId") String fileId);

	/**
	 * 根据用户id查询用户所属部门等信息
	 * @param userId
	 * @return
	 */
    Common findDeptMsgByUserId(String userId);

	/**
	 * 根据用户id查询班组信息
	 * @param userId
	 * @return
	 */
	Common findTeamMsgByUserId(String userId);

	/**
	 * 根据用户id获取基本信息
	 * @param userId
	 * @return
	 */
    Common findUserBaseMsg(String userId);
}
