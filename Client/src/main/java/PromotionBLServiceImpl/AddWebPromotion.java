package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

import PO.PromotionPO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class AddWebPromotion {

	private DataFactoryService df;
	private PromotionDataService pds;
	private PromotionDataService promotiondata;
	
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
	
	
	public void addWebPromotion(String promotionname,Calendar promotionbegintime,Calendar promotionendtime,String applycity,String applybussinesscircle,int applymembergrade) throws RemoteException{
		PromotionPO po = new PromotionPO(promotiondata.generateWebPromotionID(),promotionname,promotionbegintime,promotionendtime,applycity,applybussinesscircle,applymembergrade);
		
		try {
			pds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
