package dataHelper;

import java.util.List;

import po.RoomPO;

/**
 * 数据库对房间表的操作的服务
 * @author 刘宗侃
 *
 */
public interface RoomDataHelper {
	
	/**
	 * 在数据库中增加一个po记录
	 * 
	 * @param po RoomPO型，新增的房间
	 * @return
	 */
	public void insert(RoomPO po);
	
	/**
	 * 在数据库中更新一个po记录
	 * 
	 * @param po RoomPO型，更新的房间
	 * @return
	 */
	public void update(RoomPO po);
	
	/**
	 * 得到一个酒店的所有房间列表
	 * @param hotelid String型，逻辑层传来的酒店ID
	 * @return 一个酒店的所有房间列表
	 */
	public List<RoomPO> getAllRooms(String hotelid);
	
}
