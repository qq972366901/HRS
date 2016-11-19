package roomData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.RoomPO;

public class RoomDataServiceMySqlImpl_Stub implements Serializable,dataService.RoomDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public RoomPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		RoomPO po=new RoomPO("321","已预订","总统套房",6,3000);
		return po;
	}

	@Override
	public void insert(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(RoomPO po) throws RemoteException {
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

}
