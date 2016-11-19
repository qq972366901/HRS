package uiService;

import WebPromotionView.WebPromotionUserView;

/**
 * 负责实现酒店管理系统的网站营销人员的初始界面
 * @author 刘宗侃
 * @version 1.0
 */
public interface webPromotionUserUiService {
	public void toWebPromotionStrategyView();
	public void toCreditManagementView();
	public void toMemberLevelSystemView();
	public void toLogView();
	public void setView(WebPromotionUserView view);
	public void toProcessOrderOrderView();
}

