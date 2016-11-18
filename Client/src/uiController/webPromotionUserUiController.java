package uiController;

import HotelWorkerView.ProcessOrderView;
import WebPromotionView.CreditManagementView;
import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionStrategyView;
import WebPromotionView.WebPromotionUserView;
import common.UserType;
import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.MemberLevelSystemUiService;
import uiService.ProcessOrderUiService;
import uiService.WebPromotionStrategyUiService;
import uiService.webPromotionUserUiService;

/**
 * 负责实现酒店管理系统的网站营销人员界面的控制器
 * @author 刘宗侃
 * @version 1.0
 * @see uiService.webPromotionUserUiService
 * @see javax.swing.JFrame
 * @see java.awt.event.WindowAdapter;
 * @see java.awt.event.WindowEvent;
 * 
 */

public class webPromotionUserUiController implements webPromotionUserUiService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebPromotionUserView view;
	@Override
	public void toWebPromotionStrategyView() {
		// TODO Auto-generated method stub
		WebPromotionStrategyUiService controller=new WebPromotionStrategyUiController();
		WebPromotionStrategyView view=new WebPromotionStrategyView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toCreditManagementView() {
		// TODO Auto-generated method stub
		CreditManagementUiService controller=new CreditManagementUiController();
		CreditManagementView view=new CreditManagementView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toMemberLevelSystemView() {
		// TODO Auto-generated method stub
		MemberLevelSystemUiService controller=new MemberLevelSystemUiController();
		MemberLevelSystemView view=new MemberLevelSystemView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toLogView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setView(WebPromotionUserView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	@Override
	public void toProcessOrderOrderView() {
		// TODO Auto-generated method stub
		ProcessOrderUiService controller=new ProcessOrderUiController(1,UserType.WebPromotionWorker);
		ProcessOrderView view=new ProcessOrderView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

}

