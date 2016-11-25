package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uiService.UserManagementUiService;



public class UserManagementView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1;
	private JButton button2;
	private JLabel label2,label3,label4;
	private JTextField textField2,textField3,textField4;
	private JPanel panel;
	private UserManagementUiService controller;
	public UserManagementView(UserManagementUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
		panel=new JPanel();
		panel=this;
	}
	private void initButton(){
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		p1.add(button1);
		this.add(p1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toWebAdminUserView();
			}
		});
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("客户账号");
		textField2=new JTextField(20);
		p2.add(label2);
		p2.add(textField2);
		this.add(p2);
		JPanel p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label3 = new JLabel("客户名称");
		textField3 = new JTextField(20);
		p3.add(label3);
		p3.add(textField3);
		this.add(p3);
		JPanel p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label4 = new JLabel("联系方式");
		textField4 = new JTextField(20);
		p4.add(label4);
		p4.add(textField4);
		this.add(p4);
		JPanel p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("确认");
		p5.add(button2);
		this.add(p5);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
			if(textField2.getText().equals("")){
				JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
					}
			 else{
				 int option = JOptionPane.showConfirmDialog(panel,"            确认修改？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
			     switch (option) {
			     case JOptionPane.YES_OPTION: 
			     controller.toWebAdminUserView();
			     case JOptionPane.NO_OPTION:
			     }
			}
			}
		});
	}
}

