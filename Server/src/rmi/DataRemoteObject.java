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
		
		dataFactoryService = new datafactory.DataFactoryMySqlImpl_Stub();
		
	}

	@Override
	public DataService getUserData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getUserData();
	}

	@Override
	public DataService getCreditRecordData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getCreditRecordData();
	}

	@Override
	public DataService getPromotionData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getPromotionData();
	}

	@Override
	public DataService getOrderData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getOrderData();
	}

	@Override
	public DataService getHotelData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getHotelData();
	}

	@Override
	public DataService getRoomData() throws RemoteException {
		// TODO Auto-generated method stub
		return dataFactoryService.getRoomData();
	}
}
