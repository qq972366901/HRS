package PO;

import java.io.Serializable;
import java.util.Calendar;
/**
 * 淇冮攢绛栫暐鐨勬暟鎹疄浣�
 * @author LZ
 * @version 1.0
 * @see
 */

public class PromotionPO extends PO implements Serializable{
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
	 * 酒店营销策略
	 * @param promotionnumber String鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐缂栧彿
	 * @param promotionname String鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐鍚嶇О
	 * @param promotionbegintime Time鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐寮�濮嬫椂闂�
	 * @param promotionendtime Time鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐缁撴潫鏃堕棿
	 * @param usertype Time鍨嬶紝閫昏緫灞備紶鏉ョ殑瀹㈡埛绫诲瀷
	 * @param hotelbusinesscircle String鍨嬶紝閫昏緫灞備紶鏉ョ殑閫傜敤鍟嗗湀
	 * @param usershipgrade int鍨嬶紝閫昏緫灞備紶鏉ョ殑瀹㈡埛閫傜敤绛夌骇
	 * @param num int鍨嬶紝閫昏緫灞備紶鏉ョ殑鏈�浣庤璐暟閲�
	 * @param promotiondiscount double鍨嬶紝閫昏緫灞備紶鏉ョ殑鎶樻墸
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
	 * 网站营销策略
	 */
	public PromotionPO(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime, String city,String hotelbusinesscircle,int usershipgrade){
	     promotionNumber=promotionnumber;
	     promotionName=promotionname;
	     promotionBegintime=promotionbegintime;
	     promotionEndtime=promotionendtime;
	     applycity=city;
	     applybussinesscircle=hotelbusinesscircle;
	     applyuserShipgrade=usershipgrade;
	 }
	
