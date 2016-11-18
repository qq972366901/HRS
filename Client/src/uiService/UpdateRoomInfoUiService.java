package uiService;

import HotelWorkerView.UpdateRoomInfoView;

public interface UpdateRoomInfoUiService {

	public void setView(UpdateRoomInfoView view);
	public void toAdminRoomView();
	public void updateRoomInfo();//系统更新房间入住信息
	
}
