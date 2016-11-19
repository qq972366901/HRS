package PO;

import java.io.Serializable;
import java.util.Calendar;
/**
 * 促销策略的数据实体
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
	 * 构造普通促销策略
	 * @param promotionnumber String型，逻辑层传来的策略编号
	 * @param promotionname String型，逻辑层传来的策略名称
	 * @param promotionbegintime Time型，逻辑层传来的策略开始时间
	 * @param promotionendtime Time型，逻辑层传来的策略结束时间
	 * @param usertype Time型，逻辑层传来的客户类型
	 * @param hotelbusinesscircle String型，逻辑层传来的适用商圈
	 * @param usershipgrade int型，逻辑层传来的客户适用等级
	 * @param num int型，逻辑层传来的最低订购数量
	 * @param promotiondiscount double型，逻辑层传来的折扣
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
	 * 构造会员等级制度
	 * @param a int[]型，逻辑层传来的每个等级的信用值
	 * @param b int[]型。逻辑层传来的每个等级的折扣
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
	 * 获取每个等级的信用值
	 * @param
	 * @return 返回每个等级的信用值
	 * @throws
	 * @see
	 */
	 public int[] getCreditOfLevel(){
		 return creditOfLevel;
	 }
	 /**
		 * 设置策略每个等级信用值
		 * @param a int[]型，逻辑层传来的每个等级的信用值
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
		 * 获取每个等级的折扣
		 * @param
		 * @return 返回每个等级的折扣
		 * @throws
		 * @see
		 */
	 public double[] getDiscountOfLevel(){
		 return discountOfLevel;
	 }
	 /**
		 * 设置策略每个等级折扣
		 * @param b int[]型。逻辑层传来的每个等级的折扣
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
		 * 获取策略编号
		 * @param
		 * @return 返回策略编号
		 * @throws
		 * @see
		 */
	 public String getPromotionNumber(){
	     return promotionNumber;
	 }
	 /**
		 * 设置策略编号
		 * @param number String型，逻辑层传来的策略编号
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionNumber(String number){
	     promotionNumber=number;
	 }
	 /**
		 * 获取策略名称
		 * @param
		 * @return 返回策略名称
		 * @throws
		 * @see
		 */
	 public String getPromotionName(){
	     return promotionName;
	 }
	 /**
		 * 设置策略名称
		 * @param name String型，逻辑层传来的策略名称
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionName(String name){
	     promotionName=name;
	 }
	 /**
		 * 获取策略状态
		 * @param
		 * @return 返回策略状态
		 * @throws
		 * @see
		 */
	 public int getPromotionState(){
	     return promotionState;
	 }
	 /**
		 * 设置策略状态
		 * @param state int型，逻辑层传来的策略状态
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionState(int state){
	     promotionState=state;
	 }
	 /**
		 * 获取策略开始时间
		 * @param
		 * @return 返回策略开始时间
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionBegintime(){
	     return promotionBegintime;
	 }
	 /**
		 * 设置策略开始时间
		 * @param begintime Time型，逻辑层传来的开始时间
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionBegintime(Calendar begintime){
	     promotionBegintime=begintime;
	 }
	 /**
		 * 获取策略结束时间
		 * @param
		 * @return 返回策略结束时间
		 * @throws
		 * @see
		 */
	 public Calendar getPromotionEndtime(){
	     return promotionEndtime;
	 }
	 /**
		 * 设置策略结束时间
		 * @param endtime Time型，逻辑层传来的结束时间
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionEndtime(Calendar endtime){
	     promotionEndtime=endtime;
	 }
	 /**
		 * 获取客户适用类型
		 * @param
		 * @return 返回客户适用类型
		 * @throws
		 * @see
		 */   
	 public String getUserType(){
	     return applyuserType;
	 }
	 /**
		 * 设置客户适用种类
		 * @param type String 型，逻辑层传来的客户适用种类
		 * @return
		 * @throws
		 * @see
		 */
	 public void setUserType(String type){
	    applyuserType=type;
	 }
	 /**
		 * 获取适用商圈
		 * @param 
		 * @return 返回适用商圈
		 * @throws
		 * @see
		 */
	 public String getHotelBussinesscircle(){
	    return applybusinesscircle;
	 }
	 /**
		 * 设置适用商圈
		 * @param circle String型，逻辑层传来的适用商圈
		 * @return
		 * @throws
		 * @see
		 */
	 public void setHotelBussinesscircle(String circle){
		 applybusinesscircle=circle;
	 }
	 /**
		 * 获取客户适用等级
		 * @param
		 * @return 返回客户适用等级
		 * @throws
		 * @see
		 */
	 public int getUserShipgrade(){
	     return applyuserShipgrade;
	 }
	 /**
		 * 设置客户适用等级
		 * @param grade int型，逻辑层传来的客户适用等级
		 * @return
		 * @throws
		 * @see
		 */
	 public void setUserShipgrade(int grade){
	     applyuserShipgrade=grade;
	 }
	 /**
		 * 获取最低订购数量
		 * @param
		 * @return 返回最低订购数量
		 * @throws
		 * @see
		 */
	 public int getMiniNum(){
	     return miniNum;
	 }
	 /**
		 * 设置最低订购数量
		 * @param num int型，逻辑层传来的最低订购数量
		 * @return
		 * @throws
		 * @see
		 */
	 public void setMiniNUm(int num){
	     miniNum=num;
	 }
	 /**
		 * 获取策略折扣
		 * @param
		 * @return 返回策略折扣
		 * @throws
		 * @see
		 */
	 public double getPromotionDiscount(){
	     return promotionDiscount;
	 }
	 /**
		 * 设置策略折扣
		 * @param discount double型，逻辑层传来的策略折扣
		 * @return
		 * @throws
		 * @see
		 */
	 public void setPromotionDiscount(double discount){
	     promotionDiscount=discount;
	 }
}
