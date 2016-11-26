package uiController;

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

public class WebAdminUserUiController implements WebAdminUserUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(WebAdminUserView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toAddHotelView(){
		AddHotelUiService controller=new AddHotelUiController();
		AddHotelView view=new AddHotelView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toUserManagementView(){
		UserManagementUiService controller=new UserManagementUiController();
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
}
