package orderAbnormal;

import orderBLImpl.OrderState;
import userBLImpl.CreditRecord;
/**
 * 网站人员对于异常订单申诉成功的订单进行撤销操作
 * 
 * @author lyx
 *
 */
public class OrderAbnormalController{
	OrderState state;
	CreditRecord credit;
	public OrderAbnormalController(){
		credit=new CreditRecord();
	}
	/**
     * 撤销异常订单
     * 
     * @param String orderID,订单的id
	 * @ 
     * @see bussinesslogic.Order
     */
	public void cancelAbnormalOrder(String orderID)  {
	     state=new OrderState(orderID);
	     state.cancelAbnormalOrder();
	}
	/**
	 * 当申诉成功后，为客户恢复信用值
	 * @param userID String,客户id
	 * @param value int,订单的价值
	 */
	public void updateCredit(String userID,int value){		
	      //credit.add(userID, value/2);
	}
}
