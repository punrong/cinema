package managerOperation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelClass.Movie;
import modelClass.MovieSchedule;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

public class detailViewSchedule extends JFrame {

	private JPanel contentPane;
	
	public detailViewSchedule(MovieSchedule s, Movie m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		if(m == null) m = new Movie();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/close.png"));
		label.setBounds(1067, 6, 27, 33);
		contentPane.add(label);
		label.addMouseListener(new MouseListener() {
			
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
				managerFunction.frame1.setVisible(false);
			}
		});
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(204, 0, 0));
		label_1.setBounds(16, 77, 200, 200);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(m.getImage()));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel lblScheduleDate = new JLabel("Schedule Detail");
		lblScheduleDate.setForeground(Color.WHITE);
		lblScheduleDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		panel.add(lblScheduleDate);
		
		JLabel lblScheduleDate_1 = new JLabel(s.getScheduleDate());
		lblScheduleDate_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblScheduleDate_1.setBounds(328, 67, 649, 33);
		contentPane.add(lblScheduleDate_1);
		
		JLabel lblMovieName = new JLabel("Movie Name ");
		lblMovieName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieName.setBounds(338, 122, 100, 22);
		contentPane.add(lblMovieName);
		
		JLabel label_3 = new JLabel(": " + m.getName());
		label_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_3.setBounds(450, 123, 248, 21);
		contentPane.add(label_3);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(338, 179, 90, 22);
		contentPane.add(lblLanguage);
		
		JLabel lblSbutitle = new JLabel("Subtitle");
		lblSbutitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSbutitle.setBounds(338, 234, 90, 22);
		contentPane.add(lblSbutitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(338, 289, 111, 22);
		contentPane.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(338, 340, 111, 22);
		contentPane.add(lblRunningTime);
		
		JLabel lblGenre = new JLabel("Genre ");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(338, 389, 111, 22);
		contentPane.add(lblGenre);
		
		JLabel label_9 = new JLabel(": " + m.getGenre());
		label_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_9.setBounds(450, 390, 248, 21);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(": " + m.getRunningTime());
		label_10.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_10.setBounds(450, 341, 248, 21);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(": "+m.getFormat());
		label_11.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_11.setBounds(450, 290, 248, 21);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(": " + m.getSubtitle());
		label_12.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_12.setBounds(450, 235, 248, 21);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(": " + m.getLanguage());
		label_13.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_13.setBounds(450, 180, 248, 21);
		contentPane.add(label_13);
		JLabel label_27 = new JLabel(": " +  m.getCast());
		label_27.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_27.setBounds(450, 436, 248, 21);
		contentPane.add(label_27);
		
		JLabel lblScheduleId = new JLabel("Schedule ID");
		lblScheduleId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleId.setBounds(749, 122, 90, 22);
		contentPane.add(lblScheduleId);
		
		JLabel lblTimeStart = new JLabel("Time Start");
		lblTimeStart.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTimeStart.setBounds(749, 179, 90, 22);
		contentPane.add(lblTimeStart);
		
		JLabel lblHall = new JLabel("Hall");
		lblHall.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblHall.setBounds(749, 234, 90, 22);
		contentPane.add(lblHall);
		
		JLabel lblTotalSeat = new JLabel("Total Seat ");
		lblTotalSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTotalSeat.setBounds(749, 289, 111, 22);
		contentPane.add(lblTotalSeat);
		
		JLabel lblAvailableSeat = new JLabel("Available Seat");
		lblAvailableSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblAvailableSeat.setBounds(749, 340, 111, 22);
		contentPane.add(lblAvailableSeat);
		
		JLabel lblTicketPrice = new JLabel("Ticket Price");
		lblTicketPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketPrice.setBounds(749, 389, 111, 22);
		contentPane.add(lblTicketPrice);
		
		JLabel label_20 = new JLabel(": " + s.getTicketprice());
		label_20.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_20.setBounds(861, 390, 216, 21);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(": " + s.getRemainSeatAvailable());
		label_21.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_21.setBounds(861, 341, 216, 21);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(": " + s.getTotalSeat());
		label_22.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_22.setBounds(861, 290, 216, 21);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(": " + s.getHall());
		label_23.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_23.setBounds(861, 235, 216, 21);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel(": " + s.getTimeStart());
		label_24.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_24.setBounds(861, 180, 216, 21);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel(": " + s.getId());
		label_25.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_25.setBounds(861, 123, 216, 21);
		contentPane.add(label_25);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(338, 435, 111, 22);
		contentPane.add(lblCast);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(m.getSummary());
		textArea.setEditable(false);
		textArea.setBounds(16, 469, 1067, 136);
		contentPane.add(textArea);
	}
}
