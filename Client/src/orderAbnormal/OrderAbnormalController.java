package orderAbnormal;
import java.util.ArrayList;

import VO.OrderVO;
import common.Choice;
import common.ResultMessage;
import orderBLService.OrderBLService_realize;
public class OrderAbnormalController extends OrderBLService_realize{
	public OrderAbnormalController(int hotelId) {
		super(hotelId);
		// TODO Auto-generated constructor stub
	}
	/**
     * 根据选择的类型查找所有订单，并显示
     * 
     * @param type String型，一种订单的类型
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public ArrayList<OrderVO> findByType(String type) {
		ArrayList<OrderVO> ov=new ArrayList<OrderVO>();
		return ov;
	}
    public ResultMessage getRoomInfo (OrderVO vo) {
		return ResultMessage.Exist;
	}
	
	
	/**
     * 关闭订单界面
     * 
     * @see bussinesslogic.Order
     */
	public void cancel() {
	}
	/**
     * 根据选择的类型查找所有订单，并显示
     * 
     * @param type String型，一种订单的类型
     * @return ArrayList<OrderVO>，一个订单值对象的列表
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String orderID) {
		OrderVO ov=new OrderVO();
		return ov;
	}
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
    public OrderVO findByID(String ID) {
    	OrderVO vo=new OrderVO();
	    return vo;
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
}
