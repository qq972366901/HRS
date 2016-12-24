package HotelRoomInfo;

import java.util.List;

import HotelBLServiceImpl.HotelRoom;


/**负责实现查看酒店所有的房间的信息的控制器
 * @author 刘宗侃
 */
public class HotelRoomInfoController {

	/**
     * 得到酒店的空闲房间的房型列表
     * 
     * @param hotelid String型，酒店帐号
     * @return String型，房型列表
     */
	public List<String> getRoomType(String hotelid) {
		HotelRoom hotelRoom = HotelRoom.getHotelRoomInstance(hotelid);
		return hotelRoom.getRoomType();
	}
	
	/**
     * 得到酒店空闲的此房型的剩余数量
     * 
     * @param hotelid String型，酒店帐号
     * @param roomType String型，房间类型
     * @return  int型，订单总的原价
     */
	public int getMaxRoomNumber(String hotelid, String roomType) {
		HotelRoom hotelRoom = HotelRoom.getHotelRoomInstance(hotelid);
		return hotelRoom.getMaxRoomNumber(roomType);
	}
	
	/**
     * 得到客户酒店房间订单的总原价
     * 
     * @param hotelid String型，酒店帐号
     * @param roomType String型，房间类型
     * @param roomNumber int型，预定房间数量
     * @return  int型，订单总的原价
     */
	public int getOrderPrice(String hotelid, String roomType, int roomNumber) {
		HotelRoom hotelRoom = HotelRoom.getHotelRoomInstance(hotelid);
		return hotelRoom.getOrderPrice(roomType, roomNumber);
	}
	
}
