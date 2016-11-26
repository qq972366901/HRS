package userBLService;

import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JLabel;

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
	 * @see bussinesslogic.Customer
	 */
	public UserVO findByID(String userID) {
		return userInfomationMaintenanceController.findByID(userID);
	}
	/**
	 * 更新客户信息
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public void update(UserVO vo,String password) {
		try {
			userInfomationMaintenanceController.update(vo,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 新增客户信息
	 * @param in MessageInput型，界面输入的新增信息
	 * @return 返回ResultMessage的一个枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public boolean add(UserVO vo,String password) {
		try {
			return userManagementController.add(vo,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除客户信息
	 * @param in MessageInput型，界面选择删除的信息
	 * @return 返回ResultMessage的一个枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public void delete(String id) {
		try {
			userManagementController.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 显示信用值
	 * @param in MessageInput型，界面输入用户ID
	 * @return String型，返回客户的信用值
	 * @see bussinesslogic.Customer
	 */
	public long showCredit(String userID) {
		return userCreditRecordController.showCredit(userID);
	}
	/**
	 * 通过充值更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.Customer
	 */
	public void updateCredit(String id,long val) {
		userCreditManagementController.updateCredit(id,val);
	}
	/**
	 * 更新会员等级
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @throws RemoteException 
	 * @see bussinesslogic.Customer
	 */
	public void updateLevel(String id,long credit) {
		try {
			userCreditManagementController.updateLevel(id,credit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据信用记录更新信用值
	 * @param in MessageInput型，界面输入的更新信息
	 * @return 返回ResultMessage的一个枚举值
	 * @see bussinesslogic.Customer
	 */
	public ResultMessage updateCreditRecord(UserVO vo) {
		return userCreditManagementController.updateCreditRecord(vo);
	}
	/**
	 * 客户注册
	 * @param in MessageInput型，界面输入的注册信息
	 * @see bussinesslogic.Customer
	 */
	public void register(UserVO vo,String password) {
		try {
			userRegisterAndLogController.register(vo,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 客户登录
	 * @param ID String型，password String型，界面输入的登录信息
	 * @return 返回布尔值，表示登陆是否成功
	 * @see bussinesslogic.Customer
	 */
	public boolean login(String ID, String password)throws RemoteException {
		return userRegisterAndLogController.login(ID, password);
	}
	/**
	 * 客户登出
	 * @param ID String型，界面选择的信息
	 * @see bussinesslogic.Customer
	 */
	public void logout(String ID) {
		userRegisterAndLogController.logout(ID);
	}
	/**
	 * 信用记录显示
	 */
	public List<CreditRecordVO> showCreditRecord(String userID) {
		return userCreditRecordController.showCreditRecord(userID);
	}
	/**
	 * 判断账号是否存在
	 */
	@Override
	public boolean judge(String account) {
		// TODO Auto-generated method stub
		return userManagementController.judge(account);
	}
    /**
     * 修改密码
     */
	public void revisepassword(String userID, String password){
		userRegisterAndLogController.revisepassword(userID, password);
	}
	/**
	 * 检查密码是否正确
	 */
	@Override
	public boolean checkoldPassword(String userID, String password) {
		// TODO Auto-generated method stub
		return userRegisterAndLogController.checkoldPassword(userID,password);
	}
}
