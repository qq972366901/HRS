package userCreditManagement;

import VO.UserVO;
import common.ResultMessage;

public class UserCreditManagementController{
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
		 * 通过充值更新信用值
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
		public ResultMessage updateCredit(UserVO vo,long credit) {
			return ResultMessage.Exist;
		}
		/**
		 * 更新会员等级
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
		public ResultMessage updateLevel(UserVO vo) {
			return ResultMessage.Exist;
		}
		/**
		 * 根据信用记录更新信用值
		 * @param in MessageInput型，界面输入的更新信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
		public ResultMessage updateCreditRecord(UserVO vo) {
			return ResultMessage.Exist;
		}
			/**
			 * 订单支付成功后的信用更新
			 * @param in MessageInput型，界面输入的支付信息
			 * @return 返回ResultMessage的一个枚举值
			 * @see bussinesslogic.User
			 */
			public ResultMessage topUp(long money) {
					return null;
				}
}
