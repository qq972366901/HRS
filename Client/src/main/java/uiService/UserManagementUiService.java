package uiService;

import UserView.UserManagementView;
import VO.UserVO;

public interface UserManagementUiService {
	public void setView(UserManagementView view);
	public void toWebAdminUserView(String id);
	public UserVO findByID(String userID);
	public void update(UserVO vo);
	public long showCredit(String userID);
	public boolean judge(String account);
}
