package in.co.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.StudentBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.StudentModel;
import in.co.rays.model.UserModel;

public class TestStudent {
	
	
	public static void main (String[]args) throws Exception {
		
		testAdd();
		testFindByPk();
		testSearch();
		testUpdate();
		testDelete();
		testAuthenticate();
		testNextPk();
		
		
	}

	private static void testNextPk() throws Exception {
		StudentModel model = new StudentModel();
		Integer pk = model.nextPk();
		System.out.println("pk="+ pk);
		
	}

	private static void testAuthenticate() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean bean = model.authenticate("laxman@gmail.com", "1234");
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		} else {
			System.out.println("invalid login & password");
		}
		
	}

	private static void testSearch() throws Exception {
		
		StudentBean bean = new StudentBean();
		bean.setFirstName("a");
		
		StudentModel model = new StudentModel();
		
		List list = model.search(bean, 1 ,5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			
			bean = (StudentBean)it.next();
			
			System.out.println("\t"+bean.getFirstName());
			System.out.println("\t"+bean.getLastName());
			System.out.println("\t"+bean.getLoginId());
			System.out.println("\t"+bean.getPassword());
			System.out.println("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		
		
		
	}

	private static void testFindByPk() throws Exception {
		StudentModel model = new  StudentModel();
		
		StudentBean bean = model.findByPk(2);
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
		
	}

	private static void testAdd() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		bean.setId(3);
		bean.setFirstName("laxman");
		bean.setLastName("padiyaar");
		bean.setLoginId("laxman@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("indore ");
		
		StudentModel model =new StudentModel();
		
		model.add(bean);
		
	
		
		
		
		
	}
	
	private static void testDelete() throws Exception {
		
		StudentModel model = new StudentModel();
		
		model.delete(1);
		
		
		}
	
	
	private static void testUpdate() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		bean.setId(3);
		bean.setFirstName("priya");
		bean.setLastName("gupta");
		bean.setLoginId("priya@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("Ujjain");
		
		StudentModel model= new StudentModel();
		
		model.update(bean);
		
		
		}
	
	
	
	
	
	
	
	

}
