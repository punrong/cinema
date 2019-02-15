package sql_java_class;

public class Schedule {

	private String ID;
	private String MovieID;
	private String StartingTime;
	private int Hall;
	private int TotalSeat;
	private int AvailableSeat;
	
	public Schedule(){
		
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getMovieID() {
		return this.MovieID;
	}
	
	public String getStartingTime() {
		return this.StartingTime.substring(0, 5);
	}
	
	public int getHall() {
		return this.Hall;
	}
	
	public int getTotalSeat() {
		return this.TotalSeat;
	}
	
	public int getAvailableSeat() {
		return this.AvailableSeat;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setStartingTime(String StartingTime) {
		this.StartingTime = StartingTime;
	}
	
	public void setMovieID(String MovieID) {
		this.MovieID = MovieID;
	}
	
	public void setTotalSeat(int TotalSeat) {
		this.TotalSeat = TotalSeat;
	}
	
	public void setHall(int Hall) {
		this.Hall = Hall;
	}
	
	public void setAvailableSeat(int AvailableSeat) {
		this.AvailableSeat = AvailableSeat;
	}
	
}
