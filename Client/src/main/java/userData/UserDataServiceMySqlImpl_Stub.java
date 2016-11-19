package userData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Calendar;

import PO.UserPO;

public class UserDataServiceMySqlImpl_Stub implements Serializable,dataService.UserDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public UserPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		Calendar time1=Calendar.getInstance();
		time1.set(2016,11,11);
		UserPO po=new UserPO("lz","xxx","54290544383",2,"企业会员",1,time1,"xxx");
		return po;
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(UserPO po) throws RemoteException {
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
