package List;
import java.util.*;

import LineItem.PromotionLineItem;
public class PromotionList {

	List<PromotionLineItem> promotions;
	
	/**
	 * 营销策略列表
	 * @param
	 * @return
	 */
	public PromotionList () {
		
		promotions = new ArrayList<PromotionLineItem>();
		
	}
	
	/**
	 * 添加单个营销策略
	 * @param pli PromotionLineItem型，添加的单个营销策略
	 * @return 
	 */
	public void addPromotionLineItems(PromotionLineItem  pli) {
		promotions.add(pli);
	}
	/**
	 * 删除单个营销策略
	 * @param pli PromotionLineItem型，删除的单个营销策略
	 * @return 
	 */
	public void deletePromotionLineItems(PromotionLineItem  pli) {
		promotions.remove(pli);
	}
	/**
	 * 得到营销策略列表数量
	 * @param
	 * @return 返回营销策略列表数量
	 */
	public int getPromotionInfo() {
		return promotions.size();
	}
	/**
	 * 得到营销策略列表数量
	 * @param
	 * @return 返回营销策略列表数量
	 */
	public int getPromotion() {
		return promotions.size();
	}
	/**
	 * 得到符合条件的营销策略
	 * @param
	 * @return 返回营销策略数
	 */
	public int getPromotion(String userID) {
		int num = 0;
		for(int i=0;i<promotions.size();i++) {
			if(promotions.get(i).pro().equals(userID)) {
				num++;
			}
		}
		return num;
	}
}	



