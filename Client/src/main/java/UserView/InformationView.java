package UserView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import runner.ClientRunner;
import uiController.customerMainViewControllerImpl;
import uiController.reviseInformationViewControllerImpl;
import uiController.revisePasswordViewControllerImpl;
import uiService.InformationViewControllerService;
import uiService.customerMainViewControllerService;
import uiService.reviseInformationViewControllerService;
import uiService.revisePasswordViewControllerService;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class InformationView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JButton back;
    private InformationViewControllerService controller;
    private JPanel panel_1 ;
	
	private JLabel name ;
	
	private JLabel birth ;
	
	private JLabel tel ;
	
	private JLabel enterprise;
	
	private JLabel type ;
	
	private JLabel level ;
	
	private JLabel credit;
	
	private JButton reviseinformation ;
	
	private JButton revisepassword;
	private String UserID;
	
	private JPanel panel_2;
	private JPanel panel_27;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	
	
	/**
	 * Create the panel.
	 */
	public InformationView(InformationViewControllerService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        UserID=controller.getUserID();
        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(panel);
        
        panel_1=new JPanel();
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_1);
        panel_22=new JPanel();
        panel_22.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_22);
        birth = new JLabel("\u751F\u65E5 \uFF1A1997/02/02");
        panel_22.add(birth);
        panel_23=new JPanel();
        panel_23.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_23);
        
        tel = new JLabel("\u8054\u7CFB\u65B9\u5F0F \uFF1A15214338969");
        panel_23.add(tel);
        panel_24=new JPanel();
        panel_24.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_24);
        enterprise = new JLabel("\u516C\u53F8 \uFF1A\u5357\u4EAC\u5927\u5B66     ");
        panel_24.add(enterprise);
        panel_25=new JPanel();
        panel_25.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_25);
        panel_26=new JPanel();
        panel_26.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_26);
        panel_27=new JPanel();
        panel_27.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_27);

        panel_2=new JPanel();
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel_2);
        
        init_exit();
        
        init_information();
	}
	public void init_information(){
        		
        		back = new JButton("\u8FD4\u56DE");
        		back.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        			controller.exit();
        			}
        		});
        		panel.add(back);
        Vector<String> Data=new Vector<String>();//Vector<String> Data=controller.getInformatioin(UserID);
        		name = new JLabel("姓名 :");
        		panel_1.add(name);
		type = new JLabel("\u4F1A\u5458\u79CD\u7C7B \uFF1A\u666E\u901A\u4F1A\u5458");
		panel_25.add(type);
		level = new JLabel("\u4F1A\u5458\u7B49\u7EA7 \uFF1A3");
		panel_26.add(level);
		
		credit = new JLabel("\u4FE1\u7528\u503C \uFF1A1000");
		panel_27.add(credit);
		
		reviseinformation = new JButton("\u4FEE\u6539\u57FA\u672C\u4FE1\u606F");
		reviseinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.reviseinformation();
			}
		});
panel_2.add(reviseinformation);
		
		revisepassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		revisepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.revisepassword();
			}
		});
panel_2.add(revisepassword);
	}
	public void init_exit(){
	}
	public void exit(){
		customerMainViewControllerService con =  new customerMainViewControllerImpl(UserID);
		customerMainView vie = new customerMainView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void reviseinformation(){
		reviseInformationViewControllerService con =  new reviseInformationViewControllerImpl(UserID);
		reviseInformationView vie = new reviseInformationView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
	public void revisepassword(){
		revisePasswordViewControllerService con =  new revisePasswordViewControllerImpl(UserID);
		revisePasswordView vie = new revisePasswordView(con);
		con.setView(vie);
		ClientRunner.change(vie);
	}
}
