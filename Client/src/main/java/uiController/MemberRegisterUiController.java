package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.MemberRegisterView;
import UserView.customerMainView;
import VO.UserVO;
import WebPromotionView.WebPromotionUserView;
import UserView.AddHotelView;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AddHotelUiService;
import uiService.AdminRoomUiService;
import uiService.LoginViewControllerService;
import uiService.MemberRegisterUiService;
import uiService.customerMainViewControllerService;
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
		customerMainViewControllerService controller=new customerMainViewControllerImpl(id);
		customerMainView view =new customerMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
    public void toLogView(){
    	LoginViewControllerService controller;
		controller = new LoginViewControllerImpl();
		LogView view=new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
    /**
     * 新建一个用户
     * @return 
     */
	@Override
	public boolean createUser(UserVO vo,String password) {
		return user.add(vo, password);
	}
	
	public void register(UserVO vo,String password){
		user.register(vo,password);
	}
}
