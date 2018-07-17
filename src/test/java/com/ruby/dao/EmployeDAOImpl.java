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
	String sql="delete from employe where id=?";
	int n=jt.update(sql,new Object[] {id});
	return n;
}

@Override
public EmployeBean getEmployeById(int id) {
	String sql="select * from employe where id=?";
	      EmployeBean n= jt.queryForObject(sql, new Object[] {id} , new BeanPropertyRowMapper<EmployeBean>(EmployeBean.class));
	return n;
}

@Override
/*public int update(EmployeBean eb) {
String sql="update employe set id="+eb.getId()+",name="+eb.getName()+",desig="+eb.getDesig()+",dept="+eb.getDept()+",salary="+eb.getSalary()+",age="+eb.getAge()+" where id="+eb.getId()+";";
	System.out.println("update in Dao");
int n = jt.update(sql);
return n;
}*/
public int update(EmployeBean eb) {
String sql="update employe set id=?,name=?,desig=?,dept=?,salary=?,age=? where id="+eb.getId()+"";
	System.out.println("update in Dao");
int n = jt.update(sql,new Object[] {eb.getId(),eb.getName(),eb.getDesig(),eb.getDept(),eb.getSalary(),eb.getAge()});
return n;
}
@Override
public List<EmployeBean> findall() {
	String sql="select * from employe";
	List<EmployeBean> eb=new ArrayList<EmployeBean>();
	 List<Map<String, Object>> n = jt.queryForList(sql);
	 for(Map map :n) {
		EmployeBean e=new EmployeBean();
		e.setId((int) map.get("id"));
		e.setAge((int) map.get("age"));
		e.setDept((String) map.get("dept"));
		e.setDesig((String) map.get("desig"));
		e.setName((String) map.get("name"));
		e.setSalary((double) map.get("salary"));
		eb.add(e);		
	 }
	return eb;
}

@Override
public int insert(EmployeBean eb) {
	String sql="insert into employe(id,name,desig,dept,salary,age)values(?,?,?,?,?,?)";
    int n = jt.update(sql, new Object[] {eb.getId(),eb.getName(),eb.getDesig(),eb.getDept(),eb.getSalary(),eb.getAge()});
	
	return n;
}

@Override
public List<Map<String, Object>> login(EmployeBean eb) {
	List<Map<String, Object>> queryForList = jt.queryForList("select *from employee where id="+eb.getId()+" and name='"+eb.getName()+"'");
	
	System.out.println(queryForList);
	return queryForList;
	
}



}
