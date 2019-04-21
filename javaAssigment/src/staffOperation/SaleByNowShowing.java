package staffOperation;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import java.sql.PreparedStatement;

import modelClass.Employee;
import modelClass.Movie;
import modelClass.MovieSchedule;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class SaleByNowShowing extends JFrame {

	private int xx, yy;
	private static Movie movie;
	
	private JPanel CardImagePanel ;
	private JLabel imageIcon;
	
	private JPanel QtyPanel;
	private JLabel lblQty;
	
	private JLabel lblClose;
	private JPanel grdMovieDetail;
	private JPanel OutsideBorderPanel;
	
	private JCheckBox chckbxNewCheckBox;
	
	private JButton btnIncreaseQty;
	private JButton btnDecreaseQty;
	private JButton btnPurchase;
	
	private JLabel lblID;
	private JLabel lblTitle;
	private JTextField txtCustomerID;
	private JTextField txtPayment;
	private JLabel lblReleaseDate;
	private JLabel lblDuration;
	private JLabel lblGenre;
	private JLabel lblPrice;
	
	private int currentQty = 1;
	private JLabel lblSchedule;
	private JButton btnNext;
	
	private ArrayList<MovieSchedule> MovieScheduleList = new ArrayList<>();	
	private JLabel lblAvailableSeat;
	private JPanel panelSchedule;
	private JButton btnBack ;
	private int currentSchedule = 0;
	
	private double YourRetun;
	
	private static Employee currentUser;
	
	public static void main(String[] args) {
			new SaleByNowShowing(movie,currentUser);
	}

	public SaleByNowShowing(Movie movie, Employee currentUser) {
		
		SaleByNowShowing.currentUser = currentUser;
		
		getContentPane().setBackground(Color.WHITE);
		SaleByNowShowing.movie = movie;
		setBackground(Color.WHITE);
		initialization();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 314);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);	
	}
	
	public void initialization() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				SaleByNowShowing.this.setLocation(x - xx, y - yy);
			}
		});
		
		retrieveScheduleDB();
		
		CardImagePanel = new JPanel();
		CardImagePanel.setBackground(Color.WHITE);
		CardImagePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getName(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		CardImagePanel.setBounds(32, 16, 212, 223);
		add(CardImagePanel);
		CardImagePanel.setLayout(new CardLayout(0, 0));
		
		imageIcon = new JLabel("");
		imageIcon.setIcon(new ImageIcon(movie.getImage()));
		CardImagePanel.add(imageIcon);
		
		QtyPanel = new JPanel();
		QtyPanel.setBackground(Color.WHITE);
		QtyPanel.setBounds(32, 245, 207, 35);
		add(QtyPanel);
		
		btnDecreaseQty = new JButton("-");
		btnDecreaseQty.setForeground(Color.WHITE);
		btnDecreaseQty.setBackground(Color.LIGHT_GRAY);
		mouseAction(btnDecreaseQty);
		
		lblQty = new JLabel();
		lblQty.setText("   " + currentQty + "   ");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnIncreaseQty = new JButton("+");
		btnIncreaseQty.setForeground(Color.WHITE);
		btnIncreaseQty.setBackground(Color.LIGHT_GRAY);
		mouseAction(btnIncreaseQty);
		
		QtyPanel.add(new JLabel("Quantity"), Color.WHITE);
		QtyPanel.add(btnDecreaseQty);
		QtyPanel.add(lblQty);
		QtyPanel.add(btnIncreaseQty);
		
		lblClose = new JLabel("X");
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		
		lblClose.setForeground(Color.RED);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setBounds(568, 11, 18, 20);
		add(lblClose);
	
		grdMovieDetail = new JPanel();
		grdMovieDetail.setBackground(Color.WHITE);
		grdMovieDetail.setBounds(265, 16, 284, 264);
		add(grdMovieDetail);
		grdMovieDetail.setLayout(new GridLayout(0, 2, 0, 0));
		
		grdMovieDetail.add(new JLabel("ID"));
		lblID = new JLabel();
		lblID.setText(movie.getId());
		grdMovieDetail.add(lblID);
		
		grdMovieDetail.add(new JLabel("Title"));
		lblTitle = new JLabel();
		lblTitle.setText(movie.getName());
		grdMovieDetail.add(lblTitle);
		
		grdMovieDetail.add(new JLabel("Membership"));
		chckbxNewCheckBox = new JCheckBox("I am a member");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxNewCheckBox.isSelected()) {
					txtCustomerID.setEditable(true);
					txtCustomerID.setText("");
				}else {
					txtCustomerID.setEditable(false);
					txtCustomerID.setText("C000");
				}
			}
		});
		grdMovieDetail.add(chckbxNewCheckBox);

		grdMovieDetail.add(new JLabel("CustomerID"));
		txtCustomerID = new JTextField();
		txtCustomerID.setText("C000");
		txtCustomerID.setEditable(false);
		grdMovieDetail.add(txtCustomerID);
		
		grdMovieDetail.add(new JLabel("Release Date"));
		lblReleaseDate = new JLabel();
		lblReleaseDate.setText(movie.getOpeingDate());
		grdMovieDetail.add(lblReleaseDate);
		
		grdMovieDetail.add(new JLabel("Duration"));
		lblDuration = new JLabel();
		lblDuration.setText(movie.getRunningTime() + "");
		grdMovieDetail.add(lblDuration);
		
		grdMovieDetail.add(new JLabel("Genre"));
		lblGenre = new JLabel();
		lblGenre.setText(movie.getGenre());
		grdMovieDetail.add(lblGenre);
		
		grdMovieDetail.add(new JLabel("Available Seat"));
		lblAvailableSeat = new JLabel(MovieScheduleList.get(currentSchedule).getRemainSeatAvailable() + "");
		grdMovieDetail.add(lblAvailableSeat);
		
		grdMovieDetail.add(new JLabel("Schedule"));
		panelSchedule = new JPanel();
		panelSchedule.setBackground(Color.WHITE);
		grdMovieDetail.add(panelSchedule);
		panelSchedule.setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("<");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.LIGHT_GRAY);
		mouseAction(btnBack);
		
		lblSchedule = new JLabel(MovieScheduleList.get(0).getTimeStart());
		lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNext = new JButton(">");
		btnNext.setForeground(Color.WHITE);
		btnNext.setBackground(Color.LIGHT_GRAY);
		mouseAction(btnNext);
		
		panelSchedule.add(btnBack, BorderLayout.WEST);
		panelSchedule.add(lblSchedule, BorderLayout.CENTER);
		panelSchedule.add(btnNext, BorderLayout.EAST);
		
		grdMovieDetail.add(new JLabel("Price"));
		lblPrice = new JLabel();
		lblPrice.setText( MovieScheduleList.get(currentSchedule).getTicketprice() + "$");
		grdMovieDetail.add(lblPrice);
		
		grdMovieDetail.add(new JLabel("Your Payment"));
		txtPayment = new JTextField();
		txtPayment.setText("0.0");
		grdMovieDetail.add(txtPayment);

		grdMovieDetail.add(new JLabel(""));
		grdMovieDetail.add(new JLabel(""));
		
		grdMovieDetail.add(new JLabel(""));
		btnPurchase = new JButton("Purchase");
		btnPurchase.setForeground(Color.WHITE);
		btnPurchase.setBackground(Color.LIGHT_GRAY);
		grdMovieDetail.add(btnPurchase);
		mouseAction(btnPurchase);
		
		OutsideBorderPanel = new JPanel();
		OutsideBorderPanel.setBackground(Color.WHITE);
		OutsideBorderPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		OutsideBorderPanel.setBounds(10, 11, 576, 292);
		OutsideBorderPanel.setLayout(new CardLayout(0, 0));
		add(OutsideBorderPanel);
	}
	
	public void mouseAction(JButton selectedButton) {
		selectedButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				selectedButton.setForeground(Color.YELLOW);
			}
		});
		selectedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedButton.setForeground(Color.RED);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				selectedButton.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectedButton.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {	
				if(selectedButton.equals(btnIncreaseQty))
					currentQty++;
				else if(selectedButton.equals(btnDecreaseQty) && currentQty != 1)
					currentQty--;
				else if(selectedButton.equals(btnNext)) {
					if(currentSchedule < MovieScheduleList.size()-1)
						currentSchedule++;
				}
				else if(selectedButton.equals(btnBack)) {
					if(currentSchedule != 0) 
						currentSchedule--;
				}
				else if(selectedButton.equals(btnPurchase)) {
					
					if(checkMembershipDB()) {
							String strPayment = txtPayment.getText();
							String strPrice = lblPrice.getText();
							if(Double.parseDouble(strPayment) >= 
									Double.parseDouble(strPrice.substring(0, strPrice.length() -1 ))) {
								YourRetun = (Double.parseDouble(strPayment) 
						 				- Double.parseDouble(strPrice.substring(0, strPrice.length() -1 )));
								 JOptionPane.showMessageDialog(null, 
										 		"Payment Completed! \n Your Return: " + YourRetun
										 		, "Confirmation Box", JOptionPane.INFORMATION_MESSAGE);
								 inputSaleDB();
								 setVisible(false);
								 updateDB();
							}else {
								 JOptionPane.showMessageDialog(null, 
									 		"Not enough money"
									 		, "Confirmation Box", JOptionPane.INFORMATION_MESSAGE);
							}
					}else {
						 JOptionPane.showMessageDialog(null, 
							 		"Invalid ID"
							 		, "Confirmation Box", JOptionPane.INFORMATION_MESSAGE);
					}
				}
					
				
				lblQty.setText("   " + currentQty + "   ");
				lblAvailableSeat.setText(MovieScheduleList.get(currentSchedule).getRemainSeatAvailable() + "");
				lblPrice.setText(MovieScheduleList.get(currentSchedule).getTicketprice() * currentQty + "$");
				lblSchedule.setText(MovieScheduleList.get(currentSchedule).getTimeStart());
			}
		});
	}

	public void retrieveScheduleDB() {
		Connection cnn = null;
	    Statement stm;
		ResultSet rss;
		
		 try {
	      		
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");
			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tbschedule;");
			    	
			    	while(rss.next()) {
			    		if(rss.getString("MovieID").equals(movie.getId())) {
			    		MovieSchedule schedule = new MovieSchedule();
			    		
			    		schedule.setId(rss.getString("ScheduleID"));
			    		schedule.setMovieID(rss.getString("MovieID"));
			    		schedule.setTimeStart(rss.getString("TimeStart"));
			    		schedule.setHall(rss.getInt("Hall"));
			    		schedule.setTicketprice(rss.getDouble("TicketPrice"));
			    		schedule.setScheduleDate(rss.getString("ScheduleDate"));
			    		schedule.setTotalSeat(rss.getInt("TotalSeat"));
			    		schedule.setRemainSeatAvailable(rss.getInt("AvailableSeat"));
			    		
			    		MovieScheduleList.add(schedule);
			    		}
			    	}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						cnn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}

	public boolean checkMembershipDB() {
		Connection cnn = null;
	    Statement stm;
		ResultSet rss;
		
		 try {
	      		
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");
			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tbmembership;");
			    	
			    	while(rss.next()) {
			    		if(rss.getString("MembershipID").equals(txtCustomerID.getText())) {
			    			cnn.close();
			    			return true;
			    		}
			    	}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						cnn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		 return false;
	}
	
	public void inputSaleDB() {
		Connection cnn = null;
		Statement stm;
	    PreparedStatement prepStm;
		ResultSet rss;
		
		 try {
	      	int count = 0;
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");
			 stm = cnn.createStatement();
			 ResultSet res = stm.executeQuery("SELECT COUNT(*) FROM tbSale");
              while (res.next()){
                  count = res.getInt(1);
              }
			 
			 prepStm = cnn.prepareStatement("INSERT INTO tbSale Value(?,?,?,?,?,?,?,?,?,?)");
			 
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
			 if(count < 10)
				 prepStm.setString(1, "Sale00" + ++count);
			 else if(count < 100)
				 prepStm.setString(1, "Sale0" + ++count);
			 prepStm.setString(2, MovieScheduleList.get(currentSchedule).getId());
			 prepStm.setString(3, SaleByNowShowing.currentUser.getId());
			 prepStm.setString(4, txtCustomerID.getText());
			 prepStm.setString(5, sdf.format(date));
			 prepStm.setString(6, time.format(cal.getTime()));
			 prepStm.setInt(7, currentQty);
			 prepStm.setDouble(8, MovieScheduleList.get(currentSchedule).getTicketprice() * currentQty);
			 prepStm.setDouble(9, Double.parseDouble(txtPayment.getText()));
			 prepStm.setDouble(10, YourRetun);
			 
			 prepStm.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						cnn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}

	public void updateDB() {
	
		Connection cnn = null;
	    PreparedStatement prepStm;
		ResultSet rss;

		 try {
	      	int count = 0;
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");			 
			 prepStm = cnn.prepareStatement("UPDATE tbSchedule SET AvailableSeat = ? WHERE ScheduleID = ?");
			 
			 prepStm.setInt(1, Integer.parseInt(lblAvailableSeat.getText()) - currentQty); 
			 prepStm.setString(2, MovieScheduleList.get(currentSchedule).getId());
			 
			 prepStm.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						cnn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	

	}
}
