package datafactory;

import java.io.Serializable;
import java.rmi.RemoteException;

import dataService.DataService;
/**
 * 职责是提供不同种类的数据接口
 * @author LZ
 * @version 1.0
 * @see datafactoryService.DataFactoryService
 */
public class DataFactoryMySqlImpl implements Serializable,dataService.DataFactoryService{
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
		// TODO Auto-generated method stub
		return null;
	}
}
