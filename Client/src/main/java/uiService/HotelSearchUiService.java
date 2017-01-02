package uiService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import userView.HotelSearchView;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.OrderVO;
/**
 * 酒店搜索界面接口的实现接口
 * @author 刘伟
 *
 */
public interface HotelSearchUiService {
	/**
	 * 从上一界面获取用户ID
	 */
	public String getUserID();
	/**
	 * 设置一个HotelSearchView的panel
	 * @param view
	 */
	public void setView(HotelSearchView view);
	/**
	 *跳转到用户主界面
	 */
	public void toUserView(String id);
	/**
	 * 跳转到酒店浏览
	 */
	public void toHotelBrowseView(String userid,String hotelid) throws RemoteException;
	/**
	 *跳转到订单生成界面
	 */
	public void toOrderBuildView(String userid,String hotelid) throws RemoteException;
	/**
	 *获取所有的城市
	 */
	public List<String> getCity();
	/**
	 *获取城市的商圈
	 */
	public Vector<String> getCircle(String city);
	/**
	 *查找满足条件的酒店
	 */
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid,String name);
	/**
	 *通过酒店ID查找酒店信息
	 */
	public HotelVO findByHotelID(String hotelID);
	/**
	 *通过酒店ID查找酒店的最低价
	 */
	public int getRoomLowestPrice(String hotelID);
	/**
	 *通过酒店ID和时间获取可用的酒店策略
	 */
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time);
	/**
	 *根据酒店ID和用户ID获取用户在该酒店的历史订单
	 */
	public List<OrderVO> findByHotelIDAndUserID (String userid,String hotelid);
}
