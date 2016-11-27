package roomAvailable;
import java.util.ArrayList;

import VO.RoomVO;
public class RoomAvailableController{
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
