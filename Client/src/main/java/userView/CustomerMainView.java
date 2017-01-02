package userView;

import javax.swing.JButton;
import javax.swing.JPanel;
import runner.ClientRunner;
import uiController.CreditViewController;
import uiController.HistroyHotelViewController;
import uiController.HotelSearchUiController;
import uiController.InformationViewControllerImpl;
import uiController.LoginViewController;
import uiController.OrderViewController;
import uiService.CreditViewService;
import uiService.HistroyHotelViewControllerService;
import uiService.HotelSearchUiService;
import uiService.InformationViewControllerService;
import uiService.LoginViewControllerService;
import uiService.OrderViewService;
import uiService.CustomerMainViewService;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
/**
 * 客户初始界面的Panel
 * @author 刘宇翔
 *
 */
public class CustomerMainView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerMainViewService controller;
	private JButton information;
	private JButton exit;
	private JButton ordermanagement;
	private JButton searchhotel;
	private JButton creditmanagement;
	private JButton histroyhotel;
	private String UserID;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_33;
	private JLabel label_34;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel label_38;
	private JLabel label_39;
	private JLabel label_40;
	private JLabel label_41;
	private JLabel label_42;
	private JLabel label_43;
	private JLabel label_44;
	private JLabel label_45;
	private JLabel label_46;
	private JLabel label_47;
	private JLabel label_48;
	private JLabel label_49;
	private JLabel label_50;
	private JLabel label_51;
	private JLabel label_52;
	private JLabel label_53;
	private JLabel label_54;
	private JLabel label_55;
	private JLabel label_56;
	private JLabel label_57;
	private JLabel label_58;
	/**
	 * Create the panel.
	 */
	public CustomerMainView(CustomerMainViewService controller) {
         this.controller=controller;
         setLayout(new GridLayout(15, 12, 0, 0));
         
         label = new JLabel("");
         add(label);
         
         label_1 = new JLabel("");
         add(label_1);
         
         label_2 = new JLabel("");
         add(label_2);
         
         label_3 = new JLabel("");
         add(label_3);
         exit = new JButton("\u767B\u51FA\u8D26\u53F7");
         add(exit);
         /**
          * 返回按钮的监听
          */
         exit.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		controller.exit();
         	}
         });
         exit.setFont(UIManager.getFont("Button.font"));
         
         label_4 = new JLabel("");
         add(label_4);
         
         label_5 = new JLabel("");
         add(label_5);
         
         label_6 = new JLabel("");
         add(label_6);
         
         label_7 = new JLabel("");
         add(label_7);
         
         label_8 = new JLabel("");
         add(label_8);
         
         label_9 = new JLabel("");
         add(label_9);
         
         label_10 = new JLabel("");
         add(label_10);
         
         label_11 = new JLabel("");
         add(label_11);
         
         label_12 = new JLabel("");
         add(label_12);
         
         label_13 = new JLabel("");
         add(label_13);
         
         label_14 = new JLabel("");
         add(label_14);
         
         label_15 = new JLabel("");
         add(label_15);
         information = new JButton("\u4FE1\u606F\u67E5\u770B");
         add(information);
         /**
          * 个人信息按钮的监听
          */
         information.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		controller.information();
         	}
         });
         
         label_16 = new JLabel("");
         add(label_16);
         
         label_17 = new JLabel("");
         add(label_17);
         
         label_18 = new JLabel("");
         add(label_18);
         
         label_19 = new JLabel("");
         add(label_19);
         
         label_20 = new JLabel("");
         add(label_20);
         
         label_21 = new JLabel("");
         add(label_21);
         
         label_22 = new JLabel("");
         add(label_22);
         
         label_23 = new JLabel("");
         add(label_23);
         
         label_26 = new JLabel("");
         add(label_26);
         ordermanagement = new JButton("\u8BA2\u5355\u7BA1\u7406");
         add(ordermanagement);
         ordermanagement.setFont(UIManager.getFont("Button.font"));
         /**
          * 订单管理按钮的监听
          */
         ordermanagement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	      controller.order();
        	}
        });
         
         label_24 = new JLabel("");
         add(label_24);
         
         label_25 = new JLabel("");
         add(label_25);
         
         label_27 = new JLabel("");
         add(label_27);
         
         label_29 = new JLabel("");
         add(label_29);
         
         label_30 = new JLabel("");
         add(label_30);
         
         label_31 = new JLabel("");
         add(label_31);
         
         label_32 = new JLabel("");
         add(label_32);
         
         label_33 = new JLabel("");
         add(label_33);
         
         label_34 = new JLabel("");
         add(label_34);
         creditmanagement = new JButton("\u4FE1\u7528\u67E5\u770B");
         add(creditmanagement);
         creditmanagement.setFont(UIManager.getFont("Button.font"));
         /**
          * 信用查看按钮的监听
          */
         creditmanagement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   controller.credit();
        	}
        });
         
         label_35 = new JLabel("");
         add(label_35);
         
         label_36 = new JLabel("");
         add(label_36);
         
         label_37 = new JLabel("");
         add(label_37);
         
         label_28 = new JLabel("");
         add(label_28);
         
         label_38 = new JLabel("");
         add(label_38);
         
         label_39 = new JLabel("");
         add(label_39);
         
         label_40 = new JLabel("");
         add(label_40);
         
         label_41 = new JLabel("");
         add(label_41);
         
         label_42 = new JLabel("");
         add(label_42);
         searchhotel = new JButton("\u9152\u5E97\u641C\u7D22");
         add(searchhotel);
         /**
          * 搜索酒店按钮的监听
          */
         searchhotel.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		controller.search();
         	}
         });
         searchhotel.setFont(UIManager.getFont("Button.font"));
         
         label_43 = new JLabel("");
         add(label_43);
         
         label_44 = new JLabel("");
         add(label_44);
         
         label_45 = new JLabel("");
         add(label_45);
         
         label_46 = new JLabel("");
         add(label_46);
         
         label_47 = new JLabel("");
         add(label_47);
         
         label_48 = new JLabel("");
         add(label_48);
         
         label_49 = new JLabel("");
         add(label_49);
         
         label_50 = new JLabel("");
         add(label_50);
         
         label_51 = new JLabel("");
         add(label_51);
         histroyhotel = new JButton("\u5386\u53F2\u9152\u5E97");
         add(histroyhotel);
         histroyhotel.setFont(UIManager.getFont("Button.font"));
         /**
          * 历史酒店按钮的监听
          */
         histroyhotel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.histroy();
        	}
        });
         
         label_52 = new JLabel("");
         add(label_52);
         
         label_53 = new JLabel("");
         add(label_53);
         
         label_54 = new JLabel("");
         add(label_54);
         
         label_55 = new JLabel("");
         add(label_55);
         
         label_56 = new JLabel("");
         add(label_56);
         
         label_57 = new JLabel("");
         add(label_57);
         
         label_58 = new JLabel("");
         add(label_58);
         
         UserID=controller.getUserID();
	}
	/**
	 * 个人信息界面的跳转
	 */
    public void information(){
    	InformationViewControllerService controller =  new InformationViewControllerImpl(UserID);
		InformationView view = new InformationView(controller);
		controller.setView(view);
		ClientRunner.change(view);
    }
    /**
     * 信用查看界面的跳转
     */
	public void credit(){
		CreditViewService controller =  new CreditViewController(UserID);
		CreditView view = new CreditView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 退出的跳转
	 */
	public void exit(){
		LoginViewControllerService controller =  new LoginViewController();
		LogView view = new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 *酒店搜索界面的跳转
	 */
	public void search(){
		HotelSearchUiService con;
		try {
			con = new HotelSearchUiController(UserID);
			HotelSearchView vie=new HotelSearchView(con);
			con.setView(vie);
			ClientRunner.change(vie);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 历史酒店界面的跳转
	 */
	public void histroy(){
		HistroyHotelViewControllerService controller =  new HistroyHotelViewController(UserID);
		HistroyHotelView view = new HistroyHotelView(controller);
		controller.setView(view);
		ClientRunner.change( view);
	}
	/**
	 * 订单管理界面的跳转
	 */
	public void order() throws RemoteException{
		OrderViewService controller =  new OrderViewController(UserID);
		OrderView view = new OrderView(controller);
		controller.setView(view);
		ClientRunner.change( view);
	}
}
