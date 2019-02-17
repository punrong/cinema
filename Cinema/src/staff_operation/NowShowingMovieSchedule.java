package staff_operation;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import sql_java_class.Employee;
import sql_java_class.Movie;
import sql_java_class.Sale;
import sql_java_class.Schedule;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


public class NowShowingMovieSchedule extends JFrame {

	private int xx, yy;
	private static Movie movie = new Movie();
	private static Employee currentUser = new Employee();
	private Sale sale = new Sale();
	private static ReportPage reportPage = new ReportPage(currentUser);
	
	private JPanel CardImagePanel ;
	private JLabel imageIcon;
	
	private JPanel QtyPanel;
	private JLabel lblQty;
	
	private JLabel lblClose;
	private JPanel grdMovieDetail;
	private JPanel OutsideBorderPanel;
	
	private JPanel schedulePanel;
	private JButton btnNextSchedule;
	private JButton btnPrevSchedule;
	
	private JButton btnIncreaseQty;
	private JButton btnDecreaseQty;
	private JButton btnPurchase;
	
	private JLabel lblMovieID;
	private JLabel lblScheduleID;
	private JLabel lblStartingTime;
	private JLabel lblHall;
	private JLabel lblAvailableSeat;
	private JLabel lblTotalSeat;
	private JLabel lblPrice;
	
	private int currentQty = 1;
	private int currentScheduleIndex = 0;
	
	private ArrayList<Schedule> ScheduleMovieList;
	private JLabel lblPayment;
	private JTextField txtPayment;
	private JTextField txtMemberID;
	
	private JCheckBox chckbxMember;
	
	public static void main(String[] args) {
			new NowShowingMovieSchedule(movie, currentUser, reportPage);
	}

