package uiController;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import UserView.UserManagementView;
import UserView.WebAdminUserView;
import VO.UserVO;
import common.UserType;
import runner.ClientRunner;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.AccountInfo;

public class UserManagementUiController implements UserManagementUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private UserBLService user;
	private String UserID;
	public UserManagementUiController(String id) throws RemoteException{
    	//user=new UserBLServiceImpl();
    	this.UserID=id;
    	this.user=new UserBLServiceController();
    }
	public String getUserID(){
		return UserID;
	}
	public void setView(UserManagementView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id) throws RemoteException{
		WebAdminUserUiService controller=new WebAdminUserUiController(id);
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public AccountInfo findByID(UserType type,String userID){
		return user.findAllPeopleByID(type,userID);
	}
	public void update(UserVO vo){
		user.update(vo);
	}
	public long showCredit(String userID){
		return user.showCredit(userID);
	}
	public boolean judge(String account){
		return user.judge(account);
	}
	public int showLevel(String id){
		return user.showLevel(id);
		
	}
	public void revisepassword(String userID, String password){
		user.revisepassword(userID,password);
	}
	public void register(UserVO vo,String password){
		user.add(vo,password);
	}
	public AccountInfo getUser(UserType type, String account){
		return user.getUser(type,account);		
	}
	public boolean addLog(String id,String k,String secretid){
		return user.addLog(id,k,secretid);
	}
	@Override
	public UserVO findByID(String id) {
		return user.findByID(id);
	}
}
