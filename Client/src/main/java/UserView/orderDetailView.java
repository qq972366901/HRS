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
import uiController.OrderViewController;
import uiService.HotelDetailUiService;
import uiService.OrderViewService;
import uiService.OrderDetailViewService;

import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.Box;
import javax.swing.BoxLayout;
/**
 * 订单详情界面的Panel
 * @author 刘宇翔
 *
 */
public class OrderDetailView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private OrderDetailViewService controller;
	
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
	
	private JPanel panel10;
	private String hotelid;
	private Box box1,box2,box3;
	/**
	 * Create the panel.
	 */
	public OrderDetailView(OrderDetailViewService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        
        panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel1);
        box1=Box.createVerticalBox();
        box2=Box.createVerticalBox();
        box3=Box.createHorizontalBox();
        box3.add(Box.createHorizontalStrut(25));
        panel1.add(box1);
        panel1.add(box3);
        panel1.add(box2);
        
        panel10=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel10);
        
        UserID=controller.getUserID();
        hotelid=controller.getHotelID();
        init_exit();
        init_detail();
	}
	/**
	 * 退出按钮的初始化
	 */
	public void init_exit(){
		
		back = new JButton("\u8FD4\u56DE");
		/**
		 * 返回按钮的监听
		 */
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		panel.add(back);
	}
	/**
	 * 跳转到订单管理界面
	 */
	public void exit() throws RemoteException{
		OrderViewService con =  new OrderViewController(UserID);
		OrderView vie = new OrderView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 跳转到订单详情
	 */
	public void exit2(){
		HotelDetailUiService con =  new HotelDetailUiController(hotelid,UserID);
		HotelDetailView vie = new HotelDetailView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 初始化主panel界面
	 */
	public void init_detail(){
		List<String> data=controller.getDetail();
		hotelName = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
        box1.add(hotelName);
        box2.add(new JLabel(data.get(0)));
        box1.add(Box.createVerticalStrut(30));
        box2.add(Box.createVerticalStrut(30));
		
		hotelType = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A");
		box1.add(hotelType);
		box2.add(new JLabel(data.get(1)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		orderID = new JLabel("订单号  ：");
		box1.add(orderID);
		box2.add(new JLabel(data.get(2)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		orderValue = new JLabel("\u8BA2\u5355\u4EF7\u683C\uFF1A");
		box1.add(orderValue);
		box2.add(new JLabel(data.get(3)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		numOfPeople = new JLabel("\u4F4F\u623F\u4EBA\u6570\uFF1A");
		box1.add(numOfPeople);
		box2.add(new JLabel(data.get(4)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		roomNumber = new JLabel("房间数量：");
		box1.add(roomNumber);
		box2.add(new JLabel(data.get(5)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		inTime = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		box1.add(inTime);
		box2.add(new JLabel(data.get(6)));
		 box1.add(Box.createVerticalStrut(30));
	        box2.add(Box.createVerticalStrut(30));
		
		lastTime = new JLabel("离开时间：");
		box1.add(lastTime);
		box2.add(new JLabel(data.get(7)));
		 box1.add(Box.createVerticalStrut(30));
	       box2.add(Box.createVerticalStrut(30));
		
		score = new JLabel("评分    ：");
		box1.add(score);
		box2.add(new JLabel(data.get(8)));
		box1.add(Box.createVerticalStrut(30));
		 box2.add(Box.createVerticalStrut(30));

		
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
