package userBLServiceImpl;

import java.util.HashMap;

import VO.MemberLevelSystemVO;
/**
 * 负责提供关于会员等级系统的信息
 * @author LZ
 * @version 1.0
 */
public interface PromotionInfo {
	/**
	 * 根据等级提供折扣
	 * @param grade int
	 * @return
	 */
	public double getDiscountOfLevel(int grade);
	/**
	 * 获取会员等级系统
	 * @return MemberLevelSystemVO
	 */
	public MemberLevelSystemVO getMemberLevelSystem();
}
