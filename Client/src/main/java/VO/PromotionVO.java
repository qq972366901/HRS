package VO;

import java.util.Calendar;
import Object.Promotion;
import PO.*;

/**
 * 促销策略的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Promotion
 */

public class PromotionVO extends VO {
	 public String promotionNumber;
	 public String promotionName;
	 public int promotionState;
	 public Calendar promotionBegintime;
	 public Calendar promotionEndtime;
	 public String applyuserType;
	 public String applybusinesscircle;
	 public int applyuserShipgrade;
	 public int miniNum;
	 public double promotionDiscount;
	 public int[] creditOfLevel=new int[5];
	 public double[] discountOfLevel=new double[5];
	 public String userType;
	 public int userShipgrade;
	 public int roomNum;
	 public Calendar Birthday;
	 public PromotionVO (String promotionnumber,String promotionname,int promotionstate,Calendar promotionbegintime,Calendar promotionendtime,String applyusertype,String applybcircle,int applyusershipgrade,int mininum, double promotiondiscount,String usertype,int usershipgrade,int roomnum,Calendar birthday) {
		 promotionNumber=promotionnumber;
		 promotionName=promotionname;
		 promotionState=promotionstate;
		 promotionBegintime=promotionbegintime;
		 promotionEndtime=promotionendtime;
		 applyuserType=applyusertype;
		 applybusinesscircle=applybcircle;
		 applyuserShipgrade=applyusershipgrade;
		 miniNum=mininum;
		 promotionDiscount=promotiondiscount;
		 userType=usertype;
		 userShipgrade=usershipgrade;
		 roomNum=roomnum;
		 Birthday=birthday;
		}
	    public PromotionVO (UserPO po1,OrderPO po2,PromotionPO po){
	    	promotionNumber=po.getPromotionNumber();
	    	promotionName=po.getPromotionName();
	        promotionState=po.getPromotionState();
	    	promotionBegintime=po.getPromotionBegintime();
	    	promotionEndtime=po.getPromotionEndtime();
	    	applyuserType=po.getUserType();
	    	applybusinesscircle	=po.getHotelBussinesscircle();	
	    	applyuserShipgrade=po.getUserShipgrade();
	    	miniNum=po.getMiniNum();
	    	promotionDiscount=po.getPromotionDiscount();
	    	userType=po1.getMemberType();
	    	userShipgrade=po1.getLevel();
	    	roomNum=po2.getRoomNumber();
	    	Birthday=po1.getBirthday();
	    }
	    public PromotionVO(){};
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
