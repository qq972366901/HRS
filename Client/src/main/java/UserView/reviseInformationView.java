package UserView;

import java.awt.Dimension;
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
import javax.swing.Box;
import javax.swing.BoxLayout;
/**
 * 修改个人信息界面的Panel
 * @author 刘宇翔
 *
 */
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
	
	private JLabel enterprise;
	
	private JButton updateinformation ;
	private JTextField nameinput;
	private JTextField enterpriseinput;
	private JLabel label5_1,label5_2,label5_3;
	private String UserID;
	private JPanel panel_1;
	private  JPanel panel_2;
	private  JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel21,panel22,panel24;
	private JPanel panel_to;
	private Box box,box1;
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
        
        panel_to = new JPanel();
        panel_to.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel_to);
        box=Box.createVerticalBox();
        box1=Box.createVerticalBox();
        panel_to.add(box);
        panel_to.add(box1);
        panel= new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel);
        UserID=controller.getUserID();
        panel_3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_5=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel21=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel22=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel24=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        box1.add(panel_2);
        box1.add(panel_3);
        box1.add(panel_5);
        box.add(panel21);
        box.add(panel22);
        box.add(panel24);
        box.setPreferredSize(new Dimension(300,500));
        box1.setPreferredSize(new Dimension(300,500));
        init_exit();
        
        init_information();
	}
	/**
	 * 初始化主Panel里的相关信息
	 */
	public void init_information(){
		
		name = new JLabel("姓名     ：");
		panel21.add(name);
		
		
		birth = new JLabel("生日     ：");
		panel22.add(birth);
		enterprise = new JLabel("公司      ：");
		panel24.add(enterprise);
		
		nameinput = new JTextField();
		nameinput.setColumns(10);
		panel_2.add(nameinput);	
		
		/**
		 * 生日Combobox的实现
		 */
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
		for(int i=1920;i<2017;i++)   {
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
		
		enterpriseinput = new JTextField();
		enterpriseinput.setColumns(10);
		panel_5.add(enterpriseinput);
		updateinformation = new JButton("\u786E\u5B9A\u4FEE\u6539");
		/**
		 * 更新个人信息按钮的监听
		 */
		updateinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> data=new Vector<String>();
				data.add(nameinput.getText());
				data.add(""+(int)y.getSelectedItem()+"/"+(int)m.getSelectedItem()+"/"+
				(int)d.getSelectedItem());
				data.add(enterpriseinput.getText());
				controller.updateinformation(data);
			}
		});
		updateinformation.setFont(UIManager.getFont("Button.font"));
		updateinformation.setBounds(192, 369, 180, 60);
		panel.add(updateinformation);
		
	}
	/**
	 * 返回按钮的初始化
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
		back.setFont(UIManager.getFont("Button.font"));
		back.setBounds(10, 5, 150, 60);
		panel_1.add(back);
		
	}
	/**
	 * 返回的界面的跳转
	 */
	public void exit(){
	    InformationViewControllerService con =  new InformationViewControllerImpl(UserID);
	    InformationView vie = new InformationView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	/**
	 * 判断指定年和月的天数
	 */
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
