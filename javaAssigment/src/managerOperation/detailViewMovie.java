package managerOperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.Main;
import modelClass.Movie;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

public class detailViewMovie extends JFrame {

	private JPanel contentPane;
	
	 public detailViewMovie(Movie m, int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
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
				if(i == 1) managerFunction.frame.setVisible(false);
				else if(i == 0) Main.frameM.setVisible(false);
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(204, 0, 0));
		label_1.setBounds(24, 66, 200, 200);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(m.getImage()));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(0, 0, 1110, 42);
		contentPane.add(panel);
		
		JLabel lblMovieDetail = new JLabel("Movie Detail");
		lblMovieDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblMovieDetail.setForeground(Color.WHITE);
		panel.add(lblMovieDetail);
		
		JLabel lblNewLabel = new JLabel(m.getName());
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(345, 66, 649, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Language");
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(338, 122, 90, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(": " + m.getLanguage());
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(450, 123, 248, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(338, 179, 90, 22);
		contentPane.add(lblSubtitle);
		
		JLabel label_3 = new JLabel(": " + m.getSubtitle());
		label_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_3.setBounds(450, 180, 248, 21);
		contentPane.add(label_3);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(338, 234, 90, 22);
		contentPane.add(lblFormats);
		
		JLabel label_5 = new JLabel(": " + m.getFormat());
		label_5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_5.setBounds(450, 235, 248, 21);
		contentPane.add(label_5);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(338, 289, 111, 22);
		contentPane.add(lblRunningTime);
		
		JLabel label_7 = new JLabel(": " + m.getRunningTime());
		label_7.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_7.setBounds(450, 290, 248, 21);
		contentPane.add(label_7);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(338, 340, 90, 22);
		contentPane.add(lblGenre);
		
		JLabel label_9 = new JLabel(": " + m.getGenre());
		label_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_9.setBounds(450, 341, 248, 21);
		contentPane.add(label_9);
		
		JLabel lblOpeingDate = new JLabel("Opening Date");
		lblOpeingDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeingDate.setBounds(338, 389, 111, 22);
		contentPane.add(lblOpeingDate);
		
		JLabel label_11 = new JLabel(": " + m.getOpeingDate());
		label_11.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_11.setBounds(450, 390, 248, 21);
		contentPane.add(label_11);
		
		JLabel lblImportedDate_1 = new JLabel("Imported Date ");
		lblImportedDate_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate_1.setBounds(749, 389, 111, 22);
		contentPane.add(lblImportedDate_1);
		
		JLabel lblImportedDate = new JLabel("Imported Price ");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(749, 340, 111, 22);
		contentPane.add(lblImportedDate);
		
		JLabel lblImportedFrom = new JLabel("Imported From");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(749, 289, 111, 22);
		contentPane.add(lblImportedFrom);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(749, 234, 90, 22);
		contentPane.add(lblDirector);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(749, 179, 90, 22);
		contentPane.add(lblCast);
		
		JLabel lblMovieid = new JLabel("MovieID");
		lblMovieid.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieid.setBounds(749, 122, 90, 22);
		contentPane.add(lblMovieid);
		
		JLabel label_18 = new JLabel(": " + m.getId());
		label_18.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_18.setBounds(861, 123, 216, 21);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel(": " + m.getCast());
		label_19.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_19.setBounds(861, 180, 216, 21);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(": " + m.getDirector());
		label_20.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_20.setBounds(861, 235, 216, 21);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(": " + m.getImportFrom());
		label_21.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_21.setBounds(861, 290, 216, 21);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(": " + m.getImportPrice());
		label_22.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_22.setBounds(861, 341, 216, 21);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(": " + m.getImportDate());
		label_23.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label_23.setBounds(861, 390, 216, 21);
		contentPane.add(label_23);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(m.getSummary());
		textArea.setEditable(false);
		textArea.setBounds(16, 449, 1067, 136);
		contentPane.add(textArea);
		
	}
}
