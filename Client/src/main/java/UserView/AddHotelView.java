package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import uiService.AddHotelUiService;


public class AddHotelView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton button1,button2;
	private JLabel label2,label3,label4,label5,label6,label7,label8;
	private JTextField textField2,textField3,textField6,textField7;
	private JComboBox<String> comboBox1,comboBox3;
	private JComboBox<Integer> comboBox2;
	private JPanel panel;
	private AddHotelUiService controller;
	public AddHotelView(AddHotelUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
		panel=new JPanel();
		panel=this;
	}
	private void initButton() {
		JPanel panel1= new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel1.add(button1);
		this.add(panel1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toWebAdminUserView("id");
			}
		});	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("酒店名称");
		textField2 = new JTextField(20);
		panel2.add(label2);
		panel2.add(textField2);
		this.add(panel2);
		JPanel panel9= new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		label8 = new JLabel("所属城市");
		comboBox3=new JComboBox<String>();
		comboBox3.setPreferredSize(new Dimension(125,22));
		panel9.add(label8);
		panel9.add(comboBox3);
		this.add(panel9);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label4 = new JLabel("所属商圈");
		comboBox1=new JComboBox<String>();
		comboBox1.setPreferredSize(new Dimension(125,22));
		panel4.add(label4);
		panel4.add(comboBox1);
		this.add(panel4);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label3 = new JLabel("酒店地址");
		textField3 = new JTextField(20);
		panel3.add(label3);
		panel3.add(textField3);
		this.add(panel3);		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5 = new JLabel("酒店星级");
		comboBox2=new JComboBox<Integer>();
		comboBox2.addItem(1);
		comboBox2.addItem(2);
		comboBox2.addItem(3);
		comboBox2.addItem(4);
		comboBox2.addItem(5);
		comboBox2.setPreferredSize(new Dimension(125,22));
		panel5.add(label5);
		panel5.add(comboBox2);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label6 = new JLabel("设施服务");
		textField6 = new JTextField(20);
		panel6.add(label6);
		panel6.add(textField6);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label7 = new JLabel("酒店简介");
		textField7 = new JTextField(20);
		panel7.add(label7);
		panel7.add(textField7);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("添加酒店");
		panel8.add(button2);
		this.add(panel8);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
			     if((textField2.getText().equals(""))||(textField3.getText().equals(""))||(textField6.getText().equals(""))||(textField7.getText().equals(""))){
				    JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
						}
			     else{
			    	 int option = JOptionPane.showConfirmDialog(panel,"            确认添加？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
				     switch (option) {
				     case JOptionPane.YES_OPTION: 
				     {
				    	JFrame frame=new JFrame("酒店管理人员注册");
				    	frame.setSize(500,300);
				    	frame.setLocationRelativeTo(panel); 
				    	frame.setVisible(true);
				    	JPanel pane=new JPanel();
		                frame.add(pane);
		                pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
				    	JPanel panel1 = new JPanel();
						panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel label1 = new JLabel("姓    名");
						JTextField textField1 = new JTextField(26);
						JLabel label5=new JLabel("                   ");
						panel1.add(label1);
						panel1.add(textField1);
						panel1.add(label5);
						pane.add(panel1);
						JPanel panel2 = new JPanel();
						panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel label2 = new JLabel("      密    码");
						JPasswordField passwordField2 = new JPasswordField(26);
						JLabel label_2= new JLabel("（只能由数字和字母组成） ");
						panel2.add(label2);
						panel2.add(passwordField2);
						panel2.add(label_2);
						pane.add(panel2);
						JPanel panel3 = new JPanel();
						panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel label3 = new JLabel("确认密码");
						JPasswordField passwordField3 = new JPasswordField(26);
						JLabel label6=new JLabel("                   ");
						panel3.add(label3);
						panel3.add(passwordField3);
						panel3.add(label6);
						pane.add(panel3);
						JPanel panel4 = new JPanel();
						panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel label4 = new JLabel("联系方式");
						JTextField textField4 = new JTextField(26);
						JLabel label7=new JLabel("                   ");
						panel4.add(label4);
						panel4.add(textField4);
						panel4.add(label7);
						pane.add(panel4);
						JPanel panel5 = new JPanel();
						panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
						JButton button1=new JButton("确定");
						button1.addActionListener(new ActionListener() {			
							public void actionPerformed(ActionEvent e) {
								char[] pass2 = passwordField2.getPassword();
								String password2 = new String(pass2);
								char[] pass3 = passwordField3.getPassword();
								String password3 = new String(pass3);
								int p=0;
								for(int i=0;i<pass2.length;i++){
								  if((!Character.isDigit(pass2[i]))&&(!Character.isLetter(pass2[i]))){
									  p=1;
								  }
								}							
								if((textField1.getText().equals(""))||(password2.equals(""))||(password3.equals(""))||(textField4.getText().equals(""))){
									JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
								}
								else if((!password2.equals(""))&&(!password3.equals(""))&&(!password2.equals(password3))){
									JOptionPane.showMessageDialog(panel, "两次输入的密码不一致，请重新输入！","", JOptionPane.ERROR_MESSAGE);				
								}
								else if(p==1){
									JOptionPane.showMessageDialog(panel, "密码只能由数字和字母组成！","", JOptionPane.ERROR_MESSAGE);
								}
								else{
									 int option = JOptionPane.showConfirmDialog(panel,"请记住你的账号：     \n是否返回网站管理人员主界面？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
						    		 switch (option) {
								     case JOptionPane.YES_OPTION:  
								    	 controller.toWebAdminUserView("id");
								     case JOptionPane.NO_OPTION:
								    	 frame.dispose();
						    		 }
								}			
							}
						});	
						JButton button2=new JButton("取消");
						button2.addActionListener(new ActionListener() {			
							public void actionPerformed(ActionEvent e) {
								frame.dispose();
							}
						});	
						panel5.add(button1);
						panel5.add(button2);
						pane.add(panel5);
				     }
				     case JOptionPane.NO_OPTION:
				     }		    	
			     }
	}
		});	
}
}