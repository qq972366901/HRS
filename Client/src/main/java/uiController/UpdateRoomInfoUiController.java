package uiController;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.UpdateRoomInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.UpdateRoomInfoUiService;

public class UpdateRoomInfoUiController implements UpdateRoomInfoUiService {

	private UpdateRoomInfoView view;
	
	public void setView(UpdateRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController();
		AdminRoomView view = new AdminRoomView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateRoomInfo() {
		//系统更新房间入住信息
	}

}
