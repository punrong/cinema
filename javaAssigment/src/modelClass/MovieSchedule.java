package modelClass;

public class MovieSchedule {
	
	private String id;
	private String movieID;
	private String timeStart;
	private int hall;
	private double ticketprice;
	private int totalSeat;
	private int remainSeatAvailable;
	private String scheduleDate;
	
	
	public MovieSchedule() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getRemainSeatAvailable() {
		return remainSeatAvailable;
	}
	public void setRemainSeatAvailable(int remainSeatAvailable) {
		this.remainSeatAvailable = remainSeatAvailable;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public MovieSchedule(String id, String movieID, String timeStart, int hall, double ticketprice, int totalSeat,
			int remainSeatAvailable, String scheduleDate) {
		super();
		this.id = id;
		this.movieID = movieID;
		this.timeStart = timeStart;
		this.hall = hall;
		this.ticketprice = ticketprice;
		this.totalSeat = totalSeat;
		this.remainSeatAvailable = remainSeatAvailable;
		this.scheduleDate = scheduleDate;
	}
	
}
