package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;
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

/**
 * 浏览酒店界面的控制器
 * @author lw
 *
 */
public class HotelBrowseUiController implements HotelBrowseUiService{
	private JPanel view;
	private String userID;
	private String hotelID;
	private HotelBLService hotel;
	private OrderBLService order;
	private RoomBLService room;
	private PromotionBLService promotion;
	/**
	 * 添加酒店浏览界面的控制器构造方法
	 * @param id
	 */
	public HotelBrowseUiController(String userid,String hotelid) throws RemoteException{
		this.userID=userid;
        this.hotelID = hotelid;
		this.hotel=new HotelBLServiceController();
	    this.order=new OrderBLServiceController();
	    this.room=new RoomBLServiceController();
	    this.promotion=new PromotionController();
	}
	@Override
	/**
	 * 设置界面的panel
	 * @param 
	 */
	public void setView(HotelBrowseView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	/**
	 *跳转到酒店搜索界面
	 * @param 
	 */
	public void toHotelSearchView(String id) throws RemoteException{
		HotelSearchUiService controller=new HotelSearchUiController(id);
		HotelSearchView view=new HotelSearchView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 跳转到订单生成
	 * @param 
	 */
	public void toOrderBuildView(String id1,String id2) throws RemoteException{
		OrderBuildUiService controller=new OrderBuildUiController(id1,id2,1);
		OrderBuildView view=new OrderBuildView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 得到酒店的基本信息
	 * @param 
	 */
	public HotelVO findByHotelID(String hotelID){
		return hotel.findByHotelID(hotelID);
	}
	/**
	 * 得到客户的历史订单
	 * @param 
	 */
	public List<OrderVO> findByHotelIDAndUserID(String userID,String hotelID){
		return hotel.findByHotelIDAndUserID (userID,hotelID);
	}
	/**
	 * 从上一界面获取用户ID
	 * @param 
	 */
	public String getUserID(){
		return userID;
	}
	/**
	 * 从上一界面获取酒店ID
	 * @param 
	 */
	public String getHotelID(){
		return hotelID;
	}
	/**
	 * 获取酒店房间类型
	 * @param 
	 */
	public List<String> getRoomType(String hotelid){
		return hotel.getRoomType(hotelid);
	}
	/**
	 * 获取可用的酒店策略
	 * @param 
	 */
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time){
		return promotion.getHotelPromotionByHotelIDAndTime(hotelid,time);
	}
	/**
	 * 获取酒店的房间价格
	 * @param 
	 */
	public long getRoomPrice(String hotelid,String roomType){
		return room.getRoomPrice(hotelid,roomType);
	}
	/**
	 * 获取酒店已完成的订单
	 * @param 
	 */
	public List<OrderVO> getFinishedOrders(String hotelid){
		return order.getFinishedOrders(hotelid);
		
	}
}
