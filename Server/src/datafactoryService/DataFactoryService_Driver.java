package datafactoryService;

import java.rmi.RemoteException;

import dataService.DataService;

public class DataFactoryService_Driver {
	public void drive(DataFactoryService dataFactoryService) throws RemoteException{
		DataService d1=dataFactoryService.getCreditRecordData();
		DataService d2=dataFactoryService.getHotelData();
		DataService d3=dataFactoryService.getOrderData();
		DataService d4=dataFactoryService.getPromotionData();
		DataService d5=dataFactoryService.getRoomData();
		DataService d6=dataFactoryService.getUserData();
	}
}
