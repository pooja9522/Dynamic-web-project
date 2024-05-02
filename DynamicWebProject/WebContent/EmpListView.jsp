<%@page import="in.co.rays.bean.EmpBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<%
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;

		List nextList = (List) request.getAttribute("nextList");

		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
	<%@include file="EmpHeader.jsp"%>
	<form action="EmpListCtl" method="post">

		<table>
			<tr>
				<td><input type="text" name="EName"></td>
				
				<td><input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		<table border="1%" style="width: 100%">
			<tr>
				<th>Select</th>
				<th>S.NO.</th>
				<th>EName</th>
				<th>Dob</th>
				<th>project</th>
				<th>status</th>
				<th>salary</th>
			    <th>Edit</th>
			</tr>
			<%
				while (it.hasNext()) {

					EmpBean bean = (EmpBean) it.next();
			%>
			<tr>
				<td align="center"><input type="checkbox" name="ids"
					value="<%=bean.getId()%>"></td>
				<td align="center"><%=index++%></td>
				<td align="center"><%=bean.getEName()%></td>
				<td align="center"><%=bean.getDob()%></td>
				<td align="center"><%=bean.getProject()%></td>
				<td align="center"><%=bean.getStatus()%></td>
				<td align="center"><%=bean.getSalary()%></td>
				
				<td align="center"><a href="EmpCtl?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table style="width: 100%">
			<tr>
				<td style="width: 25%"><input type="submit" name="operation"
					value="previous" <%=(pageNo != 1) ? "" : "disabled"%>></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="add"></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="delete"></td>
				<td style="text-align: right;"><input type="submit" name="operation"
					value="next" <%=(nextList.size() != 0) ? "" : "disabled"%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>


	


</body>

</body>
</html>