package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.InformationViewControllerImpl;
import uiService.InformationViewControllerService;
import uiService.reviseInformationViewControllerService;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.BoxLayout;

public class reviseInformationView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private reviseInformationViewControllerService controller;
	
	private JLabel name ;
	
	private JLabel birth ;
	
	private JLabel tel ;
	
	private JLabel enterprise;
	
	private JLabel email;
	
	private JButton updateinformation ;
	private JTextField nameinput;
	private JTextField telinput;
	private JTextField enterpriseinput;
	private JTextField emailinput;
	private JLabel label5_1,label5_2,label5_3;
	private String UserID;
	private JPanel panel_1;
	private  JPanel panel_2;
	private  JPanel panel_3;
	private  JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	JComboBox<Integer> y;
	JComboBox<Integer> m;
	JComboBox<Integer> d;
	int temp=2000;
    int temp1=1;
    boolean flag=true;
    int[] big={1,3,5,7,8,10,12};
	/**
	 * Create the panel.
	 */
	public reviseInformationView(reviseInformationViewControllerService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panel_1 = new JPanel();
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(panel_1);
        
        panel_2= new JPanel();
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_2);
        
        panel_3 = new JPanel();
        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_3);
        
        panel_4 = new JPanel();
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_4);
       
        
        panel_5 = new JPanel();
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_5);
        
        panel_6 = new JPanel();
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_6);
        
        
        panel= new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel);
        UserID=controller.getUserID();
        init_exit();
        
        init_information();
	}
	public void init_information(){
		
		name = new JLabel("姓名 ：");
		panel_2.add(name);
		
		birth = new JLabel("\u751F\u65E5 \uFF1A");
		panel_3.add(birth);
		
		tel = new JLabel("\u8054\u7CFB\u65B9\u5F0F \uFF1A");
		panel_4.add(tel );
		enterprise = new JLabel("\u516C\u53F8 \uFF1A");
		panel_5.add(enterprise);
		email = new JLabel("\u90AE\u7BB1 \uFF1A");
		panel_6.add(email );
		
		nameinput = new JTextField();
		nameinput.setColumns(10);
		panel_2.add(nameinput);	
		
		new JLabel("生日");
		label5_1 = new JLabel("年");
		label5_2 = new JLabel("月");
		label5_3 = new JLabel("日");
		  y=new JComboBox<Integer>();
		 m=new JComboBox<Integer>();
		 d=new JComboBox<Integer>();
		  
		 y.addItemListener(new ItemListener(){
       
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED == e.getStateChange()){
					temp=(Integer)e.getItem();
				}
				
			}
			 
		 });
		
		m.addItemListener(new ItemListener(){
	         
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(ItemEvent.SELECTED == e.getStateChange()){
					temp1=(Integer)e.getItem();
					int day=judge(temp,temp1);
		            d.removeAllItems();
		           for(int i=1;i<day+1;i++){
					  d.addItem(i);
		           }
				}
				  	
			}
		 });
		for(int i=2000;i<2017;i++)   {
			  y.addItem(i);
		  }
		  for(int i=1;i<13;i++){
			  m.addItem(i);
		  }
		panel_3.add(y);
		panel_3.add(label5_1);
		panel_3.add(m);
		panel_3.add(label5_2);
		panel_3.add(d);
		panel_3.add(label5_3);
		
		telinput = new JTextField();
		telinput.setColumns(10);
		panel_4.add(telinput);	
		
		enterpriseinput = new JTextField();
		enterpriseinput.setColumns(10);
		panel_5.add(enterpriseinput);	
		
		emailinput = new JTextField();
		emailinput.setColumns(18);
		panel_6.add(emailinput);	
		
		updateinformation = new JButton("\u786E\u5B9A\u4FEE\u6539");
		updateinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> data=new Vector<String>();
				data.add(nameinput.getText());
				data.add(""+(int)y.getSelectedItem()+"/"+(int)m.getSelectedItem()+"/"+
				(int)d.getSelectedItem());
				data.add(telinput.getText());
				
				data.add(enterpriseinput.getText());
				data.add(emailinput.getText());
				controller.updateinformation(data);
			}
		});
		updateinformation.setFont(UIManager.getFont("Button.font"));
		updateinformation.setBounds(192, 369, 180, 60);
		panel.add(updateinformation);
		
	}
	public void init_exit(){
		
		back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.exit();
			}
		});
		back.setFont(UIManager.getFont("Button.font"));
		back.setBounds(10, 5, 150, 60);
		panel_1.add(back);
		
	}
	public void exit(){
	    InformationViewControllerService con =  new InformationViewControllerImpl(UserID);
	    InformationView vie = new InformationView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	private int judge(int year,int month){
		for(int i:big){
			if(month==i){
				return 31;
			}
		}
		if(month==2){
			if(rnn(year)){
				return 29;
			}
			else{
				return 28;
			}
		}
		else{
			return 30;
		}
	}
	private boolean rnn(int year){
		if(year%4==0&&year%100!=0||year%400==0){
			return true;
		}
		return false;
	}
}
