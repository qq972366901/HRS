package revisePasswordView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import InformationView.InformationView;
import InformationView.InformationViewControllerImpl;
import InformationView.InformationViewControllerService;
import LoginView.main;
import javax.swing.JPasswordField;

public class revisePasswordView extends JPanel {
	private JPanel panel;
    private JButton back;
    private revisePasswordViewControllerService controller;
    JPanel panel_1 ;
	
	private JLabel oldpassword ;
	
	private JLabel newpassword ;
	
	private JLabel againrevise ;
	
	private JButton revisepassword ;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	private boolean oldPassword;
	private boolean newPassword;
	private boolean same_oldnew;
	private boolean same;
	private String UserID;
	/**
	 * Create the panel.
	 */
	public revisePasswordView(revisePasswordViewControllerService controller) {
		setLayout(null);
        this.controller=controller;
        UserID=controller.getUserID();
        init_exit();
        
        init_information();
	}
	public void init_information(){
		panel_1 = new JPanel();
		panel_1.setBounds(103, 87, 691, 603);
		add(panel_1);
		panel_1.setLayout(null);
		
		oldpassword = new JLabel("\u539F\u5BC6\u7801 \uFF1A");
		oldpassword.setFont(new Font("宋体", Font.PLAIN, 25));
		oldpassword.setBounds(140, 59, 113, 60);
		panel_1.add(oldpassword);
		
		newpassword = new JLabel("\u65B0\u5BC6\u7801 \uFF1A");
		newpassword.setFont(new Font("宋体", Font.PLAIN, 25));
		newpassword.setBounds(140, 152, 120, 60);
		panel_1.add(newpassword);
		
		againrevise = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801 \uFF1A");
		againrevise.setFont(new Font("宋体", Font.PLAIN, 25));
		againrevise.setBounds(46, 246, 213, 60);
		panel_1.add(againrevise);
		
		Vector<String> data=new Vector<String>();
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField.setBounds(289, 59, 300, 60);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField_1.setBounds(289, 152, 300, 60);
		panel_1.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField_2.setBounds(289, 246, 300, 60);
		panel_1.add(passwordField_2);
		
		data.add(passwordField.getPassword().toString());
		data.add(passwordField_1.getPassword().toString());
		data.add(passwordField_2.getPassword().toString());
		
		revisepassword = new JButton("\u786E\u5B9A\u4FEE\u6539");
		revisepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldPassword=controller.checkoldPassword(String.valueOf(passwordField.getPassword()));
				newPassword=controller.checknewPassword(String.valueOf(passwordField_1.getPassword()));
				same=controller.checksame(String.valueOf(passwordField_1.getPassword()),String.valueOf(passwordField_2.getPassword()));
				same_oldnew=controller.checksame_old(String.valueOf(passwordField_1.getPassword()),String.valueOf(passwordField.getPassword()));
				if(!oldPassword){
					JOptionPane.showMessageDialog(null, "原密码输入有误！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!newPassword){
					JOptionPane.showMessageDialog(null, "新密码不合法！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!same){
					JOptionPane.showMessageDialog(null, "两次重复输入的密码不同！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(same_oldnew){
					JOptionPane.showMessageDialog(null, "新旧密码一致！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.revisepassword(data);
			}
		});
		revisepassword.setFont(new Font("宋体", Font.PLAIN, 20));
		revisepassword.setBounds(281, 345, 180, 60);
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
	    InformationViewControllerService con =  new InformationViewControllerImpl(UserID);
	    InformationView vie = new InformationView(con);
		con.setView(vie);
		main.change(this,vie);
	}
}
