package roomUpdate;

import roomBLServiceImpl.RoomStateChange;
import roomBLServiceImpl.RoomsReserved;

/**
 * 更新房间信息的控制器
 * @author 刘宗侃
 *
 */
public class RoomUpdateController{
	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber, String roomState) {
		RoomStateChange roomStateChange = RoomStateChange.getRoomStateChangeInstance(hotelID);
		roomStateChange.updateRoomState(roomNumber, roomState);
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
	/**
     * 房间是否存在
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     */
	public boolean exist(String hotelID, String roomNumber) {
		RoomStateChange roomStateChange = RoomStateChange.getRoomStateChangeInstance(hotelID);
		return roomStateChange.exist(roomNumber);
	}
}
