package uiService;

import java.util.Calendar;
import java.util.List;

import common.Operate;
import common.UserType;
import hotelWorkerView.ProcessOrderView;
import vo.OrderVO;
/**
 * 浏览订单界面的服务
 * @author 刘宗侃
 *
 */
public interface ProcessOrderUiService {
	public String getHotelId();
	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(ProcessOrderView view);
	/**
	 * 得到所有订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getAllOrders(String hotelId);
	/**
	 * 得到所有未执行订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getUnfinishedOrders(String hotelId);
	/**
	 * 得到已执行订单
	 * 
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getFinishedOrders(String hotelId);
	/**
	 * 得到异常订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getAbnormalOrders(String hotelId);
	
	/**
	 * 处理未执行订单
	 * @param orderId
	 * @return
	 */
	public boolean processUnfinishedOrder(String orderId);
	
	/**
	 * 处理异常订单
	 * @param orderId
	 * @param delayTime
	 * @return
	 */
	public boolean processAbnormalOrder(String orderId,String delayTime);
	
	/**
	 * 更新所选列表
	 * @param comboboxValue
	 */
	public void updateListModel(String comboboxValue);
	
	/**
	 * 订单状态置为已执行
	 */
	public void processOrderButtonClicked();
	
	/**
	 * 延时订单执行时间
	 */
	public void delayOrderButtonClicked();

	/**
	 * 返回上一界面
	 */
	public void back();

	/**
	 * 撤销异常订单
	 */
	public void cancelAbnormalOrder();

	/**
	 * 恢复信用值
	 * @param calendar
	 * @param orderNo
	 * @param appeal
	 * @param strategy
	 * @param value
	 * @param userID
	 */
	public void recover(Calendar calendar, String orderNo, Operate appeal, String strategy, int value, String userID);

	/**
	 * 得到撤销订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getCanceledOrders(String hotelId);

	/**
	 * 得到用户ID
	 * @param orderNo
	 * @return
	 */
	public String getUserID(String orderNo);

	/**
	 * 处理用户的异常订单
	 * @param userID
	 */
	public void dealwithAbnormalOrder(String userID);

	/**
	 * 得到使用的用户类型
	 * @return
	 */
	public UserType getUserType();

	public List<OrderVO> getOrder(String selected);


}
