package vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import po.PromotionPO;
import promotionBLServiceImpl.GetMemberLevelSystem;
/**
 * 网站策略的属性及数据创建与更新
 * @author lw
 */
public class WebPromotionVO{
	 public String promotionNumber;
	 public String promotionName;
	 public Calendar promotionBegintime;
	 public Calendar promotionEndtime;
	 public int applyMemberGrade;
	 public String applyCity;
	 public String applyBussinesscircle;
	 public double discount;
	 public WebPromotionVO (String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,String applycity,String applybussinesscircle,int applymembergrade,double dis) {
		 promotionNumber=promotionnumber;
		 promotionName=promotionname;
		 promotionBegintime=promotionbegintime;
		 promotionEndtime=promotionendtime;
		 applyCity=applycity;
		 applyBussinesscircle=applybussinesscircle;
		 applyMemberGrade=applymembergrade;
		 discount=dis;
		}
	 public Vector<String> getVector(){
		 Vector<String> v=new Vector<String>();
		 v.add(promotionNumber);
		 v.add(promotionName);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 String time1 = sdf.format(promotionBegintime.getTime());
		 String time2 = sdf.format(promotionEndtime.getTime());
		 v.add(time1);
		 v.add(time2);
		 v.add(applyCity);
		 v.add(applyBussinesscircle);
		 v.add(String.valueOf(applyMemberGrade));
		 v.add(String.valueOf(discount));
		 return v;
	 }
	    public WebPromotionVO (PromotionPO po){
	    	promotionNumber=po.getPromotionNumber();
	    	promotionName=po.getPromotionName();
	    	promotionBegintime=po.getPromotionBegintime();
	    	promotionEndtime=po.getPromotionEndtime();
	    	applyMemberGrade=po.getUserShipgrade();
	    	applyCity=po.getApplyCity();
	    	applyBussinesscircle=po.getHotelBussinesscircle();
	    	discount=GetMemberLevelSystem.getMemberLevelSystemInstance().getDiscountOfLevel(applyMemberGrade);
	    }
	    public WebPromotionVO(){};
	/**
     * 更新促销策略信息
     * 
     * @param promo Promotion型，一个用来更新数据的促销策略对象
     * @return 
     * @see Object.Promotion
     */
	public void update(WebPromotionVO promo) {
		 promotionNumber=promo.promotionNumber;
		 promotionName=promo.promotionName;
		 promotionBegintime=promo.promotionBegintime;
		 promotionEndtime=promo.promotionEndtime; 
		 applyMemberGrade=promo.applyMemberGrade;
		 applyCity=promo.applyCity;
		 applyBussinesscircle=promo.applyBussinesscircle;
		 discount=GetMemberLevelSystem.getMemberLevelSystemInstance().getDiscountOfLevel(applyMemberGrade);
	}
	
	/**
     * 创建酒店促销策略对象
     * 
     * @return 一个新建立的酒店促销策略
     * @see Object.Promotion
     */
	public WebPromotionVO makeWebPromotion() {
		
		return new WebPromotionVO();
	}
	
}