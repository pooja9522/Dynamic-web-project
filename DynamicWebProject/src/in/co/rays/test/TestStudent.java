package in.co.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;



import in.co.rays.bean.StudentBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.StudentModel;
import in.co.rays.model.UserModel;

public class TestStudent {
	
	public static void main(String[] args) throws Exception {
		//testNextPk();
		
		testAdd();
      //testUpdate();
		//testDelete();
		//testFindByPk();
		//testAutenticate();
		//testSearchSimple();
		//testSearch();
		
	}
	

	private static void testSearch() throws Exception {
		
		StudentBean bean=new StudentBean();
		bean.setFirstName("s");
		StudentModel model=new StudentModel();
		List list=model.search(bean,1,3);
		Iterator it= list.iterator();
		
		while(it.hasNext()) {
			bean=(StudentBean) it.next();
		System.out.println(bean.getId());
		System.out.println("\t"+bean.getFirstName());
		System.out.println("\t"+ bean.getLastName());
		System.out.println("\t"+bean.getLoginId());
		System.out.println("\t"+bean.getPassword());
		System.out.println("\t"+bean.getDob());
		System.out.println("\t"+bean.getAddress());
		}
		
				
}






	private static void testSearchSimple() throws Exception {
		StudentModel model = new StudentModel();
		List list = model.searchSimple();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			StudentBean bean = (StudentBean) it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		
			
			
		}
		
		
	}

	private static void testAutenticate() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean =model.authenticate("vishnu@gmail.com","1234");
		
		if(bean != null) {
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
	
		}else {
			   System.out.println("invalid login & password");
		}
		
	}

	private static void testFindByPk() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean =model.findByPk(1);
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
		
	}

	private static void testDelete() throws Exception {
  StudentModel model = new StudentModel();
  
  model.delete(4);
		
	}

	private static void testUpdate() throws Exception {
StudentBean bean = new StudentBean();
		bean.setId(2);
		bean.setFirstName("shushila");
		bean.setLastName("Davi");
		bean.setLoginId("shushila@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("AwantipurBarodiya");
		StudentModel model = new StudentModel();
		model.update(bean);
		
		
		
	}

	private static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();
		
		bean.setFirstName("vishnu");
		bean.setLastName("prasad ji");
		bean.setLoginId("vishnu@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("AwantipurBarodiya");
		StudentModel model = new StudentModel();
		model.add(bean);
		
	}

	private static void testNextPk() throws Exception {
		StudentModel model =new StudentModel();
		Integer pk = model.nextPk();
		System.out.println("pk="+pk);
		
	}
	
	
}


