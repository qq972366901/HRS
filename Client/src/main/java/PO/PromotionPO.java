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
	private String promotionNumber;
	private String promotionName;
	private int promotionState;
	private Calendar promotionBegintime;
	private Calendar promotionEndtime;
	private String applyuserType;
	private String applybusinesscircle;
	private int applyuserShipgrade;
	private int miniNum;
	private double promotionDiscount;
	private int[] creditOfLevel=new int[5];
	private double[] discountOfLevel=new double[5];
	/**
	 * 鏋勯�犳櫘閫氫績閿�绛栫暐
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
	public PromotionPO(String promotionnumber,String promotionname,Calendar promotionbegintime,Calendar promotionendtime, String usertype,String hotelbusinesscircle,int usershipgrade,int num,double promotiondiscount){
	     promotionNumber=promotionnumber;
	     promotionName=promotionname;
	     promotionBegintime=promotionbegintime;
	     promotionEndtime=promotionendtime;
	     applyuserType=usertype;
	     applybusinesscircle=hotelbusinesscircle;
	     applyuserShipgrade=usershipgrade;
	     miniNum=num;
	     promotionDiscount=promotiondiscount;
	 }
	/**
	 * 鏋勯�犱細鍛樼瓑绾у埗搴�
	 * @param a int[]鍨嬶紝閫昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勪俊鐢ㄥ��
	 * @param b int[]鍨嬨�傞�昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勬姌鎵�
	 * @return
	 * @throws
	 * @see
	 */
	public PromotionPO(int a[],double b[]){
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
	 public int[] getCreditOfLevel(){
		 return creditOfLevel;
	 }
	 /**
		 * 璁剧疆绛栫暐姣忎釜绛夌骇淇＄敤鍊�
		 * @param a int[]鍨嬶紝閫昏緫灞備紶鏉ョ殑姣忎釜绛夌骇鐨勪俊鐢ㄥ��
		 * @return 
		 * @throws
		 * @see
		 */
	 public void setCreditOfLevel(int[] a){
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
		 * 鑾峰彇绛栫暐鐘舵��
		 * @param
		 * @return 杩斿洖绛栫暐鐘舵��
		 * @throws
		 * @see
		 */
	 public int getPromotionState(){
	     return promotionState;
	 }
	 /**
		 * 璁剧疆绛栫暐鐘舵��
		 * @param state int鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐鐘舵��
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionState(int state){
	     promotionState=state;
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
		 * 鑾峰彇瀹㈡埛閫傜敤绫诲瀷
		 * @param
		 * @return 杩斿洖瀹㈡埛閫傜敤绫诲瀷
		 * @throws
		 * @see
		 */   
	 public String getUserType(){
	     return applyuserType;
	 }
	 /**
		 * 璁剧疆瀹㈡埛閫傜敤绉嶇被
		 * @param type String 鍨嬶紝閫昏緫灞備紶鏉ョ殑瀹㈡埛閫傜敤绉嶇被
		 * @return
		 * @throws
		 * @see
		 */
	 public void setUserType(String type){
	    applyuserType=type;
	 }
	 /**
		 * 鑾峰彇閫傜敤鍟嗗湀
		 * @param 
		 * @return 杩斿洖閫傜敤鍟嗗湀
		 * @throws
		 * @see
		 */
	 public String getHotelBussinesscircle(){
	    return applybusinesscircle;
	 }
	 /**
		 * 璁剧疆閫傜敤鍟嗗湀
		 * @param circle String鍨嬶紝閫昏緫灞備紶鏉ョ殑閫傜敤鍟嗗湀
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelBussinesscircle(String circle){
		 applybusinesscircle=circle;
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
		 * 鑾峰彇鏈�浣庤璐暟閲�
		 * @param
		 * @return 杩斿洖鏈�浣庤璐暟閲�
		 * @throws
		 * @see
		 */
	 public int getMiniNum(){
	     return miniNum;
	 }
	 /**
		 * 璁剧疆鏈�浣庤璐暟閲�
		 * @param num int鍨嬶紝閫昏緫灞備紶鏉ョ殑鏈�浣庤璐暟閲�
		 * @return
		 * @throws
		 * @see
		 */
	 public void setMiniNUm(int num){
	     miniNum=num;
	 }
	 /**
		 * 鑾峰彇绛栫暐鎶樻墸
		 * @param
		 * @return 杩斿洖绛栫暐鎶樻墸
		 * @throws
		 * @see
		 */
	 public double getPromotionDiscount(){
	     return promotionDiscount;
	 }
	 /**
		 * 璁剧疆绛栫暐鎶樻墸
		 * @param discount double鍨嬶紝閫昏緫灞備紶鏉ョ殑绛栫暐鎶樻墸
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionDiscount(double discount){
	     promotionDiscount=discount;
	 }
}
