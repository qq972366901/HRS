package creditData;

import java.io.Serializable;
import java.rmi.RemoteException;

import PO.CreditPO;
import PO.CreditRecordPO;
import dataService.CreditDataService;

public class CreditDataServiceMySqlImpl implements Serializable,CreditDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CreditPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
