package uiController;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.HotelMainView;
import HotelWorkerView.InputRoomInfoView;
import HotelWorkerView.UpdateRoomInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.HotelMainUiService;
import uiService.InputRoomInfoUiService;
import uiService.UpdateRoomInfoUiService;

public class AdminRoomUiController implements AdminRoomUiService {
	
	private AdminRoomView view;
	
	public void setView(AdminRoomView view) {
		this.view = view;
	}
	
	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController();
		HotelMainView view = new HotelMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toInputRoomInfoView() {
		InputRoomInfoUiService controller = new InputRoomInfoUiController();
		InputRoomInfoView view = new InputRoomInfoView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toUpdateRoomInfoView() {
		UpdateRoomInfoUiService controller = new UpdateRoomInfoUiController();
		UpdateRoomInfoView view = new UpdateRoomInfoView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	

}
