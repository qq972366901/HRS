package vo;
import po.RoomPO;

/**
 * 房间的属性及数据创建与更新
 * @author 刘宗侃
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
	 */
    public RoomVO (String hotelid,String roomid,String roomstatue,String roomtype,int roomprice){
    	hotelID = hotelid;
	    roomId=roomid;
	    roomStatue=roomstatue;
	    roomType=roomtype;
	    roomPrice=roomprice;
    }
    /**
   	 * 房间数据
   	 * @param po RoomPO型，数据层传来的房间
   	 * @return
   	 */
    public RoomVO (RoomPO po) {
    	hotelID = po.getHotelId();
    	roomId = po.getroomId();
    	roomStatue = po.getroomStatue();
    	roomType = po.getroomType();
    	roomPrice = po.getroomPrice();
    }
}
