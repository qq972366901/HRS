package Object;

import LineItem.RoomLineItem;
import List.OrderList;
import List.RoomList;
import VO.RoomVO;
import common.ResultMessage;

/**
 * 房间
 * @author 刘宗侃
 * @version 1.0
 * @see
 */
public class Room {
    
    private RoomList roomList;
    private OrderList orderList;
    /**
   	 * 获得房间列表
   	 * @param rl RoomList型，对应的房间列表
   	 * @return
   	 */
    public void addRoomList(RoomList rl) {
    	roomList = rl;
    }
    /**
   	 * 获得订单列表
   	 * @param ol OrderList型，对应的订单列表
   	 * @return
   	 */
    public void addOrderList(OrderList ol) {
    	orderList = ol;
    }
    /**
	 * 获取房间价格
	 * @param rvo RoomVo型
	 * @return 返回房间价格
	 * @throws
	 * @see
	 */
    public int getPrice(RoomVO rvo) {
    	return roomList.getPrice(rvo);
    }
    /**
   	 * 获得房间列表
   	 * @param
   	 * @return 对应的房间列表
   	 */
    public int getRoom() {
    	return roomList.getRoom();
    }
    /**
	 * 添加房间
	 * @param roomid String型，房间号
	 * @param roomstatue String型，房间状态
	 * @param roomtype String型，房间类型
	 * @param rooms int型，房间数量
	 * @param roomprice int型，房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public int messageAdd(String roomid, String roomstatue, String roomtype, int rooms, int roomprice) {
    	roomList.addRoomLineItems(new RoomLineItem(new RoomVO(roomid, roomstatue, roomtype, rooms, roomprice)));
    	return roomList.getRoom();
    }
    /**
	 * 更新房间
	 * @param roomid String型，房间号
	 * @param roomstatue String型，房间状态
	 * @param roomtype String型，房间类型
	 * @param rooms int型，房间数量
	 * @param roomprice int型，房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public ResultMessage messageUpdate(RoomLineItem rli,String roomid, String roomstatue, String roomtype, int rooms, int roomprice) {
    	roomList.messageUpdate(roomid, roomstatue, roomtype, rooms, roomprice);
    	return ResultMessage.Exist;
    }
    /**
	 * 获取订单信息
	 * @param
	 * @return 返回订单信息
	 * @throws
	 * @see
	 */
    public int getOrderInfo() {
    	
    	return orderList.getOrderInfo();
    }

}
