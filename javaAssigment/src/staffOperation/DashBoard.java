package staffOperation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DashBoard {

	private JPanel DashBoardLeftPanel;
	private JPanel PanelWelcome;

	
	private JLabel lblWelcome;
	private JLabel lblNowShowing;
	private JLabel lblComingSoon;
	private JLabel lblReport;
	private JLabel lblSignOut;
	
	private GridBagLayout GridBagLeftPane;
	private GridBagConstraints gbc_PanelWelcome;
	private GridBagConstraints gbc_lblNowShowing;
	private GridBagConstraints gbc_lblComingSoon;
	private GridBagConstraints gbc_lblReport;
	private GridBagConstraints gbc_lblSignout;
	
	public JPanel getDashBoardLeftPanel() {
		return this.DashBoardLeftPanel;
	}
	
	public JLabel getlblNowShowing() {
		return this.lblNowShowing;
	}
	
	public JLabel getlblComingSoon() {
		return this.lblComingSoon;
	}
	
	public JLabel getlblReport() {
		return this.lblReport;
	}
	
	public JLabel getlblSignOut() {
		return this.lblSignOut;
	}
	
	public DashBoard() {
		initializeOntheLeft();
		DashBoardLeftPanel = new JPanel();
		DashBoardLeftPanel.setBackground(new Color(102, 153, 255));
		
		GridBagLeftPane = new GridBagLayout();
		GridBagLeftPane.columnWidths = new int[]{46, 0};
		GridBagLeftPane.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		GridBagLeftPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		GridBagLeftPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		DashBoardLeftPanel.setLayout(GridBagLeftPane);
		
		DashBoardLeftPanel.add(PanelWelcome, gbc_PanelWelcome);
		DashBoardLeftPanel.add(lblNowShowing, gbc_lblNowShowing);
		DashBoardLeftPanel.add(lblComingSoon, gbc_lblComingSoon);
		DashBoardLeftPanel.add(lblReport, gbc_lblReport);
		DashBoardLeftPanel.add(lblSignOut, gbc_lblSignout);
	}
	
public void initializeOntheLeft() {
		
		PanelWelcome = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PanelWelcome.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(2);
		PanelWelcome.setBackground(Color.ORANGE);
		gbc_PanelWelcome = new GridBagConstraints();
		gbc_PanelWelcome.anchor = GridBagConstraints.NORTH;
		gbc_PanelWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_PanelWelcome.fill = GridBagConstraints.HORIZONTAL;
		gbc_PanelWelcome.gridx = 0;
		gbc_PanelWelcome.gridy = 0;
		lblWelcome = new JLabel("WELCOME!!!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Eras Bold ITC", Font.BOLD, 16));
		lblWelcome.setForeground(Color.WHITE);
		PanelWelcome.add(lblWelcome);
		
		lblNowShowing = new JLabel("Now Showing");
		lblNowShowing.setFont(new Font("Engravers MT", Font.BOLD, 16));
		lblNowShowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblNowShowing.setForeground(Color.WHITE);
		
		gbc_lblNowShowing = new GridBagConstraints();
		gbc_lblNowShowing.insets = new Insets(0, 0, 5, 0);
		gbc_lblNowShowing.anchor = GridBagConstraints.WEST;
		gbc_lblNowShowing.gridx = 0;
		gbc_lblNowShowing.gridy = 2;
		
		
		lblComingSoon = new JLabel("Coming Soon");
		lblComingSoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblComingSoon.setForeground(Color.WHITE);
		lblComingSoon.setFont(new Font("Engravers MT", Font.BOLD, 16));
		
		gbc_lblComingSoon = new GridBagConstraints();
		gbc_lblComingSoon.insets = new Insets(0, 0, 5, 0);
		gbc_lblComingSoon.gridx = 0;
		gbc_lblComingSoon.gridy = 3;
		
		lblReport = new JLabel("Report");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setFont(new Font("Engravers MT", Font.BOLD, 16));
		lblReport.setForeground(Color.WHITE);
		
		gbc_lblReport = new GridBagConstraints();
		gbc_lblReport.insets = new Insets(0, 0, 5, 0);
		gbc_lblReport.gridx = 0;
		gbc_lblReport.gridy = 4;

		
		lblSignOut = new JLabel("SignOut");
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Engravers MT", Font.BOLD, 16));
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		
		gbc_lblSignout = new GridBagConstraints();
		gbc_lblSignout.gridx = 0;
		gbc_lblSignout.gridy = 8;
	}
}
