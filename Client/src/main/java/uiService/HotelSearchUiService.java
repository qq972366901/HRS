package uiService;

import UserView.HotelSearchView;

public interface HotelSearchUiService {
	public void setView(HotelSearchView view);
	public void toUserView(String id);
	public void toHotelBrowseView(String id);
	public void toOrderBuildView(String id);
}
