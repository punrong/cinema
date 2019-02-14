package rupp.cinema;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;



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
	
	private JButton btnIncreaseQty;
	private JButton btnDecreaseQty;
	private JButton btnPurchase;
	
	private JLabel lblID;
	private JLabel lblTitle;
	private JLabel lblDirector;
	private JLabel lblReleaseDate;
	private JLabel lblDuration;
	private JLabel lblGenre;
	private JLabel lblPrice;
	
	private int currentQty = 1;
	
	public static void main(String[] args) {
			new SaleByNowShowing(movie);
	}

	public SaleByNowShowing(Movie movie) {
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
		grdMovieDetail.setBounds(265, 16, 284, 216);
		getContentPane().add(grdMovieDetail);
		grdMovieDetail.setLayout(new GridLayout(0, 2, 0, 0));
		
		grdMovieDetail.add(new JLabel("ID"));
		lblID = new JLabel();
		lblID.setText(movie.getID());
		grdMovieDetail.add(lblID);
		
		grdMovieDetail.add(new JLabel("Title"));
		lblTitle = new JLabel();
		lblTitle.setText(movie.getTitle());
		grdMovieDetail.add(lblTitle);

		grdMovieDetail.add(new JLabel("Director"));
		lblDirector = new JLabel();
		lblDirector.setText(movie.getDirector());
		grdMovieDetail.add(lblDirector);
		
		grdMovieDetail.add(new JLabel("Release Date"));
		lblReleaseDate = new JLabel();
		lblReleaseDate.setText(movie.getReleaseDate());
		grdMovieDetail.add(lblReleaseDate);
		
		grdMovieDetail.add(new JLabel("Duration"));
		lblDuration = new JLabel();
		lblDuration.setText(movie.getDuration());
		grdMovieDetail.add(lblDuration);
		
		grdMovieDetail.add(new JLabel("Genre"));
		lblGenre = new JLabel();
		lblGenre.setText(movie.getGenre());
		grdMovieDetail.add(lblGenre);
		
		grdMovieDetail.add(new JLabel("Price"));
		lblPrice = new JLabel();
		lblPrice.setText( movie.getPrice() + "$");
		grdMovieDetail.add(lblPrice);

		grdMovieDetail.add(new JLabel(""));
		grdMovieDetail.add(new JLabel(""));
		
		grdMovieDetail.add(new JLabel(""));
		btnPurchase = new JButton("Purchase");
		grdMovieDetail.add(btnPurchase);
		
		OutsideBorderPanel = new JPanel();
		OutsideBorderPanel.setBackground(Color.WHITE);
		OutsideBorderPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		OutsideBorderPanel.setBounds(10, 11, 576, 292);
		OutsideBorderPanel.setLayout(new CardLayout(0, 0));
		getContentPane().add(OutsideBorderPanel);
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
				lblPrice.setText( movie.getPrice() * currentQty + "$");
			}
		});
	}
	
}
