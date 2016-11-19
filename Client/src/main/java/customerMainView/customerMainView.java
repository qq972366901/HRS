package customerMainView;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CreditView.CreditView;
import CreditView.CreditViewControllerImpl;
import CreditView.CreditViewControllerService;
import HistroyHotelView.HistroyHotelView;
import HistroyHotelView.HistroyHotelViewControllerImpl;
import HistroyHotelView.HistroyHotelViewControllerService;
import InformationView.InformationView;
import InformationView.InformationViewControllerImpl;
import InformationView.InformationViewControllerService;
import LoginView.LoginView;
import LoginView.LoginViewControllerImpl;
import LoginView.LoginViewControllerService;
import LoginView.main;
import OrderManagementView.OrderView;
import OrderManagementView.OrderViewControllerImpl;
import OrderManagementView.OrderViewControllerService;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerMainView extends JPanel {
	private customerMainViewControllerService controller;
	private JButton information;
	private JButton exit;
	private JButton ordermanagement;
	private JButton searchhotel;
	private JButton creditmanagement;
	private JButton histroyhotel;
	private JPanel panel;
	private JPanel panel_1;
	private String UserID;
	/**
	 * Create the panel.
	 */
	public customerMainView(customerMainViewControllerService controller) {
         this.controller=controller;
         setLayout(null);         
         panel = new JPanel();
         panel.setBounds(49, 130, 920, 450);
         add(panel);
         panel.setLayout(null);
         
         init_informationbutton();
         
         init_orderbutton();
         
         init_creditbutton();
         
         init_searchbutton();
         
         init_histroybutton();
         
         UserID=controller.getUserID();
         
         panel_1 = new JPanel();
         panel_1.setBounds(768, 43, 189, 103);
         add(panel_1);
         panel_1.setLayout(null);
         
         init_exitbutton();
	}
    public void init_informationbutton(){
    	information = new JButton("\u4FE1\u606F\u67E5\u770B");
    	information.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			controller.information();
    		}
    	});
        information.setFont(new Font("宋体", Font.PLAIN, 30));
        information.setBounds(10, 189, 160, 75);
        panel.add(information);
    }
    public void init_orderbutton(){
    	ordermanagement = new JButton("\u8BA2\u5355\u7BA1\u7406");
    	ordermanagement.setFont(new Font("宋体", Font.PLAIN, 30));
    	ordermanagement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	      controller.order();
        	}
        });
    	ordermanagement.setBounds(198, 189, 160, 75);
        panel.add(ordermanagement);
    }
    public void init_creditbutton(){
    	creditmanagement = new JButton("\u4FE1\u7528\u67E5\u770B");
    	creditmanagement.setFont(new Font("宋体", Font.PLAIN, 30));
    	creditmanagement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   controller.credit();
        	}
        });
    	creditmanagement.setBounds(378, 189, 160, 75);
        panel.add(creditmanagement);
    }
    public void init_searchbutton(){
    	 searchhotel = new JButton("\u9152\u5E97\u641C\u7D22");
    	 searchhotel.addActionListener(new ActionListener() {
    	 	public void actionPerformed(ActionEvent e) {
    	 		controller.search();
    	 	}
    	 });
    	 searchhotel.setFont(new Font("宋体", Font.PLAIN, 30));
    	 searchhotel.setBounds(562, 189, 160, 75);
         panel.add(searchhotel);
    }
    public void init_histroybutton(){
    	histroyhotel = new JButton("\u5386\u53F2\u9152\u5E97");
    	histroyhotel.setFont(new Font("宋体", Font.PLAIN, 30));
    	histroyhotel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.histroy();
        	}
        });
    	histroyhotel.setBounds(750, 189, 160, 75);
        panel.add(histroyhotel);
    }
    public void init_exitbutton(){
    	exit = new JButton("\u767B\u51FA\u8D26\u53F7");
        exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.exit();
        	}
        });
        exit.setFont(new Font("宋体", Font.PLAIN, 20));
        exit.setBounds(36, 33, 143, 60);
        panel_1.add(exit);
    }
    public void information(){
    	InformationViewControllerService controller =  new InformationViewControllerImpl(UserID);
		InformationView view = new InformationView(controller);
		controller.setView(view);
		main.change(this, view);
    }
	public void credit(){
		CreditViewControllerService controller =  new CreditViewControllerImpl(UserID);
		CreditView view = new CreditView(controller);
		controller.setView(view);
		main.change(this, view);
	}
	public void exit(){
		LoginViewControllerService controller =  new LoginViewControllerImpl();
		LoginView view = new LoginView(controller);
		controller.setView(view);
		main.change(this, view);
	}
	public void search(){}
	public void histroy(){
		HistroyHotelViewControllerService controller =  new HistroyHotelViewControllerImpl(UserID);
		HistroyHotelView view = new HistroyHotelView(controller);
		controller.setView(view);
		main.change(this, view);
	}
	public void order(){
		OrderViewControllerService controller =  new OrderViewControllerImpl(UserID);
		OrderView view = new OrderView(controller);
		controller.setView(view);
		main.change(this, view);
	}
}
