package staffOperation;

import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;

import modelClass.Employee;
import modelClass.Movie;

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
	private ArrayList<SaleByNowShowing> SaleBy = new ArrayList<SaleByNowShowing>();
	
	private static Employee currentUser;
	
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
		grdNowShowingPanel.setLayout(new GridLayout(2,numOfColumn, 0, 0));
		
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
	      		
			 cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "");
			   stm =cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					   ResultSet.CONCUR_UPDATABLE);
			    	rss = stm.executeQuery("SELECT * FROM tbMovie;");
			    	
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
			    	
			    	while(rss.next()) {
			    		if(sdf.format(date).compareTo(rss.getString("OpeningDate"))<0) {
			    		Movie movie = new Movie();
			    		
			    		movie.setId(rss.getString("MovieID"));
			    		movie.setName(rss.getString("MovieName"));
			    		movie.setDirector(rss.getString("Director"));
			    		movie.setOpeingDate(rss.getString("OpeningDate"));
			    		movie.setRunningTime(rss.getInt("RunningTime"));
			    		movie.setGenre(rss.getString("Genre"));
			    		movie.setLanguage(rss.getString("Language"));
			    		movie.setImage(rss.getString("Image"));
			    		
			    		NowShowingMovieList.add(movie);
			    		NowShowingMovieImage.add(new ImageIcon(movie.getImage()));
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
		
		for(int i = 0; i < NowShowingMovieList.size() ; i++) {			
			NowShowingPanelList.add(new JPanel());		
			NowShowingImageIconList.add(new JLabel(""));
			NowShowingPanelList.get(i).setBackground(Color.WHITE);
			inputMovie(NowShowingPanelList.get(i),  NowShowingImageIconList.get(i), NowShowingMovieImage,
					NowShowingMovieList.get(i), currentIndexOfNowShowingMovieList++);
		}
	}

	public void inputMovie(JPanel MainCardPanel, JLabel lblImageIcon, ArrayList<ImageIcon> movieList, Movie movie, int  index) {		
		MainCardPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getName(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MainCardPanel.setBackground(Color.WHITE);
		MainCardPanel.setLayout(new CardLayout(0, 0));
		MainCardPanel.setPreferredSize(new Dimension(250,250));
		lblImageIcon.setIcon(movieList.get(index));
		lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);		
		MainCardPanel.add(lblImageIcon);
		mouseAction(MainCardPanel, movie, lblImageIcon, movieList, index);
	}
	
	public void mouseAction(JPanel selectedPanel, Movie movie, JLabel lblImageIcon, ArrayList<ImageIcon> movieList, int  index) {
		selectedPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				selectedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),movie.getName(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 250, 250)));
				selectedPanel.setBackground(Color.GRAY);
				selectedPanel.setLayout(new CardLayout(0, 0));
				selectedPanel.setPreferredSize(new Dimension(250,250));
				lblImageIcon.setVisible(false);
				
				JLabel lblmovieDetail =new JLabel("<html>"
						+ "ID: " + movie.getId()
						+ "<br/>"
						+ "<br/>"
						+ "Title: " + movie.getName()
						+ "<br/>"
						+ "<br/>"
						+ "Director: " + movie.getDirector()
						+ "<br/>"
						+ "<br/>"
						+ "Release Date: " + movie.getOpeingDate()
						+ "<br/>"
						+ "<br/>"
						+ "Duration: " + movie.getRunningTime()
						+ "<br/>"
						+ "<br/>"
						+ "Genre: " + movie.getGenre()
						+ "<br/>"
						+ "<br/>"
						+ "Language: " + movie.getLanguage()
						+ "</html>");
				lblmovieDetail.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
				lblmovieDetail.setForeground(Color.WHITE);
				
				selectedPanel.add(lblmovieDetail,SwingConstants.CENTER);
			}
		});
		selectedPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				selectedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getName(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				selectedPanel.setBackground(Color.WHITE);
				selectedPanel.setLayout(new CardLayout(0, 0));
				selectedPanel.setPreferredSize(new Dimension(250,250));
				selectedPanel.removeAll();
				lblImageIcon.setIcon(movieList.get(index));
				lblImageIcon.setVisible(true);
				lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);		
				selectedPanel.add(lblImageIcon);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleBy.add(new SaleByNowShowing(movie, currentUser));
				if(SaleBy.size() > 1) {
					SaleBy.get(SaleBy.size()-2).setVisible(false);
				}
				SaleBy.get(SaleBy.size()-1).setVisible(true);
			}
		});
	}
}
