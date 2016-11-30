package userBLServiceImpl;

import java.util.HashMap;
/**
 * 对于PromotionInfo接口的实现
 * @author LZ
 * @version 1.0
 */
public class MemberGrade implements PromotionInfo{
	private HashMap<Integer,Long> map;
	public MemberGrade(){
		map=new HashMap<Integer,Long>();
	}
	public Double getDiscount(Integer level) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<Integer, Long> getLevelSystem() {
		// TODO Auto-generated method stub
		return null;
	}
}
