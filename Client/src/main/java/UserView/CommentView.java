package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.OrderViewController;
import uiService.CommentViewService;
import uiService.OrderViewService;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.BoxLayout;
/**
 * 评论界面的Panel
 * @author 刘宇翔
 *
 */
public class CommentView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private CommentViewService controller;
    private String UserID;
	private JTextField scoreinput;
	
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
	
	private JButton commentButton ;
	
	private JLabel lblNewLabel_1;
	
	private boolean judgeScore;
	private boolean judgeComment;
	private JTextArea commentinput;
	private Box box1,box2,box3;
private JPanel panel1;
	
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel10_1;
	private JPanel k;
	/**
	 * Create the panel.
	 */
	public CommentView(CommentViewService controller) {
        this.controller=controller;
        k=this;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        box1=Box.createVerticalBox();
        box2=Box.createVerticalBox();
        box3=Box.createHorizontalBox();
        box3.add(Box.createHorizontalStrut(25));
        panel1.add(box1);
        panel1.add(box3);
        panel1.add(box2);
        add(panel1);
        
        panel9=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel9);
        
        panel10=new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel10);
        
        panel10_1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel10_1);
        UserID=controller.getUserID();
        init_exit();
        init_detail();
	}
	/**
	 * 初始化退出
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
	 * 退出界面的跳转
	 * @throws RemoteException
	 */
	public void exit() throws RemoteException{
		OrderViewService con =  new OrderViewController(UserID);
		OrderView vie = new OrderView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 初始化panel中的详细信息
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
		
		score = new JLabel("\u8BC4\u5206\uFF1A");
		panel9.add(score);
		
		scoreinput = new JTextField();
		scoreinput.setColumns(10);
		panel9.add(scoreinput);
		lblNewLabel = new JLabel("评分数值在1到5之间");
		panel9.add(lblNewLabel);
		
		comment = new JLabel("\u8BC4\u4EF7\uFF1A");
        panel10.add(comment);
		
		new JLabel("");

		
		commentinput = new JTextArea(10,130);
		commentButton = new JButton("\u63D0\u4EA4\u8BC4\u4EF7");
		
		/**
		 * 评论按钮的监听
		 */
		commentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				judgeScore=controller.judgeScore(scoreinput.getText());
				judgeComment=controller.judgeComment(commentinput.getText());
				if(!judgeScore){
			    	   JOptionPane.showMessageDialog(k, "请检查评分是否填写或是否正确！","", JOptionPane.ERROR_MESSAGE);
			    	   return;
			       }
			       else if(!judgeComment){
			    	   JOptionPane.showMessageDialog(k, "请检查评价是否大于等于5个字！","", JOptionPane.ERROR_MESSAGE);
			    	   return;
			       }
			       else{
			    	   controller.comment(scoreinput.getText(),commentinput.getText());
			    	   controller.changeHotelScore(controller.getHotelID(),Integer.parseInt(scoreinput.getText()));
			       }
			}
		});

		
		lblNewLabel_1 = new JLabel("\u8BC4\u4EF7\u57285\u4E2A\u5B57\u53CA\u4EE5\u4E0A");
		panel10_1.add(commentButton);
		panel10_1.add(lblNewLabel_1);

		commentinput.setLineWrap(true);
		panel10.add(commentinput);
	}
}
