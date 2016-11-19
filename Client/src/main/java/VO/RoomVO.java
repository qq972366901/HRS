package VO;
import Object.Room;

/**
 * 房间的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Room
 */

public class RoomVO extends VO {

	public String roomId;
    public String roomStatue;
    public String roomType;
    public int roomS;
    public int roomPrice;
    public RoomVO(){};
    /**
	 * 房间数据
	 * @param roomid String型，数据层传来的房间号
	 * @param roomstatue String型，数据层传来的房间状态
	 * @param roomtype String型，数据层传来的房间类型
	 * @param rooms int型，数据层传来的房间数量
	 * @param roomprice int型，数据层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public RoomVO (String roomid,String roomstatue,String roomtype,int rooms,int roomprice){
	    roomId=roomid;
	    roomStatue=roomstatue;
	    roomType=roomtype;
	    roomS=rooms;
	    roomPrice=roomprice;
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
