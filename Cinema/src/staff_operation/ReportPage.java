package staff_operation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import sql_java_class.Employee;
import sql_java_class.Sale;

public class ReportPage {

	private JPanel GrandParentReportPanel;
	private JPanel ParentReportPanel;
	private JPanel SearchPanel;
	private JPanel TotalIncomePanel;
	
	private JLabel lblTotalIncome;
	
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnReload;
	private JScrollPane scrollTableSale;
	private JTable tableSale;
	
	private DefaultTableModel modelTableSale = new DefaultTableModel(new String[]{"SaleID", "ScheduleID", "EmployeeID",  "MemberID", "Date", "Time", "TotalAmount", "TotalPrice", "Payment", "YourReturn"}, 0) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private Employee currentUser;
	
	public ReportPage(Employee currentUser) {
		this.currentUser = currentUser;
		initialization();

		ParentReportPanel = new JPanel();
		ParentReportPanel.setLayout(new BorderLayout(0,0));
		ParentReportPanel.setBackground(Color.WHITE);
		
		SearchPanel = new JPanel();
		SearchPanel.add(txtSearch);
		SearchPanel.setBackground(Color.WHITE);
		SearchPanel.add(btnSearch);
		SearchPanel.add(btnReload);
		
		JPanel emptyPanelLeft = new JPanel();
		emptyPanelLeft.setBackground(Color.WHITE);
		
		JPanel emptyPanelRight = new JPanel();
		emptyPanelRight.setBackground(Color.WHITE);
		
		TotalIncomePanel = new JPanel();
		TotalIncomePanel.add(lblTotalIncome);
		TotalIncomePanel.setBackground(Color.WHITE);
		
		ParentReportPanel.add(SearchPanel, BorderLayout.NORTH);
		ParentReportPanel.add(scrollTableSale, BorderLayout.CENTER);
		ParentReportPanel.add(emptyPanelLeft,  BorderLayout.EAST);
		ParentReportPanel.add(emptyPanelRight,  BorderLayout.WEST);
		ParentReportPanel.add(TotalIncomePanel,  BorderLayout.SOUTH);
		
		
		GrandParentReportPanel = new JPanel();
		GrandParentReportPanel.setBackground(Color.WHITE);
		GrandParentReportPanel.setLayout(new BorderLayout(0, 0));
		GrandParentReportPanel.add(ParentReportPanel, BorderLayout.CENTER);
		//GrandParentReportPanel.add(scrollTableSale, BorderLayout.SOUTH);
	}
	
	public JPanel getGrandParentReportPanel() {
		return this.GrandParentReportPanel;
	}
	
	public void initialization() {	
		txtSearch = new JTextField();
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int check= 0;
				Statement stm;
				ResultSet rss;
				modelTableSale.setRowCount(0);
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
			    	stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tblSale;");
					while(rss.next()) {
						 if(rss.getString("ID").equals(txtSearch.getText())) {
							 check = 1;
							modelTableSale.addRow(new Object[]{
									rss.getString("ID"),
									rss.getString("ScheduleID"),
									rss.getString("EmployeeID"),
									rss.getString("MemberID"),
									rss.getString("Date"),
									rss.getString("Time").substring(0, 5),
									rss.getInt("TotalAmount"),
									rss.getDouble("TotalPrice"),
									rss.getDouble("Payment"),
									rss.getDouble("YourReturn")
							});
						 }
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				if(check == 0) {
					JOptionPane.showMessageDialog(null,"SaleID not found\n");
					txtSearch.setText("");
					updateTable();
				}
			}
			
		});
		
		btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				updateTable();
			}
		});
		
		lblTotalIncome = new JLabel();
		lblTotalIncome.setBackground(Color.WHITE);
		
		scrollTableSale = new JScrollPane();
		scrollTableSale.setBackground(Color.WHITE);
		
		tableSale = new JTable(modelTableSale);
		tableSale.setBackground(Color.WHITE);
		tableSale.getTableHeader().setResizingAllowed(false);
		tableSale.getTableHeader().setReorderingAllowed(false);
		tableSale.setRowHeight(20);
		tableSale.setFont(new Font("Serif", Font.PLAIN, 15));
		tableSale.setAutoCreateColumnsFromModel(true);
		
		tableSale.setModel(modelTableSale);
		scrollTableSale.setViewportView(tableSale);
		scrollTableSale.getViewport().setBackground(Color.WHITE);
	}
	
	public void updateTable() {
		Statement stm;
		ResultSet rss;
		double income = 0;
		modelTableSale.setRowCount(0);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
	    	stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    	rss = stm.executeQuery("SELECT * FROM tblSale;");
			while(rss.next()) {
				 if(rss.getString("EmployeeID").equals(currentUser.getID())) {
					modelTableSale.addRow(new Object[]{
							rss.getString("ID"),
							rss.getString("ScheduleID"),
							rss.getString("EmployeeID"),
							rss.getString("MemberID"),
							rss.getString("Date"),
							rss.getString("Time").substring(0, 5),
							rss.getInt("TotalAmount"),
							rss.getDouble("TotalPrice"),
							rss.getDouble("Payment"),
							rss.getDouble("YourReturn")
					});
				 income += rss.getDouble("TotalPrice");
				 }
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lblTotalIncome.setText("Total Income: " + income + "$");
	}
	
}
