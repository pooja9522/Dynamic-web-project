package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import in.co.rays.bean.StudentBean;
import in.co.rays.bean.UserBean;

public class StudentModel  {
	
	



  
	  
	  public Integer nextPk() throws Exception {
		  
		  int pk =0;
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
			
		 PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		 
		 ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 
			 pk=rs.getInt(1);
		 }
		  
		  
		  return pk+1;
		  
		  
		  
	  }
	  public  void add(StudentBean bean) throws Exception {
			int pk =nextPk(); 
	  
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	 PreparedStatement ps = conn.prepareStatement ("insert into Student values(?,?,?,?,?,?,?)");
	 		ps.setInt(1, pk);
	 		ps.setString(2, bean.getFirstName());
	 		ps.setString(3, bean.getLastName());
	 		ps.setString(4, bean.getLoginId());
	 		ps.setString(5, bean.getPassword());
	 		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
	 		ps.setString(7, bean.getAddress());
	 		
	 	int i =	  ps.executeUpdate();
	 	
	 	System.out.println("data inserted="+  i);
	 	
			 
  }
  
  public void delete(int id ) throws Exception {
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
		PreparedStatement ps = conn.prepareStatement("delete  from student where id=?");
		
		ps.setInt(1,id);
		
		int i =ps.executeUpdate();
		
		
		System.out.println("data deleted successfuly"+ i);
	  
	  
  }
  
  public void update(StudentBean bean) throws Exception {
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	
	  PreparedStatement ps = conn.prepareStatement("update Student set First_Name = ?, set Last_Name=?, set LoginId =?, set Password =?,set Dob=?,set Password =? where id=?");
	  
	  ps.setString(1, bean.getFirstName());
	  ps.setString(2, bean.getLastName());
	  ps.setString(3, bean.getLoginId());
	  ps.setString(4, bean.getPassword());
	  ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
	  ps.setString(6, bean.getAddress());
	  ps.setInt(7, bean.getId());
	  
	  
	   }
  
  
  public StudentBean findByPk(int id) throws Exception {
	  
	  int pk =nextPk();
	  
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn = DriverManager .getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	  PreparedStatement ps = conn.prepareStatement("select*from student where id=?");
	  
	  ps.setInt(1, id);
	  
	  ResultSet rs =ps.executeQuery();
	  
	  StudentBean bean = null;
	  
	  while(rs.next()) {
		  
		  bean = new StudentBean();
		  bean.setId(rs.getInt(1));
		  bean.setFirstName(rs.getString(2));
		  bean.setLastName(rs.getString(3));
		  bean.setLoginId(rs.getString(4));
		  bean.setPassword(rs.getString(5));
		  bean.setDob(rs.getDate(6));
		  bean.setPassword(rs.getString(7));
		  
	  }
	  
	  return bean ;
  }
  
  public StudentBean authenticate(String loginId,String password) throws Exception{
	   int pk = nextPk();
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn = DriverManager .getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
		 
		  PreparedStatement ps = conn.prepareStatement("select*from Student where loginId=? and password =?");
		  
		  ps.setString(1 ,loginId);
		  ps.setString(2, password);
		  
		  ResultSet rs = ps.executeQuery();
		  
		  StudentBean bean = null;
		  
		  while (rs.next()) {
			  
			  bean = new StudentBean();
			  bean = new StudentBean();
			  bean.setId(rs.getInt(1));
			  bean.setFirstName(rs.getString(2));
			  bean.setLastName(rs.getString(3));
			  bean.setLoginId(rs.getString(4));
			  bean.setPassword(rs.getString(5));
			  bean.setDob(rs.getDate(6));
			  bean.setPassword(rs.getString(7));
			  

		  }
		  
		  return bean;
		  
		  
		  
	   
	   
	   
  }
  
  
  public List search() throws Exception {
	 
	  int pk = nextPk();
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn = DriverManager .getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	  PreparedStatement ps = conn.prepareStatement("select*from student");
	  
	  ResultSet rs = ps.executeQuery();
	  
	  List list = new ArrayList();
	  
	  while (rs.next()) {
		  
		 StudentBean bean = new StudentBean(); 
		  bean.setId(rs.getInt(1));
		  bean.setId(rs.getInt(1));
		  bean.setFirstName(rs.getString(2));
		  bean.setLastName(rs.getString(3));
		  bean.setLoginId(rs.getString(4));
		  bean.setPassword(rs.getString(5));
		  bean.setDob(rs.getDate(6));
		  bean.setPassword(rs.getString(7));
		  list.add(bean);
		 
		  
		    }
	  
	  return list;
	  
	  
	  
	 }
  
  
  public List search (StudentBean bean , int pageNo, int pageSize) throws Exception {
	  
	  int pk = nextPk();
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn = DriverManager .getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	  StringBuffer sql = new StringBuffer("select*from student where 1=1");
	  
	  if (bean != null) {
		  
		  if (bean.getFirstName() != null && bean.getFirstName().length()>0) {
			  sql.append(" and first_name like '"+bean.getFirstName()+"%'");
		  }
		  
			if (bean.getDob()!= null && bean.getDob().getTime()>0)  {
				sql.append("and dob like'"+new java.sql.Date(bean.getDob().getTime())+"%'");
			
		  }
		  
	  }  
		  if(pageSize>0) {
			  
			  pageNo = (pageNo-1)*pageSize;
			  
			  sql.append(" limit " +pageNo +"," + pageSize);
		  }
		  System.out.println("sql =>"+sql);
		  
		  PreparedStatement ps = conn.prepareStatement(sql.toString());
		  
		  ResultSet rs =ps.executeQuery();
		  
		  List list = new ArrayList();
		  
		  while(rs.next()) {
			  
			  bean = new StudentBean();
			  bean.setId(rs.getInt(1));
			  bean.setFirstName(rs.getString(2));
			  bean.setLastName(rs.getString(3));
			  bean.setLoginId(rs.getString(4));
			  bean.setPassword(rs.getString(5));
			  bean.setDob(rs.getDate(6));
			  bean.setAddress(rs.getString(7));
			  
			  list.add(bean);
		  }
		  
		 	  
	  
	  
	
	  return list;

  
  
  
  
  
  }
  
  
  
	  }
  
  
  
 