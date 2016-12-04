package dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.OrderPO;

public interface OrderDataHelper {
	/**
	 * 在数据库中增加一个po记录
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void insert(OrderPO po);
	/**
	 * 在数据库中删除一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void delete(OrderPO po);
	/**
	 *在数据库中更新一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void update(OrderPO po);
		/**
		 * 获取所有CreditPO
		 * @return
		 * @throws RemoteException
		 */
	    public ArrayList<OrderPO> getAllUser();
}
