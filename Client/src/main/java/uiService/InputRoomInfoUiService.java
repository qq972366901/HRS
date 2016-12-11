package uiService;

import HotelWorkerView.InputRoomInfoView;

public interface InputRoomInfoUiService {

	public void setView(InputRoomInfoView view);
	public void toAdminRoomView();
	public void inputRoomInfo(String roomType, int roomNumber, int roomPrice, String roomNNN);// 系统更新酒店拥有的房间信息
	
}
