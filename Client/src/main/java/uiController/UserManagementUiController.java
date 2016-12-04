package uiController;

import javax.swing.JPanel;

import UserView.UserManagementView;
import UserView.WebAdminUserView;
import VO.UserVO;
import runner.ClientRunner;
import uiService.UserManagementUiService;
import uiService.WebAdminUserUiService;
import userBLService.UserBLService;

public class UserManagementUiController implements UserManagementUiService {
	private static final long serialVersionUID = 1L;
	private JPanel view;
	private UserBLService user;
	@Override
	public void setView(UserManagementView view) {
		// TODO Auto-generated method stub
		this.view=view;
}
	public void toWebAdminUserView(String id){
		WebAdminUserUiService controller=new WebAdminUserUiController();
		WebAdminUserView view=new WebAdminUserView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	public UserVO findByID(String userID){
		return user.findByID(userID);
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
}
