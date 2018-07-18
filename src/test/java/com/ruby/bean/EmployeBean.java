package com.ruby.bean;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.time.DurationMin;


public class EmployeBean  {

@NotNull
@DecimalMin(value="1")
private int id;
@NotEmpty
private String name;
@NotEmpty
private String dept;
@NotEmpty
private String desig;
@NotNull
@DecimalMax(value="80")
@DecimalMin(value="19")
private int age;
@NotNull
private double salary;
@NotEmpty
@Size(min =5,max=8)
private String password;
@NotEmpty
@Email
private String email;
@NotEmpty
@Size(min =5,max=8)
private String confirmPass;
public EmployeBean() {
}


public EmployeBean( int id,String name, String dept,  String desig,int age,double salary, String password,String email,
		 String confirmPass) {
	super();
	this.id = id;
	this.name = name;
	this.dept = dept;
	this.desig = desig;
	this.age = age;
	this.salary = salary;
	this.password = password;
	this.email = email;
	this.confirmPass = confirmPass;
}
public int getAge() {
	return age;
}
public String getConfirmPass() {
	return confirmPass;
}
public String getDept() {
	return dept;
}
public String getDesig() {
	return desig;
}
public String getEmail() {
	return email;
	
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getPassword() {
	return password;
}
public double getSalary() {
	return salary;
}
public void setAge(int age) {
	this.age = age;
}
public void setConfirmPass(String confirmPass) {
	this.confirmPass = confirmPass;
}
public void setDept(String dept) {
	this.dept = dept;
}
public void setDesig(String desig) {
	this.desig = desig;
}
public void setEmail(String email) {
	this.email = email;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setPassword(String password) {
	this.password = password;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
