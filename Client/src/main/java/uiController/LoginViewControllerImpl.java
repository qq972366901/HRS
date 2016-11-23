package uiController;

import java.rmi.RemoteException;
import UserView.LogView;
import common.UserType;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
	public LoginViewControllerImpl() throws RemoteException{
    	user=new UserBLServiceController();
    }
	@Override
	public void updatemodel(String str) {		
	}

	@Override
	public void setView(LogView view) {
		this.view=view;
	}

	public void login(String id,String password,UserType type) {		
		try {
			if(user.login(id, password)){
				view.login(type);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean register() {
		// TODO Auto-generated method stub
		view.register();
		return true;
	}

	@Override
	public boolean find() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void error() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRegisterButton(String selected) {
		// TODO Auto-generated method stub
		view.updateRegisterButton(selected);
	}

}
