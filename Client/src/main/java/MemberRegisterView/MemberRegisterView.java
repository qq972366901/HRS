package MemberRegisterView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import uiService.MemberRegisterUiService;

public class MemberRegisterView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2;
	private JLabel label_3,label_7,label2,label3,label4,label5,label5_1,label5_2,label5_3,label6,label7;
	private JTextField textField2,textField6,textField7;
	private JPasswordField passwordField3,passwordField4;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3;
	private MemberRegisterUiService controller;
	public MemberRegisterView(MemberRegisterUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
	}
	private void initButton() {
		JPanel p1=new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		p1.add(button1);
		this.add(p1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toLogView();
			}
		});
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("      用户名");
		textField2 = new JTextField(10);
		panel2.add(label2);
		panel2.add(textField2);
		this.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label3 = new JLabel("                                                              密码");
		passwordField3 = new JPasswordField(10);
		label_3= new JLabel("（只能填写字符和数字）  ");
		panel3.add(label3);
		panel3.add(passwordField3);
		panel3.add(label_3);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label4 = new JLabel("确认密码 ");
		passwordField4 = new JPasswordField(10);
		panel4.add(label4);
		panel4.add(passwordField4);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5 = new JLabel("生日");
		comboBox1=new JComboBox<Integer>();
		for(int i=1900;i<2017;i++){
			comboBox1.addItem(i);
		}
		label5_1 = new JLabel("年");
		comboBox2=new JComboBox<Integer>();
		for(int i=1;i<13;i++){
			comboBox2.addItem(i);
		}
		label5_2 = new JLabel("月");
		comboBox3=new JComboBox<Integer>();
		for(int i=1;i<32;i++){
			comboBox3.addItem(i);
		}
		label5_3 = new JLabel("日");
		panel5.add(label5);
		panel5.add(comboBox1);
		panel5.add(label5_1);
		panel5.add(comboBox2);
		panel5.add(label5_2);
		panel5.add(comboBox3);
		panel5.add(label5_3);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label6 = new JLabel("联系方式");
		textField6 = new JTextField(10);
		panel6.add(label6);
		panel6.add(textField6);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label7 = new JLabel("                                                          所属酒店");
		textField7 = new JTextField(10);
		label_7=new JLabel("（非酒店工作人员不用填写）");
		panel7.add(label7);
		panel7.add(textField7);
		panel7.add(label_7);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("立即注册");
		panel8.add(button2);
		this.add(panel8);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new  JFrame();
				frame.setBounds(360,260,300,200);
				frame.setVisible(true);
				JPanel panel= new JPanel();
				panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
				frame.getContentPane().add(panel);
				JPanel panel1= new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel label = new JLabel("注册成功！");
				panel1.add(label);
				panel.add(panel1);
				JPanel panel2= new JPanel();
				panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton button = new JButton("确定");
				panel2.add(button);
				panel.add(panel2);
				button.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						controller.toLogView();
					}
				});
			}
		});		
	}
}
		