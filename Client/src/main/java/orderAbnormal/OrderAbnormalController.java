package orderAbnormal;

import orderBLImpl.OrderState;
/**
 * 网站人员对于异常订单申诉成功的订单进行撤销操作
 * 
 * @author lyx
 *
 */
public class OrderAbnormalController{
	private OrderState state;
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
}
