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
	 * @see bussinesslogic.Customer
	 */
	public void register(UserVO vo,String password) throws RemoteException {
		register.add(vo,password);
	}
		/**
		 * 客户登录
		 * @param in MessageInput型，界面输入的更新信息
		 * @return
		 * @see bussinesslogic.Customer
		 */
		public boolean login(String ID, String password)throws RemoteException {
			return log.login(ID,password);
		}
		/**
		 * 客户登出
		 * @param in MessageInput型，界面选择的信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.Customer
		 */
		public void logout(String ID) {
			log.logout(ID);
		}
		/**
		 * 修改密码
		 * @param userID
		 * @param password
		 */
		public void revisepassword(String userID, String password) {
			// TODO Auto-generated method stub
			log.revisepassword(userID,password);
		}
		/**
		 * 检查密码是否正确
		 * @param userID
		 * @param password
		 * @return 
		 */
		public boolean checkoldPassword(String userID, String password) {
			// TODO Auto-generated method stub
			return log.passwordIsValid(userID,password);
		}
}
