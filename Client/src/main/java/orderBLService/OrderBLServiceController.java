package orderBLService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import VO.OrderVO;
import common.Operate;
import orderAbnormal.OrderAbnormalController;
import orderBuild.OrderBuildController;
import orderEvaluation.OrderEvaluationController;
import orderExecute.OrderExecuteController;
import orderManagement.OrderManagementController;
import orderOverview.OrderOverviewController;

public class OrderBLServiceController implements OrderBLService{
	private OrderBuildController build;
	private OrderEvaluationController evaluation;
	private OrderExecuteController execute;
	private OrderManagementController management;
	private OrderOverviewController overview;
	private OrderAbnormalController abnormal;
	public OrderBLServiceController() throws RemoteException {
		build = new OrderBuildController();
		evaluation= new OrderEvaluationController();
		execute= new OrderExecuteController();
		management= new OrderManagementController();
		overview= new OrderOverviewController();
		abnormal=new OrderAbnormalController();	 
	}	
	
	/**
     * 获得一个客户的所有订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAllorder(String userid){
		return management.showAllorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有未执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showUndoneorder(String userid){
		return management.showUndoneorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有已执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showDoneorder(String userid){
		return management.showDoneorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有异常订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAbnormalorder(String userid){
		return management.showAbnormalorder(userid);
	}
	
	
	/**
     * 获得一个客户的所有撤销订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showCancelorder(String userid){
		return management.showCancelorder(userid);
	}
	
	
	/**
     * 客户撤销订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
     * @return boolean 如果需要扣除信用值，返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean cancel(String userid,String orderID){
		return management.cancel(userid, orderID);
	}
	
	
	/**
     * 显示订单的详细信息
     * 
     * @param String OrderID，订单的id
     * @return OrderVO ,一个订单
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String orderID){
		return management.showDetail( orderID);	
	}
	
	
	/**
     * 更新客户评论
     * 
     * @param String comment,客户的评论
     * @param int score,客户的评分
     * @param String OrderID，订单的id
     * @see bussinesslogic.Order
     */
	public void updatecomment(String comment,int score,String orderID){
		evaluation.updatecomment(comment, score, orderID);
	}
	
	
	
	/**
     * 获得一个酒店的所有订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAllOrders(String hotelId){
		return overview.getAllOrders(hotelId);
	}
	/**
     * 获得一个酒店的所有未执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getUnfinishedOrders(String hotelId) {
		return overview.getUnfinishedOrders(hotelId);
	}
	
	
	
	/**
     * 获得一个酒店的所有已执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getFinishedOrders(String hotelId) {
		return overview.getFinishedOrders(hotelId);
	}
	
	
	/**
     * 获得一个酒店的所有异常订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAbnormalOrders(String hotelId) {
		return overview.getAbnormalOrders(hotelId);
	}
	
	
	/**
     * 处理未执行订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID，订单的id
     * @return boolean值,处理成功返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean processUnfinishedOrder(String orderId) {
		return execute.processUnfinishedOrder(orderId);
	}
	
	/**
     * 酒店人员处理异常订单，延迟入住(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID,订单的id
     * @param Calendar delayTime,延时入住的时间
     * @return boolean值,处理成功返回true，否则返回false
     * @see bussinesslogic.Order
     */
	public boolean processAbnormalOrder(String orderId,Calendar delayTime) {
		return execute.processAbnormalOrder(orderId, delayTime);
	}
	
	/**
     * 网站营销人员撤销异常订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @param String orderID,订单的id
     * @see bussinesslogic.Order
     */
	public void cancelAbnormalOrder(String orderID) {
	    abnormal.cancelAbnormalOrder(orderID);
	}
	
	/**
     * 保存订单信息
     * 
     * @param OrderVO vo,一个Order的值对象
     * @see bussinesslogic.Order
     */
	public  void saveOrderInfo(OrderVO vo){	
	      build.saveOrderInfo(vo);
	}
	
	
	/**
	 * 获取酒店的所有客户评论和评分
	 * 
	 * @param String HotelID ,酒店的ID
	 * @return List<CommentVO> 一个评价的列表;
	 * @throws RemoteException 
	
	public List<CommentVO> getHotelComment(String HotelID) throws RemoteException{
		List<CommentVO> commentlist=new ArrayList<CommentVO>();
		return commentlist;
	}
	 */


	/**
	 * 
	 * @param numsOfRoom int，需要的房间数量
	 * @param RoomType String，房间的类型
	 * @param hotelID String，酒店的id
	 * @return boolean，能生成则返回true，若没有房间则返回false
	 */
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID){
		return build.whetherMake(numsOfRoom, RoomType, hotelID);
	}
	
	/**
	 * 根据不同操作更新客户的信用值(操作详情请看common包)
	 * @param userID String,客户id
	 * @param value int,订单的价值
	 * @param orderID String,订单id
	 * @param operate Operate枚举类，操作的名字
	 */
	public void updateCredit(String userID,String orderID,int value,Operate operate){
		if(operate.equals(Operate.Done)){
			execute.updateCredit(userID, orderID,value);
		}
		else if(operate.equals(Operate.Cancel)){
			management.updateCredit(userID, orderID,value);
		}
		else if(operate.equals(Operate.Delayed)){
			execute.recoveryCredit(userID, orderID,value);
		}
	}
	/**
	 * 获取一个酒店所有已撤销订单
	 */
	@Override
	public List<OrderVO> getCanceledOrders(String hotelId) {
		return overview.getCancelOrders(hotelId);
	}
	/**
	 * 根据订单编号获取客户账户
	 */
	@Override
	public String getUserID(String orderNo) {
		return management.getUserID(orderNo);
	}

}
