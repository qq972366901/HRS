package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataService.DataService;
import datafactory.DataFactoryMySqlImpl;
import datafactoryService.DataFactoryService;

public class DataRemoteObject extends UnicastRemoteObject implements DataFactoryService{
	private static final long serialVersionUID = 4029039744279087114L;
	
	private DataFactoryService dataFactoryService;
	
	protected DataRemoteObject() throws RemoteException {
		
		dataFactoryService = new DataFactoryMySqlImpl();
		
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
