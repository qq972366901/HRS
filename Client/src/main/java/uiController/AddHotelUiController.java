package uiController;

import javax.swing.JPanel;

import WebAdminView.AddHotelView;
import WebAdminView.WebAdminUserView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.webAdminUserUiService;

public class AddHotelUiController implements  AddHotelUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(AddHotelView view) {
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
