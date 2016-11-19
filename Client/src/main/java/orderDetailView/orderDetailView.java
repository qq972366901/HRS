package orderDetailView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CommentView.CommentViewControllerService;
import LoginView.main;
import OrderManagementView.OrderView;
import OrderManagementView.OrderViewControllerImpl;
import OrderManagementView.OrderViewControllerService;
import java.awt.Color;
import javax.swing.UIManager;

public class orderDetailView extends JPanel {
    private JPanel panel;
    private JButton back;
    private orderDetailViewControllerService controller;
    private JPanel panel_1 ;
	
	private String UserID;
	
	private JPanel panel_2 ;
	
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
	
	private JLabel label ;
	
	private boolean judgeScore;
	private boolean judgeComment;
	private JTextArea commentinput;
	private JLabel lblNewLabel_2;
	/**
	 * Create the panel.
	 */
	public orderDetailView(orderDetailViewControllerService controller) {
		setLayout(null);
        this.controller=controller;
        UserID=controller.getUserID();
        init_exit();
        init_detail();
	}
	public void init_exit(){
		panel = new JPanel();
		panel.setBounds(793, 36, 174, 81);
		add(panel);
		panel.setLayout(null);
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		back.setFont(new Font("宋体", Font.PLAIN, 30));
		back.setBounds(10, 5, 150, 60);
		panel.add(back);
		
	}
	public void exit(){
		OrderViewControllerService con =  new OrderViewControllerImpl(UserID);
		OrderView vie = new OrderView(con);
		con.setView(vie);
		main.change(this,vie);
	}
	public void init_detail(){
		panel_2 = new JPanel();
		panel_2.setBounds(91, 85, 843, 588);
		add(panel_2);
		panel_2.setLayout(null);
		
		hotelName = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
		hotelName.setFont(new Font("宋体", Font.PLAIN, 25));
		hotelName.setBounds(45, 27, 320, 47);
		panel_2.add(hotelName);
		
		hotelType = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A");
		hotelType.setFont(new Font("宋体", Font.PLAIN, 25));
		hotelType.setBounds(45, 97, 320, 47);
		panel_2.add(hotelType);
		
		orderID = new JLabel("\u8BA2\u5355\u53F7\uFF1A");
		orderID.setFont(new Font("宋体", Font.PLAIN, 25));
		orderID.setBounds(45, 166, 320, 47);
		panel_2.add(orderID);
		
		orderValue = new JLabel("\u8BA2\u5355\u4EF7\u683C\uFF1A");
		orderValue.setFont(new Font("宋体", Font.PLAIN, 25));
		orderValue.setBounds(45, 233, 320, 47);
		panel_2.add(orderValue);
		
		numOfPeople = new JLabel("\u4F4F\u623F\u4EBA\u6570\uFF1A");
		numOfPeople.setFont(new Font("宋体", Font.PLAIN, 25));
		numOfPeople.setBounds(437, 27, 320, 47);
		panel_2.add(numOfPeople);
		
		roomNumber = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		roomNumber.setFont(new Font("宋体", Font.PLAIN, 25));
		roomNumber.setBounds(437, 97, 320, 47);
		panel_2.add(roomNumber);
		
		inTime = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		inTime.setFont(new Font("宋体", Font.PLAIN, 25));
		inTime.setBounds(437, 166, 320, 47);
		panel_2.add(inTime);
		
		lastTime = new JLabel("\u6700\u665A\u5165\u4F4F\u65F6\u95F4\uFF1A");
		lastTime.setFont(new Font("宋体", Font.PLAIN, 25));
		lastTime.setBounds(437, 233, 368, 47);
		panel_2.add(lastTime);
		
		score = new JLabel("\u8BC4\u5206\uFF1A");
		score.setFont(new Font("宋体", Font.PLAIN, 25));
		score.setBounds(265, 290, 75, 39);
		panel_2.add(score);
		
		comment = new JLabel("\u8BC4\u4EF7\uFF1A");
		comment.setFont(new Font("宋体", Font.PLAIN, 25));
		comment.setBounds(23, 335, 100, 39);
		panel_2.add(comment);
		
		label = new JLabel("");
		label.setBounds(767, 498, 54, 15);
		panel_2.add(label);
		
		commentinput = new JTextArea();
		commentinput.setBackground(UIManager.getColor("Button.background"));
		commentinput.setForeground(UIManager.getColor("Button.focus"));
		commentinput.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		
		commentinput.setFont(new Font("宋体", Font.PLAIN, 20));
		commentinput.setLineWrap(true);
		commentinput.setBounds(107, 335, 677, 184);
		panel_2.add(commentinput);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(341, 290, 118, 39);
		panel_2.add(lblNewLabel_2);
	}
}
