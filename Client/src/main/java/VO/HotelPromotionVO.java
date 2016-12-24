package VO;

import java.util.Calendar;
import PO.*;

/**
 * 促销策略的属性及数据创建与更新
 * @author 刘宗侃
 */

public class HotelPromotionVO{
	 public String hotelID;
	 public String promotionName;
	 public Calendar promotionBegintime;
	 public Calendar promotionEndtime;	 
	 public double discount;
	 public double birthdayDiscount;
	 public double roomDiscount;
	 public double enterpriseDiscount;	
	 public HotelPromotionVO (String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount) {
		 hotelID=hotelid;
		 promotionName=promotionname;
		 promotionBegintime=promotionbegintime;
		 promotionEndtime=promotionendtime;
		 discount=promotiondiscount;
		 birthdayDiscount=birthdaydiscount;
		 roomDiscount=roomdiscount;
		 enterpriseDiscount=enterprisediscount;
	
		}
	    public HotelPromotionVO (PromotionPO po){
	    	hotelID=po.getHotelID();
	    	promotionName=po.getPromotionName();
	    	promotionBegintime=po.getPromotionBegintime();
	    	promotionEndtime=po.getPromotionEndtime();
	    	discount=po.getPromotionDiscount();
	    	birthdayDiscount=po.getBirthdayDiscount();
			roomDiscount=po.getRoomDiscount();
		    enterpriseDiscount=po.getEnterpriseDiscount();
	    }
	    public HotelPromotionVO(){};
	/**
     * 更新促销策略信息
     * 
     * @param promo Promotion型，一个用来更新数据的促销策略对象
     * @return 
     * @see Object.Promotion
     */
	public void update(HotelPromotionVO promo) {
		 hotelID=promo.hotelID;
		 promotionName=promo.promotionName;
		 promotionBegintime=promo.promotionBegintime;
		 promotionEndtime=promo.promotionEndtime;
		 discount=promo.discount;	 
		 birthdayDiscount=promo.birthdayDiscount;
		 roomDiscount=promo.roomDiscount;
		 enterpriseDiscount=promo.enterpriseDiscount;
	}
	
	/**
     * 创建酒店促销策略对象
     * 
     * @return 一个新建立的酒店促销策略
     * @see Object.Promotion
     */
	public HotelPromotionVO makeHotelPromotion() {
		
		return new HotelPromotionVO();
	}
	
}
