package roomList;

import RoomBLServiceImpl.RoomAllOfHotel;

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
	
}
