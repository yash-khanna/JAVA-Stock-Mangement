package model;

public class Users {
	
	private String username;
	private String password;
	
	Users(String Username,String Password){
		super();
		this.username=Username;
		this.password=Password;
	}
	
	Users(){
		this.username="";
		this.password="";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
