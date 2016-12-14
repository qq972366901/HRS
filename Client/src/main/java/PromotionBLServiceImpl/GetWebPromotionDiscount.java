package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
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
		private List<WebPromotionVO> voList;
		private static GetWebPromotionDiscount getWebPromotionDiscount;
		
		private GetWebPromotionDiscount() {
			voList=new ArrayList<WebPromotionVO>();
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
			WebPromotionVO  wpvo=new WebPromotionVO();
			int grade=Credit.getInstance().showLevel(userID);
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
					return discount[grade-1];
				}
				}
		}
		private boolean judgeTime(WebPromotionVO vo,Calendar time) {
			boolean outcome = false;
		if(time.compareTo(vo.promotionBegintime)>=0&&time.compareTo(vo.promotionEndtime)<=0) {
				outcome = true;
			}
			return outcome;
			
		}
		private boolean judgeCity(WebPromotionVO vo, String city) {
			boolean outcome = false;
			if(vo.applyCity ==city) {
				outcome = true;
			}
			return outcome;
		}
		private boolean judgeBussinessCircle(WebPromotionVO vo, String bussinesscircle) {
			boolean outcome = false;
			if(vo.applyBussinesscircle==bussinesscircle) {
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
