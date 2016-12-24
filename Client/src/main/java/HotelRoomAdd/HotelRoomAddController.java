package HotelRoomAdd;

import HotelBLServiceImpl.HotelRoom;

/**负责实现添加酒店房间功能的控制器
 * @author 刘宗侃
 */
public class HotelRoomAddController{
	/**
     * 更新酒店拥有的房间类型、数量、原始价格
     * 
     * @param id String型，酒店帐号
     * @param roomType String型，房间类型
     * @param roomNumber int型，房间数量
     * @param roomPrice int型，房间原始价格
     * @param roomNNN String型，房间号范围
     */
	public void updateHotelRooms(String id, String roomType, int roomNumber, int roomPrice, String roomNNN) {
		HotelRoom hotelRoom = HotelRoom.getHotelRoomInstance(id);
		hotelRoom.updateHotelRooms(roomType, roomNumber, roomPrice, roomNNN);
	}
	
}
