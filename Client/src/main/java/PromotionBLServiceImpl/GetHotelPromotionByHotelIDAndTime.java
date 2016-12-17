package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import PO.PromotionPO;
import VO.HotelPromotionVO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class GetHotelPromotionByHotelIDAndTime {
	private DataFactoryService df;
	private PromotionDataService pds;
	private List<HotelPromotionVO> voList=new ArrayList<HotelPromotionVO>();
	private static GetHotelPromotionByHotelIDAndTime getHotelPromotionByHotelID;
	private GetHotelPromotionByHotelIDAndTime() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
			List<Vector<PromotionPO>> poList = pds.getAllHotelPromotion();
			for(Vector<PromotionPO> polist : poList) {
				for(PromotionPO po : polist){
				HotelPromotionVO tempvo = new HotelPromotionVO(po);
				voList.add(tempvo);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static GetHotelPromotionByHotelIDAndTime getHotelPromotionByHotelIDInstance() {
		if(getHotelPromotionByHotelID== null) {
			getHotelPromotionByHotelID= new GetHotelPromotionByHotelIDAndTime();
		}
		return getHotelPromotionByHotelID;
	}
	public HotelPromotionVO getHotelPromotionByHotelIDAndTime(String hotelid,Calendar time) {
	    HotelPromotionVO  hpvo=new HotelPromotionVO();
		for(HotelPromotionVO vo : voList) {
		if((getHotelPromotionByHotelID.judgeHotelID(vo,hotelid))&&getHotelPromotionByHotelID.judgeTime(vo,time)) {
			    hpvo=vo;
				break;
			}
		}
		return hpvo;
	}
	private boolean judgeHotelID(HotelPromotionVO vo,String hotelid) {
		boolean outcome = false;
		if(vo.hotelID.equals(hotelid)) {
			outcome = true;
		}
		return outcome;
	}
	private boolean judgeTime(HotelPromotionVO vo,Calendar time) {
		boolean outcome = false;
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		Calendar cal3=Calendar.getInstance();
		int year1=vo.promotionBegintime.get(Calendar.YEAR);
		int month1=vo.promotionBegintime.get(Calendar.MONTH);
		int day1=vo.promotionBegintime.get(Calendar.DAY_OF_MONTH);
		cal1.set(year1,month1,day1);
		int year2=vo.promotionEndtime.get(Calendar.YEAR);
	    int month2=vo.promotionEndtime.get(Calendar.MONTH);
		int day2=vo.promotionEndtime.get(Calendar.DAY_OF_MONTH);
	    cal2.set(year2,month2,day2);
	    int year3=time.get(Calendar.YEAR);
	    int month3=time.get(Calendar.MONTH);
		int day3=time.get(Calendar.DAY_OF_MONTH);
		cal3.set(year3,month3,day3);
		Date date1=cal1.getTime(); 
		Date date2=cal2.getTime(); 
		Date date3=cal3.getTime(); 
	if(date3.getTime()>=date1.getTime()&&date3.getTime()<=date2.getTime()) {
			outcome = true;
		}
		return outcome;
		
	}
}
