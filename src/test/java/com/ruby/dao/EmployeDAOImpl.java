package com.ruby.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ruby.bean.EmployeBean;
import com.ruby.dao.mapper.Mapper;

public class EmployeDAOImpl implements EmployeDAO {
private JdbcTemplate jt;

public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}

@Override
public int delete(int id) {
	String sql="delete from employe1 where id=?";
	int n=jt.update(sql,new Object[] {id});
	return n;
}

@Override
public EmployeBean getEmployeById(int id) {
	String sql="select * from employe1 where id=?";
	      EmployeBean n= jt.queryForObject(sql, new Object[] {id} , new BeanPropertyRowMapper<EmployeBean>(EmployeBean.class));
	return n;
}

@Override

public int update(EmployeBean eb) {
String sql="update employe1 set id=?,name=?,desig=?,dept=?,salary=?,email=?,age=?,password=? where id="+eb.getId()+"";
	System.out.println("update in Dao");
int n = jt.update(sql,new Object[] {eb.getId(),eb.getName(),eb.getDesig(),eb.getDept(),eb.getSalary(),eb.getEmail(),eb.getAge(),eb.getPassword()});
return n;
}
@Override
public List<EmployeBean> findall() {
	String sql="select * from employe1";
	List<EmployeBean> eb=new ArrayList<EmployeBean>();
	 List<Map<String, Object>> n = jt.queryForList(sql);
	 for(Map map :n) {
		EmployeBean e=new EmployeBean();
		e.setId((int) map.get("id"));
		e.setName((String) map.get("name"));
		e.setDesig((String) map.get("desig"));
		e.setDept((String) map.get("dept"));
		e.setSalary((double) map.get("salary"));
		e.setEmail((String) map.get("email"));
		e.setAge((int) map.get("age"));
		e.setPassword((String) map.get("password"));
		eb.add(e);		
	 }
	return eb;
}

@Override
public int insert(EmployeBean eb) {
	String sql="insert into employe1(id,name,desig,dept,salary,email,age,password)values(?,?,?,?,?,?,?,?)";
    int n = jt.update(sql, new Object[] {eb.getId(),eb.getName(),eb.getDesig(),eb.getDept(),eb.getSalary(),eb.getEmail(),eb.getAge(),eb.getPassword()});
	
	return n;
}

	


@Override
public List<Map<String, Object>> id(EmployeBean eb) {
	String sql="select *from employe1 where id=?";
	List<Map<String, Object>> n = jt.queryForList(sql,new Object[] {eb.getId()});

	return n;
	
}

@Override
public List<Map<String, Object>> login(EmployeBean eb) {
	String sql="select *from employe1 where email=? and password=?";
	List<Map<String, Object>> n = jt.queryForList(sql,new Object[] {eb.getEmail(),eb.getPassword()});

	return n;
}





}
