package dataHelper;

import java.rmi.RemoteException;
import java.util.List;

import PO.HotelPO;

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
	 * @param po HotelPO型，界面的选择
	 * @return
	 */
	public void insert(HotelPO po) throws RemoteException;

	/**
	 * 在数据库中删除一个po
	 * 
	 * @param po HotelPO型，界面的选择
	 * @return
	 */
	public void delete(HotelPO po) throws RemoteException;

	/**
	 * 在数据库中跟新一个po
	 * 
	 * @param po HotelPO型，界面的选择
	 * @return
	 */
	public void update(HotelPO po) throws RemoteException;
	
//	public HotelPO findByName(String name) throws RemoteException;
//
//	/**
//	 * 按商圈进行查找返回相应的HotelPO结果
//	 * 
//	 * @param in
//	 *            MessageInput型，界面输入的商圈名称
//	 * @return 返回ResultMessage枚举的一项
//	 */
//	public ArrayList<HotelPO> findByDistrict(String district) throws RemoteException;
//
//	/**
//	 * 按星级进行查找返回相应的HotelPO结果
//	 * 
//	 * @param in
//	 *            MessageInput型，界面输入的星级
//	 * @return 返回ResultMessage枚举的一项
//	 */
//	public ArrayList<HotelPO> findByStar(int star) throws RemoteException;
//
//	/**
//	 * 按评分进行查找返回相应的HotelPO结果
//	 * 
//	 * @param in
//	 *            MessageInput型，界面输入的酒店评分
//	 * @return 返回ResultMessage枚举的一项
//	 */
//	public ArrayList<HotelPO> findByScore(double sco) throws RemoteException;


}
