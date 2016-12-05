package HotelRoomAdd;

import HotelBLServiceImpl.HotelRoom;
import hotelBLService.HotelBLServiceController;

public class HotelRoomAddController{
	/**
     * 更新酒店拥有的房间类型、数量、原始价格
     * 
     * @param id String型，酒店帐号
     * @param roomType String型，房间类型
     * @param roomNumber int型，房间数量
     * @param roomPrice int型，房间原始价格
     */
	public void updateHotelRooms(String id, String roomType, int roomNumber, int roomPrice) {
		HotelRoom hotelRoom = HotelRoom.getHotelRoomInstance(id);
		hotelRoom.updateHotelRooms(roomType, roomNumber, roomPrice);
	}
	
}
