package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class detailViewGensale extends JFrame {

	private JPanel contentPane;

	public detailViewGensale(Sale s, Movie m, MovieSchedule m1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
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
				managerFunction.frame4.setVisible(false);
			}
		});
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel lblSaleDetail = new JLabel("Sale Detail");
		lblSaleDetail.setForeground(Color.WHITE);
		lblSaleDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(lblSaleDetail);
		
		JLabel lblGeneralsaleId = new JLabel(s.getId());
		lblGeneralsaleId.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblGeneralsaleId.setBounds(16, 54, 1067, 51);
		contentPane.add(lblGeneralsaleId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(" Movie Information "));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(16, 124, 1067, 177);
		contentPane.add(panel_1);
		
		JLabel lblMovieName = new JLabel("Movie Name : ");
		lblMovieName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieName.setBounds(27, 51, 111, 23);
		panel_1.add(lblMovieName);
		
		JLabel label_4 = new JLabel(m.getName());
		label_4.setBounds(150, 47, 188, 35);
		panel_1.add(label_4);
		
		JLabel lblRunningTime = new JLabel("Running Time : ");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(370, 51, 122, 23);
		panel_1.add(lblRunningTime);
		
		JLabel label_6 = new JLabel(m.getRunningTime()+"");
		label_6.setBounds(493, 47, 188, 35);
		panel_1.add(label_6);
		
		JLabel lblTimeStart = new JLabel("Time Start : ");
		lblTimeStart.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTimeStart.setBounds(732, 51, 90, 23);
		panel_1.add(lblTimeStart);
		
		JLabel label_8 = new JLabel(m1.getTimeStart());
		label_8.setBounds(855, 47, 188, 35);
		panel_1.add(label_8);
		
		JLabel lblHall = new JLabel("Hall : ");
		lblHall.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblHall.setBounds(27, 110, 111, 23);
		panel_1.add(lblHall);
		
		JLabel label_10 = new JLabel(m1.getHall()+"");
		label_10.setBounds(150, 106, 188, 35);
		panel_1.add(label_10);
		
		JLabel lblTotalSeat = new JLabel("Total Seat : ");
		lblTotalSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTotalSeat.setBounds(370, 110, 111, 23);
		panel_1.add(lblTotalSeat);
		
		JLabel label_20 = new JLabel(m1.getTotalSeat()+"");
		label_20.setBounds(493, 106, 188, 35);
		panel_1.add(label_20);
		
		JLabel lblTicketPrice = new JLabel("Ticket Price : ");
		lblTicketPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketPrice.setBounds(732, 110, 111, 23);
		panel_1.add(lblTicketPrice);
		
		JLabel label_22 = new JLabel(m1.getTicketprice()+"");
		label_22.setBounds(855, 106, 188, 35);
		panel_1.add(label_22);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Sale Information "));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(16, 337, 1067, 233);
		contentPane.add(panel_2);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDate.setBounds(27, 50, 123, 23);
		panel_2.add(lblDate);
		
		JLabel label_12 = new JLabel(s.getDate());
		label_12.setBounds(150, 46, 188, 35);
		panel_2.add(label_12);
		
		JLabel lblTime = new JLabel("Time : ");
		lblTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTime.setBounds(370, 50, 90, 23);
		panel_2.add(lblTime);
		
		JLabel label_14 = new JLabel(s.getTime());
		label_14.setBounds(493, 46, 188, 35);
		panel_2.add(label_14);
		
		JLabel lblTicketAmount = new JLabel("Ticket Amount : ");
		lblTicketAmount.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketAmount.setBounds(733, 50, 123, 23);
		panel_2.add(lblTicketAmount);
		
		JLabel label_16 = new JLabel(s.getTotalAmount()+"");
		label_16.setBounds(856, 46, 188, 35);
		panel_2.add(label_16);
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTotalPrice.setBounds(27, 110, 123, 23);
		panel_2.add(lblTotalPrice);
		
		JLabel label_18 = new JLabel(s.getTotalPrice()+"");
		label_18.setBounds(150, 106, 188, 35);
		panel_2.add(label_18);
		
		JLabel lblPayment = new JLabel("Payment : ");
		lblPayment.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPayment.setBounds(370, 110, 90, 23);
		panel_2.add(lblPayment);
		
		JLabel label_24 = new JLabel(s.getPayment() +"");
		label_24.setBounds(493, 106, 188, 35);
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel(s.getYourReturn()+"");
		label_25.setBounds(856, 106, 188, 35);
		panel_2.add(label_25);
		
		JLabel lblYourReturn = new JLabel("Your Return : ");
		lblYourReturn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblYourReturn.setBounds(733, 110, 111, 23);
		panel_2.add(lblYourReturn);
		
		JLabel label_31 = new JLabel(s.getEmployeeID());
		label_31.setBounds(150, 168, 188, 35);
		panel_2.add(label_31);
		
		JLabel lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId.setBounds(27, 172, 123, 23);
		panel_2.add(lblEmployeeId);
	}

}
