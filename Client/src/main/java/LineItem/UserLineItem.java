package LineItem;

import VO.UserVO;

public class UserLineItem {
	 UserVO c;
	   public UserLineItem(UserVO c){
		   this.c=c;
	   }
	   public UserVO getUser(){
		   return c;
	   }
}
