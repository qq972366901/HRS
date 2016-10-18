package promotionWeb;
import java.util.ArrayList;

import Object.Promotion;
import VO.*;
import common.*;
import promotionBLService.PromotionBLService;
public class PromotionWeb_Driver {
	 public void drive(PromotionBLService promotionBLService){
		 ResultMessage result1=promotionBLService.madebyweb(new PromotionVO());
			if(result1 ==ResultMessage.Exist) System.out.println("madebyweb success");
			ResultMessage result2=promotionBLService.memberlevelmade(new PromotionVO());
			if(result2 ==ResultMessage.Exist) System.out.println("memberlevelmade success");
		 
		 
	 }
}
