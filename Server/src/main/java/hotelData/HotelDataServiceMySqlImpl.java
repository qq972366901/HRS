package hotelData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import PO.HotelPO;
import dataHelper.DataHelperFactory;
import dataHelper.HotelDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
import dataHelperImpl.HotelDataHelperImpl;
import dataService.HotelDataService;
/**
 * 职责是将逻辑层面发来的请求转发给后台HotelData处理
 * @author 刘宗侃
 * @version 1.0
 * @see businesslogic.Hotel
 */
public class HotelDataServiceMySqlImpl implements HotelDataService{
	
	private HashMap<String,HotelPO> hotel = new HashMap<String,HotelPO>();
	
	private DataHelperFactory factory;
	private HotelDataHelper hotelDataHelper = new HotelDataHelperImpl();
	
	private static HotelDataServiceMySqlImpl hotelDataServiceMySqlImpl;
	private HotelDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	public static HotelDataServiceMySqlImpl getInstance() throws RemoteException{
		if(hotelDataServiceMySqlImpl==null){
			hotelDataServiceMySqlImpl=new HotelDataServiceMySqlImpl();
		}
		return hotelDataServiceMySqlImpl;
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	private void init() {
		hotel=new HashMap<String,HotelPO>();
		factory=new DataHelperFactoryImpl();
		hotelDataHelper = factory.getHotelDataHelper();
		List<HotelPO> list = null;
		try {
			list = hotelDataHelper.getAllHotel();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++) {
			hotel.put(list.get(i).gethotelAccount(), list.get(i));
		}
	}
	/**
	 * 按ID进行查找返回相应的HotelPO结果
	 * @param id String型，逻辑层传来的酒店账号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public HotelPO find(String id) throws RemoteException {
		return hotel.get(id);
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
		if(!hotel.containsKey(po.gethotelAccount())) {
			hotel.put(po.gethotelAccount(), po);
			hotelDataHelper.insert(po);
		}
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
		if(hotel.containsKey(po.gethotelAccount())) {
			hotel.remove(po.gethotelAccount());
			hotelDataHelper.delete(po);
		}
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
		if(hotel.containsKey(po.gethotelAccount())) {
			hotel.put(po.gethotelAccount(), po);
			hotelDataHelper.update(po);
		}
	}

	@Override
	public List<HotelPO> getHistoryHotelByUser(String userID) {
		List<HotelPO> list = new ArrayList<HotelPO>();
		try {
			list = hotelDataHelper.getHistoryHotelByUser(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("null")
	@Override
	public List<HotelPO> getAllHotel() {
		List<HotelPO> list = null;
		Iterator<String> it = hotel.keySet().iterator();
		while(it.hasNext())   
		{   
		   list.add(hotel.get(it.next()));
		}
		return list;
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
		// 此方法感觉用不到
		HotelPO po = null;
		Iterator<String> it = hotel.keySet().iterator();
		while(it.hasNext()) {
			String id = it.next();
			if(name.equals(hotel.get(id).gethotelName())) {
				po = hotel.get(id);
				break;
			}
		}
		return po;
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
		// 此方法感觉用不到
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		Iterator<String> it = hotel.keySet().iterator();
		while(it.hasNext()) {
			String id = it.next();
			if(district.equals(hotel.get(id).gethotelDistrict())) {
				list.add(hotel.get(id));
			}
		}
		return list;
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
		// 此方法感觉用不到
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		Iterator<String> it = hotel.keySet().iterator();
		while(it.hasNext()) {
			String id = it.next();
			if(star <= hotel.get(id).gethotelStar()) {
				list.add(hotel.get(id));
			}
		}
		return list;
	}
	/**
	 * 按照酒店评分查找酒店
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.HotelPO
	 */
	@Override
	public ArrayList<HotelPO> findByScore(double sco) throws RemoteException {
		// 此方法感觉用不到
		return null;
	}
}
