package userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import PO.UserPO;
import dataHelper.DataHelperFactory;
import dataHelper.UserDataHelper;
import dataHelperImpl.UserDataHelperImpl;
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
			//存入数据库
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
	public void delete(UserPO po) throws RemoteException {
		if(user.containsKey(po.getAccount())){
			user.remove(po.getAccount());
			//更新数据库
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
			//更新数据库数据
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
		helper=dataFactory.getUserDataHelper();
		user=new HashMap<String,UserPO>();
		//从数据库取数据
	}
	/**
	 * 结束持久化数据库的使用
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public void finish() throws RemoteException {
	}

}
