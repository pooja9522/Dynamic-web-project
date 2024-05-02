package in.co.rays.model;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import in.co.rays.bean.EmpBean;

public class EmpModel {

	public Integer nextPk() throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from emp");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public void add(EmpBean bean) throws Exception {
		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");

		PreparedStatement ps = conn.prepareStatement("insert into emp values (?,?,?,?,?,?)");

		ps.setInt(1, pk);
		ps.setString(2, bean.getEName());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getProject());
		ps.setString(5, bean.getStatus());
		ps.setInt(6, bean.getSalary());
		int i=ps.executeUpdate();
		System.out.println("Data inserted = "+i);
			
			
		

	}
public void update(EmpBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
		PreparedStatement ps=conn.prepareStatement(" update emp set ename=?,dob=?,  project=? ,status=?,salary=? where id=? ");
		
		ps.setString(1, bean.getEName());
		ps.setDate(2, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(3, bean.getProject());
		ps.setString(4, bean.getStatus());
		
		ps.setInt(5, bean.getSalary());
		ps.setInt(6, bean.getId());
		
		
		int i=ps.executeUpdate();
		System.out.println("Data updated="+ i);
		
		
		}
	


public void delete(int id) throws Exception {
	
	int pk=nextPk();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	PreparedStatement ps=conn.prepareStatement("delete from emp where id=?");
	ps.setInt(1, id);
	
	int i=ps.executeUpdate();
	System.out.println("Data Deleted="+i);
	
	}

public EmpBean findByPk(int id) throws Exception{
	int pk=nextPk();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	PreparedStatement ps=conn.prepareStatement("select*from emp where id=?");
	
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	EmpBean bean=null;
	while(rs.next()) {
		bean=new EmpBean();
		bean.setId(rs.getInt(1));
		bean.setEName(rs.getString(2));
		bean.setDob(rs.getDate(3));
		bean.setProject(rs.getString(4));
		bean.setStatus(rs.getString(5));
	    bean.setSalary(rs.getInt(6));
		
	}
	return bean;
	
}
public List search(EmpBean bean,int pageNo,int pageSize) throws Exception{ 


	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_practical","root","root");
	StringBuffer sql=new StringBuffer("select *from emp where 1=1");//sql injection
	
	if(bean != null) {
		
		if(bean.getEName() != null && bean.getEName().length()>0) {
			sql.append(" and ename like '" + bean.getEName() + "%'");
		}
		
	}
	
	if(pageSize>0) {
		pageNo=(pageNo-1)*pageSize;
		sql.append(" limit " +pageNo+","+ pageSize);
	}
	 System.out.println("sql=>"+sql);
	PreparedStatement ps=conn.prepareStatement(sql.toString());
	
	ResultSet rs=ps.executeQuery();
	List list=new ArrayList();
	
	while(rs.next()) {
		bean =new EmpBean();
		bean.setId(rs.getInt(1));
		bean.setEName(rs.getString(2));
		bean.setDob(rs.getDate(3));
		bean.setProject(rs.getString(4));
		bean.setStatus(rs.getString(5));
		
		bean.setSalary(rs.getInt(6));
		list.add(bean);

	}
	return list;
}

}




