package staffOperation;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelClass.Employee;

public class SignIn extends JFrame {

	private JPanel MainPanel;
	private JTextField txtUsername;
	private JPasswordField pwd;
	private JPanel panel_left;
	private JLabel leftPhotoCinema;
	private JLabel lblVersion;
	private JLabel lblPhnomPenhCinema;
	private JLabel lblInvalidAlertMessage;
	private JLabel lblClose;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnSignIn;
	private JLabel lblLogo;
	private int xx, yy;

	public static void main(String[] args) {
		new SignIn();
	}

	public SignIn() {
		initialization();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 314);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	public void initialization() {
		
		MainPanel = new JPanel();

		MainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		MainPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				SignIn.this.setLocation(x - xx, y - yy);
			}
		});

		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		panel_left = new JPanel();
		panel_left.setBackground(new Color(135, 206, 235));
		panel_left.setBounds(0, 0, 300, 314);
		MainPanel.add(panel_left);
		panel_left.setLayout(null);
		
		leftPhotoCinema = new JLabel("");
		leftPhotoCinema.setIcon(new ImageIcon("cinema.jpg"));
		leftPhotoCinema.setBounds(0, 0, 302, 200);
		panel_left.add(leftPhotoCinema);
		
		lblVersion = new JLabel("v1.0");
		lblVersion.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setBounds(10, 289, 46, 14);
		panel_left.add(lblVersion);
		
		lblPhnomPenhCinema = new JLabel("Phnom Penh Cinema");
		lblPhnomPenhCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnomPenhCinema.setForeground(Color.WHITE);
		lblPhnomPenhCinema.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblPhnomPenhCinema.setBounds(68, 245, 181, 14);
		panel_left.add(lblPhnomPenhCinema);
		
		lblInvalidAlertMessage = new JLabel("Username or Password is incorrect");
		lblInvalidAlertMessage.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblInvalidAlertMessage.setForeground(Color.RED);
		lblInvalidAlertMessage.setVisible(false);
		lblInvalidAlertMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidAlertMessage.setBounds(296, 132, 300, 14);
		MainPanel.add(lblInvalidAlertMessage);
		
		lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblClose.setFont(new Font("Trajan Pro", Font.PLAIN, 18));
		lblClose.setForeground(new Color(255, 0, 0));
		lblClose.setBounds(583, 0, 13, 30);
		MainPanel.add(lblClose);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setBounds(317, 157, 72, 14);
		MainPanel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(310, 182, 248, 20);
		MainPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(317, 213, 72, 14);
		MainPanel.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setBounds(310, 238, 248, 20);
		MainPanel.add(pwd);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Connection cnn = null;
			    Statement stm;
				ResultSet rss;
				
		 try {
		      		
		   		cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");

			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tbEmployee;");
			    	while(rss.next()) {	
			    		Employee emp = new Employee();
			    		emp.setId(rss.getString("EmployeeID"));
			    		emp.setUsername(rss.getString("username"));
			    		emp.setPassword(rss.getString("password"));
			    		
						if(txtUsername.getText().equals(emp.getUsername()) && pwd.getText().equals(emp.getPassword())) {
							setVisible(false);
							new MainControlActivity(emp);
						}
			    	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						cnn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					lblInvalidAlertMessage.setVisible(true);
			}
		});
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(Color.RED);
		btnSignIn.setBounds(310, 277, 248, 23);
		MainPanel.add(btnSignIn);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("logo.png"));
		lblLogo.setBounds(370, 0, 128, 119);
		MainPanel.add(lblLogo);
	}
}
