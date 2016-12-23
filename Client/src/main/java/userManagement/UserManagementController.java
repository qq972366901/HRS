package userManagement;

import java.rmi.RemoteException;
import VO.UserVO;
import common.UserType;
import userBLServiceImpl.Account;
import userBLServiceImpl.AccountInfo;
import userBLServiceImpl.Customer;
import userBLServiceImpl.Register;
public class UserManagementController{
	private Account a;
	public UserManagementController(){
		try {
			a=new Account();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增客户信息
	 * @param vo UserVO型，界面输入的新增信息
	 * @param passwordo String型，用户的密码
	 * @return 返回布尔值表示成功与否
	 * @see Customer.User
	 */
		public boolean add(UserVO vo,String password) throws RemoteException {
			return a.add(vo, password);
		}
		/**
		 * 删除客户信息
		 * @param id String型，界面选择的用户账号
		 * @see Customer.User
		 */
		public void delete(String id) throws RemoteException {
			a.delete(id);
		}
		/**
		 * 判断账号是否存在
		 * @param account String型，逻辑层传入的用户账号
		 * @return 返回布尔值表示是否存在此账号
		 * @throws  
		 */
		public boolean judge(String id) throws RemoteException {
			return a.judgeAccount(id);
		}
		/**
		 * 根据用户账号和类型获取客户账户信息，供网站管理人员查看
		 * @param type UserType型，用户类型
		 * @param account String型，用户账号
		 * @return 返回用户账号信息
		 * @throws RemoteException 
		 */
		public AccountInfo getUser(UserType type, String account) throws RemoteException {
			return a.getUser(type, account);
		}
}
