package uiService;

import UserView.HotelSearchView;

public interface HotelSearchUiService {
	public void setView(HotelSearchView view);
	public void toUserView();
	public void toHotelBrowseView();
	public void toOrderBuildView();
}
