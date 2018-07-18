<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Index</th><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Department</th><th>Age</th><th>Email ID</th><th>Password</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}" varStatus="status">    
   <tr>
   <td>${status.index + 1}</td>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.desig}</td>
   <td>${emp.dept}</td>
   <td>${emp.age}</td> 
   <td>${emp.email}</td>
   <td>${emp.password}</td>
   <td><a href="viewEmploye/${emp.id}">Edit</a></td>  
   <td><a href="deleteEmploye/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="newEmploye">Add New Employee</a> 
   <a href=""> </a> 
</body>
</html>