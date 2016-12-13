package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**负责实现酒店数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Hotel
 */
public interface HotelDataService  extends DataService{
/**
 * 按id进行查找返回相应的HotelPO结果
 * @param in MessageInput型，界面输入的酒店id
 * @return 返回ResultMessage枚举的一项
 * @see data.Hotel
 */
	public HotelPO find(String id) throws RemoteException;

	/**
	 *在数据库中查找一个用户的历史酒店
	 * @param userid String型，用户ID
	 * @return 此用户的历史酒店列表
	 */
	public List<HotelPO> getHistoryHotelByUser(String userid) throws RemoteException;
	/**
	 *得到所有酒店
	 * @return 返回所以酒店的列表
	 */
	public List<HotelPO> getAllHotel() throws RemoteException;
	

/**
 * 按名称进行查找返回相应的HotelPO结果
 * @param in MessageInput型，界面输入的酒店名称
 * @return 返回ResultMessage枚举的一项
 * @see data.Hotel
 */
		public HotelPO findByName(String name) throws RemoteException;
/**
 * 按商圈进行查找返回相应的HotelPO结果
 * @param in MessageInput型，界面输入的商圈名称
 * @return 返回ResultMessage枚举的一项
 * @see data.Hotel
 */
		public ArrayList<HotelPO> findByDistrict(String district) throws RemoteException;
/**
 * 按星级进行查找返回相应的HotelPO结果
 * @param in MessageInput型，界面输入的星级
 * @return 返回ResultMessage枚举的一项
 * @see data.Hotel
 */
		public ArrayList<HotelPO> findByStar(int star) throws RemoteException;
/**
 * 按评分进行查找返回相应的HotelPO结果
 * @param in MessageInput型，界面输入的酒店评分
 * @return 返回ResultMessage枚举的一项
 * @see data.Hotel
 */
		public ArrayList<HotelPO> findByScore(double sco) throws RemoteException;
/**
 * 在数据库中增加一个po记录
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Hotel
 */
		public void insert(HotelPO po) throws RemoteException;
/**
 * 在数据库中删除一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Hotel
 */
		public void delete(HotelPO po) throws RemoteException;
/**
 *在数据库中跟新一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Hotel
 */
		public void update(HotelPO po) throws RemoteException;
	}
