package userCreditManagement;

import java.rmi.RemoteException;

import VO.UserVO;
import common.ResultMessage;
import userBLServiceImpl.Customer;


public class UserCreditManagementController extends UserBLService_realize {
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage findByID(String userID) {
		return ResultMessage.Exist;
	}
		/**
		 * 显示信用值
		 * @param in MessageInput型，界面输入用户ID
		 * @return String型，返回客户的信用值
		 * @see bussinesslogic.Customer
		 */
			public long showCredit(String userID) {
			return 200;
		}
		/**
		 * 通过充值更新信用值
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.Customer
		 */
		public void updateCredit(String id,long val) {
			//待补充
		}
		/**
		 * 更新会员等级
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @throws RemoteException 
		 * @see bussinesslogic.Customer
		 */
		public void updateLevel(String id, long credit) throws RemoteException {
			// TODO Auto-generated method stub
			Customer.getUserInstance().updateLevel(id, credit);
		}
		/**
		 * 根据信用记录更新信用值
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.Customer
		 */
			public ResultMessage updateCreditRecord(UserVO vo) {
			return ResultMessage.Exist;
		}
}
