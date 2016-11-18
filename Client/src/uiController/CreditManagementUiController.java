package uiController;

import WebPromotionView.CreditManagementView;
import WebPromotionView.WebPromotionUserView;
import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.webPromotionUserUiService;

public class CreditManagementUiController implements CreditManagementUiService{
	private CreditManagementView view;
	@Override
	public void setView(CreditManagementView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}
	@Override
	public void toWebPromotionUserView() {
		// TODO Auto-generated method stub
		webPromotionUserUiService controller=new webPromotionUserUiController();
		WebPromotionUserView view=new WebPromotionUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

}
