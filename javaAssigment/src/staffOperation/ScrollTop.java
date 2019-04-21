package staffOperation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScrollTop {
	
	private JLayeredPane MoviePaneParent;
	
	private JPanel DashBoardTopPanel;
	private JPanel TopGreetingCurrentUserPanel;
	private JPanel MoviePanelChild;
	private JPanel MovieDetail;	
	
	private JLabel lblCurrentUser;
	private JPanel PanelNextUpper;
	private JPanel PanelBackUpper;
	private JLabel lblBackUpper;
	private JLabel lblNextUpper;
	private JLabel ScrollImageUpper;
	private ArrayList<ImageIcon> ScrollImageListUpper;
	private int currentIndexOfScrollImageUpper = 0;
	
	private String currentUser;

	public JPanel getDashBoardTopPanel() {
		return this.DashBoardTopPanel;
	}
	
	public ScrollTop(String currentUser) {
		this.currentUser = currentUser;
		initializeOntheTop();
		DashBoardTopPanel = new JPanel();
		DashBoardTopPanel.setBackground(Color.WHITE);
		DashBoardTopPanel.setLayout(new BorderLayout(0, 0));
		DashBoardTopPanel.add(TopGreetingCurrentUserPanel, BorderLayout.NORTH);
		DashBoardTopPanel.add(MoviePanelChild, BorderLayout.SOUTH);
	}
	
	public void initializeOntheTop() {
		
		ScrollImageListUpper = new ArrayList<ImageIcon>();
		for(int i = 0 ; i < 11; i++) {
			ScrollImageListUpper.add((new ImageIcon("slide" + i + ".jpg")));
		}

		TopGreetingCurrentUserPanel = new JPanel();
		TopGreetingCurrentUserPanel.setBackground(Color.RED);
		TopGreetingCurrentUserPanel.setLayout(new BorderLayout(0,0));
		
		lblCurrentUser = new JLabel("     Hey!   " + currentUser + "   ");
		lblCurrentUser.setForeground(Color.WHITE);
		lblCurrentUser.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblCurrentUser.setHorizontalAlignment(SwingConstants.LEFT);
		TopGreetingCurrentUserPanel.add(lblCurrentUser, BorderLayout.WEST);
		
		MoviePanelChild = new JPanel();
		MoviePanelChild.setLayout(new BorderLayout(0, 0));
		
		MoviePaneParent = new JLayeredPane();
		MoviePanelChild.add(MoviePaneParent, BorderLayout.CENTER);
		MoviePaneParent.setLayout(new BorderLayout(0, 0));
		
		MovieDetail = new JPanel();
		MovieDetail.setBackground(Color.WHITE);
		MoviePaneParent.add(MovieDetail, BorderLayout.CENTER);
		MovieDetail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ScrollImageUpper = new JLabel("");
		ScrollImageUpper.setPreferredSize(new Dimension(1000,200));
		ScrollImageUpper.setIcon(ScrollImageListUpper.get(currentIndexOfScrollImageUpper));
		MovieDetail.add(ScrollImageUpper);
		
		PanelNextUpper = new JPanel();
		MoviePanelChild.add(PanelNextUpper, BorderLayout.EAST);
		PanelNextUpper.setBackground(Color.LIGHT_GRAY);
		PanelNextUpper.setLayout(new BorderLayout(0, 0));
		
		lblNextUpper = new JLabel("    >     ");
		lblNextUpper.setForeground(Color.WHITE);
		mouseAction(lblNextUpper);
		lblNextUpper.setFont(new Font("Tekton Pro Cond", Font.BOLD, 18));
		PanelNextUpper.add(lblNextUpper);
		
		PanelBackUpper = new JPanel();
		MoviePanelChild.add(PanelBackUpper, BorderLayout.WEST);
		PanelBackUpper.setBackground(Color.LIGHT_GRAY);
		PanelBackUpper.setLayout(new BorderLayout(0, 0));
		
		lblBackUpper = new JLabel("    <    ");
		lblBackUpper.setForeground(Color.WHITE);
		lblBackUpper.setBackground(new Color(102, 153, 255));
		mouseAction(lblBackUpper);
		lblBackUpper.setFont(new Font("Tekton Pro Cond", Font.BOLD, 18));
		lblBackUpper.setHorizontalAlignment(SwingConstants.CENTER);
		PanelBackUpper.add(lblBackUpper);
	}
	public void mouseAction(JLabel thisLabel) {
		thisLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				thisLabel.setForeground(Color.YELLOW);
			}
		});
		thisLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				thisLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				thisLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				thisLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(thisLabel.equals(lblNextUpper)) {
					if(currentIndexOfScrollImageUpper == ScrollImageListUpper.size()-1)
						ScrollImageUpper.setIcon(ScrollImageListUpper.get(currentIndexOfScrollImageUpper = 0));
					else 
						ScrollImageUpper.setIcon(ScrollImageListUpper.get(++currentIndexOfScrollImageUpper));
				}
				
				else if(thisLabel.equals(lblBackUpper)){
					if(currentIndexOfScrollImageUpper == 0)
						ScrollImageUpper.setIcon(ScrollImageListUpper.get(currentIndexOfScrollImageUpper = ScrollImageListUpper.size()-1));
					else 
						ScrollImageUpper.setIcon(ScrollImageListUpper.get(--currentIndexOfScrollImageUpper));
				}
			}
		});
	}
}
