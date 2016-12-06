package userManagement;

import java.rmi.RemoteException;
import VO.UserVO;
import userBLServiceImpl.Account;
import userBLServiceImpl.Register;
public class UserManagementController{
	private Register register;
	public UserManagementController() throws RemoteException{
		register=new Register();
	}
	/**
	 * 新增客户信息
	 * @param vo UserVO型，界面输入的新增信息
	 * @param passwordo String型，用户的密码
	 * @return 返回布尔值表示成功与否
	 * @see Customer.User
	 */
		public boolean add(UserVO vo,String password) throws RemoteException {
			return register.add(vo,password);
		}
		/**
		 * 删除客户信息
		 * @param id String型，界面选择的用户账号
		 * @see Customer.User
		 */
		public void delete(String id) throws RemoteException {
			Account.getInstance().delete(id);
		}
		/**
		 * 判断账号是否存在
		 * @param account String型，逻辑层传入的用户账号
		 * @return 返回布尔值表示是否存在此账号
		 * @throws  
		 */
		public boolean judge(String id) throws RemoteException {
			return Account.getInstance().judgeAccount(id);
		}
}
