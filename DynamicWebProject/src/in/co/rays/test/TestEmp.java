package in.co.rays.test;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean. EmpBean;

import in.co.rays.model.EmpModel;


public class TestEmp {

	public static void main(String[] args) throws Exception {
		//testNextPk();
	      //testAdd();
	     // testUpdate();
	     // testDelete();
	    // testFindByPk();
	     testSearch();
		
	}


private static void testSearch() throws Exception {
	EmpBean bean=new EmpBean();
	bean.setEName("p");
	EmpModel model=new EmpModel();
	List list=model.search(bean,1,3);
	Iterator it= list.iterator();
	
	while(it.hasNext()) {
		bean=(EmpBean) it.next();
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getEName());
		System.out.print("\t"+bean.getDob());
		System.out.print("\t"+bean.getProject());
		System.out.print("\t"+bean.getStatus());
		System.out.println("\t"+bean.getSalary());
		
	}
		
	}


private static void testFindByPk() throws Exception {
   
	
	EmpModel model=new EmpModel();
			
			EmpBean bean=model.findByPk(2);
			System.out.println(bean.getId());
			System.out.println(bean.getEName());
			System.out.println(bean.getDob());
			System.out.println(bean.getProject());
			System.out.println(bean.getStatus());
			System.out.println(bean.getSalary());
			
		
		
	}


		private static void testDelete() throws Exception {
    EmpBean bean =new EmpBean();
       bean.setId(6);
       EmpModel model = new EmpModel();
			
			model.delete(bean.getId());
		
		
	}


		private static void testUpdate() throws Exception {
			EmpBean bean=new EmpBean();
			
			bean.setId(1);
			bean.setEName("pritee");
			bean.setDob(new Date());

			bean.setProject("04");
			
			bean.setStatus("running");
			bean.setSalary(10000);
			
			EmpModel model=new EmpModel();
			
			model.update(bean);
			
			

		}


		public static void testNextPk() throws Exception {
			EmpModel model = new EmpModel();

			Integer pk = model.nextPk();

			System.out.println("pk =" + pk);

		
		
		}
		
private static void testAdd() throws Exception {
	
			
			EmpBean bean=new EmpBean();
		
		
		bean.setEName("pooja");
		bean.setDob(new Date());
		bean.setProject("04");
		
		bean.setStatus("running");
		bean.setSalary(10000);
		
		EmpModel model=new EmpModel();
		
		model.add(bean);
		
		
		}




		
}
