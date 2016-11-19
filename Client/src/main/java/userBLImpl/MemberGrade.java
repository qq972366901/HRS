package userBLImpl;

import java.util.HashMap;
/**
 * 对于PromotionInfo接口的实现
 * @author LZ
 * @version 1.0
 */
public class MemberGrade implements PromotionInfo{
	private HashMap<Integer,Long> map;
	public MemberGrade(){
		map=new HashMap<Integer, Long>();
	}
	/**
	 * 获取会员等级系统信息
	 * @return 返回会员等级系统
	 */
	@Override
	public HashMap<Integer,Long> getLevelSystem() {
		// TODO Auto-generated method stub
		return map;
	}
}
