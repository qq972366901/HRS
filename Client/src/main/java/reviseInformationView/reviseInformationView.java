package reviseInformationView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InformationView.InformationView;
import InformationView.InformationViewControllerImpl;
import InformationView.InformationViewControllerService;
import LoginView.main;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;
import javax.swing.JTextField;

public class reviseInformationView extends JPanel {
    private JPanel panel;
    private JButton back;
    private reviseInformationViewControllerService controller;
    JPanel panel_1 ;
	
	private JLabel name ;
	
	private JLabel birth ;
	
	private JLabel tel ;
	
	private JLabel enterprise;
	
	private JLabel email;
	
	private JButton updateinformation ;
	private JTextField nameinput;
	private JTextField birthinput;
	private JTextField telinput;
	private JTextField enterpriseinput;
	private JTextField emailinput;
	
	private String UserID;
	private JLabel birthtip;
	private JLabel emailtip;
	/**
	 * Create the panel.
	 */
	public reviseInformationView(reviseInformationViewControllerService controller) {
		setLayout(null);
        this.controller=controller;
        UserID=controller.getUserID();
        init_exit();
        
        init_information();
	}
	public void init_information(){
		panel_1 = new JPanel();
		panel_1.setBounds(218, 87, 710, 603);
		add(panel_1);
		panel_1.setLayout(null);
		
		name = new JLabel("姓名 ：");
		name.setFont(new Font("宋体", Font.PLAIN, 25));
		name.setBounds(39, 10, 110, 60);
		panel_1.add(name);
		
		birth = new JLabel("\u751F\u65E5 \uFF1A");
		birth.setFont(new Font("宋体", Font.PLAIN, 25));
		birth.setBounds(39, 72, 88, 60);
		panel_1.add(birth);
		
		tel = new JLabel("\u8054\u7CFB\u65B9\u5F0F \uFF1A");
		tel.setFont(new Font("宋体", Font.PLAIN, 25));
		tel.setBounds(39, 140, 138, 60);
		panel_1.add(tel);
		
		enterprise = new JLabel("\u516C\u53F8 \uFF1A");
		enterprise.setFont(new Font("宋体", Font.PLAIN, 25));
		enterprise.setBounds(39, 212, 93, 60);
		panel_1.add(enterprise);
		
		email = new JLabel("\u90AE\u7BB1 \uFF1A");
		email.setFont(new Font("宋体", Font.PLAIN, 25));
		email.setBounds(39, 282, 88, 60);
		panel_1.add(email);
		
		
		nameinput = new JTextField();
		nameinput.setFont(new Font("宋体", Font.PLAIN, 25));
		nameinput.setBounds(170, 20, 250, 50);
		panel_1.add(nameinput);
		nameinput.setColumns(10);
		
		birthinput = new JTextField();
		birthinput.setFont(new Font("宋体", Font.PLAIN, 25));
		birthinput.setBounds(170, 82, 250, 50);
		panel_1.add(birthinput);
		birthinput.setColumns(10);
		
		telinput = new JTextField();
		telinput.setFont(new Font("宋体", Font.PLAIN, 25));
		telinput.setBounds(170, 150, 250, 50);
		panel_1.add(telinput);
		telinput.setColumns(10);
		
		enterpriseinput = new JTextField();
		enterpriseinput.setFont(new Font("宋体", Font.PLAIN, 25));
		enterpriseinput.setBounds(170, 212, 250, 50);
		panel_1.add(enterpriseinput);
		enterpriseinput.setColumns(10);
		
		emailinput = new JTextField();
		emailinput.setFont(new Font("宋体", Font.PLAIN, 25));
		emailinput.setBounds(170, 282, 250, 50);
		panel_1.add(emailinput);
		emailinput.setColumns(10);
		
		Vector<String> data=new Vector<String>();
		data.add(nameinput.getText());
		data.add(birthinput.getText());
		data.add(telinput.getText());
		data.add(enterpriseinput.getText());
		data.add(emailinput.getText());
		
		updateinformation = new JButton("\u786E\u5B9A\u4FEE\u6539");
		updateinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.updateinformation(data);
			}
		});
		updateinformation.setFont(new Font("宋体", Font.PLAIN, 20));
		updateinformation.setBounds(192, 369, 180, 60);
		panel_1.add(updateinformation);
		
		birthtip = new JLabel("\u5F62\u5F0F\u4E3A:xxxx/xx/xx");
		birthtip.setFont(new Font("宋体", Font.PLAIN, 20));
		birthtip.setBounds(477, 81, 201, 50);
		panel_1.add(birthtip);
		
		emailtip = new JLabel("\u683C\u5F0F\u4E3A:xxxxx@xxxxxxx");
		emailtip.setFont(new Font("宋体", Font.PLAIN, 20));
		emailtip.setBounds(465, 284, 201, 50);
		panel_1.add(emailtip);
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
	    InformationViewControllerService con =  new InformationViewControllerImpl(UserID);
	    InformationView vie = new InformationView(con);
		con.setView(vie);
		main.change(this,vie);
	}
}
