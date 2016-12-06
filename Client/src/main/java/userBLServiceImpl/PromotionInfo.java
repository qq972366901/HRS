package userBLServiceImpl;

import VO.MemberLevelSystemVO;
/**
 * 负责提供关于会员等级系统的信息
 * @author LZ
 * @version 1.0
 */
public interface PromotionInfo {
	/**
	 * 根据等级提供折扣
	 * @param grade int型，逻辑层传入的会员等级
	 * @return 返回此等级对应的折扣
	 */
	public double getDiscountOfLevel(int grade);
	/**
	 * 获取会员等级系统
	 * @return MemberLevelSystemVO 返回回忆等级系统
	 */
	public MemberLevelSystemVO getMemberLevelSystem();
}
