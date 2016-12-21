package uiController;

import java.rmi.RemoteException;

import UserView.LogView;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
    private OrderBLService order;
	public LoginViewControllerImpl(){
    	try {
			user=new UserBLServiceController();
			order=new OrderBLServiceController();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
	@Override
	public void setView(LogView view) {
		this.view=view;
	}

	@Override
	public boolean login(String id,String password) {		
            return user.login(id, password);
	}

	@Override
	public boolean register()  {
		try {
			view.register();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void updateRegisterButton(String selected) {
		view.updateRegisterButton(selected);
	}
	@Override
	public void updateOrderState() {
		order.updateOrderState();
	}
}
