package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.OrderBuildView;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.OrderBuildUiService;

public class OrderBuildUiController implements OrderBuildUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(OrderBuildView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toHotelBrowseView(){
		HotelBrowseUiService controller=new HotelBrowseUiController();
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(){
		
	}
	
}
