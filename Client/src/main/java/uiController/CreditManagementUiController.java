package uiController;

import java.rmi.RemoteException;

import runner.ClientRunner;
import uiService.CreditManagementUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import vo.CreditRecordVO;
import webPromotionView.CreditManagementView;
import webPromotionView.WebPromotionUserView;
/**
 * 用户信用值管理界面控制器
 * @author LZ
 *
 */
public class CreditManagementUiController implements CreditManagementUiService{
	private CreditManagementView view;
	private UserBLService userService;
	public CreditManagementUiController() throws RemoteException{
		userService=new UserBLServiceController();
	}
	@Override
	public void setView(CreditManagementView view) {
		this.view=view;
	}
	@Override
	public void toWebPromotionUserView() {
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
		return userService.showCredit(acc);
	}
}
