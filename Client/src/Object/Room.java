package Object;

import java.io.Serializable;
import java.util.List;

import LineItem.RoomLineItem;
import List.OrderList;
import List.RoomList;
import common.ResultMessage;

/**
 * 房间的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	private String roomId;
    private String roomStatue;
    private String roomType;
    private int roomS;
    private int roomPrice;
    /**
	 * 构造房间的数据实体
	 * @param roomid String型，数据层传来的房间号
	 * @param roomstatue String型，数据层传来的房间状态
	 * @param roomtype String型，数据层传来的房间类型
	 * @param rooms int型，数据层传来的房间数量
	 * @param roomprice int型，数据层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public Room (String roomid,String roomstatue,String roomtype,int rooms,int roomprice){
	    roomId=roomid;
	    roomStatue=roomstatue;
	    roomType=roomtype;
	    roomS=rooms;
	    roomPrice=roomprice;
    }
    /**
	 * 构造房间的数据实体
	 * @return
	 */
    public Room (){
	    
    }
    /**
	 * 获取房间号
	 * @param
	 * @return 返回房间号
	 * @throws
	 * @see
	 */
    public String getroomId() {
    	return roomId;
    } 
    /**
	 * 设置房间号
	 * @param id String型，逻辑层传来的房间号
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomId (String id){
    	roomId=id;
    }
    /**
	 * 获取房间状态
	 * @param
	 * @return 返回房间状态
	 * @throws
	 * @see
	 */
    public String getroomStatue() {
    	return roomStatue;
    }
    /**
	 * 设置房间状态
	 * @param sta String型，逻辑层传来的房间状态
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomStatue (String sta){
    	roomStatue=sta;
    }
    /**
	 * 获取房间类型
	 * @param
	 * @return 返回房间类型
	 * @throws
	 * @see
	 */
    public String getroomType() {
    	return roomType;
    }
    /**
	 * 设置房间类型
	 * @param type String型，逻辑层传来的房间类型
	 * @return 
	 * @throws
	 * @see
	 */
    public void setroomType (String type){
		roomType=type;
	}
    /**
	 * 获取房间数量
	 * @param
	 * @return 返回房间数量
	 * @throws
	 * @see
	 */
    public int getroomS() {
		return roomS;
	}
    /**
	 * 设置房间数量
	 * @param room int型，逻辑层传来的房间数量
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomS (int room){
		roomS=room;
	}
    /**
	 * 获取房间价格
	 * @param
	 * @return 返回房间价格
	 * @throws
	 * @see
	 */
    public int getroomPrice() {
		return roomPrice;
	}
    /**
	 * 设置房间价格
	 * @param price int型，逻辑层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomPrice (int price){
		roomPrice=price;
	}
    
    
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
	 * @param
	 * @return 返回房间价格
	 * @throws
	 * @see
	 */
    public int getPrice() {
    	return roomPrice;
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
    	roomList.addRoomLineItems(new RoomLineItem(new Room(roomid, roomstatue, roomtype, rooms, roomprice)));
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
