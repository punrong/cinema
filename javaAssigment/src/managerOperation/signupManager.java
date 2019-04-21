package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class signupManager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JButton login, signup;
	private JLabel close;
	Connection con;
    Statement stm;
    ResultSet rss;
	
	public signupManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label_1 = new JLabel("WELCOME TO");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("AAAAAAAAAAAAAAAAAAAAAAAA", Font.BOLD, 33));
		label_1.setBounds(385, 111, 226, 47);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("Phnom Penh Cinema");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("AKbalthom KhmerLight", Font.BOLD, 17));
		label_5.setBounds(410, 159, 175, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("* * * * * * * * *");
		label_6.setBounds(450, 187, 91, 16);
		contentPane.add(label_6);
		
		close = new JLabel("");
		close.setBounds(622, 6, 22, 22);
		contentPane.add(close);
		close.setIcon(new ImageIcon("images/close.png"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/cinema.jpg"));
		label.setBackground(Color.LIGHT_GRAY);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(336, 0, 314, 460);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 337, 460);
		contentPane.add(panel);
		
		JLabel lblSignupAsManager = new JLabel("Signup As Manager");
		lblSignupAsManager.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		lblSignupAsManager.setBounds(25, 36, 192, 37);
		panel.add(lblSignupAsManager);
		
		JLabel label_2 = new JLabel("Username");
		label_2.setFont(new Font("AKbalthom KhmerLight", Font.PLAIN, 15));
		label_2.setBounds(25, 109, 116, 22);
		panel.add(label_2);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(25, 137, 265, 37);
		panel.add(username);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("AKbalthom KhmerLight", Font.PLAIN, 15));
		label_3.setBounds(25, 200, 116, 22);
		panel.add(label_3);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(25, 228, 265, 37);
		panel.add(password);
		
		login = new JButton("Login");
		login.setOpaque(true);
		login.setForeground(Color.BLACK);
		login.setFocusPainted(false);
		login.setBackground(new Color(0, 153, 51));
		login.setBounds(58, 369, 204, 37);
		panel.add(login);
		
		signup = new JButton("Sign Up");
		signup.setOpaque(true);
		signup.setBackground(new Color(255, 0, 102));
		signup.setBounds(58, 322, 204, 37);
		panel.add(signup);
		setUndecorated(true);
		
		login.addActionListener(this);
		signup.addActionListener(this);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Main.frame2.setVisible(false);
			}
		});
	
	}
	
	public Statement connection()
	{
		try {
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=utf-8","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			stm =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			/*rss = stm.executeQuery("SELECT * FROM Managers");
		    	rss.first();
		    	lblDisplay.setText("Id \t= "+ rss.getString(1) + "\nName \t= "+
		    	rss.getString(2) + "\nSex \t= "+ 
				rss.getString(3) + "\nScore \t= " + rss.getInt(4));*/
		    	
				//System.out.println(rss.getString(1));
		
		    	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return stm;
	}
	
	public void signupManager()
	{
		stm = connection();
		String name = username.getText().toString().trim();
		String pw = password.getText().toString().trim();
		String sql = "INSERT INTO tbManager (ManagerName, Password) VALUES ('" + name + "', '" + pw + "');";
		
		try {
    		System.out.println(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Success");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login)
		{
			username.setText("");
			password.setText("");
			this.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Main.frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(e.getSource() == signup)
		{
			signupManager();
		}
	}

}
