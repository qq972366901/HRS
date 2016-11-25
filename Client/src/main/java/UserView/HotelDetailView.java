package UserView;

import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.HistroyHotelViewControllerImpl;
import uiController.HotelDetailUiController;
import uiController.HotelorderlistViewControllerImpl;
import uiController.customerMainViewControllerImpl;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelDetailUiService;
import uiService.HotelorderlistViewControllerService;
import uiService.customerMainViewControllerService;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HotelDetailView extends JPanel{
	private HotelDetailUiService controller;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JButton back;
	private String UserID;
	private String HotelID;
	private static final long serialVersionUID = 1L;
	private JLabel hotelName;
	private JLabel hotelCity;
	private JLabel hotelCirc;
	private JLabel hotelScore;
	private JLabel hotelStar;
	private JLabel hotelTel;
	private JLabel hotelService;
	private JLabel hotelAddress;
	private JLabel hotelIntroduce;
	private JLabel hotelin;
	private JButton intoOrderList;
	public HotelDetailView(HotelDetailUiService controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel4=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel6=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel7=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel8=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel9=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel10=new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(panel);
		add(panel1);
		
		hotelName = new JLabel("酒店名称：");
		panel1.add(hotelName);
		add(panel2);
		
		hotelCity = new JLabel("酒店所在城市：");
		panel2.add(hotelCity);
		add(panel3);
		
		hotelCirc = new JLabel("酒店所在商圈：");
		panel3.add(hotelCirc);
		add(panel4);
		
		hotelScore = new JLabel("酒店评分：");
		panel4.add(hotelScore);
		add(panel5);
		
		hotelStar = new JLabel("酒店星级：");
		panel5.add(hotelStar);
		add(panel6);
		
		hotelTel = new JLabel("酒店联系方式：");
		panel6.add(hotelTel);
		add(panel7);
		
		hotelService = new JLabel("酒店服务：");
		panel7.add(hotelService);
		add(panel8);
		
		hotelAddress = new JLabel("酒店地址：");
		panel8.add(hotelAddress);
		add(panel9);
		
		hotelIntroduce = new JLabel("酒店介绍：");
		panel9.add(hotelIntroduce);
		
		hotelin = new JLabel("");
		hotelin.setPreferredSize(new Dimension(900, 100));
		panel9.add(hotelin);
		add(panel10);
		
		intoOrderList = new JButton("查看该酒店下的订单");
		intoOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.intoOrderList();
			}
		});
		panel10.add(intoOrderList);
		this.controller=controller;
		init_exit();
		init_information();
	}

	/**
	 * 
	 */
	public void init_exit(){
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
	}
	public void init_information(){
		
	}
	public void exit(){
		HistroyHotelViewControllerService con =  new HistroyHotelViewControllerImpl(UserID);
		HistroyHotelView vie = new HistroyHotelView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
    public void intoOrderList(){
    	HotelorderlistViewControllerService con =  new HotelorderlistViewControllerImpl(HotelID,UserID);
		HotelorderlistView vie = new HotelorderlistView(con);
		con.setView(vie);
		ClientRunner.change(vie);
    }
}
