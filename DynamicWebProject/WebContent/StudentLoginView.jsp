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
 
   String msg =(String)   request.getAttribute("msg");
   String login =(String) request.getAttribute("login");
   String pass = (String) request.getAttribute("pass");
   
   
 %>


<%@include file = "StudentHeader.jsp" %>
<form action="StudentLoginCtl">
<%
  if(msg != null){
	  
 %>
	<%= msg %> 
	<%
	    }
    
    %> 
  


<table>
  <tr>
  <th>loginId</th>
  <td><input type ="text" name="loginId"></td>
  
   <%
     if(login != null){  
   %>
   
    <%= login %>
    
    <%
     }
    %>
  </tr>
  
   <tr>
  <th>password</th>
  <td><input type ="text" name="password"></td>
     
     
     <%
         if(pass!=null){
        	 
      %>
      
      <%= pass %>
      <%} %>
  
  
  
  
  
  
  </tr>
  <tr>
  <th></th>
  <td><input type ="submit"></td>
  </tr>
 
</table>

</form>
</body>
</html>