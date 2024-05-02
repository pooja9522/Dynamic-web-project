<%@ page import="in.co.rays.bean.StudentBean"%>
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
   StudentBean Student = (StudentBean) session.getAttribute("Student");

%>

     <% 
 
     if(Student != null){
    	
     %>
    
    <h3>
    
      Hi,
      
      <%=Student.getFirstName() %>   </h3>
    
   <a href="StudentCtl">add Student</a>
 <a href="StudentListCtl">Student List</a>
 <a href ="StudentLoginCtl? operation=logout">LogOut</a>
 
 <%
    }else{
 %>
 
  <h3>Hi,Guest</h3>
  
  <%
    }
  %>
<hr>

</body>
</html>