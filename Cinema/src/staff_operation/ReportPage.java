package staff_operation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sql_java_class.Employee;
import sql_java_class.Sale;

public class ReportPage {

	private JPanel GrandParentReportPanel;
	private JPanel ParentReportPanel;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JScrollPane scrollTableSale;
	private JTable tableSale = new JTable();
	
	private ArrayList<Sale> sale = new ArrayList<Sale>();
	
	private DefaultTableModel modelTableSale = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0);;
	private static Employee currentUser = new Employee();
	
	public ReportPage(Employee currentUser) {
		this.currentUser = currentUser;
		initialization();

		ParentReportPanel = new JPanel();
		ParentReportPanel.setBackground(Color.WHITE);
		ParentReportPanel.add(txtSearch);
		ParentReportPanel.add(btnSearch);
		
		GrandParentReportPanel = new JPanel();
		GrandParentReportPanel.setBackground(Color.WHITE);
		GrandParentReportPanel.setLayout(new BorderLayout(0, 0));
		GrandParentReportPanel.add(ParentReportPanel, BorderLayout.NORTH);
		GrandParentReportPanel.add(scrollTableSale, BorderLayout.CENTER);
	}
	
	public JPanel getGrandParentReportPanel() {
		return this.GrandParentReportPanel;
	}
	
	public void initialization() {	
		
		txtSearch = new JTextField();
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		
		scrollTableSale = new JScrollPane();
		scrollTableSale.setBackground(Color.WHITE);
		
		
		//tableSale = new JTable();
		tableSale.setBackground(Color.WHITE);
		tableSale.setAutoCreateColumnsFromModel(true);
		//modelTableSale = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0);
		
		Connection con = null;
		Statement stm;
		ResultSet rss;
		//tableSale = new JTable();
		tableSale.setBackground(Color.WHITE);
		tableSale.setAutoCreateColumnsFromModel(true);
		//modelTableSale = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0);
		
		//modelTableSale.setRowCount(0);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
	    	stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    	rss = stm.executeQuery("SELECT * FROM tblSale;");
//	    	rss.last();
//	    	int rowCount = rss.getRow();
//	    	if(rowCount !=0){
//		    	rss.first();
//	    		Sale sale1 = new Sale();
//	    		sale1.setID(rss.getString("ID"));
//	    		sale1.setEmployeeID(rss.getString("EmployeeID"));
//	    		sale1.setScheduleID(rss.getString("StartingTime"));
//	    		sale1.setDateBought(rss.getString("Date"));
//	    		sale1.setTimeBought(rss.getString("Time"));
//	    		sale1.setTotalAmount(rss.getInt("TotalAmount"));
//	    		sale1.setTotalPrice(rss.getDouble("TotalPrice"));
//	    		sale1.setPayment(rss.getDouble("Payment"));
//	    		sale1.setChange(rss.getDouble("YourReturn"));
//	    		sale.add(sale1);
//				rss.beforeFirst();
				while(rss.next()) {
					 if(rss.getString("EmployeeID").equals(currentUser.getID()))
						modelTableSale.addRow(new Object[]{
								rss.getString("ID"),
								rss.getString("ScheduleID"),
								rss.getString("EmployeeID"),
								rss.getString("Date"),
								rss.getString("Time").substring(0, 5),
								rss.getInt("TotalAmount"),
								rss.getDouble("TotalPrice"),
								rss.getDouble("Payment"),
								rss.getDouble("YourReturn")
						});
				}
//				rss.first();
//	    	}
				
//	    	tableSale.setModel(modelTableSale);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//    	modelTableSale.fireTableDataChanged();
//    	tableSale.repaint();
    	tableSale.setModel(modelTableSale);
		scrollTableSale.setViewportView(tableSale);
		
		
	}
	
	public void UpdateTable() {
		Connection con = null;
		Statement stm;
		ResultSet rss;
		JTable tableSaleUpdate = new JTable();
		tableSaleUpdate.setBackground(Color.WHITE);
		tableSaleUpdate.setAutoCreateColumnsFromModel(true);
		DefaultTableModel modelTableSaleUpdate = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0);
		
		modelTableSaleUpdate.setRowCount(0);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
	    	stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    	rss = stm.executeQuery("SELECT * FROM tblSale;");
//	    	rss.last();
//	    	int rowCount = rss.getRow();
//	    	if(rowCount !=0){
//		    	rss.first();
//	    		Sale sale1 = new Sale();
//	    		sale1.setID(rss.getString("ID"));
//	    		sale1.setEmployeeID(rss.getString("EmployeeID"));
//	    		sale1.setScheduleID(rss.getString("StartingTime"));
//	    		sale1.setDateBought(rss.getString("Date"));
//	    		sale1.setTimeBought(rss.getString("Time"));
//	    		sale1.setTotalAmount(rss.getInt("TotalAmount"));
//	    		sale1.setTotalPrice(rss.getDouble("TotalPrice"));
//	    		sale1.setPayment(rss.getDouble("Payment"));
//	    		sale1.setChange(rss.getDouble("YourReturn"));
//	    		sale.add(sale1);
//				rss.beforeFirst();
				while(rss.next()) {
					 if(rss.getString("EmployeeID").equals(currentUser.getID()))
						modelTableSaleUpdate.addRow(new Object[]{
								rss.getString("ID"),
								rss.getString("ScheduleID"),
								rss.getString("EmployeeID"),
								rss.getString("Date"),
								rss.getString("Time").substring(0, 5),
								rss.getInt("TotalAmount"),
								rss.getDouble("TotalPrice"),
								rss.getDouble("Payment"),
								rss.getDouble("YourReturn")
						});
				}
//				rss.first();
//	    	}
				
//	    	tableSale.setModel(modelTableSale);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//    	modelTableSale.fireTableDataChanged();
//    	tableSale.repaint();
    	tableSaleUpdate.setModel(modelTableSaleUpdate);
    	tableSale = tableSaleUpdate;
		scrollTableSale.setViewportView(tableSale);	}
	
}
