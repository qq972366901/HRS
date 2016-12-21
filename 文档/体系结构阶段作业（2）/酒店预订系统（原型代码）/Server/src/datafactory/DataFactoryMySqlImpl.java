package datafactory;

import java.rmi.RemoteException;

import dataService.DataService;
import datafactoryService.DataFactoryService;
/**
 * 职责是提供不同种类的数据接口
 * @author LZ
 * @version 1.0
 * @see datafactoryService.DataFactoryService
 */
public class DataFactoryMySqlImpl implements DataFactoryService{
	/**
	 * 提供客户数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getUserData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 提供信用记录数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getCreditRecordData()  throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 提供促销策略数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getPromotionData() throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 提供订单数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getOrderData()  throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 提供酒店数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getHotelData() throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 提供房间数据接口
	 * @param
	 * @return 返回DataService
	 * @throws RemoteException
	 * @see dataService.DataService
	 */
	@Override
	public DataService getRoomData() throws RemoteException  {
		// TODO Auto-generated method stub
		return null;
	}

}
