package hotelData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台HotelData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.Hotel
 */
public class HotelDataServiceMySqlImpl implements Serializable,dataService.HotelDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 按ID进行查找返回相应的HotelPO结果
	 * @param id String型，逻辑层传来的酒店账号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public HotelPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po HotelPO型，逻辑层传来的PO实体
	 * @return 
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public void insert(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中删除一个po
	 * @param po HotelPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public void delete(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中更新一个po
	 * @param po HotelPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
	}
	/**
	 * 结束持久化数据库的使用
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按名称进行查找返回相应的HotelPO结果
	 * @param name String型，逻辑层传来的酒店名称
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public HotelPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 按商圈进行查找返回相应的HotelPO结果
	 * @param district String 型，逻辑层传来的酒店商圈
	 * @return 返回找到的PO列表
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public ArrayList<HotelPO> findByDistrict(String district) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 按星级进行查找返回相应的HotelPO结果
	 * @param star int型，逻辑层传来的酒店星级
	 * @return 返回找到的PO列表
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public ArrayList<HotelPO> findByStar(int star) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public ArrayList<HotelPO> findByScore(double sco) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
