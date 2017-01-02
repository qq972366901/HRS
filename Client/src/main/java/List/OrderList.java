package list;

import java.util.*;

import lineItem.OrderLineItem;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;
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
			if(orders.get(i).gethotelID().equals(name)){
				list.add(orders.get(i));
			}
		}
		return list;
	}
	/**
     * 生成一个订单对象
     * 
     * @param currentTime Time型，当前时间
     * @param in Time型，预计入住时间
     * @param out Time型，预计离开时间
     * @param roomType RoomType型，房间类型
     * @param num int型，房间号
     * @param numOfPerson int型，住店人数
     * @param hasChild Boolean型，是否有小孩
     * @see bussinesslogic.Order
     */
	public void makeOrder(Calendar currentTime,
			Calendar in,Calendar out,
			String roomType,int num,
			int numOfPerson,
			boolean haveChild ) {
	 		OrderVO b=new OrderVO();
	 		b.generationTime=currentTime;
	 		b.expectedCheckIn=in;
	 		b.expectedCheckOut=out;
	 		b.roomType=roomType;
	 		b.roomNumber=num;
	 		b.numOfPerson=numOfPerson;
	 		b.child=haveChild;
	 	    OrderLineItem item=new OrderLineItem(b);
	 	    orders.add(item);
	}
	/**
     * 判断订单是否已被撤销
     * 
     * @param orderID String型，客户编号
     * @param currentTime Time型，撤销订单的时间
     * @return 若已撤销则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public Boolean whetherDeduct(Calendar currentTime,String orderID){
		if(showdetail(orderID).getcancel()==currentTime){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 显示符合条件的订单
	 * @param str String型，类型
	 * @return 返回list
	 */
	public List<OrderLineItem> find(String str) {
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getroomType().equals(str)){
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
			if(orders.get(i).getorderID().equals(orderID)){
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
	public void cancel(String orderID, Calendar currentTime) {
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getorderID().equals(orderID)){
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
			if(orders.get(i).getuserID().equals(userID)&&
					orders.get(i).getorderID().equals(orderID)){
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
			if(orders.get(i).getorderID().equals(iD)){
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
			if(orders.get(i).getuserID().equals(vo.id)){
				list.add(orders.get(i));
			}
		}
		return list;
	}
	public boolean generation (String userID){
		List<OrderLineItem> list=new ArrayList<OrderLineItem>();
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getuserID().equals(userID)){
				list.add(orders.get(i));
			}
		}
		if(list.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}/**
     * 更新订单类型，为客户修改信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	private void update(String orderID,String userID,int state){
		find(userID,orderID).upCalendar(orderID,userID,state);
	}
	public void updatedone(String orderID,String userID){
		update(orderID,userID,3);
	}
	public void updateabnormal(String orderID,String userID){
		update(orderID,userID,1);
	}
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @param userID String型，客户编号
     * @return long，订单的价值
     * @see bussinesslogic.Order
     */
	public long getPrice(String orderID,String userID){
		return find(userID, orderID).getprice();
	}
	/**
     * 更新订单信息并显示评价
     * 
     * @param comment String型，客户评价
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void comment(String comment,OrderVO vo){
		find(vo.userID,vo.orderNumber).comment(comment);
	}
	private OrderLineItem find(OrderVO vo){
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getorderID().equals(vo.orderNumber)&&
					orders.get(i).getuserID().equals(vo.userID)){
				return orders.get(i);
			}
		}
		return null;
	}
	
}
