package creditrecordData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.CreditRecordPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台CreditRecordData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.CreditRecord
 */
public class CreditRecordDataServiceMySqlImpl implements Serializable,dataService.CreditRecordDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 按ID进行查找返回相应的CreditRecordPO结果
	 * @param id String型，逻辑层传来的信用记录编号
	 * @return 返回找到的PO实体
	 * @throws 远程调用失败
	 * @see PO.CreditRecordPO
	 */
	@Override
	public CreditRecordPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po CreditRecordPO型，逻辑层传来的信用记录实体
	 * @return
	 * @throws 远程调用失败 
	 * @see PO.CreditRecordPO
	 */
	@Override
	public void insert(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中删除一个po
	 * @param po CreditRecordPO型，逻辑层传来的信用记录实体
	 * @return
	 * @throws 远程调用失败
	 * @see PO.CreditRecordPO
	 */
	@Override
	public void delete(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中更新一个po
	 * @param po CreditRecordPO型，逻辑层传来的信用记录实体
	 * @return
	 * @throws 远程调用失败
	 * @see PO.CreditRecordPO
	 */
	@Override
	public void update(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws 远程调用失败
	 * @see PO.CreditRecordPO
	 */
	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 结束持久化数据库的使用
	 * @param
	 * @return
	 * @throws 远程调用失败
	 * @see PO.CreditRecordPO
	 */
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
