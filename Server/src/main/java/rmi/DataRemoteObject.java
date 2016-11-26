package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dataService.DataFactoryService;
import dataService.DataService;

public class DataRemoteObject extends UnicastRemoteObject implements Serializable,dataService.DataFactoryService,DataService{
	private static final long serialVersionUID = 4029039744279087114L;
	
	private DataFactoryService dataFactoryService;
	
	protected DataRemoteObject() throws RemoteException {
		if(dataFactoryService==null){
			dataFactoryService = new datafactory.DataFactoryMySqlImpl_Stub();
		}
		
	}

	@Override
	public DataService getDataService(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getDataService(type);
	}
}
