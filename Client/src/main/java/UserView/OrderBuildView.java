package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import VO.HotelVO;
import VO.OrderVO;
import uiService.OrderBuildUiService;
/**
 * 订单生成界面的Panel
 * @author lw
 *
 */
public class OrderBuildView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label13,label14,label15,label16,label17,label1_1,label5_1;
	private JButton button1,button2;
	private JComboBox<Integer> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox11,comboBox12;
	private JComboBox<String> comboBox10,comboBox13;
	private JPanel pane,panel1,panel3;
	private OrderBuildUiService controller;
	private int year,month,day;

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
				try {
					controller.toHotelBrowseView(controller.getUserID(),controller.getHotelID(),controller.getfrom());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Calendar ca = Calendar.getInstance();
		year = ca.get(Calendar.YEAR);//获取年份
		month=ca.get(Calendar.MONTH)+1;//获取月份
		day=ca.get(Calendar.DATE);//获取日
		Calendar nextca= Calendar.getInstance();
		nextca.add(Calendar.DAY_OF_MONTH, 1);
		int nextyear = nextca.get(Calendar.YEAR);//获取年份
		int nextmonth=nextca.get(Calendar.MONTH)+1;//获取月份
		int nextday=nextca.get(Calendar.DATE);//获取日
		int nextmax=nextca.getActualMaximum(Calendar.DATE);
		
		Calendar cal=Calendar.getInstance();
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));	
		label1=new JLabel("                          开  始  时  间 ");
		label1_1=new JLabel("（默认为当天中午12点整）");
		comboBox1= new JComboBox<Integer>();
		if((month==12&&day==30)||(month==12&&day==31)){
		    comboBox1.addItem(year);
		    comboBox1.addItem(year+1);
		}
		else{
			comboBox1.addItem(year);
		}

		
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected=(int)comboBox1.getSelectedItem();
				comboBox2.removeAllItems();
				if(selected==year){
				if(((day==30||day==31)&&month!=12)||(day==29&&(month==2||month==4||month==6||month==9||month==11))||(month==2&&(day==28||day==27))){
					comboBox2.addItem(month);
					comboBox2.addItem(month+1);
				}
				if((day==30||day==31)&&month==12){
					comboBox2.addItem(month);
					comboBox2.addItem(1);
				}
				else{
					comboBox2.addItem(month);
				}
				}
				else if(selected==year+1){
					comboBox2.addItem(1);
				}
				label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
				Calendar cal4=Calendar.getInstance();
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
			    long milliseconds1 = cal1.getTimeInMillis();  
			    long milliseconds2 = cal2.getTimeInMillis();  
			    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
				
				int selected1=(int)comboBox11.getSelectedItem();
				 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected1);
				 HotelVO vo=controller.findByHotelID(controller.getHotelID());
				 double webdiscount =1;
				try {
					webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double hoteldiscount =1;
				try {
					hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected1,cal4,cal1,cal2);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double discount=1;
				 if(webdiscount>=hoteldiscount){
					 discount=hoteldiscount;
				 }
				 else{
					 discount=webdiscount;
				 }
				 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
				 int price2=(int) (price1*discount);
				 if(price2<=0){
					 label17.setText("你的开始时间与退房时间冲突!");
				 }
				 else if(price1!=price2){
					 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
					}
					 else{
						 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
						}			
				}
			}
		});
		label2=new JLabel("年");
		comboBox2= new JComboBox<Integer>();
		int	selected=(int)comboBox1.getSelectedItem();
		if(selected==year){
		if(((day==30||day==31)&&month!=12)||(day==29&&(month==2||month==4||month==6||month==9||month==11))||(month==2&&(day==28||day==27))){
			comboBox2.addItem(month);
			comboBox2.addItem(month+1);
		}
		if((day==30||day==31)&&month==12){
			comboBox2.addItem(month);
			comboBox2.addItem(1);
		}
		else{
			comboBox2.addItem(month);
		}
		}
		else if(selected==year+1){
			comboBox2.addItem(1);
		}
		
	//确定日
		
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
					comboBox3.removeAllItems();
					int	selected1=(int)comboBox1.getSelectedItem();
					int selected2=(int)comboBox2.getSelectedItem();
					if(year==selected1&&month==selected2){
						if(day==31){
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(30);
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(30);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(29);
							comboBox3.addItem(30);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(29);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(28);
						}
						else{
							comboBox3.addItem(day);
							comboBox3.addItem(day+1);
							comboBox3.addItem(day+2);
						}
					}
					else if(year==selected1&&month!=selected2){
						if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(1);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					else if(year!=selected1){
						if(day==30){
							comboBox3.addItem(1);
						}
						else if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
					Calendar cal4=Calendar.getInstance();
					Calendar cal1=Calendar.getInstance();
					Calendar cal2=Calendar.getInstance();
					cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
					cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
				    long milliseconds1 = cal1.getTimeInMillis();  
				    long milliseconds2 = cal2.getTimeInMillis();  
				    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
					
					int selected11=(int)comboBox11.getSelectedItem();
					 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected11);
					 HotelVO vo=controller.findByHotelID(controller.getHotelID());
					 double webdiscount =1;
					try {
						webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double hoteldiscount =1;
					try {
						hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected11,cal4,cal1,cal2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double discount=1;
					 if(webdiscount>=hoteldiscount){
						 discount=hoteldiscount;
					 }
					 else{
						 discount=webdiscount;
					 }
					 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
					 int price2=(int) (price1*discount);
					 if(price2<=0){
						 label17.setText("你的开始时间与退房时间冲突!");
					 }
					 else if(price1!=price2){
						 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
						}
						 else{
							 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
							}			
					}
				}
		});
		label3=new JLabel("月");
		comboBox3= new JComboBox<Integer>();
	
		
		int	selected1=(int)comboBox1.getSelectedItem();
		int selected2=(int)comboBox2.getSelectedItem();
		if(year==selected1&&month==selected2){
			if(day==31){
				comboBox3.addItem(31);
			}
			else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
				comboBox3.addItem(30);
				comboBox3.addItem(31);
			}
			else if(day==30&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(30);
			}
			else if(day==29&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(29);
				comboBox3.addItem(30);
			}
			else if(day==29&&month==2){
				comboBox3.addItem(29);
			}
			else if(day==28&&month==2){
				comboBox3.addItem(28);
			}
			else{
				comboBox3.addItem(day);
				comboBox3.addItem(day+1);
				comboBox3.addItem(day+2);
			}
		}
		else if(year==selected1&&month!=selected2){
			if(day==31){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
				comboBox3.addItem(1);
			}
			else if(day==30&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==29&&(month==4||month==6||month==9||month==11)){
				comboBox3.addItem(1);
			}
			else if(day==29&&month==2){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
			else if(day==28&&month==2){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
		}
		else if(year!=selected1){
			if(day==30){
				comboBox3.addItem(1);
			}
			else if(day==31){
				comboBox3.addItem(1);
				comboBox3.addItem(2);
			}
		}

		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
		label9.setText("订单最晚执行时间:"+comboBox1.getSelectedItem()+"年"+comboBox2.getSelectedItem()+"月"+comboBox3.getSelectedItem()+"日当晚凌晨12点整");
		Calendar cal4=Calendar.getInstance();
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
		cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
	    long milliseconds1 = cal1.getTimeInMillis();  
	    long milliseconds2 = cal2.getTimeInMillis();  
	    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
		
		int selected1=(int)comboBox11.getSelectedItem();
		 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected1);
		 HotelVO vo=controller.findByHotelID(controller.getHotelID());
		 double webdiscount =1;
		try {
			webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double hoteldiscount =1;
		try {
			hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected1,cal4,cal1,cal2);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double discount=1;
		 if(webdiscount>=hoteldiscount){
			 discount=hoteldiscount;
		 }
		 else{
			 discount=webdiscount;
		 }
		 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
		 int price2=(int) (price1*discount);
		 if(price2<=0){
			 label17.setText("你的开始时间与退房时间冲突!");
		 }
		 else if(price1!=price2){
			 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
			}
			 else{
				 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
				}			
				}
			}
		});
		label4=new JLabel("日");
		panel1.add(label1);
		panel1.add(comboBox1);
		panel1.add(label2);
		panel1.add(comboBox2);
		panel1.add(label3);
		panel1.add(comboBox3);
		panel1.add(label4);
		panel1.add(label1_1);
		this.add(panel1);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		label5=new JLabel("                          退  房  时  间 ");
		label5_1=new JLabel("（默认为当天中午12点整）");
		comboBox4= new JComboBox<Integer>();
		for(int i=nextyear;i<2100;i++){
		    comboBox4.addItem(i);
			}
		comboBox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){		
				int	selected1=(int)comboBox4.getSelectedItem();
				if(selected1==nextyear){
					comboBox5.removeAllItems();
					for(int i=nextmonth;i<13;i++){
						comboBox5.addItem(i);
					}
					comboBox6.removeAllItems();
					for(int j=nextday;j<nextmax+1;j++){
						comboBox6.addItem(j);
					}
				}
				  else{
					if(selected1!=nextyear){
						comboBox5.removeAllItems();
						for(int i=1;i<13;i++){
							comboBox5.addItem(i);
						}
					}
				int selected2=(int)comboBox5.getSelectedItem();
				cal.set(Calendar.YEAR,selected1);
				cal.set(Calendar.MONTH,selected2-1);
				int maxDate=cal.getActualMaximum(Calendar.DATE);
				comboBox6.removeAllItems();
				for(int k=1;k<maxDate+1;k++){
					comboBox6.addItem(k);
				}
				}
				Calendar cal4=Calendar.getInstance();
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
			    long milliseconds1 = cal1.getTimeInMillis();  
			    long milliseconds2 = cal2.getTimeInMillis();  
			    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
				
				int selected11=(int)comboBox11.getSelectedItem();
				 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected11);
				 HotelVO vo=controller.findByHotelID(controller.getHotelID());
				 double webdiscount =1;
				try {
					webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double hoteldiscount =1;
				try {
					hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected11,cal4,cal1,cal2);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double discount=1;
				 if(webdiscount>=hoteldiscount){
					 discount=hoteldiscount;
				 }
				 else{
					 discount=webdiscount;
				 }
				 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
				 int price2=(int) (price1*discount);
				 if(price2<=0){
					 label17.setText("你的开始时间与退房时间冲突!");
				 }
				 else if(price1!=price2){
					 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
					}
					 else{
						 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
						}			
				}
			}
		});
		label6=new JLabel("年");
		comboBox5= new JComboBox<Integer>();
		for(int i=nextmonth;i<13;i++){
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
				Calendar cal4=Calendar.getInstance();
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
			    long milliseconds1 = cal1.getTimeInMillis();  
			    long milliseconds2 = cal2.getTimeInMillis();  
			    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
				
				int selected11=(int)comboBox11.getSelectedItem();
				 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected11);
				 HotelVO vo=controller.findByHotelID(controller.getHotelID());
				 double webdiscount =1;
				try {
					webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double hoteldiscount =1;
				try {
					hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected11,cal4,cal1,cal2);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double discount=1;
				 if(webdiscount>=hoteldiscount){
					 discount=hoteldiscount;
				 }
				 else{
					 discount=webdiscount;
				 }
				 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
				 int price2=(int) (price1*discount);
				 if(price2<=0){
					 label17.setText("你的开始时间与退房时间冲突!");
				 }
				 else if(price1!=price2){
					 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
					}
					 else{
						 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
						}			
				}
			}
		});
		label7=new JLabel("月");
		comboBox6= new JComboBox<Integer>();		
		for(int i=nextday;i<nextmax+1;i++){
		    comboBox6.addItem(i);
			}
		comboBox6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
		Calendar cal4=Calendar.getInstance();
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
		cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
	    long milliseconds1 = cal1.getTimeInMillis();  
	    long milliseconds2 = cal2.getTimeInMillis();  
	    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
		
		int selected1=(int)comboBox11.getSelectedItem();
		 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected1);
		 HotelVO vo=controller.findByHotelID(controller.getHotelID());
		 double webdiscount =1;
		try {
			webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double hoteldiscount =1;
		try {
			hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected1,cal4,cal1,cal2);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double discount=1;
		 if(webdiscount>=hoteldiscount){
			 discount=hoteldiscount;
		 }
		 else{
			 discount=webdiscount;
		 }
		 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
		 int price2=(int) (price1*discount);
		 if(price2<=0){
			 label17.setText("你的开始时间与退房时间冲突!");
		 }
		 else if(price1!=price2){
			 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
			}
			 else{
				 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
				}			
				}
			}
		});
		label8=new JLabel("日");
		panel2.add(label5);
		panel2.add(comboBox4);
		panel2.add(label6);
		panel2.add(comboBox5);
		panel2.add(label7);
		panel2.add(comboBox6);
		panel2.add(label8);
		panel2.add(label5_1);
		this.add(panel2);
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		label9=new JLabel("订单最晚执行时间:"+year+"年"+month+"月"+day+"日当晚凌晨12点整");
		panel3.add(label9);
		this.add(panel3);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		label13=new JLabel("房  间  类  型 ");
		JLabel label13_1=new JLabel(" ");
		comboBox10= new JComboBox<String>();
		comboBox10.setPreferredSize(new Dimension(170,22));
		List<String> typelist=new Vector<String>(controller.getRoomType(controller.getHotelID()));
		for(String type : typelist){
			comboBox10.addItem(type);
		}
		comboBox10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
				String selected=(String)comboBox10.getSelectedItem();
				comboBox11.removeAllItems();
				int max=controller.getMaxRoomNumber(controller.getHotelID(),selected);
				for(int i=1;i<max+1;i++){
					comboBox11.addItem(i);
				}
				Calendar cal4=Calendar.getInstance();
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
			    long milliseconds1 = cal1.getTimeInMillis();  
			    long milliseconds2 = cal2.getTimeInMillis();  
			    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
				
				int selected1=(int)comboBox11.getSelectedItem();
				 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected1);
				 HotelVO vo=controller.findByHotelID(controller.getHotelID());
				 double webdiscount =1;
				try {
					webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double hoteldiscount =1;
				try {
					hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected1,cal4,cal1,cal2);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 double discount=1;
				 if(webdiscount>=hoteldiscount){
					 discount=hoteldiscount;
				 }
				 else{
					 discount=webdiscount;
				 }
				 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
				 int price2=(int) (price1*discount);
				 if(price2<=0){
					 label17.setText("你的开始时间与退房时间冲突!");
				 }
				 else if(price1!=price2){
					 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
					}
					 else{
						 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
						}			
				}				
			}
		});
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
		for(int i=1;i<controller.getMaxRoomNumber(controller.getHotelID(),(String)comboBox10.getSelectedItem())+1;i++){
		    comboBox11.addItem(i);
			}
		comboBox11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){	
					Calendar cal4=Calendar.getInstance();
					Calendar cal1=Calendar.getInstance();
					Calendar cal2=Calendar.getInstance();
					cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
					cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
				    long milliseconds1 = cal1.getTimeInMillis();  
				    long milliseconds2 = cal2.getTimeInMillis();  
				    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
					
					int selected1=(int)comboBox11.getSelectedItem();
					 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected1);
					 HotelVO vo=controller.findByHotelID(controller.getHotelID());
					 double webdiscount =1;
					try {
						webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double hoteldiscount =1;
					try {
						hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected1,cal4,cal1,cal2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double discount=1;
					 if(webdiscount>=hoteldiscount){
						 discount=hoteldiscount;
					 }
					 else{
						 discount=webdiscount;
					 }
					 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
					 int price2=(int) (price1*discount);
					 if(price2<=0){
						 label17.setText("你的开始时间与退房时间冲突!");
					 }
					 else if(price1!=price2){
						 label17.setText("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
						}
						 else{
							 label17.setText("没有适合的促销策略，订单总计"+price1+"元");
							}			
				}
			}
		});
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
		Calendar cal4=Calendar.getInstance();
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
		cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());		    
	    long milliseconds1 = cal1.getTimeInMillis();  
	    long milliseconds2 = cal2.getTimeInMillis();  
	    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
		
		int selected3=(int)comboBox11.getSelectedItem();
		 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected3);
		 HotelVO vo=controller.findByHotelID(controller.getHotelID());
		 double webdiscount =1;
		try {
			webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal4);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double hoteldiscount =1;
		try {
			hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected3,cal4,cal1,cal2);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 double discount=1;
		 if(webdiscount>=hoteldiscount){
			 discount=hoteldiscount;
		 }
		 else{
			 discount=webdiscount;
		 }
		 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
		 int price2=(int) (price1*discount);
		 if(price1!=price2){
			 label17=new JLabel("已为你选择了最优的促销策略，打折前总计"+price1+"元，打折后总计"+price2+"元");
			}
			 else{
			 label17=new JLabel("没有适合的促销策略，订单总计"+price1+"元");
				}			
		panel8.add(label17);
		this.add(panel8);
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		button2=new JButton("提交订单");
		panel9.add(button2);
		this.add(panel9);
		button2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
				int nowyear=cal.get(Calendar.YEAR);
				int nowmonth=cal.get(Calendar.MONTH);
				int nowday=cal.get(Calendar.DATE);
				
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox1.getSelectedItem(),(int)comboBox2.getSelectedItem(),(int) comboBox3.getSelectedItem());
				cal2.set((int)comboBox4.getSelectedItem(),(int)comboBox5.getSelectedItem(),(int) comboBox6.getSelectedItem());
			    
			    long milliseconds1 = cal1.getTimeInMillis();  
			    long milliseconds2 = cal2.getTimeInMillis();  
			    long between_days=(milliseconds2-milliseconds1)/(1000*3600*24);        
				
				Date date1=cal1.getTime();
				Date date2=cal2.getTime();
				
			    if(nowday!=day){
			    	int option = JOptionPane.showConfirmDialog(pane,"开始时间过期，刷新界面？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
				     switch (option) {
				     case JOptionPane.YES_OPTION: 
				     comboBox1.removeAllItems();
				     comboBox2.removeAllItems();
				     comboBox3.removeAllItems();
				     year=nowyear;
				     month=nowmonth;
				     day=nowday;
					if((month==12&&day==30)||(month==12&&day==31)){
					    comboBox1.addItem(year);
					    comboBox1.addItem(year+1);
					}
					else{
						comboBox1.addItem(year);
					}
					int	selected=(int)comboBox1.getSelectedItem();
					if(selected==year){
					if(((day==30||day==31)&&month!=12)||(day==29&&(month==2||month==4||month==6||month==9||month==11))||(month==2&&(day==28||day==27))){
						comboBox2.addItem(month);
						comboBox2.addItem(month+1);
					}
					if((day==30||day==31)&&month==12){
						comboBox2.addItem(month);
						comboBox2.addItem(1);
					}
					else{
						comboBox2.addItem(month);
					}
					}
					else if(selected==year+1){
						comboBox2.addItem(1);
					}			
					int	selected1=(int)comboBox1.getSelectedItem();
					int selected2=(int)comboBox2.getSelectedItem();
					if(year==selected1&&month==selected2){
						if(day==31){
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(30);
							comboBox3.addItem(31);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(30);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(29);
							comboBox3.addItem(30);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(29);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(28);
						}
						else{
							comboBox3.addItem(day);
							comboBox3.addItem(day+1);
							comboBox3.addItem(day+2);
						}
					}
					else if(year==selected1&&month!=selected2){
						if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==30&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
							comboBox3.addItem(1);
						}
						else if(day==30&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==29&&(month==4||month==6||month==9||month==11)){
							comboBox3.addItem(1);
						}
						else if(day==29&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
						else if(day==28&&month==2){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
					else if(year!=selected1){
						if(day==30){
							comboBox3.addItem(1);
						}
						else if(day==31){
							comboBox3.addItem(1);
							comboBox3.addItem(2);
						}
					}
				     break;
				     case JOptionPane.NO_OPTION:
				    	 break;
				     }
			    }			    
				else if(date1.getTime()-date2.getTime()>=0){
					JOptionPane.showMessageDialog(pane, "开始时间与退房时间冲突！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(controller.showCredit(controller.getUserID())<0){
					JOptionPane.showMessageDialog(pane, "信用值不足，无法生成订单！","", JOptionPane.ERROR_MESSAGE);
				}
				else if(!controller.whetherMake((int)comboBox11.getSelectedItem(),(String)comboBox10.getSelectedItem(),controller.getHotelID())){
					JOptionPane.showMessageDialog(pane, "没有足够的满足条件的房间！","", JOptionPane.ERROR_MESSAGE);
				}
				else{
					 int selected=(int)comboBox11.getSelectedItem();
					 int price1=controller.getOrderPrice(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected);
					 HotelVO vo=controller.findByHotelID(controller.getHotelID());
					 double webdiscount =1;
					try {
						webdiscount = controller.getWebPromotionDiscount(controller.getUserID(),vo.hotelCity,vo.hotelDistrict,cal);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double hoteldiscount =1;
					try {
						hoteldiscount = controller.getHotelPromotionDiscount(controller.getHotelID(),controller.getUserID(),selected,cal,cal1,cal2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 double discount=1;
					 if(webdiscount>=hoteldiscount){
						 discount=hoteldiscount;
					 }
					 else{
						 discount=webdiscount;
					 }
					 price1=price1*(Integer.parseInt(String.valueOf(between_days)));
					 int price2=(int) (price1*discount);
					int option = JOptionPane.showConfirmDialog(pane,"      你的订单总计"+price2+"元"+"\n             确认提交？","", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null);
					     switch (option) {
					     case JOptionPane.YES_OPTION:
					   String orderid=UUID.randomUUID().toString().substring(0, 8);
					   boolean children=false;
					   if(((String)comboBox13.getSelectedItem()).equals("有")){
						   children=true;
					   }
					   Calendar calin=Calendar.getInstance();
					   calin.set(Calendar.YEAR,(int)comboBox1.getSelectedItem());
					   calin.set(Calendar.MONTH,(int)comboBox2.getSelectedItem()-1);
					   calin.set(Calendar.DAY_OF_MONTH,(int)comboBox3.getSelectedItem()); 
					   calin.set(Calendar.HOUR_OF_DAY,12);
					   calin.set(Calendar.MINUTE,0);
					   calin.set(Calendar.SECOND,0);
					   Calendar calout=Calendar.getInstance();
					   calout.set(Calendar.YEAR,(int)comboBox4.getSelectedItem());
					   calout.set(Calendar.MONTH,(int)comboBox5.getSelectedItem()-1);
					   calout.set(Calendar.DAY_OF_MONTH,(int)comboBox6.getSelectedItem());
					   calout.set(Calendar.HOUR_OF_DAY,12);
					   calout.set(Calendar.MINUTE,0);
					   calout.set(Calendar.SECOND,0);
					   Calendar callast=Calendar.getInstance();
					   callast.set(Calendar.YEAR,(int)comboBox1.getSelectedItem());
					   callast.set(Calendar.MONTH,(int)comboBox2.getSelectedItem()-1);
					   callast.set(Calendar.DAY_OF_MONTH,(int)comboBox3.getSelectedItem()); 
					   callast.set(Calendar.HOUR_OF_DAY,24);
					   callast.set(Calendar.MINUTE,0);
					   callast.set(Calendar.SECOND,0);
					   controller.updateRoomState(controller.getHotelID(),(String)comboBox10.getSelectedItem(),selected);
					   OrderVO ordervo=new OrderVO(controller.getHotelID(),controller.getUserID(),orderid,2,price2,(int)comboBox12.getSelectedItem(),children,(String)comboBox10.getSelectedItem(),selected,calin,calout,callast,null,cal,null,0);
					   controller.saveOrderInfo(ordervo);
			
					   label17.setText("你的订单总计"+price2+"元，订单号为"+orderid);
					   comboBox1.setEnabled(false);
					   comboBox2.setEnabled(false);
					   comboBox3.setEnabled(false);
					   comboBox4.setEnabled(false);
					   comboBox5.setEnabled(false);
					   comboBox6.setEnabled(false);
					   comboBox10.setEnabled(false);
					   comboBox11.setEnabled(false);
					   comboBox12.setEnabled(false);
					   comboBox13.setEnabled(false);
					   button2.setVisible(false);
					   break;
					     case JOptionPane.NO_OPTION:
					    	 break;
					     }
			}
			}
		});
	}
}