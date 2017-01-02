package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;

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
		public void insert(CreditPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void delete(CreditPO po) throws RemoteException;
	/**
	 *在数据库中更新一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void update(CreditPO po) throws RemoteException;

		/**
		 * 获取所有CreditPO
		 * @return
		 * @throws RemoteException
		 */
	    public ArrayList<CreditPO> getAllCredit() throws RemoteException;
		
 }
