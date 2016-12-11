package uiController;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import VO.HotelPromotionVO;
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
import uiService.HotelSearchUiService;
import uiService.OrderBuildUiService;
import userBLService.UserBLService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;


public class HotelBrowseUiController implements HotelBrowseUiService{
	private JPanel view;
	private String userID;
	private String hotelID;
	private HotelBLService hotel;
	private OrderBLService order;
	private RoomBLService room;
	private PromotionBLService promotion;
	public HotelBrowseUiController(String userid,String hotelid) throws RemoteException{
		this.userID=userid;
		String key=null;
		try {
			key=Log.getLogInstance().getKey(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(key!=null){
			hotelID = DES.encryptDES(hotelid, key);
		}
		else{
			System.out.println("加密失败");
		}
		this.hotel=new HotelBLServiceController();
	    this.order=new OrderBLServiceController();
	    this.room=new RoomBLServiceController();
	    this.promotion=new PromotionController();
	}
	@Override
	public void setView(HotelBrowseView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toHotelSearchView(String id) throws RemoteException{
		HotelSearchUiService controller=new HotelSearchUiController(id);
		HotelSearchView view=new HotelSearchView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public void toOrderBuildView(String id1,String id2) throws RemoteException{
		OrderBuildUiService controller=new OrderBuildUiController(id1,id2);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public HotelVO findByHotelID(String hotelID){
		return hotel.findByHotelID(hotelID);
	}
	public List<OrderVO> findByHotelIDAndUserID(String userID,String hotelID){
		return hotel.findByHotelIDAndUserID (userID,hotelID);
	}
	public String getUserID(){
		return userID;
	}
	public String getHotelID(){
		return hotelID;
	}
	public List<String> getRoomType(String hotelid){
		return hotel.getRoomType(hotelid);
	}
	public HotelPromotionVO getHotelPromotionByHotelID(String hotelid){
		return promotion.getHotelPromotionByHotelID(hotelid);
	}
	public long getRoomPrice(String hotelid,String roomType){
		return room.getRoomPrice(hotelid,roomType);
	}
	public List<OrderVO> getFinishedOrders(String hotelid){
		return order.getFinishedOrders(hotelid);
		
	}
}
