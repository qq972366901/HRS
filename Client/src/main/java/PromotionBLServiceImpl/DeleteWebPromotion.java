package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

import PO.PromotionPO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class DeleteWebPromotion {
	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static DeleteWebPromotion deleteWebPromotion;
	
	private DeleteWebPromotion() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static DeleteWebPromotion getDeleteWebPromotionInstance() {
		if(deleteWebPromotion == null) {
			deleteWebPromotion = new DeleteWebPromotion();
		}
		return deleteWebPromotion;
	}
	public boolean deleteWebPromotion(String promotionnumber){
		WebPromotionVO vo=SearchWebPromotion.getSearchWebPromotionInstance().getWebPromotionByPromotionNumber(promotionnumber);
		String promotionname=vo.promotionName;
		Calendar time1=vo.promotionBegintime;
		Calendar time2=vo.promotionEndtime;
		String city=vo.applyCity;
		String circle=vo.applyBussinesscircle;
		int grade=vo.applyMemberGrade;
		PromotionPO po=new PromotionPO(promotionnumber,promotionname,time1,time2,city,circle,grade);
		try {
			pds.delete(po);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	}
