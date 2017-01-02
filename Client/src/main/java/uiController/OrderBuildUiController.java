package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;

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
import uiService.HotelSearchUiService;
import uiService.LoginViewControllerService;
import uiService.OrderBuildUiService;
import uiService.OrderDetailViewService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userView.HotelBrowseView;
import userView.HotelDetailView;
import userView.HotelSearchView;
import userView.LogView;
import userView.OrderBuildView;
import userView.OrderDetailView;
import vo.HotelVO;
import vo.OrderVO;
/**
 * 订单生成界面的控制器
 * @author lw
 *
 */
public class OrderBuildUiController implements OrderBuildUiService{
	private JPanel view;
	private String userID;
	private String hotelID;
	private OrderBLService order;
	private RoomBLService room;
	private HotelBLService hotel;
	private PromotionBLService promotion;
	private UserBLService user;
	private int from;
	/**
	 * 订单生成界面的控制器构造方法
	 * @param id
	 */
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
	/**
	 *从上一界面获取用户ID
	 * @param 
	 */
	public String getUserID(){
		return userID;
	}
	/**
	 *判断是从哪一界面跳转而来
	 * @param 
	 */
	public int getfrom(){
		return from;
	}
	/**
	 *从上一界面获取酒店ID
	 * @param 
	 */
	public String getHotelID(){
		return hotelID;
	}
	/**
	 *设置订单生成界面的panel
	 * @param 
	 */
	@Override
	public void setView(OrderBuildView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	/**
	 *跳转到上一界面
	 * @param 
	 */
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
		else if(from==4){
			HotelSearchUiService controller=new HotelSearchUiController(id1);
			HotelSearchView view=new HotelSearchView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		}
	}
	/**
	 *保存订单信息
	 * @param 
	 */
	public  void saveOrderInfo(OrderVO vo){
		order.saveOrderInfo(vo);
	}
	/**
	 *判断订单是否能够生成
	 * @param 
	 */
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelid){
		return order.whetherMake(numsOfRoom,RoomType,hotelid);
	}
	/**
	 *更新房间信息
	 * @param 
	 */
	public void updateRoomState(String hotelid, String roomType,int roomNumber){
		room.updateRoomState(hotelid,roomType,roomNumber);
	}
	/**
	 *获取酒店的房间类型
	 * @param 
	 */
	public List<String> getRoomType(String hotelid){
		return hotel.getRoomType(hotelid);
	}
	/**
	 *得到酒店某房型的剩余房间数
	 * @param 
	 */
	public int getMaxRoomNumber(String hotelid, String roomType){
		return hotel.getMaxRoomNumber(hotelid,roomType);
	}
	/**
	 *计算订单的价值
	 * @param 
	 */
	public int getOrderPrice(String hotelid, String roomType, int roomNumber){
		return hotel.getOrderPrice(hotelid,roomType,roomNumber);
	}
	/**
	 *获取网站策略的折扣
	 * @param 
	 */
	public double getWebPromotionDiscount(String userid,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException{
		return promotion.getWebPromotionDiscount(userid,city,bussinesscircle,orderbuildtime);
		
	}
	/**
	 *获取酒店策略的折扣
	 * @param 
	 */
	public double getHotelPromotionDiscount(String hotelid,String userid,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException{
		return promotion.getHotelPromotionDiscount(hotelid,userid,roomNumber,orderbuildtime,begintime,endtime);
		
	}
	/**
	 *获取酒店的详细信息
	 * @param 
	 */
	public HotelVO findByHotelID(String hoteid){
		return hotel.findByHotelID(hoteid);
	}
	/**
	 *获取用户的信用值
	 * @param 
	 */
	public long showCredit(String userid){
		return user.showCredit(userid);
	}
}
