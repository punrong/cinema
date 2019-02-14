package rupp.cinema;

import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow {

	public JLabel lblLoading;
	public JProgressBar progressBarLoading;
	public JLabel lblPhnomPenhCinema;
	public JLabel lblBack;
	public JLabel lblLogo;
	public JPanel fullFramePanel;
	
	public Splash() {
		initialization();
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);	
		setVisible(true);
		setSize(452,299);
		setLocationRelativeTo(null);	
	}
	
	public void initialization() {
		fullFramePanel = new JPanel();
		
		fullFramePanel.setVerifyInputWhenFocusTarget(false);
		fullFramePanel.setBackground(new Color(255, 69, 0));
		fullFramePanel.setBounds(0, 255, 450, 45);
		add(fullFramePanel);
		
		fullFramePanel.setLayout(null);
		lblLoading = new JLabel("Loading..");
		lblLoading.setForeground(Color.WHITE);
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
		lblLoading.setBounds(161, 0, 125, 14);
		fullFramePanel.add(lblLoading);
		
		progressBarLoading = new JProgressBar();
		progressBarLoading.setVisible(true);
		progressBarLoading.setBackground(Color.WHITE);
		progressBarLoading.setForeground(Color.YELLOW);
		progressBarLoading.setBounds(10, 20, 430, 14);
		fullFramePanel.add(progressBarLoading);
		
		lblPhnomPenhCinema = new JLabel("Phnom Penh Cinema");
		lblPhnomPenhCinema.setFont(new Font("Lithos Pro Regular", Font.PLAIN, 16));
		lblPhnomPenhCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnomPenhCinema.setBounds(112, 168, 221, 14);
		add(lblPhnomPenhCinema);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("resource/logo.png"));
		lblLogo.setBounds(161, 48, 128, 118);
		lblLogo.setVisible(true);
		add(lblLogo);
		
		lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon("resource/back.jpg"));
		lblBack.setBounds(0, 0, 450, 254);
		add(lblBack);
	}

}
