package sql_java_class;

public class Sale {
	private String ID;
	private String ScheduleID;
	private String EmployeeID;
	private String DateBought;
	private String TimeBought;
	private String MemberID;
	private int TotalAmount;
	private double TotalPrice;
	private double Payment;
	private double YourReturn;

	public Sale() {
		
	}
	
	public void setMemberID(String MemberID) {
		this.MemberID = MemberID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setScheduleID(String ScheduleID) {
		this.ScheduleID = ScheduleID;
	}
	
	public void setEmployeeID(String EmployeeID) {
		this.EmployeeID = EmployeeID;
	}
	
	public void setDateBought(String DateBought) {
		this.DateBought = DateBought.substring(0,10);
	}
	
	public void setTimeBought(String TimeBought) {
		this.TimeBought = TimeBought;
	}
	
	public void setTotalAmount(int TotalAmount) {

		this.TotalAmount = TotalAmount;
	}
	
	public void setTotalPrice(double TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	
	public void setPayment(double Payment) {
		this.Payment = Payment;
	}
	
	public void setChange(double Change) {
		this.YourReturn = Change;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getScheduleID() {
		return this.ScheduleID;
	}
	
	public String getEmployeeID() {
		return this.EmployeeID;
	}
	
	public String getMemberID() {
		return this.MemberID;
	}
	
	public String getDateBought() {
		return this.DateBought;
	}
	
	public String getTimeBought() {
		return this.TimeBought;
	}
	
	public int getTotalAmount() {
		return this.TotalAmount;
	}
	
	public double getTotalPrice() {
		return this.TotalPrice;
	}
	
	public double getPayment() {
		return this.Payment;
	}
	
	public double getYourReturn() {
		return this.YourReturn;
	}
}

