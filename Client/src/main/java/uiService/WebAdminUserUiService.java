package uiService;

import java.rmi.RemoteException;

import userView.WebAdminUserView;

/**
 * 网站管理人员主界面接口的实现接口
 * @author 刘伟
 *
 */
public interface WebAdminUserUiService {
	/**
	 * 设置一个WebAdminUserView的panel
	 * @param view
	 */
	public void setView(WebAdminUserView view);

	/**
	 * 跳转到添加酒店界面
	 * @param view
	 */
	public void toAddHotelView(String id);

	/**
	 * 跳转到登录界面
	 * @param view
	 */
	public void toLogView();

	/**
	 * 跳转到用户管理界面
	 * @param view
	 */
	public void toUserManagementView(String id) throws RemoteException;

	/**
	 * 从上一界面获取用户ID
	 * @param view
	 */
	public String getUserID();

	/**
	 * 注销用户ID
	 * @param view
	 */
	public void logout(String ID);
}
