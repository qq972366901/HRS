package uiService;

import java.rmi.RemoteException;

import UserView.WebAdminUserView;


public interface WebAdminUserUiService {
	public void setView(WebAdminUserView view);
	public void toAddHotelView(String id);
	public void toLogView();
	public void toUserManagementView(String id) throws RemoteException;
	public String getUserID();
	public void logout(String ID);
}
