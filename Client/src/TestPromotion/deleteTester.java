package TestPromotion;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.Time;
import LineItem.PromotionLineItem;
import List.PromotionList;
import Mock.MockPromotion;
import Object.Promotion;
public class deleteTester {

	@Test
	public void test() {
		Time time1 = null;
		Time time2 = null;
		Time time3 = null;
		MockPromotion promotion1=new MockPromotion("1","双十一",time1,time2,time3,3,false,null,null,2);
		MockPromotion promotion2=new MockPromotion("2","双十二",time1,time2,time3,0,false,"新街口",null,3);
		
		PromotionList promotionList=new PromotionList();
		
		PromotionLineItem promotionLineItem1 = new PromotionLineItem(promotion1);
		PromotionLineItem promotionLineItem2 = new PromotionLineItem(promotion2);
		
		promotionList.addPromotionLineItems(promotionLineItem1);
		promotionList.addPromotionLineItems(promotionLineItem2);
		
		Promotion promotion = new Promotion();
		promotion.addPromotionList(promotionList);
		
		assertEquals(2, promotion.delete(promotion1));
	}

}
