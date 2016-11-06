package Object;

import java.util.List;

import LineItem.CreditRecordLineItem;
import LineItem.HotelLineItem;
import LineItem.OrderLineItem;
import LineItem.RoomLineItem;
import LineItem.UserLineItem;
import List.HotelList;
import List.OrderList;
import List.RoomList;
import List.UserList;

import java.util.Date;
import VO.HotelVO;
import VO.OrderVO;
import VO.UserVO;
import common.Choice;
import common.ResultMessage;
/**
 * Order
 * @author 刘宇翔
 * @version 1.0
 * @see
 */
public class Order {
	private static final long serialVersionUID = 1L;
	private String orderNumber;
	private int orderState;
	private int orderValue;
	private int numOfPerson;
	private boolean child;
	private String roomType;
	private int roomNumber;
	private Date expectedCheckIn;
	private Date expectedCheckOut;
	private Date latest;
	private Date cancel;
	private String comment;
	private int score;	
	private String userID;
	/**
	 * 构造订单数据实体
	 * @param oNum String型，逻辑层传来的订单编号
	 * @param state int型，逻辑层传来的订单状态
	 * @param value int型，逻辑层传来的订单价值
	 * @param pnum int型，逻辑层传来的人数
	 * @param ch boolean型，逻辑层传来的有无儿童
	 * @param rType String型，逻辑层传来的房间类型
	 * @param rNum int型，逻辑层传来的订购数量
	 * @param in Date型，逻辑层传来的预订入住时间
	 * @param out Date型，逻辑层传来的预订离开时间
	 * @param la Date型，逻辑层传来的最晚执行时间
	 * @param comm String型，逻辑层传来的订单评价
	 * @param sco int型，逻辑层传来的订单评分
	 * @param cancel Date型，逻辑层传来的撤销时间
	 * @return
	 * @throws
	 * @see
	 */
	public Order (String oNum, int state, int value, int pnum,boolean ch,String rType, int rNum, Date in, Date out,Date la, String comm, int sco,Date cancel) {
		
		orderNumber = oNum;
		orderState = state;
		orderValue = value;
		numOfPerson=pnum;
		child=ch;
		roomType = rType;
		roomNumber = rNum;
		expectedCheckIn = in;
		expectedCheckOut = out;
		latest=la;
		comment = comm;
		score = sco;
        this.cancel=cancel;
	}
	public Order(){}
	/**
	 * 获取撤销时间
	 * @param
	 * @return 返回时间
	 * @throws
	 * @see
	 */
	public Date getcancel() {
		return cancel;
	}
	/**
	 * 获取订单编号
	 * @param
	 * @return 返回订单编号
	 * @throws
	 * @see
	 */
	public void setcancel(Date t) {
		cancel=t;
	}
	/**
	 * 获取订单编号
	 * @param
	 * @return 返回订单编号
	 * @throws
	 * @see
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 获取订单状态
	 * @param
	 * @return 返回订单状态
	 * @throws
	 * @see
	 */
	public int getOrderState() {
		return orderState;
	}
	/**
	 * 获取订单价值
	 * @param
	 * @return 返回订单价值
	 * @throws
	 * @see
	 */
	public int getOrderValue() {
		return orderValue;
	}
	/**
	 * 获取人数
	 * @param
	 * @return 返回人数
	 * @throws
	 * @see
	 */
	public int getNumOfPerson(){
		return numOfPerson;
	}
	/**
	 * 获取有无儿童
	 * @param
	 * @return 返回有无儿童
	 * @throws
	 * @see
	 */
	public boolean getChild(){
		return child;
	}
	/**
	 * 获取房间类型
	 * @param
	 * @return 返回房间类型
	 * @throws
	 * @see
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * 获取订购数量
	 * @param
	 * @return 返回订购数量
	 * @throws
	 * @see
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	/**
	 * 获取预订入住时间
	 * @param
	 * @return 返回预订入住时间
	 * @throws
	 * @see
	 */
	public Date getExpectedCheckIn() {
		return expectedCheckIn;
	}
	/**
	 * 获取预订离开时间
	 * @param
	 * @return 返回预订离开时间
	 * @throws
	 * @see
	 */
	public Date getExpectedCheckOut() {
		return expectedCheckOut;
	}
	/**
	 * 获取最晚执行时间
	 * @param
	 * @return 返回最晚执行时间
	 * @throws
	 * @see
	 */
	public Date getLatest(){
		return latest;
	}
	/**
	 * 获取订单评价
	 * @param
	 * @return 返回订单评价
	 * @throws
	 * @see
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 获取订单评分
	 * @param
	 * @return 返回订单评分
	 * @throws
	 * @see
	 */
	public int getScore() {
		return score;
	}
	/**
	 * 设置订单编号
	 * @param oNum String型，逻辑层传来的订单编号
	 * @return
	 * @throws
	 * @see
	 */
	public void setOrderNumber(String oNum) {
		orderNumber = oNum;

	}
	/**
	 * 设置订单状态
	 * @param state int型，逻辑层传来的订单状态
	 * @return
	 * @throws
	 * @see
	 */
	public void setOrderState(int state) {
		orderState = state;
	}

