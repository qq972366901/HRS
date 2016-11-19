package Mock;

import java.util.HashMap;

import userBLImpl.MemberGrade;

public class MockMemberGrade extends MemberGrade{
	private HashMap<Integer, Long> map;
	public MockMemberGrade(){
		map=new HashMap<Integer, Long>();
		map.put(1,(long) 500);
		map.put(2,(long) 2000);
		map.put(3,(long) 4000);
		map.put(4,(long) 10000);
		map.put(5,(long) 25000);
	}
	@Override
	public HashMap<Integer,Long> getLevelSystem() {
		// TODO Auto-generated method stub
		return map;
	}
}
