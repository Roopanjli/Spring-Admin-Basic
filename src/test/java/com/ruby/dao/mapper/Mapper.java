package com.ruby.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ruby.bean.EmployeBean;

public class Mapper implements RowMapper<EmployeBean> {

	@Override
	public EmployeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeBean eb=new EmployeBean(); 
		eb.setId(rs.getInt(1));
		eb.setName(rs.getString(2));
		eb.setDesig(rs.getString(3));
		eb.setDept(rs.getString(4));
		eb.setSalary(rs.getDouble(5));
		eb.setEmail(rs.getString(6));
		eb.setAge(rs.getInt(7));
		eb.setPassword(rs.getString(8));
		
		return eb;
	}

}
