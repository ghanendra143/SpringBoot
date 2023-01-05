<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.emp.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sign up success</title>
</head>
<h1>Employee Added successfully : </h1>
Employee Id : ${employee.emp_id} <br><br>
Name : ${employee.emp_name} <br><br>
Address : ${employee.address} <br><br>
Salary : ${employee.salary}
<body>
</body>
</html>