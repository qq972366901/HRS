package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;
import uiService.HotelSearchUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class HotelSearchView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton button1,button2,button3,button4,button5,button6,button7;
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19;
	private JComboBox<String> comboBox,comboBox1,comboBox2,comboBox8,comboBox16;
	private JComboBox<Integer> comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox9,comboBox10,comboBox11,comboBox12,comboBox13,comboBox14,comboBox15;
	private JTable table;
	private JPanel pane;
	List<String> hlist;
	List<String> hlist2=new ArrayList<String>();
	private DefaultTableModel model;
	Vector<String> vColumns;
	private HotelSearchUiService controller;
	private JScrollPane scrollPane ;
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
	static HotelBLService hotel = new HotelBLServiceController();
	static RoomBLService room = new RoomBLServiceController();
	/**
     * 酒店列表按照星级从高到低排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照星级从高到低排序后的酒店列表
     */
	private static List<String> starSortHigh(List<String> hotelIDList) {
		List<HotelVO> temp = new ArrayList<HotelVO>();
		for(int i=0;i<hotelIDList.size();i++) {
			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
			temp.add(vo);
		}
		for(int i=0;i<temp.size();i++) {
			for(int j=i;j<temp.size();j++) {
				if(temp.get(j).hotelStar > temp.get(i).hotelStar) {
					HotelVO hvo = temp.get(i);
					temp.set(i, temp.get(j));
					temp.set(j, hvo);
				}
			}
		}
		List<String> outcome = new ArrayList<String>();
		for(int i=0;i<temp.size();i++) {
			outcome.add(temp.get(i).hotelAccount);
		}
		return outcome;
	}
	/**
     * 酒店列表按照星级从低到高排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照星级从低到高排序后的酒店列表
     */
	private static List<String> starSortLow(List<String> hotelIDList) {
		List<HotelVO> temp = new ArrayList<HotelVO>();
		for(int i=0;i<hotelIDList.size();i++) {
			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
			temp.add(vo);
		}
		for(int i=0;i<temp.size();i++) {
			for(int j=i;j<temp.size();j++) {
				if(temp.get(j).hotelStar < temp.get(i).hotelStar) {
					HotelVO hvo = temp.get(i);
					temp.set(i, temp.get(j));
					temp.set(j, hvo);
				}
			}
		}
		List<String> outcome = new ArrayList<String>();
		for(int i=0;i<temp.size();i++) {
			outcome.add(temp.get(i).hotelAccount);
		}
		return outcome;
	}
	/**
     * 酒店列表按照评分从高到低排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照评分从高到低排序后的酒店列表
     */
	private static List<String> scoreSortHigh(List<String> hotelIDList) {
		List<HotelVO> temp = new ArrayList<HotelVO>();
		for(int i=0;i<hotelIDList.size();i++) {
			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
			temp.add(vo);
		}
		for(int i=0;i<temp.size();i++) {
			for(int j=i;j<temp.size();j++) {
				if(temp.get(j).score > temp.get(i).score) {
					HotelVO hvo = temp.get(i);
					temp.set(i, temp.get(j));
					temp.set(j, hvo);
				}
			}
		}
		List<String> outcome = new ArrayList<String>();
		for(int i=0;i<temp.size();i++) {
			outcome.add(temp.get(i).hotelAccount);
		}
		return outcome;
	}
	/**
     * 酒店列表按照评分从低到高排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照评分从低到高排序后的酒店列表
     */
	private static List<String> scoreSortLow(List<String> hotelIDList) {
		List<HotelVO> temp = new ArrayList<HotelVO>();
		for(int i=0;i<hotelIDList.size();i++) {
			HotelVO vo = hotel.findByHotelID(hotelIDList.get(i));
			temp.add(vo);
		}
		for(int i=0;i<temp.size();i++) {
			for(int j=i;j<temp.size();j++) {
				if(temp.get(j).score < temp.get(i).score) {
					HotelVO hvo = temp.get(i);
					temp.set(i, temp.get(j));
					temp.set(j, hvo);
				}
			}
		}
		List<String> outcome = new ArrayList<String>();
		for(int i=0;i<temp.size();i++) {
			outcome.add(temp.get(i).hotelAccount);
		}
		return outcome;
	}
	/**
     * 酒店列表按照房间最低价格从高到低排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照房间最低价格从高到低排序后的酒店列表
     */
	private static List<String> priceSortHigh(List<String> hotelIDList) {
		for(int i=0;i<hotelIDList.size();i++) {
			for(int j=i;j<hotelIDList.size();j++) {
				if(room.getRoomLowestPrice(hotelIDList.get(i)) < room.getRoomLowestPrice(hotelIDList.get(j))) {
					String s = hotelIDList.get(i);
					hotelIDList.set(i, hotelIDList.get(j));
					hotelIDList.set(j, s);
				}
			}
		}
		return hotelIDList;
	}
	/**
     * 酒店列表按照房间最低价格从低到高排序
     * 
     * @param hotelIDList List<String>型，酒店帐号列表
     * @return 返回按照房间最低价格从低到高排序后的酒店列表
     */
	private static List<String> priceSortLow(List<String> hotelIDList) {
		for(int i=0;i<hotelIDList.size();i++) {
			for(int j=i;j<hotelIDList.size();j++) {
				if(room.getRoomLowestPrice(hotelIDList.get(i)) > room.getRoomLowestPrice(hotelIDList.get(j))) {
					String s = hotelIDList.get(i);
					hotelIDList.set(i, hotelIDList.get(j));
					hotelIDList.set(j, s);
				}
			}
		}
		return hotelIDList;
	}
	private void initReturnButton() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		button1=new JButton("返回");
		panel.add(button1);
		this.add(panel);
		button1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				controller.toUserView(controller.getUserID());
			}
		});
		
	}
	private void initCombobox() {
		        JPanel panel1 = new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
				label18=new JLabel("预定状态");
		        comboBox16= new JComboBox<String>();
		        comboBox16.setPreferredSize(new Dimension(171,22));
		        comboBox16.addItem("全部");
		        comboBox16.addItem("预定过");
		        comboBox16.addItem("未预定过");
				label=new JLabel("     城市");
				comboBox= new JComboBox<String>();
				List<String> list1=new ArrayList<String>(controller.getCity());
				for(String city : list1){
				comboBox.addItem(city);
				}
				comboBox.setPreferredSize(new Dimension(171,22));
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
							String	selected=(String)comboBox.getSelectedItem();
							comboBox2.removeAllItems();
							Vector<String> list2=new Vector<String>(controller.getCircle(selected));
							for(String circle : list2){
								comboBox2.addItem(circle);
							}
						}
					}
				});
				label2=new JLabel("     商圈");
				comboBox2= new JComboBox<String>();
				Vector<String> list3=new Vector<String>(controller.getCircle((String)comboBox.getItemAt(0)));
				for(String circle : list3){
					comboBox2.addItem(circle);
				}
				comboBox2.setPreferredSize(new Dimension(171,22));
				label3=new JLabel("     星级");
				comboBox3= new JComboBox<Integer>();
				comboBox3.setPreferredSize(new Dimension(171,22));
				comboBox3.addItem(null);
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
				    comboBox5.addItem(9900-100*i);
					}
				label6=new JLabel(" 评分区间");
				comboBox6= new JComboBox<Integer>();
				comboBox6.setPreferredSize(new Dimension(78,22));
				for(int i=0;i<6;i++){
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
				    comboBox7.addItem(6-i);
					}
				label8=new JLabel(" 房间类型");
				comboBox8= new JComboBox<String>();
				comboBox8.setPreferredSize(new Dimension(171,22));
				comboBox8.addItem(null);
				comboBox8.addItem("大床房");
				comboBox8.addItem("标准双人间");
				comboBox8.addItem("三人间");
				comboBox8.addItem("豪华套房");
				comboBox8.addItem("总统套房");
				label9=new JLabel(" 房间数量");
				comboBox9= new JComboBox<Integer>();
				comboBox9.setPreferredSize(new Dimension(171,22));
				comboBox9.addItem(null);
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
				Calendar ca = Calendar.getInstance();
				Calendar nextca=Calendar.getInstance();
				nextca.add(Calendar.DAY_OF_MONTH, 1);
				int year = ca.get(Calendar.YEAR);//获取年份
				int month=ca.get(Calendar.MONTH)+1;//获取月份
				int day=ca.get(Calendar.DATE);//获取日
				int nextyear = nextca.get(Calendar.YEAR);//获取年份
				int nextmonth=nextca.get(Calendar.MONTH)+1;//获取月份
				int nextday=nextca.get(Calendar.DATE);//获取日
				int max=ca.getActualMaximum(Calendar.DATE);
				int nextmax=nextca.getActualMaximum(Calendar.DATE);
				label10=new JLabel("入住日期");
				comboBox10= new JComboBox<Integer>();
				comboBox10.setPreferredSize(new Dimension(116,22));
				for(int i=year;i<year+2;i++){
				    comboBox10.addItem(i);
					}
				comboBox10.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){
						int	selected1=(int)comboBox10.getSelectedItem();
						  if(selected1==year){
							comboBox11.removeAllItems();
							for(int i=month;i<13;i++){
								comboBox11.addItem(i);
							}
							comboBox12.removeAllItems();
							for(int j=day;j<max+1;j++){
								comboBox12.addItem(j);
							}
						}
						  else{
							if(selected1!=year){
								comboBox11.removeAllItems();
								for(int i=1;i<13;i++){
									comboBox11.addItem(i);
								}
							}
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
					}
				});
				label11=new JLabel("年");
				comboBox11= new JComboBox<Integer>();
				comboBox11.setPreferredSize(new Dimension(116,22));
				for(int i=month;i<13;i++){
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
				for(int i=day;i<max+1;i++){
				    comboBox12.addItem(i);
					}
				label13=new JLabel("日");
				label14=new JLabel(" 退房日期");
				comboBox13= new JComboBox<Integer>();
				comboBox13.setPreferredSize(new Dimension(116,22));
				for(int i=nextyear;i<2100;i++){
				    comboBox13.addItem(i);
					}
				comboBox13.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						if(evt.getStateChange() == ItemEvent.SELECTED){		
						int	selected1=(int)comboBox13.getSelectedItem();
						if(selected1==nextyear){
							comboBox14.removeAllItems();
							for(int i=nextmonth;i<13;i++){
								comboBox14.addItem(i);
							}
							comboBox15.removeAllItems();
							for(int j=nextday;j<nextmax+1;j++){
								comboBox15.addItem(j);
							}
						}
						  else{
							if(selected1!=nextyear){
								comboBox14.removeAllItems();
								for(int i=1;i<13;i++){
									comboBox14.addItem(i);
								}
							}
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
					}
				});
				label15=new JLabel("年");
				comboBox14= new JComboBox<Integer>();
				comboBox14.setPreferredSize(new Dimension(116,22));
				for(int i=nextmonth;i<13;i++){
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
				for(int i=nextday;i<nextmax+1;i++){
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
				Calendar cal1=Calendar.getInstance();
				Calendar cal2=Calendar.getInstance();
				cal1.set((int)comboBox10.getSelectedItem(),(int)comboBox11.getSelectedItem()-1,(int) comboBox12.getSelectedItem());
				cal2.set((int)comboBox13.getSelectedItem(),(int)comboBox14.getSelectedItem()-1,(int) comboBox15.getSelectedItem());
				Date date1=cal1.getTime();
				Date date2=cal2.getTime();				
				 if(date1.getTime()-date2.getTime()>0){
					JOptionPane.showMessageDialog(pane, "            时间冲突！","", JOptionPane.ERROR_MESSAGE);
				}
				else{

					int star;
					if(comboBox3.getSelectedItem()==null){
						star=-1;
					}
					else{
						star=(int)comboBox3.getSelectedItem();
					}
					String roomtype;
					if(comboBox8.getSelectedItem()==null){
						roomtype=null;
					}
					else{
						roomtype=comboBox8.getSelectedItem().toString().trim();
					}
					int roomNum;
					if(comboBox9.getSelectedItem()==null){
						roomNum=-1;
					}
					else{
						roomNum=(int)comboBox9.getSelectedItem();
					}
					//最后一个参数是界面输入的酒店名字，暂时取“”
					hlist=controller.getHotelID((String)comboBox.getSelectedItem(),(String)comboBox2.getSelectedItem(),roomtype,roomNum,(int)comboBox4.getSelectedItem(), (int)comboBox5.getSelectedItem(),star,(int)comboBox6.getSelectedItem(),(int)comboBox7.getSelectedItem(),(String)comboBox16.getSelectedItem(),controller.getUserID(),"");
					if(hlist==null || hlist.size() ==0 ){
						JOptionPane.showMessageDialog(pane, "  未找到满足条件的酒店！","", JOptionPane.ERROR_MESSAGE);
					}
					else{
						hlist2.clear();
						for (int i = 0; i < hlist.size(); i++) {
				            hlist2.add(hlist.get(i));
				        }
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					Calendar cal=Calendar.getInstance();
					for(String hotelid : hlist){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
					hlist.clear();
				}
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
				int index = table.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(pane, "          请选择酒店！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
				String hid=(String)table.getValueAt(index,0);
				String key1="";
				try {
					Log log=new Log();
					key1=log.getKey(hid);
				} catch (RemoteException e1) {
					System.out.println("获取密钥失败");
					e1.printStackTrace();
				}
				String hid1=DES.encryptDES(hid,key1);
				try {
					controller.toHotelBrowseView(controller.getUserID(),hid1);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		button3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(pane, "          请选择酒店！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
					String hid=(String)table.getValueAt(index,0);
					String key1="";
					try {
						Log log=new Log();
						key1=log.getKey(hid);
					} catch (RemoteException e1) {
						System.out.println("获取密钥失败");
						e1.printStackTrace();
					}
					String hid1=DES.encryptDES(hid,key1);
					try {
						controller.toOrderBuildView(controller.getUserID(),hid1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
	private void initTable() {
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.CENTER));
		label1=new JLabel("                                   ");
		button5=new JButton("星级排序");
		button6=new JButton("评分排序");
		button7=new JButton("价格排序");
		
		button5.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
				if(a%2==0){
					List<String> list1=HotelSearchView.starSortHigh(hlist2);
					
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					for(String hotelid : list1){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
				}
				else{
					List<String> list1=HotelSearchView.starSortLow(hlist2);
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					for(String hotelid : list1){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						System.out.println(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName);
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
				}
				a++;			
			}
		});
		button6.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
				if(b%2==0){
				List<String> list2=HotelSearchView.scoreSortHigh(hlist2);
				Vector<Vector<Object>> data=new Vector<Vector<Object>>();
				for(String hotelid : list2){
					Vector<Object> inf=new Vector<Object>();
					String key="";
					try {
						Log log=new Log();
						key=log.getSKey(hotelid);
					} catch (RemoteException e1) {
						System.out.println("获取密钥失败");
						e1.printStackTrace();
					}
					String str=DES.decryptDES(hotelid, key);
					inf.add(str);
					inf.add(controller.findByHotelID(hotelid).hotelName);
					inf.add(controller.findByHotelID(hotelid).hotelAddress);
					String promotioninf="暂无";
					if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
						promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
					}
					inf.add(promotioninf);
					inf.add(controller.findByHotelID(hotelid).hotelStar);
					BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
					inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
					inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
					String ever="否";
					if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
						ever="是";
					}
					inf.add(ever);
					if(ever=="是"){
					Set<Integer> state=new HashSet<Integer>();
					for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
						state.add(ordervo.orderState);
					}
					String str1="";
					String str2="";
					String str3="";
					for(int i : state){
						if(i==1||i==2){
							str1="正常";
						}
					    if(i==3){
							str2="异常";
						}
						else if(i==4){
							str3="撤销";
						}
					}
					inf.add(str1+"."+str2+"."+str3);
					}
					else{
					inf.add("");
					}
					data.add(inf);
				}
				model= new DefaultTableModel(data, vColumns);
				table = new JTable(model){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column){
						return false;
					}
				};
				table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.getViewport().add(table);
				table.setFillsViewportHeight(true);
				}
				else{
					List<String> list2=HotelSearchView.scoreSortLow(hlist2);
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					for(String hotelid : list2){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
				}
				b++;
			}
		});
		button7.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
                if(c%2==0){
					List<String> list3=HotelSearchView.priceSortHigh(hlist2);
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					for(String hotelid : list3){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
				}
				else{
					List<String> list3=HotelSearchView.priceSortLow(hlist2);
					Vector<Vector<Object>> data=new Vector<Vector<Object>>();
					for(String hotelid : list3){
						Vector<Object> inf=new Vector<Object>();
						String key="";
						try {
							Log log=new Log();
							key=log.getSKey(hotelid);
						} catch (RemoteException e1) {
							System.out.println("获取密钥失败");
							e1.printStackTrace();
						}
						String str=DES.decryptDES(hotelid, key);
						inf.add(str);
						inf.add(controller.findByHotelID(hotelid).hotelName);
						inf.add(controller.findByHotelID(hotelid).hotelAddress);
						String promotioninf="暂无";
						if(controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName!=null){
							promotioninf=controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).promotionName+" "+controller.getHotelPromotionByHotelIDAndTime(hotelid,cal).discount+"折起";
						}
						inf.add(promotioninf);
						inf.add(controller.findByHotelID(hotelid).hotelStar);
						BigDecimal bg= new BigDecimal(controller.findByHotelID(hotelid).score);
						inf.add(bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
						inf.add(controller.getRoomLowestPrice(hotelid)+"元起");
						String ever="否";
						if(controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)!=null&&controller. findByHotelIDAndUserID (controller.getUserID(),hotelid).size()>0){
							ever="是";
						}
						inf.add(ever);
						if(ever=="是"){
						Set<Integer> state=new HashSet<Integer>();
						for(OrderVO ordervo : controller. findByHotelIDAndUserID (controller.getUserID(),hotelid)){
							state.add(ordervo.orderState);
						}
						String str1="";
						String str2="";
						String str3="";
						for(int i : state){
							if(i==1||i==2){
								str1="正常";
							}
						    if(i==3){
								str2="异常";
							}
							else if(i==4){
								str3="撤销";
							}
						}
						inf.add(str1+"."+str2+"."+str3);
						}
						else{
						inf.add("");
						}
						data.add(inf);
					}
					model= new DefaultTableModel(data, vColumns);
					table = new JTable(model){
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
					};
					table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.getViewport().add(table);
					table.setFillsViewportHeight(true);
				}
				c++;
			}
		});
		button5.setPreferredSize(new Dimension(105,22));
		button6.setPreferredSize(new Dimension(105,22));
		button7.setPreferredSize(new Dimension(105,22));
		panel8.add(label1);
		panel8.add(button5);
		panel8.add(button6);
		panel8.add(button7);
		this.add(panel8);
        scrollPane = new JScrollPane();
        
		vColumns = new Vector<String>();
		vColumns.add("酒店账号");
		vColumns.add("酒店名称");
		vColumns.add("酒店地址");
		vColumns.add("营销策略");
		vColumns.add("酒店星级");
		vColumns.add("酒店评分");
		vColumns.add("酒店价格");
		vColumns.add("是否预定过");
		vColumns.add("订单状态");
		//数据
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
