package uiController;

import java.rmi.RemoteException;

import Service.Impl.UserBLServiceImpl;
import UserView.LogView;
import uiService.LoginViewControllerService;
import userBLService.UserBLService;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LogView view;
    private UserBLService user;
    
	public LoginViewControllerImpl(){
    	user=new UserBLServiceImpl();
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
		try {
			view.login(user.login(id, password));		                                    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
