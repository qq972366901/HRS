package HotelBLServiceImpl;

import java.rmi.RemoteException;

import PO.HotelPO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;

public class HotelAdd {

	private DataFactoryService df;
	private HotelDataService hds;
	
	private static HotelAdd hotelAdd;
	
	private HotelAdd() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static HotelAdd getHotelAddInstance() {
		if(hotelAdd == null) {
			hotelAdd = new HotelAdd();
		}
		return hotelAdd;
	}
	
	
	public void addHotel(String hotelName, String hotelCity, String hotelArea, String hotelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore) {
		HotelPO hpo = new HotelPO(hotelLocation, hotelCity, hotelArea, hotelStar,hotelIntroduction,
				hotelService,hotelName,hotelID,hotelScore,hotelPhone);
		
		try {
			hds.insert(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
