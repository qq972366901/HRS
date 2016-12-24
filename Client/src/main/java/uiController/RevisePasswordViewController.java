package uiController;

import java.rmi.RemoteException;
import UserView.RevisePasswordView;
import uiService.RevisePasswordViewService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;
/**
 * 修改密码的初始界面接口的实现（方法的注释见及接口）
 * @author 刘宇翔
 *
 */
public class RevisePasswordViewController implements RevisePasswordViewService {
	private RevisePasswordView view;
	private UserBLService user;
	private String UserID;
	String key;
	public RevisePasswordViewController(String ID){
		try {
			user=new UserBLServiceController();
			key=Log.getLogInstance().getSKey(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserID=ID;
		
	}
	@Override
	public void setView(RevisePasswordView view) {
		this.view=view;
	}

	@Override
	public void exit() {
		view.exit();
	}

	@Override
	public void revisepassword(String password) {
		user.revisepassword(UserID, DES.encryptDES(password,key));
		view.exit();
	}
	@Override
	public String getUserID() {
		return UserID;
	}
	@Override
	public boolean checkoldPassword(String password) {
		return user.checkoldPassword(UserID, DES.encryptDES(password,key));
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
