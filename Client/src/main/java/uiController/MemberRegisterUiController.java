package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.MemberRegisterView;
import WebPromotionView.WebPromotionUserView;
import UserView.AddHotelView;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
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
