package staffOperation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelClass.Employee;
import modelClass.Sale;

public class ReportPage {

	private JPanel GrandParentReportPanel;
	private JPanel ParentReportPanel;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JScrollPane scrollTableSale;
	private JTable tableSale;
	
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	
	private ArrayList<Sale> sale = new ArrayList<Sale>();
	
	private DefaultTableModel modelTableSale;
	private static Employee currentUser;
	
	public ReportPage(Employee currentUser) {
		ReportPage.currentUser = currentUser;
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
		

		modelTableSale = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID","MembershipID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
			
		tableSale = new JTable(modelTableSale);
		tableSale.setBackground(Color.WHITE);
		tableSale.setAutoCreateColumnsFromModel(true);
		
		tableSale.setModel(modelTableSale);
		tableSale.getTableHeader().setReorderingAllowed(false);
		tableSale.setRowHeight(20);
		tableSale.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for(int i = 0 ; i < tableSale.getColumnCount(); i++)
			tableSale.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		
		scrollTableSale.setViewportView(tableSale);
	}
	
	public void updateTable() {
		Statement stm;
		ResultSet rss;
		modelTableSale.setRowCount(0);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");
	    	stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    	rss = stm.executeQuery("SELECT * FROM tbSale;");
			while(rss.next()) {
				 if(rss.getString("EmployeeID").equals(ReportPage.currentUser.getId()))
					modelTableSale.addRow(new Object[]{
							rss.getString("ID"),
							rss.getString("ScheduleID"),
							rss.getString("EmployeeID"),
							rss.getString("MembershipID"),
							rss.getString("Date"),
							rss.getString("Time").substring(0, 5),
							rss.getInt("TotalAmount"),
							rss.getDouble("TotalPrice"),
							rss.getDouble("Payment"),
							rss.getDouble("YourReturn")
					});
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}
	
}
