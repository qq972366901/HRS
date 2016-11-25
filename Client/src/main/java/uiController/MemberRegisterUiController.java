package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.MemberRegisterView;
import UserView.customerMainView;
import WebPromotionView.WebPromotionUserView;
import UserView.AddHotelView;
import UserView.AdminRoomView;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.AdminRoomUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
import uiService.customerMainViewControllerService;
import uiService.webPromotionUserUiService;

public class MemberRegisterUiController implements MemberRegisterUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(MemberRegisterView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void tocustomerMainView(){
		customerMainViewControllerService controller = null;
		try {
			controller = new customerMainViewControllerImpl("1");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerMainView view = new customerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
    public void toLogView(){
    	LoginViewControllerService controller;
		try {
			controller = new LoginViewControllerImpl();
			LogView view=new LogView(controller);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
