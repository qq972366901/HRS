package uiController;

import WebPromotionView.MemberLevelSystemView;
import WebPromotionView.WebPromotionUserView;
import runner.ClientRunner;
import uiService.MemberLevelSystemUiService;
import uiService.webPromotionUserUiService;

public class MemberLevelSystemUiController implements MemberLevelSystemUiService{
	private MemberLevelSystemView view;
	@Override
	public void setView(MemberLevelSystemView view) {
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
