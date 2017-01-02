package roomAvailable;
import roomBLServiceImpl.RoomAvailableJudge;

/**
 * 判断能否酒店是否有足够房间的控制器
 * @author 刘宗侃
 *
 */
public class RoomAvailableController{
	
	/**
     * 判断能否酒店是否有足够房间
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber String型，预定的房间数量
     */
	public boolean whetherSuccess(String hotelID, String roomType,int roomNumber) {
		RoomAvailableJudge roomAvailableJudge = RoomAvailableJudge.getRoomAvailableJudgeInstance(hotelID);
		return roomAvailableJudge.whetherSuccess(roomType, roomNumber);
	}
	
}
