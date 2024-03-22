package in.co.rays.servalet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet1")
public class FirstServlet1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FirstServlet1 doGet");
		System.out.println("FirstName="+req.getParameter("firstName"));
		
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		req.setAttribute("lastName", "xyz");
		  rd.forward(req, resp);
	//	resp.sendRedirect("SecondServlet");
		
	}
		
		
		
		 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FirstServlet1 doPost");
	System.out.println("firstName="+req.getParameter("firstName"));
	req.setAttribute("lastName", "jawariya");
	
	RequestDispatcher rd=req.getRequestDispatcher("SecondServlet");
	
	//resp.sendRedirect("SecondServlet");
		
		
	}	
	
	
	
	
		

	}
	
	
