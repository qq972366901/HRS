package vo;

import java.util.Calendar;

import common.UserType;
import po.UserPO;

/**
 * 用户的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.Customer
 */

public class UserVO{

	public String username;
	public String id;
	public String contactway;
	public String membertype;
	public UserType type;
	public Calendar birthday;
	public String enterprise;

	public UserVO(String usern,String ID,String contact,String mt,UserType t,Calendar birth,String enter){
		username=usern;
		id=ID;
		contactway=contact;
		membertype=mt;
		type=t;
		birthday=birth;
		enterprise=enter;
	}
	public UserVO(UserPO user) {
		username=user.getName();
		id=user.getAccount();
		contactway=user.getContact();
		membertype=user.getMemberType();
		type=user.getType();
		birthday=user.getBirthday();
		enterprise=user.getEnterprise();
	}
	
	/**
     * 更新用户信息
     * 
     * @param user UserVO型，一个用来更新数据的用户对象
     * @return 
     * @see vo.UserVO
     */
	public void update(UserVO user) {
		contactway=user.contactway;
		username=user.username;
		enterprise=user.enterprise;
		birthday=user.birthday;
		membertype=user.membertype;
	}
	
}
