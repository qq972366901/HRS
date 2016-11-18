package userBLService;

import java.rmi.RemoteException;

import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import common.UserType;

public class UserBLService_realize implements UserBLService {
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
	 * 更新客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage update(UserVO vo) {
		return null;
	}
	/**
	 * 新增客户信息
	 * @param in MessageInput型，界面输入的新增信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage add(UserVO vo) {
		return null;
	}
	/**
	 * 删除客户信息
	 * @param in MessageInput型，界面选择删除的信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage delete(UserVO vo) {
		return null;
	}
	/**
	 * 显示信用值
	 * @param in MessageInput型，界面输入用户ID
	 * @return String型，返回客户的信用值
	 * @see bussinesslogic.User
	 */
		public long showCredit(String userID) {
		return 0;
	}
	/**
	 * 通过充值更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage updateCredit(UserVO vo,long credit) {
		return null;
	}
	/**
	 * 更新会员等级
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage updateLevel(UserVO vo) {
		return null;
	}
	/**
	 * 根据信用记录更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage updateCreditRecord(UserVO vo) {
		return null;
	}
	/**
	 * 客户注册
	 * @param in MessageInput型，界面输入的注册信息
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage register(UserVO vo) {
		return null;
	}
	/**
	 * 维护客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage maintainPeersonalInfo(UserVO vo) {
		return null;
	}
	/**
	 * 信用记录显示
	 * @param in MessageInput型，界面选择的信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public CreditRecordVO showCreditRecord(UserVO vo) {
		return null;
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
	/**
	 * 订单未支付完成
	 * @param in MessageInput型，界面输入的支付信息
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage payment(long money) {
		return null;
	}
	/**
	 * 客户登录
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回UserType的所有枚举值
	 * @see bussinesslogic.User
	 */
		public UserType login(String ID, String password)throws RemoteException {
		return null;
	}
	/**
	 * 客户登出
	 * @param in MessageInput型，界面选择的信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
		public ResultMessage logout(String ID) {
		return null;
	}
	/**
	 * 按账号查找客户
	 */
	@Override
	public UserVO findByAccount(String acc) {
		// TODO Auto-generated method stub
		return null;
	}

}
