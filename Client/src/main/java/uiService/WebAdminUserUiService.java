package uiService;

import UserView.WebAdminUserView;


public interface WebAdminUserUiService {
	public void setView(WebAdminUserView view);
	public void toAddHotelView();
	public void toLogView();
	public void toUserManagementView();

}
