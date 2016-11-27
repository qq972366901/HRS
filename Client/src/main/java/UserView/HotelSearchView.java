package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import uiService.HotelSearchUiService;

public class HotelSearchView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19;
	private JComboBox<String> comboBox,comboBox1,comboBox2,comboBox8,comboBox16;
	private JComboBox<Integer> comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox9,comboBox10,comboBox11,comboBox12,comboBox13,comboBox14,comboBox15;
	private JTable table;
	private JPanel pane;
	private DefaultTableModel model;
	private HotelSearchUiService controller;
    private int a=0;
    private int b=0;
    private int c=0;
    
	public HotelSearchView(HotelSearchUiService c){
		this.controller=c;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		initReturnButton();
		initCombobox();
		initButton();
		initTable();
		this.validate();
		pane=new JPanel();
		pane=this;
	}
	private void initReturnButton() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel.add(button1);
		this.add(panel);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toUserView("id");
			}
		});
		
	}
	private void initCombobox() {
		        JPanel panel1 = new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
				label18=new JLabel("  Search");
		        comboBox16= new JComboBox<String>();
		        comboBox16.setPreferredSize(new Dimension(171,22));
		        comboBox16.addItem("所有酒店");
		        comboBox16.addItem("预定过的酒店");
		        comboBox16.addItem("未预定过的酒店");
				label=new JLabel("     城市");
				comboBox= new JComboBox<String>();
				comboBox.addItem("");
				comboBox.setPreferredSize(new Dimension(171,22));
				label2=new JLabel("     商圈");
				comboBox2= new JComboBox<String>();
				comboBox2.addItem("");
				comboBox2.setPreferredSize(new Dimension(171,22));
				label3=new JLabel("     星级");
				comboBox3= new JComboBox<Integer>();
				comboBox3.setPreferredSize(new Dimension(171,22));
				for(int i=1;i<6;i++){
				   comboBox3.addItem(i);
					}
				panel1.add(label18);
				panel1.add(comboBox16);
				panel1.add(label);
				panel1.add(comboBox);
				panel1.add(label2);
				panel1.add(comboBox2);
				panel1.add(label3);
				panel1.add(comboBox3);;
				this.add(panel1);
				JPanel panel2 = new JPanel();
				panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
				label4=new JLabel("价格区间");
				comboBox4= new JComboBox<Integer>();
				comboBox4.setPreferredSize(new Dimension(77,22));
				for(int i=0;i<100;i++){
				    comboBox4.addItem(100*i);
					}
				comboBox4.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected=(int)comboBox4.getSelectedItem();
						comboBox5.removeAllItems();
						for(int k=selected/100;k<100;k++){
							comboBox5.addItem(100*k);
						}
						}
					}
				});
				label5=new JLabel("-");
				comboBox5= new JComboBox<Integer>();
				comboBox5.setPreferredSize(new Dimension(77,22));
				for(int i=0;i<100;i++){
				    comboBox5.addItem(100*i);
					}
				label6=new JLabel(" 评分区间");
				comboBox6= new JComboBox<Integer>();
				comboBox6.setPreferredSize(new Dimension(78,22));
				for(int i=1;i<6;i++){
				    comboBox6.addItem(i);
					}
				comboBox6.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected=(int)comboBox6.getSelectedItem();
						comboBox7.removeAllItems();
						for(int k=selected;k<6;k++){
							comboBox7.addItem(k);
						}
						}
					}
				});
				label7=new JLabel("-");
				comboBox7= new JComboBox<Integer>();
				comboBox7.setPreferredSize(new Dimension(78,22));
				for(int i=1;i<6;i++){
				    comboBox7.addItem(i);
					}
				label8=new JLabel(" 房间类型");
				comboBox8= new JComboBox<String>();
				comboBox8.setPreferredSize(new Dimension(171,22));
				label9=new JLabel(" 房间数量");
				comboBox9= new JComboBox<Integer>();
				comboBox9.setPreferredSize(new Dimension(171,22));
				for(int i=1;i<101;i++){
				    comboBox9.addItem(i);
					}
				panel2.add(label4);
				panel2.add(comboBox4);
				panel2.add(label5);
				panel2.add(comboBox5);
				panel2.add(label6);
				panel2.add(comboBox6);
				panel2.add(label7);
				panel2.add(comboBox7);
				panel2.add(label8);
				panel2.add(comboBox8);
				panel2.add(label9);
				panel2.add(comboBox9);
				this.add(panel2);
				Calendar cal=Calendar.getInstance();
				JPanel panel4 = new JPanel();
				panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
				label10=new JLabel("入住日期");
				comboBox10= new JComboBox<Integer>();
				comboBox10.setPreferredSize(new Dimension(116,22));
				for(int i=2016;i<2018;i++){
				    comboBox10.addItem(i);
					}
				comboBox10.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected1=(int)comboBox10.getSelectedItem();
						int selected2=(int)comboBox11.getSelectedItem();
						cal.set(Calendar.YEAR,selected1);
						cal.set(Calendar.MONTH,selected2-1);
						int maxDate=cal.getActualMaximum(Calendar.DATE);
						comboBox12.removeAllItems();
						for(int k=1;k<maxDate+1;k++){
							comboBox12.addItem(k);
						}
						}
					}
				});
				label11=new JLabel("年");
				comboBox11= new JComboBox<Integer>();
				comboBox11.setPreferredSize(new Dimension(116,22));
				for(int i=1;i<13;i++){
				    comboBox11.addItem(i);
					}
				comboBox11.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected1=(int)comboBox10.getSelectedItem();
						int selected2=(int)comboBox11.getSelectedItem();
						cal.set(Calendar.YEAR,selected1);
						cal.set(Calendar.MONTH,selected2-1);
						int maxDate=cal.getActualMaximum(Calendar.DATE);
						comboBox12.removeAllItems();
						for(int k=1;k<maxDate+1;k++){
							comboBox12.addItem(k);
						}
						}
					}
				});
				label12=new JLabel("月");
				comboBox12= new JComboBox<Integer>();
				comboBox12.setPreferredSize(new Dimension(116,22));
				for(int i=1;i<32;i++){
				    comboBox12.addItem(i);
					}
				label13=new JLabel("日");
				label14=new JLabel(" 退房日期");
				comboBox13= new JComboBox<Integer>();
				comboBox13.setPreferredSize(new Dimension(116,22));
				for(int i=2016;i<2018;i++){
				    comboBox13.addItem(i);
					}
				comboBox13.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected1=(int)comboBox13.getSelectedItem();
						int selected2=(int)comboBox14.getSelectedItem();
						cal.set(Calendar.YEAR,selected1);
						cal.set(Calendar.MONTH,selected2-1);
						int maxDate=cal.getActualMaximum(Calendar.DATE);
						comboBox15.removeAllItems();
						for(int k=1;k<maxDate+1;k++){
							comboBox15.addItem(k);
						}
						}
					}
				});
				label15=new JLabel("年");
				comboBox14= new JComboBox<Integer>();
				comboBox14.setPreferredSize(new Dimension(116,22));
				for(int i=1;i<13;i++){
				    comboBox14.addItem(i);
					}
				comboBox14.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected1=(int)comboBox13.getSelectedItem();
						int selected2=(int)comboBox14.getSelectedItem();
						cal.set(Calendar.YEAR,selected1);
						cal.set(Calendar.MONTH,selected2-1);
						int maxDate=cal.getActualMaximum(Calendar.DATE);
						comboBox15.removeAllItems();
						for(int k=1;k<maxDate+1;k++){
							comboBox15.addItem(k);
						}
						}
					}
				});
				label16=new JLabel("月");
				comboBox15= new JComboBox<Integer>();
				comboBox15.setPreferredSize(new Dimension(116,22));
				for(int i=1;i<32;i++){
				    comboBox15.addItem(i);
					}
				label17=new JLabel("日");
				panel4.add(label10);
				panel4.add(comboBox10);
				panel4.add(label11);
				panel4.add(comboBox11);
				panel4.add(label12);
				panel4.add(comboBox12);
				panel4.add(label13);
				panel4.add(label14);
				panel4.add(comboBox13);
				panel4.add(label15);
				panel4.add(comboBox14);
				panel4.add(label16);
				panel4.add(comboBox15);
				panel4.add(label17);
				this.add(panel4);
	}
	private void initButton(){
		JPanel panel7=  new JPanel();
		panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
		label19=new JLabel("                                                                            ");
		button4=new JButton("搜索");
		button4.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox10.getSelectedItem(),(int)comboBox11.getSelectedItem(),(int) comboBox12.getSelectedItem());
				cal2.set((int)comboBox13.getSelectedItem(),(int)comboBox14.getSelectedItem(),(int) comboBox15.getSelectedItem());
				Date date1=cal1.getTime();
				Date date2=cal2.getTime();
				if(comboBox.getSelectedItem()==""||comboBox2.getSelectedItem()==""){
					JOptionPane.showMessageDialog(pane, "    必须选择城市和商圈！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(date1.getTime()-date2.getTime()>0){
					JOptionPane.showMessageDialog(pane, "            时间冲突！","", JOptionPane.ERROR_MESSAGE);
				}
				else{
					
				}
			}
		});
		panel7.add(label19);
		panel7.add(button4);
		this.add(panel7);
		JPanel panel6 = new JPanel();
		panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button2=new JButton("浏览酒店信息");
		button3=new JButton("下订单");
		panel6.add(button2);
		panel6.add(button3);
		this.add(panel6);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toHotelBrowseView("id");
			}
		});
		button3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toOrderBuildView("id");
			}
		});
		
	}
	private void initTable() {
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		label1=new JLabel("                    ");
		button5=new JButton("星级排序");
		button6=new JButton("评分排序");
		button7=new JButton("价格排序");
		
		button5.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(a%2==0){
					
				}
				else{
					
				}
				a++;			
			}
		});
		button6.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
                if(b%2==0){
					
				}
				else{
					
				}
				b++;
			}
		});
		button7.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
                if(c%2==0){
					
				}
				else{
					
				}
				c++;
			}
		});
		button5.setPreferredSize(new Dimension(120,22));
		button6.setPreferredSize(new Dimension(120,22));
		button7.setPreferredSize(new Dimension(120,22));
		panel8.add(label1);
		panel8.add(button5);
		panel8.add(button6);
		panel8.add(button7);
		this.add(panel8);
        JScrollPane scrollPane = new JScrollPane();
        
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("酒店名称");
		vColumns.add("酒店地址");
		vColumns.add("营销策略");
		vColumns.add("酒店星级");
		vColumns.add("酒店评分");
		vColumns.add("酒店价格");
		vColumns.add("是否预定过");
		vColumns.add("订单状态");
		model= new DefaultTableModel(null, vColumns);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}
}
