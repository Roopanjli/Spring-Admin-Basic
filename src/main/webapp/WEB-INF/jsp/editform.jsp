<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/SpringMVC_CURD_Jdbc/update" method="POST" commandName="eb">

<table>
<%-- <tr>
<td>Employe ID:</td>
<td><form:hidden path="id"/></td>

</tr> --%>
 <tr>
<td>Employe ID:</td>
<td><form:input path="id"/></td>

</tr> 
<tr>
<td>Employe Name:</td>
<td><form:input path="name"/></td>

<tr>
<td>Designation :</td>
<td><form:input path="desig"/></td>

</tr>


<tr>
<td>Department :</td>
<td><form:input path="dept"/></td>

</tr>
<tr>
<td>Salary :</td>
<td><form:input path="salary"/></td>

</tr>
<tr>
<td>Age :</td>
<td><form:input path="age"/></td>

</tr>
<tr>
<td>Password :</td>
<td><form:input path="password"/></td>

</tr>
<tr>
<td>Email :</td>
<td><form:input path="email"/></td>

</tr>

<tr>
<td></td><td><input type="submit" value="Register"></td><td></td>
</tr>
</table>
</form:form>
</body>
</html>