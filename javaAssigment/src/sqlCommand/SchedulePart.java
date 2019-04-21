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
import modelClass.MovieSchedule;

public class SchedulePart {
	
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

    public void inputIntoTableSchedule(MovieSchedule s, String movieName)
    {
    	connection();
    	
    	String sql = "INSERT INTO tbSchedule (ScheduleID, MovieID, TimeStart, Hall, TicketPrice, TotalSeat, AvailableSeat, ScheduleDate) VALUES ('" 
    			+ s.getId() + "', '" + s.getMovieID() + "', '" + s.getTimeStart()+ "' , '" + s.getHall() + "','" + s.getTicketprice()+ "','" + s.getTotalSeat() + "','" +s.getRemainSeatAvailable() + "' , '" + s.getScheduleDate() + "');";
		try {
    		System.out.println(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Success");

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<MovieSchedule> getFromTableSchedule()
    {
    	List<MovieSchedule> ms = new ArrayList<MovieSchedule>();
    	connection();
    	try {
	    	rss = stm.executeQuery("SELECT * FROM tbSchedule");
			rss.beforeFirst();
			while(rss.next()) {
				MovieSchedule s = new MovieSchedule(rss.getString(1), rss.getString(2), rss.getString(3), rss.getInt(4), rss.getDouble(5), rss.getInt(6), rss.getInt(7), rss.getString(8));
				ms.add(s);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ms;
    }
    
    public List<MovieSchedule> searchFromTableSchedule(String schedule)
    {
    	String movieID = "";
    	connection();
    	List<MovieSchedule> ss = new ArrayList<MovieSchedule>();   	
    	
    	String sql = "SELECT * FROM tbSchedule WHERE ScheduleDate =  '" + schedule +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				MovieSchedule s = new MovieSchedule(rss.getString(1), rss.getString(2), rss.getString(3), rss.getInt(4), rss.getDouble(5), rss.getInt(6), rss.getInt(7), rss.getString(8));
				ss.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ss;
    }
    
    
    public void deleteFromTableSchedule(String ScheduleID, int n)
    {
    	connection();
    	String sql = "DELETE FROM tbSchedule WHERE ScheduleID =  '" + ScheduleID +"' ";
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
    
    public MovieSchedule searchSeveralField(String hall, String name, String time )
    {
    	String id = "";
    	connection(); 
    	MovieSchedule s =null;
    	
    	MoviePart mp = new MoviePart();
    	Movie m = mp.searchFromTableMovie(name);
    	if(m != null) id = m.getId();
    	
    	String sql = "SELECT * FROM tbSchedule WHERE Hall =  '" + hall + "'AND TimeStart ='" +  time +  "' AND MovieID = '" + id + "' ";

		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				s = new MovieSchedule(rss.getString(1), rss.getString(2), rss.getString(3), rss.getInt(4), rss.getDouble(5), rss.getInt(6), rss.getInt(7), rss.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return s;
    }
    
    public MovieSchedule searchByID(String scheduleID)
    {
    	connection();
    	MovieSchedule s=null;
    	
    	String sql = "SELECT * FROM tbSchedule WHERE ScheduleID =  '" + scheduleID +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				s = new MovieSchedule(rss.getString(1), rss.getString(2), rss.getString(3), rss.getInt(4), rss.getDouble(5), rss.getInt(6), rss.getInt(7), rss.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return s;
    }
    
    
    

}
