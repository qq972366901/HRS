package VO;

import PO.UserPO;
/**
 * 登录有关的数据
 * @author LZ
 *
 */
public class LogVO{
	public String userpassword;
	public String id;
	public boolean inorout; 
	public LogVO(String up,String ID,boolean log){
		userpassword=up;
		id=ID;
		inorout=log;
	}
	
	public LogVO(UserPO po){
		userpassword=po.getPassword();
		id=po.getAccount();
		inorout=false;
	}
}
