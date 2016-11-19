package LoginView;

import java.rmi.RemoteException;

import Service.Impl.UserBLServiceImpl;
import common.UserType;
import userBLService.UserBLService;

public class LoginViewControllerImpl implements LoginViewControllerService{
    private LoginView view;
    private UserBLService user;
    
	public LoginViewControllerImpl(){
    	user=new UserBLServiceImpl();
    }
	@Override
	public void updatemodel(String str) {		
	}

	@Override
	public void setView(LoginView view) {
		this.view=view;
	}

	@Override
	public boolean login(String id,String password) {		
		try {
			view.login(user.login(id, password));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean register() {
		// TODO Auto-generated method stub
		return false;
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
