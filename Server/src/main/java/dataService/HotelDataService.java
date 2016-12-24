package dataService;

import PO.*;
import dataService.DataService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * 负责实现酒店数据储存所需要的服务接口
 * 
 * @author 刘宗侃
 */
public interface HotelDataService extends DataService {
	/**
	 * 按酒店id进行查找返回相应的HotelPO结果
	 * 
	 * @param id String型，酒店ID
	 * @return 酒店的PO信息
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
	 * 在数据库中增加一个po记录
	 * 
	 * @param po HotelPO型，增加的酒店
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
