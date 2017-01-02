package userBLServiceImpl;

import java.rmi.RemoteException;

import vo.UserVO;
/**
 * 负责与客户注册相关的任务
 * @author LZ
 * @version 1.0
 * @see vo.UserVO
 */
public class Register {
	private Customer user;
	public Register() throws RemoteException{
		user=new Customer();
	}
	/**
	 * 增加一位用户
	 * @param vo 界面层传来的VO对象
	 * @return 
	 * @throws RemoteException
	 * @see vo.UserVO
	 */
	public boolean add(UserVO vo,String password) throws RemoteException{
		return user.create(vo,password);
	}
	/**
	 * 获取用户信息
	 * @param id 界面层传来的用户ID
	 * @return 返回属于此ID的用户信息
	 * @see vo.UserVO
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
