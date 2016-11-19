package LoginView;

import javax.swing.JFrame;
import javax.swing.JPanel;

import CreditView.CreditView;
import CreditView.CreditViewControllerImpl;
import CreditView.CreditViewControllerService;
import customerMainView.customerMainView;
import customerMainView.customerMainViewControllerImpl;
import customerMainView.customerMainViewControllerService;


public class main {
	static JFrame mFrame;
	public static void main(String[] args){
		mFrame = new JFrame("酒店预订系统 V1.0");
		mFrame.setSize(1000, 700);
		mFrame.setLocation(300, 300);
		LoginViewControllerService controller =  new LoginViewControllerImpl();
		LoginView view = new LoginView(controller);
		controller.setView(view);
		CreditViewControllerService con=new CreditViewControllerImpl("123");
		CreditView vie=new CreditView(con);
		con.setView(vie);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);	
	}
	public static void change(JPanel view,JPanel view2){
		mFrame.remove(view);
		mFrame.repaint();
		mFrame.getContentPane().add(view2);
		mFrame.setVisible(true);
	}
}
