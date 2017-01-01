package VO;

import PO.PromotionPO;
/**
 * 会员等级制度属性及数据创建与更新
 * @author lw
 */
public class MemberLevelSystemVO{
	 public long[] creditOfLevel=new long[5];
	 public double[] discountOfLevel=new double[5];
	 public MemberLevelSystemVO (long[] creditodlevel,double[] discountoflevel) {
		 creditOfLevel=creditodlevel;
		 discountOfLevel=discountoflevel;
		}
	    public MemberLevelSystemVO (PromotionPO po){
	    	creditOfLevel=po.getCreditOfLevel();
	    	discountOfLevel=po.getDiscountOfLevel();
	    }
	    public MemberLevelSystemVO(){};
	
	public void update(MemberLevelSystemVO promo) {
		creditOfLevel=promo.creditOfLevel;
		discountOfLevel=promo.discountOfLevel;
	}
	
	/**
     * 创建会员等级制度对象
     * 
     * @return 一个新建立的会员等级制度
     * @see Object.Promotion
     */
	public MemberLevelSystemVO makeMemberGradeAndDiscount() {
		
		return new MemberLevelSystemVO();
	}
	
}

