package model;

public class Admin  extends Users{
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String Username, String Password) {
		super(Username, Password);
		// TODO Auto-generated constructor stub
	}

	public boolean checkDetails() {
		// TODO Auto-generated method stub
		String Username=this.getUsername();
		String Password=this.getPassword();
		boolean result=false;
		if(Username.equals("admin")==true && Password.equals("admin")) {
			System.out.println("Login Passed");
			result=true;
		}else {
			System.out.println("Login Failed");
			result=false;
		}
		return result;		
	}
	
	

}