	/**
	 * 设置订单价值
	 * @param value int型，逻辑层传来的订单价值
	 * @return
	 * @throws
	 * @see
	 */
	public void setOrderValue(int value) {
		orderValue = value;
	}
	/**
	 * 设置人数
	 * @param pnum int型，逻辑层传来的人数
	 * @return
	 * @throws
	 * @see
	 */
	public void setNumOfPerson(int num){
		numOfPerson=num;
	}
	/**
	 * 设置有无儿童
	 * @param ch boolean型，逻辑层传来的有无儿童
	 * @return
	 * @throws
	 * @see
	 */
	public void setChild(boolean ch){
		child=ch;
	}
	/**
	 * 设置房间类型
	 * @param rType String型，逻辑层传来的房间类型
	 * @return
	 * @throws
	 * @see
	 */
	public void setRoomType(String rType) {
		roomType = rType;
	}
	/**
	 * 设置订购数量
	 * @param rNum int型，逻辑层传来的订购数量
	 * @return
	 * @throws
	 * @see
	 */
	public void setRoomNumber(int rNum) {
		roomNumber = rNum;
	}
	/**
	 * 设置预订入住时间
	 * @param in Time型，逻辑层传来的预订入住时间
	 * @return
	 * @throws
	 * @see
	 */
	public void setExpectedCheckIn(Date in) {
		expectedCheckIn = in;
	}
	/**
	 * 设置最晚执行时间
	 * @param la Time型，逻辑层传来的最晚执行时间
	 * @return
	 * @throws
	 * @see
	 */
	public void setLatest(Date la){
		latest=la;
	}
	/**
	 * 设置预订入住时间
	 * @param out Time型，逻辑层传来的预订离开时间
	 * @return
	 * @throws
	 * @see
	 */
	public void setExpectedCheckOut(Date out) {
		expectedCheckOut = out;
	}
	/**
	 * 设置订单评价
	 * @param comm String型，逻辑层传来的订单评价
	 * @return
	 * @throws
	 * @see
	 */
	public void setComment(String comm) {
		comment = comm;
	}
	/**
	 * 设置订单评分
	 * @param sco int型，逻辑层传来的订单评分
	 * @return
	 * @throws
	 * @see
	 */
	public void setScore(int sco) {
		score = sco;
	}
	OrderLineItem orderitem;
	CreditRecordLineItem credititem;
	UserLineItem useritem;
	RoomLineItem roomitem;
	OrderList orderlist;
	RoomList roomlist;
	UserList userlist;
	HotelList hotellist;
	HotelLineItem hotelitem;
	User user;
	public void addorderlist(OrderList list){
		orderlist=list;
	}
	public void addorderuser(UserLineItem use){
		useritem=use;
	}
	public void addordcredit(CreditRecordLineItem use){
		credititem=use;
	}
	/**
     * 显示所有订单信息
     * 
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */

	public List<OrderLineItem> show(){
		return  orderlist.show();
	}
	
	
	/**
     * 显示订单中关于房间的信息
     * 
     * @param vo OrderVO型，一个订单的值对象
     * @return 返回ResultMessage的一个枚举值
     * @see bussinesslogic.Order
     */
	public ResultMessage getRoomInfo(Order vo){
		return ResultMessage.Exist;
	}
	
