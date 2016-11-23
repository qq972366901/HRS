package uiController;

import java.rmi.RemoteException;

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
	public void toUserView(){
		customerMainViewControllerService controller;
		try {
			controller = new customerMainViewControllerImpl(userID);
			customerMainView view = new customerMainView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toHotelBrowseView(){
		HotelBrowseUiService controller=new HotelBrowseUiController(userID);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(){
		OrderBuildUiService controller=new OrderBuildUiController(userID);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
