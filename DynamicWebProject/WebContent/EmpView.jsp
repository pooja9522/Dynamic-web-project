<%@page import="in.co.rays.bean.EmpBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
EmpBean bean = (EmpBean) request.getAttribute("bean");
String msg = (String) request.getAttribute("msg");
%>
<%@ include file = "EmpHeader.jsp" %>
<form action ="EmpCtl" method ="post">

<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>
		
<table>
			<tr>
				<td><input type="hidden" name="id"
					value="<%=(bean != null) ? bean.getId() : ""%>"></td>
			</tr>
			<tr>
				<th>EName :</th>
				<td><input type="text" name="eName"
					value="<%=(bean != null) ? bean.getEName(): ""%>"></td>
			</tr>
			
				<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"
					value="<%=(bean != null) ? bean.getDob() : ""%>"></td>
			</tr>
			
			<tr>
				<th>Project :</th>
				<td><input type="text" name="project"
					value="<%=(bean != null) ? bean.getProject() : ""%>"></td>
			</tr>
			<tr>
				<th>Status :</th>
				<td><input type="text" name="status"
					value="<%=(bean != null) ? bean.getStatus() : ""%>"></td>
			</tr>
			<tr>
				<th>Salary :</th>
				<td><input type="text" name="salary"
					value="<%=(bean != null) ? bean.getSalary() : ""%>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
			</tr>
		</table>

</form>

</body>
</html>