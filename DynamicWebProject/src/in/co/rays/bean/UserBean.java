package in.co.rays.bean;

import java.util.Date;

public class UserBean {
	
	private int id;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private Date dob;
	private String address;
	
	public void setId(int id) {
		this .id=id;
		}
	
	public int getId() {
		return id;
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getFirstName() {
		return firstName;
		
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLoginId(String loginId) {
		this.loginId=loginId;
		
		
	}
	
	public String getLoginId() {
		return loginId;
		
	}
	
	public void setPassword(String password){
		this.password=password;
		
		
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public void setDob(Date dob) {
		this.dob=dob;
	}
	
	public Date getDob() {
		return dob;
		
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return address;
		
	}
	
}
