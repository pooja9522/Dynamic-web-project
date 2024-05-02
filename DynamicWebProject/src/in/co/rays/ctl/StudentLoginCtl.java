package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;
import in.co.rays.bean.StudentBean;

@WebServlet("/StudentLoginCtl")
public class StudentLoginCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("operation");
		
		if (op!=null) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		
		
		resp.sendRedirect("StudentLoginView.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String login = req.getParameter("loginId");
	   String pass =  req.getParameter("password");
	   String uri = req.getParameter("uri");
	   
	  if(login.equals("")||pass.equals("")) {
		  
		  if(login.equals("")) {
			  req.setAttribute("login", "loginId is required");
		  }
		  
		  if (pass.equals("")) {
			  req.setAttribute("pass", "password is required");
		  }
		  
		  RequestDispatcher rd = req.getRequestDispatcher("StudentLoginView.jsp");
		   rd.forward(req,resp);
	   
	  }
	  
	  else {
		  
		   StudentModel model = new StudentModel();
		   
		   try {
			StudentBean bean = model.authenticate(login, pass);
			if(bean!= null) {
				HttpSession session = req.getSession();
				session.setAttribute("Student",bean);
				
				if(uri.equalsIgnoreCase("null")) {
					resp.sendRedirect("StudentWelcome.jsp");
				}
				else {
					resp.sendRedirect(uri);
				}
				
			
			}
			
			else {
				req.setAttribute("msg", "loginId & password is invalid");
				RequestDispatcher rd = req.getRequestDispatcher("StudentLoginView.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  }
		}

	}
