package UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import runner.ClientRunner;
import uiController.HotelDetailUiController;
import uiController.OrderViewControllerImpl;
import uiService.HotelDetailUiService;
import uiService.OrderViewControllerService;
import uiService.orderDetailViewControllerService;

import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.BoxLayout;

public class orderDetailView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private orderDetailViewControllerService controller;
	
	private String UserID;
	
	
	private JLabel hotelName ;
	
	private JLabel hotelType;
	
	private JLabel orderID ;
	
	private JLabel orderValue ;
	
	private JLabel numOfPeople ;
	
	private JLabel roomNumber ;
	
	private JLabel inTime;
	
	private JLabel lastTime ;
	
	private JLabel score ;
	
	private JLabel comment;
	
	private JTextArea commentinput;
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
	private String hotelid;
	/**
	 * Create the panel.
	 */
	public orderDetailView(orderDetailViewControllerService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        
        panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel1);
        
        panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel2);
        
        panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel3);
        
        panel4=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel4);
        
        panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel5);
        
        panel6=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel6);
        
        panel7=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel7);
        
        panel8=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel8);
        
        panel9=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel9);
        
        panel10=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel10);
        
        UserID=controller.getUserID();
        hotelid=controller.getHotelID();
        init_exit();
        init_detail();
	}
	public void init_exit(){
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
	}
	public void exit() throws RemoteException{
		OrderViewControllerService con =  new OrderViewControllerImpl(UserID);
		OrderView vie = new OrderView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void exit2(){
		HotelDetailUiService con =  new HotelDetailUiController(hotelid,UserID);
		HotelDetailView vie = new HotelDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void init_detail(){
		List<String> data=controller.getDetail();
		hotelName = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A"+data.get(0));
        panel1.add(hotelName);
		
		hotelType = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A"+data.get(1));
		panel2.add(hotelType);
		
		orderID = new JLabel("\u8BA2\u5355\u53F7\uFF1A"+data.get(2));
		panel3.add(orderID);
		orderValue = new JLabel("\u8BA2\u5355\u4EF7\u683C\uFF1A"+data.get(3));
		panel4.add(orderValue);
		
		numOfPeople = new JLabel("\u4F4F\u623F\u4EBA\u6570\uFF1A"+data.get(4));
		panel5.add(numOfPeople);
		
		roomNumber = new JLabel("房间数量："+data.get(5));
		panel6.add(roomNumber);
		
		inTime = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A"+data.get(6));
		panel7.add(inTime);
		
		lastTime = new JLabel("离开时间："+data.get(7));
		panel8.add(lastTime);
		
		score = new JLabel("\u8BC4\u5206\uFF1A"+data.get(8));
		panel9.add(score);
		
		comment = new JLabel("\u8BC4\u4EF7\uFF1A");
		panel10.add(comment);
		

		commentinput = new JTextArea(2,55);
		commentinput.setBackground(UIManager.getColor("Button.background"));
		commentinput.setForeground(UIManager.getColor("Button.focus"));
		commentinput.setText(data.get(9));
		commentinput.setLineWrap(true);
		panel10.add(commentinput);
	}
}
