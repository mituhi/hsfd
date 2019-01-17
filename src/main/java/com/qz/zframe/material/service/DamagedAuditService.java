package com.qz.zframe.material.service;

import java.util.List;

import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.DamagedAudit;
import com.qz.zframe.material.entity.DamagedAuditExample;

public interface DamagedAuditService {

	/**
	 * 获取损坏件审核列表
	 * 
	 * @param @param example
	 * @param @return    参数
	 * @return PageResultEntity    返回类型
	 * @throws
	 */
	public NewPageResult<DamagedAudit> getDamageAuditList(DamagedAuditExample example);

	public ResultEntity addDamageAudit(DamagedAudit damagedAudit);

	/**
	 * 编辑损坏件审核信息
	 * 
	 * @param @param damagedAudit
	 * @param @return    参数
	 * @return ResultEntity    返回类型
	 * @throws
	 */
	public ResultEntity editDamagedAudit(DamagedAudit damagedAudit);

	public ResultEntity delDamagedAudit(List<String> damagedAuditIds);

	public ResultEntityDetail<DamagedAudit> getDamageAuditListDatail(String damageAuditId);

}
