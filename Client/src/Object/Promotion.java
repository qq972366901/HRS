package Object;
import java.io.Serializable;
import java.util.List;
import java.sql.Time;
import LineItem.PromotionLineItem;
import List.PromotionList;
import common.ResultMessage;
/**
 * 营销策略的数据实体
 * @author LW
 * @version 1.0
 * @see
 */
public class Promotion implements Serializable{
   private static final long serialVersionUID=1L;
   private String promotionNumber;
   private String promotionId;
   private Time beginTime;
   private Time endTime;
   private Time Birthday;
   private int roomNumber;
   private boolean corporateMember;
   private String hotelDistrict;
   private ResultMessage memberGrade;
   private double discount;
   
   /**
	 * 构造营销策略数据实体
	 * @param promotionnumber String型，逻辑层传来的营销策略编号
	 * @param promotionid String型，逻辑层传来的营销策略名称
	 * @param begintime Time型，逻辑层传来的开始时间
	 * @param endtime Time型，逻辑层传来的结束时间
	 * @param birthday Time型，数据层传来的生日
	 * @param roomnumber int型，逻辑层传来的房间数量
	 * @param corporatemember boolean型，数据层传来的是否是企业会员
	 * @param hoteldistrict String型，逻辑侧传来的商圈
	 * @param membergrade ResultMessage型，数据层传来的会员等级
	 * @param dcount double型，逻辑侧传来的折扣
	 * @return
	 * @throws
	 * @see
	 */
   public Promotion(String promotionnumber,String promotionid,Time begintime,Time endtime,Time birthday,int roomnumber,boolean corporatemember,String hoteldistrict,ResultMessage membergrade,double dcount){
	   promotionNumber=promotionnumber;
	   promotionId=promotionid;
	   beginTime=begintime;
	   endTime=endtime;
	   Birthday=birthday;
	   roomNumber=roomnumber;
	   corporateMember=corporatemember;
	   hotelDistrict=hoteldistrict;
	   memberGrade=membergrade;
	   discount=dcount;
   }
   /**
	 * 构造营销策略的数据实体
	 * @return
	 */
   public Promotion(){
	    
   }
   /**
	 * 设置营销策略号
	 * @param number String型，逻辑层传来的营销策略号
	 * @return
	 * @throws
	 * @see
	 */
  public void setpromotionNumber(String number){
  	promotionNumber=number;
  }
  /**
	 * 获取营销策略号
	 * @param
	 * @return 返回营销策略号
	 * @throws
	 * @see
	 */
  public String getpromotionNumber() {
  	return promotionNumber;
  } 
  /**
	 * 设置营销策略名
	 * @param id String型，逻辑层传来的营销策略名
	 * @return
	 * @throws
	 * @see
	 */
public void setpromotionId(String id){
	promotionId=id;
}
/**
	 * 获取营销策略名
	 * @param
	 * @return 返回营销策略名
	 * @throws
	 * @see
	 */
public String getpromotionId() {
	return promotionId;
} 
/**
 * 设置开始时间
 * @param date1 Time型，逻辑层传来的开始时间
 * @return
 * @throws
 * @see
 */
public void setbeginTime(Time date1){
	beginTime=date1;
}
/**
 * 获取开始时间
 * @param
 * @return 返回开始时间
 * @throws
 * @see
 */
public Time getbeginTime() {
	return beginTime;
} 
/**
 * 设置结束时间
 * @param date2 Time型，逻辑层传来的结束时间
 * @return
 * @throws
 * @see
 */
public void setendTime(Time date2){
	endTime=date2;
}
/**
 * 获取结束时间
 * @param
 * @return 返回结束时间
 * @throws
 * @see
 */
public Time getendTime() {
	return endTime;
} 
/**
 * 设置折扣
 * @param dc double型，逻辑层传来的折扣
 * @return
 * @throws
 * @see
 */
public void setdiscount(double dc){
	discount=dc;
}
/**
 * 获取折扣
 * @param
 * @return 返回折扣
 * @throws
 * @see
 */
public double getdiscount() {
	return discount;
} 
/**
 * 设置会员等级
 * @param memberGrade ResultMessage型，数据层传来的会员等级
 * @return 返回会员等级
 * @throws
 * @see
 */
public ResultMessage setmemberGrade(int creditvalue){
	return memberGrade;
}
/**
 * 设置会员等级折扣
 * @param memberGrade ResultMessage型，数据层传来的会员等级
 * @return 返回折扣
 * @throws
 * @see
 */
public double setmemberGradeDiscount(ResultMessage membergrade){
	return discount;
}
/**
 * 设置会员生日折扣
 * @param  birthday Time型，数据层传来的生日
 * @return 返回折扣
 * @throws
 * @see
 */
public double setbirthdayDiscount(Time birthday){
	return discount;
}
/**
 * 设置企业会员折扣
 * @param  coporateMember boolean型，数据层传来的会员种类
 * @return 返回折扣
 * @throws
 * @see
 */
public double setcorporateMemberDiscount(boolean corporateMember){
	return discount;
}
/**
 * 设置房间数量折扣
 * @param  roomNumber int型，逻辑层传来的房间数量
 * @return 返回折扣
 * @throws
 * @see
 */
public double setroomNumberDiscount(int roomNumber){
	return discount;
}
private PromotionList promotionList;
/**
	 * 获得营销策略列表
	 * @param pl PromotionList型，对应的订单列表
	 * @return
	 */
public void addPromotionList(PromotionList pl) {
	promotionList = pl;
}

/**
 * 添加营销策略
 * @param promotionnumber String型，营销策略号
 * @param promotionid String型，营销策略名
 * @param begintime Time型，开始时间
 * @param endtime Time型，结束时间
 * @param hoteldistrict String型，商圈
 * @param dcount double型，折扣
 * @return
 * @throws
 * @see
 */
public int add(String promotionnumber,String promotionid,Time begintime,Time endtime,Time birthday,int roomnumber,boolean corporatemember,String hoteldistrict,ResultMessage membergrade,double dcount) {
	promotionList.addPromotionLineItems(new PromotionLineItem(new Promotion(promotionnumber,promotionid,begintime,endtime,birthday,roomnumber,corporatemember,hoteldistrict, membergrade,dcount)));
	return promotionList.getPromotion();
}
/**
	 * 查找用户可用的营销策略
	 * @param id String型，用户账号
	 * @return 可用的营销策略数
	 */
public int getPromotion(String userID) {
	return promotionList.getPromotion(userID);
}
/**
 * 删除营销策略
 * @param promotionnumber String型，营销策略号
 * @return
 * @throws
 * @see
 */
public int delete(Promotion promotion) {
	promotionList.deletePromotionLineItems(new PromotionLineItem(promotion));
	return promotionList.getPromotion();
}
}
