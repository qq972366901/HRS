package uiController;

import HotelWorkerView.InputRoomInfoView;
import UserView.AdminRoomView;
import hotelBLService.HotelBLService;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.InputRoomInfoUiService;

public class InputRoomInfoUiController implements InputRoomInfoUiService {
	
	private InputRoomInfoView view;
	
	private HotelBLService hotel;
	
	private String hotelID;
	
	public InputRoomInfoUiController(String id) {
		hotelID = id;
	}

	public void setView(InputRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(hotelID);
		AdminRoomView view = new AdminRoomView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void inputRoomInfo(String roomType, int roomNumber, int roomPrice) {
		//系统更新酒店拥有的房间信息
		hotel.updateHotelRooms(hotelID, roomType, roomNumber, roomPrice);
	}

}
