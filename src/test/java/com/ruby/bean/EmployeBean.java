package com.ruby.bean;



public class EmployeBean  {

	
private int id;
private String name;
private String dept;
private String desig;
private int age;
private double salary;
public EmployeBean() {
}
public EmployeBean(int id, String name, String dept, String desig, int age, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.dept = dept;
	this.desig = desig;
	this.age = age;
	this.salary = salary;
}
public int getAge() {
	return age;
}
public String getDept() {
	return dept;
}
public String getDesig() {
	return desig;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public double getSalary() {
	return salary;
}
public void setAge(int age) {
	this.age = age;
}
public void setDept(String dept) {
	this.dept = dept;
}
public void setDesig(String desig) {
	this.desig = desig;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
