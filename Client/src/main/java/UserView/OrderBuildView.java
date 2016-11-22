package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uiService.OrderBuildUiService;

public class OrderBuildView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17;
	private JButton button1,button2;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox8,comboBox9,comboBox11,comboBox12;
	private JComboBox<String> comboBox10,comboBox13;
	private JPanel pane;
	private OrderBuildUiService controller;
	
	public OrderBuildView(OrderBuildUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initButton();
		this.validate();
		pane=new JPanel();
		pane=this;
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
		Calendar cal=Calendar.getInstance();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));	
		label1=new JLabel(" 开  始  时  间 ");
		comboBox1= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
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
		label2=new JLabel("年");
		comboBox2= new JComboBox<Integer>();
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
		label3=new JLabel("月");
		comboBox3= new JComboBox<Integer>();
		for(int k=1;k<32;k++){
			comboBox3.addItem(k);
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
		label5=new JLabel(" 退  房  时  间 ");
		comboBox4= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
		    comboBox4.addItem(i);
			}
		comboBox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox4.getSelectedItem();
				int selected2=(int)comboBox5.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox6.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox6.addItem(k);
				}
				}
			}
		});
		label6=new JLabel("年");
		comboBox5= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox5.addItem(i);
			}
		comboBox5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox4.getSelectedItem();
				int selected2=(int)comboBox5.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox6.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox6.addItem(k);
				}
				}
			}
		});
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
		label9=new JLabel("订单最晚执行时间");
		comboBox7= new JComboBox<Integer>();
		for(int i=2016;i<2018;i++){
		    comboBox7.addItem(i);
			}
		comboBox7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox7.getSelectedItem();
				int selected2=(int)comboBox8.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox9.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox9.addItem(k);
				}
				}
			}
		});
		label10=new JLabel("年");
		comboBox8= new JComboBox<Integer>();
		for(int i=1;i<13;i++){
		    comboBox8.addItem(i);
			}
		comboBox8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox7.getSelectedItem();
				int selected2=(int)comboBox8.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox9.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox9.addItem(k);
				}
				}
			}
		});
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
		label13=new JLabel("房  间  类  型 ");
		JLabel label13_1=new JLabel(" ");
		comboBox10= new JComboBox<String>();
		comboBox10.setPreferredSize(new Dimension(170,22));
		panel4.add(label13);
		panel4.add(comboBox10);
		panel4.add(label13_1);
		this.add(panel4);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		label14=new JLabel("房  间  数  量 ");
		JLabel label14_1=new JLabel(" ");
		comboBox11= new JComboBox<Integer>();
		comboBox11.setPreferredSize(new Dimension(170,22));
		for(int i=1;i<101;i++){
		    comboBox11.addItem(i);
			}
		panel5.add(label14);
		panel5.add(comboBox11);
		panel5.add(label14_1);
		this.add(panel5);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		label15=new JLabel("预计入住人数 ");
		comboBox12= new JComboBox<Integer>();
		for(int i=1;i<101;i++){
		    comboBox12.addItem(i);
			}
		comboBox12.setPreferredSize(new Dimension(170,22));
		panel6.add(label15);
		panel6.add(comboBox12);
		this.add(panel6);
		JPanel panel7 = new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.CENTER));
		label16=new JLabel("有  无  儿  童 ");
		JLabel label16_1=new JLabel(" ");
		comboBox13= new JComboBox<String>();
		comboBox13.addItem("无");
		comboBox13.addItem("有");
		comboBox13.setPreferredSize(new Dimension(170,22));
		panel7.add(label16);
		panel7.add(comboBox13);
		panel7.add(label16_1);
		this.add(panel7);
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		label17=new JLabel("总计          元");
		panel8.add(label17);
		this.add(panel8);
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("提交订单");
		panel9.add(button2);
		this.add(panel9);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());
				Date date1=cal1.getTime();
				Date date2=cal2.getTime();
				if(date1.getTime()-date2.getTime()>0){
					JOptionPane.showMessageDialog(pane, "            时间冲突！","", JOptionPane.ERROR_MESSAGE);
				}
				else{
					int option = JOptionPane.showConfirmDialog(pane,"            确认提交？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
					     switch (option) {
					     case JOptionPane.YES_OPTION: 
					     controller.toHotelBrowseView();
					     case JOptionPane.NO_OPTION:
					     }
			}
			}
		});
	}
}