package promotionData;

import java.rmi.RemoteException;
import java.sql.Time;

import PO.PromotionPO;
import promotionDataService.PromotionDataService;

public class PromotionDataServiceMySqlImpl_Stub implements PromotionDataService{

	@Override
	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		PromotionPO po=new PromotionPO("D8dC3","双十一",new Time(0),new Time(0),"普通会员","",0,0,6.5);
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
