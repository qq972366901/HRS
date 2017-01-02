package userView;

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
import javax.swing.JTextField;

import common.DES;
import common.UserType;
import uiService.UserManagementUiService;
import userBLServiceImpl.Log;
import vo.UserVO;


/**
 * 用户管理界面的Panel
 * @author lw
 *
 */
public class UserManagementView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JLabel label3,label4,label6,label7,label7_1,label7_2,label7_3,label8,label9,label10,label11,label12;
	private JTextField textField2,textField3,textField4,textField5,textField6,textField7,textField8;
	private JPanel panel,p3,p4,p5,p7,p8,p9,p10,p11,p12;
	private JComboBox<String> comboBox,comboBox4;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox5;
	String str1=null;
	String key=null;
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
				try {
					controller.toWebAdminUserView(controller.getUserID());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JPanel p6=new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		label6 = new JLabel("用户类型");
		comboBox=new JComboBox<String>();
		comboBox.addItem("客户");
		comboBox.addItem("酒店工作人员");
		comboBox.addItem("网站营销人员");
		comboBox.setPreferredSize(new Dimension(132,22)) ;
		
		button4=new JButton("添加");
		button4.setEnabled(false);
		button4.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				button6.setEnabled(false);
				label3.setVisible(false);
				textField3.setVisible(false);
				label12.setVisible(false);
				textField7.setVisible(false);
				label8.setVisible(false);
				comboBox4.setVisible(false);
				label9.setVisible(false);
				textField8.setVisible(false);
				label7.setVisible(false);
				comboBox1.setVisible(false);
				label7_1.setVisible(false);
				comboBox2.setVisible(false);
				label7_2.setVisible(false);
				comboBox3.setVisible(false);
				label7_3.setVisible(false);
				label4.setVisible(false);
				textField4.setVisible(false);
				label10.setVisible(false);
				textField5.setVisible(false);
				label11.setVisible(false);
				textField6.setVisible(false);
				button7.setVisible(false);
				button5.setVisible(false);
				button2.setVisible(false);
				
				textField3.setEnabled(false);
				textField7.setEnabled(false);				
				comboBox4.setEnabled(false);			
				textField8.setEnabled(false);				
				comboBox1.setEnabled(false);				
				comboBox2.setEnabled(false);
				comboBox3.setEnabled(false);			
				textField4.setEnabled(false);				
				textField5.setEnabled(false);				
				textField6.setEnabled(false);
				button7.setEnabled(false);
				button5.setEnabled(false);
				button2.setEnabled(false);
				
				textField4.setText("");
				textField3.setText("");
				textField7.setText("");
				label3.setVisible(true);
				textField3.setVisible(true);
				label12.setVisible(true);
				textField7.setVisible(true);
				label4.setVisible(true);
				textField4.setVisible(true);
				textField3.setEnabled(true);
				textField7.setEnabled(true);
				textField4.setEnabled(true);
				button7.setVisible(true);
				button5.setVisible(true);
				button7.setEnabled(true);
				button5.setEnabled(true);
				
				button5.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	label3.setVisible(false);
						textField3.setVisible(false);
						label12.setVisible(false);
						textField7.setVisible(false);
						label8.setVisible(false);
						comboBox4.setVisible(false);
						label9.setVisible(false);
						textField8.setVisible(false);
						label7.setVisible(false);
						comboBox1.setVisible(false);
						label7_1.setVisible(false);
						comboBox2.setVisible(false);
						label7_2.setVisible(false);
						comboBox3.setVisible(false);
						label7_3.setVisible(false);
						label4.setVisible(false);
						textField4.setVisible(false);
						label10.setVisible(false);
						textField5.setVisible(false);
						label11.setVisible(false);
						textField6.setVisible(false);
						button7.setVisible(false);
						button5.setVisible(false);
						button2.setVisible(false);
						
						textField3.setEnabled(false);
						textField7.setEnabled(false);				
						comboBox4.setEnabled(false);			
						textField8.setEnabled(false);							
						textField4.setEnabled(false);				
						textField5.setEnabled(false);				
						textField6.setEnabled(false);
						button7.setEnabled(false);
						button5.setEnabled(false);
						button2.setEnabled(false);
						
						textField4.setText("");
						textField3.setText("");
						textField7.setText("");
			        }
				});
			}
		});
		p6.add(label6);
		p6.add(comboBox);
		p6.add(button4);
		this.add(p6);
		JPanel p2=new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		textField2=new JTextField(30);
		button3=new JButton("查询");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label3.setVisible(false);
				textField3.setVisible(false);
				label12.setVisible(false);
				textField7.setVisible(false);
				label8.setVisible(false);
				comboBox4.setVisible(false);
				label9.setVisible(false);
				textField8.setVisible(false);
				label7.setVisible(false);
				comboBox1.setVisible(false);
				label7_1.setVisible(false);
				comboBox2.setVisible(false);
				label7_2.setVisible(false);
				comboBox3.setVisible(false);
				label7_3.setVisible(false);
				label4.setVisible(false);
				textField4.setVisible(false);
				label10.setVisible(false);
				textField5.setVisible(false);
				label11.setVisible(false);
				textField6.setVisible(false);
				button7.setVisible(false);
				button5.setVisible(false);
				button2.setVisible(false);
				String	selected=(String)comboBox.getSelectedItem();
				//需要判断账号是否存在
				try {
					Log log=new Log();
					key=log.getKey(textField2.getText());
				} catch (RemoteException e1) {
					System.out.println("获取密钥失败");
					e1.printStackTrace();
				}
				if(key!=null){
					str1=DES.encryptDES(textField2.getText(),key);
				}
				else{
					return;
				}
				if(textField2.getText().equals("")){
					JOptionPane.showMessageDialog(panel, "请输入用户账号进行搜索！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(controller.judge(str1)==false){
					JOptionPane.showMessageDialog(panel, "请输入正确的账号进行搜索！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(selected.equals("客户")&&(controller.getUser(UserType.Customer,str1)!=null)){
						button2.setVisible(false);
						button5.setVisible(false);
						button7.setVisible(false);
                        textField3.setEnabled(false);
                        textField7.setEnabled(false);
                        textField4.setEnabled(false);
                        comboBox4.setEnabled(false);
						label3.setVisible(true);
						textField3.setVisible(true);
						label12.setVisible(true);
						textField7.setVisible(true);
						label8.setVisible(true);
						comboBox4.setVisible(true);
						label9.setVisible(true);
						textField8.setVisible(true);
						label7.setVisible(true);
						comboBox1.setVisible(true);
						label7_1.setVisible(true);
						comboBox2.setVisible(true);
						label7_2.setVisible(true);
						comboBox3.setVisible(true);
						label7_3.setVisible(true);
						label4.setVisible(true);
						textField4.setVisible(true);
						label10.setVisible(true);
						textField5.setVisible(true);
						label11.setVisible(true);
						textField6.setVisible(true);
						//从VO获取数据
						String str2=DES.decryptDES(controller.getUser(UserType.Customer,str1).username, key);
						String str3=DES.decryptDES(controller.getUser(UserType.Customer,str1).userpassword,key);
						String str4=DES.decryptDES(controller.getUser(UserType.Customer,str1).contactway, key);
						textField3.setText(str2);
						textField7.setText(str3);
						comboBox4.removeAllItems();
						comboBox4.addItem(controller.getUser(UserType.Customer,str1).membertype);
						textField8.setText(String.valueOf(controller.showLevel(str1)));
						comboBox1.removeAllItems();
						comboBox2.removeAllItems();
						comboBox3.removeAllItems();
						Calendar birthday=controller.getUser(UserType.Customer,str1).birthday;
						int year=birthday.get(Calendar.YEAR);
						int month=birthday.get(Calendar.MONTH)+1;
						int day=birthday.get(Calendar.DATE);
						comboBox1.addItem(year);
						comboBox2.addItem(month);
						comboBox3.addItem(day);
						textField4.setText(str4);
						textField5.setText(controller.getUser(UserType.Customer,str1).enterprise);
						textField6.setText(String.valueOf(controller.showCredit(str1)));					
						button6.setEnabled(true);
						textField5.setEnabled(false);
					}
					else if(selected.equals("酒店工作人员")&&(controller.getUser(UserType.HotelWorker,str1)!=null)){
						label8.setVisible(false);
						comboBox4.setVisible(false);
						label9.setVisible(false);
						textField8.setVisible(false);
						label7.setVisible(false);
						comboBox1.setVisible(false);
						label7_1.setVisible(false);
						comboBox2.setVisible(false);
						label7_2.setVisible(false);
						comboBox3.setVisible(false);
						label7_3.setVisible(false);
						label10.setVisible(false);
						textField5.setVisible(false);
						label11.setVisible(false);
						textField6.setVisible(false);
						button2.setVisible(false);
						button5.setVisible(false);
						button7.setVisible(false);
						
						textField3.setEnabled(false);
						textField7.setEnabled(false);				
						comboBox4.setEnabled(false);
						comboBox4.removeAllItems();
						textField8.setEnabled(false);				
						comboBox1.setEnabled(false);				
						comboBox2.setEnabled(false);
						comboBox3.setEnabled(false);
						comboBox1.removeAllItems();
						comboBox2.removeAllItems();
						comboBox3.removeAllItems();
						textField4.setEnabled(false);				
						textField5.setEnabled(false);				
						textField6.setEnabled(false);
						button2.setEnabled(false);
						button5.setEnabled(false);
						button7.setEnabled(false);
						textField5.setText("1");
						textField6.setText("1");
						label3.setVisible(true);
						textField3.setVisible(true);
						label12.setVisible(true);
						textField7.setVisible(true);
						label4.setVisible(true);
						textField4.setVisible(true);
						//从VO获取数据
						String str2=DES.decryptDES(controller.getUser(UserType.HotelWorker,str1).username, key);
						String str3=DES.decryptDES(controller.getUser(UserType.HotelWorker,str1).userpassword,key);
						String str4=DES.decryptDES(controller.getUser(UserType.HotelWorker,str1).contactway, key);
						textField3.setText(str2);
						textField7.setText(str3);
						textField4.setText(str4);
						button6.setEnabled(true);
					}
					else if(selected.equals("网站营销人员")&&(controller.getUser(UserType.WebPromotionWorker,str1)!=null)){
						label8.setVisible(false);
						comboBox4.setVisible(false);
						label9.setVisible(false);
						textField8.setVisible(false);
						label7.setVisible(false);
						comboBox1.setVisible(false);
						label7_1.setVisible(false);
						comboBox2.setVisible(false);
						label7_2.setVisible(false);
						comboBox3.setVisible(false);
						label7_3.setVisible(false);
						label10.setVisible(false);
						textField5.setVisible(false);
						label11.setVisible(false);
						textField6.setVisible(false);
						button2.setVisible(false);
						button5.setVisible(false);
						button7.setVisible(false);
						
						textField3.setEnabled(false);
						textField7.setEnabled(false);				
						comboBox4.setEnabled(false);	
						comboBox4.removeAllItems();
						textField8.setEnabled(false);				
						comboBox1.setEnabled(false);				
						comboBox2.setEnabled(false);
						comboBox3.setEnabled(false);
						comboBox1.removeAllItems();
						comboBox2.removeAllItems();
						comboBox3.removeAllItems();
						textField4.setEnabled(false);				
						textField5.setEnabled(false);				
						textField6.setEnabled(false);
						button2.setEnabled(false);
						button5.setEnabled(false);
						button7.setEnabled(false);
						textField5.setText("1");
						textField6.setText("1");
						label3.setVisible(true);
						textField3.setVisible(true);
						label12.setVisible(true);
						textField7.setVisible(true);
						label4.setVisible(true);
						textField4.setVisible(true);
						//从VO获取数据
						String str2=DES.decryptDES(controller.getUser(UserType.WebPromotionWorker,str1).username, key);
						String str3=DES.decryptDES(controller.getUser(UserType.WebPromotionWorker,str1).userpassword,key);
						String str4=DES.decryptDES(controller.getUser(UserType.WebPromotionWorker,str1).contactway, key);
						textField3.setText(str2);
						textField7.setText(str3);
						textField4.setText(str4);
						button6.setEnabled(true);
			}
			else{
				JOptionPane.showMessageDialog(panel, "请输入与选择类型相符的账号进行搜索！","", JOptionPane.ERROR_MESSAGE);
			}
			}
			});
		button6=new JButton("更改");
		button6.setEnabled(false);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				String	selected=(String)comboBox.getSelectedItem();
				if(selected.equals("客户")||selected.equals("酒店工作人员")){
				button4.setEnabled(false);
				}
				else{
				button4.setEnabled(true);
				}
				}
			}
		});
		p2.add(textField2);
		p2.add(button3);
		p2.add(button6);
		this.add(p2);
		p3=new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p3);
		p12=new JPanel();
		p12.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p12);
		p4=new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p4);
		p8=new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p8);
		p9=new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p9);
		p7=new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p7);
		p10=new JPanel();
		p10.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p10);
		p11=new JPanel();
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p11);
		p5=new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(p5);
		
		label3 = new JLabel("姓    名");
		textField3 = new JTextField(30);
		p3.add(label3);
		p3.add(textField3);
		textField3.setEnabled(false);
		
		
		label12 = new JLabel("密    码");
		textField7 = new JTextField(30);
		p12.add(label12);
		p12.add(textField7);
		textField7.setEnabled(false);
		
		label4 = new JLabel("联系方式");
		textField4 = new JTextField(30);
		textField4.setEnabled(false);
		p4.add(label4);
		p4.add(textField4);
		
		label8 = new JLabel("会员类型");
		comboBox4=new JComboBox<String>();
		comboBox4.setPreferredSize(new Dimension(186,22)) ;
		comboBox4.setEnabled(false);		
		p8.add(label8);
		p8.add(comboBox4);
		
		
		label9 = new JLabel("会员等级");
		textField8=new JTextField(30);
		textField8.setEnabled(false);		
		p9.add(label9);
		p9.add(textField8);
	
		
		label7 = new JLabel(" 生    日");
		Calendar cal=Calendar.getInstance();
		comboBox1=new JComboBox<Integer>();
		comboBox1.setPreferredSize(new Dimension(49,22));
		comboBox1.setEnabled(false);		
		label7_1 = new JLabel("年");
		comboBox2=new JComboBox<Integer>();
		comboBox2.setPreferredSize(new Dimension(43,22));
		comboBox2.setEnabled(false);			
		label7_2 = new JLabel("月");
		comboBox3=new JComboBox<Integer>();
		comboBox3.setPreferredSize(new Dimension(43,22));
		comboBox3.setEnabled(false);
		label7_3 = new JLabel("日");
		p7.add(label7);
		p7.add(comboBox1);
		p7.add(label7_1);
		p7.add(comboBox2);
		p7.add(label7_2);
		p7.add(comboBox3);
		p7.add(label7_3);
		
		
		label10 = new JLabel("所属企业");
		textField5 = new JTextField(30);
		textField5.setEnabled(false);
		p10.add(label10);
		p10.add(textField5);
		
		label11 = new JLabel("信 用 值");
		textField6 = new JTextField(30);
		textField6.setEnabled(false);
		p11.add(label11);
		p11.add(textField6);
		
		
		button2=new JButton("确定");

		button5=new JButton("取消");
		
		button7=new JButton("添加");
		
        button2.setEnabled(false);
        button5.setEnabled(false);
        button7.setEnabled(false);
        p5.add(button7);
		p5.add(button2);
		p5.add(button5);
		
		label3.setVisible(false);
		textField3.setVisible(false);
		label12.setVisible(false);
		textField7.setVisible(false);
		label8.setVisible(false);
		comboBox4.setVisible(false);
		label9.setVisible(false);
		textField8.setVisible(false);
		label7.setVisible(false);
		comboBox1.setVisible(false);
		label7_1.setVisible(false);
		comboBox2.setVisible(false);
		label7_2.setVisible(false);
		comboBox3.setVisible(false);
		label7_3.setVisible(false);
		label4.setVisible(false);
		textField4.setVisible(false);
		label10.setVisible(false);
		textField5.setVisible(false);
		label11.setVisible(false);
		textField6.setVisible(false);
		button2.setVisible(false);
		button5.setVisible(false);
		button7.setVisible(false);
		button2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String password= textField7.getText();
	        	char[] pass=password.toCharArray();
	        	int p=0;
				for(int i=0;i<pass.length;i++){
				  if((!Character.isDigit(pass[i]))&&(!Character.isLetter(pass[i]))){
					  p=1;
				  }
				}
	        	if(textField3.getText().equals("")||textField7.getText().equals("")||textField4.getText().equals("")||(textField5.getText().equals("")&&(((String)comboBox4.getSelectedItem()).equals("企业会员")))||textField6.getText().equals("")){
					JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
						}
            
	        	else if(p==1){
	        		JOptionPane.showMessageDialog(panel, "密码只能由数字和字母组成！","", JOptionPane.ERROR_MESSAGE);
						}
	        	else{
	        		textField3.setEnabled(false);
					textField7.setEnabled(false);
					comboBox4.setEnabled(false);
					textField8.setEnabled(false);

					textField4.setEnabled(false);
					textField5.setEnabled(false);
					textField6.setEnabled(false);
					button5.setVisible(false);
					button5.setEnabled(false);
					button2.setVisible(false);
					button7.setVisible(false);
					button2.setEnabled(false);
					button7.setEnabled(false);
					if(controller.findByID(str1).type.equals(UserType.Customer)){
							int year=(int)comboBox1.getSelectedItem();
							int month=(int)comboBox2.getSelectedItem();
							int day=(int)comboBox3.getSelectedItem();
							Calendar c =Calendar.getInstance();
							c.set(Calendar.YEAR,year);
							c.set(Calendar.MONTH,month-1);//从0开始，0表是1月，1表示2月依次类推
							c.set(Calendar.DAY_OF_MONTH,day);
							String str2=DES.encryptDES(textField3.getText(),key);
						    String str3=DES.encryptDES(textField7.getText(),key);
						    String str4=DES.encryptDES(textField4.getText(),key);
						    String enterprise="";
						    if(((String)comboBox4.getSelectedItem()).equals("普通会员")){
						    	textField5.setText(null);
						    }
						    else if(((String)comboBox4.getSelectedItem()).equals("企业会员")){
						    	enterprise=textField5.getText();
						    }
							UserVO vo=new UserVO(str2,str1,str4,(String)comboBox4.getSelectedItem(),UserType.Customer,c,enterprise);
							controller.update(vo);
							controller.revisepassword(str1,str3);
					}
					else if(controller.findByID(str1).type.equals(UserType.HotelWorker)){
						String str2=DES.encryptDES(textField3.getText(),key);
					    String str3=DES.encryptDES(textField7.getText(),key);
					    String str4=DES.encryptDES(textField4.getText(),key);
						UserVO vo=new UserVO(str2,str1,str4,null,UserType.HotelWorker,null,null);
						controller.update(vo);
						controller.revisepassword(str1,str3);
					}
					else if(controller.findByID(str1).type.equals(UserType.WebPromotionWorker)){
						String str2=DES.encryptDES(textField3.getText(),key);
					    String str3=DES.encryptDES(textField7.getText(),key);
					    String str4=DES.encryptDES(textField4.getText(),key);
						UserVO vo=new UserVO(str2,str1,str4,null,UserType.WebPromotionWorker,null,null);
						controller.update(vo);
						controller.revisepassword(str1,str3);
					}
	        	}
	        }
		});
		button6.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if(controller.getUser(UserType.Customer,str1).membertype.equals("普通会员")){
				textField3.setEnabled(true);
				textField7.setEnabled(true);				
				comboBox4.setEnabled(true);			
				textField8.setEnabled(false);				
				textField4.setEnabled(true);				
				textField5.setEnabled(false);				
				textField6.setEnabled(false);
				button2.setEnabled(true);
				button5.setEnabled(true);
				button7.setEnabled(true);
				button2.setVisible(true);
				button5.setVisible(true);
				button2.setEnabled(true);
				button5.setEnabled(true);
				button7.setVisible(false);	
				button7.setEnabled(false);
				comboBox4.removeAllItems();
				comboBox4.addItem("普通会员");
				comboBox4.addItem("企业会员");
				comboBox4.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){	
							String selected=(String)comboBox4.getSelectedItem();
							if(selected.equals("企业会员")){
								textField5.setEnabled(true);
							}
							else{
								textField5.setEnabled(false);
							}
						}
					}
				});
	        	}
	        	else if(controller.getUser(UserType.Customer,str1).membertype.equals("企业会员")){
	        		textField3.setEnabled(true);
					textField7.setEnabled(true);				
					comboBox4.setEnabled(true);			
					textField4.setEnabled(true);				
					textField5.setEnabled(true);
					textField6.setEnabled(false);
					button2.setEnabled(true);
					button5.setEnabled(true);
					button7.setEnabled(true);
					button2.setVisible(true);
					button5.setVisible(true);
					button2.setEnabled(true);
					button5.setEnabled(true);
					button7.setVisible(false);	
					button7.setEnabled(false);
					comboBox4.removeAllItems();
					comboBox4.addItem("企业会员");
					comboBox4.addItem("普通会员");
					comboBox4.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange() == ItemEvent.SELECTED){	
								String selected=(String)comboBox4.getSelectedItem();
								if(selected.equals("普通会员")){	
									textField5.setEnabled(false);
								}
								else{
									textField5.setEnabled(true);
								}
							}
						}
					});
	        	}
	        	else{
	        		textField3.setEnabled(true);
					textField7.setEnabled(true);
					textField4.setEnabled(true);
					button2.setVisible(true);
					button5.setVisible(true);
					button2.setEnabled(true);
					button5.setEnabled(true);
					button7.setVisible(false);
					button7.setEnabled(false);
	        	}
	        }
		});
	
	
		button5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
				String str2=DES.decryptDES(controller.findByID(str1).username,key);
				String str3=DES.decryptDES(controller.getUser(controller.findByID(str1).type,str1).userpassword,key);
				String str4=DES.decryptDES(controller.findByID(str1).contactway,key);
				textField3.setText(str2);
				textField7.setText(str3);
				comboBox4.removeAllItems();
				comboBox4.addItem(controller.findByID(str1).membertype);
				textField8.setText(String.valueOf(controller.showLevel(str1)));
				comboBox1.removeAllItems();
				comboBox2.removeAllItems();
				comboBox3.removeAllItems();
				Calendar birthday=controller.findByID(str1).birthday;
				int year=birthday.get(Calendar.YEAR);
				int month=birthday.get(Calendar.MONTH)+1;
				int day=birthday.get(Calendar.DATE);
				comboBox3.addItem(day);
				comboBox1.addItem(year);
				comboBox2.addItem(month);
				textField4.setText(str4);
				textField5.setText(controller.findByID(str1).enterprise);
				textField6.setText(String.valueOf(controller.showCredit(str1)));
				textField3.setEnabled(false);
				textField7.setEnabled(false);
				comboBox4.setEnabled(false);
				textField8.setEnabled(false);
				comboBox1.setEnabled(false);
				comboBox2.setEnabled(false);
				comboBox3.setEnabled(false);
				textField4.setEnabled(false);
				textField5.setEnabled(false);
				textField6.setEnabled(false);
	        	button2.setVisible(false);
				button5.setVisible(false);
				button2.setEnabled(false);
				button5.setEnabled(false);
				button7.setVisible(false);
				button7.setEnabled(false);
	        }
		});
		button7.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String password= textField7.getText();
	        	char[] pass=password.toCharArray();
	        	int p=0;
				for(int i=0;i<pass.length;i++){
				  if((!Character.isDigit(pass[i]))&&(!Character.isLetter(pass[i]))){
					  p=1;
				  }
				}
	        	if(textField3.getText().equals("")||textField7.getText().equals("")||textField4.getText().equals("")){
					JOptionPane.showMessageDialog(panel, "          请补全信息！","", JOptionPane.ERROR_MESSAGE);
						}
            
	        	else if(p==1){
	        		JOptionPane.showMessageDialog(panel, "密码只能由数字和字母组成！","", JOptionPane.ERROR_MESSAGE);
						}
	        	else{
	        		String id=UUID.randomUUID().toString().substring(0, 8);
	        		String key1=DES.init();
	        		String str5=DES.encryptDES(id,key1);
	        		 try {
	        			Log log=new Log();
						log.addKey(id,key1,str5);
						} catch (RemoteException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
	                 controller.addLog(id,key1,str5);
				     String str6=DES.encryptDES(textField7.getText(), key1);
				     String str7=DES.encryptDES(textField3.getText(),key1);
				     String str8=DES.encryptDES(textField4.getText(), key1);
	        		UserVO vo=new UserVO(str7,str5,str8,null,UserType.WebPromotionWorker,null,null);
	        		controller.register(vo,str6);
	        		JOptionPane.showMessageDialog(panel, "  成功添加网站营销人员！\n请记住账号："+id,"", JOptionPane.ERROR_MESSAGE);
	        		label3.setVisible(false);
					textField3.setVisible(false);
					label12.setVisible(false);
					textField7.setVisible(false);
					label8.setVisible(false);
					comboBox4.setVisible(false);
					label9.setVisible(false);
					textField8.setVisible(false);
					label7.setVisible(false);
					comboBox1.setVisible(false);
					label7_1.setVisible(false);
					comboBox2.setVisible(false);
					label7_2.setVisible(false);
					comboBox3.setVisible(false);
					label7_3.setVisible(false);
					label4.setVisible(false);
					textField4.setVisible(false);
					label10.setVisible(false);
					textField5.setVisible(false);
					label11.setVisible(false);
					textField6.setVisible(false);
					button7.setVisible(false);
					button5.setVisible(false);
					button2.setVisible(false);
					
					textField3.setEnabled(false);
					textField7.setEnabled(false);				
					comboBox4.setEnabled(false);			
					textField8.setEnabled(false);				
					comboBox1.setEnabled(false);				
					comboBox2.setEnabled(false);
					comboBox3.setEnabled(false);			
					textField4.setEnabled(false);				
					textField5.setEnabled(false);				
					textField6.setEnabled(false);
					button7.setEnabled(false);
					button5.setEnabled(false);
					button2.setEnabled(false);
					
					textField4.setText("");
					textField3.setText("");
					textField7.setText("");
	        	}
	        }
		});
	}
}

