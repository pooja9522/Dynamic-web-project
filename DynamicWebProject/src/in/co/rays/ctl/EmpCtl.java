package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.EmpBean;
import in.co.rays.model.EmpModel;



@WebServlet("/EmpCtl")
public class EmpCtl  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		EmpModel model = new EmpModel();

		if (id != null) {

			try {
				EmpBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = req.getRequestDispatcher("EmpView.jsp");
		rd.forward(req, resp);

		
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String ename = req.getParameter("eName");
		String dob = req.getParameter("dob");
		String project = req.getParameter("project");
		String status = req.getParameter("status");
		
		int salary =Integer.parseInt(req.getParameter("salary"));
		String id = req.getParameter("id");
		String op = req.getParameter("operation");

		EmpModel model = new EmpModel();

		EmpBean bean = new EmpBean();
		bean.setEName(ename);
	
		
	
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setProject(project);
		bean.setStatus(status);
		bean.setSalary(salary);
		

		if (op.equals("save")) {

			try {
				model.add(bean);
				req.setAttribute("msg", "Data Added Successfully...!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (op.equals("update")) {

			bean.setId(Integer.parseInt(id));

			try {
				model.update(bean);
				EmpBean existBean = model.findByPk(bean.getId());
				req.setAttribute("bean", existBean);
				req.setAttribute("msg", "Data Updated Successfully...!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("EmpView.jsp");
		rd.forward(req, resp);

		
		
	}

}
