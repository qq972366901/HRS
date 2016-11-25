package uiController;

import java.rmi.RemoteException;
import java.util.Vector;
import UserView.reviseInformationView;
import UserView.revisePasswordView;
import uiService.revisePasswordViewControllerService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class revisePasswordViewControllerImpl implements revisePasswordViewControllerService {
	private revisePasswordView view;
	private UserBLService user;
	private String UserID;
	private char[] judge={'a','z','A','Z','0','9'};
	public revisePasswordViewControllerImpl(String ID) throws RemoteException{
		user=new UserBLServiceController();
		UserID=ID;
	}
	@Override
	public void setView(revisePasswordView view) {
		// TODO Auto-generated method stub
		this.view=view;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		view.exit();
	}

	@Override
	public void revisepassword(Vector<String> vector) {
		// TODO Auto-generated method stub
		//user.update((UserVO) vector);
		view.exit();
	}
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return UserID;
	}
	@Override
	public boolean checkoldPassword(String password) {
		// TODO Auto-generated method stub
		//user.checkoldPassword(UserID,password);
		return true;
	}
	@Override
	public boolean checknewPassword(String password) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		if(password1.equals(password2)){
			return true;
		}
		return false;
	}
	@Override
	public boolean checksame_old(String password1, String password2) {
		// TODO Auto-generated method stub
		if(password1.equals(password2)){
			return true;
		}
		return false;
	}
}
