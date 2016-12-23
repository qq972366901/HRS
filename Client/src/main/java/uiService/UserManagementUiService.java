package uiService;

import java.rmi.RemoteException;

import UserView.UserManagementView;
import VO.UserVO;
import common.UserType;
import userBLServiceImpl.AccountInfo;
/**
 * 用户账号管理控制器接口
 * @author LZ
 *
 */
public interface UserManagementUiService {
	/**
	 * 获取用户账号
	 * @return 用户账号
	 */
	public String getUserID();
	/**
	 * 设置界面
	 * @param view UserManagementView型，界面层传来的panel
	 */
	public void setView(UserManagementView view);
	/**
	 * 跳转到网站管理人员主界面
	 * @param id String型，界面层传来的账号
	 * @throws RemoteException
	 */
	public void toWebAdminUserView(String id) throws RemoteException;
	/**
	 * 更新用户信息
	 * @param vo User型，界面层传来的VO对象
	 */
	public void update(UserVO vo);
	/**
	 * 按账号查找用户
	 * @param id
	 * @return
	 */
	public UserVO findByID(String id);
	/**
	 * 获取用户当前信用值
	 * @param userID String型，界面层传来的用户账号
	 * @return 返回此用户信用值
	 */
	public long showCredit(String userID);
	/**
	 * 判断此用户是否存在
	 * @param account String型，界面层传来的用户账号
	 * @return 判断结果
	 */
	public boolean judge(String account);
	/**
	 * 获取用户当前会员等级
	 * @param id String型，界面层传来的用户账号
	 * @return 返回此用户的会员等级
	 */
	public int showLevel(String id);
	/**
	 * 修改密码
	 * @param userID String型，界面层传来的用户账号
	 * @param password String型，界面层传来的新密码
	 */
	public void revisepassword(String userID, String password);
	/**
	 * 用户注册
	 * @param vo UserVO型，界面层传来的VO对象
	 * @param password String型，界面层传来的密码
	 */
	public void register(UserVO vo,String password);
	/**
	 * 获取用户账号信息
	 * @param type UserType型，界面层传来的用户类型
	 * @param account String型，界面层传来的用户账号
	 * @return 返回此用户账号信息
	 */
	public AccountInfo getUser(UserType type, String account);
	/**
	 * 增加密钥关系
	 * @param id String型，界面层传来的用户初始账号
	 * @param k String型，界面层传来的密钥
	 * @param secretid String型，界面层传来的用户加密后的账号
	 * @return 返回此操作是否成功
	 */
	public boolean addLog(String id,String k,String secretid);
}
