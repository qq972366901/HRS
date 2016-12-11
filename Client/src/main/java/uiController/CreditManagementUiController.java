package uiController;

import java.rmi.RemoteException;

import VO.CreditRecordVO;
import VO.UserVO;
import WebPromotionView.CreditManagementView;
import WebPromotionView.WebPromotionUserView;
import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class CreditManagementUiController implements CreditManagementUiService{
	private CreditManagementView view;
	private UserBLService userService;
	public CreditManagementUiController() throws RemoteException{
		userService=new UserBLServiceController();
	}
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
		try {
			userService=new UserBLServiceController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller.setView(view);
		ClientRunner.change(view);
	}
	@Override
	public void updateCredit(CreditRecordVO vo) {
		userService.updateCreditRecord(vo);
	}
	@Override
	public long getCurrencredit(String acc) {
		// TODO Auto-generated method stub
		return userService.showCredit(acc);
	}
}
