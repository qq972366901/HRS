package LoginView;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import common.UserType;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginView extends JPanel {
	private JPasswordField passwordField;
	private JTextField textField;
	private LoginViewControllerService controller;
	public JPanel optionpannel;
    public JComboBox<String> comboBox;
    public JPanel loginpannel;
    public JLabel admin;
    public JLabel password;
    public JButton login;
    public JButton register;
    public JButton find;
    /**
	 * Create the panel.
	 */
	public LoginView(LoginViewControllerService controller) {
		setLayout(null);
		this.controller=controller;
		init_optionpannel();
		init_loginpannel();	
	}
	public void init_optionpannel(){
		optionpannel = new JPanel();
		optionpannel.setBounds(207, 143, 234, 103);
		add(optionpannel);
		optionpannel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 30));
		comboBox.setBounds(10, 20, 214, 60);
		optionpannel.add(comboBox);
		comboBox.setToolTipText("");
		
		List<String> list=new ArrayList<String>();
		list.add("客户");
		list.add("酒店营销人员");
		list.add("网站营销人员");
		list.add("网站管理人员");
		for (String str : list) {
			comboBox.addItem(str);
		}
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
			
				if(evt.getStateChange() == ItemEvent.SELECTED){
					
					String selected=(String)comboBox.getSelectedItem();
					
					//更换数据源
					controller.updatemodel(selected);
				}
			}

		});
	}
	public void init_loginpannel(){
		loginpannel = new JPanel();
		loginpannel.setBounds(155, 208, 683, 355);
		add(loginpannel);
		loginpannel.setLayout(null);
		
		admin = new JLabel("\u8D26\u53F7\u540D \uFF1A");
		admin.setBounds(92, 56, 150, 50);
		loginpannel.add(admin);
		admin.setForeground(new Color(0, 0, 0));
		admin.setFont(new Font("宋体", Font.PLAIN, 30));
		
		password = new JLabel(" \u5BC6\u7801 \uFF1A");
		password.setBounds(92, 135, 150, 50);
		loginpannel.add(password);
		password.setForeground(Color.BLACK);
		password.setFont(new Font("宋体", Font.PLAIN, 30));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setBounds(269, 56, 238, 50);
		loginpannel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordField.setBounds(269, 135, 236, 50);
		loginpannel.add(passwordField);
		
		login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "账号密码输入有误！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.login(textField.getText(),String.valueOf(passwordField.getPassword()));
			}
		});
		login.setFont(new Font("宋体", Font.PLAIN, 30));
		login.setBounds(269, 219, 117, 56);
		loginpannel.add(login);
		
		register = new JButton("\u6CE8\u518C\u8D26\u53F7");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!controller.register()){
					controller.error();
				}
			}
		});
		register.setFont(new Font("宋体", Font.PLAIN, 15));
		register.setBounds(555, 113, 103, 44);
		loginpannel.add(register);
	}
	public void login(UserType type){
		if(type==UserType.Customer){
		   customerMainViewControllerService con =  new customerMainViewControllerImpl(login.getText());
		   customerMainView vie = new customerMainView(con);
		   con.setView(vie);
		   main.change(this,vie);
		}
		if(type!=UserType.Customer){
	    }
	}
}
