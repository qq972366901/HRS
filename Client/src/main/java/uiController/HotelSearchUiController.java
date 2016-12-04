package uiController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Object.Hotel;
import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.LogView;
import UserView.OrderBuildView;
import UserView.WebAdminUserView;
import UserView.customerMainView;
import VO.HotelVO;
import common.MessageInput;
import common.ResultMessage;
import hotelBLService.HotelBLService;
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
	private HotelBLService hotel;
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
	public List<HotelVO> getHistoryHotel(String userID){
		return hotel.getHistoryHotel(userID);
		
	}
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid){
		return hotel.getHotelID(city,businessCircle,roomType,roomNumber,priceLow,priceHigh,hotelStar,scoreLow,scoreHigh,everBooked,userid);
	}
	public ResultMessage messagelook(HotelVO hvo){
		return hotel.messagelook(hvo);
	}
	public ArrayList<HotelVO> messagesearch(MessageInput in){
		return hotel.messagesearch(in);
	}
	public  ArrayList<HotelVO> historylook(String  id){
		return hotel.historylook(id);
	}
	public HotelVO pricesort(ArrayList<Hotel>  ah){
		return hotel.pricesort(ah);
	}
	public HotelVO starsort(ArrayList<Hotel>  ah){
		return hotel.starsort(ah);
	}
	public HotelVO scoresort(ArrayList<Hotel>  ah){
		return hotel.scoresort(ah);
	}
}
