<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style >
.error{
color:red;

}


</style>
</head>
<body>
<form:form action="check" method="POST" commandName="eb">

<table>
<tr>
<td>Employe ID:</td>
<td><form:input path="id"/></td>
<td><form:errors path="id" cssClass="error"/>
</tr>
<tr>
<td>Employe Name:</td>
<td><form:input path="name"/></td>
<td><form:errors path="name" cssClass="error"/>
<tr>
<td>Designation :</td>
<td><form:input path="desig"/></td>
<td><form:errors path="desig" cssClass="error"/>
</tr>


<tr>
<td>Department :</td>
<td><form:input path="dept"/></td>
<td><form:errors path="dept" cssClass="error"/>
</tr>
<tr>
<td>Salary :</td>
<td><form:input path="salary"/></td>
<td><form:errors path="salary" cssClass="error"/>
</tr>
<tr>
<td>Age :</td>
<td><form:input path="age"/></td>
<td><form:errors path="age" cssClass="error"/>
</tr>

<tr>
<td>Email ID :</td>
<td><form:input path="email"/></td>
<td><form:errors path="email" cssClass="error"/>
</tr>

<tr>
<td>Password :</td>
<td><form:password path="password"/></td>
<td><form:errors path="password" cssClass="error"/>
</tr>

<tr>
<td>Confirm Password :</td>
<td><form:password path="confirmPass"/></td>
<td><form:errors path="confirmPass" cssClass="error"/>
</tr>

<tr>
<td></td><td><input type="submit" value="Register"></td><td></td>
</tr>
</table>
</form:form>
</body>
</html>