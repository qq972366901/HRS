package HotelBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;
import VO.HotelVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import rmi.RemoteHelper;

public class HotelInfoListByUser {

	private String userID;
	private List<HotelVO> list;
	
	private DataFactoryService df;
	private HotelDataService hds;
	
	private static HotelInfoListByUser hotelInfoListByUser;
	
	private HotelInfoListByUser(String userid) {
		userID = userid;
		df=RemoteHelper.getInstance().getDataFactoryService();
		list=new ArrayList<HotelVO>();
		try {
			hds = (HotelDataService)df.getDataService("Hotel");
			List<HotelPO> listpo = hds.getHistoryHotelByUser(userID);
			for(HotelPO hpo : listpo) {
				HotelVO vo = new HotelVO(hpo);
				list.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static HotelInfoListByUser getHotelInfoListByUserInstance(String userid) {
		if(hotelInfoListByUser == null) {
			hotelInfoListByUser = new HotelInfoListByUser(userid);
		}
		return hotelInfoListByUser;
	}
	
	public List<HotelVO> getHistoryHotel() {
		return list;
	}
	
	
}
