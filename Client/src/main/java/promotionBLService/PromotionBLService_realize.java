package promotionBLService;

import java.util.ArrayList;

import Object.Promotion;
import VO.PromotionVO;
import common.ResultMessage;

public class PromotionBLService_realize implements PromotionBLService{
	/**
     * 添加一种新的酒店营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyhotel (PromotionVO vo) {
		return null;
	}
	
	
	/**
     * 添加一种新的网站营销策略，并公布
     * 
     * @param vo PromotionVO型，界面输入的营销策略
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage madebyweb (PromotionVO vo ) {
		return null;
	} 

	
	/**
     * 标记会员等级标准
     * 
     * @param vo PromotionVO型，界面输入的会员等级标注
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Promotion
     */
	public ResultMessage memberlevelmade(PromotionVO vo) {
		return null;
	}

	
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
		return null;
	}

    /**
     * 获取所有网站营销策略
     */
	@Override
	public ArrayList<PromotionVO> getAllWebPromotion() {
		// TODO Auto-generated method stub
		return new ArrayList<PromotionVO>();
	}


	@Override
	public boolean deleteStrategy(int strategyNo) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public void updateMemberLevelSystem(PromotionVO vo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addMemberLevelSystem(PromotionVO vo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PromotionVO getMemberLevelSystem() {
		// TODO Auto-generated method stub
		return null;
	}
}