	/**
	 * 鏋勯�犱細鍛樼瓑绾у埗搴�
	 * @param a int[]鍨嬶紝閫昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勪俊鐢ㄥ��
	 * @param b int[]鍨嬨�傞�昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勬姌鎵�
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
	 * 鑾峰彇姣忎釜绛夌骇鐨勪俊鐢ㄥ��
	 * @param
	 * @return 杩斿洖姣忎釜绛夌骇鐨勪俊鐢ㄥ��
	 * @throws
	 * @see
	 */
	 public long[] getCreditOfLevel(){
		 return creditOfLevel;
	 }
	 /**
		 * 璁剧疆绛栫暐姣忎釜绛夌骇淇＄敤鍊�
		 * @param a int[]鍨嬶紝閫昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勪俊鐢ㄥ��
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
		 * 鑾峰彇姣忎釜绛夌骇鐨勬姌鎵�
		 * @param
		 * @return 杩斿洖姣忎釜绛夌骇鐨勬姌鎵�
		 * @throws
		 * @see
		 */
	 public double[] getDiscountOfLevel(){
		 return discountOfLevel;
	 }
	 /**
		 * 璁剧疆绛栫暐姣忎釜绛夌骇鎶樻墸
		 * @param b int[]鍨嬨�傞�昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勬姌鎵�
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
		 * 鑾峰彇绛栫暐缂栧彿
		 * @param
		 * @return 杩斿洖绛栫暐缂栧彿
		 * @throws
		 * @see
		 */
	 public String getHotelID(){
	     return hotelID;
	 }
	 /**
		 * 璁剧疆绛栫暐缂栧彿
		 * @param number String鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐缂栧彿
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelID(String id){
	     hotelID=id;
	 }
	 /**
		 * 鑾峰彇绛栫暐缂栧彿
		 * @param
		 * @return 杩斿洖绛栫暐缂栧彿
		 * @throws
		 * @see
		 */
	 public String getPromotionNumber(){
	     return promotionNumber;
	 }
	 /**
		 * 璁剧疆绛栫暐缂栧彿
		 * @param number String鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐缂栧彿
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionNumber(String number){
	     promotionNumber=number;
	 }
	 /**
		 * 鑾峰彇绛栫暐鍚嶇О
		 * @param
		 * @return 杩斿洖绛栫暐鍚嶇О
		 * @throws
		 * @see
		 */
	 public String getPromotionName(){
	     return promotionName;
	 }
	 /**
		 * 璁剧疆绛栫暐鍚嶇О
		 * @param name String鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐鍚嶇О
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionName(String name){
	     promotionName=name;
	 }
	 /**
		 * 鑾峰彇绛栫暐寮�濮嬫椂闂�
		 * @param
		 * @return 杩斿洖绛栫暐寮�濮嬫椂闂�
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionBegintime(){
	     return promotionBegintime;
	 }
	 /**
		 * 璁剧疆绛栫暐寮�濮嬫椂闂�
		 * @param begintime Time鍨嬶紝閫昏緫灞備紶鏉ョ殑寮�濮嬫椂闂�
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionBegintime(Calendar begintime){
	     promotionBegintime=begintime;
	 }
	 /**
		 * 鑾峰彇绛栫暐缁撴潫鏃堕棿
		 * @param
		 * @return 杩斿洖绛栫暐缁撴潫鏃堕棿
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionEndtime(){
	     return promotionEndtime;
	 }
	 /**
		 * 璁剧疆绛栫暐缁撴潫鏃堕棿
		 * @param endtime Time鍨嬶紝閫昏緫灞備紶鏉ョ殑缁撴潫鏃堕棿
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionEndtime(Calendar endtime){
	     promotionEndtime=endtime;
	 }

	 /**
		 * 鑾峰彇閫傜敤鍟嗗湀
		 * @param 
		 * @return 杩斿洖閫傜敤鍟嗗湀
		 * @throws
		 * @see
		 */
	 public String getHotelBussinesscircle(){
	    return applybussinesscircle;
	 }
	 /**
		 * 璁剧疆閫傜敤鍟嗗湀
		 * @param circle String鍨嬶紝閫昏緫灞備紶鏉ョ殑閫傜敤鍟嗗湀
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelBussinesscircle(String circle){
		 applybussinesscircle=circle;
	 }
	 /**
		 * 鑾峰彇瀹㈡埛閫傜敤绛夌骇
		 * @param
		 * @return 杩斿洖瀹㈡埛閫傜敤绛夌骇
		 * @throws
		 * @see
		 */
	 public int getUserShipgrade(){
	     return applyuserShipgrade;
	 }
	 /**
		 * 璁剧疆瀹㈡埛閫傜敤绛夌骇
		 * @param grade int鍨嬶紝閫昏緫灞備紶鏉ョ殑瀹㈡埛閫傜敤绛夌骇
		 * @return
		 * @throws
		 * @see
		 */
	 public void setUserShipgrade(int grade){
	     applyuserShipgrade=grade;
	 }

	 /**
		 * 鑾峰彇绛栫暐鎶樻墸
		 * @param
		 * @return 杩斿洖绛栫暐鎶樻墸
		 * @throws
		 * @see
		 */
	 public double getPromotionDiscount(){
	     return Discount;
	 }
	 /**
		 * 璁剧疆绛栫暐鎶樻墸
		 * @param discount double鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐鎶樻墸
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionDiscount(double discount){
	     Discount=discount;
	 }
	 public double getBirthdayDiscount(){
	     return birthdayDiscount;
	 }
	 public void setBirthdayDiscount(double birthdaydiscount){
		 birthdayDiscount=birthdaydiscount;
	 }
	 public double getRoomDiscount(){
	     return roomDiscount;
	 }
	 public void setRoomDiscount(double roomdiscount){
		 roomDiscount=roomdiscount;
	 }
	 public double getEnterpriseDiscount(){
	     return enterpriseDiscount;
	 }
	 public void setEnterpriseDiscount(double enterprisediscount){
		 enterpriseDiscount=enterprisediscount;
	 }
	 public String getApplyCity(){
	     return applycity;
	 }
	 public void setApplyCity(String city){
		 applycity=city;
	 }
}
