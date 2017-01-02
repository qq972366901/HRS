package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.LoginViewControllerService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userView.AddHotelView;
import userView.LogView;
import userView.UserManagementView;
import userView.WebAdminUserView;
/**
 * 网站管理人员主界面的控制器
 * @author lw
 *
 */
public class WebAdminUserUiController implements WebAdminUserUiService{
	private JPanel view;
	private String UserID;
	private UserBLService user;
	/**
	 * 网站管理人员主界面的控制器构造方法
	 * @param id
	 */
	public WebAdminUserUiController(String id) throws RemoteException{
    	this.UserID=id;
    	this.user=new UserBLServiceController();
    }
	/**
	 * 设置网站管理人员主界面的panel
	 * @param 
	 */
	public void setView(WebAdminUserView view) {
		this.view=view;
}
	/**
	 * 跳转到添加酒店界面
	 * @param 
	 */
	public void toAddHotelView(String id){
		AddHotelUiService controller = null;
		try {
			controller = new AddHotelUiController(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AddHotelView view=new AddHotelView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到用户管理
	 * @param 
	 */
	public void toUserManagementView(String id) throws RemoteException{
		UserManagementUiService controller=new UserManagementUiController(id);
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到登录界面
	 * @param 
	 */
	public void toLogView(){
		LoginViewControllerService controller=new LoginViewController();
		LogView view=new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 从上一界面获取用户的ID
	 * @param 
	 */
	public String getUserID(){
		return UserID;
	}
	/**
	 * 注销登录信息
	 * @param 
	 */
	public void logout(String ID){
		user.logout(ID);
	}
}
