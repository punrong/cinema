package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelClass.Employee;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class detailViewEmployee extends JFrame {

	private JPanel contentPane;

	public detailViewEmployee(Employee e) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(1067, 6, 27, 33);
		label_1.setIcon(new ImageIcon("images/close.png"));
		contentPane.add(label_1);
		label_1.addMouseListener(new MouseListener() {
			
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
				managerFunction.frame2.setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel lblEmployeeDetail = new JLabel("Employee Detail");
		lblEmployeeDetail.setForeground(Color.WHITE);
		lblEmployeeDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(lblEmployeeDetail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setBounds(16, 110, 1067, 147);
		contentPane.add(panel_1);
		
		JLabel label_5 = new JLabel("Gender :");
		label_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_5.setBounds(27, 36, 90, 23);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel(e.getGender());
		label_6.setBounds(150, 32, 188, 35);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Date of Birth :");
		label_7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_7.setBounds(370, 36, 111, 23);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel(e.getDob());
		label_8.setBounds(493, 32, 188, 35);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Salary :");
		label_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_9.setBounds(732, 36, 90, 23);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel(e.getSalary()+"");
		label_10.setBounds(855, 32, 188, 35);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Employee ID : ");
		label_11.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_11.setBounds(27, 88, 111, 23);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel(e.getId());
		label_12.setBounds(150, 84, 188, 35);
		panel_1.add(label_12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Address Information "));
		panel_2.setBounds(16, 280, 1067, 147);
		contentPane.add(panel_2);
		
		JLabel label_13 = new JLabel("Street :");
		label_13.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_13.setBounds(27, 40, 90, 23);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel(e.getStreet());
		label_14.setBounds(150, 36, 188, 35);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("District : ");
		label_15.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_15.setBounds(370, 36, 90, 23);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel(e.getDistrict());
		label_16.setBounds(493, 36, 188, 35);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Commune : ");
		label_17.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_17.setBounds(733, 32, 90, 23);
		panel_2.add(label_17);
		
		JLabel label_18 = new JLabel(e.getCommune());
		label_18.setBounds(856, 28, 188, 35);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel("City / Province : ");
		label_19.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_19.setBounds(27, 94, 123, 23);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel(e.getCity());
		label_20.setBounds(150, 90, 188, 35);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("Country : ");
		label_21.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_21.setBounds(370, 94, 90, 23);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel(e.getCountry());
		label_22.setBounds(493, 90, 188, 35);
		panel_2.add(label_22);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(16, 449, 1067, 106);
		contentPane.add(panel_3);
		
		JLabel label_23 = new JLabel("Mobile : ");
		label_23.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_23.setBounds(27, 48, 90, 23);
		panel_3.add(label_23);
		
		JLabel label_24 = new JLabel(e.getPhoneNum());
		label_24.setBounds(150, 44, 188, 35);
		panel_3.add(label_24);
		
		JLabel label_25 = new JLabel("Email : ");
		label_25.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_25.setBounds(370, 52, 90, 23);
		panel_3.add(label_25);
		
		JLabel label_26 = new JLabel(e.getEmail());
		label_26.setBounds(493, 48, 188, 35);
		panel_3.add(label_26);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder(" Official Information "));
		panel_4.setBounds(16, 577, 1067, 106);
		contentPane.add(panel_4);
		
		JLabel label_27 = new JLabel("Username : ");
		label_27.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_27.setBounds(27, 48, 90, 23);
		panel_4.add(label_27);
		
		JLabel label_28 = new JLabel(e.getUsername());
		label_28.setBounds(150, 44, 188, 35);
		panel_4.add(label_28);
		
		JLabel label_29 = new JLabel("Password : ");
		label_29.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_29.setBounds(370, 48, 90, 23);
		panel_4.add(label_29);
		
		JLabel label_30 = new JLabel(e.getPassword());
		label_30.setBounds(493, 44, 188, 35);
		panel_4.add(label_30);
		
		JLabel lblNewLabel = new JLabel(e.getfName() + " " + e.getlName());
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(16, 54, 1067, 43);
		contentPane.add(lblNewLabel);
	}

}
