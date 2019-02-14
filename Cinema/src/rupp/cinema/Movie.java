package rupp.cinema;

public class Movie {

	private String id;
	private String title;
	private String director;
	private String releaseDate;
	private String duration;
	private String genre;
	private double price;
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate.substring(0,10);
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public void setGenre(String genre) {

		this.genre = genre;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public String getReleaseDate() {
		return this.releaseDate;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Movie() {
		
	}
	
}
