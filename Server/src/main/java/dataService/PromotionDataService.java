package dataService;
import PO.*;
import dataService.DataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**负责实现营销策略数据储存所需要的服务接口
 * @author 刘伟
 * @version 1.0
 * see presentation.Promotion
 */
public interface PromotionDataService  extends DataService{
	/**
	 * 按ID进行查找返回相应的PromotionPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see data.Promotion
	 */
		public PromotionPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void insert(PromotionPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void delete(PromotionPO po) throws RemoteException;
	/**
	 *在数据库中跟新一个po
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void update(PromotionPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void init() throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @param in MessageInput型，界面的选择
	 * @return 
	 * @see data.Promotion
	 */
		public void finish() throws RemoteException;
	}

