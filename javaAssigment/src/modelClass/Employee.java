package modelClass;

public class Employee extends Person {
	
	private String fName;
	private String lName;
	private String gender;
	private String dob;
	private double salary;
	private String street;
	private String district;
	private String commune;
	private String city;
	private String country;
	private String phoneNum;
	private String email;
	public Employee(String id, String fName, String lName, String gender, String dob, double salary, String street,
			String district, String commune, String city, String country, String phoneNum,
			String email, String username, String password) {
		super(id, username, password);
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.dob = dob;
		this.salary = salary;
		this.street = street;
		this.district = district;
		this.commune = commune;
		this.city = city;
		this.country = country;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public Employee() {super();}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
