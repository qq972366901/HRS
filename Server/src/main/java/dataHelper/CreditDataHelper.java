package dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CreditPO;
/**
 * 持久化信用数据
 * @author LZ
 *
 */
public interface CreditDataHelper{
	/**
	 * 在数据库中增加一个po记录
	 * @param po CreditPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void insert(CreditPO po);
	/**
	 * 在数据库中删除一个po
	 * @param po CreditPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.Credit
	 */
		public void delete(CreditPO po);
	/**
	 *在数据库中更新一个po
	 * @param po CreditPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.Credit
	 */
		public void update(CreditPO po);
		/**
		 * 获取所有CreditPO
		 * @return
		 * @throws RemoteException
		 */
	    public ArrayList<CreditPO> getAllCredit();
}
