package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import PO.PromotionPO;
import VO.HotelPromotionVO;
import VO.HotelVO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;
import userBLServiceImpl.Customer;

public class GetHotelPromotionDiscount {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private List<HotelPromotionVO> voList= new ArrayList<HotelPromotionVO>();;
	
	private static GetHotelPromotionDiscount getHotelPromotionDiscount;
	
	private GetHotelPromotionDiscount() {
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
	
	public static GetHotelPromotionDiscount getGetHotelPromotionDiscountInstance() {
		if(getHotelPromotionDiscount== null) {
			getHotelPromotionDiscount = new GetHotelPromotionDiscount();
		}
		return getHotelPromotionDiscount;
	}
	
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException {
		HotelPromotionVO  hpvo=new HotelPromotionVO();
		for(HotelPromotionVO vo : voList) {
		if(getHotelPromotionDiscount.judgeHotel(vo,hotelid) &&getHotelPromotionDiscount.judgeTime(vo,orderbuildtime)) {				
			    hpvo=vo;
				break;
			}
		}
		double discount;
		if(hpvo.hotelID==null){
			discount=1;
		}
		else{
		discount=hpvo.discount/10;
		UserVO vo1=Customer.getUserInstance().findByID(userID);
		Calendar birthday=vo1.birthday;
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		Calendar cal3=Calendar.getInstance();
		int year1=begintime.get(Calendar.YEAR);
		int month1=begintime.get(Calendar.MONTH);
		int day1=begintime.get(Calendar.DAY_OF_MONTH);
		cal1.set(year1,month1,day1);
		int year2=endtime.get(Calendar.YEAR);
	    int month2=endtime.get(Calendar.MONTH);
		int day2=endtime.get(Calendar.DAY_OF_MONTH);
	    cal2.set(year2,month2,day2);
	    int year3=birthday.get(Calendar.YEAR);
	    int month3=birthday.get(Calendar.MONTH);
		int day3=birthday.get(Calendar.DAY_OF_MONTH);
		cal3.set(year3,month3,day3);
		Date date1=cal1.getTime(); 
		Date date2=cal2.getTime(); 
		Date date3=cal3.getTime(); 
	if(date3.getTime()>=date1.getTime()&&date3.getTime()<=date2.getTime()) {
			discount=discount*(hpvo.birthdayDiscount/10);
		}
		if(roomNumber>=3){
			discount=discount*(hpvo.roomDiscount/10);
		}
		String membertype=vo1.membertype;
		if(membertype.equals("企业会员")){
			discount=discount*(hpvo.enterpriseDiscount/10);
		}
		}
		return discount;
	}
	
	private boolean judgeHotel(HotelPromotionVO vo, String hotelid) {
		boolean outcome = false;
		if(vo.hotelID .equals(hotelid)) {
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
