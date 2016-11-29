package uiService;

import HotelWorkerView.UpdateRoomInfoView;

public interface UpdateRoomInfoUiService {

	public void setView(UpdateRoomInfoView view);
	public void toAdminRoomView();
	public void updateRoomInfo(String hotelID, String roomNumber,String roomType, String roomState);//系统更新房间入住信息
	
}
