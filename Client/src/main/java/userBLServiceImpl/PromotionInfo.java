package userBLServiceImpl;

import java.util.HashMap;
/**
 * 负责提供关于会员等级系统的信息
 * @author LZ
 * @version 1.0
 */
public interface PromotionInfo {
	/**
	 * 根据等级提供折扣
	 * @param level
	 * @return
	 */
	public Double getDiscount(Integer level);
	/**
	 * 获取会员等级系统
	 * @return
	 */
	public HashMap<Integer, Long> getLevelSystem();
}
