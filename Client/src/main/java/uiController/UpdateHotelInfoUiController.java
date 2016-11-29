package uiController;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.UpdateHotelInfoView;
import hotelBLService.HotelBLService;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.UpdateHotelInfoUiService;

public class UpdateHotelInfoUiController implements UpdateHotelInfoUiService {
	
	private UpdateHotelInfoView view;
	
	private HotelBLService hotel;
	
	private String hotelID;
	
	public UpdateHotelInfoUiController(String id) {
		hotelID = id;
	}

	public void setView(UpdateHotelInfoView view) {
		this.view = view;
	}

	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(hotelID);
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateHotelInfo(String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone) {
		//数据库更新酒店信息
		hotel.updateHotelInfo(hotelID, hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar, hotelPhone);
	}

}
