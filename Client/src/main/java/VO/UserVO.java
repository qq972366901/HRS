package VO;

import java.util.Calendar;
import java.util.Vector;

import common.UserType;

/**
 * 用户的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Customer
 */

public class UserVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String username;
	public String id;
	public String contactway;
	public String membertype;
	public UserType type;
	public Calendar birthday;
	public String enterprise;

	public UserVO(){
	}
	public UserVO(String usern,String ID,String contact,String mt,UserType t,Calendar birth,String enter){
		username=usern;
		id=ID;
		contactway=contact;
		membertype=mt;
		type=t;
		birthday=birth;
		enterprise=enter;
	}
	/**
     * 更新用户信息
     * 
     * @param user UserVO型，一个用来更新数据的用户对象
     * @return 
     * @see VO.UserVO
     */
	public void update(UserVO user) {
		contactway=user.contactway;
		username=user.username;
		enterprise=user.enterprise;
		birthday=user.birthday;
		membertype=user.membertype;
	}
	
	/**
     * 创建用户对象
     * 
     * @return 一个新注册的用户
     * @see Object.User
     */
	public UserVO makeUser() {
		
		return new UserVO();
	}
	
}
