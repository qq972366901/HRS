package uiService;

import HotelWorkerView.UpdateHotelInfoView;

public interface UpdateHotelInfoUiService {

	public void setView(UpdateHotelInfoView view);
	public void toHotelMainView();
	public void updateHotelInfo(String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone);//更新酒店信息
	
}
