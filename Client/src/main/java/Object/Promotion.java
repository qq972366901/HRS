package Object;
import java.util.Calendar;
import java.util.List;

import LineItem.PromotionLineItem;
import List.OrderList;
import List.PromotionList;
import VO.PromotionVO;
/**
 * 营销策略的数据实体
 * @author LW
 * @version 1.0
 * @see
 */
public class Promotion{
	PromotionLineItem promotionlineitem;
	PromotionList promotionlist;
    private PromotionList promotionList;
/**
 * 制定会员等级折扣
 * @param promotionnumber String型，营销策略号
 * @param promotionname String型，营销策略名
 * @param begintime Calendar型，开始时间
 * @param endtime Calendar型，结束时间
 * @param appluusertype String型，适用客户类型
 * @param num int型，订购最低房间数
 * @param dcount double型，折扣
 * @return
 * @throws
 * @see
 */ 
  public double setmemberGradeDiscount(double a,double b,double c,double d,double e){
	double discount=1;
	PromotionVO vo=new PromotionVO();
	if(vo.userShipgrade==1){
		discount=a;
	}
	else if(vo.userShipgrade==2){
		discount=b;
    	}
	else if(vo.userShipgrade==3){
		discount=c;
	}
	else if(vo.userShipgrade==4){
		discount=d;
	}
	else if(vo.userShipgrade==5){
		discount=e;
	}
	return discount;
  }
/**
 * 添加酒店营销策略
 * @param promotionnumber String型，营销策略号
 * @param promotionname String型，营销策略名
 * @param begintime Calendar型，开始时间
 * @param endtime Calendar型，结束时间
 * @param appluusertype String型，适用客户类型
 * @param num int型，订购最低房间数
 * @param dcount double型，折扣
 * @return
 * @throws
 * @see
 */
public void hoteladd(String promotionnumber,String promotionname,Calendar begintime,Calendar endtime,String applyusertype,int num,double dcount) {
	PromotionVO vo=new PromotionVO();
	vo.promotionNumber=promotionnumber;
	vo.promotionName=promotionname;
	vo.promotionState=1;
	vo.promotionBegintime=begintime;
	vo.promotionEndtime=endtime;
	vo.applyuserType=applyusertype;
	vo.miniNum=num;
	vo.promotionDiscount=dcount;
	PromotionLineItem a=new PromotionLineItem(vo);
    promotionList.addPromotionLineItems(a);
}
public void addpromotionlist(PromotionList list){
	promotionlist=list;
}
/**
 * 添加网站营销策略
 * @param promotionnumber String型，营销策略号
 * @param promotionid String型，营销策略名
 * @param begintime Calendar型，开始时间
 * @param endtime Calendar型，结束时间
 * @param circle String型，商圈
 * @param grade int型，会员等级
 * @param dcount double型，折扣
 * @return
 * @throws
 * @see
 */
public void webadd(String promotionnumber,String promotionname,Calendar begintime,Calendar endtime,String circle,int grade,double dcount) {
	PromotionVO vo=new PromotionVO();
	vo.promotionNumber=promotionnumber;
	vo.promotionName=promotionname;
	vo.promotionState=1;
	vo.promotionBegintime=begintime;
	vo.promotionEndtime=endtime;
	vo.applybusinesscircle=circle;
	vo.applyuserShipgrade=grade;
	vo.promotionDiscount=dcount;
	PromotionLineItem a=new PromotionLineItem(vo);
    promotionList.addPromotionLineItems(a);
}
/**
	 * 查找用户可用的营销策略并选择优惠最大策略
	 * @param id String型，用户账号
	 * @return 可用的营销策略数
	 */
public double getPromotion() {
	List<PromotionLineItem> list=promotionList.getPromotion();
	double min=list.get(0).getvo().promotionDiscount;
	for(int i=1;i<list.size();i++){
	if(list.get(i).getvo().promotionDiscount<=min){
	min=list.get(i).getvo().promotionDiscount;
  }
	}
	return min;
}
/**
 * 删除营销策略
 * @param promotionnumber String型，营销策略号
 * @return
 * @throws
 * @see
 */
public void delete(String promotionnumber) {
	List<PromotionLineItem> list=promotionList.getPromotion();
	for(int i=1;i<list.size();i++){
		if(list.get(i).getvo().promotionNumber==promotionnumber){
			promotionlist.cancel(promotionnumber);	
		}
	}
}
}
