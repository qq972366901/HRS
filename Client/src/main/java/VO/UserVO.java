package VO;

import java.util.Calendar;

/**
 * 用户的属性及数据创建与更新
 * @author 刘宗侃
 * @version 1.0
 * @see Object.User
 */

public class UserVO extends VO {

	public String username;
	public String useraccount;
	public String contactway;
	public String id;
	public boolean inorout;
	public int level;
	public long credit;
	public String membertype;
	public int type;//1：客户 2：酒店工作人员 3：网站营销人员 4：网站管理人员
	public Calendar birthday;
	public String enterprise;

	public UserVO(){
	}
	public UserVO(String usern,String usera,String con,String ID,boolean io,int le,long cr,String mt,int t,Calendar birth,String enter){
		username=usern;
		useraccount=usera;
		contactway=con;
		id=ID;
		inorout=io;
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
		username=user.username;
		enterprise=user.enterprise;
		birthday=user.birthday;
		membertype=user.membertype;
		contactway=user.contactway;
		credit=user.credit;
		inorout=user.inorout;
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
