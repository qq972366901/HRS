package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**负责实现客户数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.User
 */
public interface UserDataService  extends DataService,Remote{
	/**
	 * 按ID进行查找返回相应的UserPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see Customer.User
	 */
		public UserPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see Customer.User
	 */
		public void insert(UserPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see Customer.User
	 */
		public void delete(UserPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see Customer.User
	 */
		public void update(UserPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see Customer.User
	 */
		public void init() throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see Customer.User
	 */
		public void finish() throws RemoteException;
	}

