package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.OrderViewControllerImpl;
import uiService.CommentViewService;
import uiService.OrderViewControllerService;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;

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
	private JPanel panel10_1;
	/**
	 * Create the panel.
	 */
	public CommentView(CommentViewService controller) {
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
        
        panel10_1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panel10_1);
        UserID=controller.getUserID();
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
	public void init_detail(){
		List<String> list=controller.getDetail();
		hotelName = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A"+list.get(0));
        panel1.add(hotelName);
		
		hotelType = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A"+list.get(1));
		panel2.add(hotelType);
		
		orderID = new JLabel("\u8BA2\u5355\u53F7\uFF1A"+list.get(2));
		panel3.add(orderID);
		orderValue = new JLabel("\u8BA2\u5355\u4EF7\u683C\uFF1A"+list.get(3));
		panel4.add(orderValue);
		
		numOfPeople = new JLabel("\u4F4F\u623F\u4EBA\u6570\uFF1A"+list.get(4));
		panel5.add(numOfPeople);
		
		roomNumber = new JLabel("\u623F\u95F4\u53F7\uFF1A"+list.get(5));
		panel6.add(roomNumber);
		
		inTime = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A"+list.get(6));
		panel7.add(inTime);
		
		lastTime = new JLabel("\u6700\u665A\u5165\u4F4F\u65F6\u95F4\uFF1A"+list.get(7));
		panel8.add(lastTime);
		
		JLabel temp=new JLabel();
		temp.setPreferredSize(new Dimension(150,20));
		panel9.add(temp);
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

		
		lblNewLabel_1 = new JLabel("\u8BC4\u4EF7\u57285\u4E2A\u5B57\u53CA\u4EE5\u4E0A");
		panel10_1.add(commentButton);
		panel10_1.add(lblNewLabel_1);

		commentinput.setLineWrap(true);
		panel10.add(commentinput);
	}
}
