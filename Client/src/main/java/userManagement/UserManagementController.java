package userManagement;

import java.rmi.RemoteException;
import VO.UserVO;
import common.ResultMessage;
import userBLServiceImpl.Account;
import userBLServiceImpl.Register;
public class UserManagementController{
	private Register register;
	public UserManagementController(){
		register=new Register();
	}
		/**
		 * 新增客户信息
		 * @param in MessageInput型，界面输入的新增信息
		 * @return 返回ResultMessage的一个枚举值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public boolean add(UserVO vo,String password) throws RemoteException {
			return register.add(vo,password);
		}
		/**
		 * 删除客户信息
		 * @param in MessageInput型，界面选择删除的信息
		 * @return 返回ResultMessage的一个枚举值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public void delete(String id) throws RemoteException {
			Account.getInstance().delete(id);
		}
			/**
			 * 判断客户账号是否存在
			 * @param account
			 * @return
			 */
		public boolean judge(String id) {
			// TODO Auto-generated method stub
			return Account.getInstance().judgeAccount(id);
		}
}
