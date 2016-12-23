package uiService;

import java.util.Vector;

import UserView.InformationView;
/**
 * 负责实现个人信息管理的初始界面
 * @author 刘宇翔
 *
 */
public interface InformationViewControllerService {
    /**
     * 返回按钮的实现
     */
	public void exit();
	/**
	 * 设置一个InformationView的panel
	 * @param view
	 */
	public void setView(InformationView view);
	/**
	 * 获得客户相关信息
	 * @param UserID 客户账号
	 * @return 客户相关信息
	 */
    public Vector<String> getInformation(String UserID);
    /**
     * 修改个人信息界面的跳转
     */
    public void reviseinformation();
    /**
     * 修改密码界面的跳转
     */
    public void revisepassword();
    /**
     * 获得用户id
     * @return 用户id
     */
    public String getUserID();
}
