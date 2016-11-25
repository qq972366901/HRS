package userManagement;

import VO.UserVO;
import common.ResultMessage;
public class UserManagementController{
		/**
		 * 新增客户信息
		 * @param in MessageInput型，界面输入的新增信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
			public ResultMessage add(UserVO vo) {
			return ResultMessage.Exist;
		}
		/**
		 * 删除客户信息
		 * @param in MessageInput型，界面选择删除的信息
		 * @return 返回ResultMessage的一个枚举值
		 * @see bussinesslogic.User
		 */
			public ResultMessage delete(UserVO vo) {
			return ResultMessage.Exist;
		}
			/**
			 * 判断客户账号是否存在
			 * @param account
			 * @return
			 */
		public boolean judge(String account) {
			// TODO Auto-generated method stub
			return false;
		}
}
