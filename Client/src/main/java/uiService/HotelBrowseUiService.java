package uiService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import userView.HotelBrowseView;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.OrderVO;
/**
 * 酒店浏览界面接口的实现接口
 * @author 刘伟
 *
 */
public interface HotelBrowseUiService {
	/**
	 * 设置一个HotelBrowseView的panel
	 * @param view
	 */
	public void setView(HotelBrowseView view);
	 /**
     * 酒店搜索界面跳转
     */
	public void toHotelSearchView(String id) throws RemoteException;
	 /**
     * 订单生成界面跳转
     */
	public void toOrderBuildView(String userid,String hotelid) throws RemoteException;
	 /**
     * 通过酒店ID查找酒店信息
     */
	public HotelVO findByHotelID(String hotelID);
	 /**
     * 通过酒店ID和用户ID获取用户的订单列表
     */
	public List<OrderVO> findByHotelIDAndUserID(String userID,String hotelID);
	 /**
     * 获取上一界面传来的用户ID
     */
	public String getUserID();
	 /**
     * 获取上一界面传来的酒店ID
     */
	public String getHotelID();
	 /**
     * 根据酒店ID获取酒店的可用房间类型
     */
	public List<String> getRoomType(String hotelid);
	 /**
     * 通过酒店ID和时间获取酒店的促销策略
     */
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time);
	 /**
     * 根据酒店ID和房间类型获取房间的单价
     */
	public long getRoomPrice(String hotelid,String roomType);
	 /**
     * 根据酒店ID获取酒店的已完成订单
     */
	public List<OrderVO> getFinishedOrders(String hotelId) ;
}
