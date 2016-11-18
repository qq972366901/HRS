package TestPromotion;

import static org.junit.Assert.*;
import java.sql.Time;
import java.util.Calendar;

import org.junit.Test;
import LineItem.PromotionLineItem;
import List.PromotionList;
import Mock.MockPromotion;
import Object.Promotion;
public class getPromotionTester {


	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Calendar time1=Calendar.getInstance();
		time1.set(Calendar.YEAR,2006);
		time1.set(Calendar.MONTH,8);
		time1.set(Calendar.DAY_OF_MONTH,3);
		Calendar time2 =Calendar.getInstance();;
		time2.set(Calendar.YEAR, 2007);
		time2.set(Calendar.MONTH, 8);
		time2.set(Calendar.DAY_OF_MONTH, 3);
		Calendar time3 =Calendar.getInstance();
		time3.set(Calendar.YEAR, 2000);
		time3.set(Calendar.MONTH, 8);
		time3.set(Calendar.DAY_OF_MONTH, 3);
		MockPromotion promotion1=new MockPromotion("1","双十一",1,time1,time2,"1",null,0,1,0.7,null,0,0,time3);
		MockPromotion promotion2=new MockPromotion("2","双十一",1,time1,time2,null,"新街口",2,0,0.8,null,0,0,time3);
		PromotionList list=new PromotionList();
		
		PromotionLineItem item1 = new PromotionLineItem(promotion1);
		PromotionLineItem item2 = new PromotionLineItem(promotion2);
		
		list.addPromotionLineItems(item1);
		list.addPromotionLineItems(item2);
		
		Promotion promotion = new Promotion();
		promotion.addpromotionlist(list);
		promotion.hoteladd("1","双十一",time1,time2,"1",1,0.7);
		promotion.webadd("2","双十一",time1,time2,"新街口",2,0.8);
		assertEquals( promotion.getPromotion(),0.7);
	
	}

}
