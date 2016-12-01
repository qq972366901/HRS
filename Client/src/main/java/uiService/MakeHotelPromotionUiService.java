package uiService;

import java.util.Calendar;

import HotelWorkerView.MakeHotelPromotionView;

public interface MakeHotelPromotionUiService {

	public void setView(MakeHotelPromotionView view);
	public void toHotelMainView();
	public void makeHotelPromotion(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount);//系统更新酒店营销策略
	
}
