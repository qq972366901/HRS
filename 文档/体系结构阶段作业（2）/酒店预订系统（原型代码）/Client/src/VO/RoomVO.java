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
