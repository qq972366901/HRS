package uiController;

import HotelWorkerView.InputRoomInfoView;
import UserView.AdminRoomView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.InputRoomInfoUiService;

public class InputRoomInfoUiController implements InputRoomInfoUiService {
	
	private InputRoomInfoView view;

	public void setView(InputRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController();
		AdminRoomView view = new AdminRoomView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void inputRoomInfo() {
		//系统更新酒店拥有的房间信息
	}

}
