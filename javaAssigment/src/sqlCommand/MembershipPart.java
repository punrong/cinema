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

public class MembershipPart {
	
	Connection con;
    Statement stm;
    ResultSet rss;
    
    public void connection()
	{
		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=utf-8","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			stm =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

    public void inputIntoTableMembership(Membership m)
    {
    	connection();
 
    	String sql = "INSERT INTO tbMembership (MembershipId, FirstName, LastName, Gender, DateOfBirth, RegisterDate, CardLevel, Discount , Mobile) VALUES ('" 
    			+ m.getId() + "', '" + m.getfName() + "', '" + m.getlName() + "' , '" + m.getGender() + "','" + m.getDob() + "','" + m.getRegisterDate() + "','" + m.getCardLevel() + "' , '" + m.getDiscount() + "','"
    			+ m.getMobile() + "');";
		try {
    		System.out.println(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Success");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
    
    public List<Membership> getFromTableEmployee()
    {
    	List<Membership> ms = new ArrayList<Membership>();
    	connection();
    	try {
	    	rss = stm.executeQuery("SELECT * FROM tbMembership");
			rss.beforeFirst();
			while(rss.next()) {
				Membership m = new Membership(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getString(6), rss.getString(7), rss.getDouble(8), rss.getString(9));
				ms.add(m);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return ms;
    }
    
    public Membership searchFromTableMembership(String membershipID)
    {
    	connection();
    	Membership m = null;
    	
    	String sql = "SELECT * FROM tbMembership WHERE MembershipID =  '" + membershipID +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				m = new Membership(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getString(6), rss.getString(7), rss.getDouble(8), rss.getString(9));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    	return m;
    }
    
    public void deleteFromTableMembership(String membershipID, int n)
    {
    	connection();
    	String sql = "DELETE FROM tbMembership WHERE MembershipID =  '" + membershipID +"' ";
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
