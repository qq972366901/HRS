package uiController;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.InputRoomInfoView;
import HotelWorkerView.UpdateRoomInfoView;
import UserView.AdminRoomView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.HotelMainUiService;
import uiService.InputRoomInfoUiService;
import uiService.UpdateRoomInfoUiService;

public class AdminRoomUiController implements AdminRoomUiService {
	
	private AdminRoomView view;
	
	private String hotelID;
	
	public AdminRoomUiController(String id) {
		hotelID = id;
	}
	
	public void setView(AdminRoomView view) {
		this.view = view;
	}
	
	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(hotelID);
		HotelMainView view = new HotelMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toInputRoomInfoView() {
		InputRoomInfoUiService controller = new InputRoomInfoUiController(hotelID);
		InputRoomInfoView view = new InputRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toUpdateRoomInfoView() {
		UpdateRoomInfoUiService controller = new UpdateRoomInfoUiController(hotelID);
		UpdateRoomInfoView view = new UpdateRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	

}
