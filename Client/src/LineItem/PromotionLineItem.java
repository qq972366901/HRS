package LineItem;

import VO.PromotionVO;
public class PromotionLineItem {
   PromotionVO vo;	
	/**
	 * 单个营销策略
	 * @param p Promotion型，传入营销策略对象
	 * @return 单个营销策略
	 */
	public PromotionLineItem (PromotionVO vo) {
		this.vo=vo;
	}
	public PromotionVO getvo(){
   	 return vo;
    }
	 /**
 	 * 取消营销策略
 	 * 
 	 */
     public void cancel(){
    	 vo.promotionState=0;
     }
}
