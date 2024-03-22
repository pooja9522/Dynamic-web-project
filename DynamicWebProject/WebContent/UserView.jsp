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
		UserBean bean = (UserBean) request.getAttribute("bean");
		String msg = (String) request.getAttribute("msg");
	%>

	<%@include file="Header.jsp"%>
	<form action="UserCtl.do" method="post">
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
				<th>First Name :</th>
				<td><input type="text" name="firstName"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="lastName"
					value="<%=(bean != null) ? bean.getLastName() : ""%>"></td>
			</tr>
			<tr>
				<th>Login ID :</th>
				<td><input type="text" name="loginId"
					value="<%=(bean != null) ? bean.getLoginId() : ""%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"
					value="<%=(bean != null) ? bean.getPassword() : ""%>"></td>
			</tr>
			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"
					value="<%=(bean != null) ? bean.getDob() : ""%>"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=(bean != null) ? bean.getAddress() : ""%>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
			</tr>
		</table>
	

</form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@include file="Footer.jsp" %>
</body>
</html>