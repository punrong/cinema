package staff_operation;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import sql_java_class.Employee;
import sql_java_class.Movie;

import java.awt.event.*;

public class NowShowingPage {

	private JPanel GrandParentNowShowingPanel;
	private JPanel ParentNowShowingPanel;
	private JPanel grdNowShowingPanel;
	private ArrayList<JPanel>  NowShowingPanelList;
	private ArrayList<JLabel>  NowShowingImageIconList;
	private ArrayList<ImageIcon> NowShowingMovieImage;
	private int currentIndexOfNowShowingMovieList = 0;
	private ArrayList<Movie> NowShowingMovieList;	
	private ArrayList<NowShowingMovieSchedule> SaleBy = new ArrayList<NowShowingMovieSchedule>();
	private static Employee currentUser = new Employee();
	
	public JPanel getGrandParentNowShowingPanel() {
		return this.GrandParentNowShowingPanel;
	}
	
	public NowShowingPage(Employee currentUser) {
		NowShowingPage.currentUser = currentUser;
		initialization();
		
		GrandParentNowShowingPanel = new JPanel();
		GrandParentNowShowingPanel.setBackground(Color.WHITE);
		GrandParentNowShowingPanel.setLayout(new BorderLayout(0, 0));
		
		ParentNowShowingPanel = new JPanel();
		ParentNowShowingPanel.setBackground(Color.WHITE);
		GrandParentNowShowingPanel.add(ParentNowShowingPanel, BorderLayout.CENTER);
		ParentNowShowingPanel.setLayout(new BorderLayout(0, 0));
		
		int numOfColumn;
		if(NowShowingMovieList.size() % 2 == 0)
			numOfColumn = NowShowingMovieList.size()/2;
		else 
			numOfColumn = NowShowingMovieList.size()/2 +1;
		
		grdNowShowingPanel = new JPanel();
		grdNowShowingPanel.setBackground(Color.WHITE);
		ParentNowShowingPanel.add(grdNowShowingPanel, BorderLayout.NORTH);
		grdNowShowingPanel.setLayout(new GridLayout(0,numOfColumn, 0, 0));
		
		for(int i = 0 ; i < NowShowingPanelList.size(); i++)
			grdNowShowingPanel.add(NowShowingPanelList.get(i));	
	}
	
public void initialization() {
		
		NowShowingMovieImage = new ArrayList<ImageIcon>();
		NowShowingPanelList = new ArrayList<JPanel>();
		NowShowingImageIconList = new ArrayList<JLabel>();
		NowShowingMovieList = new ArrayList<Movie>();
		
		Connection cnn = null;
	    Statement stm;
		ResultSet rss;
		
		 try {
	      		
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tblNowShowingMovie;");
			    	while(rss.next()) {
			    		Movie movie = new Movie();
			    		
			    		movie.setID(rss.getString("ID"));
			    		movie.setTitle(rss.getString("Title"));
			    		movie.setDirector(rss.getString("Director"));
			    		movie.setReleaseDate(rss.getString("ReleaseDate"));
			    		movie.setDuration(rss.getString("Duration"));
			    		movie.setGenre(rss.getString("Genre"));
			    		movie.setPrice(rss.getDouble("Price"));
			    		
			    		NowShowingMovieList.add(movie);
			    		NowShowingMovieImage.add(new ImageIcon("resource/" + movie.getTitle() + ".jpg"));
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
		
		for(int i = 0; i < NowShowingMovieList.size() ; i++) {			
			NowShowingPanelList.add(new JPanel());		
			NowShowingImageIconList.add(new JLabel(""));
			NowShowingPanelList.get(i).setBackground(Color.WHITE);
			inputMovie(NowShowingPanelList.get(i),  NowShowingImageIconList.get(i), NowShowingMovieImage,
					NowShowingMovieList.get(i), currentIndexOfNowShowingMovieList++);
		}
	}

	public void inputMovie(JPanel MainCardPanel, JLabel lblImageIcon, ArrayList<ImageIcon> movieList, Movie movie, int  index) {		
		MainCardPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MainCardPanel.setBackground(Color.WHITE);
		MainCardPanel.setLayout(new CardLayout(5, 5));
		lblImageIcon.setIcon(movieList.get(index));
		lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);		
		MainCardPanel.add(lblImageIcon);
		mouseAction(MainCardPanel, movie, lblImageIcon, movieList, index);
	}
	
	public void mouseAction(JPanel selectedPanel, Movie movie, JLabel lblImageIcon, ArrayList<ImageIcon> movieList, int  index) {
		selectedPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				selectedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 250, 250)));
				selectedPanel.setBackground(Color.GRAY);
				selectedPanel.setLayout(new CardLayout(5, 5));
				lblImageIcon.setVisible(false);
				
				JLabel lblmovieDetail =new JLabel("<html>"
						+ "ID: " + movie.getID()
						+ "<br/>"
						+ "<br/>"
						+ "Title: " + movie.getTitle()
						+ "<br/>"
						+ "<br/>"
						+ "Director: " + movie.getDirector()
						+ "<br/>"
						+ "<br/>"
						+ "Release Date: " + movie.getReleaseDate()
						+ "<br/>"
						+ "<br/>"
						+ "Duration: " + movie.getDuration()
						+ "<br/>"
						+ "<br/>"
						+ "Genre: " + movie.getGenre()
						+ "<br/>"
						+ "<br/>"
						+ "Unit Price: " + movie.getPrice()
						+ "</html>");
				lblmovieDetail.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
				lblmovieDetail.setForeground(Color.WHITE);
				
				selectedPanel.add(lblmovieDetail,SwingConstants.CENTER);
			}
		});
		selectedPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				selectedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				selectedPanel.setBackground(Color.WHITE);
				selectedPanel.setLayout(new CardLayout(5, 5));
				selectedPanel.removeAll();
				lblImageIcon.setIcon(movieList.get(index));
				lblImageIcon.setVisible(true);
				lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);		
				selectedPanel.add(lblImageIcon);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleBy.add(new NowShowingMovieSchedule(movie, NowShowingPage.currentUser));
				if(SaleBy.size() > 1) {
					SaleBy.get(SaleBy.size()-2).setVisible(false);
				}
				SaleBy.get(SaleBy.size()-1).setVisible(true);
			}
		});
	}
}
