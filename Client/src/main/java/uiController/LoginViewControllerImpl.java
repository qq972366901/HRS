package uiController;

import java.rmi.RemoteException;

import UserView.LogView;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
    
	public LoginViewControllerImpl(){
    	try {
			user=new UserBLServiceController();
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
}
