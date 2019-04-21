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
import modelClass.Movie;
import modelClass.MovieSchedule;

public class EmployeePart {
	
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

    public void inputIntoTableEmployee(Employee e)
    {
    	connection();
    	//String id = m.getName() + m.getDirector();
    	String sql = "INSERT INTO tbEmployee (EmployeeId, FirstName, LastName, Gender, DateOfBirth, Salary, Street, District, Commune, City, Country, Mobile, Email, Username, Password) VALUES ('" 
    			+ e.getId() + "', '" + e.getfName() + "', '" + e.getlName() + "' , '" +e.getGender() + "','" + e.getDob() + "','" + e.getSalary() + "','" + e.getStreet() + "' , '" + e.getDistrict() + "','"
    			+ e.getCommune() + "','" + e.getCity()+ "','" + e.getCountry() + "','" + e.getPhoneNum() + "','" + e.getEmail() + "','" +e.getUsername() + "','" + e.getPassword() + "');";
		try {
    		System.out.println(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Success");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
    
    public List<Employee> getFromTableEmployee()
    {
    	List<Employee> es = new ArrayList<Employee>();
    	connection();
    	try {
	    	rss = stm.executeQuery("SELECT * FROM tbEmployee");
			rss.beforeFirst();
			while(rss.next()) {
				Employee e = new Employee(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getDouble(6), rss.getString(7), rss.getString(8), rss.getString(9), rss.getString(10), rss.getString(11), rss.getString(12),rss.getString(13), rss.getString(14), rss.getString(15));
				es.add(e);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return es;
    }
    
    public Employee searchFromTableEmployee(String username)
    {
    	connection();
    	Employee e = null;
    	
    	String sql = "SELECT * FROM tbEmployee WHERE Username =  '" + username +"' ";
		try {
			rss = stm.executeQuery(sql);
			rss.beforeFirst();
			while(rss.next()) {
				e = new Employee(rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4), rss.getString(5), rss.getDouble(6), rss.getString(7), rss.getString(8), rss.getString(9), rss.getString(10), rss.getString(11), rss.getString(12),rss.getString(13), rss.getString(14), rss.getString(15));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    	return e;
    }
    
    public void deleteFromTableEmployee(String employeeID, int n)
    {
    	connection();
    	String sql = "DELETE FROM tbEmployee WHERE EmployeeID =  '" + employeeID +"' ";
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
    
    public void deleteFromTableEmployee(String employeeName)
    {
    	connection();
    	String sql = "DELETE FROM tbEmployee WHERE Username =  '" + employeeName +"' ";
    	try {
			stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Delete Completed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
