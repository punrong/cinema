package modelClass;

public class Sale {
	
	private String id;
	private String scheduleID;
	private String employeeID;
	private String date;
	private String time;
	private int totalAmount;
	private double totalPrice;
	private double payment;
	private double yourReturn;

	private String membershipID;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getYourReturn() {
		return yourReturn;
	}
	public void setYourReturn(double yourReturn) {
		this.yourReturn = yourReturn;
	}
	
	public String getMembershipID() {
		return membershipID;
	}
	public void setMembershipID(String membershipID) {
		this.membershipID = membershipID;
	}

	public Sale(String id, String scheduleID, String employeeID , String membershipID, String date, String time, int totalAmount,
			double totalPrice, double payment, double yourReturn) {
		super();
		this.id = id;
		this.scheduleID = scheduleID;
		this.employeeID = employeeID;
		this.date = date;
		this.time = time;
		this.totalAmount = totalAmount;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.yourReturn = yourReturn;
		this.membershipID = membershipID;
	}
}
