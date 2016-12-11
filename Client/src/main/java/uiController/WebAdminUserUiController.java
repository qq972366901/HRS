package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.LogView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.LoginViewControllerService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class WebAdminUserUiController implements WebAdminUserUiService{
	private JPanel view;
	private String UserID;
	private UserBLService user;
	public WebAdminUserUiController(String id) throws RemoteException{
    	this.UserID=id;
    	this.user=new UserBLServiceController();
    }
	public void setView(WebAdminUserView view) {
		this.view=view;
}
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
	public void toUserManagementView(String id) throws RemoteException{
		UserManagementUiService controller=new UserManagementUiController(id);
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toLogView(){
		LoginViewControllerService controller=new LoginViewControllerImpl();
		LogView view=new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public String getUserID(){
		return UserID;
	}
	public void logout(String ID){
		user.logout(ID);
	}
}
