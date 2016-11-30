package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**负责实现房间数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Room
 */
public interface RoomDataService  extends DataService,Remote{
	/**
	 * 按ID进行查找返回相应的RoomPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see data.Room
	 */
		public RoomPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param po RoomPO型，界面的选择
	 * @return 
	 * @see data.Room
	 */
		public void insert(RoomPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param po RoomPO型，界面的选择
	 * @see data.Room
	 */
		public void delete(RoomPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param po RoomPO型，界面的选择
	 * @see data.Room
	 */
		public void update(RoomPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @see data.Room
	 */
		public void init() throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @see data.Room
	 */
		public void finish() throws RemoteException;
		List<RoomPO> getAllRooms(String hotelid) throws RemoteException;
	}
