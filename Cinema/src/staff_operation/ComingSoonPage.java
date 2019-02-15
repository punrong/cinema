package staff_operation;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import sql_java_class.Movie;

public class ComingSoonPage {

	private JPanel GrandParentComingSoonPanel;
	private JPanel ParentComingSoonPanel;
	private JPanel grdComingSoonPanel;
	private ArrayList<JPanel>  ComingSoonPanelList;
	private ArrayList<JLabel> ComingSoonImageIconList;;
	private ArrayList<ImageIcon> ComingSoonMovieImage;
	private int currentIndexOfComingSoonMovieList = 0;
	private ArrayList<Movie> ComingSoonMovieList;
	
	public JPanel getGrandParentComingSoonPanel() {
		return this.GrandParentComingSoonPanel;
	}
	
	public ComingSoonPage() {
		initialization();
		GrandParentComingSoonPanel = new JPanel();
		GrandParentComingSoonPanel.setBackground(Color.WHITE);
		GrandParentComingSoonPanel.setLayout(new BorderLayout(0, 0));
		
		ParentComingSoonPanel = new JPanel();
		ParentComingSoonPanel.setBackground(Color.WHITE);
		GrandParentComingSoonPanel.add(ParentComingSoonPanel, BorderLayout.CENTER);
		ParentComingSoonPanel.setLayout(new BorderLayout(0, 0));
		
		
		int numOfColumn;
		if(ComingSoonMovieList.size() % 2 == 0)
			numOfColumn = ComingSoonMovieList.size()/2;
		else 
			numOfColumn = ComingSoonMovieList.size()/2 +1;
		
		grdComingSoonPanel = new JPanel();
		ParentComingSoonPanel.add(grdComingSoonPanel, BorderLayout.NORTH);
		grdComingSoonPanel.setLayout(new GridLayout(0, numOfColumn, 0, 0));
		
		for(int i = 0 ; i < ComingSoonPanelList.size(); i++)
			grdComingSoonPanel.add(ComingSoonPanelList.get(i));
	}
	
	public void initialization() {
		
		ComingSoonMovieImage = new ArrayList<ImageIcon>();
		ComingSoonPanelList = new ArrayList<JPanel>();	
		ComingSoonImageIconList = new ArrayList<JLabel>();
		ComingSoonMovieList = new ArrayList<Movie>();
		
		Connection cnn = null;
		Statement stm;
		ResultSet rss;
		
		try {
			cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
			
			stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			
			rss = stm.executeQuery("SELECT * FROM tblComingSoonMovie;");
			
			while(rss.next()) {
				Movie movie = new Movie();
				
				movie.setID(rss.getString("ID"));
	    		movie.setTitle(rss.getString("Title"));
	    		movie.setDirector(rss.getString("Director"));
	    		movie.setReleaseDate(rss.getString("ReleaseDate"));
	    		movie.setDuration(rss.getString("Duration"));
	    		movie.setGenre(rss.getString("Genre"));
	    		
	    		ComingSoonMovieList.add(movie);
	    		ComingSoonMovieImage.add(new ImageIcon("resource/" + movie.getTitle() + ".jpg"));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0 ; i < ComingSoonMovieList.size() ; i ++) {
			ComingSoonPanelList.add(new JPanel());
			ComingSoonImageIconList.add(new JLabel(""));
			ComingSoonImageIconList.get(i).setBackground(Color.WHITE);
			inputMovie(ComingSoonPanelList.get(i), ComingSoonImageIconList.get(i), ComingSoonMovieImage, 
					ComingSoonMovieList.get(i), currentIndexOfComingSoonMovieList++);
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
	
	public void mouseAction(JPanel thisPanel, Movie movie, JLabel lblImageIcon, ArrayList<ImageIcon> movieList, int  index) {
		thisPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				thisPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 250, 250)));
				thisPanel.setBackground(Color.GRAY);
				thisPanel.setLayout(new CardLayout(5, 5));
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
						+ "</html>");
				lblmovieDetail.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
				lblmovieDetail.setForeground(Color.WHITE);
				
				thisPanel.add(lblmovieDetail,SwingConstants.CENTER);
			}
		});
		thisPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				thisPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), movie.getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				thisPanel.setBackground(Color.WHITE);
				thisPanel.setLayout(new CardLayout(5, 5));
				thisPanel.removeAll();
				lblImageIcon.setIcon(movieList.get(index));
				lblImageIcon.setVisible(true);
				lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);		
				thisPanel.add(lblImageIcon);
			}
		});
	}

}
