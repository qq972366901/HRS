package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 职责是定义提供数据接口的接口
 * @author LZ
 * @version 2.0
 * @see
 */
public interface DataFactoryService extends Remote{
	/**
	 * 定义提供数据的接口
	 * @param
	 * @return
	 * @throws
	 * @see dataService.DataService
	 */
	public DataService getDataService(String type) throws RemoteException ;
}
