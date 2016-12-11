package userBLService;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import VO.CreditRecordVO;
import VO.UserVO;
import common.UserType;
import userBLServiceImpl.AccountInfo;
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
	 * @param  userID String型，界面输入的客户ID
	 * @return 返回UserVO
	 * @throws  
	 * @see Customer.User
	 */
	public UserVO findByID(String userID){
		try {
			return userInfomationMaintenanceController.findByID(userID);
		} catch (RemoteException e) {
			System.out.println("获取用户信息失败");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 更新客户信息
	 * @param vo UserVO型，界面输入的更新信息
	 * @param passwordo String型，用户的密码
	 * @see Customer.User
	 */
	public void update(UserVO vo) {
		try {
			userInfomationMaintenanceController.update(vo);
		} catch (RemoteException e) {
			System.out.println("更新客户信息失败");
			e.printStackTrace();
		}
	}
	/**
	 * 新增客户信息
	 * @param vo UserVO型，界面输入的新增信息
	 * @param passwordo String型，用户的密码
	 * @return 返回布尔值表示成功与否
	 * @see Customer.User
	 */
	public boolean add(UserVO vo,String password) {
		try {
			return userManagementController.add(vo,password);
		} catch (RemoteException e) {
			System.out.println("新增客户信息失败");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除客户信息
	 * @param id String型，界面选择的用户账号
	 * @see Customer.User
	 */
	public void delete(String id) {
		try {
			userManagementController.delete(id);
		} catch (RemoteException e) {
			System.out.println("删除用户失败");
			e.printStackTrace();
		}
	}
	/**
	 * 显示信用值
	 * @param userID String型，界面输入用户ID
	 * @return long型，返回客户的信用值
	 * @throws  
	 * @see Customer.User
	 */
	public long showCredit(String userID){
		try {
			return userCreditRecordController.showCredit(userID);
		} catch (RemoteException e) {
			System.out.println("获取信用值失败");
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 更新会员等级
	 * @param id String型，界面输入的用户账号
	 * @param credit long型，界面传入的信用值
	 * @see Customer.User
	 */
	public void updateLevel(String id,long credit) {
		try {
			userCreditManagementController.updateLevel(id,credit);
		} catch (RemoteException e) {
			System.out.println("更新会员等级失败");
			e.printStackTrace();
		}
	}
	/**
	 * 根据信用记录更新信用值
	 * @param vo CreditRecordVO型，界面传入的CreditRecordVO
	 * @throws RemoteException 
	 * @see Customer.User
	 */
	public void updateCreditRecord(CreditRecordVO vo) {
		try {
			userCreditManagementController.updateCreditRecord(vo);
			updateLevel(vo.account,vo.currentcredit);
		} catch (RemoteException e) {
			System.out.println("rmi失败");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("解析失败");
			e.printStackTrace();
		}
	}
	/**
	 * 客户注册
	 * @param vo UserVO型，界面传入的VO对象
	 * @param password String型，界面传入的客户密码
	 * @see Customer.User
	 */
	public void register(UserVO vo,String password) {
		try {
			userRegisterAndLogController.register(vo,password);
		} catch (RemoteException e) {
			System.out.println("客户注册失败");
			e.printStackTrace();
		}
	}
	/**
	 * 客户登录
	 * @param ID String型，界面输入的用户账号
	 * @param password String型，界面输入的用户账号
	 * @see Customer.User
	 */
	public boolean login(String ID, String password){
		try {
			return userRegisterAndLogController.login(ID, password);
		} catch (RemoteException e) {
			System.out.println("客户登录失败");
			e.printStackTrace();
		}
		return false;
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
	 * @param id String型，界面传入的客户账号
	 * @return 返回信用记录列表 
	 * @see Customer.User
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String userID){
		try {
			return userCreditRecordController.showCreditRecord(userID);
		} catch (RemoteException e) {
			System.out.println("rmi失败");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("解析失败");
			e.printStackTrace();
		}
		return new HashMap<String,CreditRecordVO>();
	}
	/**
	 * 判断账号是否存在
	 * @param account String型，逻辑层传入的用户账号
	 * @return 返回布尔值表示是否存在此账号
	 * @throws  
	 */
	@Override
	public boolean judge(String account){
		try {
			return userManagementController.judge(account);
		} catch (RemoteException e) {
			System.out.println("判断失败");
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 修改密码
     * @param userID String型，界面层传入的用户账号
     * @param password String 型，界面层传入的用户密码
     */
	public void revisepassword(String userID, String password){
		userRegisterAndLogController.revisepassword(userID, password);
	}
	/**
	 * 检查密码是否正确
	 * @param userID String型，界面层传入的用户账号
     * @param password String 型，界面层传入的用户密码
     * @return 返回布尔值表示密码是否正确
	 */
	@Override
	public boolean checkoldPassword(String userID, String password) {
		return userRegisterAndLogController.checkoldPassword(userID,password);
	}
	/**
	 * 获取对应等级的折扣
	 * @param level int 型，界面层传入的会员等级
	 * return 返回此等级对应的折扣
	 */
	@Override
	public Double getDiscount(int level) {
		return userCreditManagementController.getDiscount(level);
	}
	/**
	 * 更新所有客户的会员等级
	 * 
	 */
	@Override
	public boolean updateAllLevel() {
		return userCreditManagementController.updateAllLevel();
	}
	/**
	 * 显示信用等级
	 * @param id String 型，界面层传入的客户账户
	 * @return 返回此账号的信用等级
	 */
	public int showLevel(String id){
		return userInfomationMaintenanceController.showLevel(id);
	}
	/**
	 * 根据用户账号和类型获取客户账户信息，供网站管理人员查看
	 * @param type UserType型，用户类型
	 * @param account String型，用户账号
	 * @return 返回用户账号信息
	 * @throws  
	 */
	@Override
	public AccountInfo getUser(UserType type, String account){
		try {
			return userManagementController.getUser(type,account);
		} catch (RemoteException e) {
			System.out.println("获取用户账号信息失败");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addLog(String id, String k, String secretid) {
		return userRegisterAndLogController.addLog(id,k,secretid);
	}
}
