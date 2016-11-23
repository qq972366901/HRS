package userBLService;

import java.rmi.RemoteException;
import java.util.List;

import VO.CreditRecordVO;
import VO.UserVO;
import common.ResultMessage;
import userCreditManagement.UserCreditManagementController;
import userCreditRecord.UserCreditRecordController;
import userInformationMaintenance.UserInformationMaintenanceController;
import userManagement.UserManagementController;
import userRegisterAndLog.UserRegisterAndLogController;
/**
 * User模块的实现
 * @author LZ
 *
 */
public class UserBLServiceController implements UserBLService {
	private UserRegisterAndLogController userRegisterAndLogController;
	private UserManagementController userManagementController;
	private UserInformationMaintenanceController userInfomationMaintenanceController;
	private UserCreditRecordController userCreditRecordController;
	private UserCreditManagementController userCreditManagementController;
	/**
	 * 初始化
	 * @throws RemoteException 
	 */
	public UserBLServiceController() throws RemoteException{
		this.userCreditManagementController=new UserCreditManagementController();
		this.userCreditRecordController=new UserCreditRecordController();
		this.userInfomationMaintenanceController=new UserInformationMaintenanceController();
		this.userRegisterAndLogController=new UserRegisterAndLogController();
		this.userManagementController=new UserManagementController();
	}
	
	/**
	 * 根据客户ID查找客户信息并返回
	 * @param  in MessageInput型，界面输入的客户ID
	 * @return 返回ResultMessage的所有枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage findByID(String userID) {
		return userInfomationMaintenanceController.findByID(userID);
	}
	/**
	 * 更新客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage update(UserVO vo) {
		return userInfomationMaintenanceController.update(vo);
	}
	/**
	 * 新增客户信息
	 * @param in MessageInput型，界面输入的新增信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage add(UserVO vo) {
		return userManagementController.add(vo);
	}
	/**
	 * 删除客户信息
	 * @param in MessageInput型，界面选择删除的信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage delete(UserVO vo) {
		return userManagementController.delete(vo);
	}
	/**
	 * 显示信用值
	 * @param in MessageInput型，界面输入用户ID
	 * @return String型，返回客户的信用值
	 * @see bussinesslogic.User
	 */
	public long showCredit(String userID) {
		return userCreditRecordController.showCredit(userID);
	}
	/**
	 * 通过充值更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage updateCredit(UserVO vo,long credit) {
		return userCreditManagementController.updateCredit(vo, credit);
	}
	/**
	 * 更新会员等级
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage updateLevel(UserVO vo) {
		return userCreditManagementController.updateLevel(vo);
	}
	/**
	 * 根据信用记录更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage updateCreditRecord(UserVO vo) {
		return userCreditManagementController.updateCreditRecord(vo);
	}
	/**
	 * 客户注册
	 * @param in MessageInput型，界面输入的注册信息
	 * @see bussinesslogic.User
	 */
	public void register(UserVO vo) {
		try {
			userRegisterAndLogController.register(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 维护客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage maintainPeersonalInfo(UserVO vo) {
		return userInfomationMaintenanceController.maintainPeersonalInfo(vo);
	}
	/**
	 * 订单支付成功后的信用更新
	 * @param in MessageInput型，界面输入的支付信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.User
	 */
	public ResultMessage topUp(long money) {
		return userCreditManagementController.topUp(money);
	}
	/**
	 * 客户登录
	 * @param ID String型，password String型，界面输入的登录信息
	 * @return 返回布尔值，表示登陆是否成功
	 * @see bussinesslogic.User
	 */
	public boolean login(String ID, String password)throws RemoteException {
		return userRegisterAndLogController.login(ID, password);
	}
	/**
	 * 客户登出
	 * @param ID String型，界面选择的信息
	 * @see bussinesslogic.User
	 */
	public void logout(String ID) {
		userRegisterAndLogController.logout(ID);
	}
	/**
	 * 按账号查找客户
	 */
	@Override
	public UserVO findByAccount(String acc) {
		// TODO Auto-generated method stub
		return userInfomationMaintenanceController.findByAccount(acc);
	}
	/**
	 * 信用记录显示
	 */
	public List<CreditRecordVO> showCreditRecord(String userID) {
		return userCreditRecordController.showCreditRecord(userID);
	}

}
