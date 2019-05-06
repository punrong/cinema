package managerOperation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.ScrollPaneAdjustable;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import sqlCommand.EmployeePart;
import sqlCommand.MembershipPart;
import sqlCommand.MoviePart;
import sqlCommand.SalePart;
import sqlCommand.SchedulePart;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import lu.tudor.santec.jtimechooser.JTimeChooser;
import lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo;
import main.Main;
import modelClass.Employee;
import modelClass.Membership;
import modelClass.Movie;
import modelClass.MovieSchedule;
import modelClass.Sale;

import javax.swing.JSpinner;

public class managerFunction extends JFrame implements MouseListener, ActionListener{
	//movie part 
	private JTextField mName, mLanguage, mSubtitle, mRun, mGenre, mCast, mDirector, mFrom, mPirce, mImg, mDSearch,mSSearch, mUSearch;
	private JComboBox cboFormats, cboUFormats;
	private JDateChooser openDateChooser, importDateChooser, uOpenDateChooser, uImportDateChooser;
	private JLabel lblmovieName, lblsubtitle, lblformats, lblrunningtime, lblgenre, lblopendate, lblcast, lbldirector, lblprice,lbldate, lblfrom, lbllanguage, lblSearch, lblMovieID;
	private JTextField mUName, mULanguage, mUSubtitle, mUUGenre, mUCast, mUDirector, mUFrom, mUPirce, mUImg, mUSum, mURun, mUMovieID;
	private JLabel lblDmovieName, lblDsubtitle, lblDformats, lblDrunningtime, lblDgenre, lblDopendate, lblDcast, lblDdirector, lblDprice,lblDdate, lblDfrom, lblDlanguage, lblDMovieID;
	private JButton btnMDSearch, btnMSSearch, btnMUSearch;
	private JButton btnCancel, btnClear, btnAdd;
	private JButton btnUMCancel, btnUMClear, btnUMUpdate;
	private JButton btnDMCancel, btnDMClear, btnDMDelete;
	private JButton btnSMClear, btnSMCancel;
	private JTextArea mSSummary, mUSummary, mDSummary, summary;
	private JLabel mAIcon, mVIcon, mSIcon, mUIcon, mDIcon;
	
	//schedule part
	private JTextField sLanguage, sSubtitle, sFormats, sRun, sGenre, sCast, sTSeat, sASeat,sTPrice;
	private JComboBox sAName, sAHall;
	private JTextArea sASummary;
	private JDateChooser sScheduleDate, sSearch, uScheduleDate;
	private JButton btnSAClear, btnSACancel, btnSAAdd;
	private JButton btnSSearch, btnSClear, btnSCancel;
	private JSpinner spinnerSTime, spinnerUTime;
	private JLabel vDate, vName, vTime, vHall, vTSeat, vASeat, vTPrice, vRun;
	private DefaultTableModel tableSchedule;
	private JTable tableSch;
	private JTextField uLanguage, uSubtitle, uFormats, uRun, uGenre, uCast, uTSeat, uASeat,uTPrice, uScheduleID, uSearch;
	private JComboBox uAName, uAHall;
	private JTextArea uASummary;
	private JButton btnUSearch, btnUClear, btnUCancel, btnUUpdate;
	private JLabel dName, dLanguage, dSubtitle, dFormats, dRun, dGenre, dCast, dScheduleID, dTime, dHall, dTSeat, dASeat, dTPrice, dScheduleDate;
	private JTextField dSearch;
	private JTextArea dASummary;
	private JButton btnDSearch, btnDClear, btnDCancel, btnDDelete;
	private JLabel sAIcon, sVIcon, sUIcon, sDIcon;
	
	//Employee part
	private JTextField fName, lName, lSalary, street, district, commune, city, country, mobile, email, username, password, dESearch, sESearch;
	private JComboBox gender;
	private JDateChooser dob;
	private JButton btnAECancel, btnAEClear, btnAEAdd;
	private DefaultTableModel tableEmployee;
	private JTable tableEmp;
	private JButton btnVEUpdate, btnVECancel, btnVEDelete;
	private JLabel sfName, slName, slSalary, sstreet, sdistrict, scommune, scity, scountry, smobile, semail, susername, spassword, sdob, sgender,  sEmployeeID;
	private JButton btnSESearch, btnSEClear, btnSECancel;
	private JTextField ufName, ulName, ulSalary, ustreet, udistrict, ucommune, ucity, ucountry, umobile, uemail, uusername, upassword, uESearch, uEmployeeID;
	private JComboBox ugender;
	private JDateChooser udob;
	private JButton btnUECancel, btnUEClear, btnUEUpdate, btnUESearch;
	private JLabel dfName, dlName, dlSalary, dstreet, ddistrict, dcommune, dcity, dcountry, dmobile, demail, dusername, dpassword, ddob, dgender, dEmployeeID;
	private JButton btnDESearch, btnDEClear, btnDECancel, btnDEDelete;
	
	//Membership part
	private JTextField mFName, mLName, mmobile, mdiscount, dMSearch, sMSearch;
	private JComboBox mgender, mCardLevel;
	private JDateChooser mdob, mrDate;
	private JButton btnAMCancel, btnAMClear, btnAMAdd;
	private DefaultTableModel tableMembership;
	private JTable tableMem;
	private JButton btnVMUpdate, btnVMCancel, btnVMDelete;
	private JLabel mSfName, mSlName, mSmobile, mSdob, mSgender, mSMemID, mSCLevel, mSDiscount, mSRDate;
	private JButton btnSMemSearch, btnSMemClear, btnSMemCancel;
	private JTextField uMfName, uMlName, uMmobile,uMDiscount, uMMemID, uMSearch;
	private JComboBox uMgender, uMCLevel;
	private JDateChooser uMdob, uMrDate;
	private JButton btnUMemCancel, btnUMemClear, btnUMemUpdate, btnUMemSearch;
	private JLabel mDfName, mDlName, mDmobile, mDdob, mDgender, mDMemID, mDCLevel, mDDiscount, mRDDate;
	private JButton btnDMemSearch, btnDMemClear, btnDMemCancel, btnDMemDelete;
	
	
	//General Sale part
	private DefaultTableModel tableVGensale;
	private JTable tableVGSale;
	private JButton btnVGCancel, btnVGDelete;
	private DefaultTableModel tableSGensale;
	private JTable tableSGSale;
	private JButton btnSGCancel, btnSGDelete, btnSGSearch;
	private JDateChooser sGDate;
	private JLabel sgMName, sgMRun, sgMTime, sgMHall, sgMTSeat, sgMTPrice, sgSaleID, sgDate, sgTime, sgTAmount, sgTPrice, sgPayment, sgYourReturn, sgEID;
	private JTextField sgSearch;
	private JButton btnDGCancel, btnDGDelete, btnDGSearch, btnDGClear;
	
	//Membership Sale part
	private DefaultTableModel tableVMemsale;
	private JTable tableVMSale;
	private JButton btnVMSCancel, btnVMSDelete;
	private DefaultTableModel tableSMensale;
	private JTable tableSMSale;
	private JButton btnSMSCancel, btnSMSDelete, btnSMSSearch;		
	private JDateChooser sMDate;
	private JLabel smMName, smMRun, smMTime, smMHall, smMTSeat, smMTPrice, smSaleID, smDate, smTime, smTAmount, smTPrice, smPayment, smYourReturn, smEID, smMemID;
	private JTextField smSearch;
	private JButton btnDMSCancel, btnDMSDelete, btnDMSSearch, btnDMSClear;
	
	
	private JPanel contentPane, panel, submenu, panelAdd, panelButtonAdd, panelSearch, panelButtonSearch, panelButtonUpdate, panelUpdate, panelButtonDelete, panelDelete;
	private JPanel panelAddSchedule, panelButtonAddSch,panelSearchSch, panelButtonSearchSch, panelUpdateSch, panelButtonUpdateSch, panelDeleteSch, panelButtonDeleteSch;
	private JPanel panelAddEmployee, panelButtonAddEmployee, panelViewEmployee, panelButtonViewEmp, panelSearchEmp, panelButtonSearchEmp, panelUpdateEmp, panelButtonUpdateEmp, panelDeleteEmp, panelButtonDeleteEmp;
	private JPanel panelAddMembership, panelButtonAddMembership, panelViewMembership, panelButtonViewMem, panelSearchMem, panelButtonSearchMem, panelUpdateMem, panelButtonUpdateMem, panelDeleteMem, panelButtomDeleteMem;
	private JPanel panelViewGenSale, panelButtonGenSale, panelSearchGenSale, panelButtonSearchGenSale, panelDeleteGenSale, panelButtonDeleteGenSale, panelViewMemSale, panelButtonViewMemSale, panelSearchMemSale, panelButtonSearchMemSale, panelDeleteMemSale, panelButtonDeleteMemSale;
	private JPanel menulist, logout, exit;
	private JPanel conMovie, conSchedule, conEmployee, conSale, conMember, conSale1;
	
	private JLabel menu, title, back, madd, mshow, msearch, mupdate, mdelete, subtitle, lbltime, lblhall,lblseat, lblava, lblmobile, lblemail, lblusername, lblpassword;
	private JLabel lblfirstName, lbllastName, lblgender, lbldob, lblsalary, lblstreet, lbldistrict, lblcommune, lblcity, lblcountry;
	private JLabel lbldiscount, lbllevel, lblregisterdate;
	
	private JScrollPane spViewMovie, spViewSchedule;
	
	public int count = 0;
	private JComboBox comboMovieName, cbogender;
	private MoviePart mP;
	
	private List<Movie> ms;
	private JPanel panelViewMovie;
	
	private SchedulePart sP;
	private List<MovieSchedule> ss;
	
	private EmployeePart eP;
	private List<Employee> es;
	
	private MembershipPart msP;
	private List<Membership> mss;

	private SalePart ssP;
	private List<Sale> gs;
	
	String fileName = null;
	
	public static detailViewMovie frame;
	public static detailViewSchedule frame1;
	public static detailViewEmployee frame2;
	public static detailViewGensale frame4;
	public static detailViewMembership frame3;
	public static detailViewMemsale frame5;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerFunction frame = new managerFunction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public managerFunction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exit = new JPanel();
		exit.setBackground(Color.WHITE);
		exit.setLayout(null);
		exit.setBorder(new LineBorder(new Color(0, 0, 0)));
		exit.setBounds(0, 93, 195, 42);
		contentPane.add(exit);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblExit.setBounds(13, 10, 149, 23);
		exit.add(lblExit);
		
