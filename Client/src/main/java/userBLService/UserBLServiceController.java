package userBLService;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.HashMap;
import VO.CreditRecordVO;
import VO.UserVO;
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
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除客户信息
	 * @param id String型，界面选择的用户
	 * @see Customer.User
	 */
	public void delete(String id) {
		try {
			userManagementController.delete(id);
		} catch (RemoteException e) {
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
			e.printStackTrace();
		} catch (ParseException e) {
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
			e.printStackTrace();
		}
	}
	/**
	 * 客户登录
	 * @param ID String型，界面输入的用户账号
	 * @param password型，界面输入的用户账号
	 * @see Customer.User
	 */
	public boolean login(String ID, String password){
		try {
			return userRegisterAndLogController.login(ID, password);
		} catch (RemoteException e) {
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
	 * @throws  
	 * @throws  
	 * @see Customer.User
	 */
	public HashMap<String,CreditRecordVO> showCreditRecord(String userID){
		try {
			return userCreditRecordController.showCreditRecord(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new HashMap<String,CreditRecordVO>();
	}
	/**
	 * 判断账号是否存在
	 * @throws  
	 */
	@Override
	public boolean judge(String account){
		try {
			return userManagementController.judge(account);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
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
		return userRegisterAndLogController.checkoldPassword(userID,password);
	}
	/**
	 * 获取对应等级的折扣
	 */
	@Override
	public Double getDiscount(int level) {
		return userCreditManagementController.getDiscount(level);
	}
	/**
	 * 更新所有客户的会员等级
	 */
	@Override
	public void updateAllLevel() {
		userCreditManagementController.updateAllLevel();
	}
	/**
	 * 显示信用等级
	 * @param id
	 * @return
	 */
	public int showLevel(String id){
		return userInfomationMaintenanceController.showLevel(id);
	}
}
