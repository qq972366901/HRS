package LoginView;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserView.CreditView;
import UserView.LogView;
import UserView.customerMainView;
import uiController.CreditViewControllerImpl;
import uiController.LoginViewControllerImpl;
import uiController.customerMainViewControllerImpl;
import uiService.CreditViewControllerService;
import uiService.LoginViewControllerService;
import uiService.customerMainViewControllerService;


public class main {
	static JFrame mFrame;
	public static void main(String[] args){
		mFrame = new JFrame("酒店预订系统 V1.0");
		mFrame.setSize(1000, 700);
		mFrame.setLocation(300, 300);
		LoginViewControllerService controller =  new LoginViewControllerImpl();
		LogView view = new LogView(controller);
		controller.setView(view);
		CreditViewControllerService con=new CreditViewControllerImpl("123");
		CreditView vie=new CreditView(con);
		con.setView(vie);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);	
	}
	public static void change(JPanel view2){
		mFrame.getContentPane().removeAll();
		mFrame.getContentPane().add(view2);
		mFrame.setVisible(true);
	}
}