	public NowShowingMovieSchedule(Movie movie, Employee currentUser, ReportPage reportPage) {
		getContentPane().setBackground(Color.WHITE);
		NowShowingMovieSchedule.movie = movie;
		NowShowingMovieSchedule.currentUser = currentUser;
		NowShowingMovieSchedule.reportPage = reportPage;
		setBackground(Color.WHITE);
		initialization();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 314);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);	
	}
	
	public void initialization() {
		accessDatabase();
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
				NowShowingMovieSchedule.this.setLocation(x - xx, y - yy);
			}
		});
		
		CardImagePanel = new JPanel();
		CardImagePanel.setBackground(Color.WHITE);
		CardImagePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		CardImagePanel.setBounds(32, 16, 212, 223);
		getContentPane().add(CardImagePanel);
		CardImagePanel.setLayout(new CardLayout(0, 0));
		
		imageIcon = new JLabel("");
		imageIcon.setIcon(new ImageIcon("resource/" + movie.getTitle() + ".jpg"));
		CardImagePanel.add(imageIcon);
		
		QtyPanel = new JPanel();
		QtyPanel.setBackground(Color.WHITE);
		QtyPanel.setBounds(32, 245, 207, 35);
		getContentPane().add(QtyPanel);
		
		QtyPanel.add(new JLabel("Quantity"), Color.WHITE);
		
		btnDecreaseQty = new JButton("-");
		btnDecreaseQty.setForeground(Color.WHITE);
		btnDecreaseQty.setBackground(Color.LIGHT_GRAY);
		QtyPanel.add(btnDecreaseQty);
		mouseAction(btnDecreaseQty);
		
		lblQty = new JLabel();
		lblQty.setText("   " + currentQty + "   ");
		lblQty.setHorizontalAlignment(SwingConstants.CENTER);
		QtyPanel.add(lblQty);
		
		btnIncreaseQty = new JButton("+");
		btnIncreaseQty.setForeground(Color.WHITE);
		btnIncreaseQty.setBackground(Color.LIGHT_GRAY);
		QtyPanel.add(btnIncreaseQty);
		mouseAction(btnIncreaseQty);
		
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
		getContentPane().add(lblClose);
	
		grdMovieDetail = new JPanel();
		grdMovieDetail.setBackground(Color.WHITE);
		grdMovieDetail.setBounds(265, 16, 284, 264);
		getContentPane().add(grdMovieDetail);
		grdMovieDetail.setLayout(new GridLayout(0, 2, 0, 0));
		
		grdMovieDetail.add(new JLabel("Schedule ID"));
		lblScheduleID = new JLabel();
		lblScheduleID.setText(ScheduleMovieList.get(currentScheduleIndex).getID());
		grdMovieDetail.add(lblScheduleID);
		
		grdMovieDetail.add(new JLabel("Movie ID"));
		lblMovieID = new JLabel();
		lblMovieID.setText(ScheduleMovieList.get(currentScheduleIndex).getMovieID());
		grdMovieDetail.add(lblMovieID);
		
		chckbxMember = new JCheckBox("Member");
		chckbxMember.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxMember.setBackground(Color.WHITE);
		grdMovieDetail.add(chckbxMember);
		
		txtMemberID = new JTextField();
		txtMemberID.setEditable(false);
		txtMemberID.setText("C000");
		grdMovieDetail.add(txtMemberID);
		txtMemberID.setColumns(10);
		
		chckbxMember.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	txtMemberID.setEditable(true);
		        	txtMemberID.setText("");
		        } else {
		        	txtMemberID.setEditable(false);
		        	txtMemberID.setText("C000");
		        };
		    }
		});
		
		grdMovieDetail.add(new JLabel("Starting Time"));
		lblStartingTime = new JLabel();
		lblStartingTime.setText(ScheduleMovieList.get(currentScheduleIndex).getStartingTime());
		lblStartingTime.setHorizontalAlignment(JLabel.CENTER);
		
		btnNextSchedule = new JButton();
		btnNextSchedule.setBackground(Color.LIGHT_GRAY);
		btnNextSchedule.setForeground(Color.WHITE);
		btnNextSchedule.setText(">");
		mouseAction(btnNextSchedule);
		
		btnPrevSchedule = new JButton();
		btnPrevSchedule.setBackground(Color.LIGHT_GRAY);
		btnPrevSchedule.setForeground(Color.WHITE);
		btnPrevSchedule.setText("<");
		mouseAction(btnPrevSchedule);
		
		schedulePanel = new JPanel();
		schedulePanel.setLayout(new BorderLayout(0,0));
		schedulePanel.setBackground(Color.WHITE);
		
		schedulePanel.add(btnPrevSchedule,BorderLayout.WEST);
		schedulePanel.add(lblStartingTime , BorderLayout.CENTER);
		schedulePanel.add(btnNextSchedule, BorderLayout.EAST);
		
		grdMovieDetail.add(schedulePanel);
		
		grdMovieDetail.add(new JLabel("Hall"));
		lblHall = new JLabel();
		lblHall.setText(""+ScheduleMovieList.get(currentScheduleIndex).getHall());
		grdMovieDetail.add(lblHall);
		
		grdMovieDetail.add(new JLabel("Available Seat"));
		lblAvailableSeat = new JLabel();
		lblAvailableSeat.setText(""+ScheduleMovieList.get(currentScheduleIndex).getAvailableSeat());
		grdMovieDetail.add(lblAvailableSeat);
		
		grdMovieDetail.add(new JLabel("Total Seat"));
		lblTotalSeat = new JLabel();
		lblTotalSeat.setText(""+ScheduleMovieList.get(currentScheduleIndex).getTotalSeat());
		grdMovieDetail.add(lblTotalSeat);
		
		grdMovieDetail.add(new JLabel("Price"));
		lblPrice = new JLabel();
		lblPrice.setText( movie.getPrice() + "$");
		grdMovieDetail.add(lblPrice);
		
		lblPayment = new JLabel("Payment");
		grdMovieDetail.add(lblPayment);
		
		txtPayment = new JTextField();
		grdMovieDetail.add(txtPayment);
		txtPayment.setColumns(10);
		
		grdMovieDetail.add(new JLabel(""));
		grdMovieDetail.add(new JLabel(""));
		
		grdMovieDetail.add(new JLabel(""));
		btnPurchase = new JButton("Purchase");
		mouseAction(btnPurchase);
		grdMovieDetail.add(btnPurchase);
		
		OutsideBorderPanel = new JPanel();
		OutsideBorderPanel.setBackground(Color.WHITE);
		OutsideBorderPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		OutsideBorderPanel.setBounds(10, 11, 576, 292);
		OutsideBorderPanel.setLayout(new CardLayout(0, 0));
		getContentPane().add(OutsideBorderPanel);
	}
	
	public void accessDatabase() {
		
		ScheduleMovieList = new ArrayList<Schedule>();
		Connection cnn = null;
	    Statement stm;
		ResultSet rss;
		
		 try {
	      		
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tblschedule;");
			    	while(rss.next()) {
			    		Schedule schedule = new Schedule();
			    		
			    		schedule.setID(rss.getString("ID"));
			    		schedule.setMovieID(rss.getString("MovieID"));
			    		schedule.setStartingTime(rss.getString("StartingTime"));
			    		schedule.setHall(rss.getInt("Hall"));
			    		schedule.setTotalSeat(rss.getInt("TotalSeat"));
			    		schedule.setAvailableSeat(rss.getInt("AvailableSeat"));
			    		
			    		if(schedule.getMovieID().equals(NowShowingMovieSchedule.movie.getID()))
			    			ScheduleMovieList.add(schedule);
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
				if(selectedButton.equals(btnIncreaseQty)) {
					currentQty++;
					lblQty.setText("   " + currentQty + "   ");
					lblPrice.setText( movie.getPrice() * currentQty + "$");
				}
				
				else if(selectedButton.equals(btnDecreaseQty) && currentQty != 1) {
					currentQty--;
					lblQty.setText("   " + currentQty + "   ");
					lblPrice.setText( movie.getPrice() * currentQty + "$");
				}
				else if(selectedButton.equals(btnNextSchedule) && currentScheduleIndex != ScheduleMovieList.size()-1) {
					lblStartingTime.setText(ScheduleMovieList.get(++currentScheduleIndex).getStartingTime());
					lblScheduleID.setText(ScheduleMovieList.get(currentScheduleIndex).getID());
					lblHall.setText(ScheduleMovieList.get(currentScheduleIndex).getHall()+"");
					lblAvailableSeat.setText(ScheduleMovieList.get(currentScheduleIndex).getAvailableSeat()+"");
					lblTotalSeat.setText(ScheduleMovieList.get(currentScheduleIndex).getTotalSeat()+"");
				}
				
				else if(selectedButton.equals(btnPrevSchedule) && currentScheduleIndex != 0) { 
					lblStartingTime.setText(ScheduleMovieList.get(--currentScheduleIndex).getStartingTime());
					lblScheduleID.setText(ScheduleMovieList.get(currentScheduleIndex).getID());
					lblHall.setText(ScheduleMovieList.get(currentScheduleIndex).getHall()+"");
					lblAvailableSeat.setText(ScheduleMovieList.get(currentScheduleIndex).getAvailableSeat()+"");
					lblTotalSeat.setText(ScheduleMovieList.get(currentScheduleIndex).getTotalSeat()+"");
				}
				
				else if(selectedButton.equals(btnPurchase)) {
					
					Connection cnn = null;
					
					 try {
				      		
						 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
						   
						 PreparedStatement st = cnn.prepareStatement("UPDATE  tblschedule Set AvailableSeat = ? Where ID =? ");
						 st.setInt(1,ScheduleMovieList.get(currentScheduleIndex).getAvailableSeat() - currentQty);
						 st.setString(2,ScheduleMovieList.get(currentScheduleIndex).getID());
						 st.executeUpdate();
						 
						 Statement  stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
								   ResultSet.CONCUR_UPDATABLE);
						 ResultSet  	rss = stm.executeQuery("SELECT * FROM tblSale ORDER BY TIME DESC LIMIT 1;");
						 String id = "1";
						 if(rss.next() == true) {
							 id = rss.getString("ID").substring(4);
							 id = Integer.parseInt(id) + 1 +"";
							 
							 }
						
							chckbxMember.addItemListener(new ItemListener() {
							    @Override
							    public void itemStateChanged(ItemEvent e) {
							        if(e.getStateChange() == ItemEvent.SELECTED) {
							        	txtMemberID.setEditable(true);
							        	txtMemberID.setText("");
							        } else {
							        	txtMemberID.setEditable(false);
							        	txtMemberID.setText("C000");
							        };
							    }
							});
						 
						 if(Double.parseDouble(txtPayment.getText()) >= movie.getPrice() * currentQty && !txtMemberID.getText().isEmpty()) {
							 PreparedStatement preparedStmt = cnn.prepareStatement(" INSERT into tblsale "
								 		+ "(ID, ScheduleID, EmployeeID, MemberID, Date, Time, TotalAmount, TotalPrice, Payment, YourReturn) "
									        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
								
							 	 sale.setID("Sale"+ id);
								 sale.setScheduleID(ScheduleMovieList.get(currentScheduleIndex).getID());
								 sale.setEmployeeID(NowShowingMovieSchedule.currentUser.getID());
								 sale.setMemberID(txtMemberID.getText());
								 sale.setTotalAmount(currentQty);
								 sale.setTotalPrice(movie.getPrice() * currentQty);
								 sale.setPayment(Double.parseDouble(txtPayment.getText()));
								 sale.setChange(Double.parseDouble(txtPayment.getText()) - movie.getPrice() * currentQty);
								 
								 preparedStmt.setString(1, sale.getID());
								 preparedStmt.setString(2, sale.getScheduleID());
								 preparedStmt.setString(3, sale.getEmployeeID());
								 preparedStmt.setString(4, sale.getMemberID());
								
								 Timestamp date = new Timestamp(new java.util.Date().getTime());
								 preparedStmt.setTimestamp(5, date);
								 preparedStmt.setTimestamp(6, date);
	
								 preparedStmt.setInt(7, sale.getTotalAmount());
								 preparedStmt.setDouble(8, sale.getTotalPrice());
								 preparedStmt.setDouble(9, sale.getPayment());
								 preparedStmt.setDouble(10, sale.getYourReturn());
								 
								 preparedStmt.execute();
								 
								 setVisible(false);
								 JOptionPane.showMessageDialog(null,"Purchase Successfully\n" + "Please take your change : " + sale.getYourReturn() + "$");
								 
						 }
						 else if(txtMemberID.getText().isEmpty()){
							JOptionPane.showMessageDialog(null,"Please enter your Member ID\n");
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Not enough payment\n"); 
						 }
							} catch (SQLException e1) {
								e1.printStackTrace();
							} finally {
								try {
									cnn.close();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
				}
			}
		});
	}
}
