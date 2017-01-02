package orderBuild;

import orderBLImpl.OrderLineItem;
import roomBLServiceImpl.RoomAvailableJudge;
import vo.OrderVO;
/**
 * 生成订单
 * 判断订单是否能够执行，倘若能够执行，那么记录订单信息并保存到数据库中
 * @author lyx
 *
 */
public class OrderBuildController{
	OrderLineItem order;
	RoomAvailableJudge room;
	public OrderBuildController() {
		order=new OrderLineItem();
	}
	/**
     * 保存订单信息
     * 
     * @param String orderID,订单的id
	 * @ 
     * @see bussinesslogic.Order
     */
	public  void saveOrderInfo(OrderVO vo) {
		order.saveOrderInfo(vo);
	}
	
	/**
	 * 
	 * @param inTime Calendar，预订的入住时间
	 * @param outTime Calendar，预计离开时间
	 * @param numsOfRoom int，需要的房间数量
	 * @param RoomType String，房间的类型
	 * @param hotelID String，酒店的id
	 * @return boolean，能生成则返回true，若没有房间则返回false
	 */
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID){
		room=RoomAvailableJudge.getRoomAvailableJudgeInstance(hotelID);
		return room.whetherSuccess(RoomType, numsOfRoom);
	}	
}
