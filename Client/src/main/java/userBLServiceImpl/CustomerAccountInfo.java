package userBLServiceImpl;

import VO.LogVO;
import VO.UserVO;
import common.UserType;

/**
 * 客户账户信息，提供给Account类维护，使用
 * @author LZ
 *
 */
public class CustomerAccountInfo  extends AccountInfo{
	private UserType type;
	private String username;
	private String id;
	private String password;
	private String contactway;

	public CustomerAccountInfo(UserVO vo,String userpassword) {
		// TODO Auto-generated constructor stub
		type=vo.type;
		username=vo.username;
		id=vo.id;
		password=userpassword;
		contactway=vo.contactway;
	}

}
