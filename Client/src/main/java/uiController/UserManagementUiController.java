package uiController;

import javax.swing.JPanel;

import WebAdminView.UserManagementView;
import WebAdminView.WebAdminUserView;
import runner.ClientRunner;
import uiService.UserManagementUiService;
import uiService.webAdminUserUiService;

public class UserManagementUiController implements UserManagementUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(UserManagementView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(){
		webAdminUserUiService controller=new webAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}