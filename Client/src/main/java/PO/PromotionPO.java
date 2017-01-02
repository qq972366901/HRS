package po;

import java.io.Serializable;
import java.util.Calendar;
/**
 * 策略的数据实体
 * @author LW
 * @version 1.0
 * @see
 */

public class PromotionPO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private String promotionNumber;
	private String promotionName;
	private Calendar promotionBegintime;
	private Calendar promotionEndtime;
	private String applybussinesscircle;
	private String applycity;
	private int applyuserShipgrade;
	private double Discount;
	private long[] creditOfLevel=new long[5];
	private double[] discountOfLevel=new double[5];
	private double birthdayDiscount;
	private double roomDiscount;
	private double enterpriseDiscount;
	/**
	 * 酒店营销策略的数据实体
	 * @param hotelid String逻辑层传来的酒店ID
	 * @param promotionname String逻辑层传来的策略名
	 * @param promotionbegintime Time逻辑层传来的策略开始时间
	 * @param promotionendtime Time逻辑层传来的策略结束时间
	 * @param promotiondiscount double逻辑层传来的基础折扣
	 * @param birthdaydiscount double逻辑层传来的生日折扣
	 * @param roomdiscount double逻辑层传来的房间折扣
	 * @param enterprisediscount double逻辑层传来的企业会员折扣
	 * @return
	 * @throws
	 * @see
	 */
	public PromotionPO(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount){
	     hotelID=hotelid;
	     promotionName=promotionname;
	     promotionBegintime=promotionbegintime;
	     promotionEndtime=promotionendtime;
	     Discount=promotiondiscount;
	     birthdayDiscount=birthdaydiscount;
	     roomDiscount=roomdiscount;
	     enterpriseDiscount=enterprisediscount;
	 }
	/**
	 * 网站营销策略的数据实体
	 * @param promotionnumber String逻辑层传来的策略号
	 * @param promotionname String逻辑层传来的策略名
	 * @param promotionbegintime Time逻辑层传来的策略开始时间
	 * @param promotionendtime Time逻辑层传来的策略结束时间
	 * @param city String逻辑层传来城市
	 * @param hotelbusinesscircle String逻辑层传来的商圈
	 * @param usershipgrade int逻辑层传来的会员等级
	 * @param promotiondiscount double逻辑层传来的基础折扣
	 * @return
	 * @throws
	 * @see
	 */
	public PromotionPO(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime, String city,String hotelbusinesscircle,int usershipgrade,double dis){
	     promotionNumber=promotionnumber;
	     promotionName=promotionname;
	     promotionBegintime=promotionbegintime;
	     promotionEndtime=promotionendtime;
	     applycity=city;
	     applybussinesscircle=hotelbusinesscircle;
	     applyuserShipgrade=usershipgrade;
	     Discount=dis;
	 }
	
	/**
	 * 会员等级制度的数据实体
	 * @param a int[]逻辑层传来的信用值的数组
	 * @param b int[]逻辑层传来的折扣的数组
	 * @return
	 * @throws
	 * @see
	 */
	public PromotionPO(long a[],double b[]){
		for(int i=0;i<a.length;i++){
			creditOfLevel[i]=a[i];
		}
		for(int i=0;i<b.length;i++){
			discountOfLevel[i]=b[i];
		}
	}
	/**
	 * 会员等级的信用值
	 * @param
	 * @return long[]型，信用值的数组
	 * @throws
	 * @see
	 */
	 public long[] getCreditOfLevel(){
		 return creditOfLevel;
	 }
	 /**
		 * 设置会员等级的信用值
		 * @param a int[]信用值的数组
		 * @return 
		 * @throws
		 * @see
		 */
	 public void setCreditOfLevel(long[] a){
		 for(int i=0;i<a.length;i++){
			creditOfLevel[i]=a[i];
		}
	 }
	 /**
		 * 得到会员等级的折扣
		 * @param
		 * @return 会员等级的折扣数组
		 * @throws
		 * @see
		 */
	 public double[] getDiscountOfLevel(){
		 return discountOfLevel;
	 }
	 /**
		 * 设置会员等级的折扣
		 * @param b int[]会员等级折扣的数组
		 * @return
		 * @throws
		 * @see
		 */
	 public void setDiscountOfLevel(double[] b){
		 for(int i=0;i<b.length;i++){
				discountOfLevel[i]=b[i];
			}
	 }
	 /**
		 * 等到酒店ID
		 * @param
		 * @return String型，酒店ID
		 * @throws
		 * @see
		 */
	 public String getHotelID(){
	     return hotelID;
	 }
	 /**
		 * 设置酒店ID
		 * @param number String型，酒店ID
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelID(String id){
	     hotelID=id;
	 }
	 /**
		 * 得到策略号
		 * @param
		 * @return String型，策略号
		 * @throws
		 * @see
		 */
	 public String getPromotionNumber(){
	     return promotionNumber;
	 }
	 /**
		 * 设置策略号
		 * @param number String型，策略号
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionNumber(String number){
	     promotionNumber=number;
	 }
	 /**
		 * 得到策略名称
		 * @param
		 * @return String型，策略名称
		 * @throws
		 * @see
		 */
	 public String getPromotionName(){
	     return promotionName;
	 }
	 /**
		 * 设置策略名称
		 * @param name String型，策略名称
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionName(String name){
	     promotionName=name;
	 }
	 /**
		 * 得到策略开始时间
		 * @param
		 * @return Calendar型，策略开始时间
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionBegintime(){
	     return promotionBegintime;
	 }
	 /**
		 * 设置策略开始时间
		 * @param begintime Calendar型，设置策略开始时间
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionBegintime(Calendar begintime){
	     promotionBegintime=begintime;
	 }
	 /**
		 * 得到策略结束时间
		 * @param
		 * @return Calendar型，策略结束时间
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionEndtime(){
	     return promotionEndtime;
	 }
	 /**
		 * 设置策略结束时间
		 * @param endtime Calendar型，策略结束时间
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionEndtime(Calendar endtime){
	     promotionEndtime=endtime;
	 }

	 /**
		 * 得到酒店商圈
		 * @param 
		 * @return String型，酒店的商圈
		 * @throws
		 * @see
		 */
	 public String getHotelBussinesscircle(){
	    return applybussinesscircle;
	 }
	 /**
		 * 设置酒店的商圈
		 * @param circle String型，酒店的商圈
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelBussinesscircle(String circle){
		 applybussinesscircle=circle;
	 }
	 /**
		 * 得到适用的会员等级
		 * @param
		 * @return int型，适用的会员等级
		 * @throws
		 * @see
		 */
	 public int getUserShipgrade(){
	     return applyuserShipgrade;
	 }
	 /**
		 * 设置适用的会员等级
		 * @param grade int型，适用的会员等级
		 * @return
		 * @throws
		 * @see
		 */
	 public void setUserShipgrade(int grade){
	     applyuserShipgrade=grade;
	 }

	 /**
		 * 得到策略的折扣
		 * @param
		 * @return double型，策略的折扣
		 * @throws
		 * @see
		 */
	 public double getPromotionDiscount(){
	     return Discount;
	 }
	 /**
		 * 设置策略的折扣
		 * @param discount double型，策略的折扣
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionDiscount(double discount){
	     Discount=discount;
	 }
	 /**
		 * 得到生日的折扣
		 * @param
		 * @return double型，生日的折扣
		 * @throws
		 * @see
		 */
	 public double getBirthdayDiscount(){
	     return birthdayDiscount;
	 }
	 /**
		 * 设置生日的折扣
		 * @param discount double型，生日的折扣
		 * @return
		 * @throws
		 * @see
		 */
	 public void setBirthdayDiscount(double birthdaydiscount){
		 birthdayDiscount=birthdaydiscount;
	 }
	 /**
		 * 得到房间的折扣
		 * @param
		 * @return double型，房间的折扣
		 * @throws
		 * @see
		 */
	 public double getRoomDiscount(){
	     return roomDiscount;
	 }
	 /**
		 * 设置房间的折扣
		 * @param discount double型，房间的折扣
		 * @return
		 * @throws
		 * @see
		 */
	 public void setRoomDiscount(double roomdiscount){
		 roomDiscount=roomdiscount;
	 }
	 /**
		 * 得到企业会员的折扣
		 * @param
		 * @return double型，企业会员的折扣
		 * @throws
		 * @see
		 */
	 public double getEnterpriseDiscount(){
	     return enterpriseDiscount;
	 }
	 /**
		 * 设置企业会员的折扣
		 * @param discount double型，企业会员的折扣
		 * @return
		 * @throws
		 * @see
		 */
	 public void setEnterpriseDiscount(double enterprisediscount){
		 enterpriseDiscount=enterprisediscount;
	 }
	 /**
		 * 得到适用的城市
		 * @param
		 * @return String型，适用的城市
		 * @throws
		 * @see
		 */
	 public String getApplyCity(){
	     return applycity;
	 }
	 /**
		 * 设置适用的城市
		 * @param city String型，适用的城市
		 * @return
		 * @throws
		 * @see
		 */
	 public void setApplyCity(String city){
		 applycity=city;
	 }
	 /**
		 * 得到策略的折扣
		 * @param
		 * @return double型，策略的折扣
		 * @throws
		 * @see
		 */
	 public double getDiscount() {
			return Discount;
		}
}
