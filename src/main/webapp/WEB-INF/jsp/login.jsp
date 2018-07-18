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
color: red;
}



</style>
</head>
<body>
<form:form action="loginEmployee" method="POST" commandName="eb">
<table>
<tr>
<td>
Enter Email
</td>
<td>
<form:input path="email" ></form:input>
<form:errors path ="email" cssClass="error"/>
</td>
</tr>
<tr>
<td>Enter Password</td>
<td>
<form:password path="password" ></form:password>
<form:errors path ="password" cssClass="error"/>
</td>
</tr>
<tr>
<td>
<input type="submit" value="Login">
</td>
</tr>
</table>
</form:form>
New  User? <a href="newEmploye">Sign Up Here</a>
</body>
</html>