package dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CreditRecordPO;
/**
 * 持久化信用记录数据
 * @author LZ
 *
 */
public interface CreditRecordDataHelper {
	/**
	 * 在数据库中增加一个po记录
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void insert(CreditRecordPO po);
		/**
		 * 获取所有CreditRecordPO
		 * @return
		 * @throws RemoteException
		 */
	    public ArrayList<CreditRecordPO> getAllCredit();
}
