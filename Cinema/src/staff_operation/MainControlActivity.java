package staff_operation;

import javax.swing.*;

import main.SignInOptions;
import sql_java_class.Employee;
import sql_java_class.Sale;
import sql_java_class.Schedule;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class MainControlActivity extends JFrame {
		
	private JLayeredPane DescriptionPane;
	
	private NowShowingPage ShowingPage;
	private ComingSoonPage ComingPage = new ComingSoonPage();
	private ReportPage reportPage;
	//private SalePage sale = new SalePage();
	private DashBoard dashBoard = new DashBoard();
	private ScrollTop scrollTop;
	
	private JPanel NowShowingPanel ;
	private JPanel ComingSoonPanel;
	//private JPanel SalePanel;
	private JPanel ReportPanel;

	private static Employee currentUser;


	public static void main(String[] args) {
		new MainControlActivity(currentUser);
	}

	public MainControlActivity(Employee currentUser) {
		MainControlActivity.currentUser = currentUser;
		ShowingPage = new NowShowingPage(MainControlActivity.currentUser);
		reportPage = new ReportPage(MainControlActivity.currentUser);
		initialization();
		setTitle("Phnom Penh Cinema");
		ImageIcon img = new ImageIcon("resource/mini logo.png"); 
		setIconImage(img.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void initialization() {
		
		scrollTop = new ScrollTop(MainControlActivity.currentUser.getUsername());
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(scrollTop.getDashBoardTopPanel(), BorderLayout.NORTH);
		
		initializeOntheMainMiddleContent();
		DescriptionPane = new JLayeredPane();
		DescriptionPane.setBackground(Color.BLUE);
		getContentPane().add(DescriptionPane, BorderLayout.CENTER);
		DescriptionPane.setLayout(new CardLayout(0, 0));
		
		headerOntheMiddle(NowShowingPanel, "Now Showing");
		headerOntheMiddle(ComingSoonPanel," Coming Soon");
//		headerOntheMiddle(SalePanel, "Sale");
		headerOntheMiddle(ReportPanel, "Report");
		
		DescriptionPane.add(NowShowingPanel);			
		DescriptionPane.add(ComingSoonPanel);
//		DescriptionPane.add(SalePanel);
		DescriptionPane.add(ReportPanel);
		ReportPanel.setLayout(new BorderLayout(0, 0));
		
	

//		SalePanel.add(sale.getEmptySpaceLeft(), BorderLayout.WEST);
//		SalePanel.add(sale.getMainPanel(), BorderLayout.CENTER);
		ReportPanel.add(reportPage.getGrandParentReportPanel(), BorderLayout.CENTER);
		NowShowingPanel.add(ShowingPage.getGrandParentNowShowingPanel(), BorderLayout.CENTER);
		ComingSoonPanel.add(ComingPage.getGrandParentComingSoonPanel(), BorderLayout.CENTER);
		
		getContentPane().add(dashBoard.getDashBoardLeftPanel(), BorderLayout.WEST);
		mouseAction(dashBoard.getlblNowShowing());
		mouseAction(dashBoard.getlblComingSoon());
//		mouseAction(dashBoard.getlblSale());
//		mouseAction(dashBoard.getlblSchedule());
		mouseAction(dashBoard.getlblReport());
		mouseAction(dashBoard.getlblSignOut());
	}
	
	
	
	public void initializeOntheMainMiddleContent() {
		NowShowingPanel = new JPanel();		
		NowShowingPanel.setBackground(Color.WHITE);
		NowShowingPanel.setLayout(new BorderLayout(0, 0));
		
		ComingSoonPanel = new JPanel();
		ComingSoonPanel.setBackground(Color.WHITE);
		ComingSoonPanel.setLayout(new BorderLayout(0, 0));
		
//		SalePanel = new JPanel();	
//		SalePanel.setBackground(Color.WHITE);
//		SalePanel.setLayout(new BorderLayout(0, 0));		
		
		ReportPanel = new JPanel();		
		ReportPanel.setBackground(Color.WHITE);
	}
	
	public void headerOntheMiddle(JPanel thisPanel, String title) {
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.GREEN);
		thisPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		JLabel headerTitle = new JLabel(title);
		headerTitle.setFont(new Font("Eras Bold ITC", Font.BOLD, 16));
		headerTitle.setForeground(Color.WHITE);
		headerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(headerTitle);
	}	
	
	public void mouseAction(JLabel selectedLabel) {
		selectedLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				selectedLabel.setForeground(Color.YELLOW);
			}
		});
		selectedLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				selectedLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectedLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {			
				if(selectedLabel.equals(dashBoard.getlblNowShowing())) {
					NowShowingPanel.setVisible(true);
					ComingSoonPanel.setVisible(false);
					//SalePanel.setVisible(false);
					ReportPanel.setVisible(false);
					
				}
				else if(selectedLabel.equals(dashBoard.getlblComingSoon())) {
					ComingSoonPanel.setVisible(true);
					NowShowingPanel.setVisible(false);
					//SalePanel.setVisible(false);
					ReportPanel.setVisible(false);
//					refreshFrame();
				}
					
//				else if(selectedLabel.equals(dashBoard.getlblSale())) {
//					SalePanel.setVisible(true);
//					ComingSoonPanel.setVisible(false);
//					NowShowingPanel.setVisible(false);
//					ReportPanel.setVisible(false);	
//				}
					
				else if(selectedLabel.equals(dashBoard.getlblReport())) {
					reportPage.UpdateTable();
					ReportPanel.setVisible(true);
					//SalePanel.setVisible(false);
					NowShowingPanel.setVisible(false);
					ComingSoonPanel.setVisible(false);
//					refreshFrame();
				}
					
				else if(selectedLabel.equals(dashBoard.getlblSignOut())) {
					setVisible(false);
					SignInOptions sign = new SignInOptions();
					sign.setVisible(true);
				}
			}
		});
	}
	private void refreshFrame() {
		repaint();
		revalidate();
	}
}