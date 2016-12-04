package uiService;

import UserView.AddHotelView;
import common.MessageInput;
import common.ResultMessage;

public interface AddHotelUiService {
	public void setView(AddHotelView view);
	public void toWebAdminUserView(String id);
	public void toUserManagementView(String id);
	public void saveHotelInfo(String hotelName, String hotelCity, String hotelArea, String hoelLocation,
			int hotelStar, String hotelService, String hotelIntroduction, String hotelPhone, 
			String hotelID, double hotelScore);
	public ResultMessage accuntadmin(MessageInput  in);
}
