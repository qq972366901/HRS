package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.DataService;
/**
 * 职责是定义提供数据接口的接口
 * @author LZ
 * @version 1.0
 * @see
 */
public interface DataFactoryService extends Remote{
	/**
	 * 定义提供客户数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getUserData() throws RemoteException ;
	/**
	 * 定义提供信用记录数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getCreditRecordData() throws RemoteException ;
	/**
	 * 定义提供促销策略数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getPromotionData() throws RemoteException ;
	/**
	 * 定义提供订单数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getOrderData() throws RemoteException ;
	/**
	 * 定义提供酒店数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getHotelData() throws RemoteException ;
	/**
	 * 定义提供房间数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getRoomData() throws RemoteException ;
}
