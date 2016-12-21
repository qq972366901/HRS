package userCreditRecharge;
import java.rmi.RemoteException;

import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import common.UserType;
import userBLService.UserBLService_realize;
public class UserCreditRechargeController extends UserBLService_realize{
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage findByID(String userID) {
		return null;
	}
		/**
		 * 显示信用值
		 * @param in MessageInput型，界面输入用户ID
		 * @return String型，返回客户的信用值
		 * @see bussinesslogic.User
		 */
			public long showCredit(String userID) {
			return 200;
		}
			/**
			 * 信用记录显示
			 * @param in MessageInput型，界面选择的信息
			 * @return 返回ResultMessage的一个枚举值
			 * @see bussinesslogic.User
			 */
				public CreditRecordVO showCreditRecord(UserVO vo) {
				CreditRecordVO crv=new CreditRecordVO();
				return crv;
			}
			/**
			 * 通过充值更新信用值
			 * @param in MessageInput型，界面输入的更新信息
			 * @return 返回ResultMessage的一个枚举值
			 * @see bussinesslogic.User
			 */
				public ResultMessage updateCredit(UserVO vo,long credit) {
				return ResultMessage.Exist;
			}
				/**
				 * 客户登录
				 * @param in MessageInput型，界面输入的更新信息
				 * @return 返回UserType的所有枚举值
				 * @see bussinesslogic.User
				 */
					public UserType login(String ID, String password)throws RemoteException {
					return UserType.Customer;
				}
				/**
				 * 客户登出
				 * @param in MessageInput型，界面选择的信息
				 * @return 返回ResultMessage的一个枚举值
				 * @see bussinesslogic.User
				 */
					public ResultMessage logout(String ID) {
					return ResultMessage.Exist;
				}
}
