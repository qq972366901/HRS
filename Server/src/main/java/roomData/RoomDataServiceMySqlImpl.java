package roomData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import PO.RoomPO;
import dataHelper.DataHelperFactory;
import dataHelper.RoomDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.RoomDataService;
/**
 * 职责是将逻辑层面发来的请求转发给后台RoomData处理
 * @author 刘宗侃
 * @version 1.0
 * @see businesslogic.Room
 */
public class RoomDataServiceMySqlImpl implements RoomDataService{

	private List<RoomPO> room;
	
	private String hotelID;
	
	private static RoomDataServiceMySqlImpl roomDataServiceMySqlImpl;
	
	private DataHelperFactory factory;
	private RoomDataHelper roomDataHelper;
	
	private RoomDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
	}
	
	public static RoomDataServiceMySqlImpl getInstance() throws RemoteException{
		if(roomDataServiceMySqlImpl==null){
			roomDataServiceMySqlImpl=new RoomDataServiceMySqlImpl();
		}
		return roomDataServiceMySqlImpl;
	}
	
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void init() throws RemoteException {
		factory=new DataHelperFactoryImpl();
		roomDataHelper = factory.getRoomDataHelper();
	}
	
	/**
	 * 按ID进行查找返回相应的RoomPO结果
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public RoomPO find(String id) throws RemoteException {
		//find方法通过getAllRooms(String hotelid)得到，此方法不用
		return null;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void insert(RoomPO po) throws RemoteException {
		if(hotelID != po.getHotelId()) {
			hotelID = po.getHotelId();
			List<RoomPO> list;
			list = roomDataHelper.getAllRooms(po.getHotelId());
			for(int i=0;i<list.size();i++) {
				room.add(list.get(i));
			}
		}
		room.add(po);
		roomDataHelper.insert(po);
	}
	/**
	 * 在数据库中删除一个po
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void delete(RoomPO po) throws RemoteException {
		if(hotelID != po.getHotelId()) {
			hotelID = po.getHotelId();
			List<RoomPO> list;
			list = roomDataHelper.getAllRooms(po.getHotelId());
			for(int i=0;i<list.size();i++) {
				room.add(list.get(i));
			}
		}
		int index = room.indexOf(po);
		room.remove(index);
		roomDataHelper.delete(po);
	}
	/**
	 * 在数据库中更新一个po
	 * @param po RoomPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public void update(RoomPO po) throws RemoteException {
		if(hotelID != po.getHotelId()) {
			hotelID = po.getHotelId();
			List<RoomPO> list;
			list = roomDataHelper.getAllRooms(po.getHotelId());
			for(int i=0;i<list.size();i++) {
				room.add(list.get(i));
			}
		}
		int index = room.indexOf(po);
		room.set(index, po);
		roomDataHelper.update(po);
	}
	/**
	 * 得到一个酒店的所有房间列表
	 * @param hotelid String型，逻辑层传来的酒店ID
	 * @return 一个酒店的所有房间列表
	 * @throws RemoteException
	 * @see PO.RoomPO
	 */
	public List<RoomPO> getAllRooms(String hotelid) {
		if(hotelID != hotelid) {
			hotelID = hotelid;
			List<RoomPO> list;
			list = roomDataHelper.getAllRooms(hotelid);
			for(int i=0;i<list.size();i++) {
				room.add(list.get(i));
			}
		}
		return room;
	}

}
