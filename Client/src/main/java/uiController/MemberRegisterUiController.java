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
import userBLServiceImpl.Customer;

public class MemberRegisterUiController implements MemberRegisterUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	@Override
	public void setView(MemberRegisterView view) {
		// TODO Auto-generated method stub
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
     * @throws RemoteException 
     */
	@Override
	public boolean createUser(UserVO vo,String password) {
		// TODO Auto-generated method stub
		try {
			return Customer.getUserInstance().create(vo,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
