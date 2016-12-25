package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.CustomerMainViewController;
import uiController.ReviseInformationViewController;
import uiController.RevisePasswordViewController;
import uiService.InformationViewControllerService;
import uiService.CustomerMainViewService;
import uiService.ReviseInformationViewService;
import uiService.RevisePasswordViewService;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
/**
 * 个人信息管理界面的Panel
 * @author 刘宇翔
 *
 */
public class InformationView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private InformationViewControllerService controller;
    private JPanel panel_1 ;
	
	private JLabel name ;
	
	private JLabel birth ;
	
	private JLabel tel ;
	
	private JLabel enterprise;
	
	private JLabel type ;
	
	private JLabel level ;
	
	private JLabel credit;
	
	private JButton reviseinformation ;
	
	private JButton revisepassword;
	private String UserID;
	
	private JPanel panel_2;
	private JPanel panel_27;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private Vector<String> Data;
	
	
	/**
	 * Create the panel.
	 */
	public InformationView(InformationViewControllerService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        UserID=controller.getUserID();
        Data=controller.getInformation(UserID);
        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(panel);
		
        panel_1=new JPanel();
        panel_1.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_1);
        panel_22=new JPanel();
        panel_22.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_22);
        birth = new JLabel("\u751F\u65E5      :"+" "+Data.get(1)+"    ");
        panel_22.add(new JLabel("                                                                       "));
		
		
        panel_22.add(birth);
        panel_23=new JPanel();
        panel_23.add(new JLabel("                                                                       "));
        panel_23.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_23);
        
        tel = new JLabel("联系方式  :"+" "+Data.get(2)+"   ");
        panel_23.add(tel);
        panel_24=new JPanel();
        panel_24.add(new JLabel("                                                                       "));
        panel_24.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_24);
        enterprise = new JLabel("公司      :"+" "+Data.get(3)+"    ");
        panel_24.add(enterprise);
        panel_25=new JPanel();
        panel_25.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_25);
        panel_26=new JPanel();
        panel_26.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_26);
        panel_27=new JPanel();
        panel_27.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(panel_27);

        panel_2=new JPanel();
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_2);
        
        init_exit();
        
        init_information();
	}
	/**
	 * 主要panel的初始化
	 */
	public void init_information(){
        		panel_1.add(new JLabel("                                                                       "));
        		panel_25.add(new JLabel("                                                                       "));
        		panel_26.add(new JLabel("                                                                       "));
        		panel_27.add(new JLabel("                                                                       "));
        		
        		back = new JButton("\u8FD4\u56DE");
        		/**
        		 * 返回按钮的监听
        		 */
        		back.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        			controller.exit();
        			}
        		});
        		panel.add(back);
        		name = new JLabel("姓名      :"+" "+Data.get(0)+"    ");
        		panel_1.add(name);
		type = new JLabel("会员种类  :"+" "+Data.get(4)+"    ");
		panel_25.add(type);
		level = new JLabel("会员等级  :"+" "+Data.get(5)+"    ");
		panel_26.add(level);
		
		credit = new JLabel("信用值    :"+" "+Data.get(6)+"    ");
		panel_27.add(credit);
		
		reviseinformation = new JButton("\u4FEE\u6539\u57FA\u672C\u4FE1\u606F");
		/**
		 * 修改信息按钮的监听
		 */
		reviseinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.reviseinformation();
			}
		});
      panel_2.add(reviseinformation);
		
		revisepassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		/**
		 * 修改密码按钮的监听
		 */
		revisepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.revisepassword();
			}
		});
panel_2.add(revisepassword);
	}
	public void init_exit(){
	}
	/**
	 * 返回按钮的跳转实现
	 */
	public void exit(){
		CustomerMainViewService con =  new CustomerMainViewController(UserID);
		CustomerMainView vie = new CustomerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 修改信息界面的跳转
	 */
	public void reviseinformation(){
		ReviseInformationViewService con =  new ReviseInformationViewController(UserID);
		ReviseInformationView vie = new ReviseInformationView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 修改密码界面的跳转
	 */
	public void revisepassword(){
		RevisePasswordViewService con =  new RevisePasswordViewController(UserID);
		RevisePasswordView vie = new RevisePasswordView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
