<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!-- <form action="Welcome.jsp" method = "post"> --> 
 <form action="UserRegistrationCtl" method="post">


<table>
     <tr>
        <th>First Name :</th>
           <td><input type="text" name="firstName"></td>
         
         
       </tr> 
       
       <tr>
       <th> last Name:</th>
       <td> <input type="text"   name="lastName"></td>
       
       </tr>
       <tr>
          <th> Login id:</th>
          
          <td> <input type="text"  name="loginId"> </td> 
          
          </tr>
         <tr>
           <th>  password:</th>
           
           <td>  <input type ="text"  name="password"></td>
                           
          </tr>
          
        <tr>  
         <th>    Dob :</th>
         
         <td>  <input type="Date"    name="dob"></td>
         
         </tr>
          
         <tr>  
         <th>    Address :</th>
         
         <td>  <input type="text"    name="address"></td>
         
         </tr>
         
           <tr>  
         <th>  </th>
         
         <td>  <input type="Submit" ></td>
         
         </tr>
         
      </table> 
      </form>


</body>
</html>