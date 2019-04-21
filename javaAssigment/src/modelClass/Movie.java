package modelClass;

public class Movie {
	
	private String id;
	private String name;
	private String language;
	private String subtitle;
	private String format;
	private int runningTime;
	private String genre;
	private String opeingDate;
	private String cast;
	private String director;
	private String importFrom;
	private String importDate;
	private double importPrice;
	private String image;
	private String summary;
	
	public Movie() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getOpeingDate() {
		return opeingDate;
	}
	public void setOpeingDate(String opeingDate) {
		this.opeingDate = opeingDate;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getImportFrom() {
		return importFrom;
	}
	public void setImportFrom(String importFrom) {
		this.importFrom = importFrom;
	}
	public String getImportDate() {
		return importDate;
	}
	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}
	public double getImportPrice() {
		return importPrice;
	}
	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}
	public Movie(String id, String name, String language, String subtitle, String format, int runningTime, String genre,
			String opeingDate, String cast, String director, String importFrom, String importDate, double importPrice,
			String image, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.subtitle = subtitle;
		this.format = format;
		this.runningTime = runningTime;
		this.genre = genre;
		this.opeingDate = opeingDate;
		this.cast = cast;
		this.director = director;
		this.importFrom = importFrom;
		this.importDate = importDate;
		this.importPrice = importPrice;
		this.image = image;
		this.summary = summary;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
