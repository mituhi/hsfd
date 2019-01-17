package com.qz.zframe.common.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.CodeConfigDao;
import com.qz.zframe.common.entity.CodeConfig;
import com.qz.zframe.common.service.CodeConfigService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CodeConfigServiceImpl implements CodeConfigService {
	
	@Autowired
	private CodeConfigDao codeConfigDao;

	@Autowired
	private CurrentUserService currentUserService;

	/**
	 * 分页查询编码配置信息
	 * @param configType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageResultEntity queryCodeConfig(String configType, Integer pageNum, Integer pageSize) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex = (pageNum - 1) * pageSize;
		//到第几条数据结束
		int lastIndex = pageNum * pageSize;
		List<CodeConfig> list = codeConfigDao.queryCodeConfig(configType, firstIndex, lastIndex);
		if (list == null || list.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			Integer num = codeConfigDao.queryCodeConfigNum(configType);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	/**
	 * 根据id编码配置信息
	 * @param configId
	 * @return
	 */
	@Override
	public CodeConfig queryCodeConfigById(String configId) throws Exception {
		if (StringUtils.isBlank(configId)) {
			throw new Exception("配置id不能为空!");
		}
		return codeConfigDao.queryCodeConfigById(configId);
	}

	/**
	 * 新增编码配置
	 * @param codeConfig
	 * @return
	 */
	@Override
	public ResultEntity addCodeConfig(CodeConfig codeConfig) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if (codeConfig == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("传入对象不能为空!");
			return resultEntity;
		}
		//判断必填字段
		resultEntity = checkFields(codeConfig);
		if (ErrorCode.ERROR == resultEntity.getCode()) {
			return resultEntity;
		}
		//判断是否已经有配置信息
		boolean result = checkCodeConfigByMsg(codeConfig.getConfigType(), codeConfig.getBusinessCode());
		if (result) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("该对象已经配置过!");
			return resultEntity;
		}

		codeConfig.setConfigId(UUID.randomUUID().toString().replaceAll("-",""));
		codeConfig.setCreater(currentUserService.getId());
		codeConfig.setCreateTime(new Date());
		codeConfigDao.addCodeConfig(codeConfig);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("保存成功");
		return resultEntity;
	}

	/**
	 * 判断必填字段
	 * @param codeConfig
	 * @return
	 */
	private ResultEntity checkFields(CodeConfig codeConfig) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(codeConfig.getConfigType())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("配置类型不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(codeConfig.getBusinessCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("业务编号不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(codeConfig.getConfigType())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("配置值不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(codeConfig.getConfigType())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("状态不能为空");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 修改编码配置
	 * @param codeConfig
	 * @return
	 */
	@Override
	public ResultEntity updateCodeConfig(CodeConfig codeConfig) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if (codeConfig == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("传入对象不能为空!");
			return resultEntity;
		}
		if (StringUtils.isBlank(codeConfig.getConfigId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("编码配置id不能为空!");
			return resultEntity;
		}

		//判断必填字段
		resultEntity = checkFields(codeConfig);
		if (ErrorCode.ERROR == resultEntity.getCode()) {
			return resultEntity;
		}

		//判断是否已经有配置信息
		boolean result = checkCodeConfigByMsg(codeConfig.getConfigType(), codeConfig.getBusinessCode());
		if (result) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("该对象已经配置过!");
			return resultEntity;
		}

		codeConfigDao.updateCodeConfig(codeConfig);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
	}

	/**
	 * 根据条件判断编码配置信息是否已经配置过
	 * 是 true 否 false
	 * @param configType
	 * @param businessCode
	 * @return
	 */
	@Override
	public boolean checkCodeConfigByMsg(String configType, String businessCode) throws Exception {
		if (StringUtils.isBlank(configType)) {
			throw new Exception("配置类型不能为空");
		}
		List<CodeConfig> codeConfigs = codeConfigDao.findConfigByMsg(configType, businessCode);
		if (CollectionUtils.isEmpty(codeConfigs)) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * 删除编码配置
	 * @param configIds
	 * @return
	 */
	@Override
	public ResultEntity deleteCodeConfig(List<String> configIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isEmpty(configIds)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空!");
			return resultEntity;
		}
		//TODO 判断是否有业务使用到

		codeConfigDao.deleteCodeConfig(configIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

	/**
	 * 根据条件查询配置值
	 * @param configType
	 * @param businessCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public String findValueByMsg(String configType, String businessCode) throws Exception {
		if (StringUtils.isBlank(configType)) {
			throw new Exception("配置类型不能为空");
		}
		List<CodeConfig> codeConfigs = codeConfigDao.findConfigByMsg(configType, businessCode);
		if (CollectionUtils.isEmpty(codeConfigs)) {
			return null;

		}else if (codeConfigs.size() > 1) {
			throw new Exception("配置出错，请联系管理员");
		}else {
			return codeConfigs.get(0).getConfigValue();
		}
	}
}

