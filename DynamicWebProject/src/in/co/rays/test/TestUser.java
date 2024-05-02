package in.co.rays.test;



import java.util.Date;



import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
	
		
		//testAdd();
		//testUpdate();
		//testDelete();
	   // testFindByPk();
		testSearch();
//	testAuthenticate();
		//testSearch();
		//testNextPk();
		
		
		
		
		
	}
	
	
		
		
		
	public static void testNextPk() throws Exception {
		UserModel model = new UserModel();

		Integer pk = model.nextPk();

		System.out.println("pk =" + pk);
	}
	
	
		
		
	




		private static void testAuthenticate() throws Exception {
		UserModel model=new  UserModel();
		UserBean bean = model.authenticate("laxman@gmail.com", "1234");
		
		if( bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
			
		} else {
			System.out.println("invalid login &password");
		}
		
	}




		private static void testSearch() throws Exception {
			
			UserBean bean=new UserBean();
			bean.setFirstName("p");
			UserModel model=new UserModel();
			List list=model.search(bean,1,3);
			Iterator it= list.iterator();
			
			while(it.hasNext()) {
				bean=(UserBean) it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+ bean.getLastName());
			System.out.print("\t"+bean.getLoginId());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t" +bean.getDob());
			System.out.println("\t"+bean.getAddress());
			}
			
					
	}




		private static void testFindByPk() throws Exception {
			
			UserModel model=new UserModel();
			
			UserBean bean=model.findByPk(2);
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		
		
	}




		private static void testDelete() throws Exception {
			
			UserModel model=new UserModel();
			
			model.delete(3);
		
		
	}




		private static void testUpdate() throws Exception {
			UserBean bean =new UserBean();
			
			bean.setId(1);
			bean.setFirstName("laxman");
			bean.setLastName("patel");
			bean.setLoginId("laxman@gmail.com");
			bean.setPassword("1234");
			bean.setDob(new Date());
			bean.setAddress("sehore");
			
			UserModel model=new UserModel();
		
            model.update(bean);
			
	}




		private static void testAdd() throws Exception {
			
			UserBean bean=new UserBean();
		
		bean.setFirstName("laxman");
		bean.setLastName("patel");
		bean.setLoginId("laxman@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("indore");
		
		UserModel model=new UserModel();
		
		model.add(bean);
		
		
		}
		

		
		

}
