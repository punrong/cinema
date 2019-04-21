package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelClass.Membership;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class detailViewMembership extends JFrame {

	private JPanel contentPane;

	public detailViewMembership(Membership m) {
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
				managerFunction.frame3.setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Employee Detail");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(label);
		
		JLabel lblMembershipId = new JLabel(m.getId());
		lblMembershipId.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblMembershipId.setBounds(17, 58, 1067, 51);
		contentPane.add(lblMembershipId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setBounds(17, 128, 1067, 147);
		contentPane.add(panel_1);
		
		JLabel lblFirstName = new JLabel("First Name : ");
		lblFirstName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFirstName.setBounds(27, 36, 90, 23);
		panel_1.add(lblFirstName);
		
		JLabel label_4 = new JLabel(m.getfName());
		label_4.setBounds(150, 32, 188, 35);
		panel_1.add(label_4);
		
		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(370, 36, 111, 23);
		panel_1.add(lblLastName);
		
		JLabel label_6 = new JLabel(m.getlName());
		label_6.setBounds(493, 32, 188, 35);
		panel_1.add(label_6);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGender.setBounds(732, 36, 90, 23);
		panel_1.add(lblGender);
		
		JLabel label_8 = new JLabel(m.getGender());
		label_8.setBounds(855, 32, 188, 35);
		panel_1.add(label_8);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth : ");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(27, 88, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		JLabel label_10 = new JLabel(m.getDob());
		label_10.setBounds(150, 84, 188, 35);
		panel_1.add(label_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Card Information "));
		panel_2.setBounds(17, 313, 1067, 147);
		contentPane.add(panel_2);
		
		JLabel lblMembershipId_1 = new JLabel("Membership ID : ");
		lblMembershipId_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMembershipId_1.setBounds(27, 40, 123, 23);
		panel_2.add(lblMembershipId_1);
		
		JLabel label_12 = new JLabel(m.getId());
		label_12.setBounds(150, 36, 188, 35);
		panel_2.add(label_12);
		
		JLabel lblCardLevel = new JLabel("Card Level : ");
		lblCardLevel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCardLevel.setBounds(370, 36, 90, 23);
		panel_2.add(lblCardLevel);
		
		JLabel label_14 = new JLabel(m.getCardLevel());
		label_14.setBounds(493, 36, 188, 35);
		panel_2.add(label_14);
		
		JLabel lblDiscount = new JLabel("Discount : ");
		lblDiscount.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDiscount.setBounds(733, 32, 90, 23);
		panel_2.add(lblDiscount);
		
		JLabel label_16 = new JLabel(m.getDiscount()+"");
		label_16.setBounds(856, 28, 188, 35);
		panel_2.add(label_16);
		
		JLabel lblRegisterDate = new JLabel("Register Date : ");
		lblRegisterDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRegisterDate.setBounds(27, 94, 123, 23);
		panel_2.add(lblRegisterDate);
		
		JLabel label_18 = new JLabel(m.getRegisterDate());
		label_18.setBounds(150, 90, 188, 35);
		panel_2.add(label_18);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(17, 497, 1067, 106);
		contentPane.add(panel_3);
		
		JLabel label_21 = new JLabel("Mobile : ");
		label_21.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_21.setBounds(27, 48, 90, 23);
		panel_3.add(label_21);
		
		JLabel label_22 = new JLabel(m.getMobile());
		label_22.setBounds(150, 44, 188, 35);
		panel_3.add(label_22);
	}

}
