package uiController;

import java.rmi.RemoteException;
import UserView.revisePasswordView;
import uiService.revisePasswordViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class revisePasswordViewControllerImpl implements revisePasswordViewControllerService {
	private revisePasswordView view;
	private UserBLService user;
	private String UserID;
	public revisePasswordViewControllerImpl(String ID){
		try {
			user=new UserBLServiceController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserID=ID;
		
	}
	@Override
	public void setView(revisePasswordView view) {
		this.view=view;
	}

	@Override
	public void exit() {
		view.exit();
	}

	@Override
	public void revisepassword(String password) {
		user.revisepassword(UserID, password);
		view.exit();
	}
	@Override
	public String getUserID() {
		return UserID;
	}
	@Override
	public boolean checkoldPassword(String password) {
		return user.checkoldPassword(UserID, password);
	}
	@Override
	public boolean checknewPassword(String password) {
		if(password.equals("")){
			return false;
		}
		System.out.println(password);
		for(char a:password.toCharArray()){
			if((a>='a'&&a<='z')
					||(a>='A'&&a<='Z')
					||(a>='0'&&a<='9')){
			}
			else{
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean checksame(String password1, String password2) {
		if(password1.equals(password2)){
			return true;
		}
		return false;
	}
	@Override
	public boolean checksame_old(String password1, String password2) {
		if(password1.equals(password2)){
			return true;
		}
		return false;
	}
}
