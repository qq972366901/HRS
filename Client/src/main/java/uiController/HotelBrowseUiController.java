package uiController;

import java.util.List;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import orderBLService.OrderBLService;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;
import userBLService.UserBLService;


public class HotelBrowseUiController implements HotelBrowseUiService{
	private JPanel view;
	private String userID;
	private HotelBLService hotel;
	private OrderBLService order;
	public HotelBrowseUiController(String userID){
		this.userID=userID;
	}
	public void setView(HotelBrowseView view) {
		this.view=view;
}
	public void toHotelSearchView(String id){
		HotelSearchUiService controller=new HotelSearchUiController(userID);
		HotelSearchView view=new HotelSearchView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(String id){
		OrderBuildUiService controller=new OrderBuildUiController(userID);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public HotelVO findByHotelID(String hotelID){
		return hotel.findByHotelID(hotelID);
	}
	public List<OrderVO> findByHotelID (String userID,String hotelID){
		return hotel.findByHotelIDAndUserID (userID,hotelID);
	}
//	public boolean getroominfo(HotelVO vo){
//		return hotel.getroominfo(vo);
//	}
}
