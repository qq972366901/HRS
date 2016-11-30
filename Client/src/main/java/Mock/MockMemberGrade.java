package Mock;

import java.util.HashMap;

import userBLServiceImpl.MemberGrade;
import userBLServiceImpl.PromotionInfo;

public class MockMemberGrade implements PromotionInfo{
	private HashMap<Integer, Long> map1;
	private HashMap<Integer, Double> map2;
	public MockMemberGrade(){
		map1=new HashMap<Integer, Long>();
		map1.put(1,(long) 500);
		map1.put(2,(long) 2000);
		map1.put(3,(long) 4000);
		map1.put(4,(long) 10000);
		map1.put(5,(long) 25000);
		map2=new HashMap<Integer, Double>();
		map2.put(1, 9.5);
		map2.put(2, 8.5);
		map2.put(3, 7.5);
		map2.put(4, 6.5);
		map2.put(5, 5.5);
	}
	@Override
	public Double getDiscount(Integer level) {
		return map2.get(level);
	}
	@Override
	public HashMap<Integer, Long> getLevelSystem() {
		return map1;
	}
}
