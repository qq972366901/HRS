package VO;

import Object.User;

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
	public int level;
	public String type;
	public String birthday;
	public String enterprise;

	/**
     * 更新用户信息
     * 
     * @param user User型，一个用来更新数据的用户对象
     * @return 
     * @see Object.User
     */
	public void update(User user) {
		
	}
	
	/**
     * 创建用户对象
     * 
     * @return 一个新注册的用户
     * @see Object.User
     */
	public User makeUser() {
		
		return new User();
	}
	
}
