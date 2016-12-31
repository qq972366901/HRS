package roomBLService;

/**
 * 负责实现房间功能的服务接口
 * @author 刘宗侃
 */

public interface RoomBLService {
	
	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber, String roomState);
	/**
     * 判断能否酒店是否有足够房间
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber int型，预定的房间数量
     */
	public boolean whetherSuccess(String hotelID, String roomtype,int roomNumber);
	/**
     * 客户下单更新酒店被预定的房间的状态
     * 
     * @param hotelID String型，酒店ID
     * @param roomType String型，房型
     * @param roomNumber String型，预定的房间数量
     */
	public void updateRoomState(String hotelID, String roomType,int roomNumber);
	/**
     * 得到酒店的所有空闲房间的最低价格，若无空闲房间，返回 -1 
     * 
     * @param hotelID String型，酒店ID
     * @return 此酒店的所有空闲房间的最低价格
     */
	public int getRoomLowestPrice(String hotelID);
	/**
     * 得到酒店的某房间类型的价格
     * 
     * @param hotelid String型，酒店的id
     * @param roomType String型，一种房间类型
     * @return 返回酒店的某房间类型的价格
     */
	public int getRoomPrice(String hotelid, String roomType);
	
	/**
     * 房间是否存在
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     */
	public boolean exist(String hotelID, String roomNumber);
	
}
