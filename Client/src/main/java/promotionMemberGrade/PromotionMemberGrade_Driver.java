package promotionMemberGrade;
import java.util.ArrayList;

import Object.Promotion;
import VO.*;
import common.*;
import promotionBLService.PromotionBLService;
public class PromotionMemberGrade_Driver {
	 public void drive(PromotionBLService promotionBLService){
			boolean result1=promotionBLService.cancel(new Promotion());
			if(result1) System.out.println("cancel success");
			ArrayList<PromotionVO> result2=promotionBLService.getPromotion("123");
			if(result2 ==new ArrayList<PromotionVO>()) System.out.println("getPromotion success");
		 
		 
	 }
}
