package uiController;

import javax.swing.JPanel;

import UserView.AddHotelView;
import UserView.WebAdminUserView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.WebAdminUserUiService;

public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(AddHotelView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(){
		WebAdminUserUiService controller=new WebAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
