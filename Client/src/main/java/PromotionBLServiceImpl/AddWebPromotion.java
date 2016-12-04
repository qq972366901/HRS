package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

import PO.PromotionPO;
import VO.WebPromotionVO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class AddWebPromotion {

	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static AddWebPromotion addWebPromotion;
	
	private AddWebPromotion() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static AddWebPromotion getAddWebPromotionInstance() {
		if(addWebPromotion == null) {
			addWebPromotion = new AddWebPromotion();
		}
		return addWebPromotion;
	}
	
	
	public void addWebPromotion(WebPromotionVO vo) throws RemoteException{
		PromotionPO po = new PromotionPO(vo.promotionNumber,vo.promotionName,vo.promotionBegintime,vo.promotionEndtime,vo.applyCity,vo.applyBussinesscircle,vo.applyMemberGrade);
		
		try {
			pds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
