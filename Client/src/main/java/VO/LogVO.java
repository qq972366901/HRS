package VO;

import PO.UserPO;

public class LogVO extends VO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userpassword;
	public String id;
	public boolean inorout; 
	public LogVO(String up,String ID,boolean log){
		userpassword=up;
		id=ID;
		inorout=log;
	}
	public LogVO(){
		
	}
	public LogVO(UserPO po){
		
	}
}
