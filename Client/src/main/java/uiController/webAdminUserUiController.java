package uiController;

import javax.swing.JPanel;

import WebAdminView.AddHotelView;
import WebAdminView.UserManagementView;
import WebAdminView.WebAdminUserView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.UserManagementUiService;
import uiService.webAdminUserUiService;

public class webAdminUserUiController implements webAdminUserUiService{
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
		
	}
}
