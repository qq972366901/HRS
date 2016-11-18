package List;
import java.util.*;

import LineItem.PromotionLineItem;
public class PromotionList {

	List<PromotionLineItem> promotions;
	
	/**
	 * 钀ラ攢绛栫暐鍒楄〃
	 * @param
	 * @return
	 */
	public PromotionList () {
		
		promotions = new ArrayList<PromotionLineItem>();
		
	}
	
	/**
	 * 娣诲姞鍗曚釜钀ラ攢绛栫暐
	 * @param pli PromotionLineItem鍨嬶紝娣诲姞鐨勫崟涓惀閿�绛栫暐
	 * @return 
	 */
	public void addPromotionLineItems(PromotionLineItem  pli) {
		promotions.add(pli);
	}
	/**
	 * 鏄剧ず钀ラ攢绛栫暐鍒楄〃
	 * @param pli PromotionLineItem鍨嬶紝鏄剧ず鐨勫崟涓惀閿�绛栫暐
	 * @return list鍒楄〃
	 */
	public List<PromotionLineItem> show(){
		return promotions;
	}
	/**
	 * 鍙栨秷钀ラ攢绛栫暐
	 * @param str String鍨嬶紝id
	 * @param time Time鍨嬶紝鎾ら攢鏃堕棿
	 */
	public void cancel(String promotionnumber) {
		for(int i=0;i<promotions.size();i++){
			if(promotions.get(i).getvo().promotionNumber.equals(promotionnumber)){
				promotions.get(i).cancel();
			}
		}
	}
	/**
	 * 鍙栨秷钀ラ攢绛栫暐
	 *
	 */
	public void cancel() {
		promotions.get(0).cancel();
	}
	/**
	 * 寰楀埌钀ラ攢绛栫暐鍒楄〃鏁伴噺
	 * @param
	 * @return 杩斿洖钀ラ攢绛栫暐鍒楄〃鏁伴噺
	 */
	public int getPromotionInfo() {
		return promotions.size();
	}
	/**
	 * 寰楀埌钀ラ攢绛栫暐鍒楄〃鏁伴噺
	 * @param
	 * @return 杩斿洖钀ラ攢绛栫暐鍒楄〃鏁伴噺
	 */
	public int getPromotion2() {
		return promotions.size();
	}
	/**
	 * 寰楀埌鐢ㄦ埛鍙敤鐨勮惀閿�绛栫暐
	 * @param
	 * @return 杩斿洖钀ラ攢绛栫暐
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


