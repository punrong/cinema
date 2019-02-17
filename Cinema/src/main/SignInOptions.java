package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class SignInOptions extends JFrame {
	
	private JPanel MainPanel;
	private JLabel lblClose;
	private JLabel lblLogo;
	private int xx, yy;
	private JButton btnStaff;
	private JLabel lblSignInAs;

	public static void main(String[] args) {
		new SignInOptions();
	}

	public SignInOptions() {
		initialization();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 272);
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
				SignInOptions.this.setLocation(x - xx, y - yy);
			}
		});

		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		lblSignInAs = new JLabel("SIGN IN AS");
		lblSignInAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignInAs.setBounds(106, 153, 89, 14);
		MainPanel.add(lblSignInAs);
		lblClose.setFont(new Font("Trajan Pro", Font.PLAIN, 18));
		lblClose.setForeground(Color.RED);
		lblClose.setBounds(285, 0, 13, 19);
		MainPanel.add(lblClose);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("resource/logo.png"));
		lblLogo.setBounds(0, 11, 290, 119);
		MainPanel.add(lblLogo);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAdmin.setForeground(Color.DARK_GRAY);
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setBounds(106, 186, 89, 23);
		MainPanel.add(btnAdmin);
		
		btnStaff = new JButton("Staff");
		btnStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignIn sign = new SignIn();
				setVisible(false);
				sign.setVisible(true);
			}
		});
		btnStaff.setForeground(Color.DARK_GRAY);
		btnStaff.setBackground(Color.WHITE);
		btnStaff.setBounds(106, 245, 89, 23);
		MainPanel.add(btnStaff);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBackground(Color.WHITE);
		lblOr.setForeground(Color.DARK_GRAY);
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(91, 220, 110, 14);
		MainPanel.add(lblOr);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("resource/back.jpg"));
		lblBackground.setBounds(0, 0, 298, 272);
		MainPanel.add(lblBackground);
	}
}
