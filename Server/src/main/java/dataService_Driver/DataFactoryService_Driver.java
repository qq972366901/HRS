package dataService_Driver;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.DataService;

public class DataFactoryService_Driver {
	public void drive(DataFactoryService dataFactoryService) throws RemoteException{
		DataService d1=dataFactoryService.getDataService("User");
		DataService d2=dataFactoryService.getDataService("Hotel");
		DataService d3=dataFactoryService.getDataService("CreditRecord");
		DataService d4=dataFactoryService.getDataService("Promotion");
		DataService d5=dataFactoryService.getDataService("Room");
		DataService d6=dataFactoryService.getDataService("Order");
	}
}
