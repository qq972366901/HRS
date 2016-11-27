package uiController;

import HotelWorkerView.UpdateRoomInfoView;
import UserView.AdminRoomView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.UpdateRoomInfoUiService;

public class UpdateRoomInfoUiController implements UpdateRoomInfoUiService {

	private UpdateRoomInfoView view;
	
	private String hotelID;
	
	public UpdateRoomInfoUiController(String id) {
		hotelID = id;
	}
	
	public void setView(UpdateRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(hotelID);
		AdminRoomView view = new AdminRoomView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateRoomInfo() {
		//系统更新房间入住信息
	}

}
