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
		MockPromotion promotion = new MockPromotion(null, null, null, null, null, 0, false, null, null, 0);
		ResultMessage memberGrade=promotion.setmemberGrade(20);
		assertEquals(memberGrade, memberGrade);
	}

}
