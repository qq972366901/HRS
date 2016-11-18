package List;

import java.util.*;

import LineItem.RoomLineItem;
import Object.Order;
import VO.OrderVO;
import VO.RoomVO;
/**
 * 房间列表
 * @author 刘宗侃
 * @version 1.0
 * @see
 */
public class RoomList {

	List<RoomLineItem> rooms;
	
	/**
	 * 房间列表
	 * @param
	 * @return
	 */
	public RoomList () {
		
		rooms = new ArrayList<RoomLineItem>();
		
	}
	
	/**
	 * 添加单个房间
	 * @param rli RoomLineItem型，添加的单个房间 
	 * @return 
	 */
	public void addRoomLineItems(RoomLineItem  rli) {
		rooms.add(rli);
	}
	
	/**
	 * 得到房间价格
	 * @param rvo RoomVO型
	 * @return 返回房间价格
	 */
	public int getPrice(RoomVO rvo) {
		return 300;
	}
	
	/**
	 * 得到房间列表数量
	 * @param
	 * @return 返回房间列表数量
	 */
	public int getRoom() {
		return rooms.size();
	}
	
	/**
	 * 更新房间信息
	 * @param roomid String型，房间号
	 * @param roomstatue String型，房间状态
	 * @param roomtype String型，房间类型
	 * @param rooms int型，房间数量
	 * @param roomprice int型，房间价格
	 * @return
	 */
	public void messageUpdate(String roomid, String roomstatue, String roomtype, int rooms, int roomprice) {
		this.rooms.add(new RoomLineItem(new RoomVO(roomid, roomstatue, roomtype, rooms, roomprice)));
	}

	/**
	 * 得到房间列表数量
	 * @param
	 * @return 返回房间列表数量
	 */
	public int getRoomInfo() {
		return rooms.size();
	}
	/**
	 * 得到房间列表数量
	 * @param
	 * @return 返回房间列表数量
	 */
	public int getRoomInfo(OrderVO vo){
		return  0;
	}
}










