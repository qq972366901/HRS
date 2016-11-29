package creditData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.CreditPO;
import PO.CreditRecordPO;
import dataHelper.CreditDataHelper;
import dataHelper.DataHelperFactory;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.CreditDataService;

public class CreditDataServiceMySqlImpl implements CreditDataService{

	private CreditDataHelper creditDataHelper;
	
	private DataHelperFactory dataFactory;
	
	private CreditDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		dataFactory=new DataHelperFactoryImpl();
		creditDataHelper=dataFactory.getCreditDataHelper();
	}
	private static CreditDataServiceMySqlImpl creditDataServiceMySqlImpl;
	public static CreditDataServiceMySqlImpl getInstance() throws RemoteException{
		if(creditDataServiceMySqlImpl==null){
			creditDataServiceMySqlImpl=new CreditDataServiceMySqlImpl();
		}
		return creditDataServiceMySqlImpl;
	}
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
	/*
	@Override
	public ArrayList<String> get() {
		ArrayList<String> list=new ArrayList<String>();
		try {
			list=creditDataHelper.get();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}*/

}
