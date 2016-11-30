package dataHelper;

import java.rmi.RemoteException;
import java.util.List;

import PO.RoomPO;

public interface RoomDataHelper {

	/**
	 * 按ID进行查找返回相应的RoomPO结果
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public RoomPO find(String id);
	
	/**
	 * 在数据库中增加一个po实体
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void insert(RoomPO po);
	
	/**
	 * 在数据库中删除一个po
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void delete(RoomPO po);
	
	/**
	 * 在数据库中更新一个po
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void update(RoomPO po);
	
	/**
	 * 得到一个酒店的所有房间列表
	 * @param hotelid String型，逻辑层传来的酒店ID
	 * @return 一个酒店的所有房间列表
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public List<RoomPO> getAllRooms(String hotelid);
	
}
