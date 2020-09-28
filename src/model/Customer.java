package model;

public class Customer extends Users{
	
	public Customer() {
		super();
	}
	
	public Customer(String Username, String Password) {
		super(Username, Password);
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean checkDetails() {
		// TODO Auto-generated method stub
		String Username=this.getUsername();
		String Password=this.getPassword();
		boolean result=false;
		if(Username.equals("Customer")==true && Password.equals("Customer")) {
			System.out.println("Login Passed");
			result=true;
		}else {
			System.out.println("Login Failed");
			result=false;
		}
		return result;		
	}
}
