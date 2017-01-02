package hotelData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dataHelper.DataHelperFactory;
import dataHelper.HotelDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
import dataHelperImpl.HotelDataHelperImpl;
import dataService.HotelDataService;
import po.HotelPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台HotelData处理
 * @author 刘宗侃
 */
public class HotelDataServiceMySqlImpl implements HotelDataService{
	
	private HashMap<String,HotelPO> hotel = new HashMap<String,HotelPO>();
	
	private DataHelperFactory factory;
	private HotelDataHelper hotelDataHelper = new HotelDataHelperImpl();
	
	private static HotelDataServiceMySqlImpl hotelDataServiceMySqlImpl;
	
	/**
	 * 酒店数据服务构造方法
	 * @throws RemoteException
	 */
	private HotelDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	
	/**
	 * 得到酒店数据服务
	 * @return
	 * @throws RemoteException
	 */
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
	 * @see po.HotelPO
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
	 * @see po.HotelPO
	 */
	public HotelPO find(String id) throws RemoteException {
		return hotel.get(id);
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po HotelPO型，逻辑层传来的PO实体
	 * @return 
	 * @throws RemoteException
	 * @see po.HotelPO
	 */
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
	 * @see po.HotelPO
	 */
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
	 * @see po.HotelPO
	 */
	public void update(HotelPO po) throws RemoteException {
		if(hotel.containsKey(po.gethotelAccount())) {
			hotel.put(po.gethotelAccount(), po);
			hotelDataHelper.update(po);
		}
	}

	/**
	 * 在数据库中查找一个用户的历史酒店
	 * 
	 * @param userID String型，用户ID
	 * @return 此用户的历史酒店列表
	 */
	public List<HotelPO> getHistoryHotelByUser(String userID) {
		List<HotelPO> list = new ArrayList<HotelPO>();
		try {
			list = hotelDataHelper.getHistoryHotelByUser(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 得到所有酒店
	 * 
	 * @return 返回所以酒店的列表
	 */
	public List<HotelPO> getAllHotel() {
		List<HotelPO> list = new ArrayList<HotelPO>();
		Iterator<String> it = hotel.keySet().iterator();
		while(it.hasNext())   
		{   
		   list.add(hotel.get(it.next()));
		}
		return list;
	}
}
