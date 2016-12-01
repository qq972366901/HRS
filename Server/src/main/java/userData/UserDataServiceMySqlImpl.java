package userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import PO.UserPO;
import common.UserType;
import dataHelper.DataHelperFactory;
import dataHelper.UserDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.UserDataService;
/**
 * 职责是将逻辑层面发来的请求转发给后台UserData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.User
 */
public class UserDataServiceMySqlImpl implements UserDataService{
	private static UserDataServiceMySqlImpl userDataServiceMySqlImpl;
	private DataHelperFactory dataFactory;
	private HashMap<String,UserPO> user;
	private UserDataHelper helper;
	private UserDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	public static UserDataServiceMySqlImpl getInstance() throws RemoteException{
		if(userDataServiceMySqlImpl==null){
			userDataServiceMySqlImpl=new UserDataServiceMySqlImpl();
		}
		return userDataServiceMySqlImpl;
	}
	/**
	 * 按ID进行查找返回相应的UserPO结果
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public UserPO find(String id) throws RemoteException {
		return user.get(id);
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po UserPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public void insert(UserPO po) throws RemoteException {
		if(!user.containsKey(po.getAccount())){
			user.put(po.getAccount(), po);
			helper.insert(po);
		}
	}
	/**
	 * 在数据库中删除一个po
	 * @param po UserPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public void delete(String userID) throws RemoteException {
		if(user.containsKey(userID)){
			user.remove(userID);
			helper.delete(user.get(userID));
		}
	}
	/**
	 * 在数据库中更新一个po
	 * @param po UserPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public void update(UserPO po) throws RemoteException {
		if(user.containsKey(po.getAccount())){
			user.put(po.getAccount(), po);
			helper.update(po);
		}
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public void init() throws RemoteException {
		dataFactory=new DataHelperFactoryImpl();
		helper=dataFactory.getUserDataHelper();
		user=new HashMap<String,UserPO>();
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		list=helper.getAllUser();
		for(int i=0;i<list.size();i++){
			user.put(list.get(i).getAccount(), list.get(i));
		}
	}
	/**
	 * 获取所有客户信息
	 * @return
	 * @throws RemoteException
	 */
	public List<UserPO> getAllCustomer() throws RemoteException {
		List<UserPO> list=new ArrayList<UserPO>();
		Iterator<String> it=user.keySet().iterator();
		while(it.hasNext()){
			if(user.get(it.next()).getType().equals(UserType.Customer)){
				list.add(user.get(it.next()));
			}
		}  
		return list;
	}
	/**
	 * 获取所有非客户的用户信息
	 */
	@Override
	public List<UserPO> getAllWorker() throws RemoteException {
		List<UserPO> list=new ArrayList<UserPO>();
		Iterator<String> it=user.keySet().iterator();
		while(it.hasNext()){
			if(!user.get(it.next()).getType().equals(UserType.Customer)){
				list.add(user.get(it.next()));
			}
		}  
		return list;
	}
	
}
