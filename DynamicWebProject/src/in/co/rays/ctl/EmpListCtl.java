package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.EmpBean;
import in.co.rays.model.EmpModel;


@WebServlet("/EmpListCtl")
public class EmpListCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = 5;

		EmpModel model = new EmpModel();

		try {
			List list = model.search(null, pageNo, pageSize);
			List nextList = model.search(null, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("EmpListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EmpBean bean = null;
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));
		int pageSize = 5;

		EmpModel model = new EmpModel();

		String ename = req.getParameter("EName");
		String op = req.getParameter("operation");
		
		
		

		if (op.equals("search")) {
			pageNo = 1;
			bean = new EmpBean();
			bean.setEName(ename);
		
			}
			
			
			
		

		if (op.equals("add")) {
			resp.sendRedirect("EmpCtl");
		}

		if (op.equals("next")) {
			pageNo++;
		}

		if (op.equals("previous")) {
			pageNo--;
		}

		if (op.equals("delete")) {
			pageNo = 1;
			String[] ids = req.getParameterValues("ids");
			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("EmpListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}


		
		
	
	}

}
