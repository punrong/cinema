package sqlCommand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelClass.Movie;

public class MoviePart {
	
	Connection con;
    Statement stm;
    ResultSet rss;
    
    public void connection()
	{
		try {
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=utf-8","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			stm =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
    
    public void inputIntoTableMovie(Movie m)
    {
    	connection();
    	//String id = m.getName() + m.getDirector();
    	String sql = "INSERT INTO tbMovie (MovieID, MovieName, Language, Subtitle, Formats, RunningTime, Genre, OpeningDate, Cast, Director, ImportedFrom, ImportedDate, ImportedPrice, Image, Summary) VALUES ('" 
    			+ m.getId() + "', '" + m.getName() + "', '" +m.getLanguage()+ "' , '" + m.getSubtitle() + "','" + m.getFormat()+ "','" + m.getRunningTime() + "','" + m.getGenre() + "' , '" + m.getOpeingDate() + "','"
    			+ m.getCast() + "','" + m.getDirector() + "','" + m.getImportFrom() + "','" + m.getImportDate() + "','" + m.getImportPrice() + "','" + m.getImage() + "','" + m.getSummary() + "');";
		try {
    		System.out.println(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Success");

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<Movie> getFromTableMovie()
    {
    	List<Movie> ms = new ArrayList<Movie>();
    	connection();
    	try {
	    	rss = stm.executeQuery("SELECT * FROM tbMovie");
			rss.beforeFirst();
			while(rss.next()) {
				Movie m = new Movie(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getInt(6), rss.getString(7), rss.getString(8), rss.getString(9), rss.getString(10), rss.getString(11), rss.getString(12),rss.getDouble(13), rss.getString(14), rss.getString(15));
				ms.add(m);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ms;
    }
    
    public Movie searchFromTableMovie(String MovieName)
    {
    	connection();
    	Movie m=null;
    	String sql = "SELECT * FROM tbMovie WHERE MovieName =  '" + MovieName +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				m = new Movie(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getInt(6), rss.getString(7), rss.getString(8), rss.getString(9), rss.getString(10), rss.getString(11), rss.getString(12),rss.getDouble(13), rss.getString(14), rss.getString(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return m;
    }
    
    public Movie searchByID(String id)
    {
    	connection();
    	Movie m=null;
    	String sql = "SELECT * FROM tbMovie WHERE MovieID =  '" + id +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				m = new Movie(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getInt(6), rss.getString(7), rss.getString(8), rss.getString(9), rss.getString(10), rss.getString(11), rss.getString(12),rss.getDouble(13), rss.getString(14), rss.getString(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return m;
    }
    
    public void deleteFromTableMovie(String MovieID, int n)
    {
    	connection();
    	String sql = "DELETE FROM tbMovie WHERE MovieID =  '" + MovieID +"' ";
    	try {
			stm.executeUpdate(sql);
			if(n == 1)
			{
				JOptionPane.showMessageDialog(null, "Delete Completed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
