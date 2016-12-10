package uiService;

import java.rmi.RemoteException;

import UserView.UserManagementView;
import VO.UserVO;
import common.UserType;
import userBLServiceImpl.AccountInfo;

public interface UserManagementUiService {
	public String getUserID();
	public void setView(UserManagementView view);
	public void toWebAdminUserView(String id) throws RemoteException;
	public UserVO findByID(String userID);
	public void update(UserVO vo);
	public long showCredit(String userID);
	public boolean judge(String account);
	public int showLevel(String id);
	public void revisepassword(String userID, String password);
	public void register(UserVO vo,String password);
	public AccountInfo getUser(UserType type, String account);
	public boolean addLog(String id,String k,String secretid);
}
