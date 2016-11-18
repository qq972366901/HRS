package Object;
import java.util.Calendar;
import java.util.List;

import LineItem.PromotionLineItem;
import List.OrderList;
import List.PromotionList;
import VO.PromotionVO;
/**
 * 钀ラ攢绛栫暐鐨勬暟鎹疄浣�
 * @author LW
 * @version 1.0
 * @see
 */
public class Promotion{
	PromotionLineItem promotionlineitem;
	PromotionList promotionlist;
    private PromotionList promotionList;
/**
 * 鍒跺畾浼氬憳绛夌骇鎶樻墸
 * @param promotionnumber String鍨嬶紝钀ラ攢绛栫暐鍙�
 * @param promotionname String鍨嬶紝钀ラ攢绛栫暐鍚�
 * @param begintime Calendar鍨嬶紝寮�濮嬫椂闂�
 * @param endtime Calendar鍨嬶紝缁撴潫鏃堕棿
 * @param appluusertype String鍨嬶紝閫傜敤瀹㈡埛绫诲瀷
 * @param num int鍨嬶紝璁㈣喘鏈�浣庢埧闂存暟
 * @param dcount double鍨嬶紝鎶樻墸
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
 * 娣诲姞閰掑簵钀ラ攢绛栫暐
 * @param promotionnumber String鍨嬶紝钀ラ攢绛栫暐鍙�
 * @param promotionname String鍨嬶紝钀ラ攢绛栫暐鍚�
 * @param begintime Calendar鍨嬶紝寮�濮嬫椂闂�
 * @param endtime Calendar鍨嬶紝缁撴潫鏃堕棿
 * @param appluusertype String鍨嬶紝閫傜敤瀹㈡埛绫诲瀷
 * @param num int鍨嬶紝璁㈣喘鏈�浣庢埧闂存暟
 * @param dcount double鍨嬶紝鎶樻墸
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
 * 娣诲姞缃戠珯钀ラ攢绛栫暐
 * @param promotionnumber String鍨嬶紝钀ラ攢绛栫暐鍙�
 * @param promotionid String鍨嬶紝钀ラ攢绛栫暐鍚�
 * @param begintime Calendar鍨嬶紝寮�濮嬫椂闂�
 * @param endtime Calendar鍨嬶紝缁撴潫鏃堕棿
 * @param circle String鍨嬶紝鍟嗗湀
 * @param grade int鍨嬶紝浼氬憳绛夌骇
 * @param dcount double鍨嬶紝鎶樻墸
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
	 * 鏌ユ壘鐢ㄦ埛鍙敤鐨勮惀閿�绛栫暐骞堕�夋嫨浼樻儬鏈�澶х瓥鐣�
	 * @param id String鍨嬶紝鐢ㄦ埛璐﹀彿
	 * @return 鍙敤鐨勮惀閿�绛栫暐鏁�
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
 * 鍒犻櫎钀ラ攢绛栫暐
 * @param promotionnumber String鍨嬶紝钀ラ攢绛栫暐鍙�
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
