package rupp.cinema;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class SalePage {

	private JPanel GrandParentSalePanel;
	private JPanel imagePanel;
	private JPanel CardImagePanel;
	private JPanel ParentSalePanel;
	private JPanel gridSalePanel;
	private JPanel MovieDetailPanel;
	private JPanel emptySpaceLeft;
	private JPanel qtyPanel;
	
	private JLabel image;
	private JLabel lblQty;
	private JLabel lblMovieTitle = new JLabel();
	private JComboBox<String> cboMovieID;
	private JLabel lblMovieDirector = new JLabel();
	private JLabel lblReleaseDate = new JLabel();
	private JLabel lblGenre = new JLabel();
	private JLabel lblDuration = new JLabel();
	private JLabel lblPrice = new JLabel();
	
	private ArrayList<Movie> SaleMovieList;
	
	private JButton btnIncreaseQty;
	private JButton btnDecreaseQty;
	
	private int currentQty = 1;
	private static int currentIndex = 0;
	
	public JPanel getEmptySpaceLeft() {
		return this.emptySpaceLeft;
	}
	
	public JPanel getMainPanel() {
		return this.GrandParentSalePanel;
	}
	
	public SalePage() {
		initialization();
		GrandParentSalePanel = new JPanel();
		GrandParentSalePanel.setVisible(true);
		GrandParentSalePanel.setBackground(Color.WHITE);
		GrandParentSalePanel.setLayout(new BorderLayout(0,0));
		
		imagePanel = new JPanel();
		imagePanel.setVisible(true);
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setLayout(new BorderLayout(0,0));
		
		ParentSalePanel = new JPanel();
		ParentSalePanel.setVisible(true);
		ParentSalePanel.setBackground(Color.WHITE);
		ParentSalePanel.setLayout(new BorderLayout(0,0));
		
		gridSalePanel = new JPanel();
		gridSalePanel.setVisible(true);
		gridSalePanel.setBackground(Color.WHITE);
		gridSalePanel.setLayout(new GridLayout(0,4,0,0));
		
		gridSalePanel.add(new JLabel("        Movie ID"));
		gridSalePanel.add(cboMovieID);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblMovieTitle.setText(SaleMovieList.get(currentIndex).getTitle());
		gridSalePanel.add(new JLabel("        Movie Title"));
		gridSalePanel.add(lblMovieTitle);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblMovieDirector.setText(SaleMovieList.get(currentIndex).getDirector());
		gridSalePanel.add(new JLabel("        Movie Director"));
		gridSalePanel.add(lblMovieDirector);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblReleaseDate.setText(SaleMovieList.get(currentIndex).getReleaseDate());
		gridSalePanel.add(new JLabel("        Release Date"));
		gridSalePanel.add(lblReleaseDate);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblDuration.setText(SaleMovieList.get(currentIndex).getDuration());
		gridSalePanel.add(new JLabel("        Duration"));
		gridSalePanel.add(lblDuration);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblGenre.setText(SaleMovieList.get(currentIndex).getGenre());
		gridSalePanel.add(new JLabel("        Genre"));
		gridSalePanel.add(lblGenre);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		gridSalePanel.add(new JLabel("        Quantity"));
		gridSalePanel.add(qtyPanel);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		lblPrice.setText(SaleMovieList.get(currentIndex).getPrice() + "$");
		gridSalePanel.add(new JLabel("        Price"));
		gridSalePanel.add(lblPrice);
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JButton("Purchase"));
		gridSalePanel.add(new JLabel(""));
		gridSalePanel.add(new JLabel(""));
		
		MovieDetailPanel = new JPanel();
		MovieDetailPanel.setVisible(true);
		MovieDetailPanel.setBackground(Color.WHITE);
		MovieDetailPanel.setLayout(new BorderLayout(0,0));
		
		MovieDetailPanel.add(gridSalePanel, BorderLayout.NORTH);
		ParentSalePanel.add(MovieDetailPanel, BorderLayout.CENTER);
		GrandParentSalePanel.add(new JLabel("<html><br/><br/><br/><br/><br/><br/></html>"),BorderLayout.NORTH);
		imagePanel.add(CardImagePanel,BorderLayout.NORTH);
		GrandParentSalePanel.add(imagePanel, BorderLayout.WEST);
		GrandParentSalePanel.add(ParentSalePanel, BorderLayout.CENTER);
		
	}
	
	public void initialization() {

		SaleMovieList = new ArrayList<Movie>();
		cboMovieID = new JComboBox<String>();
		cboMovieID.setBackground(Color.WHITE);
		
		Connection cnn = null;
	    Statement stm;
		ResultSet rss;
		
		 try {
	      		
		   		cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");

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
			    		
			    		SaleMovieList.add(movie);
			    		cboMovieID.addItem(movie.getID());
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
		 
		cboMovieID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentQty = 1;
				currentIndex = cboMovieID.getSelectedIndex();
				lblMovieTitle.setText(SaleMovieList.get(currentIndex).getTitle());
				lblMovieDirector.setText(SaleMovieList.get(currentIndex).getDirector());
				lblReleaseDate.setText(SaleMovieList.get(currentIndex).getReleaseDate());
				lblDuration.setText(SaleMovieList.get(currentIndex).getDuration());
				lblGenre.setText(SaleMovieList.get(currentIndex).getGenre());
				CardImagePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), SaleMovieList.get(currentIndex).getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				image.setIcon(new ImageIcon("resource/" + SaleMovieList.get(currentIndex).getTitle() + ".jpg"));
				lblQty.setText("   " + currentQty + "   ");
				lblPrice.setText(SaleMovieList.get(currentIndex).getPrice() * currentQty + "$");
			}
			
		});
		 
		btnIncreaseQty = new JButton();
		btnIncreaseQty.setBackground(Color.LIGHT_GRAY);
		btnIncreaseQty.setForeground(Color.WHITE);
		btnIncreaseQty.setText("+");
		mouseAction(btnIncreaseQty);
		
		btnDecreaseQty = new JButton();
		btnDecreaseQty.setBackground(Color.LIGHT_GRAY);
		btnDecreaseQty.setForeground(Color.WHITE);
		btnDecreaseQty.setText("-");
		mouseAction(btnDecreaseQty);
		
		image = new JLabel();
		image.setIcon(new ImageIcon("resource/" + SaleMovieList.get(currentIndex).getTitle() + ".jpg"));
		lblQty = new JLabel();
		lblQty.setText("   " + currentQty + "   ");
		lblQty.setHorizontalAlignment(JLabel.CENTER);
		
		emptySpaceLeft = new JPanel();
		emptySpaceLeft.setBackground(Color.WHITE);
		emptySpaceLeft.add(new JLabel("                                                                                              "));
		
		qtyPanel = new JPanel();
		qtyPanel.setLayout(new BorderLayout(0,0));
		qtyPanel.setBackground(Color.WHITE);
		
		qtyPanel.add(btnDecreaseQty,BorderLayout.WEST);
		qtyPanel.add(lblQty , BorderLayout.CENTER);
		qtyPanel.add(btnIncreaseQty, BorderLayout.EAST);
		
		CardImagePanel = new JPanel();
		CardImagePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), SaleMovieList.get(currentIndex).getTitle(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		CardImagePanel.setBackground(Color.WHITE);
		CardImagePanel.setLayout(new CardLayout(5, 5));
		CardImagePanel.add(image);
		
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
				
				lblQty.setText("   " + currentQty + "   ");
				lblPrice.setText(SaleMovieList.get(currentIndex).getPrice() * currentQty + "$");
			}
		});
	}
}
