package uiService;

import UserView.HotelBrowseView;

public interface HotelBrowseUiService {
	public void setView(HotelBrowseView view);
	public void toHotelSearchView(String id);
	public void toOrderBuildView(String id);
}
