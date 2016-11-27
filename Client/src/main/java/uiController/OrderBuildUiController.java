package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.LogView;
import UserView.OrderBuildView;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.LoginViewControllerService;
import uiService.OrderBuildUiService;

public class OrderBuildUiController implements OrderBuildUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	public OrderBuildUiController(String userID){
		this.userID=userID;
	}
	@Override
	public void setView(OrderBuildView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toHotelBrowseView(String id){
		HotelBrowseUiService controller=new HotelBrowseUiController(userID);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	
}
