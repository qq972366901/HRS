package creditData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.CreditPO;
import PO.CreditRecordPO;
import dataService.CreditDataService;

public class CreditDataServiceMySqlImpl_Stub implements Serializable,CreditDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CreditPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		CreditPO po=new CreditPO("1",0,0);
		return po;
	}

	@Override
	public void insert(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(CreditRecordPO po) throws RemoteException {
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
