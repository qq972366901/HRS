package VO;

import java.util.Calendar;

/**
 * 用户的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Customer
 */

public class UserVO extends VO {

	public String username;
	public String id;
	public String contactway;
	public int level;
	public long credit;
	public String membertype;
	public UserType type;
	public Calendar birthday;
	public String enterprise;

	public UserVO(){
	}
	public UserVO(String usern,String ID,String contact,int le,long cr,String mt,UserType t,Calendar birth,String enter){
		username=usern;
		id=ID;
		contactway=contact;
		level=le;
		credit=cr;
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
		credit=user.credit;
		level=user.level;
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
