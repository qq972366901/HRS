package uiService;

import webPromotionView.WebPromotionUserView;

/**
 * 负责实现酒店管理系统的网站营销人员的初始界面
 * @author 刘宗侃
 * @version 1.0
 */
public interface webPromotionUserUiService {
	/**
	 * 跳转到制定网站策略界面
	 */
	public void toWebPromotionStrategyView();
	/**
	 * 跳转到信用值管理界面
	 */
	public void toCreditManagementView();
	/**
	 * 跳转到制定会员等级系统界面
	 */
	public void toMemberLevelSystemView();
	/**
	 * 跳转到登录界面
	 */
	public void toLogView();
	/**
	 * 设置界面
	 * @param view 界面层传来的panel
	 */
	public void setView(WebPromotionUserView view);
	/**
	 * 跳转到订单界面
	 */
	public void toProcessOrderOrderView();
}

