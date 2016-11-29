package roomAvailable;
import java.util.ArrayList;
import RoomBLServiceImpl.RoomAvailableJudge;
import VO.RoomVO;

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
	

	/**
     * 返回可入住房间
     * 
     * @return ArrayList<RoomVO>,一个房间值对象列表
     * @see bussinesslogic.Room
     */
	public ArrayList<RoomVO> getRoom() {
		ArrayList<RoomVO> array=new ArrayList<RoomVO>(); 
		return array;
	}
	
	
	/**
     * 返回房间的价格
     * 
     * @param roomType String型，一种房间类型
     * @return 返回一个long数值
     * @see bussinesslogic.Room
     */
	public long getPrice(String roomType) {
		return 200;
	}
}
