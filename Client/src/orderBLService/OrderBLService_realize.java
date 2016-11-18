package orderBLService;

import java.util.ArrayList;
import java.util.List;

import Object.Hotel;
import Object.RoomType;
import Object.Time;
import VO.HotelVO;
import VO.OrderVO;
import VO.UserVO;
import common.Choice;
import common.ResultMessage;

public class OrderBLService_realize implements OrderBLService{
    public OrderBLService_realize(int hotelId) {
		// TODO Auto-generated constructor stub
	}


	/**
     * 显示所有订单信息
     * 
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public ArrayList<OrderVO> show(int hotelid){
		return null;
	}
	
	
	/**
     * 显示订单中关于房间的信息
     * 
     * @param vo OrderVO型，一个订单的值对象
     * @return 返回ResultMessage的一个枚举值
     * @see bussinesslogic.Order
     */
	public ResultMessage getRoomInfo (OrderVO vo) {
		return null;
	}
	
	
	/**
     * 关闭订单界面
     * 
     * @see bussinesslogic.Order
     */
	public void cancel() {
	}
	
	
	/**
     * 显示订单中关于房间的信息
     * 
     * @param vo UserVO型，一个客户的值对象
     * @return ArrayList<Hotel> ，一个酒店的列表
     * @see bussinesslogic.Order
     */
	public ArrayList<Hotel> gethistory(UserVO vo) {
		return null;
	}
	
	
	/**
     * 显示选中的酒店的所有历史订单
     * 
     * @param vo HotelVO型，一个酒店的值对象
     * @return ArrayList<Order> ，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public ArrayList<OrderVO> findByType(HotelVO vo) {
		return null;
	}
	
	
	/**
     * 根据选择的类型查找所有订单，并显示
     * 
     * @param type String型，一种订单的类型
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public ArrayList<OrderVO> findByType(String type) {
		return null;
	}
	
	
	/**
     * 根据订单号查找订单详情，并显示
     * 
     * @param orderID String型，订单号
     * @return OrderVO，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String orderID) {
		return null;
	}
	
	
	/**
     * 将一个订单类型变为已撤销，并保存撤销时间
     * 
     * @param orderID String型，订单号
     * @param currentTime Time型，当前时间
     * @see bussinesslogic.Order
     */
	public void cancelOrder(String orderID,Time currentTime) {
	}
	
	
	/**
     * 进行撤销订单的操作
     * 
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void duduct(OrderVO order) {
	}
	
	
	/**
     * 判断订单是否已被撤销
     * 
     * @param orderID String型，客户编号
     * @param currentTime Time型，撤销订单的时间
     * @return 若已撤销则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public Boolean whetherDeduct(Time currentTime,String orderID) {
		return null;
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
	public void makeOrder(Time currentTime,
			Time in,Time out,Time ddl,
			RoomType roomType,int num,
			int numOfPerson,
			boolean haveChild ) {
	}
	
	
	
	/**
     * 判断订单是否生成
     * 
     * @param userID String型，客户编号
     * @return 若已生成则返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean whetherMake(String uerID) {
		return false;
	}
	
	
	
	/**
     * 更改订单状态为已执行，为客户增加信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void done(String orderID,String userID) {
	}
	
	
	/**
     * 更新订单类型为异常，为客户减去信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void abnormalOrder(String orderID,String userID) {
	}
	
	
	/**
     * 更新订单类型为已执行，为客户恢复信用值，更新会员等级  
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void delayIn(String orderID,String userID) {
	}
	
	
	/**
     * 结束订单执行任务，持久化更新涉及的领域对象的数据 系统结束
     * 
     * @see bussinesslogic.Order
     */
	public void endExecute() {
	}
	
	
	/**
     * 更新订单信息并显示评价
     * 
     * @param comment String型，客户评价
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void comment(String comment,OrderVO order) {
	}
	
	
	/**
     * 根据输入的ID查找订单并显示
     * 
     * @param ID String型，订单号
     * @return OrderVO，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public OrderVO findByID(String ID) {
		return null;
	}
	
	
	/**
     * 恢复客户信用值，更新会员等级
     * 
     * @param vo OrderVO型，订单的值对象
     * @param choice Choice型，一个枚举值
     * @see bussinesslogic.Order
     */
	public void regain(OrderVO vo,Choice choice) {
	}
	
	
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @param userID String型，客户编号
     * @return long，订单的价值
     * @see bussinesslogic.Order
     */
	public long getPrice(OrderVO vo,String userID) {
		return 0;
	}
	
	
	/**
     * 计算订单价值并显示
     * 
     * @param vo OrderVO型，订单的值对象
     * @return ResultMessage的一个枚举值
     * @see bussinesslogic.Order
     */
	public ResultMessage payment(OrderVO vo) {
		return null;
	}


	@Override
	public List<OrderVO> getUnfinishedOrders(int hotelId) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}


	@Override
	public List<OrderVO> getFinishedOrders(int hotelId) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}


	@Override
	public List<OrderVO> getAbnormalOrders(int hotelId) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}
}
