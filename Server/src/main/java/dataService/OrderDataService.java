package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**负责实现订单数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Order
 */
public interface OrderDataService  extends DataService{
/**
 * 按ID进行查找返回相应的OrderPO结果
 * @param in MessageInput型，界面输入的订单类型
 * @return 返回ResultMessage枚举的一项
 * @see data.Order
 */
		public OrderPO find(String id) throws RemoteException;
/**
 * 按类型进行查找返回相应的OrderPO结果
 * @param in MessageInput型，界面输入的客户ID
 * @return 返回ResultMessage枚举的一项
 * @see data.Order
*/	
		public ArrayList<OrderPO> findByType(String type)throws RemoteException;
/**
 * 在数据库中增加一个po记录
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void insert(OrderPO po) throws RemoteException;
/**
 * 在数据库中删除一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void delete(OrderPO po) throws RemoteException;
/**
 *在数据库中跟新一个po
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void update(OrderPO po) throws RemoteException;
/**
 * 按初始化持久化数据库
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void init() throws RemoteException;
/**
 * 结束持久化数据库的使用
 * @param in MessageInput型，界面的选择
 * @return 
 * @see data.Order
 */
		public void finish() throws RemoteException;
	}

