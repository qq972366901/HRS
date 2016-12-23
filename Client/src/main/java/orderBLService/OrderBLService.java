package orderBLService;
import java.rmi.RemoteException;
import java.util.*;

import PO.OrderPO;
import VO.*;
import common.*;

/**
 * 负责实现订单界面所需要的服务接口
 * @author 刘宇翔
 * @version 1.0
 * @see presentation.Order
 */

public interface OrderBLService {

	/**
     * 获得一个客户的所有订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAllorder(String userid);
	
	
	/**
     * 获得一个客户的所有未执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showUndoneorder(String userid);
	
	
	/**
     * 获得一个客户的所有已执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showDoneorder(String userid);
	
	
	/**
     * 获得一个客户的所有异常订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAbnormalorder(String userid);
	
	
	/**
     * 获得一个客户的所有撤销订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showCancelorder(String userid);
	
	
	/**
     * 撤销订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
     * @return boolean 如果需要扣除信用值返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean cancel(String userid,String orderID);
	
	
	/**
     * 显示订单的详细信息
     * 
     * @param String OrderID，订单的id
     * @return OrderVO ,一个订单
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String orderID);
	
	
	/**
     * 更新客户评论
     * 
     * @param String comment,客户的评论
     * @param int score,客户的评分
     * @param String OrderID，订单的id
     * @see bussinesslogic.Order
     */
	public void updatecomment(String comment,int score,String orderID);
	
	
	/**
     * 获得一个酒店的所有订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAllOrders(String hotelId);
	/**
     * 获得一个酒店的所有未执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getUnfinishedOrders(String hotelId) ;
	
	
	
	/**
     * 获得一个酒店的所有已执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getFinishedOrders(String hotelId) ;
	
	
	/**
     * 获得一个酒店的所有异常订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAbnormalOrders(String hotelId) ;
	
	
	/**
     * 处理未执行订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID，订单的id
     * @return boolean值,处理成功返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean processUnfinishedOrder(String orderId) ;
	
	/**
     * 处理异常订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID,订单的id
     * @param Calendar delayTime,延时入住的时间
     * @return boolean值,处理成功返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean processAbnormalOrder(String orderId,Calendar delayTime) ;
	
	/**
     * 撤销异常订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID,订单的id
     * @see bussinesslogic.Order
     */
	public void cancelAbnormalOrder(String orderID);
	
	/**
     * 保存订单信息(传入的VO至少需要给所有在PO中出现的属性赋值)
     * 
     * @param String orderID,订单的id
     * @see bussinesslogic.Order
     */
	public  void saveOrderInfo(OrderVO vo);
	
	
	/**
	 * 根据不同操作更新客户的信用值(操作详情请看common包)
	 * @param userID String,客户id
	 * @param value int,订单的价值
	 * @param orderID String,订单id
	 * @param operate Operate枚举类，操作的名字
	 */
	public void updateCredit(String userID,String orderID,int value,Operate operate);
	/**
	 * 获取所有已撤销订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getCanceledOrders(String hotelId);
	/**
	 * 
	 * @param numsOfRoom int，需要的房间数量
	 * @param RoomType String，房间的类型
	 * @param hotelID String，酒店的id
	 * @return boolean，能生成则返回true，若没有房间则返回false
	 */
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID);
	/**
	 * 
	 * @param orderNo String型，订单编号
	 * @return String返回拥有此订单的客户账户
	 */
	public String getUserID(String orderNo);
	/**
	 * 更新订单的状态，将超时的订单设置为异常
	 */
	public void updateOrderState();
	/**
	 * 获取酒店的所有当天的未执行订单
	 * @param String HotelID,酒店id
	 * @return List<OrderVO> 订单列表
	 */
	public List<OrderVO> getNowadaysUnfinishedOrder(String HotelID);
}
