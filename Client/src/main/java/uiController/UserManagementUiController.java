package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.UserManagementView;
import UserView.WebAdminUserView;
import VO.UserVO;
import common.UserType;
import runner.ClientRunner;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.AccountInfo;
/**
 * 用户管理界面的控制器
 * @author lw
 *
 */
public class UserManagementUiController implements UserManagementUiService {
	private JPanel view;
	private UserBLService user;
	private String UserID;
	/**
	 * 用户管理界面的控制器构造方法
	 * @param id
	 */
	public UserManagementUiController(String id) throws RemoteException{
    	this.UserID=id;
    	this.user=new UserBLServiceController();
    }
	/**
	 * 从上一界面获取用户ID
	 * @param 
	 */
	public String getUserID(){
		return UserID;
	}
	/**
	 * 设置用户管理界面的panel
	 * @param 
	 */
	public void setView(UserManagementView view) {
		this.view=view;
}
	/**
	 * 跳转到网站管理人员界面
	 * @param 
	 */
	public void toWebAdminUserView(String id) throws RemoteException{
		WebAdminUserUiService controller=new WebAdminUserUiController(id);
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	/**
	 * 获取用户的账号信息
	 * @param 
	 */
	public AccountInfo findByID(UserType type,String userID){
		return user.findAllPeopleByID(type,userID);
	}
	/**
	 * 更新用户的信息
	 * @param 
	 */
	public void update(UserVO vo){
		user.update(vo);
	}
	/**
	 * 获取用户的信用值
	 * @param 
	 */
	public long showCredit(String userID){
		return user.showCredit(userID);
	}
	/**
	 * 判断账号是否存在
	 * @param 
	 */
	public boolean judge(String account){
		return user.judge(account);
	}
	/**
	 * 获取用户的会员等级
	 * @param 
	 */
	public int showLevel(String id){
		return user.showLevel(id);
		
	}
	/**
	 * 修改账号的密码
	 * @param 
	 */
	public void revisepassword(String userID, String password){
		user.revisepassword(userID,password);
	}
	/**
	 *保存客户的注册信息
	 * @param 
	 */
	public void register(UserVO vo,String password){
		user.add(vo,password);
	}
	/**
	 * 获取客户的账号信息
	 * @param 
	 */
	public AccountInfo getUser(UserType type, String account){
		return user.getUser(type,account);		
	}
	/**
	 * 保存客户的账号，加密后的账号和密钥
	 * @param 
	 */
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
	/**
	 * 获取用户的详细信息
	 * @param 
	 */
	@Override
	public UserVO findByID(String id) {
		return user.findByID(id);
	}
}
