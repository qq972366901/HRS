package datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Map;

import creditData.CreditDataServiceMySqlImpl;
import creditrecordData.CreditRecordDataServiceMySqlImpl;
import dataService.DataFactoryService;
import dataService.DataService;
import hotelData.HotelDataServiceMySqlImpl;
import orderData.OrderDataServiceMySqlImpl;
import promotionData.PromotionDataServiceMySqlImpl;
import roomData.RoomDataServiceMySqlImpl;
import userData.UserDataServiceMySqlImpl;
/**
 * 职责是提供不同种类的数据接口
 * @author LZ
 * @version 1.0
 * @see datafactoryService.DataFactoryService
 */
public class DataFactoryMySqlImpl extends UnicastRemoteObject implements DataFactoryService{
	private Map<String, DataService> dataService = null;
	private DataFactoryMySqlImpl() throws RemoteException {
		dataService=new Hashtable<String, DataService>();
		dataService.put("User", UserDataServiceMySqlImpl.getInstance());
		dataService.put("CreditRecord",CreditRecordDataServiceMySqlImpl.getInstance());
		dataService.put("Hotel", HotelDataServiceMySqlImpl.getInstance());
		dataService.put("Promotion", PromotionDataServiceMySqlImpl.getInstance());
		dataService.put("Room", RoomDataServiceMySqlImpl.getInstance());
		dataService.put("Order", OrderDataServiceMySqlImpl.getInstance());
		dataService.put("Credit",CreditDataServiceMySqlImpl.getInstance());
	}
	private static DataFactoryService dataFactory;
	public static DataFactoryService getInstance() throws RemoteException{
		if(dataFactory==null){
			dataFactory=new DataFactoryMySqlImpl();
		}
		return dataFactory;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 提供数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getDataService(String type) throws RemoteException{
		return dataService.get(type);
	}
}
