package TestPromotion;

import static org.junit.Assert.*;

import org.junit.Test;
import LineItem.PromotionLineItem;
import List.PromotionList;
import Mock.MockPromotion;
import Object.Promotion;
import common.ResultMessage;
public class setmemberGradeTester {

	@Test
	public void test() {
		Promotion promotion = new Promotion();
		promotion.setmemberGradeDiscount(0.1,0.2,0.3,0.4,0.5);
		assertEquals(5,5);
	}

}
