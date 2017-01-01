package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.UUID;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import VO.UserVO;
import common.UserType;
import uiService.MemberRegisterUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;
/**
 * 会员注册界面的Panel
 * @author lw
 *
 */
public class MemberRegisterView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2;
	private JLabel label_3,label2,label3,label4,label5,label5_1,label5_2,label5_3,label6,label7,label8;
	private JTextField textField2,textField6,textField7;
	private JPasswordField passwordField3,passwordField4;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3;
	private JComboBox<String> comboBox4;
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
		JPanel panel10 = new JPanel();
		panel10.setLayout(new FlowLayout(FlowLayout.CENTER));
		label8 = new JLabel("会员类型");
		comboBox4 = new JComboBox<String>();
		comboBox4.setPreferredSize(new Dimension(162,22)) ;
		comboBox4.addItem("普通会员");
		comboBox4.addItem("企业会员");
		comboBox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				String	selected=(String)comboBox4.getSelectedItem();
				if(selected.equals("企业会员")){
					textField7.setEditable(true);
				}
				else if(selected.equals("普通会员")){
					textField7.setText("");
					textField7.setEditable(false);				
				}
				}
			}
		});
		panel10.add(label8);
		panel10.add(comboBox4);
		this.add(panel10);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label2 = new JLabel("姓    名");
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
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		label7 = new JLabel("所属企业");
		textField7 = new JTextField(26);
		textField7.setEditable(false);
		panel9.add(label7);
		panel9.add(textField7);
		this.add(panel9);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("立即注册");
		panel8.add(button2);
		this.add(panel8);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {					
						String	selected=(String)comboBox4.getSelectedItem();
						if(selected.equals("企业会员")){
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
							if((textField2.getText().equals(""))||(password3.equals(""))||(password4.equals(""))||(textField6.getText().equals(""))||(textField7.getText().equals(""))){
								JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
							}
							else if((!password3.equals(""))&&(!password4.equals(""))&&(!password3.equals(password4))){
								JOptionPane.showMessageDialog(panel, "两次输入的密码不一致，请重新输入！","", JOptionPane.ERROR_MESSAGE);				
							}
							else if(p==1){
								JOptionPane.showMessageDialog(panel, "密码只能由数字和字母组成！","", JOptionPane.ERROR_MESSAGE);
							}
							else{
								 int option1 = JOptionPane.showConfirmDialog(panel,"            确认注册？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
							     switch (option1) {
							     case JOptionPane.YES_OPTION: 
							    	 {   
							    		 String id=UUID.randomUUID().toString().substring(0, 8);
							    		 String key=DES.init();
							    		 String str1=DES.encryptDES(id,key);
							    		 try {
							    			Log log=new Log();
											log.addKey(id,key,str1);
											} catch (RemoteException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
							    		 controller.addLog(id,key,str1);
									     String str2=DES.encryptDES(password4, key);
									     String str3=DES.encryptDES(textField2.getText(),key);
									     String str4=DES.encryptDES(textField6.getText(), key);
								    	 Calendar time=Calendar.getInstance();
								    	 time.set(Calendar.YEAR,(int)comboBox1.getSelectedItem());
								    	 time.set(Calendar.MONTH,(int)comboBox2.getSelectedItem()-1);
								    	 time.set(Calendar.DAY_OF_MONTH,(int)comboBox3.getSelectedItem());
								    	 UserVO vo=new UserVO(str3,str1,str4,"企业会员",UserType.Customer,time,textField7.getText());
								    	 controller.register(vo, str2);
							    		 int option2 = JOptionPane.showConfirmDialog(panel,"请记住你的账号："+id+"\n是否跳转到客户主界面？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
							    		 switch (option2) {
							     case JOptionPane.YES_OPTION:			    	
									     controller.tocustomerMainView(str1);
									    	 break;
									     case JOptionPane.NO_OPTION:
									    	 break;
							    		 }
							    		 break;
							    	 }
							     case JOptionPane.NO_OPTION:
							    	 break;
							     }		    						
							}
						}
						else if(selected.equals("普通会员")){
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
								 int option1 = JOptionPane.showConfirmDialog(panel,"            确认注册？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
							     switch (option1) {
							     case JOptionPane.YES_OPTION: 
							    	 {
							    		 String id=UUID.randomUUID().toString().substring(0, 8);
							    		 String key=DES.init();
							    		 String str1=DES.encryptDES(id,key);
							    		 try {
							    			Log log=new Log();
											log.addKey(id,key,str1);
											} catch (RemoteException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
							    		 controller.addLog(id,key,str1);
									     String str2=DES.encryptDES(password4, key);
									     String str3=DES.encryptDES(textField2.getText(),key);
									     String str4=DES.encryptDES(textField6.getText(), key);
								    	 Calendar time=Calendar.getInstance();
								    	 time.set(Calendar.YEAR,(int)comboBox1.getSelectedItem());
								    	 time.set(Calendar.MONTH,(int)comboBox2.getSelectedItem()-1);
								    	 time.set(Calendar.DAY_OF_MONTH,(int)comboBox3.getSelectedItem());
								    	 UserVO vo=new UserVO(str3,str1,str4,"普通会员",UserType.Customer,time,"");
								    	 controller.register(vo,str2);
							    		 int option2 = JOptionPane.showConfirmDialog(panel,"请记住你的账号："+id+"\n是否跳转到客户主界面？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
							    		 switch (option2) {
									     case JOptionPane.YES_OPTION:  		    	
									    		 controller.tocustomerMainView(str1);								    
									    	 break;
									     case JOptionPane.NO_OPTION:
									    	 break;
							    		 }	
							    	 }
							     case JOptionPane.NO_OPTION:
							    	 break;
							     }		    						
							}			
						}
						
				
					}
				});
				}

}
		