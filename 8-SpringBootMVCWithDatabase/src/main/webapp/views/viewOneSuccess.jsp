<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@page import="java.util.List"%> --%>
<%@ page import="com.emp.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view one success</title>
</head>
<h1>Employee details fetched successfully : </h1>
<body>
<%-- Employee Details : ${emp}  --%>

<table border="2" width="50%" cellpadding="2">
<tr><th>Id</th><th>Employee Name</th><th>Address</th><th>Salary</th></tr>
<%Employee em = (Employee)request.getAttribute("emp");
	int id = em.getEmp_id();
	String name = em.getEmp_name();
	String add = em.getAddress();
	int sal = em.getSalary();
%>
<tr>
<td><% out.print(id);%></td>
<td><% out.print(name);%></td>
<td><% out.print(add);%></td>
<td><% out.print(sal);%></td>
</tr>
</table>

</body>
</html>