package List;

import java.util.*;

import LineItem.OrderLineItem;
import VO.HotelVO;
import VO.UserVO;
/**
 * OrderLIst
 * @author 刘宇翔
 * @version 1.0
 * @see
 */
public class OrderList {
	List<OrderLineItem> orders;	
	/**
	 * 订单列表
	 * @param
	 * @return
	 */
	public OrderList () {		
		orders = new ArrayList<OrderLineItem>();		
	}
	
	/**
	 * 添加单个订单
	 * @param oli OrderLineItem型，添加的单个订单
	 * @return 
	 */
	public void addOrderLineItems(OrderLineItem  oli) {
		orders.add(oli);
	}
	/**
	 * 显示订单列表
	 * @param oli OrderLineItem型，显示的单个订单
	 * @return list列表
	 */
	public List<OrderLineItem> show(){
		return orders;
	}
	/**
	 * 得到订单
	 * @param
	 * @return 返回订单
	 */
	public int getOrderInfo() {
		return orders.size();
	}
	
	/**
	 * 得到订单
	 * @param
	 * @return 返回订单
	 */
	public int getOrder() {
		return orders.size();
	}
	/**
	 * 显示历史订单
	 * @param vo HotelVOt型，酒店
	 * @return 返回list
	 */
	public List<OrderLineItem> gethotel(HotelVO vo) {		
		String name=vo.hotelName;
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().hotelID.equals(name)){
				list.add(orders.get(i));
			}
		}
		return list;
	}
	/**
	 * 显示符合条件的订单
	 * @param str String型，类型
	 * @return 返回list
	 */
	public List<OrderLineItem> find(String str) {
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().roomType.equals(str)){
				list.add(orders.get(i));
			}
		}
		return list;
	}
	/**
	 * 显示符合条件的订单
	 * @param str String型，订单号
	 * @return 返回订单
	 */
	public OrderLineItem showdetail(String orderID) {
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().orderNumber.equals(orderID)){
				return orders.get(i);
			}
		}
		return null;
	}
	/**
	 * 取消订单
	 * @param str String型，id
	 * @param time Time型，撤销时间
	 */
	public void cancel(String orderID, Date currentTime) {
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().orderNumber.equals(orderID)){
				orders.get(i).cancel(currentTime);
			}
		}
	}
	/**
	 * 取消订单
	 *
	 */
	public void cancel() {
		orders.get(0).cancel();
	}
	/**
	 * 查找订单
	 * @param str String型，id
	 * @param str String型，orderid
	 * 
	 */
	public OrderLineItem find(String userID, String orderID) {
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().userID.equals(userID)&&
					orders.get(i).getvo().orderNumber.equals(orderID)){
				return orders.get(i);
			}
		}
		return null;
	}
	/**
	 * 查找订单
	 * @param str String型，id
	 * @return orderItem
	 * 
	 */
	public OrderLineItem findByID(String iD) {
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().orderNumber.equals(iD)){
				return orders.get(i);
			}
		}
		return null;
	}
	/**
	 * 显示历史订单
	 * @param vo UserVOt型，用户
	 * @return 返回list
	 */
	public List<OrderLineItem> gethistory(UserVO vo) {
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().userID.equals(vo.id)){
				list.add(orders.get(i));
			}
		}
		return list;
	}
	public boolean generation (String userID){
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getvo().userID.equals(userID)){
				list.add(orders.get(i));
			}
		}
		if(list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
}
