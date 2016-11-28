package VO;
import java.util.Vector;

import Object.Room;
import PO.RoomPO;

/**
 * 房间的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Room
 */

public class RoomVO{

	public String hotelID;
	public String roomId;
    public String roomStatue;
    public String roomType;
    public int roomPrice;
    public RoomVO(){};
    /**
	 * 房间数据
	 * @param hotelid String型，房间所属的酒店帐号
	 * @param roomid String型，房间号
	 * @param roomstatue String型，房间状态
	 * @param roomtype String型，房间类型
	 * @param roomprice int型，房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public RoomVO (String hotelid,String roomid,String roomstatue,String roomtype,int roomprice){
    	hotelID = hotelid;
	    roomId=roomid;
	    roomStatue=roomstatue;
	    roomType=roomtype;
	    roomPrice=roomprice;
    }
    public RoomVO (RoomPO po) {
    	hotelID = po.getHotelId();
    	roomId = po.getroomId();
    	roomStatue = po.getroomStatue();
    	roomType = po.getroomType();
    	roomPrice = po.getroomPrice();
    }
    /**
     * 更新房间信息
     * 
     * @param room Room型，一个用来更新数据的房间对象
     * @return 
     * @see Object.Room
     */
	public void update(Room room) {
		
	}
	
	/**
     * 创建房间对象
     * 
     * @return 一个新录入的房间
     * @see Object.Room
     */
	public Room makeRoom() {
		
		return new Room();
	}
    
}
