package LineItem;

import VO.RoomVO;
/**
 * 单个房间
 * @author 刘宗侃
 * @version 1.0
 */
public class RoomLineItem {

	RoomVO roomVO;
	
	/**
	 * 单个房间
	 * @param r Room型，传入房间对象
	 * @return 单个房间
	 */
	public RoomLineItem (RoomVO rvo) {
		roomVO = rvo;
	}
	
	/**
	 * 得到房间价格
	 * @param 
	 * @return 返回房间价格
	 */
	public int getPrice() {
		return roomVO.roomPrice;
	}
	
}
