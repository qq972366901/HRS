package VO;
import java.sql.Time;
import Object.Order;

/**
 * 订单的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Order
 */

public class OrderVO extends VO {

	public String orderNumber;
	public int orderState;
	public int orderValue;
	public int numOfPerson;
	public boolean child;
	public String roomType;
	public int roomNumber;
	public Time expectedCheckIn;
	public Time expectedCheckOut;
	public Time latest;
	public String comment;
	public int score;	

	/**
     * 更新订单信息
     * 
     * @param ord Order型，一个用来更新数据的订单对象
     * @return 
     * @see Object.Order
     */
	public void update(Order ord) {
		
	}
	
	/**
     * 创建订单对象
     * 
     * @return 一个新下的订单
     * @see Object.Order
     */
	public Order makeOrder() {
		
		return new Order();
	}
	
}
