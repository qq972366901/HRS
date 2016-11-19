package Mock;

import VO.RoomVO;

public class MockRoom extends RoomVO {

	private String roomId;
    private String roomStatue;
    private String roomType;
    private int roomS;
    private int roomPrice;
    /**
	 * 模拟房间
	 * @param roomid String型，数据层传来的房间号
	 * @param roomstatue String型，数据层传来的房间状态
	 * @param roomtype String型，数据层传来的房间类型
	 * @param rooms int型，数据层传来的房间数量
	 * @param roomprice int型，数据层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
	public MockRoom(String roomid, String roomstatue, String roomtype, int rooms, int roomprice) {
		super(roomid, roomstatue, roomtype, rooms, roomprice);
	}
	
	/**
	 * 获取房间号
	 * @param
	 * @return 返回房间号
	 * @throws
	 * @see
	 */
    public String getroomId() {
    	return roomId;
    } 
    /**
	 * 设置房间号
	 * @param id String型，逻辑层传来的房间号
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomId (String id){
    	roomId=id;
    }
    /**
	 * 获取房间状态
	 * @param
	 * @return 返回房间状态
	 * @throws
	 * @see
	 */
    public String getroomStatue() {
    	return roomStatue;
    }
    /**
	 * 设置房间状态
	 * @param sta String型，逻辑层传来的房间状态
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomStatue (String sta){
    	roomStatue=sta;
    }
    /**
	 * 获取房间类型
	 * @param
	 * @return 返回房间类型
	 * @throws
	 * @see
	 */
    public String getroomType() {
    	return roomType;
    }
    /**
	 * 设置房间类型
	 * @param type String型，逻辑层传来的房间类型
	 * @return 
	 * @throws
	 * @see
	 */
    public void setroomType (String type){
		roomType=type;
	}
    /**
	 * 获取房间数量
	 * @param
	 * @return 返回房间数量
	 * @throws
	 * @see
	 */
    public int getroomS() {
		return roomS;
	}
    /**
	 * 设置房间数量
	 * @param room int型，逻辑层传来的房间数量
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomS (int room){
		roomS=room;
	}
    /**
	 * 获取房间价格
	 * @param
	 * @return 返回房间价格
	 * @throws
	 * @see
	 */
    public int getroomPrice() {
		return roomPrice;
	}
    /**
	 * 设置房间价格
	 * @param price int型，逻辑层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public void setroomPrice (int price){
		roomPrice=price;
	}
    
    

}




