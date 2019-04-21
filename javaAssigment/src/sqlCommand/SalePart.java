package sqlCommand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelClass.Employee;
import modelClass.Membership;
import modelClass.MovieSchedule;
import modelClass.Sale;

public class SalePart {
	
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

    public List<Sale> getFromTableSale()
    {
    	List<Sale> ss = new ArrayList<Sale>();
    	connection();
    	try {
	    	rss = stm.executeQuery("SELECT * FROM tbSale");
			rss.beforeFirst();
			while(rss.next()) {
				Sale s = new Sale(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getString(6), rss.getInt(7), rss.getDouble(8),rss.getDouble(9), rss.getDouble(10));
				ss.add(s);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ss;
    }
    
    public List<Sale> searchFromTableSale(String saleDate)
    {
    	connection();
    	List<Sale> ss = new ArrayList<Sale>();   	
    	
    	String sql = "SELECT * FROM tbSale WHERE Date =  '" + saleDate +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				Sale s = new Sale(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getString(6), rss.getInt(7), rss.getDouble(8),rss.getDouble(9), rss.getDouble(10));
				ss.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ss;
    }
    
    
    public void deleteFromTableSale(String saleID, int n)
    {
    	connection();
    	String sql = "DELETE FROM tbSale WHERE ID =  '" + saleID +"' ";
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
    
    public Sale searchFromTableSales(String saleID)
    {
    	connection(); 	
    	Sale s = null;
    	
    	String sql = "SELECT * FROM tbSale WHERE ID =  '" + saleID +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				s = new Sale(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getString(6), rss.getInt(7), rss.getDouble(8),rss.getDouble(9), rss.getDouble(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return s;
    }
   
}
