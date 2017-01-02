package po;

import java.io.Serializable;
/**
 * 房间的数据实体
 * @author LZ
 * @version 1.0
 * @see
 */
public class RoomPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private String roomId;
    private String roomStatue;
    private String roomType;
    private int roomPrice;
    /**
	 * 构造房间的数据实体
	 * @param roomid String型，数据层传来的房间号
	 * @param roomstatue String型，数据层传来的房间状态
	 * @param roomtype String型，数据层传来的房间类型
	 * @param roomprice int型，数据层传来的房间价格
	 * @return
	 * @throws
	 * @see
	 */
    public RoomPO (String hotelid,String roomid,String roomstatue,String roomtype,int roomprice){
    	hotelID = hotelid;
	    roomId=roomid;
	    roomStatue=roomstatue;
	    roomType=roomtype;
	    roomPrice=roomprice;
    }
    /**
	 * 获取所属酒店帐号
	 * @param
	 * @return 返回所属酒店帐号
	 * @throws
	 * @see
	 */
    public String getHotelId() {
    	return hotelID;
    } 
    /**
	 * 设置所属酒店帐号
	 * @param id String型，逻辑层传来的所属酒店帐号
	 * @return
	 * @throws
	 * @see
	 */
    public void setHotelId (String id){
    	hotelID=id;
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
