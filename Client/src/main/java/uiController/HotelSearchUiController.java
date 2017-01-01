package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import UserView.HotelBrowseView;
import UserView.HotelSearchView;
import UserView.OrderBuildView;
import UserView.CustomerMainView;
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
import uiService.CustomerMainViewService;

/**
 * 搜索酒店界面的控制器
 * @author lw
 *
 */
public class HotelSearchUiController implements HotelSearchUiService{
	private JPanel view;
	private String userID;
	private HotelBLService hotel;
	private PromotionBLService promotion;
	private RoomBLService room;
	/**
	 * 酒店搜索界面的控制器构造方法
	 * @param id
	 */
	public HotelSearchUiController(String userID) throws RemoteException {
		// TODO Auto-generated constructor stub
		this.userID=userID;
		this.hotel=new HotelBLServiceController();
		this.promotion=new PromotionController();
		this.room=new RoomBLServiceController();
	}
	@Override
	/**
	 * 设置酒店搜索界面的panel
	 */
	public void setView(HotelSearchView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	/**
	 * 跳转到用户主界面
	 */
	public void toUserView(String id){
		CustomerMainViewService controller =  new CustomerMainViewController(userID);
		CustomerMainView view = new CustomerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到酒店浏览界面
	 */
	public void toHotelBrowseView(String id1,String id2) throws RemoteException{
		HotelBrowseUiService controller=new HotelBrowseUiController(id1,id2);
		HotelBrowseView view=new HotelBrowseView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到网站管理人员主界面
	 */
	public void toOrderBuildView(String id1,String id2) throws RemoteException{
		OrderBuildUiService controller=new OrderBuildUiController(id1,id2,4);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 得到所有的城市
	 */
	public List<String> getCity(){
		return promotion.getCity();
	}
	/**
	 * 得到城市的商圈
	 */
	public Vector<String> getCircle(String city){
		return promotion.getCircle(city);
		
	}
	/**
	 * 查找满足条件的酒店的ID
	 */
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid,String name){
		return hotel.getHotelID(city,businessCircle,roomType,roomNumber,priceLow,priceHigh,hotelStar,scoreLow,scoreHigh,everBooked,userid,name);
	}
	/**
	 * 获取从上一界面传来的用户ID
	 */
	public String getUserID() {
		// TODO Auto-generated method stub
		return userID;
	}
	/**
	 * 获取酒店的详细信息
	 */
	public HotelVO findByHotelID(String hotelid){
		return hotel.findByHotelID(hotelid);
	}
	/**
	 * 获取酒店房间的最低价
	 */
	public int getRoomLowestPrice(String hotelid){
		return room.getRoomLowestPrice(hotelid);
	}
	/**
	 *获取适用的酒店策略
	 */
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time){
		return promotion.getHotelPromotionByHotelIDAndTime(hotelid,time);
	}
	/**
	 * 获取用户在酒店的历史订单
	 */
	public List<OrderVO> findByHotelIDAndUserID (String userid,String hotelid){
		return hotel.findByHotelIDAndUserID (userid,hotelid);
		
	}
}
