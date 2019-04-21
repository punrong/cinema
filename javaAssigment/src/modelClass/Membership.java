package modelClass;

public class Membership {
	
	private String id;
	private String fName;
	private String lName;
	private String gender;
	private String dob;
	private String registerDate;
	private String cardLevel;
	private double discount;
	private String mobile;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getCardLevel() {
		return cardLevel;
	}
	public void setCardLevel(String cardLevel) {
		this.cardLevel = cardLevel;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Membership(String id, String fName, String lName, String gender, String dob, String registerDate,
			String cardLevel, double discount, String mobile) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.dob = dob;
		this.registerDate = registerDate;
		this.cardLevel = cardLevel;
		this.discount = discount;
		this.mobile = mobile;
	}

}
