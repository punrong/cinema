package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import main.Main;

import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginManager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JButton login, signup;
	private JLabel cover, close;

	Connection con;
    Statement stm;
    ResultSet rss;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
	}*/

	/**
	 * Create the frame.
	 */
	public loginManager() {
		ImageIcon icon1;
		icon1 = new ImageIcon("images/cinema.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("* * * * * * * * *");
		label.setBounds(107, 185, 91, 16);
		contentPane.add(label);
		
		JLabel lblPhnomPenhCinema = new JLabel("Phnom Penh Cinema");
		lblPhnomPenhCinema.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPhnomPenhCinema);
		lblPhnomPenhCinema.setBounds(67, 157, 175, 16);
		//panel.add(lblPhnomPenhCinema);
		lblPhnomPenhCinema.setFont(new Font("AKbalthom KhmerLight", Font.BOLD, 17));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(313, 0, 337, 460);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginAsManager = new JLabel("Login As Manager");
		lblLoginAsManager.setFont(new Font("Arial Unicode MS", Font.PLAIN, 21));
		lblLoginAsManager.setBounds(25, 36, 192, 37);
		panel.add(lblLoginAsManager);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("AKbalthom KhmerLight", Font.PLAIN, 15));
		lblUsername.setBounds(25, 109, 116, 22);
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(25, 137, 265, 37);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("AKbalthom KhmerLight", Font.PLAIN, 15));
		lblPassword.setBounds(25, 200, 116, 22);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(25, 228, 265, 37);
		panel.add(password);
		
		login = new JButton("Login");
		login.setFocusPainted(false);
		login.setOpaque(true);
		login.setIcon(null);
		login.setForeground(new Color(0, 0, 0));
		login.setBackground(new Color(0, 153, 51));
		login.setBounds(59, 324, 204, 37);
		panel.add(login);
		
		signup = new JButton("Sign Up");
		signup.setBackground(new Color(255, 0, 102));
		signup.setOpaque(true);
		signup.setBounds(59, 373, 204, 37);
		panel.add(signup);
		
		close = new JLabel("");
		close.setIcon(new ImageIcon("images/close.png"));
		close.setBounds(309, 6, 22, 22);
		panel.add(close);
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
				Main.frame.setVisible(false);
			}
		});
		
		JLabel lblWelcomeTo = new JLabel("WELCOME TO");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcomeTo);
		lblWelcomeTo.setBounds(42, 109, 226, 47);
		//panel.add(lblWelcomeTo);
		lblWelcomeTo.setFont(new Font("AAAAAAAAAAAAAAAAAAAAAAAA", Font.BOLD, 33));
		
		cover = new JLabel("");
		cover.setVerticalAlignment(SwingConstants.TOP);
		cover.setIcon(icon1);
		cover.setBounds(0, 0, 314, 460);
		contentPane.add(cover);
		setUndecorated(true);
		
		login.addActionListener(this);
		signup.addActionListener(this);
	}
	
	public Statement connection()
	{
		try {
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?characterEncoding=utf-8","root","");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			stm =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return stm;
	}
	
	public void loginManager()
	{
		int b=0;
		String name = username.getText().toString().trim();
		String pw = password.getText().toString().trim();
		stm = connection();
		try {
			rss = stm.executeQuery("SELECT * FROM tbManager");
			rss.beforeFirst();
			while(rss.next()) {
				if(rss.getString(2).equals(name) && rss.getString(3).equals(pw))
				{
					b=1;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								managerFunction frame = new managerFunction();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					//JOptionPane.showMessageDialog(null, "Right");
					return;
				}
				else b=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(b == 0)
		{
			JOptionPane.showMessageDialog(null, "Username or Password is incorrect, Please try again");
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login)
		{
			loginManager();
		}
		else if(e.getSource() == signup)
		{
			username.setText("");
			password.setText("");
			this.setVisible(false);
			Main.frame2 = new passwordVerify();
			Main.frame2.setVisible(true);
		}
	}
}
