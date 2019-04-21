package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelClass.Membership;
import modelClass.Movie;
import modelClass.MovieSchedule;
import modelClass.Sale;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class detailViewMemsale extends JFrame {

	private JPanel contentPane;

	public detailViewMemsale(Sale s, Movie m, MovieSchedule m1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(1067, 5, 27, 33);
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
				managerFunction.frame5.setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Sale Detail");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(label);
		
		JLabel lblMembershipsaleId = new JLabel(s.getId());
		lblMembershipsaleId.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblMembershipsaleId.setBounds(16, 54, 1067, 51);
		contentPane.add(lblMembershipsaleId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(" Movie Information "));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(16, 124, 1067, 177);
		contentPane.add(panel_1);
		
		JLabel label_3 = new JLabel("Movie Name : ");
		label_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_3.setBounds(27, 51, 111, 23);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel(m.getName());
		label_4.setBounds(150, 47, 188, 35);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Running Time : ");
		label_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_5.setBounds(370, 51, 122, 23);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel(m.getRunningTime()+"");
		label_6.setBounds(493, 47, 188, 35);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Time Start : ");
		label_7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_7.setBounds(732, 51, 90, 23);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel(m1.getTimeStart());
		label_8.setBounds(855, 47, 188, 35);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Hall : ");
		label_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_9.setBounds(27, 110, 111, 23);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel(m1.getHall()+"");
		label_10.setBounds(150, 106, 188, 35);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Total Seat : ");
		label_11.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_11.setBounds(370, 110, 111, 23);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel(m1.getTotalSeat()+"");
		label_12.setBounds(493, 106, 188, 35);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Ticket Price : ");
		label_13.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_13.setBounds(732, 110, 111, 23);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel(m1.getTicketprice()+"");
		label_14.setBounds(855, 106, 188, 35);
		panel_1.add(label_14);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Sale Information "));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(16, 337, 1067, 233);
		contentPane.add(panel_2);
		
		JLabel lblMembershipId = new JLabel("Membership ID : ");
		lblMembershipId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMembershipId.setBounds(27, 50, 123, 23);
		panel_2.add(lblMembershipId);
		
		JLabel label_16 = new JLabel(s.getMembershipID());
		label_16.setBounds(150, 46, 188, 35);
		panel_2.add(label_16);
		
		JLabel lblEmployeeId = new JLabel("Employee ID : ");
		lblEmployeeId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId.setBounds(370, 50, 111, 23);
		panel_2.add(lblEmployeeId);
		
		JLabel label_18 = new JLabel(s.getEmployeeID());
		label_18.setBounds(493, 46, 188, 35);
		panel_2.add(label_18);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDate.setBounds(733, 50, 123, 23);
		panel_2.add(lblDate);
		
		JLabel label_20 = new JLabel(s.getDate());
		label_20.setBounds(856, 46, 188, 35);
		panel_2.add(label_20);
		
		JLabel lblTime = new JLabel("Time : ");
		lblTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTime.setBounds(27, 110, 123, 23);
		panel_2.add(lblTime);
		
		JLabel label_22 = new JLabel(s.getTime());
		label_22.setBounds(150, 106, 188, 35);
		panel_2.add(label_22);
		
		JLabel lblTicketAmount = new JLabel("Ticket Amount : ");
		lblTicketAmount.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketAmount.setBounds(370, 110, 123, 23);
		panel_2.add(lblTicketAmount);
		
		JLabel label_24 = new JLabel(s.getTotalAmount()+"");
		label_24.setBounds(493, 106, 188, 35);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel(s.getTotalPrice()+"");
		label_25.setBounds(856, 106, 188, 35);
		panel_2.add(label_25);
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTotalPrice.setBounds(733, 110, 111, 23);
		panel_2.add(lblTotalPrice);
		
		JLabel label_27 = new JLabel(s.getPayment()+"");
		label_27.setBounds(150, 168, 188, 35);
		panel_2.add(label_27);
		
		JLabel lblPayment = new JLabel("Payment : ");
		lblPayment.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPayment.setBounds(27, 172, 123, 23);
		panel_2.add(lblPayment);
		
		JLabel lblYourReturn = new JLabel("Your Return : ");
		lblYourReturn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblYourReturn.setBounds(370, 172, 123, 23);
		panel_2.add(lblYourReturn);
		
		JLabel label_29 = new JLabel(s.getYourReturn()+"");
		label_29.setBounds(493, 168, 188, 35);
		panel_2.add(label_29);
	}

}
