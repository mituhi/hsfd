package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.DamagedAudit;
import com.qz.zframe.material.entity.DamagedAuditDetail;
import com.qz.zframe.material.entity.DamagedAuditDetailExample;
import com.qz.zframe.material.entity.DamagedAuditExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DamagedAuditDetailMapper extends BaseMapper<DamagedAuditDetail, DamagedAuditDetailExample, Long>{

	/**
	 * 通过审核id删除审核详情
	 * 
	 * @param @param damagedAuditId    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void delByDamagedId(String damagedAuditId);

	public void delByDamagedIds(List<String> damagedAuditIds);
    
}