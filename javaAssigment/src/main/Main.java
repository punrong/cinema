package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;

import managerOperation.detailViewMovie;
import managerOperation.loginManager;
import managerOperation.passwordVerify;
import modelClass.Movie;
import sqlCommand.MoviePart;
import sqlCommand.SchedulePart;
import staffOperation.SignIn;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.LayoutManager;

public class Main extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel menu;
	private JPanel menulist, loginManagers, loginStaff, exit;
	public int count=0;
	public static loginManager frame;
	public static passwordVerify frame2;
	public static detailViewMovie frameM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 52, 1680, 379);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		menulist = new JPanel();
		menulist.setVisible(false);
		menulist.setBounds(0, 0, 195, 125);
		panel_1.add(menulist);
		menulist.setLayout(null);
		
		loginManagers = new JPanel();
		loginManagers.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginManagers.setBounds(0, 0, 195, 42);
		menulist.add(loginManagers);
		loginManagers.setLayout(null);
		loginManagers.addMouseListener(this);
		
		JLabel lblNewLabel = new JLabel("Login As Manager");
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(13, 10, 149, 23);
		loginManagers.add(lblNewLabel);
		
		loginStaff = new JPanel();
		loginStaff.setLayout(null);
		loginStaff.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginStaff.setBounds(0, 41, 195, 42);
		menulist.add(loginStaff);
		loginStaff.addMouseListener(this);
		
		JLabel lblLoginAsStaff = new JLabel("Login As Staff");
		lblLoginAsStaff.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLoginAsStaff.setBounds(13, 10, 149, 23);
		loginStaff.add(lblLoginAsStaff);
		
		exit = new JPanel();
		exit.setLayout(null);
		exit.setBorder(new LineBorder(new Color(0, 0, 0)));
		exit.setBounds(0, 82, 195, 43);
		menulist.add(exit);
		exit.addMouseListener(this);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblExit.setBounds(13, 10, 149, 23);
		exit.add(lblExit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images/cinema.gif"));
		label_1.setBounds(0, 0, 676, 379);
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/c1.jpg"));
		label.setBounds(676, 0, 690, 379);
		panel_1.add(label);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("images/keyboard-right-arrow-button copy.png"));
		label_3.setBounds(22, 185, 30, 16);
		panel_1.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/keyboard-right-arrow-button.png"));
		lblNewLabel_1.setBounds(1645, 185, 30, 27);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("images/keyboard-right-arrow-button.png"));
		label_2.setBounds(22, 223, -39, 33);
		panel_1.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1690, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		menu = new JLabel("");
		menu.setBounds(16, 10, 30, 32);
		menu.setIcon(new ImageIcon("images/menu (1).png"));
		panel.add(menu);
		menu.addMouseListener(this);
		
		JLabel lblPhnomPenhCinema = new JLabel("Phnom Penh Cinema");
		lblPhnomPenhCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnomPenhCinema.setForeground(Color.WHITE);
		lblPhnomPenhCinema.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblPhnomPenhCinema.setBounds(0, 6, 1365, 36);
		panel.add(lblPhnomPenhCinema);
		
		JLabel lblNowShowing = new JLabel("Now Showing");
		lblNowShowing.setBackground(Color.WHITE);
		lblNowShowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblNowShowing.setFont(new Font("Arial Unicode MS", Font.PLAIN, 19));
		lblNowShowing.setBounds(0, 432, 1366, 37);
		contentPane.add(lblNowShowing);
		
		
		//show movie
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 596, 1680, 454);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 471, 1366, 291);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(panel_6);
		
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		MoviePart mP = new MoviePart();
		List<Movie> ss = mP.getFromTableMovie();
		if(ss.size() > 0)
		{
			int size = ss.size();
			if(size % 5 == 0)
			{
				int row = size / 5;
				panel_6.setLayout(new GridLayout(row, 5, 0, 0));
			}
			else 
			{
				int row = (size /5) +1;
				panel_6.setLayout(new GridLayout(row, 5, 0, 0));
			}
			
			for(Movie mp : ss) {
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.WHITE);
				panel_6.add(panel_2);
				
				JPanel m = new JPanel(new BorderLayout());
				JLabel pic = new JLabel();
				pic.setIcon(new ImageIcon(mp.getImage()));
				pic.setPreferredSize(new Dimension(250,350));
				
				JLabel title = new JLabel(mp.getName());
				title.setOpaque(true);
				title.setBackground(Color.WHITE);
				title.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
				title.setHorizontalAlignment(SwingConstants.CENTER);
				m.add(pic, BorderLayout.CENTER);
				m.add(title, BorderLayout.SOUTH);
				
				panel_2.add(m);
				
				m.addMouseListener(new MouseListener() {
					
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
						frameM = new detailViewMovie(mp, 0);
						frameM.setVisible(true);
					}
				});
			}
		}
		
		///////////////////////end show movie////////////////////////////////
		
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1366,768);
		//setExtendedState(MAXIMIZED_BOTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == menu)
		{
			if(count == 1) {
				menulist.setVisible(false);
				count = 0;
			}
			else if(count == 0)
			{
				count = 1;
				menulist.setVisible(true);
			}
		}
		else if(e.getSource() == loginManagers)
		{
			menulist.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new loginManager();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(e.getSource() == loginStaff)
		{
			menulist.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						(new SignIn()).setVisible(true);;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(e.getSource() == exit)
		{
			
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
