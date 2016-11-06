package LineItem;

import java.util.Date;

import Object.Order;
import VO.OrderVO;
/**
 * OrderLineItem
 * @author 刘宇翔
 * @version 1.0
 * @see
 */
public class OrderLineItem {
     Order order;
     OrderVO vo;

     /**
      * 单个订单
      * @param o Order型，传入订单对象
      * @return 单个订单
      */
     public OrderLineItem(Order o){
    	 order=o;
     }
     public OrderLineItem(OrderVO vo){
    	 this.vo=vo;
     }
     public Order getorder(){
    	 return order;
     }
     /**
 	 * 取消订单
 	 * @param Time，时间
 	 *
 	 */
     public void cancel(Date currentTime){
    	 order.setcancel(currentTime);
    	 order.setOrderState(-1);
     }
     /**
 	 * 取消订单行为
 	 * 
 	 */
     public void cancel(){
    	 order.setOrderState(-1);
     }
     /**
 	 * 获得取消时间
 	 * @return 返回时间
 	 */
	public Date getcancel() {
		return order.getcancel();
	}
	/**
	 * 判断是否完成订单
	 * @param userID
	 * @return 返回bool
	 */
	public boolean complete(String uerID) {
		return true;
	}
}
