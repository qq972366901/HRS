package roomUpdate;

import RoomBLServiceImpl.RoomStateChange;
import RoomBLServiceImpl.RoomsReserved;

public class RoomUpdateController{
	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomType String型，房型
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber, String roomType, String roomState) {
		RoomStateChange roomStateChange = RoomStateChange.getRoomStateChangeInstance(hotelID);
		roomStateChange.updateRoomState(roomNumber, roomType, roomState);
	}
	/**
     * 客户下单更新酒店被预定的房间的状态
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber int型，预定的房间数量
     */
	public void updateRoomState(String hotelID, String roomType,int roomNumber) {
		RoomsReserved roomsReserved = RoomsReserved.getRoomsReservedInstance(hotelID);
		roomsReserved.updateRoomsState(roomType, roomNumber);
	}
	
}