	/**
     * 显示用户的所有历史订单
     * 
     * @param vo UserVO型，一个客户的值对象
     * @return ArrayList<Hotel> ，一个订单的列表
     * @see bussinesslogic.Order
     */
	public List<OrderLineItem> gethistory(UserVO vo){
		return  orderlist.gethistory(vo);
	}
	
	
	/**
     * 显示选中的酒店的所有历史订单
     * 
     * @param vo HotelVO型，一个酒店的值对象
     * @return ArrayList<Order> ，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public List<OrderLineItem> findByType(HotelVO vo){
		return orderlist.gethotel(vo);
	}
	
	
	/**
     * 根据选择的类型查找所有订单，并显示
     * 
     * @param type String型，一种订单的类型
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public List<OrderLineItem> findByType(String type){
		return orderlist.find(type);
	}
	
	
	/**
     * 根据订单号查找订单详情，并显示
     * 
     * @param orderID String型，订单号
     * @return OrderVO，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public OrderLineItem showDetail(String orderID){
		return orderlist.showdetail(orderID);
	}
	
	
	/**
     * 将一个订单类型变为已撤销，并保存撤销时间
     * 
     * @param orderID String型，订单号
     * @param currentTime Time型，当前时间
     * @see bussinesslogic.Order
     */
	public void cancelOrder(String orderID,Date currentTime){
		orderlist.cancel(orderID,currentTime);
	}
	
	
	/**
     * 进行撤销订单的操作
     * 
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void duduct(OrderVO order){
		orderlist.cancel();
	}
	
	
	/**
     * 判断订单是否已被撤销
     * 
     * @param orderID String型，客户编号
     * @param currentTime Time型，撤销订单的时间
     * @return 若已撤销则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public Boolean whetherDeduct(Date currentTime,String orderID){
		orderitem=orderlist.showdetail(orderID);
		if(orderitem.getcancel()==currentTime){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
     * 生成一个订单对象
     * 
     * @param currentTime Time型，当前时间
     * @param in Time型，入住时间
     * @param out Time型，离开时间
     * @param ddl Time型，预计离开时间
     * @param roomType RoomType型，房间类型
     * @param num int型，房间号
     * @param numOfPerson int型，住店人数
     * @param hasChild Boolean型，是否有小孩
     * @see bussinesslogic.Order
     */
	public void makeOrder(Date currentTime,
			Date in,Date out,Date ddl,
			String roomType,int num,
			int numOfPerson,
			boolean haveChild ) {
		Order b=new Order();
	    OrderLineItem a=new OrderLineItem(b);
		a.getorder().setExpectedCheckIn(in);
		a.getorder().setExpectedCheckOut(out);
		a.getorder().setLatest(ddl);
		a.getorder().setRoomType(roomType);
		a.getorder().setNumOfPerson(numOfPerson);
		a.getorder().setRoomNumber(num);
		a.getorder().setChild(haveChild);
		orderlist.addOrderLineItems(a);
	}
	
	
	
	/**
     * 判断订单是否生成
     * 
     * @param userID String型，客户编号
     * @return 若已生成则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean whetherMake(String uerID){
		return true;
	}
	
	
	
	/**
     * 更改订单状态为已执行，为客户增加信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void done(String orderID,String userID){
		orderlist.find(userID,orderID).getorder().setOrderState(1);
		credititem.getUser().setCurrentcredit(2);
		useritem.getUser().setLevel(2);
	}
	
	
	/**
     * 更新订单类型为异常，为客户减去信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void abnormalOrder(String orderID,String userID){
		orderlist.find(userID,orderID).getorder().setOrderState(1);
		credititem.getUser().setCurrentcredit(1);
		useritem.getUser().setLevel(1);
	}
	
	
	/**
     * 更新订单类型为已执行，为客户恢复信用值，更新会员等级  
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void delayIn(String orderID,String userID){
		orderlist.find(userID,orderID).getorder().setOrderState(3);
		credititem.getUser().setCurrentcredit(3);
		useritem.getUser().setLevel(3);
	}
	
	
	/**
     * 结束订单执行任务，持久化更新涉及的领域对象的数据 系统结束
     * 
     * @see bussinesslogic.Order
     */
	public ResultMessage endExecute() {
		return ResultMessage.Exist;
	}
	
	
	/**
     * 更新订单信息并显示评价
     * 
     * @param comment String型，客户评价
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void comment(String comment,Order order){
		orderitem=new OrderLineItem(order);
		orderitem.getorder().setComment(comment);
	}
	
	
	/**
     * 根据输入的ID查找订单并显示
     * 
     * @param ID String型，订单号
     * @return OrderVO，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public OrderLineItem findByID(String ID){
		return orderlist.findByID(ID);
	}
	
	
	/**
     * 恢复客户信用值，更新会员等级
     * 
     * @param vo OrderVO型，订单的值对象
     * @param choice Choice型，一个枚举值
     * @see bussinesslogic.Order
     */
	public void regain(OrderVO vo,Choice choice){
		credititem.getUser().setCurrentcredit(3);
		useritem.getUser().setLevel(3);
	}
	
	
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @param userID String型，客户编号
     * @return long，订单的价值
     * @see bussinesslogic.Order
     */
	public long getPrice(Order vo,String userID){
		orderitem=new OrderLineItem(vo);
		return orderitem.getorder().getOrderValue();
	}
	
	
	/**
     * 未支付订单
     * 
     * @param vo OrderVO型，订单的值对象
     * @return ResultMessage的一个枚举值
     * @see bussinesslogic.Order
     */
	public ResultMessage payment(OrderVO vo){
		return ResultMessage.Exist;
	}
}
