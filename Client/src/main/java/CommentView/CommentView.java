package CommentView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import InformationView.InformationViewControllerService;
import LoginView.main;
import OrderManagementView.OrderView;
import OrderManagementView.OrderViewControllerImpl;
import OrderManagementView.OrderViewControllerService;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CommentView extends JPanel {
    private JPanel panel;
    private JButton back;
    private CommentViewControllerService controller;
    private JPanel panel_1 ;
	
	private String UserID;
	private JTextField scoreinput;
	
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

	
	private JLabel lblNewLabel ;
	
	private JLabel comment;
	
	private JLabel label ;
	
	private JButton commentButton ;
	
	private JLabel lblNewLabel_1;
	
	private boolean judgeScore;
	private boolean judgeComment;
	private JTextArea commentinput;
	/**
	 * Create the panel.
	 */
	public CommentView(CommentViewControllerService controller) {
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
		panel_2.setBounds(87, 63, 843, 588);
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
		
		scoreinput = new JTextField();
		scoreinput.setFont(new Font("宋体", Font.PLAIN, 25));
		scoreinput.setBounds(350, 290, 96, 39);
		panel_2.add(scoreinput);
		scoreinput.setColumns(10);
		
		lblNewLabel = new JLabel("\u8BC4\u5206\u6570\u503C\u57280\u5230100\u4E4B\u95F4");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(485, 290, 197, 39);
		panel_2.add(lblNewLabel);
		
		comment = new JLabel("\u8BC4\u4EF7\uFF1A");
		comment.setFont(new Font("宋体", Font.PLAIN, 25));
		comment.setBounds(23, 335, 100, 39);
		panel_2.add(comment);
		
		label = new JLabel("");
		label.setBounds(767, 498, 54, 15);
		panel_2.add(label);
		
		commentinput = new JTextArea();
		commentButton = new JButton("\u63D0\u4EA4\u8BC4\u4EF7");
		commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeScore=controller.judgeScore(scoreinput.getText());
				judgeComment=controller.judgeComment(commentinput.getText());
				if(!judgeScore){
			    	   JOptionPane.showMessageDialog(null, "请检查评分是否填写或是否正确！","", JOptionPane.ERROR_MESSAGE);
			    	   return;
			       }
			       else if(!judgeComment){
			    	   JOptionPane.showMessageDialog(null, "请检查评价是否大于等于5个字！","", JOptionPane.ERROR_MESSAGE);
			    	   return;
			       }
			       else{
			    	   controller.comment(scoreinput.getText(),commentinput.getText());
			       }
			}
		});
		commentButton.setFont(new Font("宋体", Font.PLAIN, 25));
		commentButton.setBounds(341, 531, 159, 47);
		panel_2.add(commentButton);
		
		lblNewLabel_1 = new JLabel("\u8BC4\u4EF7\u57285\u4E2A\u5B57\u53CA\u4EE5\u4E0A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(539, 544, 216, 28);
		panel_2.add(lblNewLabel_1);
		
		
		commentinput.setFont(new Font("宋体", Font.PLAIN, 20));
		commentinput.setLineWrap(true);
		commentinput.setBounds(107, 335, 677, 184);
		panel_2.add(commentinput);
	}
}
