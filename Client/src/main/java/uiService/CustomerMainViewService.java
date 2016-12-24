package uiService;

import UserView.CustomerMainView;
/**
 * 负责实现客户的初始界面
 * @author 刘宇翔
 *
 */
public interface CustomerMainViewService {
	/**
	 * 设置一个customerMainView 的panel
	 * @param view
	 */
	public void setView(CustomerMainView view);
	/**
	 * 个人信息界面的跳转
	 */
	public void information();
	/**
	 * 信用界面的跳转
	 */
	public void credit();
	/**
	 * 返回界面的跳转
	 */
	public void exit();
	/**
	 * 酒店搜索界面的跳转
	 */
	public void search();
	/**
	 * 历史酒店界面的跳转
	 */
	public void histroy();
	/**
	 * 订单界面的跳转
	 */
	public void order();
	/**
	 * 获得客户id
	 * @return userID String 
	 */
	public String getUserID();
}
