package VO;

import java.sql.Time;

import Object.Promotion;

/**
 * 促销策略的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Promotion
 */

public class PromotionVO extends VO {

	 public String promotionNumber;
	 public String promotionName;
	 public Time promotionBegintime;
	 public Time promotionEndtime;
	 public String userType;
	 public String businesscircle;
	 public int userShipgrade;
	 public int miniNum;
	 public double promotionDiscount;
	 public int[] creditOfLevel=new int[5];
	 public double[] discountOfLevel=new double[5];
	/**
     * 更新促销策略信息
     * 
     * @param promo Promotion型，一个用来更新数据的促销策略对象
     * @return 
     * @see Object.Promotion
     */
	public void update(Promotion promo) {
		
	}
	
	/**
     * 创建促销策略对象
     * 
     * @return 一个新建立的促销策略
     * @see Object.Promotion
     */
	public Promotion makePromotion() {
		
		return new Promotion();
	}
	
}
