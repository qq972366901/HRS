package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.MemberRegisterView;
import UserView.CustomerMainView;
import VO.UserVO;
import WebPromotionView.WebPromotionUserView;
import UserView.AddHotelView;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.AdminRoomUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
import uiService.CustomerMainViewService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.Customer;

public class MemberRegisterUiController implements MemberRegisterUiService {
	private JPanel view;
	private UserBLService user;
	public MemberRegisterUiController() throws RemoteException{
		this.user=new UserBLServiceController();
	}
	@Override
	public void setView(MemberRegisterView view) {
		this.view=view;
}

	public void tocustomerMainView(String id){
		CustomerMainViewService controller=new CustomerMainViewController(id);
		CustomerMainView view =new CustomerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
    public void toLogView(){
    	LoginViewControllerService controller;
		controller = new LoginViewController();
		LogView view=new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
 
	public void register(UserVO vo,String password){
		user.register(vo,password);
	}
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
}
