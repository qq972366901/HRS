package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelDetailView;
import UserView.LogView;
import UserView.OrderBuildView;
import UserView.orderDetailView;
import VO.HotelVO;
import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;
import runner.ClientRunner;
import uiService.HotelBrowseUiService;
import uiService.HotelDetailUiService;
import uiService.LoginViewControllerService;
import uiService.OrderBuildUiService;
import uiService.orderDetailViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class OrderBuildUiController implements OrderBuildUiService{
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private String userID;
	private String hotelID;
	private OrderBLService order;
	private RoomBLService room;
	private HotelBLService hotel;
	private PromotionBLService promotion;
	private UserBLService user;
	private int from;
	public OrderBuildUiController(String userID,String hotelID,int come) throws RemoteException{
		this.order=new OrderBLServiceController();
	    this.room=new RoomBLServiceController();
	    this.hotel=new HotelBLServiceController();
	    this.promotion=new PromotionController();
	    this.user=new UserBLServiceController();
		this.userID=userID;
		this.hotelID=hotelID;
		this.from=come;
	}
	public String getUserID(){
		return userID;
	}
	public int getfrom(){
		return from;
	}
	public String getHotelID(){
		return hotelID;
	}
	@Override
	public void setView(OrderBuildView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toHotelBrowseView(String id1,String id2,int from) throws RemoteException{
		if(from==1){
		HotelBrowseUiService controller=new HotelBrowseUiController(id1,id2);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
		}
		else if(from==2){
			HotelDetailUiService con =  new HotelDetailUiController(id2,id1);
			HotelDetailView vie = new HotelDetailView(con);
			con.setView(vie);
			ClientRunner.change(vie);
		}
	}
	public  void saveOrderInfo(OrderVO vo){
		order.saveOrderInfo(vo);
	}
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelid){
		return order.whetherMake(numsOfRoom,RoomType,hotelid);
	}
	public void updateRoomInfo(String hotelid, String roomNumber, String roomType, String roomState){
		room.updateRoomInfo(hotelid,roomNumber,roomType,roomState);
	}
	public void updateRoomState(String hotelid, String roomType,int roomNumber){
		room.updateRoomState(hotelid,roomType,roomNumber);
	}
	public List<String> getRoomType(String hotelid){
		return hotel.getRoomType(hotelid);
	}
	public int getMaxRoomNumber(String hotelid, String roomType){
		return hotel.getMaxRoomNumber(hotelid,roomType);
	}
	public int getOrderPrice(String hotelid, String roomType, int roomNumber){
		return hotel.getOrderPrice(hotelid,roomType,roomNumber);
	}
	public double getWebPromotionDiscount(String userid,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException{
		return promotion.getWebPromotionDiscount(userid,city,bussinesscircle,orderbuildtime);
		
	}
	public double getHotelPromotionDiscount(String hotelid,String userid,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException{
		return promotion.getHotelPromotionDiscount(hotelid,userid,roomNumber,orderbuildtime,begintime,endtime);
		
	}
	public HotelVO findByHotelID(String hoteid){
		return hotel.findByHotelID(hoteid);
	}
	public long showCredit(String userid){
		return user.showCredit(userid);
	}
}
