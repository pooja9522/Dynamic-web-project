package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.StudentBean;


@WebServlet("/StudentLoginCtl")
public class StudentLoginCtl extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("StudentLoginView.jsp");
		
		
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login =req.getParameter("loginId");
		String pass  =	req.getParameter("password");
		StudentBean bean = new StudentBean();
		if(bean != null) {
			
			
			resp.sendRedirect("StudentWelcome.jsp");
	
	}
		
		
		
		  else {
			  resp.sendRedirect("StudentLoginView.jsp"); }
		  
		 }
	

}
