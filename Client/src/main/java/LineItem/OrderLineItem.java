package LineItem;

import java.util.Calendar;
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
     public void cancel(Calendar currentTime){
    	 vo.cancel=currentTime;
    	 vo.orderState=-1;
    	 
     }
     /**
  	 * 获得订单价格
  	 * @return 价格，long
  	 *
  	 */
     public long getprice(){
    	 return vo.orderValue;
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
	public Calendar getcancel() {
		return vo.cancel;
	}
	/**
 	 * 获得订单id
 	 * @return 返回时间
 	 */
	public String getorderID() {
		return vo.orderNumber;
	}
	/**
 	 * 获得用户id
 	 * @return 返回时间
 	 */
	public String getuserID() {
		return vo.userID;
	}
	/**
 	 * 获得酒店id
 	 * @return 返回时间
 	 */
	public String gethotelID() {
		return vo.hotelID;
	}
	/**
 	 * 获得房间类型
 	 * @return 返回时间
 	 */
	public String getroomType() {
		return vo.roomType;
	}
	/**
     *
     * 更新订单类型，为客户修改信用值，更新会员等级 
     * 
     * @param userID String型，客户编号
     * @param orderID String型，订单号
     * @see bussinesslogic.Order
     */
	public void upCalendar(String orderID,String userID,int state){
		vo.credit=state;
		vo.userLevel=state;
		vo.orderState=state;
	}
	/**
     * 更新订单信息并显示评价
     * 
     * @param comment String型，客户评价
     * @param order OrderVO型，一个订单的值对象
     * @see bussinesslogic.Order
     */
	public void comment(String comment){
		vo.comment=comment;
	}
}
