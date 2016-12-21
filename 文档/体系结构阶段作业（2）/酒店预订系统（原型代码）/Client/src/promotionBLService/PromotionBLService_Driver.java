package promotionBLService;
import java.util.ArrayList;

import Object.Promotion;
import VO.*;
import common.*;
import hotelBLService.HotelBLService;
public class PromotionBLService_Driver {
	public void drive(PromotionBLService promotionBLService){
	ResultMessage result1=promotionBLService.madebyhotel(new PromotionVO());
	if(result1 ==ResultMessage.Exist) System.out.println("madebyhotel success");
	ResultMessage result2=promotionBLService.madebyweb(new PromotionVO());
	if(result2 ==ResultMessage.Exist) System.out.println("madebyweb success");
	ResultMessage result3=promotionBLService.memberlevelmade(new PromotionVO());
	if(result3 ==ResultMessage.Exist) System.out.println("memberlevelmade success");
	boolean result4=promotionBLService.cancel(new Promotion());
	if(result4) System.out.println("cancel success");
	ArrayList<PromotionVO> result5=promotionBLService.getPromotion("123");
	if(result5 ==new ArrayList<PromotionVO>()) System.out.println("getPromotion success");
	
}
}
