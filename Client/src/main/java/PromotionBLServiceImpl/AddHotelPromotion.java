package PromotionBLServiceImpl;

import java.rmi.RemoteException;
import java.util.Calendar;

import PO.PromotionPO;
import dataService.DataFactoryService;
import dataService.PromotionDataService;
import rmi.RemoteHelper;

public class AddHotelPromotion {

	private DataFactoryService df;
	private PromotionDataService pds;
	
	private static AddHotelPromotion addHotelPromotion;
	
	private AddHotelPromotion() {
		df=RemoteHelper.getInstance().getDataFactoryService();
		try {
			pds = (PromotionDataService)df.getDataService("Promotion");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static AddHotelPromotion getAddHotelPromotionInstance() {
		if(addHotelPromotion == null) {
			addHotelPromotion = new AddHotelPromotion();
		}
		return addHotelPromotion;
	}
	
	
	public void addHotelPromotion(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount){
		PromotionPO po = new PromotionPO(hotelid,promotionname,promotionbegintime,promotionendtime,promotiondiscount,birthdaydiscount,roomdiscount,enterprisediscount);
		
		try {
			pds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
