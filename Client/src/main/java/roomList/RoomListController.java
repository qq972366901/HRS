package roomList;

import RoomBLServiceImpl.RoomAllOfHotel;

/**
 * 酒店所以房间列表的控制器
 * @author 刘宗侃
 *
 */
public class RoomListController {

	/**
     * 得到酒店的所有空闲房间的最低价格，若无空闲房间，返回 -1 
     * 
     * @param hotelID String型，酒店ID
     * @return 此酒店的所有空闲房间的最低价格
     */
	public int getRoomLowestPrice(String hotelID) {
		RoomAllOfHotel roomAllOfHotel = RoomAllOfHotel.getRoomAllOfHotelInstance(hotelID);
		return roomAllOfHotel.getLowestPrice();
	}
	
	/**
     * 得到酒店的某房间类型的价格
     * 
     * @param hotelid String型，酒店的id
     * @param roomType String型，一种房间类型
     * @return 返回酒店的某房间类型的价格
     */
	public int getPrice(String hotelid, String roomType) {
		RoomAllOfHotel roomAllOfHotel = RoomAllOfHotel.getRoomAllOfHotelInstance(hotelid);
		return roomAllOfHotel.getPrice(roomType);
	}
	
}
