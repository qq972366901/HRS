package creditrecordData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataHelper.CreditRecordDataHelper;
import dataHelper.DataHelperFactory;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.CreditRecordDataService;
import po.CreditRecordPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台CreditRecordData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.CreditRecord
 */
public class CreditRecordDataServiceMySqlImpl implements CreditRecordDataService{
	
	private static CreditRecordDataServiceMySqlImpl creditRecordDataServiceMySqlImpl;
	private CreditRecordDataHelper helper;
	private List<CreditRecordPO> list;
	private DataHelperFactory factory;
	private CreditRecordDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	public static CreditRecordDataServiceMySqlImpl getInstance() throws RemoteException{
		if(creditRecordDataServiceMySqlImpl==null){
			creditRecordDataServiceMySqlImpl=new CreditRecordDataServiceMySqlImpl();
		}
		return creditRecordDataServiceMySqlImpl;
	}
	/**
	 * 按ID进行查找返回相应的CreditRecordPO结果
	 * @param id String型，逻辑层传来的信用记录编号
	 * @return 返回找到的PO实体
	 * @throws 远程调用失败
	 * @see po.CreditRecordPO
	 */
	@Override
	public List<CreditRecordPO> find(String id) throws RemoteException {
		List<CreditRecordPO> polist=new ArrayList<CreditRecordPO>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUserID().equals(id)){
				polist.add(list.get(i));
			}
		}
		return polist;
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po CreditRecordPO型，逻辑层传来的信用记录实体
	 * @return
	 * @throws 远程调用失败 
	 * @see po.CreditRecordPO
	 */
	@Override
	public void insert(CreditRecordPO po) throws RemoteException {
		list.add(po);
		helper.insert(po);
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws 远程调用失败
	 * @see po.CreditRecordPO
	 */
	private void init() throws RemoteException {
		factory=new DataHelperFactoryImpl();
		helper=factory.getCreditRecordDataHelper();
		list=helper.getAllCredit();
	}
	@Override
	public List<CreditRecordPO> getAllCreditRecord() throws RemoteException {
		return list;
	}

}
