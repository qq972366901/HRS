package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;


public class HotelBrowseUiController implements HotelBrowseUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	public HotelBrowseUiController(String userID){
		this.userID=userID;
	}
	@Override
	public void setView(HotelBrowseView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toHotelSearchView(){
		HotelSearchUiService controller=new HotelSearchUiController(userID);
		HotelSearchView view=new HotelSearchView(controller);
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
