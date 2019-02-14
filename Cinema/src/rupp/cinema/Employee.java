package rupp.cinema;

public class Employee {

	private String id;
	private String username;
	private String dateOfBirth;
	private double salary;
	private String phoneNumber;
	private String password;
	
	public String getID(){
		return this.id;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getDateOfBirth(){
		return this.dateOfBirth;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public Employee() {
		
	}
	
}
