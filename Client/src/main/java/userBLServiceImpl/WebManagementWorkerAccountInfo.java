package userBLServiceImpl;

import VO.LogVO;
import VO.UserVO;
import common.UserType;

/**
 * 网站管理人员账户信息，提供给Account类维护，使用
 * @author LZ
 *
 */
public class WebManagementWorkerAccountInfo  extends AccountInfo{
	private UserType type;
	private String username;
	private String id;
	private String password;
	private String contactway;
	public WebManagementWorkerAccountInfo(UserVO vo,String userpassword) {
		type=vo.type;
		username=vo.username;
		id=vo.id;
		password=userpassword;
		contactway=vo.contactway;
	}
	
}
