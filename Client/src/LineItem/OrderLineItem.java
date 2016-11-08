package LineItem;

import java.util.Date;
import java.util.HashMap;

import Object.Order;
import VO.OrderVO;
/**
 * OrderLineItem
 * @author 刘宇翔
 * @version 1.0
 * @see
 */
public class OrderLineItem {
	OrderVO vo;
     /**
      * 单个订单
      * @param o OrderVO型，传入订单对象
      * @return 单个订单
      */
     public OrderLineItem(OrderVO vo){
    	 this.vo=vo;
     }
     public OrderVO getvo(){
    	 return vo;
     }
     /**
 	 * 取消订单
 	 * @param Time，时间
 	 *
 	 */
     public void cancel(Date currentTime){
    	 vo.cancel=currentTime;
    	 vo.orderState=-1;
    	 
     }
     /**
 	 * 取消订单行为
 	 * 
 	 */
     public void cancel(){
    	 vo.orderState=-1;
     }
     /**
 	 * 获得取消时间
 	 * @return 返回时间
 	 */
	public Date getcancel() {
		return vo.cancel;
	}
}
