package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;

public class OrderBuildView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17;
	private JButton button1,button2;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox8,comboBox9,comboBox11,comboBox12;
	private JComboBox<String> comboBox10,comboBox13;
	private OrderBuildUiService controller;
	
	public OrderBuildView(OrderBuildUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
	}

	private void initButton() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel.add(button1);
		this.add(panel);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toHotelBrowseView();
			}
		});
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		label1=new JLabel("开始时间");
		comboBox1= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
		    comboBox1.addItem(i);
			}
		label2=new JLabel("年");
		comboBox2= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox2.addItem(i);
			}
		label3=new JLabel("月");
		comboBox3= new JComboBox<Integer>();
		for(int i=1;i<32;i++){
		    comboBox3.addItem(i);
			}
		label4=new JLabel("日");
		panel1.add(label1);
		panel1.add(comboBox1);
		panel1.add(label2);
		panel1.add(comboBox2);
		panel1.add(label3);
		panel1.add(comboBox3);
		panel1.add(label4);
		this.add(panel1);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5=new JLabel("退房时间");
		comboBox4= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
		    comboBox4.addItem(i);
			}
		label6=new JLabel("年");
		comboBox5= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox5.addItem(i);
			}
		label7=new JLabel("月");
		comboBox6= new JComboBox<Integer>();		
		for(int i=1;i<32;i++){
		    comboBox6.addItem(i);
			}
		label8=new JLabel("日");
		panel2.add(label5);
		panel2.add(comboBox4);
		panel2.add(label6);
		panel2.add(comboBox5);
		panel2.add(label7);
		panel2.add(comboBox6);
		panel2.add(label8);
		this.add(panel2);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label9=new JLabel("最晚订单执行时间");
		comboBox7= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
		    comboBox7.addItem(i);
			}
		label10=new JLabel("年");
		comboBox8= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox8.addItem(i);
			}
		label11=new JLabel("月");
		comboBox9= new JComboBox<Integer>();		
		for(int i=1;i<32;i++){
		    comboBox9.addItem(i);
			}
		label12=new JLabel("日");
		panel3.add(label9);
		panel3.add(comboBox7);
		panel3.add(label10);
		panel3.add(comboBox8);
		panel3.add(label11);
		panel3.add(comboBox9);
		panel3.add(label12);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label13=new JLabel("房间类型");
		comboBox10= new JComboBox<String>();
		panel4.add(label13);
		panel4.add(comboBox10);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label14=new JLabel("房间数量");
		comboBox11= new JComboBox<Integer>();
		for(int i=1;i<101;i++){
		    comboBox11.addItem(i);
			}
		panel5.add(label14);
		panel5.add(comboBox11);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label15=new JLabel("预计入住人数");
		comboBox12= new JComboBox<Integer>();
		for(int i=1;i<101;i++){
		    comboBox12.addItem(i);
			}
		panel6.add(label15);
		panel6.add(comboBox12);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label16=new JLabel("有无儿童");
		comboBox13= new JComboBox<String>();
		comboBox13.addItem("无");
		comboBox13.addItem("有");
		panel7.add(label16);
		panel7.add(comboBox13);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		label17=new JLabel("总价          元");
		panel8.add(label17);
		this.add(panel8);
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("提交订单");
		panel9.add(button2);
		this.add(panel9);
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
				JLabel label = new JLabel("提交成功！");
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
						controller.toHotelBrowseView();
					}
				});
			}
		});
	}
}