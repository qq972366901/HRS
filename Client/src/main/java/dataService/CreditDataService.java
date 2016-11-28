package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.CreditPO;
import PO.CreditRecordPO;

/**负责实现信用数据储存所需要的服务接口
 * @author LZ
 * @version 1.0
 * see presentation.Credit
 */
public interface CreditDataService  extends DataService,Remote{
	/**
	 * 按ID进行查找返回相应的CreditPO结果
	 * @param in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage枚举的一项
	 * @see data.CreditRecord
	 */
		public CreditPO find(String id) throws RemoteException;
	/**
	 * 在数据库中增加一个po记录
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void insert(CreditRecordPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void delete(CreditRecordPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void update(CreditRecordPO po) throws RemoteException;
	/**
	 * 按初始化持久化数据库
	 * @return 
	 * @see data.CreditRecord
	 */
		public void init() throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @return 
	 * @see data.CreditRecord
	 */
		public void finish() throws RemoteException;
}
