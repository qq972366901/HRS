package creditData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import PO.CreditPO;
import PO.UserPO;
import common.UserType;
import dataHelper.CreditDataHelper;
import dataHelper.DataHelperFactory;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.CreditDataService;
/**
 * 职责是将逻辑层面发来的请求转发给后台CreditData处理
 * @author LZ
 *
 */
public class CreditDataServiceMySqlImpl implements CreditDataService{

	private CreditDataHelper creditDataHelper;
	private HashMap<String,CreditPO> credit;
	private DataHelperFactory factory;
	private CreditDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
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
		return credit.get(id);
	}

	@Override
	public void insert(CreditPO po) throws RemoteException {
		if(!credit.containsKey(po.getAccount())){
			credit.put(po.getAccount(), po);
			creditDataHelper.insert(po);
		}
	}

	@Override
	public void delete(CreditPO po) throws RemoteException {
		if(credit.containsKey(po.getAccount())){
			credit.remove(po.getAccount());
			creditDataHelper.delete(po);
		}
	}

	@Override
	public void update(CreditPO po) throws RemoteException {
		if(credit.containsKey(po.getAccount())){
			credit.put(po.getAccount(), po);
			creditDataHelper.update(po);
		}
	}

	@Override
	public ArrayList<CreditPO> getAllCredit() throws RemoteException {
		ArrayList<CreditPO> list=new ArrayList<CreditPO>();
		for (Map.Entry<String, CreditPO> entry : credit.entrySet()) {
            list.add(entry.getValue());
        }
		return list;
	}
	private void init(){
		factory=new DataHelperFactoryImpl();
		creditDataHelper=factory.getCreditDataHelper();
		ArrayList<CreditPO> list=new ArrayList<CreditPO>();
		list=creditDataHelper.getAllCredit();
		credit=new HashMap<String,CreditPO>();
		for(int i=0;i<list.size();i++){
			credit.put(list.get(i).getAccount(), list.get(i));
		}
	}
}
