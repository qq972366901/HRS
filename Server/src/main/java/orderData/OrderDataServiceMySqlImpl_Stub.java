package orderData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import PO.OrderPO;

public class OrderDataServiceMySqlImpl_Stub implements Serializable,dataService.OrderDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		OrderPO po=new OrderPO("xxx", 1,500,5,true,"总统套房",302, new Time(0),new Time(1),new Time(2),"xxx",5);
		return po;
	}

	@Override
	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!");
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeed!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish Succeed!");
	}

	@Override
	public ArrayList<OrderPO> findByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		ArrayList<OrderPO> x=new ArrayList<OrderPO>();
		OrderPO po=new OrderPO("xxx", 1,500,5,true,"总统套房",302, new Time(0),new Time(1),new Time(2),"xxx",5);
		x.add(po);
		return x;
	}

}
