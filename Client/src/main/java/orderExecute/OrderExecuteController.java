package orderExecute;

import java.util.Calendar;
import orderBLImpl.OrderState;
/**
 * 酒店工作人员对订单的操作
 * 对于未执行订单，将其状态更改为已执行，并为客户增加相应价值的信用值
 * 对于延迟入住，更改最晚执行时间，恢复客户信用值
 * @author lyx
 *
 */
public class OrderExecuteController{
	OrderState state;
	public OrderExecuteController() {
	}
	/**
     * 处理未执行订单
     * 
     * @param String orderID，订单的id
     * @return boolean值,处理成功返回true，否则返回false
	 * @ 
     * @see bussinesslogic.Order
     */
	public boolean processUnfinishedOrder(String orderId)  {
		state=new OrderState(orderId);
		return state.processUnfinishedOrder();
	}
	/**
	 * 当酒店将客户订单从未执行变为已执行时，为客户增加信用值
	 * @param userID String,客户id
	 * @param value int,订单的价值
	 */
	public void updateCredit(String userID,int value){		
		//credit.add(userID,value);
	}

	
	/**
     * 处理异常订单/订单延期
     * 
     * @param String orderID,订单的id
     * @param Calendar delayTime,延时入住的时间
     * @return boolean值,处理成功返回true，否则返回false
	 * @ 
     * @see bussinesslogic.Order
     */
	public boolean processAbnormalOrder(String orderId,Calendar delayTime)  {
		state=new OrderState(orderId);
		return state.processAbnormalOrder(delayTime);
	}
	/**
	 * 当客户申请延期入住的时候，为客户恢复信用值
	 * @param userID String,客户id
	 * @param value int,订单的价值
	 */
	public void recoveryCredit(String userID,int value){
		//credit.add(userID,value);
	}
}
