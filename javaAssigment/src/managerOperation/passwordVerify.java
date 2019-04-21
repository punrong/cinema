package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JTextField;
import javax.swing.JButton;

public class passwordVerify extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField password;
	private JButton cancel, enter;
	public static signupManager frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwordVerify frame = new passwordVerify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public passwordVerify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRequirement = new JLabel("Requirement");
		lblRequirement.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		lblRequirement.setBounds(113, 16, 117, 27);
		contentPane.add(lblRequirement);
		
		JLabel label = new JLabel("Password");
		label.setFont(new Font("AKbalthom KhmerLight", Font.PLAIN, 15));
		label.setBounds(44, 65, 116, 22);
		contentPane.add(label);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(44, 93, 265, 37);
		contentPane.add(password);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(54, 150, 117, 29);
		contentPane.add(cancel);
		
		enter = new JButton("Enter");
		enter.setBackground(new Color(0, 153, 255));
		enter.setOpaque(true);
		enter.setBounds(180, 150, 117, 29);
		contentPane.add(enter);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		enter.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cancel)
		{
			this.setVisible(false);
			Main.frame.setVisible(true);
		}
		else if(e.getSource() == enter)
		{
			if(password.getText().toString().equals("123456789")) {
				this.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frame1 = new signupManager();
							frame1.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			else
			{
				System.out.println("wrong");
			}
		}
	}

}
