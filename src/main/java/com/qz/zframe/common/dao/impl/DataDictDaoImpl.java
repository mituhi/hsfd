package com.qz.zframe.common.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataDictDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}
