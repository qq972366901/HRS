package uiService;

import UserView.AddHotelView;

public interface AddHotelUiService {
	public void setView(AddHotelView view);
	public void toWebAdminUserView(String id);
	public void toUserManagementView(String id);
	
}
