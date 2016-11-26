package uiController;

import java.rmi.RemoteException;

import UserView.LogView;
import common.UserType;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
    
	public LoginViewControllerImpl(){
    	//user=new UserBLServiceImpl();
    }
	@Override
	public void updatemodel(String str) {		
	}

	@Override
	public void setView(LogView view) {
		this.view=view;
	}

	@Override
	public boolean login(String id,String password,String type) {		
		view.login(UserType.Customer);		                                    
		return true;
		/*if(user.login(id,password,type)){
		 *    view.login();
		 *    return true;
		 *    }
		 *else{
		 *    return false;
		 * }	
		 * 
		 */
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
