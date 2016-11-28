package HotelBLServiceImpl;

import java.rmi.RemoteException;

import PO.HotelPO;
import VO.HotelVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;

public class HotelInfo {
	
	private String hotelID;
	
	private HotelVO hvo;
	
	private DataFactoryService df;
	private HotelDataService hds;
	
	private static HotelInfo hotelInfo;
	
	private HotelInfo(String id) {
		hotelID = id;
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			HotelPO hpo = hds.find(hotelID);
			hvo = new HotelVO(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static HotelInfo getHotelInfoInstance(String id) {
		if(hotelInfo == null) {
			hotelInfo = new HotelInfo(id);
		}
		return hotelInfo;
	}
	
	public void updateHotelInfo(String hName, String hLocation, String hService, String hCity,
			String hArea, String hIntroduce, int hStar, String hPhone) {
		hvo.hotelName = hName;
		hvo.hotelAddress = hLocation;
		hvo.hotelService = hService;
		hvo.hotelCity = hCity;
		hvo.hotelDistrict = hArea;
		hvo.hotelProfile = hIntroduce;
		hvo.hotelStar = hStar;
		hvo.hotelPhone = hPhone;
		
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,hvo.score);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public HotelVO getHotelVO() {
		return this.hvo;
	}

}
