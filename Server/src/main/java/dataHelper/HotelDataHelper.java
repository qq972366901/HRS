package dataHelper;

import java.rmi.RemoteException;
import java.util.List;

import PO.HotelPO;

/**
 * 数据库对酒店表的操作的服务
 * @author 刘宗侃
 *
 */
public interface HotelDataHelper {

	/**
	 * 按酒店ID进行查找返回相应的HotelPO结果
	 * 
	 * @param id String型，界面输入的酒店id
	 * @return 返回对应的HotelPO
	 */
	public HotelPO find(String id) throws RemoteException;

	/**
	 * 在数据库中查找一个用户的历史酒店
	 * 
	 * @param userid String型，用户ID
	 * @return 此用户的历史酒店列表
	 */
	public List<HotelPO> getHistoryHotelByUser(String userid) throws RemoteException;

	/**
	 * 得到所有酒店
	 * 
	 * @return 返回所以酒店的列表
	 */
	public List<HotelPO> getAllHotel() throws RemoteException;

	/**
	 * 按名称进行查找返回相应的HotelPO结果
	 * 
	 * @param name String型，界面输入的酒店名称
	 * @return 返回得到的HotelPO
	 */
	
	/**
	 * 在数据库中增加一个po记录
	 * 
	 * @param po HotelPO型，新增的酒店
	 * @return
	 */
	public void insert(HotelPO po) throws RemoteException;

	/**
	 * 在数据库中删除一个po
	 * 
	 * @param po HotelPO型，删除的酒店
	 * @return
	 */
	public void delete(HotelPO po) throws RemoteException;

	/**
	 * 在数据库中更新一个po
	 * 
	 * @param po HotelPO型，更新的酒店
	 * @return
	 */
	public void update(HotelPO po) throws RemoteException;
	
}
