package userInformationMaintenance;

import VO.UserVO;
import common.ResultMessage;

public class UserInformationMaintenanceController{
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage findByID(String userID){
			return ResultMessage.Exist;
	}
	/**
	 * 更新客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage update(UserVO vo){
			return ResultMessage.Exist;
	}
	/**
	 * 维护客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage maintainPeersonalInfo(UserVO vo){
			return ResultMessage.Exist;
		}
		/**
		 * 按账号查找客户
		 */
		public UserVO findByAccount(String acc) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
