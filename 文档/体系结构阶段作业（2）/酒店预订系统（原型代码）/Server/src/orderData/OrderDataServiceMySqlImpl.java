package orderData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.OrderPO;
import orderDataService.OrderDataService;
/**
 * 职责是将逻辑层面发来的请求转发给后台OrderData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.Order
 */
public class OrderDataServiceMySqlImpl implements OrderDataService{
	/**
	 * 按ID进行查找返回相应的OrderPO结果
	 * @param id String型，逻辑层传来的订单编号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see PO.OrderPO
	 */
	@Override
	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.OrderPO
	 */
	@Override
	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中删除一个po
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see PO.OrderPO
	 */
	@Override
	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在数据库中跟新一个po
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return 
	 * @throws RemoteException
	 * @see PO.OrderPO
	 */
	@Override
	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see PO.OrderPO
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
	 * @see PO.OrderPO
	 */
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 按类型进行查找返回相应的OrderPO结果
	 * @param type String型，逻辑层传来的订单类型
	 * @return 返回找到的PO实体列表
	 * @throws RemoteException
	 * @see PO.OrderPO
	 */
	@Override
	public ArrayList<OrderPO> findByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
