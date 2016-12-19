package promotionHotel;
import java.util.ArrayList;

import Object.Promotion;
import VO.*;
import common.*;
import promotionBLService.PromotionBLService;
public class PromotionHotel_Driver {
	 public void drive(PromotionBLService promotionBLService){
		 ResultMessage result=promotionBLService.madebyhotel(new PromotionVO());
			if(result ==ResultMessage.Exist) System.out.println("madebyhotel success");
		 
		 
	 }
}
