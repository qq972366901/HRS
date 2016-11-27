package uiController;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.MemberRegisterView;
import UserView.UserManagementView;
import UserView.WebAdminUserView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.MemberRegisterUiService;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;

public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(AddHotelView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id){
		WebAdminUserUiService controller=new WebAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toUserManagementView(String id){
		UserManagementUiService controller=new UserManagementUiController();
		UserManagementView view=new UserManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
