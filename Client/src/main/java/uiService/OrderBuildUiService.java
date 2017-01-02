package uiService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import userView.OrderBuildView;
import vo.HotelVO;
import vo.OrderVO;
/**
 * 订单生成界面接口的实现接口
 * @author 刘伟
 *
 */
public interface OrderBuildUiService {
	/**
	 * 设置一个OrderBuildView的panel
	 * @param view
	 */
	public void setView(OrderBuildView view);

	/**
	 * 跳转到酒店浏览界面
	 * @param view
	 */
	public void toHotelBrowseView(String id1,String id2,int from) throws RemoteException;

	/**
	 * 保存订单信息
	 * @param 
	 */
	public  void saveOrderInfo(OrderVO vo);

	/**
	 * 判断订单是否能够生成
	 * @param 
	 */
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID);

	/**
	 * 从上一界面获取用户ID
	 * @param 
	 */
	public String getUserID();

	/**
	 * 从上一界面获取酒店ID
	 * @param 
	 */
	public String getHotelID();

	/**
	 *更新房间状态
	 * @param 
	 */
	public void updateRoomState(String hotelID, String roomType,int roomNumber);

	/**
	 * 根据酒店ID获取房间种类
	 * @param 
	 */
	public List<String> getRoomType(String hotelid);

	/**
	 * 得到酒店某房型的剩余房间数
	 * @param 
	 */
	public int getMaxRoomNumber(String hotelid, String roomType);

	/**
	 * 计算订单的价格
	 * @param 
	 */
	public int getOrderPrice(String hotelid, String roomType, int roomNumber);

	/**
	 * 获取网站策略的折扣
	 * @param 
	 */
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException;

	/**
	 * 获取酒店策略的折扣
	 * @param 
	 */
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException;

	/**
	 * 根据酒店ID获取酒店信息
	 * @param 
	 */
	public HotelVO findByHotelID(String hotelID);

	/**
	 * 根据用户ID获取用户信用值
	 * @param 
	 */
	public long showCredit(String userID);

	/**
	 * 判断是从哪一界面跳转而来
	 * @param 
	 */
	public int getfrom();
}
