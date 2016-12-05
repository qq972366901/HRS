package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import PO.PromotionPO;
import VO.MemberLevelSystemVO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import promotionMemberGrade.PromotionMemberGradeController;
import rmi.RemoteHelper;
import userBLServiceImpl.Credit;

public class SearchWebPromotion {
	private DataFactoryService df;
	private PromotionDataService pds;
	private List<WebPromotionVO> voList;
	private static SearchWebPromotion searchWebPromotion;
	
	private SearchWebPromotion() {
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
	
	public static SearchWebPromotion getSearchWebPromotionInstance() {
		if(searchWebPromotion== null) {
			searchWebPromotion = new SearchWebPromotion();
		}
		return searchWebPromotion;
	}
	
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException {
		WebPromotionVO  wpvo=new WebPromotionVO();
		long creditvalue=Credit.getInstance().showCredit(userID);
		MemberLevelSystemVO vo2=GetMemberLevelSystem.getMemberLevelSystemInstance().getMemberLevelSystem();
		long credit[]=vo2.creditOfLevel;
		int grade;
		if(creditvalue<credit[0]){
				grade=0;
			}
		else if(creditvalue>=credit[0]&&creditvalue<credit[1]){
			    grade=1;
		}
		else if(creditvalue>=credit[1]&&creditvalue<credit[2]){
		        grade=2;
	    }
		else if(creditvalue>=credit[2]&&creditvalue<credit[3]){
		        grade=3;
	    }
		else if(creditvalue>=credit[3]&&creditvalue<credit[4]){
		        grade=4;
	    }
		else{
		        grade=5;
		}
		for(WebPromotionVO vo : voList) {
		if(searchWebPromotion.judgeTime(vo,orderbuildtime)&&searchWebPromotion.judgeCity(vo,city) &&searchWebPromotion.judgeBussinessCircle(vo,bussinesscircle) &&searchWebPromotion.judgeMemberGrade(vo,grade)) {				
			    wpvo=vo;
				break;
			}
		}
		double discount[]=vo2.discountOfLevel;
			if(wpvo==null){
				return 1;
			}
			else{
				return discount[grade-1];
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
	public WebPromotionVO getWebPromotionByPromotionNumber(String promotionnumber) {
		WebPromotionVO  wpvo=new WebPromotionVO();
		for(WebPromotionVO vo : voList) {
		if(searchWebPromotion.judgePromotionNumber(vo,promotionnumber)) {				
			    wpvo=vo;
				break;
			}
		}
		return wpvo;
	}
	private boolean judgePromotionNumber(WebPromotionVO vo,String promotionnumber) {
		boolean outcome = false;
		if(vo.promotionNumber==promotionnumber) {
			outcome = true;
		}
		return outcome;
	}
	public Vector<Vector<String>> getAllWebPromotion(){
		voList=new Vector<WebPromotionVO>();
		Vector< Vector<String>> list=new Vector<Vector<String>>();
		for(int i=0;i<voList.size();i++){
			Vector<String> v=voList.get(i).getVector();
			//PromotionMemberGradeController p=new PromotionMemberGradeController();
			//v.add(String.valueOf(p.getDiscountOfLevel(voList.get(i).applyMemberGrade)));
			list.add(v);
		}
		return list;
	}
}
