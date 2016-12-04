package uiController;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.LogView;
import UserView.OrderBuildView;
import VO.OrderVO;
import orderBLService.OrderBLService;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.LoginViewControllerService;
import uiService.OrderBuildUiService;

public class OrderBuildUiController implements OrderBuildUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	private OrderBLService order;
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
	public  void saveOrderInfo(OrderVO vo){
		order.saveOrderInfo(vo);
	}
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID){
		return order.whetherMake(numsOfRoom,RoomType,hotelID);
	}
	
}
