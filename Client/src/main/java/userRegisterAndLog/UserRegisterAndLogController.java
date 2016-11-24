package userRegisterAndLog;
import java.rmi.RemoteException;

import VO.UserVO;
import userBLServiceImpl.Log;
import userBLServiceImpl.Register;
public class UserRegisterAndLogController{
	private Register register;
	private Log log;
	public UserRegisterAndLogController() throws RemoteException{
		this.log=Log.getLogInstance();
		this.register=new Register();
	}
	/**
	 * 客户注册
	 * @param in MessageInput型，界面输入的注册信息
	 * @return 返回ResultMessage的所有枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.User
	 */
	public void register(UserVO vo) throws RemoteException {
		register.add(vo);
	}
		/**
		 * 客户登录
		 * @param in MessageInput型，界面输入的更新信息
		 * @return
		 * @see bussinesslogic.User
		 */
		public boolean login(String ID, String password)throws RemoteException {
			return log.login(ID,password);
		}
		/**
		 * 客户登出
		 * @param in MessageInput型，界面选择的信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
		public void logout(String ID) {
			log.logout(ID);
		}
}
