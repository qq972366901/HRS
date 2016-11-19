package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;


public class HotelSearchUiController implements HotelSearchUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(HotelSearchView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toUserView(){
		
	}
	public void toHotelBrowseView(){
		HotelBrowseUiService controller=new HotelBrowseUiController();
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(){
		OrderBuildUiService controller=new OrderBuildUiController();
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
}
