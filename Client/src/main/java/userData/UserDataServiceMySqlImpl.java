package userData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.UserPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台UserData处理
 * @author LZ
 * @version 1.0
 * @see Customer.User
 */
public class UserDataServiceMySqlImpl implements Serializable,dataService.UserDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 按ID进行查找返回相应的UserPO结果
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.UserPO
	 */
	@Override
	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
