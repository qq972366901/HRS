package dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import po.UserPO;
/**
 * 持久化用户数据
 * @author LZ
 *
 */
public interface UserDataHelper {
	/**
	 * 在数据库中增加一个po记录
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void insert(UserPO po);
	/**
	 * 在数据库中删除一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void delete(UserPO po);
	/**
	 *在数据库中更新一个po
	 * @param po CreditRecordPO型，逻辑层传入的PO对象
	 * @return 
	 * @see data.CreditRecord
	 */
		public void update(UserPO po);
		/**
		 * 获取所有UserPO
		 * @return
		 * @throws RemoteException
		 */
	    public ArrayList<UserPO> getAllUser();
	    /**
	     * 获取所有原始账号和密钥
	     * @return
	     */
		public HashMap<String, String> getAllKeys();
		/**
		 * 获取所有加密账号和密钥
		 * @return
		 */
		public HashMap<String,String> getAllSKeys();
		/**
		 * 删除一个密钥
		 * @param secretID
		 */
		public void deleteKey(String secretID);
		/**
		 * 增加一个密钥
		 * @param id
		 * @param k
		 */
		public void addKey(String id, String k,String secretid);
}
