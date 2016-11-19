package promotionData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.PromotionPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台PromotionData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.Promotion
 */
public class PromotionDataServiceMySqlImpl implements Serializable,dataService.PromotionDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 按ID进行查找返回相应的PromotionPO结果
	 * @param id String 型，逻辑层传来的策略编号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void insert(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中删除一个po
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void delete(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中跟新一个po
	 * @param po PromotionPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void update(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 结束持久化数据库的使用
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.PromotionPO
	 */
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