		logout = new JPanel();
		logout.setBackground(Color.WHITE);
		logout.setLayout(null);
		logout.setBorder(new LineBorder(new Color(0, 0, 0)));
		logout.setBounds(0, 52, 195, 42);
		contentPane.add(logout);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLogout.setBounds(13, 10, 149, 23);
		logout.add(lblLogout);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(204, 0, 0));
		panel_3.setBounds(0, 0, 1690, 54);
		contentPane.add(panel_3);
		
		menu = new JLabel("");
		menu.setIcon(new ImageIcon("images/menu (1).png"));
		menu.setBounds(16, 10, 30, 32);
		panel_3.add(menu);
		menu.addMouseListener(this);
		
		back = new JLabel("   Back");
		back.setForeground(Color.WHITE);
		back.setIcon(new ImageIcon("images/back-arrow.png"));
		back.setBounds(16, 10, 114, 32);
		back.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_3.add(back);
		back.addMouseListener(this);
		back.setVisible(false);
		
		logout.setVisible(false);
		exit.setVisible(false);
		exit.addMouseListener(this);
		logout.addMouseListener(this);
		
		title = new JLabel("Phnom Penh Cinema");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		title.setBounds(0, 6, 1365, 36);
		panel_3.add(title);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 0, 0));
		panel.setBounds(50, 665, 1266, 103);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1,6,10,10));
		
		//movie icon
		JPanel con = new JPanel(new BorderLayout());
		con.setBackground(new Color(204, 0, 0));
		JLabel labelMovie = new JLabel("");
		labelMovie.setIcon(new ImageIcon("images/movie-symbol-of-video-camera (1).png"));
		con.add(labelMovie, BorderLayout.CENTER);
		JLabel label = new JLabel("Movie");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		con.add(label, BorderLayout.SOUTH);
		
		conMovie = new JPanel();
		conMovie.setBackground(new Color(204, 0, 0));
		conMovie.add(con);
		
		//schedule icon
		JPanel con1 = new JPanel(new BorderLayout());
		con1.setBackground(new Color(204, 0, 0));
		JLabel labelSchedule = new JLabel("");
		labelSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		labelSchedule.setIcon(new ImageIcon("images/calendar (1).png"));
		con1.add(labelSchedule, BorderLayout.NORTH);
		
		conSchedule = new JPanel();
		conSchedule.setBackground(new Color(204, 0, 0));
		conSchedule.add(con1);
		JLabel label1 = new JLabel("Movie Schedule");
		con1.add(label1, BorderLayout.SOUTH);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		
		//employee icon
		JPanel con2 = new JPanel(new BorderLayout());
		con2.setBackground(new Color(204, 0, 0));
		JLabel labelEmployee = new JLabel("");
		labelEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		labelEmployee.setIcon(new ImageIcon("images/group (1).png"));
		con2.add(labelEmployee, BorderLayout.CENTER);
		
		conEmployee = new JPanel();
		conEmployee.setBackground(new Color(204, 0, 0));
		conEmployee.add(con2);
		JLabel label2 = new JLabel("Employee");
		con2.add(label2, BorderLayout.SOUTH);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		
		//member icon
		JPanel con3 = new JPanel(new BorderLayout());
		con3.setBackground(new Color(204, 0, 0));
		JLabel labelMember  = new JLabel("");
		labelMember.setHorizontalAlignment(SwingConstants.CENTER);
		labelMember.setIcon(new ImageIcon("images/restaurant-membership-card-tool (1).png"));
		con3.add(labelMember, BorderLayout.CENTER);
				
		conMember = new JPanel();
		conMember.setBackground(new Color(204, 0, 0));
		conMember.add(con3);
		JLabel label3 = new JLabel("Membership");
		con3.add(label3, BorderLayout.SOUTH);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));

		//sale icon
		JPanel con4 = new JPanel(new BorderLayout());
		con4.setBackground(new Color(204, 0, 0));
		JLabel labelSale = new JLabel("");
		labelSale.setHorizontalAlignment(SwingConstants.CENTER);
		labelSale.setIcon(new ImageIcon("images/badge (1).png"));
		con4.add(labelSale, BorderLayout.CENTER);
				
		conSale = new JPanel();
		conSale.setBackground(new Color(204, 0, 0));
		conSale.add(con4);
		JLabel label4 = new JLabel("General Sale");
		con4.add(label4, BorderLayout.SOUTH);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(Color.WHITE);
		label4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				
		//saleMembershio icon
		JPanel con5 = new JPanel(new BorderLayout());
		con5.setBackground(new Color(204, 0, 0));
		JLabel labelSale1 = new JLabel("");
		labelSale1.setHorizontalAlignment(SwingConstants.CENTER);
		labelSale1.setIcon(new ImageIcon("images/percentage (1).png"));
		con5.add(labelSale1, BorderLayout.CENTER);
				
		conSale1 = new JPanel();
		conSale1.setBackground(new Color(204, 0, 0));
		conSale1.add(con5);
		JLabel label5 = new JLabel("Membership Sale");
		con5.add(label5, BorderLayout.SOUTH);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(Color.WHITE);
		label5.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));	
		
		panel.add(conMovie);
		panel.add(conSchedule);
		panel.add(conEmployee);
		panel.add(conMember);
		panel.add(conSale);
		panel.add(conSale1);
	
		submenu = new JPanel();
		subtitle = new JLabel(); 
		UISubmenu("", "", "", "", "", "", 1); 
		
		addMovieUI();
		panelAdd.setVisible(false);
		panelButtonAdd.setVisible(false);
		
		viewMovieUI();
		spViewMovie.setVisible(false);
		
		searchMovieUI();
		panelSearch.setVisible(false);
		panelButtonSearch.setVisible(false);
		
		updateMovieUI();
		panelUpdate.setVisible(false);
		panelButtonUpdate.setVisible(false);
		
		deleteMovieUI();
		panelDelete.setVisible(false);
		panelButtonDelete.setVisible(false);
		
		addMovieScheduleUI();
		panelAddSchedule.setVisible(false);
		panelButtonAddSch.setVisible(false);
		
		viewMovieScheduleUI();
		spViewSchedule.setVisible(false);
		
		searchMovieScheduleUI();
		panelSearchSch.setVisible(false);
		panelButtonSearchSch.setVisible(false);
		
		updateMovieScheduleUI();
		panelUpdateSch.setVisible(false);
		panelButtonUpdateSch.setVisible(false);
		
		deleteMovieScheduleUI();
		panelDeleteSch.setVisible(false);
		panelButtonDeleteSch.setVisible(false);
		
		addEmployeeUI();
		panelAddEmployee.setVisible(false);
		panelButtonAddEmployee.setVisible(false);
		
		viewEmployeeUI();
		panelViewEmployee.setVisible(false);
		panelButtonViewEmp.setVisible(false);
		
		searchEmployeeUI();
		panelSearchEmp.setVisible(false);
		panelButtonSearchEmp.setVisible(false);
		
		updateEmployeeUI();
		panelUpdateEmp.setVisible(false);
		panelButtonUpdateEmp.setVisible(false);
		
		deleteEmployeeUI();
		panelDeleteEmp.setVisible(false);
		panelButtonDeleteEmp.setVisible(false);
		
		addMembershipUI();
		panelAddMembership.setVisible(false);
		panelButtonAddMembership.setVisible(false);
		
		viewMembershipUI();
		panelViewMembership.setVisible(false);
		panelButtonViewMem.setVisible(false);
		
		searchMembershipUI();
		panelSearchMem.setVisible(false);
		panelButtonSearchMem.setVisible(false);
		
		updateMemebrshipUI();
		panelUpdateMem.setVisible(false);
		panelButtonUpdateMem.setVisible(false);
		
		deleteMembershipUI();
		panelDeleteMem.setVisible(false);
		panelButtomDeleteMem.setVisible(false);
		
		viewGeneralSaleUI();
		panelViewGenSale.setVisible(false);
		panelButtonGenSale.setVisible(false);
		
		searchGenSaleUI();
		panelSearchGenSale.setVisible(false);
		panelButtonSearchGenSale.setVisible(false);
		
		deleteGenSaleUI();
		panelDeleteGenSale.setVisible(false);
		panelButtonDeleteGenSale.setVisible(false);
		
		viewMemSaleUI();
		panelViewMemSale.setVisible(false);
		panelButtonViewMemSale.setVisible(false);
		
		searchMemSaleUI();
		panelSearchMemSale.setVisible(false);
		panelButtonSearchMemSale.setVisible(false);
		
		deleteMemSaleUI();
		panelDeleteMemSale.setVisible(false);
		panelButtonDeleteMemSale.setVisible(false);
		
		conMovie.addMouseListener(this);
		conSchedule.addMouseListener(this);
		conEmployee.addMouseListener(this);
		conMember.addMouseListener(this);
		conSale.addMouseListener(this);
		conSale1.addMouseListener(this);
		
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1366,768);
		//setLocationRelativeTo(null);
	}
	
	public void UISubmenu(String add, String show, String search, String update, String delete, String showImage, int choose)
	{
		submenu = new JPanel();
		submenu.setBorder(UIManager.getBorder("Menu.border"));
		submenu.setBackground(Color.WHITE);
		submenu.setBounds(0, 52, 255, 716);
		contentPane.add(submenu);
		submenu.setLayout(null);
		
		mupdate = new JLabel(update);
		madd = new JLabel(add);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 193, 298, 406);
		submenu.add(panel_1);
		panel_1.setLayout(new GridLayout(5,1, 0, 0));
		
		if(choose == 1) {
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		//panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		madd.setBounds(10, 0, 298, 87);
		panel_2.add(madd);
		madd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		madd.setIcon(new ImageIcon("images/pluss.png"));
		
		}
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		//panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4);
		
		mshow = new JLabel(show);
		mshow.setIcon(new ImageIcon(showImage));
		mshow.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		mshow.setBounds(10, 0, 298, 87);
		panel_4.add(mshow);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		//panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5);
		
		msearch = new JLabel(search);
		msearch.setIcon(new ImageIcon("images/magnifying-glass.png"));
		msearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		msearch.setBounds(10, 0, 298, 87);
		panel_5.add(msearch);
		
		if(choose == 1) {
			JPanel panel_6 = new JPanel();
			panel_6.setLayout(null);
			//panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_6.setBackground(Color.WHITE);
			panel_1.add(panel_6);
			
			mupdate.setIcon(new ImageIcon("images/refresh.png"));
			mupdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
			mupdate.setBounds(10, 0, 298, 87);
			panel_6.add(mupdate);
		}
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		//panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_1.add(panel_7);
		
		mdelete = new JLabel(delete);
		mdelete.setIcon(new ImageIcon("images/delete.png"));
		mdelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		mdelete.setBounds(10, 0, 298, 87);
		panel_7.add(mdelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(204, 0, 0));
		panel_2.setBounds(-8, 0, 340, 193);
		submenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/phakneath/Downloads/film.png"));
		lblNewLabel.setBounds(6, 0, 258, 129);
		panel_2.add(lblNewLabel);
		
		JLabel lblPhnomPenhCinema = new JLabel("Phnom Penh Cinema");
		lblPhnomPenhCinema.setForeground(Color.WHITE);
		lblPhnomPenhCinema.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnomPenhCinema.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		lblPhnomPenhCinema.setBounds(8, 70, 258, 111);
		panel_2.add(lblPhnomPenhCinema);
		
		JLabel lblWelcomeManager = new JLabel("Welcome Manager");
		lblWelcomeManager.setForeground(Color.WHITE);
		lblWelcomeManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeManager.setBounds(8, 141, 256, 37);
		lblWelcomeManager.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		panel_2.add(lblWelcomeManager);
		
		subtitle.setBounds(315, 60, 467, 42);
		subtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
		contentPane.add(subtitle);
		
		submenu.setVisible(false);
		madd.addMouseListener(this);
		mshow.addMouseListener(this);
		msearch.addMouseListener(this);
		mupdate.addMouseListener(this);
		mdelete.addMouseListener(this);
		/////////////// view movie list ///////////////////////////////
		
	}
	
	 public ImageIcon ResizeImage(String ImagePath, JLabel label)
	 {
	        ImageIcon MyImage = new ImageIcon(ImagePath);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
	        return image;
	 }
	 
	 public String ImageLoader(JLabel label)
	 {
		 String fileName = null;
		 
		 JFileChooser file = new JFileChooser();
	     file.setCurrentDirectory(new File(System.getProperty("user.home")));
	      //filter the files
	     FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
	     file.addChoosableFileFilter(filter);
	     int result = file.showSaveDialog(null);
	           //if the user click on save in Jfilechooser
	     if(result == JFileChooser.APPROVE_OPTION){
		     File selectedFile = file.getSelectedFile();
		     String path = selectedFile.getAbsolutePath();
		     label.setIcon(ResizeImage(path, label));
		     
		     Image image = ResizeImage(path, label).getImage();
		     BufferedImage bi = new BufferedImage(300, 400, BufferedImage.TYPE_INT_RGB);
		     Graphics2D g2d = (Graphics2D) bi.createGraphics();
		     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		     g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		     g2d.drawImage(image, 0, 0, 300,400, null);
		     g2d.dispose();
		     
		     fileName = selectedFile.getName();
		     
		     String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		     System.out.println(ext);
		         
		    try {
		    	File file1 = new File(fileName);
				ImageIO.write((RenderedImage) bi, ext , file1);
		     } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		     }
		     
	     }
	     //if the user click on save in Jfilechooser
	     else if(result == JFileChooser.CANCEL_OPTION){
	         System.out.println("No File Select");
	     }
	     
	     return fileName;
	 }
	
	public void viewMovieUI()
	{
		spViewMovie = new JScrollPane();
		spViewMovie.setBounds(257, 114, 1110, 654);
		spViewMovie.getViewport().setBackground(new Color(238, 238, 238));
		contentPane.add(spViewMovie);
		spViewMovie.setBorder(BorderFactory.createEmptyBorder());
		mVIcon = new JLabel("");
	}
	
	public void addMovieUI()
	{
		panelAdd = new JPanel();
		panelAdd.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelAdd.setBounds(280, 110, 1065, 582);
		contentPane.add(panelAdd);
		panelAdd.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelAdd.add(lblNewLabel_2);
		mAIcon = new JLabel("");
		mAIcon.setOpaque(true);
		mAIcon.setBackground(new Color(204, 0, 0));
		mAIcon.setBounds(20, 65, 200, 200);
		panelAdd.add(mAIcon);
		mAIcon.addMouseListener(new MouseListener() {
			
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
				fileName = ImageLoader(mAIcon);
			}
			});
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(293, 79, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelAdd.add(lblNewLabel_3);
		
		mName = new JTextField();
		mName.setBounds(427, 79, 218, 36);
		panelAdd.add(mName);
		mName.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(293, 127, 100, 23);
		panelAdd.add(lblLanguage);
		mLanguage = new JTextField();
		mLanguage.setColumns(10);
		mLanguage.setBounds(427, 127, 218, 36);
		panelAdd.add(mLanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(293, 175, 100, 23);
		panelAdd.add(lblSubtitle);
		
		mSubtitle = new JTextField();
		mSubtitle.setColumns(10);
		mSubtitle.setBounds(427, 175, 218, 36);
		panelAdd.add(mSubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(293, 222, 100, 23);
		panelAdd.add(lblFormats);
		
		cboFormats = new JComboBox();
		cboFormats.setBounds(427, 223, 218, 36);
		panelAdd.add(cboFormats);
		
		cboFormats.addItem("2D");
		cboFormats.addItem("3D");
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(293, 271, 108, 23);
		panelAdd.add(lblRunningTime);
		
		mRun = new JTextField();
		mRun.setColumns(10);
		mRun.setBounds(427, 271, 218, 36);
		panelAdd.add(mRun);
		
		mRun.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(293, 319, 108, 23);
		panelAdd.add(lblGenre);
		
		mGenre = new JTextField();
		mGenre.setColumns(10);
		mGenre.setBounds(427, 319, 218, 36);
		panelAdd.add(mGenre);
		
		JLabel lblOpeningDate = new JLabel("Opening Date");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(293, 372, 108, 23);
		panelAdd.add(lblOpeningDate);
		
		openDateChooser = new JDateChooser();
		openDateChooser.setBounds(427, 367, 218, 36);
		panelAdd.add(openDateChooser);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(688, 84, 108, 23);
		panelAdd.add(lblCast);
		
		mCast = new JTextField();
		mCast.setColumns(10);
		mCast.setBounds(829, 79, 218, 36);
		panelAdd.add(mCast);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(688, 130, 108, 23);
		panelAdd.add(lblDirector);
		
		mDirector = new JTextField();
		mDirector.setColumns(10);
		mDirector.setBounds(829, 125, 218, 36);
		panelAdd.add(mDirector);
		
		JLabel lblImportedFrom = new JLabel("Imported From");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(688, 178, 108, 23);
		panelAdd.add(lblImportedFrom);
		
		mFrom = new JTextField();
		mFrom.setColumns(10);
		mFrom.setBounds(829, 173, 218, 36);
		panelAdd.add(mFrom);
		
		JLabel lblImportedPrice = new JLabel("Imported Price");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(688, 225, 108, 23);
		panelAdd.add(lblImportedPrice);
		
		mPirce = new JTextField();
		mPirce.setColumns(10);
		mPirce.setBounds(829, 220, 218, 36);
		panelAdd.add(mPirce);
		
		mPirce.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblImportedDate = new JLabel("Imported Date");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(688, 276, 108, 23);
		panelAdd.add(lblImportedDate);
		
		importDateChooser = new JDateChooser();
		importDateChooser.setBounds(829, 268, 218, 36);
		panelAdd.add(importDateChooser);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 475, 148, 23);
		panelAdd.add(lblMovieSummary);
		
		summary = new JTextArea();
		summary.setBounds(227, 437, 799, 122);
		panelAdd.add(summary);
		
		panelButtonAdd = new JPanel();
		panelButtonAdd.setBounds(525, 703, 610, 65);
		contentPane.add(panelButtonAdd);
		panelButtonAdd.setLayout(null);
		
		btnCancel = new JButton("   Cancel");
		btnCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnCancel.setBounds(6, 5, 151, 41);
		
		panelButtonAdd.add(btnCancel);
		
		btnClear = new JButton("   Clear");
		btnClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnClear.setIcon(new ImageIcon("images/clear.png"));
		btnClear.setBounds(223, 5, 133, 41);
		panelButtonAdd.add(btnClear);
		
		btnAdd = new JButton("   Add Movie");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("images/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonAdd.add(btnAdd);
		
		btnCancel.addActionListener(this);
		btnClear.addActionListener(this);
		btnAdd.addActionListener(this);
	}
	
	public void searchMovieUI()
	{
		panelSearch = new JPanel();
		panelSearch.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearch.setBounds(280, 110, 1065, 582);
		contentPane.add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Movie Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearch.add(lblNewLabel_2);
		
		mSIcon = new JLabel("");
		mSIcon.setOpaque(true);
		mSIcon.setBackground(new Color(204, 0, 0));
		mSIcon.setBounds(20, 65, 200, 200);
		panelSearch.add(mSIcon);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 115, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelSearch.add(lblNewLabel_3);
		
		lblmovieName = new JLabel(":");
		lblmovieName.setBounds(432, 110, 218, 36);
		panelSearch.add(lblmovieName);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 163, 100, 23);
		panelSearch.add(lblLanguage);
		
		lbllanguage = new JLabel(":");
		lbllanguage.setBounds(432, 158, 218, 36);
		panelSearch.add(lbllanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 211, 100, 23);
		panelSearch.add(lblSubtitle);
		
		lblsubtitle = new JLabel(":");
		lblsubtitle.setBounds(432, 206, 218, 36);
		panelSearch.add(lblsubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 258, 100, 23);
		panelSearch.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 307, 108, 23);
		panelSearch.add(lblRunningTime);
		
		lblrunningtime = new JLabel(":");
		lblrunningtime.setBounds(432, 302, 218, 36);
		panelSearch.add(lblrunningtime);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 355, 108, 23);
		panelSearch.add(lblGenre);
		
		lblgenre = new JLabel(":");
		lblgenre.setBounds(432, 350, 218, 36);
		panelSearch.add(lblgenre);
		
		JLabel lblOpeningDate = new JLabel("Opening Date");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(288, 399, 108, 23);
		panelSearch.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(681, 168, 108, 23);
		panelSearch.add(lblCast);
		
		lblcast = new JLabel(":");
		lblcast.setBounds(823, 163, 218, 36);
		panelSearch.add(lblcast);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(681, 214, 108, 23);
		panelSearch.add(lblDirector);
		
		lbldirector = new JLabel(":");
		lbldirector.setBounds(823, 209, 218, 36);
		panelSearch.add(lbldirector);
		
		JLabel lblImportedFrom = new JLabel("Imported From");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(681, 262, 108, 23);
		panelSearch.add(lblImportedFrom);
		
		lblfrom = new JLabel(":");
		lblfrom.setBounds(823, 257, 218, 36);
		panelSearch.add(lblfrom);
		
		JLabel lblImportedPrice = new JLabel("Imported Price");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(681, 309, 108, 23);
		panelSearch.add(lblImportedPrice);
		
		lblprice = new JLabel(":");
		lblprice.setBounds(823, 304, 218, 36);
		panelSearch.add(lblprice);
		
		JLabel lblImportedDate = new JLabel("Imported Date");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(681, 360, 108, 23);
		panelSearch.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 475, 148, 23);
		panelSearch.add(lblMovieSummary);
		
		mSSummary = new JTextArea();
		mSSummary.setText("aaa");
		mSSummary.setEditable(false);
		mSSummary.setBounds(227, 437, 779, 122);
		panelSearch.add(mSSummary);
		
		lblformats = new JLabel(":");
		lblformats.setBounds(432, 254, 218, 36);
		panelSearch.add(lblformats);
		
		lblopendate = new JLabel(":");
		lblopendate.setBounds(432, 389, 218, 36);
		panelSearch.add(lblopendate);
		
		lbldate = new JLabel(":");
		lbldate.setBounds(823, 352, 218, 36);
		panelSearch.add(lbldate);
		
		lblSearch = new JLabel("Search by Name");
		lblSearch.setBounds(292, 67, 150, 23);
		lblSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		panelSearch.add(lblSearch);
		
		mSSearch = new JTextField();
		mSSearch.setBounds(462, 63, 390, 36);
		panelSearch.add(mSSearch);
		mSSearch.setColumns(10);
		
		btnMSSearch = new JButton("Search");
		btnMSSearch.setBounds(907, 65, 117, 36);
		panelSearch.add(btnMSSearch);
		
		btnMSSearch.addActionListener(this);
		
		lblMovieID = new JLabel("Movie ID ");
		lblMovieID.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieID.setBounds(681, 120, 108, 23);
		panelSearch.add(lblMovieID);
		
		lblMovieID= new JLabel(":");
		lblMovieID.setBounds(823, 115, 218, 36);
		panelSearch.add(lblMovieID);
		
		panelButtonSearch = new JPanel();
		panelButtonSearch.setBounds(528, 703, 610, 65);
		contentPane.add(panelButtonSearch);
		panelButtonSearch.setLayout(null);
		
		btnSMCancel = new JButton("   Cancel");
		btnSMCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSMCancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearch.add(btnSMCancel);
		
		btnSMClear = new JButton("   Clear");
		btnSMClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMClear.setIcon(new ImageIcon("images/clear.png"));
		btnSMClear.setBounds(347, 6, 133, 41);
		panelButtonSearch.add(btnSMClear);
		
		btnSMClear.addActionListener(this);
		btnSMCancel.addActionListener(this);		

	}

	public void updateMovieUI()
	{
		panelUpdate = new JPanel();
		panelUpdate.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelUpdate.setBounds(280, 110, 1065, 582);
		contentPane.add(panelUpdate);
		panelUpdate.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Update Movie"); 
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelUpdate.add(lblNewLabel_2);
		
		mUIcon = new JLabel("");
		mUIcon.setOpaque(true);
		mUIcon.setBackground(new Color(204, 0, 0));
		mUIcon.setBounds(20, 65, 200, 200);
		panelUpdate.add(mUIcon);
		
		mUIcon.addMouseListener(new MouseListener() {
			
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
				fileName = ImageLoader(mUIcon);
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 121, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelUpdate.add(lblNewLabel_3);
		
		mUName = new JTextField();
		mUName.setBounds(432, 116, 218, 36);
		panelUpdate.add(mUName);
		mUName.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 169, 100, 23);
		panelUpdate.add(lblLanguage);
		
		mULanguage = new JTextField();
		mULanguage.setColumns(10);
		mULanguage.setBounds(432, 164, 218, 36);
		panelUpdate.add(mULanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 217, 100, 23);
		panelUpdate.add(lblSubtitle);
		
		mUSubtitle = new JTextField();
		mUSubtitle.setColumns(10);
		mUSubtitle.setBounds(432, 212, 218, 36);
		panelUpdate.add(mUSubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 264, 100, 23);
		panelUpdate.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 313, 108, 23);
		panelUpdate.add(lblRunningTime);
		
		mURun= new JTextField();
		mURun.setColumns(10);
		mURun.setBounds(432, 308, 218, 36);
		panelUpdate.add(mURun);
		
		mURun.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 361, 108, 23);
		panelUpdate.add(lblGenre);
		
		mUUGenre = new JTextField();
		mUUGenre.setColumns(10);
		mUUGenre.setBounds(432, 356, 218, 36);
		panelUpdate.add(mUUGenre);
		
		JLabel lblOpeningDate = new JLabel("Opening Date");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(288, 414, 108, 23);
		panelUpdate.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(676, 174, 108, 23);
		panelUpdate.add(lblCast);
		
		mUCast = new JTextField();
		mUCast.setColumns(10);
		mUCast.setBounds(826, 169, 218, 36);
		panelUpdate.add(mUCast);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(676, 220, 108, 23);
		panelUpdate.add(lblDirector);
		
		mUDirector = new JTextField();
		mUDirector.setColumns(10);
		mUDirector.setBounds(826, 215, 218, 36);
		panelUpdate.add(mUDirector);
		
		JLabel lblImportedFrom = new JLabel("Imported From");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(676, 268, 108, 23);
		panelUpdate.add(lblImportedFrom);
		
		mUFrom = new JTextField();
		mUFrom.setColumns(10);
		mUFrom.setBounds(826, 263, 218, 36);
		panelUpdate.add(mUFrom);
		
		JLabel lblImportedPrice = new JLabel("Imported Price");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(676, 315, 108, 23);
		panelUpdate.add(lblImportedPrice);
		
		mUPirce = new JTextField();
		mUPirce.setColumns(10);
		mUPirce.setBounds(826, 310, 218, 36);
		panelUpdate.add(mUPirce);
		
		mUPirce.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblImportedDate = new JLabel("Imported Date");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(676, 366, 108, 23);
		panelUpdate.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 475, 148, 23);
		panelUpdate.add(lblMovieSummary);
		
		mUSummary = new JTextArea();
		mUSummary.setText("aaa");
		mUSummary.setBounds(227, 450, 779, 122);
		panelUpdate.add(mUSummary);
		
		cboUFormats = new JComboBox();
		cboUFormats.setBounds(432, 260, 218, 36);
		panelUpdate.add(cboUFormats);
		
		cboUFormats.addItem("2D");
		cboUFormats.addItem("3D");
		
		uOpenDateChooser = new JDateChooser();
		uOpenDateChooser.setBounds(432, 404, 218, 36);
		panelUpdate.add(uOpenDateChooser);
		
		uImportDateChooser = new JDateChooser();
		uImportDateChooser.setBounds(826, 358, 218, 36);
		panelUpdate.add(uImportDateChooser);
		
		JLabel lblSearch_1 = new JLabel("Search by Name");
		lblSearch_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_1.setBounds(298, 71, 150, 23);
		panelUpdate.add(lblSearch_1);
		
		mUSearch = new JTextField();
		mUSearch.setBounds(468, 66, 397, 36);
		panelUpdate.add(mUSearch);
		mUSearch.setColumns(10);
		
		btnMUSearch = new JButton("Search");
		btnMUSearch.setBounds(907, 65, 117, 36);
		panelUpdate.add(btnMUSearch);
		
		JLabel lblMovieId_1 = new JLabel("Movie ID ");
		lblMovieId_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieId_1.setBounds(676, 126, 108, 23);
		panelUpdate.add(lblMovieId_1);
		
		mUMovieID= new JTextField();
		mUMovieID.setColumns(10);
		mUMovieID.setEditable(false);;
		mUMovieID.setBounds(826, 121, 218, 36);
		panelUpdate.add(mUMovieID);
		
		panelButtonUpdate = new JPanel();
		panelButtonUpdate.setBounds(537, 703, 610, 65);
		contentPane.add(panelButtonUpdate);
		panelButtonUpdate.setLayout(null);
		
		btnUMCancel = new JButton("   Cancel");
		btnUMCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnUMCancel.setBounds(6, 5, 151, 41);
		
		panelButtonUpdate.add(btnUMCancel);
		
		btnUMClear = new JButton("   Clear");
		btnUMClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMClear.setIcon(new ImageIcon("images/clear.png"));
		btnUMClear.setBounds(223, 5, 133, 41);
		panelButtonUpdate.add(btnUMClear);
		
		btnUMUpdate = new JButton("   Update Movie");
		btnUMUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMUpdate.setIcon(new ImageIcon("images/contract.png"));
		btnUMUpdate.setBounds(416, 5, 166, 41);
		panelButtonUpdate.add(btnUMUpdate);
		
		btnMUSearch.addActionListener(this);
		btnUMCancel.addActionListener(this);
		btnUMClear.addActionListener(this);
		btnUMUpdate.addActionListener(this);
	}

	public void deleteMovieUI()
	{
		panelDelete = new JPanel();
		panelDelete.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDelete.setBounds(280, 110, 1065, 582);
		contentPane.add(panelDelete);
		panelDelete.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Movie Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDelete.add(lblNewLabel_2);
		
		mDIcon = new JLabel("");
		mDIcon.setOpaque(true);
		mDIcon.setBackground(new Color(204, 0, 0));
		mDIcon.setBounds(20, 65, 200, 200);
		panelDelete.add(mDIcon);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 116, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelDelete.add(lblNewLabel_3);
		
		lblDmovieName = new JLabel(":");
		lblDmovieName.setBounds(432, 111, 218, 36);
		panelDelete.add(lblDmovieName);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 164, 100, 23);
		panelDelete.add(lblLanguage);
		
		lblDlanguage = new JLabel(":");
		lblDlanguage.setBounds(432, 159, 218, 36);
		panelDelete.add(lblDlanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 212, 100, 23);
		panelDelete.add(lblSubtitle);
		
		lblDsubtitle = new JLabel(":");
		lblDsubtitle.setBounds(432, 207, 218, 36);
		panelDelete.add(lblDsubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 259, 100, 23);
		panelDelete.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 308, 108, 23);
		panelDelete.add(lblRunningTime);
		
		lblDrunningtime = new JLabel(":");
		lblDrunningtime.setBounds(432, 303, 218, 36);
		panelDelete.add(lblDrunningtime);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 356, 108, 23);
		panelDelete.add(lblGenre);
		
		lblDgenre = new JLabel(":");
		lblDgenre.setBounds(432, 351, 218, 36);
		panelDelete.add(lblDgenre);
		
		JLabel lblOpeningDate = new JLabel("Opening Date");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(282, 404, 108, 23);
		panelDelete.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(676, 169, 108, 23);
		panelDelete.add(lblCast);
		
		lblDcast = new JLabel(":");
		lblDcast.setBounds(820, 164, 218, 36);
		panelDelete.add(lblDcast);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(676, 215, 108, 23);
		panelDelete.add(lblDirector);
		
		lblDdirector = new JLabel(":");
		lblDdirector.setBounds(820, 210, 218, 36);
		panelDelete.add(lblDdirector);
		
		JLabel lblImportedFrom = new JLabel("Imported From");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(676, 263, 108, 23);
		panelDelete.add(lblImportedFrom);
		
		lblDfrom = new JLabel(":");
		lblDfrom.setBounds(820, 258, 218, 36);
		panelDelete.add(lblDfrom);
		
		JLabel lblImportedPrice = new JLabel("Imported Price");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(676, 310, 108, 23);
		panelDelete.add(lblImportedPrice);
		
		lblDprice = new JLabel(":");
		lblDprice.setBounds(820, 305, 218, 36);
		panelDelete.add(lblDprice);
		
		JLabel lblImportedDate = new JLabel("Imported Date");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(676, 361, 108, 23);
		panelDelete.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 475, 148, 23);
		panelDelete.add(lblMovieSummary);
		
		mDSummary = new JTextArea();
		mDSummary.setText("aaa");
		mDSummary.setEditable(false);
		mDSummary.setBounds(227, 439, 779, 122);
		panelDelete.add(mDSummary);
		
		lblDformats = new JLabel(":");
		lblDformats.setBounds(432, 255, 218, 36);
		panelDelete.add(lblDformats);
		
		lblDopendate = new JLabel(":");
		lblDopendate.setBounds(432, 397, 218, 36);
		panelDelete.add(lblDopendate);
		
		lblDdate = new JLabel(":");
		lblDdate.setBounds(820, 353, 218, 36);
		panelDelete.add(lblDdate);
		
		JLabel lblSearch = new JLabel("Search by Name");
		lblSearch.setBounds(298, 69, 150, 22);
		lblSearch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		panelDelete.add(lblSearch);
		
		mDSearch = new JTextField();
		mDSearch.setBounds(468, 65, 397, 36);
		panelDelete.add(mDSearch);
		mDSearch.setColumns(10);
		
		btnMDSearch = new JButton("Search");
		btnMDSearch.setBounds(907, 65, 117, 36);
		panelDelete.add(btnMDSearch);
		
		JLabel lblMovieId = new JLabel("Movie ID ");
		lblMovieId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieId.setBounds(676, 121, 108, 23);
		panelDelete.add(lblMovieId);
		
		lblDMovieID = new JLabel(":");
		lblDMovieID.setBounds(820, 116, 218, 36);
		panelDelete.add(lblDMovieID);
		
		panelButtonDelete = new JPanel();
		panelButtonDelete.setBounds(700, 948, 610, 65);
		contentPane.add(panelButtonDelete);
		panelButtonDelete.setLayout(null);
		
		btnDMCancel = new JButton("   Cancel");
		btnDMCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDMCancel.setBounds(6, 5, 151, 41);
		
		panelButtonDelete.add(btnDMCancel);
		
		btnDMClear= new JButton("   Clear");
		btnDMClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMClear.setIcon(new ImageIcon("images/clear.png"));
		btnDMClear.setBounds(223, 5, 133, 41);
		panelButtonDelete.add(btnDMClear);
		
		btnDMDelete = new JButton("   Delete Movie");
		btnDMDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDMDelete.setBounds(416, 5, 166, 41);
		panelButtonDelete.add(btnDMDelete);
		
		btnDMCancel.addActionListener(this);
		btnDMClear.addActionListener(this);
		btnDMDelete.addActionListener(this);
		btnMDSearch.addActionListener(this);
	}
	public void addMovieScheduleUI()
	{
		panelAddSchedule = new JPanel();
		panelAddSchedule.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelAddSchedule.setBounds(280, 110, 1065, 582);
		contentPane.add(panelAddSchedule);
		panelAddSchedule.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Schedule Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelAddSchedule.add(lblNewLabel_2);
		
		sAIcon = new JLabel("");
		sAIcon.setOpaque(true);
		sAIcon.setBackground(new Color(204, 0, 0));
		sAIcon.setBounds(20, 65, 200, 200);
		panelAddSchedule.add(sAIcon);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 83, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelAddSchedule.add(lblNewLabel_3);
		
		sAName = new JComboBox();
		sAName.setBounds(433, 78, 218, 36);
		panelAddSchedule.add(sAName);
		/*mP = new MoviePart();
		List<Movie> m = mP.getFromTableMovie();
		for(int i=0; i<m.size(); i++) {
			sAName.addItem(m.get(i).getName());
		}*/
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 131, 100, 23);
		panelAddSchedule.add(lblLanguage);
		
		sLanguage = new JTextField();
		sLanguage.setColumns(10);
		sLanguage.setEditable(false);
		sLanguage.setBounds(433, 126, 218, 36);
		panelAddSchedule.add(sLanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 179, 100, 23);
		panelAddSchedule.add(lblSubtitle);
		
		sSubtitle = new JTextField();
		sSubtitle.setColumns(10);
		sSubtitle.setEditable(false);
		sSubtitle.setBounds(433, 174, 218, 36);
		panelAddSchedule.add(sSubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 226, 100, 23);
		panelAddSchedule.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 275, 108, 23);
		panelAddSchedule.add(lblRunningTime);
		
		sRun = new JTextField();
		sRun.setColumns(10);
		sRun.setEditable(false);
		sRun.setBounds(433, 270, 218, 36);
		panelAddSchedule.add(sRun);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 323, 108, 23);
		panelAddSchedule.add(lblGenre);
		
		sGenre = new JTextField();
		sGenre.setColumns(10);
		sGenre.setEditable(false);
		sGenre.setBounds(433, 318, 218, 36);
		panelAddSchedule.add(sGenre);
		
		JLabel lblOpeningDate = new JLabel("Cast");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(288, 376, 108, 23);
		panelAddSchedule.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Time Start");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(676, 91, 108, 23);
		panelAddSchedule.add(lblCast);
		
		JLabel lblDirector = new JLabel("Hall");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(676, 137, 108, 23);
		panelAddSchedule.add(lblDirector);
		
		sAHall = new JComboBox();
		sAHall.setBounds(828, 132, 218, 36);
		panelAddSchedule.add(sAHall);
		
		sAHall.addItem("- - - Choose - - -");
		sAHall.addItem("1");
		sAHall.addItem("2");
		sAHall.addItem("3");
		sAHall.addItem("4");
		sAHall.addItem("5");
		
		JLabel lblImportedFrom = new JLabel("Total Seat");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(676, 185, 108, 23);
		panelAddSchedule.add(lblImportedFrom);
		
		sTSeat = new JTextField();
		sTSeat.setColumns(10);
		sTSeat.setBounds(828, 180, 218, 36);
		panelAddSchedule.add(sTSeat);
		
		sTSeat.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblImportedPrice = new JLabel("Available Seat");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(676, 232, 108, 23);
		panelAddSchedule.add(lblImportedPrice);
		
		sASeat = new JTextField();
		sASeat.setColumns(10);
		sASeat.setBounds(828, 227, 218, 36);
		panelAddSchedule.add(sASeat);
		
		sASeat.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblImportedDate = new JLabel("Ticket Price");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(676, 283, 108, 23);
		panelAddSchedule.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 475, 148, 23);
		panelAddSchedule.add(lblMovieSummary);
		
		sASummary = new JTextArea();
		sASummary.setText("aaa");
		sASummary.setEditable(false);
		sASummary.setBounds(227, 437, 779, 122);
		panelAddSchedule.add(sASummary);
		
		sFormats = new JTextField();
		sFormats.setColumns(10);
		sFormats.setEditable(false);
		sFormats.setBounds(433, 222, 218, 36);
		panelAddSchedule.add(sFormats);
		
		sCast = new JTextField();
		sCast.setColumns(10);
		sCast.setEditable(false);
		sCast.setBounds(433, 366, 218, 36);
		panelAddSchedule.add(sCast);
		
		sTPrice = new JTextField();
		sTPrice.setColumns(10);
		sTPrice.setBounds(828, 275, 218, 36);
		panelAddSchedule.add(sTPrice);
		
		sTPrice.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		lblScheduleDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleDate.setBounds(676, 336, 121, 23);
		panelAddSchedule.add(lblScheduleDate);
		
		sScheduleDate = new JDateChooser();
		sScheduleDate.setBounds(828, 331, 218, 36);
		panelAddSchedule.add(sScheduleDate);
		
		java.util.Date date = new java.util.Date();
		SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY ) ;
		spinnerSTime = new JSpinner(sm);
		spinnerSTime.setBounds(828, 83, 218, 36);
		panelAddSchedule.add(spinnerSTime);
		
		JSpinner.DateEditor ed = new JSpinner.DateEditor(spinnerSTime, "HH:mm a");
		spinnerSTime.setEditor(ed);
		
		panelButtonAddSch = new JPanel();
		panelButtonAddSch.setBounds(537, 703, 610, 65);
		contentPane.add(panelButtonAddSch);
		panelButtonAddSch.setLayout(null);
		
		btnSACancel = new JButton("   Cancel");
		btnSACancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSACancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSACancel.setBounds(6, 5, 151, 41);
		
		panelButtonAddSch.add(btnSACancel);
		
		btnSAClear = new JButton("   Clear");
		btnSAClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSAClear.setIcon(new ImageIcon("images/clear.png"));
		btnSAClear.setBounds(223, 5, 133, 41);
		panelButtonAddSch.add(btnSAClear);
		
		btnSAAdd = new JButton("   Add Schedule");
		btnSAAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSAAdd.setIcon(new ImageIcon("images/contract.png"));
		btnSAAdd.setBounds(416, 5, 166, 41);
		panelButtonAddSch.add(btnSAAdd);
		
		btnSACancel.addActionListener(this);
		btnSAClear.addActionListener(this);
		btnSAAdd.addActionListener(this);
		
		sAName.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				mP = new MoviePart();
				//System.out.println(e.getItem());
				Movie m = mP.searchFromTableMovie(e.getItem().toString());
				System.out.println("In");
				
				if(m != null) {
					sLanguage.setText(m.getLanguage());
				sSubtitle.setText(m.getSubtitle());
				sFormats.setText(m.getFormat());
				sRun.setText(m.getRunningTime()+"");
				sGenre.setText(m.getGenre());
				sCast.setText(m.getCast());
				sASummary.setText(m.getSummary());
				sAIcon.setIcon(new ImageIcon(m.getImage()));
				}
			}
		});
	}
	
	public void viewMovieScheduleUI()
	{
		spViewSchedule = new JScrollPane();
		spViewSchedule.setBounds(257, 114, 1109, 654);
		spViewSchedule.getViewport().setBackground(new Color(238, 238, 238));
		contentPane.add(spViewSchedule);
		spViewSchedule.setBorder(BorderFactory.createEmptyBorder());
		sVIcon = new JLabel();
	}
	
	public void searchMovieScheduleUI()
	{
		panelSearchSch = new JPanel();
		panelSearchSch.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearchSch.setBounds(280, 110, 1065, 582);
		contentPane.add(panelSearchSch);
		panelSearchSch.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Search Movie Schedule");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearchSch.add(lblNewLabel_2);
		
		tableSchedule = new DefaultTableModel();
		tableSchedule.addColumn("ScheduleID");
		tableSchedule.addColumn("MovieName");
		tableSchedule.addColumn("TimeStart");
		tableSchedule.addColumn("Hall");
		tableSchedule.addColumn("TotalSeat");
		tableSchedule.addColumn("ScheduleDate");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(22, 132, 1021, 428);
		panel_1.setLayout(new BorderLayout());
		panelSearchSch.add(panel_1);
		
		tableSch = new JTable(tableSchedule);
		tableSch.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableSch.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableSch), BorderLayout.CENTER);
		
		tableSch.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableSch.getTableHeader().setBackground(new Color(204,0,0));
		tableSch.getTableHeader().setForeground(Color.WHITE);
		tableSch.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableSch.setRowHeight(28);
		
		tableSch.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				/* JTable table =(JTable) e.getSource();
			        Point point = e.getPoint();
			        int row = table.rowAtPoint(point);*/
			        if (e.getClickCount() == 2 && tableSch.getSelectedRow() != -1) {
			        	String id = (String) tableSch.getModel().getValueAt(tableSch.getSelectedRow(), 0);
			        	sP = new SchedulePart();
			        	MovieSchedule s = sP.searchByID(id);
			        	mP = new MoviePart();
			        	Movie m = mP.searchByID(s.getMovieID());
			            frame1 = new detailViewSchedule(s,m);
			            frame1.setVisible(true);
			        }
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
				
			}
		});
		
		JLabel lblSearch_3 = new JLabel("Search : ");
		lblSearch_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_3.setBounds(85, 78, 88, 25);
		panelSearchSch.add(lblSearch_3);
		
		btnSSearch = new JButton("Search");
		btnSSearch.setBounds(864, 73, 117, 35);
		panelSearchSch.add(btnSSearch);
		
		sSearch = new JDateChooser();
		sSearch.setBounds(236, 73, 551, 35);
		panelSearchSch.add(sSearch);
		
		panelButtonSearchSch = new JPanel();
		panelButtonSearchSch.setBounds(542, 703, 610, 65);
		contentPane.add(panelButtonSearchSch);
		panelButtonSearchSch.setLayout(null);
		
		btnSCancel = new JButton("   Cancel");
		btnSCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSCancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearchSch.add(btnSCancel);
		
		btnSClear = new JButton("   Clear");
		btnSClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSClear.setIcon(new ImageIcon("images/clear.png"));
		btnSClear.setBounds(347, 6, 133, 41);
		panelButtonSearchSch.add(btnSClear);
		
		/*JButton btnAdd = new JButton("   Add Movie");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonSearch.add(btnAdd);*/
		
		btnSSearch.addActionListener(this);
		btnSClear.addActionListener(this);
		btnSCancel.addActionListener(this);
	}
	
	public void updateMovieScheduleUI()
	{
		panelUpdateSch = new JPanel();
		panelUpdateSch.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelUpdateSch.setBounds(280, 110, 1065, 607);
		contentPane.add(panelUpdateSch);
		panelUpdateSch.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Schedule Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelUpdateSch.add(lblNewLabel_2);
		
		sUIcon = new JLabel("");
		sUIcon.setOpaque(true);
		sUIcon.setBackground(new Color(204, 0, 0));
		sUIcon.setBounds(20, 83, 200, 200);
		panelUpdateSch.add(sUIcon);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 136, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelUpdateSch.add(lblNewLabel_3);
		
		uAName = new JComboBox();
		uAName.setBounds(432, 131, 218, 36);
		panelUpdateSch.add(uAName);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 184, 100, 23);
		panelUpdateSch.add(lblLanguage);
		
		uLanguage = new JTextField();
		uLanguage.setColumns(10);
		uLanguage.setEditable(false);
		uLanguage.setBounds(432, 179, 218, 36);
		panelUpdateSch.add(uLanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 232, 100, 23);
		panelUpdateSch.add(lblSubtitle);
		
		uSubtitle = new JTextField();
		uSubtitle.setColumns(10);
		uSubtitle.setEditable(false);
		uSubtitle.setBounds(432, 227, 218, 36);
		panelUpdateSch.add(uSubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 279, 100, 23);
		panelUpdateSch.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 328, 108, 23);
		panelUpdateSch.add(lblRunningTime);
		
		uRun = new JTextField();
		uRun.setColumns(10);
		uRun.setEditable(false);
		uRun.setBounds(432, 323, 218, 36);
		panelUpdateSch.add(uRun);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 376, 108, 23);
		panelUpdateSch.add(lblGenre);
		
		uGenre = new JTextField();
		uGenre.setColumns(10);
		uGenre.setEditable(false);
		uGenre.setBounds(432, 371, 218, 36);
		panelUpdateSch.add(uGenre);
		
		JLabel lblOpeningDate = new JLabel("Cast");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(288, 429, 108, 23);
		panelUpdateSch.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Time Start");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(676, 189, 108, 23);
		panelUpdateSch.add(lblCast);
		
		java.util.Date date = new java.util.Date();
		SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY ) ;
		spinnerUTime = new JSpinner(sm);
		spinnerUTime.setBounds(820, 184, 219, 36);
		panelUpdateSch.add(spinnerUTime);
		
		JSpinner.DateEditor ed = new JSpinner.DateEditor(spinnerUTime, "HH:mm a");
		spinnerUTime.setEditor(ed);
			
		JLabel lblDirector = new JLabel("Hall");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(676, 237, 108, 23);
		panelUpdateSch.add(lblDirector);
		
		uAHall = new JComboBox();
		uAHall.setBounds(820, 232, 219, 36);
		panelUpdateSch.add(uAHall);
		
		uAHall.addItem("- - - Choose - - -");
		uAHall.addItem("1");
		uAHall.addItem("2");
		uAHall.addItem("3");
		uAHall.addItem("4");
		uAHall.addItem("5");
		
		JLabel lblImportedFrom = new JLabel("Total Seat");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(676, 284, 108, 23);
		panelUpdateSch.add(lblImportedFrom);
		
		uTSeat = new JTextField();
		uTSeat.setColumns(10);
		uTSeat.setBounds(820, 280, 219, 36);
		panelUpdateSch.add(uTSeat);
		
		uTSeat.addKeyListener(new KeyListener() {
			@Override
		public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblImportedPrice = new JLabel("Available Seat");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(676, 333, 108, 23);
		panelUpdateSch.add(lblImportedPrice);
		
		uASeat= new JTextField();
		uASeat.setColumns(10);
		uASeat.setBounds(820, 328, 219, 36);
		panelUpdateSch.add(uASeat);
		
		uASeat.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblImportedDate = new JLabel("Ticket Price");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(676, 381, 108, 23);
		panelUpdateSch.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 505, 148, 23);
		panelUpdateSch.add(lblMovieSummary);
		
		uASummary = new JTextArea();
		uASummary.setText("aaa");
		uASummary.setEditable(false);
		uASummary.setBounds(227, 470, 779, 122);
		panelUpdateSch.add(uASummary);
		
		uFormats = new JTextField();
		uFormats.setColumns(10);
		uFormats.setEditable(false);
		uFormats.setBounds(432, 275, 218, 36);
		panelUpdateSch.add(uFormats);
		
		uCast = new JTextField();
		uCast.setColumns(10);
		uCast.setEditable(false);
		uCast.setBounds(432, 419, 218, 36);
		panelUpdateSch.add(uCast);
		
		uTPrice = new JTextField();
		uTPrice.setColumns(10);
		uTPrice.setBounds(820, 376, 219, 36);
		panelUpdateSch.add(uTPrice);
		
		uTPrice.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		lblScheduleDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleDate.setBounds(676, 434, 121, 23);
		panelUpdateSch.add(lblScheduleDate);
		
		uScheduleDate = new JDateChooser();
		uScheduleDate.setBounds(820, 424, 219, 36);
		panelUpdateSch.add(uScheduleDate);
		
		JLabel lblSearch_2 = new JLabel("Search");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(298, 69, 61, 23);
		panelUpdateSch.add(lblSearch_2);
		
		uSearch= new JTextField();
		uSearch.setBounds(459, 65, 397, 36);
		panelUpdateSch.add(uSearch);
		uSearch.setColumns(10);
		
		btnUSearch = new JButton("Search");
		btnUSearch.setBounds(907, 65, 117, 36);
		panelUpdateSch.add(btnUSearch);
		
		JLabel lblNewLabel_8 = new JLabel("e.g MovieName/Hall/TimeStart");
		lblNewLabel_8.setBounds(298, 103, 207, 16);
		panelUpdateSch.add(lblNewLabel_8);
		
		JLabel lblScheduleId_1 = new JLabel("Schedule ID ");
		lblScheduleId_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleId_1.setBounds(676, 141, 108, 23);
		panelUpdateSch.add(lblScheduleId_1);
		
		uScheduleID = new JTextField();
		uScheduleID.setColumns(10);
		uScheduleID.setEditable(false);
		uScheduleID.setBounds(820, 136, 219, 36);
		panelUpdateSch.add(uScheduleID);
		
		panelButtonUpdateSch = new JPanel();
		panelButtonUpdateSch.setBounds(530, 718, 610, 65);
		contentPane.add(panelButtonUpdateSch);
		panelButtonUpdateSch.setLayout(null);
		
		btnUCancel = new JButton("   Cancel");
		btnUCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnUCancel.setBounds(6, 5, 151, 41);
		
		panelButtonUpdateSch.add(btnUCancel);
		
		btnUClear = new JButton("   Clear");
		btnUClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUClear.setIcon(new ImageIcon("images/clear.png"));
		btnUClear.setBounds(223, 5, 133, 41);
		panelButtonUpdateSch.add(btnUClear);
		
		btnUUpdate = new JButton("   Update Schedule");
		btnUUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUUpdate.setIcon(new ImageIcon("images/contract.png"));
		btnUUpdate.setBounds(416, 5, 176, 41);
		panelButtonUpdateSch.add(btnUUpdate);
		
		btnUSearch.addActionListener(this);
		btnUCancel.addActionListener(this);
		btnUClear.addActionListener(this);
		btnUUpdate.addActionListener(this);
		
		uAName.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				mP = new MoviePart();
				//System.out.println(e.getItem());
				Movie m = mP.searchFromTableMovie(e.getItem().toString());
				System.out.println("In");
				
				if(m != null) {
				uLanguage.setText(m.getLanguage());
				uSubtitle.setText(m.getSubtitle());
				uFormats.setText(m.getFormat());
				uRun.setText(m.getRunningTime()+"");
				uGenre.setText(m.getGenre());
				uCast.setText(m.getCast());
				uASummary.setText(m.getSummary());
				}
			}
		});
	}	
	public void deleteMovieScheduleUI()
	{
		panelDeleteSch = new JPanel();
		panelDeleteSch.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDeleteSch.setBounds(280, 110, 1065, 607);
		contentPane.add(panelDeleteSch);
		panelDeleteSch.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Schedule Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDeleteSch.add(lblNewLabel_2);
		
		sDIcon = new JLabel("");
		sDIcon.setOpaque(true);
		sDIcon.setBackground(new Color(204, 0, 0));
		sDIcon.setBounds(20, 65, 200, 200);
		panelDeleteSch.add(sDIcon);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name");
		lblNewLabel_3.setBounds(288, 136, 100, 23);
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panelDeleteSch.add(lblNewLabel_3);
		
		dName = new JLabel(":");
		dName.setBounds(432, 131, 218, 36);
		panelDeleteSch.add(dName);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLanguage.setBounds(288, 184, 100, 23);
		panelDeleteSch.add(lblLanguage);
		
		dLanguage = new JLabel(":");
		dLanguage.setBounds(432, 179, 218, 36);
		panelDeleteSch.add(dLanguage);
		
		JLabel lblSubtitle = new JLabel("Subtitle");
		lblSubtitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSubtitle.setBounds(288, 232, 100, 23);
		panelDeleteSch.add(lblSubtitle);
		
		dSubtitle = new JLabel(":");
		dSubtitle.setBounds(432, 227, 218, 36);
		panelDeleteSch.add(dSubtitle);
		
		JLabel lblFormats = new JLabel("Formats");
		lblFormats.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblFormats.setBounds(288, 279, 100, 23);
		panelDeleteSch.add(lblFormats);
		
		JLabel lblRunningTime = new JLabel("Running Time");
		lblRunningTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblRunningTime.setBounds(288, 328, 108, 23);
		panelDeleteSch.add(lblRunningTime);
		
		dRun = new JLabel(":");
		dRun.setBounds(432, 323, 218, 36);
		panelDeleteSch.add(dRun);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGenre.setBounds(288, 376, 108, 23);
		panelDeleteSch.add(lblGenre);
		
		dGenre = new JLabel(":");
		dGenre.setBounds(432, 371, 218, 36);
		panelDeleteSch.add(dGenre);
		
		JLabel lblOpeningDate = new JLabel("Cast");
		lblOpeningDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblOpeningDate.setBounds(288, 429, 108, 23);
		panelDeleteSch.add(lblOpeningDate);
		
		JLabel lblCast = new JLabel("Time Start");
		lblCast.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCast.setBounds(676, 189, 108, 23);
		panelDeleteSch.add(lblCast);
		
		dTime = new JLabel(":");
		dTime.setBounds(826, 184, 218, 36);
		panelDeleteSch.add(dTime);
		
		JLabel lblDirector = new JLabel("Hall");
		lblDirector.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDirector.setBounds(676, 235, 108, 23);
		panelDeleteSch.add(lblDirector);
		
		dHall= new JLabel(":");
		dHall.setBounds(826, 230, 218, 36);
		panelDeleteSch.add(dHall);
		
		JLabel lblImportedFrom = new JLabel("Total Seat");
		lblImportedFrom.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedFrom.setBounds(676, 283, 108, 23);
		panelDeleteSch.add(lblImportedFrom);
		
		dTSeat= new JLabel(":");
		dTSeat.setBounds(826, 278, 218, 36);
		panelDeleteSch.add(dTSeat);
		
		JLabel lblImportedPrice = new JLabel("Available Seat");
		lblImportedPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedPrice.setBounds(676, 330, 108, 23);
		panelDeleteSch.add(lblImportedPrice);
		
		dASeat = new JLabel(":");
		dASeat.setBounds(826, 325, 218, 36);
		panelDeleteSch.add(dASeat);
		
		JLabel lblImportedDate = new JLabel("Ticket Price");
		lblImportedDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblImportedDate.setBounds(676, 381, 108, 23);
		panelDeleteSch.add(lblImportedDate);
		
		JLabel lblMovieSummary = new JLabel("Movie Summary");
		lblMovieSummary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMovieSummary.setBounds(53, 505, 148, 23);
		panelDeleteSch.add(lblMovieSummary);
		
		dASummary = new JTextArea();
		dASummary.setText("aaa");
		dASummary.setEditable(false);
		dASummary.setBounds(227, 470, 799, 122);
		panelDeleteSch.add(dASummary);
		
		dFormats = new JLabel(":");
		dFormats.setBounds(432, 275, 218, 36);
		panelDeleteSch.add(dFormats);
		
		dCast = new JLabel(":");
		dCast.setBounds(432, 419, 218, 36);
		panelDeleteSch.add(dCast);
		
		dTPrice= new JLabel(":");
		dTPrice.setBounds(826, 373, 218, 36);
		panelDeleteSch.add(dTPrice);
		
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		lblScheduleDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleDate.setBounds(676, 434, 121, 23);
		panelDeleteSch.add(lblScheduleDate);
		
		dScheduleDate = new JLabel(":");
		dScheduleDate.setBounds(826, 429, 218, 36);
		panelDeleteSch.add(dScheduleDate);
		
		JLabel lblSearch_2 = new JLabel("Search");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(298, 69, 61, 23);
		panelDeleteSch.add(lblSearch_2);
		
		dSearch = new JTextField();
		dSearch.setBounds(459, 65, 397, 36);
		panelDeleteSch.add(dSearch);
		dSearch.setColumns(10);
		
		btnDSearch = new JButton("Search");
		btnDSearch.setBounds(907, 65, 117, 36);
		panelDeleteSch.add(btnDSearch);
		
		JLabel lblNewLabel_8 = new JLabel("e.g MovieName/Hall/TimeStart");
		lblNewLabel_8.setBounds(298, 103, 207, 16);
		panelDeleteSch.add(lblNewLabel_8);
		
		JLabel lblScheduleId = new JLabel("Schedule ID ");
		lblScheduleId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblScheduleId.setBounds(676, 141, 108, 23);
		panelDeleteSch.add(lblScheduleId);
		
		dScheduleID = new JLabel(":");
		dScheduleID.setBounds(826, 136, 218, 36);
		panelDeleteSch.add(dScheduleID);
		
		panelButtonDeleteSch = new JPanel();
		panelButtonDeleteSch.setBounds(530, 718, 610, 65);
		contentPane.add(panelButtonDeleteSch);
		panelButtonDeleteSch.setLayout(null);
		
		btnDCancel = new JButton("   Cancel");
		btnDCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDCancel.setBounds(6, 5, 151, 41);
		
		panelButtonDeleteSch.add(btnDCancel);
		
		btnDClear = new JButton("   Clear");
		btnDClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDClear.setIcon(new ImageIcon("images/clear.png"));
		btnDClear.setBounds(223, 5, 133, 41);
		panelButtonDeleteSch.add(btnDClear);
		
		btnDDelete = new JButton("   Delete Schedule");
		btnDDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDDelete.setBounds(416, 5, 176, 41);
		panelButtonDeleteSch.add(btnDDelete);
		
		btnDSearch.addActionListener(this);
		btnDClear.addActionListener(this);
		btnDCancel.addActionListener(this);
		btnDDelete.addActionListener(this);
	}
	
	public void addEmployeeUI()
	{
		panelAddEmployee = new JPanel();
		panelAddEmployee.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelAddEmployee.setBounds(280, 110, 1065, 592);
		contentPane.add(panelAddEmployee);
		panelAddEmployee.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelAddEmployee.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 52, 1027, 146);
		panelAddEmployee.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(18, 37, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		fName = new JTextField();
		fName.setBounds(141, 33, 191, 35);
		panel_1.add(fName);
		fName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 37, 90, 23);
		panel_1.add(lblLastName);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(483, 33, 191, 35);
		panel_1.add(lName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 37, 90, 23);
		panel_1.add(lblGener);
		
		gender = new JComboBox();
		gender.setBounds(828, 33, 191, 35);
		panel_1.add(gender);
		
		gender.addItem("- - - Choose - - -");
		gender.addItem("Male");
		gender.addItem("Female");
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(18, 91, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 91, 90, 23);
		panel_1.add(lblSalary);
		
		lSalary = new JTextField();
		lSalary.setColumns(10);
		lSalary.setBounds(483, 87, 191, 35);
		panel_1.add(lSalary);
		lSalary.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {// TODO Auto-generated method stub
				onlyNumber(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		dob = new JDateChooser();
		dob.setBounds(141, 87, 191, 35);
		panel_1.add(dob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Address Information "));
		panel_2.setBounds(18, 210, 1027, 146);
		panelAddEmployee.add(panel_2);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(27, 41, 90, 23);
		panel_2.add(lblStreet);
		
		street = new JTextField();
		street.setColumns(10);
		street.setBounds(150, 37, 191, 35);
		panel_2.add(street);
		
		JLabel lblDistrict = new JLabel("District : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 41, 90, 23);
		panel_2.add(lblDistrict);
		
		district = new JTextField();
		district.setColumns(10);
		district.setBounds(483, 37, 191, 35);
		panel_2.add(district);
		
		JLabel lblCommune = new JLabel("Commune : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 41, 90, 23);
		panel_2.add(lblCommune);
		
		commune = new JTextField();
		commune.setColumns(10);
		commune.setBounds(828, 37, 191, 35);
		panel_2.add(commune);
		
		JLabel lblCityProvince = new JLabel("City / Province : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(27, 92, 123, 23);
		panel_2.add(lblCityProvince);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(150, 88, 191, 35);
		panel_2.add(city);
		
		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(360, 92, 90, 23);
		panel_2.add(lblCountry);
		
		country = new JTextField();
		country.setColumns(10);
		country.setBounds(483, 88, 191, 35);
		panel_2.add(country);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(18, 368, 1027, 92);
		panelAddEmployee.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(27, 41, 90, 23);
		panel_3.add(lblMobile);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(150, 37, 191, 35);
		panel_3.add(mobile);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmail.setBounds(360, 41, 90, 23);
		panel_3.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(483, 37, 191, 35);
		panel_3.add(email);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder(" Official Information "));
		panel_4.setBounds(18, 472, 1027, 92);
		panelAddEmployee.add(panel_4);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblUsername.setBounds(26, 41, 90, 23);
		panel_4.add(lblUsername);
		
		username = new JTextField();
		username.setColumns(10);
		username.setEditable(false);
		username.setBounds(149, 37, 191, 35);
		panel_4.add(username);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPassword.setBounds(360, 41, 90, 23);
		panel_4.add(lblPassword);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(483, 37, 191, 35);
		panel_4.add(password);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
		
		((javax.swing.border.TitledBorder) panel_4.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_4.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_4.repaint();
	
		panelButtonAddEmployee = new JPanel();
		panelButtonAddEmployee.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonAddEmployee);
		panelButtonAddEmployee.setLayout(null);
		
		btnAECancel = new JButton("   Cancel");
		btnAECancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAECancel.setIcon(new ImageIcon("images/close (1).png"));
		btnAECancel.setBounds(6, 5, 151, 41);
		
		panelButtonAddEmployee.add(btnAECancel);
		
		btnAEClear = new JButton("   Clear");
		btnAEClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAEClear.setIcon(new ImageIcon("images/clear.png"));
		btnAEClear.setBounds(223, 5, 133, 41);
		panelButtonAddEmployee.add(	btnAEClear);
		
		btnAEAdd = new JButton("   Add Employee");
		btnAEAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAEAdd.setIcon(new ImageIcon("images/contract.png"));
		btnAEAdd.setBounds(416, 5, 176, 41);
		panelButtonAddEmployee.add(btnAEAdd);
		
		btnAECancel.addActionListener(this);
		btnAEClear.addActionListener(this);
		btnAEAdd.addActionListener(this);
		
		mobile.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
		});
		lName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				username.setText(lName.getText().toString().trim() + mobile.getText().toString().trim());
			}
		});
		
	}
	public void viewEmployeeUI()
	{
		panelViewEmployee = new JPanel();
		panelViewEmployee.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelViewEmployee.setBounds(280, 110, 1065, 592);
		contentPane.add(panelViewEmployee);
		panelViewEmployee.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee List");
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelViewEmployee.add(lblNewLabel_2);
		tableEmployee = new DefaultTableModel();
		tableEmployee.addColumn("Employee Name");
		tableEmployee.addColumn("Username");
		tableEmployee.addColumn("Gender");
		tableEmployee.addColumn("Phone Number");
		tableEmployee.addColumn("Email");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(16, 58, 1032, 517);
		panel_1.setLayout(new BorderLayout());
		panelViewEmployee.add(panel_1);
		
		tableEmp = new JTable(tableEmployee);
		tableEmp.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableEmp.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableEmp), BorderLayout.CENTER);
		
		tableEmp.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableEmp.getTableHeader().setBackground(new Color(204,0,0));
		tableEmp.getTableHeader().setForeground(Color.WHITE);
		tableEmp.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableEmp.setRowHeight(28);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableEmp.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableEmp.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableEmp.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableEmp.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableEmp.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableEmp.getColumnModel().getColumn(4).setCellRenderer(renderer);
	    
	    tableEmp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableEmp.getSelectedRow() != -1) {
		        	String username = (String) tableEmp.getModel().getValueAt(tableEmp.getSelectedRow(), 1);
		        	eP = new EmployeePart();
		        	Employee emp = eP.searchFromTableEmployee(username);
		            frame2 = new detailViewEmployee(emp);
		            frame2.setVisible(true);
		        }
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
				
			}
		});
		
	    
	    panelButtonViewEmp = new JPanel();
		panelButtonViewEmp.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonViewEmp);
		panelButtonViewEmp.setLayout(null);
		
		btnVECancel = new JButton("   Cancel");
		btnVECancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVECancel.setIcon(new ImageIcon("images/close (1).png"));
		btnVECancel.setBounds(6, 5, 151, 41);
		
		panelButtonViewEmp.add(btnVECancel);
		
		btnVEUpdate = new JButton("   Update");
		btnVEUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVEUpdate.setIcon(new ImageIcon("images/clear.png"));
		btnVEUpdate.setBounds(223, 5, 133, 41);
		panelButtonViewEmp.add(btnVEUpdate);
		
		btnVEDelete = new JButton("   Delete");
		btnVEDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVEDelete.setIcon(new ImageIcon("images/contract.png"));
		btnVEDelete.setBounds(416, 5, 166, 41);
		panelButtonViewEmp.add(btnVEDelete);
		
		btnVECancel.addActionListener(this);
		btnVEUpdate.addActionListener(this);
		btnVEDelete.addActionListener(this);
	}
	
	public void searchEmployeeUI()
	{
		panelSearchEmp = new JPanel();
		panelSearchEmp.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearchEmp.setBounds(280, 110, 1065, 592);
		contentPane.add(panelSearchEmp);
		panelSearchEmp.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearchEmp.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 101, 1027, 129);
		panelSearchEmp.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 36, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		sfName = new JLabel();
		sfName.setBounds(139, 32, 191, 35);
		panel_1.add(sfName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 36, 90, 23);
		panel_1.add(lblLastName);
		
		slName = new JLabel();
		slName.setBounds(483, 32, 191, 35);
		panel_1.add(slName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 36, 90, 23);
		panel_1.add(lblGener);
		
		sgender = new JLabel();
		sgender.setBounds(828, 32, 191, 35);
		panel_1.add(sgender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 83, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		sdob = new JLabel();
		sdob.setBounds(139, 79, 191, 35);
		panel_1.add(sdob);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 83, 90, 23);
		panel_1.add(lblSalary);
		
		slSalary = new JLabel();
		slSalary.setBounds(483, 79, 191, 35);
		panel_1.add(slSalary);
		
		JLabel lblEmployeeId_3 = new JLabel("Employee ID : ");
		lblEmployeeId_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId_3.setBounds(705, 83, 111, 23);
		panel_1.add(lblEmployeeId_3);
		
		sEmployeeID = new JLabel();
		sEmployeeID.setBounds(828, 79, 191, 35);
		panel_1.add(sEmployeeID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Address Information "));
		panel_2.setBounds(18, 242, 1027, 129);
		panelSearchEmp.add(panel_2);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 36, 90, 23);
		panel_2.add(lblStreet);
		
		sstreet = new JLabel();
		sstreet.setBounds(139, 32, 191, 35);
		panel_2.add(sstreet);
		
		JLabel lblDistrict = new JLabel("District : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(358, 40, 90, 23);
		panel_2.add(lblDistrict);
		
		sdistrict = new JLabel();
		sdistrict.setBounds(481, 36, 191, 35);
		panel_2.add(sdistrict);
		
		JLabel lblCommune = new JLabel("Commune : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 36, 90, 23);
		panel_2.add(lblCommune);
		
		scommune = new JLabel();
		scommune.setBounds(828, 32, 191, 35);
		panel_2.add(scommune);
		
		JLabel lblCityProvince = new JLabel("City / Province : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(16, 83, 123, 23);
		panel_2.add(lblCityProvince);
		
		scity = new JLabel();
		scity.setBounds(139, 79, 191, 35);
		panel_2.add(scity);
		
		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(358, 87, 90, 23);
		panel_2.add(lblCountry);
		
		scountry = new JLabel();
		scountry.setBounds(481, 83, 191, 35);
		panel_2.add(scountry);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(18, 383, 1027, 92);
		panelSearchEmp.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(16, 40, 90, 23);
		panel_3.add(lblMobile);
		
		smobile = new JLabel();
		smobile.setBounds(139, 36, 191, 35);
		panel_3.add(smobile);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmail.setBounds(360, 40, 90, 23);
		panel_3.add(lblEmail);
		
		semail = new JLabel();
		semail.setBounds(483, 36, 191, 35);
		panel_3.add(semail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder(" Official Information "));
		panel_4.setBounds(18, 487, 1027, 92);
		panelSearchEmp.add(panel_4);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblUsername.setBounds(16, 40, 90, 23);
		panel_4.add(lblUsername);
		
		susername = new JLabel();
		susername.setBounds(139, 36, 191, 35);
		panel_4.add(susername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPassword.setBounds(360, 40, 90, 23);
		panel_4.add(lblPassword);
		
		spassword = new JLabel();
		spassword.setBounds(483, 36, 191, 35);
		panel_4.add(spassword);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
		
		((javax.swing.border.TitledBorder) panel_4.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_4.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_4.repaint();
	
		panelButtonSearchEmp = new JPanel();
		panelButtonSearchEmp.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonSearchEmp);
		panelButtonSearchEmp.setLayout(null);
		
		btnSECancel= new JButton("   Cancel");
		btnSECancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSECancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSECancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearchEmp.add(btnSECancel);
		
		btnSEClear = new JButton("   Clear");
		btnSEClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSEClear.setIcon(new ImageIcon("images/clear.png"));
		btnSEClear.setBounds(347, 6, 133, 41);
		panelButtonSearchEmp.add(btnSEClear);
		
		JLabel lblSearch_2 = new JLabel("Search by Username : ");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(79, 57, 185, 23);
		panelSearchEmp.add(lblSearch_2);
		
		sESearch = new JTextField();
		sESearch.setBounds(287, 53, 551, 36);
		panelSearchEmp.add(sESearch);
		sESearch.setColumns(10);
		
		btnSESearch = new JButton("Search");
		btnSESearch.setBounds(871, 53, 117, 36);
		panelSearchEmp.add(btnSESearch);
		
		/*JButton btnAdd = new JButton("   Add Employee");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchEmp.add(btnAdd);*/
		btnSEClear.addActionListener(this);
		btnSECancel.addActionListener(this);
		btnSESearch.addActionListener(this);
	}
	public void updateEmployeeUI()
	{
		panelUpdateEmp = new JPanel();
		panelUpdateEmp.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelUpdateEmp.setBounds(280, 110, 1065, 592);
		contentPane.add(panelUpdateEmp);
		panelUpdateEmp.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelUpdateEmp.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(18, 90, 1027, 136);
		panelUpdateEmp.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 35, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		ufName = new JTextField();
		ufName.setBounds(139, 31, 191, 35);
		panel_1.add(ufName);
		ufName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 35, 90, 23);
		panel_1.add(lblLastName);
		
		ulName = new JTextField();
		ulName.setColumns(10);
		ulName.setBounds(483, 31, 191, 35);
		panel_1.add(ulName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 35, 90, 23);
		panel_1.add(lblGener);
		
		ugender = new JComboBox();
		ugender.setBounds(828, 31, 191, 35);
		panel_1.add(ugender);
		
		ugender.addItem("- - - Choose - - -");
		ugender.addItem("Male");
		ugender.addItem("Female");
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 82, 111, 23);
		panel_1.add(lblDateOfBirth);
				
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 82, 90, 23);
		panel_1.add(lblSalary);
		
		ulSalary = new JTextField();
		ulSalary.setColumns(10);
		ulSalary.setBounds(483, 78, 191, 35);
		panel_1.add(ulSalary);
		
		JLabel lblEmployeeId_2 = new JLabel("Employee ID : ");
		lblEmployeeId_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId_2.setBounds(705, 84, 111, 23);
		panel_1.add(lblEmployeeId_2);
		
		uEmployeeID = new JTextField();
		uEmployeeID.setColumns(10);
		uEmployeeID.setEditable(false);
		uEmployeeID.setBounds(828, 78, 191, 35);
		panel_1.add(uEmployeeID);
		
		udob = new JDateChooser();
		udob.setBounds(139, 78, 191, 35);
		panel_1.add(udob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Address Information "));
		panel_2.setBounds(18, 237, 1027, 136);
		panelUpdateEmp.add(panel_2);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 35, 90, 23);
		panel_2.add(lblStreet);
		
		ustreet = new JTextField();
		ustreet.setColumns(10);
		ustreet.setBounds(139, 32, 191, 35);
		panel_2.add(ustreet);
		
		JLabel lblDistrict = new JLabel("District : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 39, 90, 23);
		panel_2.add(lblDistrict);
		
		udistrict = new JTextField();
		udistrict.setColumns(10);
		udistrict.setBounds(483, 35, 191, 35);
		panel_2.add(udistrict);
		
		JLabel lblCommune = new JLabel("Commune : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 39, 90, 23);
		panel_2.add(lblCommune);
		
		ucommune = new JTextField();
		ucommune.setColumns(10);
		ucommune.setBounds(828, 35, 191, 35);
		panel_2.add(ucommune);
		
		JLabel lblCityProvince = new JLabel("City / Province : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(16, 83, 123, 23);
		panel_2.add(lblCityProvince);
		
		ucity = new JTextField();
		ucity.setColumns(10);
		ucity.setBounds(139, 79, 191, 35);
		panel_2.add(ucity);
		
		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(360, 86, 90, 23);
		panel_2.add(lblCountry);
		
		ucountry = new JTextField();
		ucountry.setColumns(10);
		ucountry.setBounds(483, 82, 191, 35);
		panel_2.add(ucountry);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(18, 385, 1027, 92);
		panelUpdateEmp.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(18, 40, 90, 23);
		panel_3.add(lblMobile);
		
		umobile = new JTextField();
		umobile.setColumns(10);
		umobile.setBounds(141, 36, 191, 35);
		panel_3.add(umobile);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmail.setBounds(360, 40, 90, 23);
		panel_3.add(lblEmail);
		
		uemail = new JTextField();
		uemail.setColumns(10);
		uemail.setBounds(483, 36, 191, 35);
		panel_3.add(uemail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder(" Official Information "));
		panel_4.setBounds(18, 489, 1027, 92);
		panelUpdateEmp.add(panel_4);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblUsername.setBounds(18, 40, 90, 23);
		panel_4.add(lblUsername);
		
		uusername = new JTextField();
		uusername.setColumns(10);
		username.setEditable(false);
		uusername.setBounds(141, 36, 191, 35);
		panel_4.add(uusername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPassword.setBounds(360, 40, 90, 23);
		panel_4.add(lblPassword);
		
		upassword = new JTextField();
		upassword.setColumns(10);
		upassword.setBounds(483, 36, 191, 35);
		panel_4.add(upassword);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
		
		((javax.swing.border.TitledBorder) panel_4.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_4.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_4.repaint();
	
		panelButtonUpdateEmp = new JPanel();
		panelButtonUpdateEmp.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonUpdateEmp);
		panelButtonUpdateEmp.setLayout(null);
		
		btnUECancel = new JButton("   Cancel");
		btnUECancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUECancel.setIcon(new ImageIcon("images/close (1).png"));
		btnUECancel.setBounds(1, 5, 151, 41);
		
		panelButtonUpdateEmp.add(btnUECancel);
		
		btnUEClear = new JButton("   Clear");
		btnUEClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUEClear.setIcon(new ImageIcon("images/clear.png"));
		btnUEClear.setBounds(218, 5, 133, 41);
		panelButtonUpdateEmp.add(btnUEClear);
		
		btnUEUpdate = new JButton("   Update Employee");
		btnUEUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUEUpdate.setIcon(new ImageIcon("images/contract.png"));
		btnUEUpdate.setBounds(411, 5, 188, 41);
		panelButtonUpdateEmp.add(btnUEUpdate);
		
		JLabel lblSearch_2 = new JLabel("Search by Username : ");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(78, 55,185 , 23);
		panelUpdateEmp.add(lblSearch_2);
		
		uESearch = new JTextField();
		uESearch.setBounds(286, 51, 551, 36);
		panelUpdateEmp.add(uESearch);
		uESearch.setColumns(10);
		
		btnUESearch = new JButton("Search");
		btnUESearch.setBounds(870, 51, 117, 36);
		panelUpdateEmp.add(btnUESearch);
		
		btnUEClear.addActionListener(this);
		btnUECancel.addActionListener(this);
		btnUEUpdate.addActionListener(this);
		btnUESearch.addActionListener(this);
		umobile.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
		});
		
		ulName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				uusername.setText(ulName.getText().toString().trim() + umobile.getText().toString().trim());
			}
		});
	}
	
	public void deleteEmployeeUI()
	{
		panelDeleteEmp = new JPanel();
		panelDeleteEmp.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDeleteEmp.setBounds(280, 110, 1065, 592);
		contentPane.add(panelDeleteEmp);
		panelDeleteEmp.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDeleteEmp.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 100, 1027, 128);
		panelDeleteEmp.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 36, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		dfName = new JLabel();
		dfName.setBounds(139, 32, 191, 35);
		panel_1.add(dfName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 36, 90, 23);
		panel_1.add(lblLastName);
		
		dlName = new JLabel();
		dlName.setBounds(483, 32, 191, 35);
		panel_1.add(dlName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 36, 90, 23);
		panel_1.add(lblGener);
		
		dgender = new JLabel();
		dgender.setBounds(828, 32, 191, 35);
		panel_1.add(dgender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 83, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		ddob = new JLabel();
		ddob.setBounds(139, 79, 191, 35);
		panel_1.add(ddob);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 83, 90, 23);
		panel_1.add(lblSalary);
		
		dlSalary = new JLabel();
		dlSalary.setBounds(483, 79, 191, 35);
		panel_1.add(dlSalary);
		
		JLabel lblEmployeeId_1 = new JLabel("Employee ID : ");
		lblEmployeeId_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId_1.setBounds(705, 85, 111, 23);
		panel_1.add(lblEmployeeId_1);
		
		dEmployeeID = new JLabel();
		dEmployeeID.setBounds(828, 79, 191, 35);
		panel_1.add(dEmployeeID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Address Information "));
		panel_2.setBounds(16, 240, 1027, 128);
		panelDeleteEmp.add(panel_2);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 36, 90, 23);
		panel_2.add(lblStreet);
		
		dstreet = new JLabel();
		dstreet.setBounds(139, 32, 191, 35);
		panel_2.add(dstreet);
		
		JLabel lblDistrict = new JLabel("District : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 40, 90, 23);
		panel_2.add(lblDistrict);
		
		ddistrict = new JLabel();
		ddistrict.setBounds(483, 36, 191, 35);
		panel_2.add(ddistrict);
		
		JLabel lblCommune = new JLabel("Commune : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 40, 90, 23);
		panel_2.add(lblCommune);
		
		dcommune = new JLabel();
		dcommune.setBounds(828, 36, 191, 35);
		panel_2.add(dcommune);
		
		JLabel lblCityProvince = new JLabel("City / Province : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(16, 83, 123, 23);
		panel_2.add(lblCityProvince);
		
		dcity = new JLabel();
		dcity.setBounds(139, 79, 191, 35);
		panel_2.add(dcity);
		
		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(360, 83, 90, 23);
		panel_2.add(lblCountry);
		
		dcountry = new JLabel();
		dcountry.setBounds(483, 79, 191, 35);
		panel_2.add(dcountry);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(16, 380, 1027, 92);
		panelDeleteEmp.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(16, 40, 90, 23);
		panel_3.add(lblMobile);
		
		dmobile = new JLabel();
		dmobile.setBounds(139, 36, 191, 35);
		panel_3.add(dmobile);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmail.setBounds(360, 44, 90, 23);
		panel_3.add(lblEmail);
		
		demail = new JLabel();
		demail.setBounds(483, 40, 191, 35);
		panel_3.add(demail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(BorderFactory.createTitledBorder(" Official Information "));
		panel_4.setBounds(16, 484, 1027, 92);
		panelDeleteEmp.add(panel_4);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblUsername.setBounds(16, 40, 90, 23);
		panel_4.add(lblUsername);
		
		dusername = new JLabel();
		dusername.setBounds(139, 36, 191, 35);
		panel_4.add(dusername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPassword.setBounds(360, 44, 90, 23);
		panel_4.add(lblPassword);
		
		dpassword = new JLabel();
		dpassword.setBounds(483, 40, 191, 35);
		panel_4.add(dpassword);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
		
		((javax.swing.border.TitledBorder) panel_4.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_4.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_4.repaint();
	
		panelButtonDeleteEmp = new JPanel();
		panelButtonDeleteEmp.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonDeleteEmp);
		panelButtonDeleteEmp.setLayout(null);
		
		btnDECancel = new JButton("   Cancel");
		btnDECancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDECancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDECancel.setBounds(1, 5, 151, 41);
		
		panelButtonDeleteEmp.add(btnDECancel);
		
		btnDEClear = new JButton("   Clear");
		btnDEClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDEClear.setIcon(new ImageIcon("images/clear.png"));
		btnDEClear.setBounds(218, 5, 133, 41);
		panelButtonDeleteEmp.add(btnDEClear);
		
		btnDEDelete = new JButton("   Delete Employee");
		btnDEDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDEDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDEDelete.setBounds(411, 5, 188, 41);
		panelButtonDeleteEmp.add(btnDEDelete);
		

		JLabel lblSearch_2 = new JLabel("Search by Username : ");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(93, 56, 185, 23);
		panelDeleteEmp.add(lblSearch_2);
		
		dESearch = new JTextField();
		dESearch.setBounds(301, 52, 551, 36);
		panelDeleteEmp.add(dESearch);
		dESearch.setColumns(10);
		
		btnDESearch = new JButton("Search");
		btnDESearch.setBounds(885, 52, 117, 36);
		panelDeleteEmp.add(btnDESearch);
		
		/*JButton btnAdd = new JButton("   Add Employee");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchEmp.add(btnAdd);*/
		
		btnDECancel.addActionListener(this);
		btnDEClear.addActionListener(this);
		btnDEDelete.addActionListener(this);
		btnDESearch.addActionListener(this);
	}
	
	public void addMembershipUI()
	{
		panelAddMembership = new JPanel();
		panelAddMembership.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelAddMembership.setBounds(280, 110, 1065, 592);
		contentPane.add(panelAddMembership);
		panelAddMembership.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 65);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelAddMembership.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 75, 1027, 180);
		panelAddMembership.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 48, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		mFName = new JTextField();
		mFName.setBounds(139, 44, 191, 35);
		panel_1.add(mFName);
		mFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 48, 90, 23);
		panel_1.add(lblLastName);
		
		mLName = new JTextField();
		mLName.setColumns(10);
		mLName.setBounds(483, 44, 191, 35);
		panel_1.add(mLName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(704, 52, 90, 23);
		panel_1.add(lblGener);
		
		mgender = new JComboBox();
		mgender.setBounds(827, 48, 191, 35);
		panel_1.add(mgender);
		
		mgender.addItem("- - - Choose - - -");
		mgender.addItem("Male");
		mgender.addItem("Female");
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 115, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		mdob = new JDateChooser();
		mdob.setBounds(139, 111, 191, 35);
		panel_1.add(mdob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Card Information "));
		panel_2.setBounds(21, 291, 1022, 106);
		panelAddMembership.add(panel_2);
		
		JLabel lblStreet = new JLabel("Register Date :");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 50, 111, 23);
		panel_2.add(lblStreet);
		
		JLabel lblDistrict = new JLabel("Card Level : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 51, 90, 23);
		panel_2.add(lblDistrict);
		
		JLabel lblCommune = new JLabel("Discount (%) : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 48, 111, 23);
		panel_2.add(lblCommune);
		
		mdiscount = new JTextField();
		mdiscount.setColumns(10);
		mdiscount.setBounds(828, 44, 191, 35);
		panel_2.add(mdiscount);
		mdiscount.setEditable(false);
		
		mrDate = new JDateChooser();
		mrDate.setBounds(139, 44, 191, 35);
		panel_2.add(mrDate);
		
		mCardLevel = new JComboBox();
		mCardLevel.setBounds(483, 44, 191, 35);
		panel_2.add(mCardLevel);
		
		mCardLevel.addItem("- - - Choose - - -");
		mCardLevel.addItem("Silver");
		mCardLevel.addItem("Gold");
		mCardLevel.addItem("Premium");
		
		mCardLevel.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(mCardLevel.getSelectedItem().equals("Silver"))
					mdiscount.setText("10");
				else if(mCardLevel.getSelectedItem().equals("Gold"))
					mdiscount.setText("20");
				else if(mCardLevel.getSelectedItem().equals("Premium"))
					mdiscount.setText("30");
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(21, 432, 1022, 106);
		panelAddMembership.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(16, 48, 90, 23);
		panel_3.add(lblMobile);
		
		mmobile = new JTextField();
		mmobile.setColumns(10);
		mmobile.setBounds(139, 44, 191, 35);
		panel_3.add(mmobile);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
	
		panelButtonAddMembership = new JPanel();
		panelButtonAddMembership.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonAddMembership);
		panelButtonAddMembership.setLayout(null);
		
		btnAMCancel = new JButton("   Cancel");
		btnAMCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAMCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnAMCancel.setBounds(1, 5, 151, 41);
		
		panelButtonAddMembership.add(btnAMCancel);
		
		btnAMClear = new JButton("   Clear");
		btnAMClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAMClear.setIcon(new ImageIcon("images/clear.png"));
		btnAMClear.setBounds(208, 5, 133, 41);
		panelButtonAddMembership.add(btnAMClear);
		
		btnAMAdd = new JButton("   Add Membership");
		btnAMAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAMAdd.setIcon(new ImageIcon("images/contract.png"));
		btnAMAdd.setBounds(401, 5, 198, 41);
		panelButtonAddMembership.add(btnAMAdd);
		
		btnAMCancel.addActionListener(this);
		btnAMClear.addActionListener(this);
		btnAMAdd.addActionListener(this);
	}
	
	public void viewMembershipUI()
	{
		panelViewMembership = new JPanel();
		panelViewMembership.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelViewMembership.setBounds(280, 110, 1065, 592);
		contentPane.add(panelViewMembership);
		panelViewMembership.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership List");
		lblNewLabel_2.setBounds(6, 8, 1053, 55);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelViewMembership.add(lblNewLabel_2);
		
		tableMembership = new DefaultTableModel();
		tableMembership.addColumn("MemebrshipID");
		tableMembership.addColumn("Memebrship Name");
		tableMembership.addColumn("Gender");
		tableMembership.addColumn("Phone Number");
		tableMembership.addColumn("Card Level");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(17, 67, 1029, 507);
		panel_1.setLayout(new BorderLayout());
		panelViewMembership.add(panel_1);
		
		tableMem = new JTable(tableMembership);
		tableMem.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableMem.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableMem), BorderLayout.CENTER);
		
		tableMem.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableMem.getTableHeader().setBackground(new Color(204,0,0));
		tableMem.getTableHeader().setForeground(Color.WHITE);
		tableMem.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableMem.setRowHeight(28);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableMem.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableMem.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableMem.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableMem.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableMem.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableMem.getColumnModel().getColumn(4).setCellRenderer(renderer);
	
	    tableMem.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableMem.getSelectedRow() != -1) {
		        	String id = (String) tableMem.getModel().getValueAt(tableMem.getSelectedRow(), 0);
		        	msP = new MembershipPart();
		        	Membership m = msP.searchFromTableMembership(id);
		            frame3 = new detailViewMembership(m);
		            frame3.setVisible(true);
		        }
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
				
			}
		});
		panelButtonViewMem = new JPanel();
		panelButtonViewMem.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonViewMem);
		panelButtonViewMem.setLayout(null);
		
		btnVMCancel = new JButton("   Cancel");
		btnVMCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVMCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnVMCancel.setBounds(6, 5, 151, 41);
		
		panelButtonViewMem.add(btnVMCancel);
		
		btnVMUpdate = new JButton("   Update");
		btnVMUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVMUpdate.setIcon(new ImageIcon("images/clear.png"));
		btnVMUpdate.setBounds(223, 5, 133, 41);
		panelButtonViewMem.add(btnVMUpdate);
		
		btnVMDelete = new JButton("   Delete");
		btnVMDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVMDelete.setIcon(new ImageIcon("images/contract.png"));
		btnVMDelete.setBounds(416, 5, 166, 41);
		panelButtonViewMem.add(btnVMDelete);
		
		btnVMCancel.addActionListener(this);
		btnVMUpdate.addActionListener(this);
		btnVMDelete.addActionListener(this);
	}
	
	public void searchMembershipUI()
	{
		panelSearchMem = new JPanel();
		panelSearchMem.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearchMem.setBounds(280, 110, 1065, 592);
		contentPane.add(panelSearchMem);
		panelSearchMem.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 45);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearchMem.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 105, 1027, 166);
		panelSearchMem.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 49, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		mSfName= new JLabel();
		mSfName.setBounds(139, 45, 191, 35);
		panel_1.add(mSfName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 49, 90, 23);
		panel_1.add(lblLastName);
		
		mSlName = new JLabel();
		mSlName.setBounds(483, 45, 191, 35);
		panel_1.add(mSlName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 49, 90, 23);
		panel_1.add(lblGener);
		
		mSgender = new JLabel();
		mSgender.setBounds(828, 45, 191, 35);
		panel_1.add(mSgender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 116, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		mSdob = new JLabel();
		mSdob.setBounds(139, 112, 191, 35);
		panel_1.add(mSdob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Card Information "));
		panel_2.setBounds(16, 293, 1027, 166);
		panelSearchMem.add(panel_2);
		
		JLabel lblStreet = new JLabel("Membership ID : ");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 51, 120, 23);
		panel_2.add(lblStreet);
		
		JLabel lblDistrict = new JLabel("Card Level : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 52, 90, 23);
		panel_2.add(lblDistrict);
		
		JLabel lblCommune = new JLabel("Discount : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(704, 49, 90, 23);
		panel_2.add(lblCommune);
		mSDiscount = new JLabel();
		mSDiscount.setBounds(827, 45, 191, 35);
		panel_2.add(mSDiscount);
		
		mSMemID = new JLabel();
		mSMemID.setBounds(139, 45, 191, 35);
		panel_2.add(mSMemID);
		
		mSCLevel = new JLabel();
		mSCLevel.setBounds(483, 45, 242, 35);
		panel_2.add(mSCLevel);
		
		JLabel label = new JLabel("Register Date :");
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label.setBounds(16, 117, 111, 23);
		panel_2.add(label);
		
		mSRDate = new JLabel();
		mSRDate.setBounds(139, 111, 191, 35);
		panel_2.add(mSRDate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(16, 479, 1027, 100);
		panelSearchMem.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(27, 48, 90, 23);
		panel_3.add(lblMobile);
		
		mSmobile = new JLabel();
		mSmobile.setBounds(150, 44, 191, 35);
		panel_3.add(mSmobile);
		
		JLabel lblNewLabel_10 = new JLabel("Search by MemID : ");
		lblNewLabel_10.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(97, 60, 185, 25);
		panelSearchMem.add(lblNewLabel_10);
		
		sMSearch = new JTextField();
		sMSearch.setBounds(268, 60, 551, 35);
		panelSearchMem.add(sMSearch);
		sMSearch.setColumns(10);
		
		btnSMemSearch = new JButton("Search");
		btnSMemSearch.setBounds(880, 60, 117, 35);
		panelSearchMem.add(btnSMemSearch);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
	
		panelButtonSearchMem = new JPanel();
		panelButtonSearchMem.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonSearchMem);
		panelButtonSearchMem.setLayout(null);
		
		btnSMemCancel = new JButton("   Cancel");
		btnSMemCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMemCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSMemCancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearchMem.add(btnSMemCancel);
		
		btnSMemClear = new JButton("   Clear");
		btnSMemClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMemClear.setIcon(new ImageIcon("images/clear.png"));
		btnSMemClear.setBounds(347, 6, 133, 41);
		panelButtonSearchMem.add(btnSMemClear);
		
		/*JButton btnAdd = new JButton("   Add Membership");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchMem.add(btnAdd);*/
		
		btnSMemSearch.addActionListener(this);
		btnSMemCancel.addActionListener(this);
		btnSMemClear.addActionListener(this);
	}
	
	public void updateMemebrshipUI()
	{
		panelUpdateMem = new JPanel();
		panelUpdateMem.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelUpdateMem.setBounds(280, 110, 1065, 592);
		contentPane.add(panelUpdateMem);
		panelUpdateMem.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 42);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelUpdateMem.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 105, 1027, 156);
		panelUpdateMem.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 37, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		uMfName = new JTextField();
		uMfName.setBounds(139, 33, 191, 35);
		panel_1.add(uMfName);
		uMfName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 37, 90, 23);
		panel_1.add(lblLastName);
		
		uMlName = new JTextField();
		uMlName.setColumns(10);
		uMlName.setBounds(483, 33, 191, 35);
		panel_1.add(uMlName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 37, 90, 23);
		panel_1.add(lblGener);
		
		uMgender = new JComboBox();
		uMgender.setBounds(828, 33, 191, 35);
		panel_1.add(uMgender);
		
		uMgender.addItem("- - - Choose - - -");
		uMgender.addItem("Male");
		uMgender.addItem("Female");
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 104, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		uMdob = new JDateChooser();
		uMdob.setBounds(139, 100, 191, 35);
		panel_1.add(uMdob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Card Information "));
		panel_2.setBounds(16, 289, 1027, 156);
		panelUpdateMem.add(panel_2);
		
		JLabel lblStreet = new JLabel("Membership ID : ");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 41, 120, 23);
		panel_2.add(lblStreet);
		
		JLabel lblDistrict = new JLabel("Card Level : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 40, 90, 23);
		panel_2.add(lblDistrict);
		
		JLabel lblCommune = new JLabel("Discount (%) : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 37, 111, 23);
		panel_2.add(lblCommune);
		
		uMDiscount = new JTextField();
		uMDiscount.setColumns(10);
		uMDiscount.setBounds(828, 33, 191, 35);
		panel_2.add(uMDiscount);
		uMDiscount.setEditable(false);
		
		uMCLevel = new JComboBox();
		uMCLevel.setBounds(483, 33, 191, 35);
		panel_2.add(uMCLevel);
		
		uMCLevel.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(mCardLevel.getSelectedItem().equals("Silver"))
					uMDiscount.setText("10");
				else if(mCardLevel.getSelectedItem().equals("Gold"))
					uMDiscount.setText("20");
				else if(mCardLevel.getSelectedItem().equals("Premium"))
					uMDiscount.setText("30");
			}
		});
		
		uMCLevel.addItem("- - - Choose - - -");
		uMCLevel.addItem("Silver");
		uMCLevel.addItem("Gold");
		uMCLevel.addItem("Premium");
		
		
		JLabel label = new JLabel("Register Date :");
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label.setBounds(16, 110, 111, 23);
		panel_2.add(label);
		
		uMrDate = new JDateChooser();
		uMrDate.setBounds(139, 104, 191, 35);
		panel_2.add(uMrDate);
		
		uMMemID = new JTextField();
		uMMemID.setBounds(139, 33, 191, 35);
		uMMemID.setEditable(false);
		panel_2.add(uMMemID);
		uMMemID.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(16, 473, 1266, 98);
		panelUpdateMem.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(16, 43, 90, 23);
		panel_3.add(lblMobile);
		
		uMmobile = new JTextField();
		uMmobile.setColumns(10);
		uMmobile.setBounds(139, 39, 191, 35);
		panel_3.add(uMmobile);
		
		JLabel lblNewLabel_10 = new JLabel("Search by MemID : ");
		lblNewLabel_10.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(97, 60, 185, 25);
		panelUpdateMem.add(lblNewLabel_10);
		
		uMSearch = new JTextField();
		uMSearch.setBounds(268, 60, 551, 35);
		panelUpdateMem.add(uMSearch);
		uMSearch.setColumns(10);
		
		btnUMemSearch = new JButton("Search");
		btnUMemSearch.setBounds(880, 60, 117, 35);
		panelUpdateMem.add(btnUMemSearch);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
	
		panelButtonUpdateMem = new JPanel();
		panelButtonUpdateMem.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonUpdateMem);
		panelButtonUpdateMem.setLayout(null);
		
		btnUMemCancel = new JButton("   Cancel");
		btnUMemCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMemCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnUMemCancel.setBounds(1, 5, 151, 41);
		
		panelButtonUpdateMem.add(btnUMemCancel);
		
		btnUMemClear = new JButton("   Clear");
		btnUMemClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMemClear.setIcon(new ImageIcon("images/clear.png"));
		btnUMemClear.setBounds(208, 5, 133, 41);
		panelButtonUpdateMem.add(btnUMemClear);
		
		btnUMemUpdate= new JButton("   Update Membership");
		btnUMemUpdate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnUMemUpdate.setIcon(new ImageIcon("images/contract.png"));
		btnUMemUpdate.setBounds(401, 5, 203, 41);
		panelButtonUpdateMem.add(btnUMemUpdate);
		
		btnUMemSearch.addActionListener(this);
		btnUMemCancel.addActionListener(this);
		btnUMemClear.addActionListener(this);
		btnUMemUpdate.addActionListener(this);
		
	}
	public void deleteMembershipUI()
	{
		panelDeleteMem = new JPanel();
		panelDeleteMem.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDeleteMem.setBounds(280, 110, 1065, 592);
		contentPane.add(panelDeleteMem);
		panelDeleteMem.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 46);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDeleteMem.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 105, 1027, 156);
		panelDeleteMem.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Personal Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("First Name :");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 37, 90, 23);
		panel_1.add(lblNewLabel_9);
		
		mDfName = new JLabel();
		mDfName.setBounds(139, 33, 191, 35);
		panel_1.add(mDfName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 37, 90, 23);
		panel_1.add(lblLastName);
		
		mDlName = new JLabel();
		mDlName.setBounds(483, 33, 191, 35);
		panel_1.add(mDlName);
		
		JLabel lblGener = new JLabel("Gender :");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 37, 90, 23);
		panel_1.add(lblGener);
		
		mDgender = new JLabel();
		mDgender.setBounds(828, 33, 191, 35);
		panel_1.add(mDgender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 104, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		mDdob = new JLabel();
		mDdob.setBounds(139, 100, 191, 35);
		panel_1.add(mDdob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Card Information "));
		panel_2.setBounds(20, 286, 1027, 156);
		panelDeleteMem.add(panel_2);
		
		JLabel lblStreet = new JLabel("Membership ID : ");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 39, 120, 23);
		panel_2.add(lblStreet);
		
		JLabel lblDistrict = new JLabel("Card Level : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 40, 90, 23);
		panel_2.add(lblDistrict);
		
		JLabel lblCommune = new JLabel("Discount : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 37, 90, 23);
		panel_2.add(lblCommune);
		
		mDDiscount = new JLabel();
		mDDiscount.setBounds(828, 33, 191, 35);
		panel_2.add(mDDiscount);
		
		mRDDate = new JLabel();
		mRDDate.setBounds(139, 33, 191, 35);
		panel_2.add(mRDDate);
		
		mDCLevel = new JLabel();
		mDCLevel.setBounds(483, 33, 191, 35);
		panel_2.add(mDCLevel);
		
		JLabel label = new JLabel("Register Date :");
		label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		label.setBounds(16, 103, 111, 23);
		panel_2.add(label);
		mDMemID = new JLabel();
		mDMemID.setBounds(139, 97, 191, 35);
		panel_2.add(mDMemID);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createTitledBorder(" Contact Information "));
		panel_3.setBounds(20, 465, 1027, 97);
		panelDeleteMem.add(panel_3);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblMobile.setBounds(16, 43, 90, 23);
		panel_3.add(lblMobile);
		
		mDmobile = new JLabel();
		mDmobile.setBounds(139, 39, 191, 35);
		panel_3.add(mDmobile);
		
		JLabel lblNewLabel_10 = new JLabel("Search by MemID : ");
		lblNewLabel_10.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(97, 60, 185, 25);
		panelDeleteMem.add(lblNewLabel_10);
		
		dMSearch = new JTextField();
		dMSearch.setBounds(268, 60, 551, 35);
		panelDeleteMem.add(dMSearch);
		dMSearch.setColumns(10);
		
		btnDMemSearch = new JButton("Search");
		btnDMemSearch.setBounds(880, 60, 117, 35);
		panelDeleteMem.add(btnDMemSearch);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
		
		((javax.swing.border.TitledBorder) panel_3.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_3.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_3.repaint();
	
		panelButtomDeleteMem = new JPanel();
		panelButtomDeleteMem.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtomDeleteMem);
		panelButtomDeleteMem.setLayout(null);
		
		
		btnDMemCancel = new JButton("   Cancel");
		btnDMemCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMemCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDMemCancel.setBounds(1, 5, 151, 41);
		
		panelButtomDeleteMem.add(btnDMemCancel);
		
		btnDMemClear = new JButton("   Clear");
		btnDMemClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMemClear.setIcon(new ImageIcon("images/clear.png"));
		btnDMemClear.setBounds(210, 5, 133, 41);
		panelButtomDeleteMem.add(btnDMemClear);
		
		btnDMemDelete = new JButton("   Delete Membership");
		btnDMemDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMemDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDMemDelete.setBounds(401, 5, 198, 41);
		panelButtomDeleteMem.add(btnDMemDelete);
		
		/*JButton btnAdd = new JButton("   Add Membership");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchMem.add(btnAdd);*/
		
		btnDMemSearch.addActionListener(this);
		btnDMemCancel.addActionListener(this);
		btnDMemClear.addActionListener(this);
		btnDMemDelete.addActionListener(this);
	}
	
	public void viewGeneralSaleUI()
	{
		panelViewGenSale = new JPanel();
		panelViewGenSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelViewGenSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelViewGenSale);
		panelViewGenSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("General Sale List");
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelViewGenSale.add(lblNewLabel_2);
		
		tableVGensale = new DefaultTableModel();
		tableVGensale.addColumn("Gen-SaleID");
		tableVGensale.addColumn("ScheduleID");
		tableVGensale.addColumn("DateSale");
		tableVGensale.addColumn("EmployeeID");
		tableVGensale.addColumn("TotalPrice");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(16, 70, 1030, 504);
		panel_1.setLayout(new BorderLayout());
		panelViewGenSale.add(panel_1);
		
		tableVGSale = new JTable(tableVGensale);
		tableVGSale.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableVGSale.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableVGSale), BorderLayout.CENTER);
		
		tableVGSale.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableVGSale.getTableHeader().setBackground(new Color(204,0,0));
		tableVGSale.getTableHeader().setForeground(Color.WHITE);
		tableVGSale.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableVGSale.setRowHeight(28);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableVGSale.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableVGSale.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableVGSale.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableVGSale.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableVGSale.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableVGSale.getColumnModel().getColumn(4).setCellRenderer(renderer);

	    tableVGSale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableVGSale.getSelectedRow() != -1) { 
		        	String id = (String) tableVGSale.getModel().getValueAt(tableVGSale.getSelectedRow(), 0);
		        	ssP = new SalePart();
		        	Sale s = ssP.searchFromTableSales(id);
		        	sP = new SchedulePart();
		        	MovieSchedule m1 = sP.searchByID(s.getScheduleID());
		        	mP = new MoviePart();
		        	Movie m = mP.searchByID(m1.getMovieID());
		            frame4 = new detailViewGensale(s,m,m1);
		            frame4.setVisible(true); 
		        }
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
				
			}
		});
		panelButtonGenSale = new JPanel();
		panelButtonGenSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonGenSale);
		panelButtonGenSale.setLayout(null);
		
		btnVGCancel = new JButton("   Cancel");
		btnVGCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVGCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnVGCancel.setBounds(130, 6, 151, 41);
		
		panelButtonGenSale.add(btnVGCancel);
		
		btnVGDelete = new JButton("   Delete");
		btnVGDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVGDelete.setIcon(new ImageIcon("images/clear.png"));
		btnVGDelete.setBounds(347, 6, 133, 41);
		panelButtonGenSale.add(btnVGDelete);
		
		/*JButton btnAdd = new JButton("   Delete");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonGenSale.add(btnAdd);*/
		
		btnVGCancel.addActionListener(this);
		btnVGDelete.addActionListener(this);
	}
	public void searchGenSaleUI()
	{
		panelSearchGenSale = new JPanel();
		panelSearchGenSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearchGenSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelSearchGenSale);
		panelSearchGenSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("General Sale List");
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearchGenSale.add(lblNewLabel_2);
		
		tableSGensale = new DefaultTableModel();
		tableSGensale.addColumn("Gen-SaleID");
		tableSGensale.addColumn("ScheduleID");
		tableSGensale.addColumn("DateSale");
		tableSGensale.addColumn("EmployeeID");
		tableSGensale.addColumn("TotalPrice");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(19, 110, 1029, 467);
		panel_1.setLayout(new BorderLayout());
		panelSearchGenSale.add(panel_1);
		
		tableSGSale = new JTable(tableSGensale);
		tableSGSale.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableSGSale.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableSGSale), BorderLayout.CENTER);
		
		tableSGSale.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableSGSale.getTableHeader().setBackground(new Color(204,0,0));
		tableSGSale.getTableHeader().setForeground(Color.WHITE);
		tableSGSale.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableSGSale.setRowHeight(28);
		
		JLabel lblSearch_3 = new JLabel("Search : ");
		lblSearch_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_3.setBounds(99, 68, 88, 25);
		panelSearchGenSale.add(lblSearch_3);
		
		btnSGSearch = new JButton("Search");
		btnSGSearch.setBounds(878, 63, 117, 35);
		panelSearchGenSale.add(btnSGSearch);
		
		sGDate = new JDateChooser();
		sGDate.setBounds(250, 63, 551, 35);
		panelSearchGenSale.add(sGDate);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableSGSale.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableSGSale.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableSGSale.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableSGSale.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableSGSale.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableSGSale.getColumnModel().getColumn(4).setCellRenderer(renderer);
	
	    tableSGSale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableSGSale.getSelectedRow() != -1) {
		        	String id = (String) tableSGSale.getModel().getValueAt(tableSGSale.getSelectedRow(), 0);
		        	ssP = new SalePart();
		        	Sale s = ssP.searchFromTableSales(id);
		        	sP = new SchedulePart();
		        	MovieSchedule m1 = sP.searchByID(s.getScheduleID());
		        	mP = new MoviePart();
		        	Movie m = mP.searchByID(m1.getMovieID());
		            frame4 = new detailViewGensale(s,m,m1);
		            frame4.setVisible(true);
		        }
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
				
			}
		});
	    
		panelButtonSearchGenSale = new JPanel();
		panelButtonSearchGenSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonSearchGenSale);
		panelButtonSearchGenSale.setLayout(null);
		
		btnSGCancel = new JButton("   Cancel");
		btnSGCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSGCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSGCancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearchGenSale.add(btnSGCancel);
		
		btnSGDelete = new JButton("   Delete");
		btnSGDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSGDelete.setIcon(new ImageIcon("images/clear.png"));
		btnSGDelete.setBounds(347, 6, 133, 41);
		panelButtonSearchGenSale.add(btnSGDelete);
		
		/*JButton btnAdd = new JButton("   Delete");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonGenSale.add(btnAdd);*/
		
		btnSGCancel.addActionListener(this);
		btnSGDelete.addActionListener(this);
		btnSGSearch.addActionListener(this);
	}
	public void deleteGenSaleUI()
	{
		panelDeleteGenSale = new JPanel();
		panelDeleteGenSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDeleteGenSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelDeleteGenSale);
		panelDeleteGenSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("General Sale List");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDeleteGenSale.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 110, 1027, 180);
		panelDeleteGenSale.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Movie Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Movie Name : ");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 48, 111, 23);
		panel_1.add(lblNewLabel_9);
		
		sgMName = new JLabel();
		sgMName.setBounds(139, 44, 191, 35);
		panel_1.add(sgMName);
		
		JLabel lblLastName = new JLabel("Running Time : ");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 48, 122, 23);
		panel_1.add(lblLastName);
		
		sgMRun = new JLabel();
		sgMRun.setBounds(483, 44, 191, 35);
		panel_1.add(sgMRun);
		
		JLabel lblGener = new JLabel("Time Start : ");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 48, 90, 23);
		panel_1.add(lblGener);
		
		sgMTime = new JLabel();
		sgMTime.setBounds(828, 44, 191, 35);
		panel_1.add(sgMTime);
		
		JLabel lblDateOfBirth = new JLabel("Hall : ");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 115, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		sgMHall= new JLabel();
		sgMHall.setBounds(139, 111, 191, 35);
		panel_1.add(sgMHall);
		
		JLabel lblSalary = new JLabel("Total Seat : ");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 115, 90, 23);
		panel_1.add(lblSalary);
		
		sgMTSeat = new JLabel();
		sgMTSeat.setBounds(483, 111, 191, 35);
		panel_1.add(sgMTSeat);
		
		JLabel lblTicketPrice_1 = new JLabel("Ticket Price : ");
		lblTicketPrice_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketPrice_1.setBounds(705, 115, 105, 23);
		panel_1.add(lblTicketPrice_1);
		
		sgMTPrice = new JLabel();
		sgMTPrice.setBounds(828, 111, 191, 35);
		panel_1.add(sgMTPrice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Sale Information "));
		panel_2.setBounds(16, 316, 1027, 250);
		panelDeleteGenSale.add(panel_2);
		
		JLabel lblStreet = new JLabel("Sale ID : ");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 48, 90, 23);
		panel_2.add(lblStreet);
		
		sgSaleID = new JLabel();
		sgSaleID.setBounds(139, 44, 191, 35);
		panel_2.add(sgSaleID);
		
		JLabel lblDistrict = new JLabel("Date : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 52, 90, 23);
		panel_2.add(lblDistrict);
		
		sgDate = new JLabel();
		sgDate.setBounds(483, 48, 191, 35);
		panel_2.add(sgDate);
		
		JLabel lblCommune = new JLabel("Time : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 52, 90, 23);
		panel_2.add(lblCommune);
		
		sgTime = new JLabel();
		sgTime.setBounds(828, 48, 191, 35);
		panel_2.add(sgTime);
		
		JLabel lblCityProvince = new JLabel("Ticket Amount : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(16, 115, 123, 23);
		panel_2.add(lblCityProvince);
		
		sgTAmount = new JLabel();
		sgTAmount.setBounds(139, 111, 191, 35);
		panel_2.add(sgTAmount);
		
		JLabel lblCountry = new JLabel("Total Price : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(360, 119, 90, 23);
		panel_2.add(lblCountry);
		
		sgTPrice = new JLabel();
		sgTPrice.setBounds(483, 115, 191, 35);
		panel_2.add(sgTPrice);
		
		JLabel lblPayment = new JLabel("Payment : ");
		lblPayment.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPayment.setBounds(705, 119, 90, 23);
		panel_2.add(lblPayment);
		
		sgPayment = new JLabel();
		sgPayment.setBounds(828, 115, 191, 35);
		panel_2.add(sgPayment);
		
		JLabel lblYourReturn = new JLabel("Your Return : ");
		lblYourReturn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblYourReturn.setBounds(16, 185, 123, 23);
		panel_2.add(lblYourReturn);
		
		sgYourReturn = new JLabel();
		sgYourReturn.setBounds(139, 181, 191, 35);
		panel_2.add(sgYourReturn);
		
		sgEID = new JLabel();
		sgEID.setBounds(483, 185, 191, 35);
		panel_2.add(sgEID);
		
		JLabel lblEmployeeId = new JLabel("Employee ID : ");
		lblEmployeeId.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployeeId.setBounds(360, 189, 111, 23);
		panel_2.add(lblEmployeeId);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
	
		panelButtonDeleteGenSale= new JPanel();
		panelButtonDeleteGenSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonDeleteGenSale);
		panelButtonDeleteGenSale.setLayout(null);
		
		btnDGCancel = new JButton("   Cancel");
		btnDGCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDGCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDGCancel.setBounds(1, 5, 151, 41);
		
		panelButtonDeleteGenSale.add(btnDGCancel);
		
		btnDGClear = new JButton("   Clear");
		btnDGClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDGClear.setIcon(new ImageIcon("images/clear.png"));
		btnDGClear.setBounds(218, 5, 133, 41);
		panelButtonDeleteGenSale.add(btnDGClear);
		
		btnDGDelete = new JButton("   Delete Gensale");
		btnDGDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDGDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDGDelete.setBounds(411, 5, 188, 41);
		panelButtonDeleteGenSale.add(btnDGDelete);
		

		JLabel lblSearch_2 = new JLabel("Search by SaleID : ");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(96, 65, 185, 23);
		panelDeleteGenSale.add(lblSearch_2);
		
		sgSearch = new JTextField();
		sgSearch.setBounds(284, 61, 551, 36);
		panelDeleteGenSale.add(sgSearch);
		sgSearch.setColumns(10);
		
		btnDGSearch = new JButton("Search");
		btnDGSearch.setBounds(868, 61, 117, 36);
		panelDeleteGenSale.add(btnDGSearch);
		
		/*JButton btnAdd = new JButton("   Add Employee");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchEmp.add(btnAdd);*/
		
		btnDGCancel.addActionListener(this);
		btnDGClear.addActionListener(this);
		btnDGDelete.addActionListener(this);
		btnDGSearch.addActionListener(this);
	}
	
	public void viewMemSaleUI()
	{
		panelViewMemSale = new JPanel();
		panelViewMemSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelViewMemSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelViewMemSale);
		panelViewMemSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Sale List");
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelViewMemSale.add(lblNewLabel_2);
		
		tableVMemsale= new DefaultTableModel();
		tableVMemsale.addColumn("Mem-SaleID");
		tableVMemsale.addColumn("MembershipID");
		tableVMemsale.addColumn("ScheduleID");
		tableVMemsale.addColumn("DateSale");
		tableVMemsale.addColumn("EmployeeID");
		tableVMemsale.addColumn("TotalPrice");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(16, 70, 1031, 506);
		panel_1.setLayout(new BorderLayout());
		panelViewMemSale.add(panel_1);
		
		tableVMSale = new JTable(tableVMemsale);
		tableVMSale.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableVMSale.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableVMSale), BorderLayout.CENTER);
		
		tableVMSale.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableVMSale.getTableHeader().setBackground(new Color(204,0,0));
		tableVMSale.getTableHeader().setForeground(Color.WHITE);
		tableVMSale.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableVMSale.setRowHeight(28);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableVMSale.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableVMSale.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableVMSale.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableVMSale.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableVMSale.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableVMSale.getColumnModel().getColumn(4).setCellRenderer(renderer);
	    tableVMSale.getColumnModel().getColumn(5).setCellRenderer(renderer);
	    
	    tableVMSale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableVMSale.getSelectedRow() != -1) {
		        	String id = (String) tableVMSale.getModel().getValueAt(tableVMSale.getSelectedRow(), 0);
		        	ssP = new SalePart();
		        	Sale s = ssP.searchFromTableSales(id);
		        	sP = new SchedulePart();
		        	MovieSchedule m1 = sP.searchByID(s.getScheduleID());
		        	mP = new MoviePart();
		        	Movie m = mP.searchByID(m1.getMovieID());
		            frame5 = new detailViewMemsale(s,m,m1);
		            frame5.setVisible(true);
		        }
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
				
			}
		});
		panelButtonViewMemSale = new JPanel();
		panelButtonViewMemSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonViewMemSale);
		panelButtonViewMemSale.setLayout(null);
		
		btnVMSCancel = new JButton("   Cancel");
		btnVMSCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVMSCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnVMSCancel.setBounds(130, 6, 151, 41);
		
		panelButtonViewMemSale.add(btnVMSCancel);
		
		btnVMSDelete = new JButton("   Delete");
		btnVMSDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnVMSDelete.setIcon(new ImageIcon("images/clear.png"));
		btnVMSDelete.setBounds(347, 6, 133, 41);
		panelButtonViewMemSale.add(btnVMSDelete);
		
		/*JButton btnAdd = new JButton("   Delete");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonGenSale.add(btnAdd);*/
		btnVMSCancel.addActionListener(this);
		btnVMSDelete.addActionListener(this);
		
	}
	public void searchMemSaleUI()
	{
		panelSearchMemSale = new JPanel();
		panelSearchMemSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelSearchMemSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelSearchMemSale);
		panelSearchMemSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Sale List");
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelSearchMemSale.add(lblNewLabel_2);
		
		tableSMensale = new DefaultTableModel();
		tableSMensale.addColumn("Gen-SaleID");
		tableSMensale.addColumn("MembershipID");
		tableSMensale.addColumn("ScheduleID");
		tableSMensale.addColumn("DateSale");
		tableSMensale.addColumn("EmployeeID");
		tableSMensale.addColumn("TotalPrice");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(18, 116, 1028, 459);
		panel_1.setLayout(new BorderLayout());
		panelSearchMemSale.add(panel_1);
		
		tableSMSale = new JTable(tableSMensale);
		tableSMSale.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableSMSale.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		panel_1.add(new JScrollPane(tableSMSale), BorderLayout.CENTER);
		
		tableSMSale.getTableHeader().setPreferredSize(new Dimension(100,37));
		tableSMSale.getTableHeader().setBackground(new Color(204,0,0));
		tableSMSale.getTableHeader().setForeground(Color.WHITE);
		tableSMSale.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		tableSMSale.setRowHeight(28);
		
		JLabel lblSearch_3 = new JLabel("Search : ");
		lblSearch_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_3.setBounds(97, 68, 88, 25);
		panelSearchMemSale.add(lblSearch_3);
		
		btnSMSSearch = new JButton("Search");
		btnSMSSearch.setBounds(876, 63, 117, 35);
		panelSearchMemSale.add(btnSMSSearch);
		
		sMDate = new JDateChooser();
		sMDate.setBounds(248, 63, 551, 35);
		panelSearchMemSale.add(sMDate);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
				tableSMSale.getTableHeader().getDefaultRenderer();
	          renderer.setHorizontalAlignment(JLabel.CENTER);
	          
	    renderer = new DefaultTableCellRenderer();
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    tableSMSale.getColumnModel().getColumn(0).setCellRenderer(renderer);
	    tableSMSale.getColumnModel().getColumn(1).setCellRenderer(renderer);
	    tableSMSale.getColumnModel().getColumn(2).setCellRenderer(renderer);
	    tableSMSale.getColumnModel().getColumn(3).setCellRenderer(renderer);
	    tableSMSale.getColumnModel().getColumn(4).setCellRenderer(renderer);
	    tableSMSale.getColumnModel().getColumn(5).setCellRenderer(renderer);
	    
	    tableSMSale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && tableSMSale.getSelectedRow() != -1) {
		        	String id = (String) tableSMSale.getModel().getValueAt(tableSMSale.getSelectedRow(), 0);
		        	ssP = new SalePart();
		        	Sale s = ssP.searchFromTableSales(id);
		        	sP = new SchedulePart();
		        	MovieSchedule m1 = sP.searchByID(s.getScheduleID());
		        	mP = new MoviePart();
		        	Movie m = mP.searchByID(m1.getMovieID());
		            frame5 = new detailViewMemsale(s,m,m1);
		            frame5.setVisible(true);
		        }
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
				
			}
		});
		panelButtonSearchMemSale= new JPanel();
		panelButtonSearchMemSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonSearchMemSale);
		panelButtonSearchMemSale.setLayout(null);
		
		btnSMSCancel = new JButton("   Cancel");
		btnSMSCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMSCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnSMSCancel.setBounds(130, 6, 151, 41);
		
		panelButtonSearchMemSale.add(btnSMSCancel);
		
		btnSMSDelete = new JButton("   Delete");
		btnSMSDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnSMSDelete.setIcon(new ImageIcon("images/clear.png"));
		btnSMSDelete.setBounds(347, 6, 133, 41);
		panelButtonSearchMemSale.add(btnSMSDelete);
		
		/*JButton btnAdd = new JButton("   Delete");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 166, 41);
		panelButtonGenSale.add(btnAdd);*/
		
		btnSMSCancel.addActionListener(this);
		btnSMSDelete.addActionListener(this);
		btnSMSSearch.addActionListener(this);
	}
	public void deleteMemSaleUI()
	{
		panelDeleteMemSale = new JPanel();
		panelDeleteMemSale.setBorder(new LineBorder(new Color(204, 0, 0), 3));
		panelDeleteMemSale.setBounds(280, 110, 1065, 592);
		contentPane.add(panelDeleteMemSale);
		panelDeleteMemSale.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Sale Information");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 8, 1053, 50);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		panelDeleteMemSale.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 110, 1027, 180);
		panelDeleteMemSale.add(panel_1);
		
		panel_1.setBorder(BorderFactory.createTitledBorder(" Movie Information "));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Movie Name : ");
		lblNewLabel_9.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(16, 48, 111, 23);
		panel_1.add(lblNewLabel_9);
		
		smMName = new JLabel();
		smMName.setBounds(139, 44, 190, 35);
		panel_1.add(smMName);
		
		JLabel lblLastName = new JLabel("Running Time : ");
		lblLastName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblLastName.setBounds(360, 48, 122, 23);
		panel_1.add(lblLastName);
		
		smMRun = new JLabel();
		smMRun.setBounds(483, 44, 191, 35);
		panel_1.add(smMRun);
		
		JLabel lblGener = new JLabel("Time Start : ");
		lblGener.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblGener.setBounds(705, 48, 90, 23);
		panel_1.add(lblGener);
		
		smMTime = new JLabel();
		smMTime.setBounds(828, 44, 191, 35);
		panel_1.add(smMTime);
		
		JLabel lblDateOfBirth = new JLabel("Hall : ");
		lblDateOfBirth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(16, 115, 111, 23);
		panel_1.add(lblDateOfBirth);
		
		smMHall = new JLabel();
		smMHall.setBounds(139, 111, 190, 35);
		panel_1.add(smMHall);
		
		JLabel lblSalary = new JLabel("Total Seat : ");
		lblSalary.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblSalary.setBounds(360, 115, 90, 23);
		panel_1.add(lblSalary);
		
		smMTSeat = new JLabel();
		smMTSeat.setBounds(483, 111, 191, 35);
		panel_1.add(smMTSeat);
		
		JLabel lblTicketPrice_1 = new JLabel("Ticket Price : ");
		lblTicketPrice_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblTicketPrice_1.setBounds(705, 115, 105, 23);
		panel_1.add(lblTicketPrice_1);
		
		smMTPrice = new JLabel();
		smMTPrice.setBounds(828, 111, 191, 35);
		panel_1.add(smMTPrice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder(" Sale Information "));
		panel_2.setBounds(16, 316, 1027, 250);
		panelDeleteMemSale.add(panel_2);
		
		JLabel lblStreet = new JLabel("Sale ID : ");
		lblStreet.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblStreet.setBounds(16, 48, 123, 23);
		panel_2.add(lblStreet);
		
		smSaleID = new JLabel();
		smSaleID.setBounds(139, 44, 190, 35);
		panel_2.add(smSaleID);
		JLabel lblDistrict = new JLabel("Membership ID : ");
		lblDistrict.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblDistrict.setBounds(360, 48, 123, 23);
		panel_2.add(lblDistrict);
		
		smMemID = new JLabel();
		smMemID.setBounds(483, 44, 191, 35);
		panel_2.add(smMemID);
		
		JLabel lblCommune = new JLabel("Employee ID : ");
		lblCommune.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCommune.setBounds(705, 48, 123, 23);
		panel_2.add(lblCommune);
		
		smEID = new JLabel();
		smEID.setBounds(828, 44, 191, 35);
		panel_2.add(smEID);
		
		JLabel lblCityProvince = new JLabel("Date : ");
		lblCityProvince.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCityProvince.setBounds(16, 115, 123, 23);
		panel_2.add(lblCityProvince);
		
		smDate = new JLabel();
		smDate.setBounds(139, 111, 190, 35);
		panel_2.add(smDate);
		
		JLabel lblCountry = new JLabel("Time : ");
		lblCountry.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblCountry.setBounds(360, 115, 90, 23);
		panel_2.add(lblCountry);
		
		smTime = new JLabel();
		smTime.setBounds(483, 111, 191, 35);
		panel_2.add(smTime);
		
		JLabel lblPayment = new JLabel("Ticket Amount : ");
		lblPayment.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblPayment.setBounds(705, 115, 123, 23);
		panel_2.add(lblPayment);
		
		smTAmount = new JLabel();
		smTAmount.setBounds(828, 111, 191, 35);
		panel_2.add(smTAmount);
		
		JLabel lblYourReturn = new JLabel("Total Price : ");
		lblYourReturn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblYourReturn.setBounds(16, 185, 123, 23);
		panel_2.add(lblYourReturn);
		
		smTPrice = new JLabel();
		smTPrice.setBounds(139, 181, 190, 35);
		panel_2.add(smTPrice);
		
		smPayment = new JLabel();
		smPayment.setBounds(483, 181, 191, 35);
		panel_2.add(smPayment);
		
		JLabel lblEmployee = new JLabel("Payment : ");
		lblEmployee.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblEmployee.setBounds(360, 185, 123, 23);
		panel_2.add(lblEmployee);
		
		JLabel lblYourReturn_1 = new JLabel("Your Return : ");
		lblYourReturn_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		lblYourReturn_1.setBounds(705, 185, 123, 23);
		panel_2.add(lblYourReturn_1);
		
		smYourReturn = new JLabel();
		smYourReturn.setBounds(828, 181, 193, 35);
		panel_2.add(smYourReturn);
		
		((javax.swing.border.TitledBorder) panel_1.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_1.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_1.repaint();
		
		((javax.swing.border.TitledBorder) panel_2.getBorder()).
        setTitleFont(new Font("Comic Sans MS", Font.BOLD, 18));
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleColor(new Color(204, 0, 0));
		panel_2.repaint();
	
		panelButtonDeleteMemSale= new JPanel();
		panelButtonDeleteMemSale.setBounds(538, 706, 610, 65);
		contentPane.add(panelButtonDeleteMemSale);
		panelButtonDeleteMemSale.setLayout(null);
		
		btnDMSCancel = new JButton("   Cancel");
		btnDMSCancel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMSCancel.setIcon(new ImageIcon("images/close (1).png"));
		btnDMSCancel.setBounds(1, 5, 151, 41);
		
		panelButtonDeleteMemSale.add(btnDMSCancel);
		
		btnDMSClear = new JButton("   Clear");
		btnDMSClear.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMSClear.setIcon(new ImageIcon("images/clear.png"));
		btnDMSClear.setBounds(218, 5, 133, 41);
		panelButtonDeleteMemSale.add(		btnDMSClear);
		
		btnDMSDelete = new JButton("   Delete MemSale");
		btnDMSDelete.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnDMSDelete.setIcon(new ImageIcon("images/contract.png"));
		btnDMSDelete.setBounds(411, 5, 188, 41);
		panelButtonDeleteMemSale.add(btnDMSDelete);
		

		JLabel lblSearch_2 = new JLabel("Search by SaleID : ");
		lblSearch_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		lblSearch_2.setBounds(97, 64, 185, 23);
		panelDeleteMemSale.add(lblSearch_2);
		
		smSearch = new JTextField();
		smSearch.setBounds(285, 60, 551, 36);
		panelDeleteMemSale.add(smSearch);
		smSearch.setColumns(10);
		
		btnDMSSearch = new JButton("Search");
		btnDMSSearch.setBounds(869, 60, 117, 36);
		panelDeleteMemSale.add(btnDMSSearch);
		
		/*JButton btnAdd = new JButton("   Add Employee");
		btnAdd.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
		btnAdd.setIcon(new ImageIcon("/Users/phakneath/Downloads/contract.png"));
		btnAdd.setBounds(416, 5, 176, 41);
		panelButtonSearchEmp.add(btnAdd);*/
		
		btnDMSCancel.addActionListener(this);
		btnDMSClear.addActionListener(this);
		btnDMSSearch.addActionListener(this);
		btnDMSDelete.addActionListener(this);
	}
	
	///////////////////////// Add Movie /////////////////////////////
	
	public void AddMovie()
	{
		String name = mName.getText().toString().trim();
		String language = mLanguage.getText().toString().trim();
		String subtitle = mSubtitle.getText().toString().trim();
		String formats = cboFormats.getSelectedItem().toString();
		int running = Integer.parseInt(mRun.getText().toString());
		String genre = mGenre.getText().toString().trim();
		String open = DateFormat.getDateInstance().format(openDateChooser.getDate());
		String cast = mCast.getText().toString().trim();
		String director = mDirector.getText().toString().trim();
		String importFrom = mFrom.getText().toString().trim();
		double importPrice = Double.parseDouble(mPirce.getText().toString().trim());
		String importDate = DateFormat.getDateInstance().format(importDateChooser.getDate());
		String image = fileName;
		
		String sum = summary.getText().toString();
		
		String id = System.currentTimeMillis() + "";
		
		Movie m = new Movie(id, name, language, subtitle, formats, running, genre, open, cast, director, importFrom,importDate, importPrice, image, sum);
		mP = new MoviePart();
		mP.inputIntoTableMovie(m);
	}
	
	public void ViewMovie()
	{
		panelViewMovie = new JPanel();
		spViewMovie.setViewportView(panelViewMovie);
		mP = new MoviePart();
		
		if(mP.getFromTableMovie().size() >0) 
		{
			ms = mP.getFromTableMovie();
			int size = ms.size();
			if(size % 4 == 0)
			{
				int row = size / 4;
				panelViewMovie.setLayout(new GridLayout(row, 4, 0, 0));
			}
			else
			{
				int row = (size / 4) + 1;
				panelViewMovie.setLayout(new GridLayout(row, 4, 0, 0));
			}
			
			for(Movie m : ms) {
				JPanel panel_8 = new JPanel();
				panel_8.setLayout(new BorderLayout(0, 0));
				
				mVIcon = new JLabel();
				panel_8.add(mVIcon, BorderLayout.CENTER);
				mVIcon.setIcon(new ImageIcon(m.getImage()));
				mVIcon.setPreferredSize(new Dimension(200,200));
				
				JLabel movieTitle = new JLabel(m.getName());
				movieTitle.setHorizontalAlignment(SwingConstants.CENTER);
				movieTitle.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
				movieTitle.setPreferredSize(new Dimension(100,50));
				panel_8.add(movieTitle, BorderLayout.SOUTH);
				
				JPanel con = new JPanel();
				con.add(panel_8);
				panelViewMovie.add(con);
				
				panel_8.addMouseListener(new MouseListener() {
					
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
						//JOptionPane.showMessageDialog(null, m.getName());
						frame = new detailViewMovie(m, 1);
						frame.setVisible(true);
					}
				});
			}
		}
	}
	
	public void SearchMovie()
	{
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(mSSearch.getText().toString().trim());
		lblmovieName.setText(":  " + m.getName());
		lbllanguage.setText(":  " +m.getLanguage());
		lblsubtitle.setText(":  " +m.getSubtitle());
		lblformats.setText(":  " +m.getFormat());
		lblrunningtime.setText(":  " +m.getRunningTime()+"");
		lblgenre.setText(":  " +m.getGenre());
		lblopendate.setText(":  " +m.getOpeingDate());
		lblcast.setText(":  " +m.getCast());
		lbldirector.setText(":  " +m.getDirector());
		lblfrom.setText(":  " +m.getImportFrom());
		lbldate.setText(":  " +m.getImportDate());
		lblprice.setText(":  " +m.getImportPrice() + "");
		lblMovieID.setText(":  " +m.getId());
		mSSummary.setText(m.getSummary());
		mSIcon.setIcon(new ImageIcon(m.getImage()));
		
	}
	
	public void UpdateMovie()
	{
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(mUSearch.getText().toString().trim());
		mUName.setText(m.getName());
		mULanguage.setText(m.getLanguage());
		mUSubtitle.setText(m.getSubtitle());
		cboUFormats.setSelectedItem(m.getFormat());
		mURun.setText(m.getRunningTime()+"");
		mUUGenre.setText(m.getGenre());
		
		java.util.Date date=null;
		try {
			date = new SimpleDateFormat("MMM d, yyyy").parse(m.getOpeingDate());
			uOpenDateChooser.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		mUCast.setText(m.getCast());
		mUDirector.setText(m.getDirector());
		mUFrom.setText(m.getImportFrom());
		
		try {
			date = new SimpleDateFormat("MMM d, yyyy").parse(m.getImportDate());
			uImportDateChooser.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mUPirce.setText(m.getImportPrice() + "");
		mUMovieID.setText(m.getId());
		mUSummary.setText(m.getSummary());
		
		mUIcon.setIcon(new ImageIcon(m.getImage()));
	}
	
	public void UpdateBtnExecute()
	{
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(mUSearch.getText().toString().trim());
		String id = m.getId();
		mP.deleteFromTableMovie(id, 0);
		
		String name = mUName.getText().toString().trim();
		String language = mULanguage.getText().toString().trim();
		String subtitle = mUSubtitle.getText().toString().trim();
		String formats = cboUFormats.getSelectedItem().toString();
		int running = Integer.parseInt(mURun.getText().toString());
		String genre = mUUGenre.getText().toString().trim();
		String open = DateFormat.getDateInstance().format(uOpenDateChooser.getDate());
		String cast = mUCast.getText().toString().trim();
		String director = mUDirector.getText().toString().trim();
		String importFrom = mUFrom.getText().toString().trim();
		double importPrice = Double.parseDouble(mUPirce.getText().toString().trim());
		String importDate = DateFormat.getDateInstance().format(uImportDateChooser.getDate());
		String image = null;
		if(fileName == null)  image = m.getImage();
		else image = fileName;
		
		String sum = mUSummary.getText().toString();
		
		Movie m1 = new Movie(id, name, language, subtitle, formats, running, genre, open, cast, director, importFrom,importDate, importPrice, image, sum);
		mP.inputIntoTableMovie(m1);
	}
	
	public void DeleteMovie()
	{
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(mDSearch.getText().toString().trim());
		lblDmovieName.setText(":  " + m.getName());
		lblDlanguage.setText(":  " +m.getLanguage());
		lblDsubtitle.setText(":  " +m.getSubtitle());
		lblDformats.setText(":  " +m.getFormat());
		lblDrunningtime.setText(":  " +m.getRunningTime()+"");
		lblDgenre.setText(":  " +m.getGenre());
		lblDopendate.setText(":  " +m.getOpeingDate());
		lblDcast.setText(":  " +m.getCast());
		lblDdirector.setText(":  " +m.getDirector());
		lblDfrom.setText(":  " +m.getImportFrom());
		lblDdate.setText(":  " +m.getImportDate());
		lblDprice.setText(":  " +m.getImportPrice() + "");
		lblDMovieID.setText(":  " +m.getId());
		mDSummary.setText(m.getSummary());
		mDIcon.setIcon(new ImageIcon(m.getImage()));
	}
	
	public void DeleteBtnExecute()
	{
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(mDSearch.getText().toString());
		mP.deleteFromTableMovie(m.getId(), 1);
	}
	
	public void ClearMovieControl()
	{
		fileName = null;
		mAIcon.setIcon(null);
		mVIcon.setIcon(null);
		mSIcon.setIcon(null);
		mUIcon.setIcon(null);
		mDIcon.setIcon(null);
		mName.setText(""); 
		mLanguage.setText(""); 
		mSubtitle.setText(""); 
		mRun.setText(""); 
		mGenre.setText(""); 
		mCast.setText("");
		mDirector.setText("");
		mFrom.setText(""); 
		mPirce.setText(""); 
		//mImg.setText(""); 
		summary.setText(""); 
		mDSearch.setText(""); 
		mSSearch.setText(""); 
		mUSearch.setText("");
		cboFormats.setSelectedIndex(0); cboUFormats.setSelectedIndex(0);
		java.util.Date date=null;
		openDateChooser.setDate(date); importDateChooser.setDate(date); uOpenDateChooser.setDate(date); uImportDateChooser.setDate(date);
		lblmovieName.setText(":"); lblsubtitle.setText(":"); lblformats.setText(":"); lblrunningtime.setText(":"); lblgenre.setText(":"); lblopendate.setText(":"); lblcast.setText(":"); lbldirector.setText(":"); lblprice.setText(":"); lbldate.setText(":"); lblfrom.setText(":"); lbllanguage.setText(":"); lblMovieID.setText(":");
		mUName.setText(""); mULanguage.setText(""); mUSubtitle.setText(""); mURun.setText(""); mUUGenre.setText(""); mUCast.setText(""); mUDirector.setText(""); mUFrom.setText(""); mUPirce.setText("");
		//mUImg.setText(""); 
		mUMovieID.setText("");
		lblDmovieName.setText(":"); lblDsubtitle.setText(":"); lblDformats.setText(":"); lblDrunningtime.setText(":"); lblDgenre.setText(":"); lblDopendate.setText(":"); lblDcast.setText(":"); lblDdirector.setText(":"); lblDprice.setText(":"); lblDdate.setText(":"); lblDfrom.setText(":"); lblDlanguage.setText(":"); lblDMovieID.setText(":");
		mSSummary.setText(""); mUSummary.setText(""); mDSummary.setText("");
	}	

	//////////////////////////// Add Movie Schedule ///////////////////////////
	public void AddSchedule()
	{
		String movieName = sAName.getSelectedItem().toString();
		
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(movieName);
	
		java.util.Date timer = (java.util.Date) spinnerSTime.getValue();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        String time = format.format(timer);
		int hall = Integer.parseInt(sAHall.getSelectedItem().toString());
		int tSeat = Integer.parseInt(sTSeat.getText().toString());
		int aSeat = Integer.parseInt(sASeat.getText().toString());
		double price = Double.parseDouble(sTPrice.getText().toString());	
		String date = DateFormat.getDateInstance().format(sScheduleDate.getDate()); 
		String MovieID = m.getId();
		String id = System.currentTimeMillis()+"";
		
		sP = new SchedulePart();
		MovieSchedule ms = new MovieSchedule(id, MovieID,time,hall,price,tSeat,aSeat,date);
		sP.inputIntoTableSchedule(ms, movieName);
	}
	public void ViewSchedule()
	{
		JPanel panel_3 = new JPanel();
		spViewSchedule.setViewportView(panel_3);
		
		sP = new SchedulePart();
		if(sP.getFromTableSchedule().size() > 0)
		{
			ss = sP.getFromTableSchedule();
			int size = ss.size();
			if(size % 2 == 0)
			{
				int row = size / 2;
				panel_3.setLayout(new GridLayout(row, 2, 0, 0));
			}
			else 
			{
				int row = (size /2) +1;
				panel_3.setLayout(new GridLayout(row, 2, 0, 0));
			}
			for(MovieSchedule s: ss)
			{
				mP = new MoviePart();
				Movie m = mP.searchByID(s.getMovieID());
				
				JPanel sch = new JPanel(new BorderLayout());
				sch.setBorder(new LineBorder(new Color(0, 0, 0)));
				sch.addMouseListener(new MouseListener() {
					
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
						frame1 = new detailViewSchedule(s, m);
						frame1.setVisible(true);
					}
				});
				
			
				sVIcon = new JLabel();
				sVIcon.setIcon(new ImageIcon(m.getImage()));
				sVIcon.setPreferredSize(new Dimension(200, 200));
				
				sch.add(sVIcon, "West");
			
				
				JPanel sch1 = new JPanel();
				sch1.setPreferredSize(new Dimension(380, 350));
				
				sch.add(sch1, "Center");
				sch1.setLayout(null);
				
				JLabel lblNewLabel_4 = new JLabel("Movie Name");
				lblNewLabel_4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblNewLabel_4.setBounds(18, 55, 97, 16);
				sch1.add(lblNewLabel_4);
				
				vName = new JLabel();
				vName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vName.setBounds(141, 55, 230, 16);
				sch1.add(vName);
				
				vRun = new JLabel();
				vRun.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vRun.setBounds(141, 99, 230, 16);
				sch1.add(vRun);
				
				if(m != null) {
					vName.setText(": " + m.getName());
					vRun.setText(": " + m.getRunningTime());
				}
				else 
				{
					vName.setText(": Movie not Found");
					vRun.setText(": Not Found");
				}
				
				JLabel label = new JLabel("Time Start");
				label.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				label.setBounds(18, 145, 81, 16);
				sch1.add(label);
				
				vTime = new JLabel(": " + s.getTimeStart());
				vTime.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vTime.setBounds(141, 145, 230, 16);
				sch1.add(vTime);
				
				JLabel lblHall = new JLabel("Hall");
				lblHall.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblHall.setBounds(18, 191, 81, 16);
				sch1.add(lblHall);
				
				vHall = new JLabel(": " + s.getHall());
				vHall.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vHall.setBounds(141, 191, 230, 16);
				sch1.add(vHall);
				
				JLabel lblTotalSeat = new JLabel("Total Seat");
				lblTotalSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblTotalSeat.setBounds(18, 243, 81, 16);
				sch1.add(lblTotalSeat);
				
				vTSeat = new JLabel(": " + s.getTotalSeat());
				vTSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vTSeat.setBounds(141, 243, 230, 16);
				sch1.add(vTSeat);
				
				JLabel lblAvaliableSeat = new JLabel("Avaliable Seat");
				lblAvaliableSeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblAvaliableSeat.setBounds(18, 295, 111, 16);
				sch1.add(lblAvaliableSeat);
				
				vASeat = new JLabel(": " + s.getRemainSeatAvailable());
				vASeat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vASeat.setBounds(141, 295, 230, 16);
				sch1.add(vASeat);
				
				vTPrice = new JLabel();
				/////////////////////////
				/*JLabel lblTicketPrice = new JLabel("Ticket Price");
				lblTicketPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblTicketPrice.setBounds(18, 349, 97, 16);
				sch1.add(lblTicketPrice);
				
				vTPrice = new JLabel(": " + s.getTicketprice());
				vTPrice.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				vTPrice.setBounds(141, 349, 230, 16);
				sch1.add(vTPrice);*/
				/////////////////////////
				
				JLabel lblRunningTime_1 = new JLabel("Running Time");
				lblRunningTime_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
				lblRunningTime_1.setBounds(18, 99, 111, 23);
				sch1.add(lblRunningTime_1);
				
				vDate = new JLabel("DATE: " + s.getScheduleDate());
				vDate.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
				vDate.setBounds(18, 12, 329, 23);
				sch1.add(vDate);
				
				JPanel con = new JPanel();
				con.add(sch);
				
				panel_3.add(con);
			}
		}
	}
	
	public void SearchSchedule()
	{
		mP = new MoviePart();
		for (int i = tableSchedule.getRowCount() - 1; i >= 0; i--) {
		    tableSchedule.removeRow(i);
		}
		
		String search = DateFormat.getDateInstance().format(sSearch.getDate());
		sP = new SchedulePart();
		ss = sP.searchFromTableSchedule(search);
		for(MovieSchedule s : ss)
		{
			Movie m = mP.searchByID(s.getMovieID());
			if(m != null) {
				Object obj[] = {s.getId(), m.getName(), s.getTimeStart(), s.getHall(), s.getTotalSeat(),  s.getScheduleDate()};
				tableSchedule.addRow(obj);
			}
			else
			{
				Object obj[] = {s.getId(), "Not Found", s.getTimeStart(), s.getHall(), s.getTotalSeat(),  s.getScheduleDate()};
				tableSchedule.addRow(obj);
			}
		}

		
	}
	
	public void UpdateSchedule()
	{
		String search = uSearch.getText().toString().trim();
		sP = new SchedulePart();
		
		String s[] = search.split("/");
		String name = s[0];
		String hall = s[1];
		String time = s[2];
		
		MovieSchedule ms = sP.searchSeveralField(hall, name, time);
		
		if(ms != null) {
			mP = new MoviePart();
			Movie m = mP.searchFromTableMovie(name);
			
			uAName.setSelectedItem(m.getName());
			uLanguage.setText(m.getLanguage());
			uSubtitle.setText(m.getSubtitle());
			uFormats.setText(m.getFormat());
			uRun.setText(m.getRunningTime() + "");
			uGenre.setText(m.getGenre());
			uCast.setText(m.getCast());
			uASummary.setText(m.getSummary());
			sUIcon.setIcon(new ImageIcon(m.getImage()));
			
			uScheduleID.setText(ms.getId());
			uAHall.setSelectedItem(ms.getHall()+"");
			uTSeat.setText(ms.getTotalSeat() + "");
			uASeat.setText(ms.getRemainSeatAvailable() + "");
			uTPrice.setText(ms.getTicketprice()+ "");
			
			java.util.Date date=null;
			try {
				date = new SimpleDateFormat("MMM d, yyyy").parse(ms.getScheduleDate());
				//uOpenDateChooser.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			uScheduleDate.setDate(date);
			
			SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
			java.util.Date d=null;
			try {
				d = (java.util.Date)format.parse(ms.getTimeStart());
				spinnerUTime.setValue(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void BtnUpdateExecute()
	{
		String movieName = uAName.getSelectedItem().toString();
		
		mP = new MoviePart();
		Movie m = mP.searchFromTableMovie(movieName);
	
		java.util.Date timer = (java.util.Date) spinnerUTime.getValue();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        String time = format.format(timer);
		int hall = Integer.parseInt(uAHall.getSelectedItem().toString());
		int tSeat = Integer.parseInt(uTSeat.getText().toString());
		int aSeat = Integer.parseInt(uASeat.getText().toString());
		double price = Double.parseDouble(uTPrice.getText().toString());	
		String date = DateFormat.getDateInstance().format(uScheduleDate.getDate()); 
		String MovieID = m.getId();
		String id = uScheduleID.getText().toString();
		
		sP = new SchedulePart();
		sP.deleteFromTableSchedule(id, 0);
		MovieSchedule ms = new MovieSchedule(id, MovieID,time,hall,price,tSeat,aSeat,date);
		sP.inputIntoTableSchedule(ms, movieName);
	}
	
	public void DeleteSchedule()
	{
		String search = dSearch.getText().toString().trim();
		sP = new SchedulePart();
		
		String s[] = search.split("/");
		String name = s[0];
		String hall = s[1];
		String time = s[2];
		
		MovieSchedule ms = sP.searchSeveralField(hall, name, time);
		
		if(ms != null) {
			mP = new MoviePart();
			Movie m = mP.searchFromTableMovie(name);
			
			dName.setText(": " + m.getName());
			dLanguage.setText(": " + m.getLanguage());
			dSubtitle.setText(": " + m.getSubtitle());
			dFormats.setText(": " + m.getFormat());
			dRun.setText(": " + m.getRunningTime());
			dGenre.setText(": " + m.getGenre());
			dCast.setText(": " + m.getCast());
			dASummary.setText(m.getSummary());
			sDIcon.setIcon(new ImageIcon(m.getImage()));
			
			dScheduleID.setText(": " + ms.getId());
			dHall.setText(": " + ms.getHall());
			dTSeat.setText(": " + ms.getTotalSeat());
			dASeat.setText(": " + ms.getRemainSeatAvailable());
			dTPrice.setText(": " + ms.getTicketprice());
			dScheduleDate.setText(": " + ms.getScheduleDate());
			dTime.setText(": " + ms.getTimeStart());
		}
	}
	
	public void BtnDeleteExecute()
	{
		String a = dScheduleID.getText().toString();
		String s[] = a.split(" ");
		
		System.out.println(s[1]);
		sP = new SchedulePart();
		sP.deleteFromTableSchedule(s[1], 1);
	}
	
	public void ClearScheduleControls()
	{
		fileName = null;
		sAIcon.setIcon(null);
		sVIcon.setIcon(null);
		sUIcon.setIcon(null);
		sDIcon.setIcon(null);
		sAName.setSelectedIndex(0); sAHall.setSelectedIndex(0);
		uAName.setSelectedIndex(0); uAHall.setSelectedIndex(0);
		sLanguage.setText(""); sSubtitle.setText(""); sFormats.setText(""); sRun.setText(""); sGenre.setText(""); sCast.setText(""); sTSeat.setText(""); sASeat.setText(""); sTPrice.setText("");
		sASummary.setText("");
		sScheduleDate.setDate(null); sSearch.setDate(null); uScheduleDate.setDate(null);
		//spinnerSTime.setValue(null); spinnerUTime.setValue(null);
	
		for (int i = tableSchedule.getRowCount() - 1; i >= 0; i--) {
		    tableSchedule.removeRow(i);
		}
		uLanguage.setText(""); uSubtitle.setText(""); uFormats.setText(""); uRun.setText(""); uGenre.setText(""); uCast.setText(""); uTSeat.setText(""); uASeat.setText(""); uTPrice.setText(""); uScheduleID.setText(""); uSearch.setText("");
		uASummary.setText("");
		dName.setText(": "); dLanguage.setText(": "); dSubtitle.setText(": "); dFormats.setText(": "); dRun.setText(": "); dGenre.setText(": "); dCast.setText(": "); dScheduleID.setText(": "); dTime.setText(": "); dHall.setText(": "); dTSeat.setText(": "); dASeat.setText(": "); dTPrice.setText(": "); dScheduleDate.setText(": ");
		dSearch.setText("");
		dASummary.setText("");
	}
	
	public void AddEmployee()
	{
		eP = new EmployeePart();
		String firstname = fName.getText().toString().trim();
		String lastname = lName.getText().toString().trim();
		String g = gender.getSelectedItem().toString();
		String dateofbirth = DateFormat.getDateInstance().format(dob.getDate()); 
		double salary = Double.parseDouble(lSalary.getText().toString().trim());
		String s = street.getText().toString().trim();
		String d = district.getText().toString().trim();
		String c = commune.getText().toString().trim();
		String ci = city.getText().toString().trim();
		String count = country.getText().toString().trim();
		String m = mobile.getText().toString().trim();
		String e = email.getText().toString().trim();
		String u = username.getText().toString().trim();
		String p = password.getText().toString().trim();
		String id = System.currentTimeMillis() +"";
		Employee emp = new Employee(id,firstname,lastname,g,dateofbirth,salary,s,d,c,ci,count,m,e,u,p);
		
		eP.inputIntoTableEmployee(emp);
	}
	public void ViewEmployee()
	{
		eP = new EmployeePart();
		
		es = eP.getFromTableEmployee();
		
		if(es != null)
		for(int i=0; i<es.size(); i++)
		{
			Object[] emp= {es.get(i).getfName() + " " + es.get(i).getlName(), es.get(i).getUsername(), es.get(i).getGender(), es.get(i).getPhoneNum(), es.get(i).getEmail()};
			tableEmployee.addRow(emp);
		}
	}

	public void SearchEmployee()
	{
		String usernameSearch = sESearch.getText().toString().trim();
		
		eP = new EmployeePart();
		Employee e = eP.searchFromTableEmployee(usernameSearch);
		
		sfName.setText(e.getfName());
		slName.setText(e.getlName());
		sgender.setText(e.getGender());
		sdob.setText(e.getDob());
		
		slSalary.setText(e.getSalary() + "");
		sEmployeeID.setText(e.getId());
		sstreet.setText(e.getStreet());
		sdistrict.setText(e.getDistrict());
		scommune.setText(e.getCommune());
		scity.setText(e.getCity());
		scountry.setText(e.getCountry());
		smobile.setText(e.getPhoneNum());
		semail.setText(e.getEmail());
		susername.setText(e.getUsername());
		spassword.setText(e.getPassword());
	}
	
	public void UpdateEmployee()
	{
		String usernameSearch = uESearch.getText().toString().trim();
		
		eP = new EmployeePart();
		Employee e = eP.searchFromTableEmployee(usernameSearch);
		
		ufName.setText(e.getfName());
		ulName.setText(e.getlName());
		ugender.setSelectedItem(e.getGender());
		
		java.util.Date date=null;
		try {
			date = new SimpleDateFormat("MMM d, yyyy").parse(e.getDob());
			//uOpenDateChooser.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		udob.setDate(date);
		
		ulSalary.setText(e.getSalary() + "");
		uEmployeeID.setText(e.getId());
		ustreet.setText(e.getStreet());
		udistrict.setText(e.getDistrict());
		ucommune.setText(e.getCommune());
		ucity.setText(e.getCity());
		ucountry.setText(e.getCountry());
		umobile.setText(e.getPhoneNum());
		uemail.setText(e.getEmail());
		uusername.setText(e.getUsername());
		upassword.setText(e.getPassword());
	}
	
	public void UpdateEmployeeBtn()
	{
		eP = new EmployeePart();
		String firstname = ufName.getText().toString().trim();
		String lastname = ulName.getText().toString().trim();
		String g = ugender.getSelectedItem().toString();
		String dateofbirth = DateFormat.getDateInstance().format(udob.getDate()); 
		double salary = Double.parseDouble(ulSalary.getText().toString().trim());
		String s = ustreet.getText().toString().trim();
		String d = udistrict.getText().toString().trim();
		String c = ucommune.getText().toString().trim();
		String ci = ucity.getText().toString().trim();
		String count = ucountry.getText().toString().trim();
		String m = umobile.getText().toString().trim();
		String e = uemail.getText().toString().trim();
		String u = uusername.getText().toString().trim();
		String p = upassword.getText().toString().trim();
		String id = uEmployeeID.getText().toString();
		
		eP.deleteFromTableEmployee(id, 0);
		Employee emp = new Employee(id,firstname,lastname,g,dateofbirth,salary,s,d,c,ci,count,m,e,u,p);
		eP.inputIntoTableEmployee(emp);
	}
	public void DeleteEmployee()
	{
		String usernameSearch = dESearch.getText().toString().trim();
		
		eP = new EmployeePart();
		Employee e = eP.searchFromTableEmployee(usernameSearch);
		
		dfName.setText(e.getfName());
		dlName.setText(e.getlName());
		dgender.setText(e.getGender());
		ddob.setText(e.getDob());
		
		dlSalary.setText(e.getSalary() + "");
		dEmployeeID.setText(e.getId());
		dstreet.setText(e.getStreet());
		ddistrict.setText(e.getDistrict());
		dcommune.setText(e.getCommune());
		dcity.setText(e.getCity());
		dcountry.setText(e.getCountry());
		dmobile.setText(e.getPhoneNum());
		demail.setText(e.getEmail());
		dusername.setText(e.getUsername());
		dpassword.setText(e.getPassword());
	}
	public void DeleteEmployeeBtn()
	{
		eP = new EmployeePart();
		eP.deleteFromTableEmployee(dEmployeeID.getText().toString().trim(), 1);
	}
	
	public void onlyNumber(KeyEvent e)
	{
		 char enter = e.getKeyChar();
	        if(!(Character.isDigit(enter))){
	            e.consume();
	        }
	}
	

	public void ClearEmployeeControls()
	{
		for (int i = tableEmployee.getRowCount() - 1; i >= 0; i--) {
			tableEmployee.removeRow(i);
		}
		
		fName.setText(""); lName.setText(""); lSalary.setText(""); street.setText(""); district.setText(""); commune.setText(""); city.setText(""); country.setText(""); mobile.setText(""); email.setText(""); username.setText(""); password.setText(""); dESearch.setText(""); sESearch.setText("");
		gender.setSelectedIndex(0);
		dob.setDate(null);
		sfName.setText(""); slName.setText(""); slSalary.setText(""); sstreet.setText(""); sdistrict.setText(""); scommune.setText(""); scity.setText(""); scountry.setText(""); smobile.setText(""); semail.setText(""); susername.setText(""); spassword.setText(""); sdob.setText(""); sgender.setText("");  sEmployeeID.setText("");
		ufName.setText(""); ulName.setText(""); ulSalary.setText(""); ustreet.setText(""); udistrict.setText(""); ucommune.setText(""); ucity.setText(""); ucountry.setText(""); umobile.setText(""); uemail.setText(""); uusername.setText(""); upassword.setText(""); uESearch.setText(""); uEmployeeID.setText("");
		ugender.setSelectedIndex(0);
		udob.setDate(null);
		dfName.setText(""); dlName.setText(""); dlSalary.setText(""); dstreet.setText(""); ddistrict.setText(""); dcommune.setText(""); dcity.setText(""); dcountry.setText(""); dmobile.setText(""); demail.setText(""); dusername.setText(""); dpassword.setText(""); ddob.setText(""); dgender.setText(""); dEmployeeID.setText("");
	}
	
	public void AddMembership()
	{
		msP = new MembershipPart();
		String name = mFName.getText().toString().trim();
		String name1 = mLName.getText().toString().trim();
		String gender = mgender.getSelectedItem().toString();
		String dob = DateFormat.getDateInstance().format(mdob.getDate());
		String rDate = DateFormat.getDateInstance().format(mrDate.getDate());
		String clevel = mCardLevel.getSelectedItem().toString();
		String discount = mdiscount.getText().toString().trim();
		String mobile = mmobile.getText().toString().trim();
		String id = name1 + mobile;
		
		Membership m = new Membership(id, name, name1, gender, dob, rDate, clevel, Double.parseDouble(discount), mobile);
		msP.inputIntoTableMembership(m);
	}
	
	public void ViewMembership()
	{
		msP = new MembershipPart();
		mss = msP.getFromTableEmployee();
		if(mss != null)
		{
			for(Membership m:mss)
			{
				Object[] mem = {m.getId(), m.getfName()+ " " + m.getlName(), m.getGender(), m.getMobile(), m.getCardLevel()};
				tableMembership.addRow(mem);
			}
		}
	}
	
	public void SearchMembership()
	{
		String search = sMSearch.getText().toString().trim();
		msP = new MembershipPart();
		Membership m = msP.searchFromTableMembership(search);
		
		mSfName.setText(m.getfName());
		mSlName.setText(m.getlName());
		mSmobile.setText(m.getMobile());
		mSdob.setText(m.getDob());
		mSgender.setText(m.getGender());
		mSMemID.setText(m.getId());
		mSCLevel.setText(m.getCardLevel());
		mSDiscount.setText(m.getDiscount()+"");
		mSRDate.setText(m.getRegisterDate());
	}
	public void UpdateMembership()
	{
		String search = uMSearch.getText().toString().trim();
		msP = new MembershipPart();
		Membership m = msP.searchFromTableMembership(search);
		
		uMfName.setText(m.getfName());
		uMlName.setText(m.getlName());
		uMmobile.setText(m.getMobile());
		java.util.Date date=null;
		try {
			date = new SimpleDateFormat("MMM d, yyyy").parse(m.getDob());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uMdob.setDate(date);
		uMgender.setSelectedItem(m.getGender());
		uMMemID.setText(m.getId());
		uMCLevel.setSelectedItem(m.getCardLevel());
		uMDiscount.setText(m.getDiscount()+"");
		
		try {
			date = new SimpleDateFormat("MMM d, yyyy").parse(m.getRegisterDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uMrDate.setDate(date);
	}
	public void UpdateMembershipBtn()
	{
		msP = new MembershipPart();
		String name = uMfName.getText().toString().trim();
		String name1 = uMlName.getText().toString().trim();
		String gender = uMgender.getSelectedItem().toString();
		String dob = DateFormat.getDateInstance().format(uMdob.getDate());
		String rDate = DateFormat.getDateInstance().format(uMrDate.getDate());
		String clevel = uMCLevel.getSelectedItem().toString();
		String discount = uMDiscount.getText().toString().trim();
		String mobile = uMmobile.getText().toString().trim();
		String id = uMMemID.getText().toString().trim();
		
		msP.deleteFromTableMembership(id, 0);
		Membership m = new Membership(id, name, name1, gender, dob, rDate, clevel, Double.parseDouble(discount), mobile);
		msP.inputIntoTableMembership(m);
	}
	public void DeleteMembership()
	{
		String search = dMSearch.getText().toString().trim();
		msP = new MembershipPart();
		Membership m = msP.searchFromTableMembership(search);
		
		mDfName.setText(m.getfName());
		mDlName.setText(m.getlName());
		mDmobile.setText(m.getMobile());
		mDdob.setText(m.getDob());
		mDgender.setText(m.getGender());
		mDMemID.setText(m.getId());
		mDCLevel.setText(m.getCardLevel());
		mDDiscount.setText(m.getDiscount()+"");
		mRDDate.setText(m.getRegisterDate());
	}
	public void DeleteMembershipBtn()
	{
		msP = new MembershipPart();
		msP.deleteFromTableMembership(mDMemID.getText().toString().trim(), 1);
	}
	public void ClearMembershipControls()
	{
		for (int i = tableMembership.getRowCount() - 1; i >= 0; i--) {
			tableMembership.removeRow(i);
		}
		mFName.setText(""); mLName.setText(""); mmobile.setText(""); mdiscount.setText(""); dMSearch.setText(""); sMSearch.setText("");
		mgender.setSelectedIndex(0); mCardLevel.setSelectedIndex(0);
		mdob.setDate(null); mrDate.setDate(null);
		mSfName.setText(""); mSlName.setText(""); mSmobile.setText(""); mSdob.setText(""); mSgender.setText(""); mSMemID.setText(""); mSCLevel.setText(""); mSDiscount.setText(""); mSRDate.setText("");
		uMfName.setText(""); uMlName.setText(""); uMmobile.setText(""); uMDiscount.setText(""); uMMemID.setText(""); uMSearch.setText("");
		uMgender.setSelectedIndex(0); uMCLevel.setSelectedIndex(0);
		uMdob.setDate(null); uMrDate.setDate(null);
		mDfName.setText(""); mDlName.setText(""); mDmobile.setText(""); mDdob.setText(""); mDgender.setText(""); mDMemID.setText(""); mDCLevel.setText(""); mDDiscount.setText(""); mRDDate.setText("");
	}
	public void ViewGeneralSale()
	{	
		ssP = new SalePart();
		gs = ssP.getFromTableSale();
		if(gs != null)
		{
			for(Sale s:gs)
			{
				if(s.getMembershipID().equals("C000")) {
					Object[] gen = {s.getId(), s.getScheduleID(), s.getDate(), s.getEmployeeID(), s.getTotalPrice()};
					tableVGensale.addRow(gen);
				}
			}
		} 
	}
	
	public void SearchGeneralSale()
	{
		for (int i = tableSGensale.getRowCount() - 1; i >= 0; i--) {
		    tableSGensale.removeRow(i);
		}
		
		String search = DateFormat.getDateInstance().format(sGDate.getDate());
		ssP = new SalePart();
		gs = ssP.searchFromTableSale(search);
		if(gs != null)
		{
			for(Sale s:gs)
			{
				if(s.getMembershipID() == null) {
				Object[] gen = {s.getId(), s.getScheduleID(), s.getDate(), s.getEmployeeID(), s.getTotalPrice()};
				tableSGensale.addRow(gen);
				}
			}
		} 
	}
	public void DeleteGeneralSale()
	{
		String search = sgSearch.getText().toString().trim();
		
		ssP = new SalePart();
		Sale s = ssP.searchFromTableSales(search);
		if(s != null)
		{ 
			if(s.getMembershipID() == null) {
				sgSaleID.setText(s.getId());
				sgDate.setText(s.getDate());
				sgTime.setText(s.getTime());
				sgTAmount.setText(s.getTotalAmount()+"");
				sgTPrice.setText(s.getTotalPrice()+"");
				
				sgPayment.setText(s.getPayment()+"");
				sgYourReturn.setText(s.getYourReturn()+"");
				sgEID.setText(s.getEmployeeID());
				
				sP = new SchedulePart();
				MovieSchedule m = sP.searchByID(s.getScheduleID());
				if(m != null)
				{
					sgMTime.setText(m.getTimeStart());
					sgMHall.setText(m.getHall()+"");
					sgMTSeat.setText(m.getTotalSeat()+"");
					
					mP = new MoviePart();
					Movie mv = mP.searchByID(m.getMovieID());
					if(mv != null)
					{
						sgMName.setText(mv.getName());
						sgMRun.setText(mv.getRunningTime()+"");
						sgMTPrice.setText(m.getTicketprice()+"");
					}
				}
			}
		}
	}

	public void DeleteGeneralSaleBtn()
	{
		ssP = new SalePart();
		ssP.deleteFromTableSale(sgSaleID.getText().toString().trim(), 1);
	}
	public void ClearGensaleControls()
	{
		for (int i = tableSGensale.getRowCount() - 1; i >= 0; i--) {
		    tableSGensale.removeRow(i);
		}
		
		for (int i = tableVGensale.getRowCount() - 1; i >= 0; i--) {
		    tableVGensale.removeRow(i);
		}
		
		sGDate.setDate(null);
		sgMName.setText(""); sgMRun.setText(""); sgMTime.setText(""); sgMHall.setText(""); sgMTSeat.setText(""); sgMTPrice.setText(""); sgSaleID.setText(""); sgDate.setText(""); sgTime.setText(""); sgTAmount.setText(""); sgTPrice.setText(""); sgPayment.setText(""); sgYourReturn.setText(""); sgEID.setText("");
		sgSearch.setText("");;
	}
	
	public void deleteFromTable(DefaultTableModel a, JTable b, int t)
	{
		if(b.getSelectedRow() > -1) {
			String id = (String) b.getModel().getValueAt(b.getSelectedRow(), 0);
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Record?") == JOptionPane.YES_OPTION) {
				ssP = new SalePart();
				ssP.deleteFromTableSale(id, 1);
				for (int i = a.getRowCount() - 1; i >= 0; i--) {
					a.removeRow(i);
				}
				if(t == 1) ViewGeneralSale();
				else if(t == 2) SearchGeneralSale();
				else if(t == 5) ViewMembershipSale();
				else if(t == 6) SearchMemSale();
			}
		}
	}
	
	public void ViewMembershipSale()
	{	
		ssP = new SalePart();
		gs = ssP.getFromTableSale();
		if(gs != null)
		{
			for(Sale s:gs)
			{
				if(!s.getMembershipID().equals("C000")) {
					Object[] gen = {s.getId(), s.getMembershipID(), s.getScheduleID(), s.getDate(), s.getEmployeeID(), s.getTotalPrice()};
					tableVMemsale.addRow(gen);
				}
			}
		} 
	}
	
	public void SearchMemSale()
	{
		for (int i = tableSMensale.getRowCount() - 1; i >= 0; i--) {
			tableSMensale.removeRow(i);
		}
		
		String search = DateFormat.getDateInstance().format(sMDate.getDate());
		ssP = new SalePart();
		gs = ssP.searchFromTableSale(search);
		if(gs != null)
		{
			for(Sale s:gs)
			{
				if(s.getMembershipID() != null) {
				Object[] gen = {s.getId(), s.getMembershipID(), s.getScheduleID(), s.getDate(), s.getEmployeeID(), s.getTotalPrice()};
				tableSMensale.addRow(gen);
				}
			}
		} 
	}
	
	public void DeleteMemSale()
	{
		String search = smSearch.getText().toString().trim();
		
		ssP = new SalePart();
		Sale s = ssP.searchFromTableSales(search);
		if(s != null)
		{ 
			if(s.getMembershipID() != null) {
				smSaleID.setText(s.getId());
				smDate.setText(s.getDate());
				smTime.setText(s.getTime());
				smTAmount.setText(s.getTotalAmount()+"");
				smTPrice.setText(s.getTotalPrice()+"");
				smMemID.setText(s.getMembershipID());
				
				smPayment.setText(s.getPayment()+"");
				smYourReturn.setText(s.getYourReturn()+"");
				smEID.setText(s.getEmployeeID());
				
				sP = new SchedulePart();
				MovieSchedule m = sP.searchByID(s.getScheduleID());
				if(m != null)
				{
					smMTime.setText(m.getTimeStart());
					smMHall.setText(m.getHall()+"");
					smMTSeat.setText(m.getTotalSeat()+"");
					
					mP = new MoviePart();
					Movie mv = mP.searchByID(m.getMovieID());
					if(mv != null)
					{
						smMName.setText(mv.getName());
						smMRun.setText(mv.getRunningTime()+"");
						smMTPrice.setText(m.getTicketprice()+"");
					}
				}
			}
		}
	}
	
	public void DeleteMemSaleBtn()
	{
		ssP = new SalePart();
		ssP.deleteFromTableSale(smSaleID.getText().toString().trim(), 1);
	}
	
	public void ClearMemControls()
	{
		for (int i = tableVMemsale.getRowCount() - 1; i >= 0; i--) {
			tableVMemsale.removeRow(i);
		}
		
		for (int i = tableSMensale.getRowCount() - 1; i >= 0; i--) {
			tableSMensale.removeRow(i);
		}
		
		sMDate.setDate(null);
		smMName.setText(""); smMRun.setText(""); smMTime.setText(""); smMHall.setText(""); smMTSeat.setText(""); smMTPrice.setText(""); smSaleID.setText(""); smDate.setText(""); smTime.setText(""); smTAmount.setText(""); smTPrice.setText(""); smPayment.setText(""); smYourReturn.setText(""); smEID.setText(""); smMemID.setText("");
		smSearch.setText("");;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name="";
		try {
			JLabel label = (JLabel)e.getSource();
			name = label.getText();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	    
		if(e.getSource() == menu)
		{
			if(count == 1) {
				logout.setVisible(false);
				exit.setVisible(false);
				count = 0;
			}
			else if(count == 0)
			{
				count = 1;
				logout.setVisible(true);
				exit.setVisible(true);
			}
		}
		else if(e.getSource() == back)
		{
			title.setText("Phnom Penh Cinema");
			panel.setVisible(true);
			back.setVisible(false);
			menu.setVisible(true);
			submenu.setVisible(false);
			subtitle.setVisible(false);
			
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
			
			spViewMovie.setVisible(false);
			
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
			
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
			
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
			
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
			
			spViewSchedule.setVisible(false);
			
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);
			
			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
			
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
			
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
			
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
			
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
			
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
			
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
			
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
			
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
			
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
			
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
			
			panelViewGenSale.setVisible(false);
			panelButtonGenSale.setVisible(false);
			
			panelSearchGenSale.setVisible(false);
			panelButtonSearchGenSale.setVisible(false);
			
			panelDeleteGenSale.setVisible(false);
			panelButtonDeleteGenSale.setVisible(false);
			
			panelViewMemSale.setVisible(false);
			panelButtonViewMemSale.setVisible(false);
			
			panelSearchMemSale.setVisible(false);
			panelButtonSearchMemSale.setVisible(false);
			
			panelDeleteMemSale.setVisible(false);
			panelButtonDeleteMemSale.setVisible(false);
		}
		else if(e.getSource() == exit)
		{
			
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			
		}
		else if(e.getSource() == logout)
		{
			this.dispose();
			Main.frame.setVisible(false);
		}
		else if(e.getSource() == conMovie)
		{
			title.setText("Movie");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("   Add New Movie", "   View Movie List", "   Search Movie", "   Update Movie", "   Delete Movie", "images/clapperboard.png",1);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
		}
		else if(e.getSource() == conSchedule)
		{
			title.setText("Movie Schedule");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("   Add Movie Schedule", "   View Movie Schedule", "   Search Movie Schedule", "   Update Movie Schedule", "   Delete Movie Schedule", "images/calendar (2).png",1);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
			
			mP = new MoviePart();
			List<Movie> m = mP.getFromTableMovie();
			sAName.removeAllItems();
			sAName.addItem("- - - Choose - - -");
			for(int i=0; i<m.size(); i++) {
				sAName.addItem(m.get(i).getName());
			}
			
			uAName.removeAllItems();
			uAName.addItem("- - - Choose - - -");
			for(int i=0; i<m.size(); i++) {
				uAName.addItem(m.get(i).getName());
			}
		}
		else if(e.getSource() == conEmployee)
		{
			title.setText("Employee");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("   Add New Employee", "   View Employee List", "   Search Employee", "   Update Employee", "   Delete Employee", "images/group (2).png",1);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
		}
		else if(e.getSource() == conMember)
		{
			title.setText("Membership");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("   Add New Membership", "   View Membership List", "   Search Membership", "   Update Membership", "   Delete Membership", "images/restaurant-membership-card-tool (2).png",1);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
		}
		else if(e.getSource() == conSale)
		{
			title.setText("General Sale");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("     ", "   View General Sale", "   Search General Sale", "   Update General Sale", "   Delete General Sale", "images/badge (2).png",0);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
		}
		else if(e.getSource() == conSale1)
		{
			title.setText("Membership Sale");
			panel.setVisible(false);
			back.setVisible(true);
			menu.setVisible(false);
			UISubmenu("     ", "   View Membership Sale", "   Search Membership Sale", "   Update Membership Sale", "   Delete Membership Sale", "images/percentage-red.png",0);
			submenu.setVisible(true);
			logout.setVisible(false);
			exit.setVisible(false);
		}
		else if(name.equals("   Add New Movie"))
		{
			//JOptionPane.showMessageDialog(null, "add");
			ClearMovieControl();
			
			subtitle.setText("New Movie");
			subtitle.setVisible(true);
			panelAdd.setVisible(true);
			panelButtonAdd.setVisible(true);
			
			spViewMovie.setVisible(false);
			
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
			
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
			
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
			
		}
		else if(name.equals("   View Movie List"))
		{
			//JOptionPane.showMessageDialog(null, "show");
			ClearMovieControl();
			
			spViewMovie.setVisible(true);
			subtitle.setText("View Movie List");
			subtitle.setVisible(true);
			
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
			
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
			
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
			
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
			
			ViewMovie();
			
		}
		else if(name.equals("   Search Movie"))
		{
			//JOptionPane.showMessageDialog(null, "search");
			ClearMovieControl();
			
			subtitle.setVisible(true);
			subtitle.setText("Search Movie List");
			panelSearch.setVisible(true);
			panelButtonSearch.setVisible(true);
			
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
			
			spViewMovie.setVisible(false);
			
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
			
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
		}
		else if(name.equals("   Update Movie"))
		{
			ClearMovieControl();
			
			panelUpdate.setVisible(true);
			panelButtonUpdate.setVisible(true);
			spViewMovie.setVisible(true);
			subtitle.setVisible(true);
			subtitle.setText("Update Movie");
			
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
			
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
			
			spViewMovie.setVisible(false);
			
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
		}
		else if(name.equals("   Delete Movie"))
		{
			ClearMovieControl();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete Movie");
			
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
			
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
			
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
			
			spViewMovie.setVisible(false);
			
			panelDelete.setVisible(true);
			panelButtonDelete.setVisible(true);
		}
		else if(name.equals("   Add Movie Schedule"))
		{
			ClearScheduleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Add Movie Schedule");
			
			panelAddSchedule.setVisible(true);
			panelButtonAddSch.setVisible(true);
			
			spViewSchedule.setVisible(false);
			
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);
			
			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
		
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
		
		}
		else if(name.equals("   View Movie Schedule"))
		{
			ClearScheduleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("View Movie Schedule");
			
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
			
			spViewSchedule.setVisible(true);
			
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);
			
			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
			
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
			
			ViewSchedule();
		}
		else if(name.equals("   Search Movie Schedule"))
		{
			ClearScheduleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Search Movie Schedule");
			
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
			
			spViewSchedule.setVisible(false);
			
			panelSearchSch.setVisible(true);
			panelButtonSearchSch.setVisible(true);
			
			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
			
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
		}
		else if(name.equals("   Update Movie Schedule"))
		{
			ClearScheduleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Update Movie Schedule");
			
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
			
			spViewSchedule.setVisible(false);
			
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);

			panelUpdateSch.setVisible(true);
			panelButtonUpdateSch.setVisible(true);
			
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
		}
		else if(name.equals("   Delete Movie Schedule"))
		{
			ClearScheduleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete Movie Schedule");
			
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
			
			spViewSchedule.setVisible(false);
			
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);

			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
			
			panelDeleteSch.setVisible(true);
			panelButtonDeleteSch.setVisible(true);
		}
		else if(name.equals("   Add New Employee"))
		{
			ClearEmployeeControls();
			
			subtitle.setVisible(true);
			subtitle.setText("New Employee");
			
			panelAddEmployee.setVisible(true);
			panelButtonAddEmployee.setVisible(true);
			
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
			
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
			
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
		}
		else if(name.equals("   View Employee List"))
		{
			ClearEmployeeControls();
			
			subtitle.setVisible(true);
			subtitle.setText("View Employee");
			
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
			
			panelViewEmployee.setVisible(true);
			panelButtonViewEmp.setVisible(true);
			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
			
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
			
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
			
			ViewEmployee();
		}
		else if(name.equals("   Search Employee"))
		{
			ClearEmployeeControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Search Employee");
			
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
			
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
			
			panelSearchEmp.setVisible(true);
			panelButtonSearchEmp.setVisible(true);
			
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
			
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
		}
		else if(name.equals("   Update Employee"))
		{
			ClearEmployeeControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Update Employee");
			
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
			
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
			
			panelUpdateEmp.setVisible(true);
			panelButtonUpdateEmp.setVisible(true);
			
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
		}
		else if(name.equals("   Delete Employee"))
		{
			ClearEmployeeControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete Employee");
			
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
			
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
			
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
			
			panelDeleteEmp.setVisible(true);
			panelButtonDeleteEmp.setVisible(true);
		}
		else if(name.equals("   Add New Membership"))
		{
			ClearMembershipControls();
			
			subtitle.setVisible(true);
			subtitle.setText("New Memebrship");
			
			panelAddMembership.setVisible(true);
			panelButtonAddMembership.setVisible(true);
			
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
			
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
			
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
			
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
		}
		else if(name.equals("   View Membership List"))
		{
			ClearMembershipControls();
			
			subtitle.setVisible(true);
			subtitle.setText("View Memebrship");
			
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
			
			panelViewMembership.setVisible(true);
			panelButtonViewMem.setVisible(true);
			
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
			
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
			
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
			
			ViewMembership();
		}
		else if(name.equals("   Search Membership"))
		{
			ClearMembershipControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Search Memebrship");
			
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
			
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
			
			panelSearchMem.setVisible(true);
			panelButtonSearchMem.setVisible(true);
			
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
			
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
		}
		else if(name.equals("   Update Membership"))
		{
			ClearMembershipControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Update Memebrship");
			
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
			
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
			
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
			
			panelUpdateMem.setVisible(true);
			panelButtonUpdateMem.setVisible(true);
			
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
		}
		else if(name.equals("   Delete Membership"))
		{
			ClearMembershipControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete Memebrship");
			
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
			
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
			
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
			
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
			
			panelDeleteMem.setVisible(true);
			panelButtomDeleteMem.setVisible(true);
		}
		else if(name.equals("   View General Sale"))
		{
			ClearGensaleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("View General Sale");
			
			panelViewGenSale.setVisible(true);
			panelButtonGenSale.setVisible(true);
			
			panelSearchGenSale.setVisible(false);
			panelButtonSearchGenSale.setVisible(false);
			
			panelDeleteGenSale.setVisible(false);
			panelButtonDeleteGenSale.setVisible(false);
			
			ViewGeneralSale();
		}
		else if(name.equals("   Search General Sale"))
		{
			ClearGensaleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Search General Sale");
			
			panelViewGenSale.setVisible(false);
			panelButtonGenSale.setVisible(false);
			
			panelSearchGenSale.setVisible(true);
			panelButtonSearchGenSale.setVisible(true);
			
			panelDeleteGenSale.setVisible(false);
			panelButtonDeleteGenSale.setVisible(false);
		}
		else if(name.equals("   Delete General Sale"))
		{
			ClearGensaleControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete General Sale");
			
			panelViewGenSale.setVisible(false);
			panelButtonGenSale.setVisible(false);
			
			panelSearchGenSale.setVisible(false);
			panelButtonSearchGenSale.setVisible(false);
			
			panelDeleteGenSale.setVisible(true);
			panelButtonDeleteGenSale.setVisible(true);
		}
		else if(name.equals("   View Membership Sale"))
		{		
			ClearMemControls();
			
			subtitle.setVisible(true);
			subtitle.setText("View Membership Sale");
			
			panelViewMemSale.setVisible(true);
			panelButtonViewMemSale.setVisible(true);
			
			panelSearchMemSale.setVisible(false);
			panelButtonSearchMemSale.setVisible(false);
			
			panelDeleteMemSale.setVisible(false);
			panelButtonDeleteMemSale.setVisible(false);
			
			ViewMembershipSale();
		}
		else if(name.equals("   Search Membership Sale"))
		{
			ClearMemControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Search Membership Sale");
			
			panelViewMemSale.setVisible(false);
			panelButtonViewMemSale.setVisible(false);
			
			panelSearchMemSale.setVisible(true);
			panelButtonSearchMemSale.setVisible(true);
			
			panelDeleteMemSale.setVisible(false);
			panelButtonDeleteMemSale.setVisible(false);
		}
		else if(name.equals("   Delete Membership Sale"))
		{
			ClearMemControls();
			
			subtitle.setVisible(true);
			subtitle.setText("Delete Membership Sale");
			
			panelViewMemSale.setVisible(false);
			panelButtonViewMemSale.setVisible(false);
			
			panelSearchMemSale.setVisible(false);
			panelButtonSearchMemSale.setVisible(false);
			
			panelDeleteMemSale.setVisible(true);
			panelButtonDeleteMemSale.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("   Add Movie"))
		{
			AddMovie();
		}
		else if(e.getSource() == btnMSSearch)
		{
			SearchMovie();
		}
		else if(e.getSource() == btnMUSearch)
		{
			UpdateMovie();
		}
		else if(e.getSource() == btnUMUpdate)
		{
			UpdateBtnExecute();
		}
		else if(e.getSource() == btnMDSearch)
		{
			DeleteMovie();
		}
		else if(e.getSource() == btnDMDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this movie?") == JOptionPane.YES_OPTION) {
				DeleteBtnExecute();
				ClearMovieControl();
			}
		}
		else if(e.getSource() == btnClear)
		{
			ClearMovieControl();
		}
		else if(e.getSource() == btnSMClear)
		{
			ClearMovieControl();
		}
		else if(e.getSource() == btnUMClear)
		{
			ClearMovieControl();
		}
		else if(e.getSource() == btnDMClear)
		{
			ClearMovieControl();
		}
		else if(e.getSource() == btnCancel)
		{
			subtitle.setVisible(false);
			panelAdd.setVisible(false);
			panelButtonAdd.setVisible(false);
		}
		else if(e.getSource() == btnUMCancel)
		{
			subtitle.setVisible(false);
			panelUpdate.setVisible(false);
			panelButtonUpdate.setVisible(false);
		}
		else if(e.getSource() == btnSMCancel)
		{
			subtitle.setVisible(false);
			panelSearch.setVisible(false);
			panelButtonSearch.setVisible(false);
		}
		else if(e.getSource() == btnDMCancel)
		{
			subtitle.setVisible(false);
			panelDelete.setVisible(false);
			panelButtonDelete.setVisible(false);
		}
		else if(e.getSource() == btnSAAdd)
		{
			AddSchedule();
		}
		else if(e.getSource() == btnSSearch)
		{
			SearchSchedule();
		}
		else if(e.getSource() == btnUSearch)
		{
			UpdateSchedule();
		}
		else if(e.getSource() == btnUUpdate)
		{
			BtnUpdateExecute();
		}
		else if(e.getSource() == btnDSearch)
		{
			DeleteSchedule();
		}
		else if(e.getSource() == btnDDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Schedule?") == JOptionPane.YES_OPTION) {
				BtnDeleteExecute();
				ClearScheduleControls();
			}
		}
		else if(e.getSource() == btnSACancel)
		{
			subtitle.setVisible(false);
			panelAddSchedule.setVisible(false);
			panelButtonAddSch.setVisible(false);
		}
		else if(e.getSource() == btnSCancel)
		{
			subtitle.setVisible(false);
			panelSearchSch.setVisible(false);
			panelButtonSearchSch.setVisible(false);
		}
		else if(e.getSource() == btnUCancel)
		{
			subtitle.setVisible(false);
			panelUpdateSch.setVisible(false);
			panelButtonUpdateSch.setVisible(false);
		}
		else if(e.getSource() == btnDCancel)
		{
			subtitle.setVisible(false);
			panelDeleteSch.setVisible(false);
			panelButtonDeleteSch.setVisible(false);
		}
		else if(e.getSource() == btnSAClear)
		{
			ClearScheduleControls();
		}
		else if(e.getSource() == btnSClear)
		{
			ClearScheduleControls();
		}
		else if(e.getSource() == btnUClear)
		{
			ClearScheduleControls();
		}
		else if(e.getSource() == btnDClear)
		{
			ClearScheduleControls();
		}
		else if(e.getSource() == btnAEAdd)
		{
			AddEmployee();
		}
		else if(e.getSource() == btnSESearch)
		{
			SearchEmployee();
		}
		else if(e.getSource() == btnUESearch)
		{
			UpdateEmployee();
		}
		else if(e.getSource() == btnUEUpdate)
		{
			UpdateEmployeeBtn();
		}
		else if(e.getSource() == btnDESearch)
		{
			DeleteEmployee();
		}
		else if(e.getSource() == btnDEDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Employee?") == JOptionPane.YES_OPTION) {
				DeleteEmployeeBtn();
				ClearEmployeeControls();
			}
		}
		else if(e.getSource() == btnAECancel)
		{
			subtitle.setVisible(false);
			panelAddEmployee.setVisible(false);
			panelButtonAddEmployee.setVisible(false);
		}
		else if(e.getSource() == btnVECancel)
		{
			subtitle.setVisible(false);		
			panelViewEmployee.setVisible(false);
			panelButtonViewEmp.setVisible(false);
		}
		else if(e.getSource() == btnSECancel)
		{
			subtitle.setVisible(false);			
			panelSearchEmp.setVisible(false);
			panelButtonSearchEmp.setVisible(false);
		}
		else if(e.getSource() == btnUECancel)
		{
			subtitle.setVisible(false);
			panelUpdateEmp.setVisible(false);
			panelButtonUpdateEmp.setVisible(false);
		}
		else if(e.getSource() == btnDECancel)
		{
			subtitle.setVisible(false);
			panelDeleteEmp.setVisible(false);
			panelButtonDeleteEmp.setVisible(false);
		}
		else if(e.getSource() == btnAEClear)
		{
			ClearEmployeeControls();
		}
		else if(e.getSource() == btnSEClear)
		{
			ClearEmployeeControls();
		}
		else if(e.getSource() == btnUEClear)
		{
			ClearEmployeeControls();
		}
		else if(e.getSource() == btnDEClear)
		{
			ClearEmployeeControls();
		}
		else if(e.getSource() == btnVEUpdate)
		{
			if(tableEmp.getSelectedRow() > -1) {
				String username = (String) tableEmp.getModel().getValueAt(tableEmp.getSelectedRow(), 1);
				uESearch.setText(username);	
				panelViewEmployee.setVisible(false);
				panelButtonViewEmp.setVisible(false);
				subtitle.setText("Update Employee");
				panelUpdateEmp.setVisible(true);
				panelButtonUpdateEmp.setVisible(true);
				UpdateEmployee();
			}
		}
		else if(e.getSource() == btnVEDelete)
		{
			if(tableEmp.getSelectedRow() > -1) {
				String username = (String) tableEmp.getModel().getValueAt(tableEmp.getSelectedRow(), 1);
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Employee?") == JOptionPane.YES_OPTION) {
					eP = new EmployeePart();
					eP.deleteFromTableEmployee(username);
					for (int i = tableEmployee.getRowCount() - 1; i >= 0; i--) {
						tableEmployee.removeRow(i);
					}
					ViewEmployee();
				}
			}
		}
		else if(e.getSource() == btnAMAdd)
		{
			AddMembership();
		}
		else if(e.getSource() == btnSMemSearch)
		{
			SearchMembership();
		}
		else if(e.getSource() == btnUMemSearch)
		{
			UpdateMembership();
		}
		else if(e.getSource() == btnUMemUpdate)
		{
			UpdateMembershipBtn();
		}
		else if(e.getSource() == btnDMemSearch)
		{
			DeleteMembership();
		}
		else if(e.getSource() == btnDMemDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Membership?") == JOptionPane.YES_OPTION) {
				DeleteMembershipBtn();
				ClearMembershipControls();
			}
		}
		else if(e.getSource() == btnAMCancel)
		{
			subtitle.setVisible(false);
			panelAddMembership.setVisible(false);
			panelButtonAddMembership.setVisible(false);
		}
		else if(e.getSource() == btnVMCancel)
		{
			subtitle.setVisible(false);
			panelViewMembership.setVisible(false);
			panelButtonViewMem.setVisible(false);
		}
		else if(e.getSource() == btnSMemCancel)
		{
			subtitle.setVisible(false);
			panelSearchMem.setVisible(false);
			panelButtonSearchMem.setVisible(false);
		}
		else if(e.getSource() == btnUMemCancel)
		{
			subtitle.setVisible(false);
			panelUpdateMem.setVisible(false);
			panelButtonUpdateMem.setVisible(false);
		}
		else if(e.getSource() == btnDMemCancel)
		{
			subtitle.setVisible(false);
			panelDeleteMem.setVisible(false);
			panelButtomDeleteMem.setVisible(false);
		}
		else if(e.getSource() == btnAMClear)
		{
			ClearMembershipControls();
		}
		else if(e.getSource() == btnSMemClear)
		{
			ClearMembershipControls();
		}
		else if(e.getSource() == btnUMemClear)
		{
			ClearMembershipControls();
		}
		else if(e.getSource() == btnDMemClear)
		{
			ClearMembershipControls();
		}
		else if(e.getSource() == btnVMUpdate)
		{
			if(tableMem.getSelectedRow() > -1) {
				String id = (String) tableMem.getModel().getValueAt(tableMem.getSelectedRow(), 0);
				uMSearch.setText(id);	
				panelViewMembership.setVisible(false);
				panelButtonViewMem.setVisible(false);
				subtitle.setText("Update Membership");
				panelUpdateMem.setVisible(true);
				panelButtonUpdateMem.setVisible(true);
				UpdateMembership();
			}
		}
		else if(e.getSource() == btnVMDelete)
		{
			if(tableMem.getSelectedRow() > -1) {
				String id = (String) tableMem.getModel().getValueAt(tableMem.getSelectedRow(), 0);
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Membership?") == JOptionPane.YES_OPTION) {
					msP = new MembershipPart();
					msP.deleteFromTableMembership(id, 1);
					for (int i = tableMembership.getRowCount() - 1; i >= 0; i--) {
						tableMembership.removeRow(i);
					}
					ViewMembership();
					
				}
			}
		}
		else if(e.getSource() == btnSGSearch)
		{
			SearchGeneralSale();
		}
		else if(e.getSource() == btnDGSearch)
		{
			DeleteGeneralSale();
		}
		else if(e.getSource() == btnDGDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Record?") == JOptionPane.YES_OPTION) {
				DeleteGeneralSaleBtn();
				ClearGensaleControls();
			}
		}
		else if(e.getSource() == btnSGCancel)
		{
			subtitle.setVisible(false);
			panelSearchGenSale.setVisible(false);
			panelButtonSearchGenSale.setVisible(false);	
		}
		else if(e.getSource() == btnVGCancel)
		{
			subtitle.setVisible(false);
			panelViewGenSale.setVisible(false);
			panelButtonGenSale.setVisible(false);
		}
		else if(e.getSource() == btnDGCancel)
		{
			subtitle.setVisible(false);
			panelDeleteGenSale.setVisible(false);
			panelButtonDeleteGenSale.setVisible(false);
		}
		else if(e.getSource() == btnDGClear)
		{
			ClearGensaleControls();
		}
		else if(e.getSource() == btnVGDelete)
		{
			deleteFromTable(tableVGensale , tableVGSale, 1);
		}
		else if(e.getSource() ==btnSGDelete)
		{
			deleteFromTable(tableSGensale , tableSGSale, 2);
		}
		else if(e.getSource() == btnSMSSearch)
		{
			SearchMemSale();
		}
		else if(e.getSource() == btnDMSSearch)
		{
			DeleteMemSale();
		}
		else if(e.getSource() == btnDMSDelete)
		{
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Record?") == JOptionPane.YES_OPTION) {
				DeleteMemSaleBtn();
				ClearMemControls();
			}
		}
		else if(e.getSource() == btnSMSCancel)
		{
			subtitle.setVisible(false);
			panelSearchMemSale.setVisible(false);
			panelButtonSearchMemSale.setVisible(false);
			
			panelDeleteMemSale.setVisible(false);
			panelButtonDeleteMemSale.setVisible(false);
		}
		else if(e.getSource() == btnVMSCancel)
		{
			subtitle.setVisible(false);		
			panelViewMemSale.setVisible(false);
			panelButtonViewMemSale.setVisible(false);
		}
		else if(e.getSource() == btnDMSCancel)
		{
			subtitle.setVisible(false);
			panelDeleteMemSale.setVisible(false);
			panelButtonDeleteMemSale.setVisible(false);
		}
		else if(e.getSource() == btnDMSClear)
		{
			ClearMemControls();
		}
		else if(e.getSource() == btnVMSDelete)
		{
			deleteFromTable(tableVMemsale , tableVMSale, 5);
		}
		else if(e.getSource() == btnSMSDelete)
		{
			deleteFromTable(tableSMensale , tableSMSale, 6);
		}
	}
}
