package UserView;

import java.awt.Dimension;
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
import javax.swing.JTextField;

import uiService.UserManagementUiService;



public class UserManagementView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JLabel label3,label4,label6,label7,label7_1,label7_2,label7_3,label8,label9,label10,label11,label12;
	private JTextField textField2,textField3,textField4,textField5,textField6,textField7,textField8;
	private JPanel panel,p3,p4,p5,p7,p8,p9,p10,p11,p12;
	private JComboBox<String> comboBox,comboBox4;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox5;
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
				controller.toWebAdminUserView("id");
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
				String	selected=(String)comboBox.getSelectedItem();
				//需要判断账号是否存在
				if(textField2.getText().equals("")){
					JOptionPane.showMessageDialog(panel, "请输入用户账号进行搜索！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(selected.equals("客户")){
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
					button5.setEnabled(false);
					button2.setEnabled(false);
					button7.setEnabled(false);
	
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
					textField3.setText("1");
					textField7.setText("1");
					comboBox4.addItem("1");
					textField8.setText("1");
					comboBox1.addItem(1);
					comboBox2.addItem(1);
					comboBox3.addItem(1);
					textField4.setText("1");
					textField5.setText("1");
					textField6.setText("1");
					
					button6.setEnabled(true);
				}
				else if(selected.equals("酒店工作人员")){
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
			textField3.setText("1");
			textField7.setText("1");
			textField4.setText("1");
			button6.setEnabled(true);
			
				}
				else if(selected.equals("网站营销人员")){
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
			textField3.setText("1");
			textField7.setText("1");
			textField4.setText("1");
			
			button6.setEnabled(true);
			button6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
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
			});
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
	
		
		label7 = new JLabel("生    日");
		Calendar cal=Calendar.getInstance();
		comboBox1=new JComboBox<Integer>();
		comboBox1.setPreferredSize(new Dimension(43,22));
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
	        	if(textField3.getText().equals("")||textField7.getText().equals("")||textField4.getText().equals("")||textField5.getText().equals("")||textField6.getText().equals("")){
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
					comboBox1.setEnabled(false);
					comboBox2.setEnabled(false);
					comboBox3.setEnabled(false);
					textField4.setEnabled(false);
					textField5.setEnabled(false);
					textField6.setEnabled(false);
					button5.setVisible(false);
					button5.setEnabled(false);
					button2.setVisible(false);
					button7.setVisible(false);
					button2.setEnabled(false);
					button7.setEnabled(false);
	        	}
	        }
		});
		button6.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
				textField3.setEnabled(true);
				textField7.setEnabled(true);				
				comboBox4.setEnabled(true);			
				textField8.setEnabled(true);				
				comboBox1.setEnabled(true);				
				comboBox2.setEnabled(true);
				comboBox3.setEnabled(true);			
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
	        }
		});
	
		button5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
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
	        		JOptionPane.showMessageDialog(panel, "  成功添加网站营销人员！\n请记住账号：","", JOptionPane.ERROR_MESSAGE);
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

