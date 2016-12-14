package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import PO.PromotionPO;
import VO.HotelPromotionVO;
import VO.UserVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;
import userBLServiceImpl.Customer;

public class GetHotelPromotionDiscount {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private List<HotelPromotionVO> voList;
	
	private static GetHotelPromotionDiscount getHotelPromotionDiscount;
	
	private GetHotelPromotionDiscount() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
			List<PromotionPO> poList = pds.getAllHotelPromotion();
			for(PromotionPO po : poList) {
				HotelPromotionVO tempvo = new HotelPromotionVO(po);
				voList.add(tempvo);
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
	
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime) throws RemoteException {
		HotelPromotionVO  hpvo=new HotelPromotionVO();
		for(HotelPromotionVO vo : voList) {
		if(getHotelPromotionDiscount.judgeHotel(vo,hotelid) &&getHotelPromotionDiscount.judgeTime(vo,orderbuildtime)) {				
			    hpvo=vo;
				break;
			}
		}
		double discount;
		if(hpvo==null){
			discount=1;
		}
		else{
		discount=hpvo.discount;
		UserVO vo1=Customer.getUserInstance().findByID(userID);
		Calendar birthday=vo1.birthday;
		String membertype=vo1.membertype;
		if(birthday.compareTo(hpvo. promotionBegintime)>=0&&birthday.compareTo(hpvo. promotionEndtime)<=0){
			discount=discount*(hpvo.birthdayDiscount);
		}
		if(roomNumber>=3){
			discount=discount*(hpvo.roomDiscount);
		}
		if(membertype.equals("企业会员")){
			discount=discount*(hpvo.enterpriseDiscount);
		}
		}
		return discount;
	}
	
	private boolean judgeHotel(HotelPromotionVO vo, String hotelid) {
		boolean outcome = false;
		if(vo.hotelID == hotelid) {
			outcome = true;
		}
		return outcome;
	}
	private boolean judgeTime(HotelPromotionVO vo,Calendar time) {
		boolean outcome = false;
	if(time.compareTo(vo.promotionBegintime)>=0&&time.compareTo(vo.promotionEndtime)<=0) {
			outcome = true;
		}
		return outcome;
		
	}

	
	
}
