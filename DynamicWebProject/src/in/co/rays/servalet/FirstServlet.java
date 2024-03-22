package in.co.rays.servalet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(urlPatterns = { "/FirstServlet" })*//* this is another way to call side in browser*/
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<h1>My First Servlet....!!!</h1>");
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("firstName");
		String lname=req.getParameter("lastName");
		String login=req.getParameter("loginId");
	    String pass=req.getParameter("passord");
	    String dob=req.getParameter("dob");
	    String address=req.getParameter("address");
	    
	    resp.setContentType("text/html");
	    
	    PrintWriter out=resp.getWriter();
	   out.println("<h1> My First Servalet....!!!!</h1>");
	   out.println("fname"+fname);
	   out.println("lname"+lname);
	   out.println("login"+login);
	   out.println("pass"+pass);
	   out.println("dob"+dob);
	  out.println("address"+address);
	    
	   out.close();
	    
	    
	    
	}
	
}