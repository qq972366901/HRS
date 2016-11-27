package uiController;

import javax.swing.JPanel;

import UserView.UserManagementView;
import UserView.WebAdminUserView;
import runner.ClientRunner;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;

public class UserManagementUiController implements UserManagementUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(UserManagementView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id){
		WebAdminUserUiService controller=new WebAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
