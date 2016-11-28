package VO;

import java.util.Vector;

import PO.UserPO;

public class LogVO{
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
