package com.ruby.dao;

import java.util.List;
import java.util.Map;

import com.ruby.bean.EmployeBean;

public interface EmployeDAO {
public int delete(int id);
public EmployeBean getEmployeById(int id);
public int update(EmployeBean eb);
public List<EmployeBean> findall();
public int insert(EmployeBean eb);
public List<Map<String, Object>> login(EmployeBean eb);
public List<Map<String, Object>> id(EmployeBean eb);

}