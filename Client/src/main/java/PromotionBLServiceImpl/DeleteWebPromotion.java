package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

import PO.HotelPO;
import PO.PromotionPO;
import VO.HotelVO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class DeleteWebPromotion {
	private DataFactoryService df;
	private PromotionDataService pds;
	private String promotionNumber;
	private WebPromotionVO wvo;
	
	private static DeleteWebPromotion deleteWebPromotion;
	
	private DeleteWebPromotion(String id) {
		promotionNumber=id;
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
			PromotionPO ppo = pds.find(promotionNumber);
			wvo = new WebPromotionVO(ppo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static DeleteWebPromotion getDeleteWebPromotionInstance(String id) {
		if(deleteWebPromotion == null) {
			deleteWebPromotion = new DeleteWebPromotion(id);
		}
		return deleteWebPromotion;
	}
	public boolean deleteWebPromotion(String promotionnumber){
		wvo.promotionNumber=null;
		wvo.promotionName=null;
		wvo.promotionBegintime=null;
		wvo.promotionEndtime=null;
		wvo.applyCity=null;
		wvo.applyBussinesscircle=null;
		wvo.applyMemberGrade=-1;
		PromotionPO po=new PromotionPO(wvo.promotionNumber,wvo.promotionName,wvo.promotionBegintime,wvo.promotionEndtime,wvo.applyCity,wvo.applyBussinesscircle,wvo.applyMemberGrade,wvo.discount);
		try {
			pds.delete(po);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	}
