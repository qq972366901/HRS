package UserView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import runner.ClientRunner;
import uiController.InformationViewControllerImpl;
import uiService.InformationViewControllerService;
import uiService.revisePasswordViewControllerService;

import javax.swing.JPasswordField;
import javax.swing.BoxLayout;

public class revisePasswordView extends JPanel {
	private JPanel panel;
    private JButton back;
    private revisePasswordViewControllerService controller;
    private JPanel panel1 ;
    private JPanel panel11 ;
    private JPanel panel12 ;
    private JPanel panel13 ;
    private JPanel panel2 ;
    private JPanel panel3 ;
	
	private JLabel oldpassword ;
	
	private JLabel newpassword ;
	
	private JLabel againrevise ;
	
	private JButton revisepassword ;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	private boolean oldPassword;
	private boolean newPassword;
	private boolean same_oldnew;
	private boolean same;
	private String UserID;
	private JPanel k;
	/**
	 * Create the panel.
	 */
	public revisePasswordView(revisePasswordViewControllerService controller) {
        this.controller=controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        UserID=controller.getUserID();
        k=this;
        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(panel);
        panel1=new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel1);
        panel11=new JPanel();
        panel11.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel11);
        panel12=new JPanel();
        panel12.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel12);
        panel13=new JPanel();
        panel13.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        panel2=new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));                      
        add(panel2);
        init_exit();
        
        init_information();
	}
	public void init_information(){
		
		oldpassword = new JLabel("\u539F\u5BC6\u7801 \uFF1A");
		panel1.add(oldpassword);
		
		newpassword = new JLabel("\u65B0\u5BC6\u7801 \uFF1A");
		panel11.add(newpassword);
		
		againrevise = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801 \uFF1A");
		panel12.add(againrevise);
		
		passwordField = new JPasswordField(15);
		panel1.add(passwordField);
		
		passwordField_1 = new JPasswordField(15);
		panel11.add(passwordField_1);
		
		passwordField_2 = new JPasswordField(15);
		panel12.add(passwordField_2);
		JLabel l=new JLabel();
		l.setPreferredSize(new Dimension(50,1));
		panel12.add(l);
		
		
		revisepassword = new JButton("\u786E\u5B9A\u4FEE\u6539");
		revisepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vector<String> data=new Vector<String>();
				data.add(String.valueOf(passwordField.getPassword()));
				data.add(String.valueOf(passwordField_1.getPassword()));
				data.add(String.valueOf(passwordField_2.getPassword()));
				oldPassword=controller.checkoldPassword(String.valueOf(passwordField.getPassword()));
				newPassword=controller.checknewPassword(String.valueOf(passwordField_1.getPassword()));
				same=controller.checksame(String.valueOf(passwordField_1.getPassword()),String.valueOf(passwordField_2.getPassword()));
				same_oldnew=controller.checksame_old(String.valueOf(passwordField_1.getPassword()),String.valueOf(passwordField.getPassword()));
				if(!oldPassword){
					JOptionPane.showMessageDialog(k, "原密码输入有误！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!newPassword){
					JOptionPane.showMessageDialog(k, "新密码不合法！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(!same){
					JOptionPane.showMessageDialog(k, "两次重复输入的密码不同！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(same_oldnew){
					JOptionPane.showMessageDialog(null, "新旧密码一致！","", JOptionPane.ERROR_MESSAGE);
					return;
				}
				controller.revisepassword(data);
			}
		});
		panel2.add(revisepassword);
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
	public void exit(){
	    InformationViewControllerService con;
		try {
			con = new InformationViewControllerImpl(UserID);
			InformationView vie = new InformationView(con);
			con.setView(vie);
			ClientRunner.change(vie);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
