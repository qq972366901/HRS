package runner;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import PO.HotelPO;
import UserView.MemberRegisterView;
import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.LogView;
import UserView.OrderBuildView;
import UserView.AddHotelView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import dataService.CreditDataService;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import dataService.OrderDataService;
import orderBLImpl.Comment;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import rmi.RemoteHelper;
import uiController.HotelSearchUiController;
import uiController.LoginViewControllerImpl;
import uiService.HotelSearchUiService;
import uiService.LoginViewControllerService;



public class ClientRunner implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RemoteHelper remoteHelper;
	static JFrame mFrame;
	public ClientRunner() throws RemoteException {
		linkToServer();
		initGUI();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			System.out.println("linked");			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private void initGUI() throws RemoteException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	mFrame = new JFrame("HRS"); 
       	 	mFrame.setSize(1000, 700);
        	mFrame.setLocation(10, 10);
        	LoginViewControllerService controller =  new LoginViewControllerImpl();
        	LogView view = new LogView(controller);
    		controller.setView(view);
    		mFrame.getContentPane().add(view);
        	mFrame.setVisible(true);
        	/*DataFactoryService df=RemoteHelper.getInstance().getDataFactoryService();
        	CreditDataService cd=(CreditDataService) df.getDataService("Credit");
        	ArrayList<String> list=cd.get();
        	for(int i=0;i<list.size();i++){
        		System.out.println(list.get(i));
        	}*/
	}
	public static void change(JPanel view){
		mFrame.getContentPane().removeAll();
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
		if(view instanceof WebAdminUserView) {
        mFrame.setTitle("网站管理人员主界面");
		}
		else if(view instanceof UserManagementView) {
	    mFrame.setTitle("用户管理");
		}
		else if(view instanceof AddHotelView) {
	    mFrame.setTitle("添加酒店");
		}
		else if(view instanceof MemberRegisterView) {
		mFrame.setTitle("会员注册");
		}
		else if(view instanceof HotelSearchView) {
		mFrame.setTitle("酒店搜索");
		}
		else if(view instanceof HotelBrowseView) {
		mFrame.setTitle("酒店浏览");
		}
		else if(view instanceof OrderBuildView) {
		mFrame.setTitle("生成订单");
		}
	}

	
	public static void main(String[] args){
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
