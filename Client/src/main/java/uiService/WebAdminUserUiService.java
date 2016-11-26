package uiService;

import UserView.WebAdminUserView;


public interface WebAdminUserUiService {
	public void setView(WebAdminUserView view);
	public void toAddHotelView(String id);
	public void toLogView(String id);
	public void toUserManagementView(String id);

}
