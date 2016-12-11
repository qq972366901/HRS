package orderManagement;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import VO.CreditRecordVO;
import VO.OrderVO;
import common.Operate;
import orderBLImpl.OrderLineItem;
import orderBLImpl.OrderList;
import orderBLImpl.Orderstate;
import userBLServiceImpl.Credit;
/**
 * 客户的个人订单管理
 * 可以查看不同类型的订单，并对于一些未执行订单进行撤销操作
 * @author Lyx
 *
 */
public class OrderManagementController{
	OrderList list;
	OrderLineItem order;
	Orderstate state;
	Credit credit;
	public OrderManagementController() throws RemoteException{
		list=new OrderList();
		order=new OrderLineItem();
		credit=Credit.getInstance();
	}
	/**
     * 获得一个客户的所有订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAllorder(String userid){
		return list.showAllorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有未执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showUndoneorder(String userid){
		return list.showUndoneorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有已执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showDoneorder(String userid){
		return list.showDoneorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有异常订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAbnormalorder(String userid){
		return list.showAbnormalorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有撤销订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showCancelorder(String userid){
		return list.showCancelorder(userid);
	}
	
	
	/**
     * 客户撤销订单
     * 
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
     * @return boolean ,如果需要扣除信用值则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean cancel(String userid,String orderID){
		state=new Orderstate(orderID);
		return state.cancel();
	}
	
	
	/**
     * 显示订单的详细信息
     * 
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
     * @return OrderVO ,一个订单
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String userID,String orderID){
		return order.showDetail(userID, orderID);		
	}
	
	/**
	 * 当客户撤销订单需要扣除信用值时，扣除信用值。
	 * @param userID String,客户id
	 * @param orderID String,订单id
	 * @param value int,订单的价值
	 */
	public void updateCredit(String userID,String orderID, int value){		
		 try {
				credit.updateCredit(new CreditRecordVO(userID,Calendar.getInstance(),orderID,Operate.Cancel, -value/2, credit.showCredit(userID)-value/2));
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	/**
	 * 根据订单编号获取客户账户
	 * @param orderNo String型，订单编号
	 * @return String返回拥有此订单的账号
	 */
	public String getUserID(String orderNo) {
		return order.getUserID(orderNo);
	}
}
