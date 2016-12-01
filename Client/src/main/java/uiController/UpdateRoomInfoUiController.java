package uiController;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.UpdateRoomInfoView;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.UpdateRoomInfoUiService;

public class UpdateRoomInfoUiController implements UpdateRoomInfoUiService {

	private UpdateRoomInfoView view;
	
	private String hotelID;
	
	private RoomBLService room = new RoomBLServiceController();
	
	public UpdateRoomInfoUiController(String id) {
		hotelID = id;
	}
	
	public void setView(UpdateRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(hotelID);
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateRoomInfo(String hotelID, String roomNumber,String roomType, String roomState) {
		//系统更新房间状态信息
		room.updateRoomInfo(hotelID, roomNumber,roomType, roomState);
	}

}
