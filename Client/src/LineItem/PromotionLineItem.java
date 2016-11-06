package LineItem;

import Object.Promotion;
public class PromotionLineItem {
Promotion promotion;
	
	/**
	 * 单个营销策略
	 * @param p Promotion型，传入营销策略对象
	 * @return 单个营销策略
	 */
	public PromotionLineItem (Promotion p) {
		promotion= p;
	}
	/**
	 * @param 
	 * @return 营销策略名称
	 */
	public String pro() {
		return promotion.getpromotionId();	
	}
}

