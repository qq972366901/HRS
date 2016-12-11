package HotelBLServiceImpl;

import java.rmi.RemoteException;

import PO.HotelPO;
import VO.HotelVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class HotelInfo {
	
	private String hotelID;
	
	private HotelVO hvo;
	
	private DataFactoryService df;
	private HotelDataService hds;
	
	private String key = null;
	
//	private static HotelInfo hotelInfo;
	
	public HotelInfo(String id) {
		hotelID = id;
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			key=Log.getLogInstance().getKey(hotelID);
			HotelPO hpo = hds.find(DES.encryptDES(hotelID, key));
			hvo = new HotelVO(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
//	public static HotelInfo getHotelInfoInstance(String id) {
//		if(hotelInfo == null) {
//			hotelInfo = new HotelInfo(id);
//		}
//		return hotelInfo;
//	}
	
	public void updateHotelInfo(String hName, String hLocation, String hService, String hCity,
			String hArea, String hIntroduce, int hStar, String hPhone) {
		hvo.hotelName = hName;
		hvo.hotelAddress = hLocation;
		hvo.hotelService = hService;
		hvo.hotelCity = hCity;
		hvo.hotelDistrict = hArea;
		hvo.hotelProfile = hIntroduce;
		hvo.hotelStar = hStar;
		if(key!=null){
			hvo.hotelPhone = DES.encryptDES(hPhone, key);
		}
		else{
			System.out.println("加密失败");
		}
		
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,hvo.score,hvo.hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public HotelVO getHotelVO() {
		return this.hvo;
	}
	
	public void updateHotelPhone(String hotelPhone) {
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,hvo.score,hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void updateHotelScore(int sco) {
		double newScore;
		if(hvo.score - 0 < 0.001) {
			newScore = sco;
		} else {
			int num = 1;
			while(hvo.score * num % 1 > 0.01) {
				num++;
			}
			newScore = (hvo.score*num + sco) / (num + 1);
		}
		HotelPO hpo = new HotelPO(hvo.hotelAddress,hvo.hotelCity, hvo.hotelDistrict,hvo.hotelStar,hvo.hotelProfile,hvo.hotelService,hvo.hotelName,hvo.hotelAccount,newScore,hvo.hotelPhone);
		try {
			hds.update(hpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public double getHotelScore() {
		return hvo.score;
	}

}
