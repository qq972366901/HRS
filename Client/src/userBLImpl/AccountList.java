package userBLImpl;

import java.util.HashMap;

import VO.UserVO;
/**
 * 账户工厂，负责返回特定类型的账户列表
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public interface AccountList {
	/**
	 * 返回特定类型的账户列表
	 * @param type int型，逻辑层传来的账户类型
	 * @return 返回属于此类型的账户列表
	 * @see VO.UserVO
	 */
	public HashMap<String,UserVO> getAccountList(int type);
}
