package com.qz.zframe.material.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.material.entity.DamagedAudit;
import com.qz.zframe.material.entity.DamagedAuditExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DamagedAuditMapper extends BaseMapper<DamagedAudit, DamagedAuditExample, Long>{

	void delBydamagedAuditIds(List<String> damagedAuditIds);
   
}