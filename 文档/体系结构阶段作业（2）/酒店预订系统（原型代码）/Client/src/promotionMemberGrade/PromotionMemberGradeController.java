package promotionMemberGrade;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.Promotion;
import VO.PromotionVO;
import common.ResultMessage;
import common.UserType;
import promotionBLService.PromotionBLService_realize;
public class PromotionMemberGradeController extends PromotionBLService_realize{	
	/**
     * 取消一个订单
     * 
     * @param promotion Promotion型，需要取消的订单
     * @return 取消成功则返回true，否则返回true
     * @see bussinesslogic.Promotion
     */
	public boolean cancel(Promotion promotion) {
		return false;
	}
	
	
	/**
     * 显示所有能用的营销策略
     * 
     * @param userID String型，客户的ID
     * @return ArrayList<PromotionVO>，一个营销策略值对象的列表
     * @see bussinesslogic.Promotion
     */
	public ArrayList<PromotionVO> getPromotion(String userID) {
		ArrayList<PromotionVO> array=new ArrayList<PromotionVO>();
		return array;
	}
}

