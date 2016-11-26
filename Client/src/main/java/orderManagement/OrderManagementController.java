package orderManagement;

import java.util.List;

import VO.OrderVO;
import orderBLImpl.OrderLineItem;
import orderBLImpl.OrderList;
import orderBLImpl.OrderState;
/**
 * 客户的个人订单管理
 * 可以查看不同类型的订单，并对于一些未执行订单进行撤销操作
 * @author Lyx
 *
 */
public class OrderManagementController{
	OrderList list;
	OrderLineItem order;
	OrderState state;
	public OrderManagementController(){
		list=new OrderList();
		order=new OrderLineItem();
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
		state=new OrderState(orderID);
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
	 * @param value int,订单的价值
	 */
	public void updateCredit(String userID,int value){		
	    //credit.add(userID,-value);
	}
}
