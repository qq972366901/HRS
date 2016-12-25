package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
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
		/**
		 * 获取所有用户信息
		 * @return
		 */
		public List<UserPO> getAllUser() throws RemoteException;
		/**
		 * 修改某位用户的密码
		 * @param userID
		 * @param password
		 */
		public void modifyPassword(String userID, String password) throws RemoteException;
		/**
		 * 获取所有原始账号和密钥
		 */
		public HashMap<String,String> getAllKeys() throws RemoteException;
		/**
		 * 获取所有加密账号和密钥
		 * @return
		 * @throws RemoteException
		 */
		public HashMap<String,String> getAllSKeys() throws RemoteException;
		/**
		 * 删除一个密钥
		 * @param secretID
		 * @throws RemoteException
		 */
		public void deleteKey(String secretID) throws RemoteException;
		/**
		 * 增加一个密钥
		 * @param id
		 * @param k
		 * @throws RemoteException
		 */
		public void addKey(String id, String k,String secretid) throws RemoteException;
	}

