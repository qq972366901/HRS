package TestPromotion;

import static org.junit.Assert.*;
import java.sql.Time;
import org.junit.Test;
import LineItem.PromotionLineItem;
import List.PromotionList;
import Mock.MockPromotion;
import Object.Promotion;
public class getPromotionTester {

	@Test
	public void test() {
        Time time1=null;
        Time time2=null;
        Time time3=null;
		Promotion promotion1 = new Promotion("1","双十一",time1,time2,time3,3,false,null,null,2);
		Promotion promotion2 = new Promotion("2","双十二",time1,time2,time3,0,false,"新街口",null,3);
		
		PromotionList promotionList = new PromotionList();
		
		PromotionLineItem promotionLineItem1 = new PromotionLineItem(promotion1);
		PromotionLineItem promotionLineItem2 = new PromotionLineItem(promotion2);
		
		promotionList.addPromotionLineItems(promotionLineItem1);
		promotionList.addPromotionLineItems(promotionLineItem2);
		
		Promotion promotion = new Promotion();
		
		promotion.addPromotionList(promotionList);
		
		assertEquals(0, promotion.getPromotion("123"));
	
	}

}
