package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**负责实现客户数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.User
 */
public interface UserDataService  extends DataService{
		
	/**
	 * 按ID进行查找返回相应的UserPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see data.User
	 */
		public UserPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.User
	 */
		public void insert(UserPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.User
	 */
		public void delete(String userID) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.User
	 */
		public void update(UserPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.User
	 */
		public void init() throws RemoteException;
		/**
		 * 获取所有客户信息
		 * @return
		 * @throws RemoteException
		 */
		public List<UserPO> getAllCustomer() throws RemoteException;
		/**
		 * 获取所有非客户信息
		 * @return
		 * @throws RemoteException
		 */
		public List<UserPO> getAllWorker() throws RemoteException;
	}

