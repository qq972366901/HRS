package uiController;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.UpdateHotelInfoView;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.UpdateHotelInfoUiService;

public class UpdateHotelInfoUiController implements UpdateHotelInfoUiService {
	
	private UpdateHotelInfoView view;

	public void setView(UpdateHotelInfoView view) {
		this.view = view;
	}

	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController();
		HotelMainView view = new HotelMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateHotelInfo() {
		//数据库更新酒店信息
	}

}
