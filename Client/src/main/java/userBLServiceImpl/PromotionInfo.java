package userBLServiceImpl;

import java.util.HashMap;
/**
 * 负责提供关于会员等级系统的信息
 * @author LZ
 * @version 1.0
 */
public interface PromotionInfo {
	/**
	 * 获取会员等级系统信息
	 * @return 返回会员等级系统
	 */
	public HashMap<Integer,Long>  getLevelSystem();
}
