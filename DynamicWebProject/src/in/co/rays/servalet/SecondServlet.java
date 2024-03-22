package in.co.rays.servalet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet doget");
		String str=(String) req.getAttribute("lastName");
		System.out.println(str);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Second Servlet dopost");
		
		String str=(String) req.getAttribute("lastName");
		System.out.println("lastName="+str);
		

		//System.out.println("SecondServlet firstName = " + req.getParameter("firstName"));

		//System.out.println("SecondServlet lastName = " + req.getAttribute("lastName"));

	}
	
	
	
	
	
	

}
