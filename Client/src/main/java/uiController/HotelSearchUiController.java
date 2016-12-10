package uiController;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import UserView.customerMainView;
import VO.HotelPromotionVO;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;
import uiService.customerMainViewControllerService;


public class HotelSearchUiController implements HotelSearchUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	private HotelBLService hotel;
	private PromotionBLService promotion;
	private RoomBLService room;
	public HotelSearchUiController(String userID) throws RemoteException {
		// TODO Auto-generated constructor stub
		this.userID=userID;
		this.hotel=new HotelBLServiceController();
		this.promotion=new PromotionController();
		this.room=new RoomBLServiceController();
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
	public void toHotelBrowseView(String id1,String id2) throws RemoteException{
		HotelBrowseUiService controller=new HotelBrowseUiController(id1,id2);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(String id1,String id2) throws RemoteException{
		OrderBuildUiService controller=new OrderBuildUiController(id1,id2);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public List<String> getCity(){
		return promotion.getCity();
	}
	public Vector<String> getCircle(String city){
		return promotion.getCircle(city);
		
	}
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid){
		return hotel.getHotelID(city,businessCircle,roomType,roomNumber,priceLow,priceHigh,hotelStar,scoreLow,scoreHigh,everBooked,userid);
	}
	public String getUserID() {
		// TODO Auto-generated method stub
		return userID;
	}
	public HotelVO findByHotelID(String hotelid){
		return hotel.findByHotelID(hotelid);
	}
	public int getRoomLowestPrice(String hotelid){
		return room.getRoomLowestPrice(hotelid);
	}
	public HotelPromotionVO getHotelPromotionByHotelID(String hotelid){
		return promotion.getHotelPromotionByHotelID(hotelid);
	}
	public List<OrderVO> findByHotelIDAndUserID (String userid,String hotelid){
		return hotel.findByHotelIDAndUserID (userid,hotelid);
		
	}
}
