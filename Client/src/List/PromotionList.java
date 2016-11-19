package List;
import java.util.*;

import VO.UserVO;
import LineItem.OrderLineItem;
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
	 * 显示营销策略列表
	 * @param pli PromotionLineItem型，显示的单个营销策略
	 * @return list列表
	 */
	public List<PromotionLineItem> show(){
		return promotions;
	}
	/**
	 * 取消营销策略
	 * @param str String型，id
	 * @param time Time型，撤销时间
	 */
	public void cancel(String promotionnumber) {
		for(int i=0;i<promotions.size();i++){
			if(promotions.get(i).getvo().promotionNumber.equals(promotionnumber)){
				promotions.get(i).cancel();
			}
		}
	}
	/**
	 * 取消营销策略
	 *
	 */
	public void cancel() {
		promotions.get(0).cancel();
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
	public int getPromotion2() {
		return promotions.size();
	}
	/**
	 * 得到用户可用的营销策略
	 * @param
	 * @return 返回营销策略
	 */
	public List<PromotionLineItem> getPromotion(){
		List<PromotionLineItem> list=new ArrayList<PromotionLineItem>();
		for(int i=0;i<promotions.size();i++){
			if((promotions.get(i).getvo().applyuserType.equals(promotions.get(i).getvo().userType))&&(promotions.get(i).getvo().applyuserShipgrade==promotions.get(i).getvo().userShipgrade)){
				list.add(promotions.get(i));
			}
		}
		   return list;
	}
}


