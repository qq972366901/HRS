package userBLImpl;

import java.rmi.RemoteException;

import VO.UserVO;
/**
 * 负责与注册相关的任务
 * @author LZ
 * @version 1.0
 * @see VO.UserVO
 */
public class Register {
	private User user;
	public Register(){
		user=new User();
	}
	/**
	 * 增加一位用户
	 * @param vo 界面层传来的VO对象
	 * @throws RemoteException
	 * @see VO.UserVO
	 */
	public void add(UserVO vo) throws RemoteException{
		user.create(vo);
	}
	/**
	 * 获取用户信息
	 * @param id 界面层传来的用户ID
	 * @return 返回属于此ID的用户信息
	 * @see VO.UserVO
	 */
	public UserVO getUser(String id){
		if(user.findByID(id) != null){
			return user.findByID(id);
		}
		else{
			return null;
		}
	}
}
