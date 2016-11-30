package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.DataService;

public interface DataFactoryService extends Remote{
	public DataService getDataService(String type) throws RemoteException;
}
