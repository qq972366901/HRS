package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.LogView;
import UserView.OrderBuildView;
import UserView.WebAdminUserView;
import UserView.customerMainView;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import uiService.LoginViewControllerService;
import uiService.OrderBuildUiService;
import uiService.WebAdminUserUiService;
import uiService.customerMainViewControllerService;
import uiService.userUiService;


public class HotelSearchUiController implements HotelSearchUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	public HotelSearchUiController(String userID) {
		// TODO Auto-generated constructor stub
		this.userID=userID;
	}
	@Override
	public void setView(HotelSearchView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toUserView(String id){
		customerMainViewControllerService controller =  new customerMainViewControllerImpl(userID);
		customerMainView view = new customerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toHotelBrowseView(String id){
		HotelBrowseUiService controller=new HotelBrowseUiController(userID);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(String id){
		OrderBuildUiService controller=new OrderBuildUiController(userID);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
