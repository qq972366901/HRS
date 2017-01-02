package dataService;
import dataService.DataService;
import po.*;

import java.rmi.RemoteException;
import java.util.List;

/**负责实现房间数据储存所需要的服务接口
 * @author 刘宗侃
 */
public interface RoomDataService  extends DataService{
	/**
	 * 在数据库中增加一个po记录
	 * @param po RoomPO型，要加入的房间
	 * @return 
	 */
	public void insert(RoomPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param po RoomPO型，要更新的房间
	 * @return 
	 */
	public void update(RoomPO po) throws RemoteException;
	/**
	 * 得到一个酒店的所有房间列表
	 * @param hotelid String型，被查找的酒店ID
	 * @return 一个酒店的所有房间列表
	 */
	public List<RoomPO> getAllRooms(String hotelid) throws RemoteException;
}
