package InformationView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import LoginView.main;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;
import reviseInformationView.reviseInformationView;
import reviseInformationView.reviseInformationViewControllerImpl;
import reviseInformationView.reviseInformationViewControllerService;
import revisePasswordView.revisePasswordView;
import revisePasswordView.revisePasswordViewControllerImpl;
import revisePasswordView.revisePasswordViewControllerService;

import javax.swing.JLabel;

public class InformationView extends JPanel {
    private JPanel panel;
    private JButton back;
    private InformationViewControllerService controller;
    JPanel panel_1 ;
	
	private JLabel name ;
	
	private JLabel birth ;
	
	private JLabel tel ;
	
	private JLabel enterprise;
	
	private JLabel email;
	
	private JLabel type ;
	
	private JLabel level ;
	
	private JLabel credit;
	
	private JButton reviseinformation ;
	
	private JButton revisepassword;
	private String UserID;
	/**
	 * Create the panel.
	 */
	public InformationView(InformationViewControllerService controller) {
		setLayout(null);
        this.controller=controller;
        UserID=controller.getUserID();
        init_exit();
        
        init_information();
	}
	public void init_information(){
		panel_1 = new JPanel();
		panel_1.setBounds(172, 58, 556, 603);
		add(panel_1);
		panel_1.setLayout(null);
		
		name = new JLabel("姓名 ：");
		name.setFont(new Font("宋体", Font.PLAIN, 25));
		name.setBounds(39, 10, 279, 60);
		panel_1.add(name);
		
		birth = new JLabel("\u751F\u65E5 \uFF1A1997/02/02");
		birth.setFont(new Font("宋体", Font.PLAIN, 25));
		birth.setBounds(39, 72, 229, 60);
		panel_1.add(birth);
		
		tel = new JLabel("\u8054\u7CFB\u65B9\u5F0F \uFF1A15214338969");
		tel.setFont(new Font("宋体", Font.PLAIN, 25));
		tel.setBounds(39, 140, 401, 60);
		panel_1.add(tel);
		
		enterprise = new JLabel("\u516C\u53F8 \uFF1A\u5357\u4EAC\u5927\u5B66     ");
		enterprise.setFont(new Font("宋体", Font.PLAIN, 25));
		enterprise.setBounds(39, 212, 279, 60);
		panel_1.add(enterprise);
		
		email = new JLabel("\u90AE\u7BB1 \uFF1Alam0054321@qq.com");
		email.setFont(new Font("宋体", Font.PLAIN, 25));
		email.setBounds(39, 282, 422, 60);
		panel_1.add(email);
		
		type = new JLabel("\u4F1A\u5458\u79CD\u7C7B \uFF1A\u666E\u901A\u4F1A\u5458");
		type.setFont(new Font("宋体", Font.PLAIN, 25));
		type.setBounds(39, 352, 279, 60);
		panel_1.add(type);
		
		level = new JLabel("\u4F1A\u5458\u7B49\u7EA7 \uFF1A3");
		level.setFont(new Font("宋体", Font.PLAIN, 25));
		level.setBounds(39, 422, 174, 60);
		panel_1.add(level);
		
		credit = new JLabel("\u4FE1\u7528\u503C \uFF1A1000");
		credit.setFont(new Font("宋体", Font.PLAIN, 25));
		credit.setBounds(39, 492, 271, 60);
		panel_1.add(credit);
		
		reviseinformation = new JButton("\u4FEE\u6539\u57FA\u672C\u4FE1\u606F");
		reviseinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.reviseinformation();
			}
		});
		reviseinformation.setFont(new Font("宋体", Font.PLAIN, 20));
		reviseinformation.setBounds(349, 424, 180, 60);
		panel_1.add(reviseinformation);
		
		revisepassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		revisepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.revisepassword();
			}
		});
		revisepassword.setFont(new Font("宋体", Font.PLAIN, 20));
		revisepassword.setBounds(349, 494, 180, 60);
		panel_1.add(revisepassword);
	}
	public void init_exit(){
		panel = new JPanel();
		panel.setBounds(784, 46, 174, 81);
		add(panel);
		panel.setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		back.setFont(new Font("宋体", Font.PLAIN, 30));
		back.setBounds(10, 5, 150, 60);
		panel.add(back);
		
	}
	public void exit(){
		customerMainViewControllerService con =  new customerMainViewControllerImpl(UserID);
		customerMainView vie = new customerMainView(con);
		con.setView(vie);
		main.change(this,vie);
	}
	public void reviseinformation(){
		reviseInformationViewControllerService con =  new reviseInformationViewControllerImpl(UserID);
		reviseInformationView vie = new reviseInformationView(con);
		con.setView(vie);
		main.change(this,vie);
	}
	public void revisepassword(){
		revisePasswordViewControllerService con =  new revisePasswordViewControllerImpl(UserID);
		revisePasswordView vie = new revisePasswordView(con);
		con.setView(vie);
		main.change(this,vie);
	}
}
