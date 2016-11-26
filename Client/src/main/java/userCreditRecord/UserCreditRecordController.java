package userCreditRecord;
import java.rmi.RemoteException;

import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import common.UserType;
import userBLService.UserBLService_realize;

public class UserCreditRecordController extends UserBLService_realize{
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
			 * 信用记录显示
			 * @param in MessageInput型，界面选择的信息
			 * @return 返回ResultMessage的一个枚举值
			 * @see bussinesslogic.Customer
			 */
				public CreditRecordVO showCreditRecord(UserVO vo) {
				CreditRecordVO cr=new CreditRecordVO("1@nju.edu.cn","2016/2/2 12/4/6","4728",0,50,3000);
				return cr;
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
