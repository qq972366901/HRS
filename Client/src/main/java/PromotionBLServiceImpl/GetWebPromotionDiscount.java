package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import PO.PromotionPO;
import VO.MemberLevelSystemVO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;
import userBLServiceImpl.Credit;

public class GetWebPromotionDiscount {
		private DataFactoryService df;
		private PromotionDataService pds;
		private List<WebPromotionVO> voList=new ArrayList<WebPromotionVO>();
		private static GetWebPromotionDiscount getWebPromotionDiscount;
		
		private GetWebPromotionDiscount() {
			df=RemoteHelper.getInstance().getDataFactoryService();
			try {
				pds = (PromotionDataService)df.getDataService("Promotion");
				List<PromotionPO> poList = pds.getAllWebPromotion();
				for(PromotionPO po : poList) {
					WebPromotionVO tempvo = new WebPromotionVO(po);
					voList.add(tempvo);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		public static GetWebPromotionDiscount getWebPromotionDiscountInstance() {
			if(getWebPromotionDiscount== null) {
				getWebPromotionDiscount = new GetWebPromotionDiscount();
			}
			return getWebPromotionDiscount;
		}
		
		public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException {
			WebPromotionVO  wpvo=null;
			Credit c=new Credit();
			int grade=c.showLevel(userID);
			MemberLevelSystemVO vo2=GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
			for(WebPromotionVO vo : voList) {
			if(getWebPromotionDiscount.judgeTime(vo,orderbuildtime)&&getWebPromotionDiscount.judgeCity(vo,city) &&getWebPromotionDiscount.judgeBussinessCircle(vo,bussinesscircle) &&getWebPromotionDiscount.judgeMemberGrade(vo,grade)) {				
				    wpvo=vo;
					break;
				}
			}
			double discount[]=vo2.discountOfLevel;
				if(wpvo==null){
					return 1;
				}
				else{
					if(grade==0){
						return 1;
					}
					else{
					return discount[grade-1]/10;
				}
				}
		}
		private boolean judgeTime(WebPromotionVO vo,Calendar time) {
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
		private boolean judgeCity(WebPromotionVO vo, String city) {
			boolean outcome = false;
			if(vo.applyCity.equals(city)) {
				outcome = true;
			}
			return outcome;
		}
		private boolean judgeBussinessCircle(WebPromotionVO vo, String bussinesscircle) {
			boolean outcome = false;
			if(vo.applyBussinesscircle.equals(bussinesscircle)) {
				outcome = true;
			}
			return outcome;
		}
		private boolean judgeMemberGrade(WebPromotionVO vo,int grade) {
			boolean outcome = false;
			if(vo.applyMemberGrade<=grade) {
				outcome = true;
			}
			return outcome;
		}
}
