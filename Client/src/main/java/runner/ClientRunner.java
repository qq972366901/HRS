package runner;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import UserView.MemberRegisterView;
import UserView.HotelBrowseView;
import UserView.HotelDetailView;
import UserView.HotelSearchView;
import UserView.InformationView;
import UserView.LogView;
import UserView.OrderBuildView;
import UserView.OrderView;
import UserView.AddHotelView;
import UserView.CommentView;
import UserView.CreditView;
import UserView.HistroyHotelView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import WebPromotionView.CreditManagementView;
import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import orderBLImpl.OrderList;
import rmi.RemoteHelper;
import uiController.LoginViewControllerImpl;
import uiService.LoginViewControllerService;

/**
 * 客户端初始化
 * @author LZ
 *
 */

public class ClientRunner implements Serializable{

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
			e.printStackTrace();
		}
        	mFrame = new JFrame("酒店预订系统"); 
       	 	mFrame.setSize(1000, 700);
        	mFrame.setLocation(10, 10);
        	LoginViewControllerService controller =  new LoginViewControllerImpl();
        	LogView view = new LogView(controller);
    		controller.setView(view);
    		mFrame.getContentPane().add(view);
        	mFrame.setVisible(true);
	}
	/**
	 * 界面跳转
	 * @param view JPanel型，界面层传入的panel
	 */
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
		else if(view instanceof OrderView) {
		mFrame.setTitle("订单管理");
		}
		else if(view instanceof CommentView) {
		mFrame.setTitle("订单评价");
		}
		else if(view instanceof InformationView) {
		mFrame.setTitle("个人信息管理");
		}
		else if(view instanceof CreditView) {
		mFrame.setTitle("信用管理");
		}
		else if(view instanceof HistroyHotelView) {
		mFrame.setTitle("历史酒店浏览");
		}
		else if(view instanceof HotelDetailView) {
		mFrame.setTitle("酒店订单浏览");
		}
		else if(view instanceof LogView){
			mFrame.setTitle("酒店预订系统");
		}
		else if(view instanceof MemberLevelSystemView){
			mFrame.setTitle("制定会员等级制度");
		}
		else if(view instanceof WebPromotionStrategyView){
			mFrame.setTitle("制定网站营销策略");
		}
		else if(view instanceof WebPromotionUserView){
			mFrame.setTitle("网站营销人员主界面");
		}
		else if(view instanceof CreditManagementView){
			mFrame.setTitle("信用值管理");
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
