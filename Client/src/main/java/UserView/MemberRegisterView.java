package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import VO.UserVO;
import uiService.MemberRegisterUiService;

public class MemberRegisterView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2;
	private JLabel label_3,label2,label3,label4,label5,label5_1,label5_2,label5_3,label6;
	private JTextField textField2,textField6;
	private JPasswordField passwordField3,passwordField4;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3;
	private MemberRegisterUiService controller;
	private JPanel panel;
	public MemberRegisterView(MemberRegisterUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
		panel=new JPanel();
		panel=this;
	}
	private void initButton() {
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel1.add(button1);
		this.add(panel1);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toLogView();
			}
		});
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("用 户 名");
		textField2 = new JTextField(26);
		panel2.add(label2);
		panel2.add(textField2);
		this.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label3 = new JLabel("                          密    码");
		passwordField3 = new JPasswordField(26);
		label_3= new JLabel("（只能由数字和字母组成） ");
		panel3.add(label3);
		panel3.add(passwordField3);
		panel3.add(label_3);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label4 = new JLabel("确认密码");
		passwordField4 = new JPasswordField(26);
		panel4.add(label4);
		panel4.add(passwordField4);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		Calendar cal=Calendar.getInstance();
		label5 = new JLabel("    生    日");
		comboBox1=new JComboBox<Integer>();
		for(int i=1900;i<2017;i++){
			comboBox1.addItem(i);
		}
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox1.getSelectedItem();
				int selected2=(int)comboBox2.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox3.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox3.addItem(k);
				}
				}
			}
		});
		label5_1 = new JLabel("年");
		comboBox2=new JComboBox<Integer>();
		for(int i=1;i<13;i++){
			comboBox2.addItem(i);
		}
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
					int	selected1=(int)comboBox1.getSelectedItem();
					int selected2=(int)comboBox2.getSelectedItem();
					cal.set(Calendar.YEAR,selected1);
					cal.set(Calendar.MONTH,selected2-1);
					int maxDate=cal.getActualMaximum(Calendar.DATE);
					comboBox3.removeAllItems();
					for(int k=1;k<maxDate+1;k++){
						comboBox3.addItem(k);
					}
					}
				}
		});
		label5_2 = new JLabel("月");
		comboBox3=new JComboBox<Integer>();
		for(int k=1;k<32;k++){
			comboBox3.addItem(k);
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
		textField6 = new JTextField(26);
		panel6.add(label6);
		panel6.add(textField6);
		this.add(panel6);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("立即注册");
		panel8.add(button2);
		this.add(panel8);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				char[] pass3 = passwordField3.getPassword();
				String password3 = new String(pass3);
				char[] pass4 = passwordField4.getPassword();
				String password4 = new String(pass4);
				int p=0;
				for(int i=0;i<pass3.length;i++){
				  if((!Character.isDigit(pass3[i]))&&(!Character.isLetter(pass3[i]))){
					  p=1;
				  }
				}
				if((textField2.getText().equals(""))||(password3.equals(""))||(password4.equals(""))||(textField6.getText().equals(""))){
					JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
				}
				else if((!password3.equals(""))&&(!password4.equals(""))&&(!password3.equals(password4))){
					JOptionPane.showMessageDialog(panel, "两次输入的密码不一致，请重新输入！","", JOptionPane.ERROR_MESSAGE);				
				}
				else if(p==1){
					JOptionPane.showMessageDialog(panel, "密码只能由数字和字母组成！","", JOptionPane.ERROR_MESSAGE);
				}
				else{
					 int option = JOptionPane.showConfirmDialog(panel,"            确认注册？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
				     switch (option) {
					     case JOptionPane.YES_OPTION:
					    	 UserVO vo=new UserVO();//暂时这么初始化
					    	 if(controller.createUser(vo)){
						    	 vo.id="2";//暂时定为2，需要有方法产生ID，并告诉用户
						    	 controller.tocustomerMainView(vo.id);
					    	 }
					    	 break;
					     case JOptionPane.NO_OPTION:
					    	 break;
				     }		    						
				}
			}
		});
	}
}
		