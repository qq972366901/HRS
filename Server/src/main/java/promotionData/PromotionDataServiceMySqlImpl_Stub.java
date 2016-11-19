package promotionData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Calendar;

import PO.PromotionPO;

public class PromotionDataServiceMySqlImpl_Stub implements Serializable,dataService.PromotionDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		Calendar time1=Calendar.getInstance();
		time1.set(2016,11,11);
		Calendar time2=Calendar.getInstance();
		time2.set(2016,11,12);
		PromotionPO po=new PromotionPO("D8dC3","双十一",time1,time2,"普通会员","",0,0,6.5);
		return po;
	}

	@Override
	public void insert(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!");
	}

	@Override
	public void delete(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(PromotionPO po) throws RemoteException {
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
