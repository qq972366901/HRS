package dataService_Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import dataService.HotelDataService;

public class HotelDataService_Driver {
	public void drive(HotelDataService hotelDataService) throws RemoteException{
		ArrayList<HotelPO> a=new ArrayList<HotelPO>();
		HotelPO po=hotelDataService.find("423523");
		a=hotelDataService.findByDistrict("оиаж");
		po=hotelDataService.findByName("xxx");
		a=hotelDataService.findByScore(4);
		a=hotelDataService.findByStar(2);
		hotelDataService.insert(po);
		hotelDataService.update(po);
		hotelDataService.delete(po);
		hotelDataService.init();
		hotelDataService.finish();
	}
}
