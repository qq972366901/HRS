package uiController;

import VO.UserVO;
import WebPromotionView.CreditManagementView;
import WebPromotionView.WebPromotionUserView;
import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLService_realize;

public class CreditManagementUiController implements CreditManagementUiService{
	private CreditManagementView view;
	private UserBLService userService;
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
		userService=new UserBLService_realize();
		controller.setView(view);
		ClientRunner.change(view);
	}
	@Override
	public void updateCredit(String acc, int value) {
		// TODO Auto-generated method stub
		UserVO vo=userService.findByAccount(acc);
		userService.updateCredit(vo,value);
	}

}
