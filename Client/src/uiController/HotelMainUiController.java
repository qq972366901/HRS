package uiController;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.BrowseOrderView;
import HotelWorkerView.HotelMainView;
import HotelWorkerView.MakeHotelPromotionView;
import HotelWorkerView.UpdateHotelInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.BrowseOrderUiService;
import uiService.HotelMainUiService;
import uiService.MakeHotelPromotionUiService;
import uiService.UpdateHotelInfoUiService;

public class HotelMainUiController implements HotelMainUiService {

	private HotelMainView view;
	
	
	public void setView(HotelMainView view){
		this.view = view;
	}
	
	public void toLogView() {
		//跳转到初始登录界面
	}
	
	public void toUpdateHotelInfoView() {
		UpdateHotelInfoUiService controller = new UpdateHotelInfoUiController();
		UpdateHotelInfoView view = new UpdateHotelInfoView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController();
		AdminRoomView view = new AdminRoomView(controller);
		controller.setView(view);
		ClientRunner.change(view);
		
	}
	
	public void toBrowseOrderView() {
		BrowseOrderUiService controller = new BrowseOrderUiController();
		BrowseOrderView view = new BrowseOrderView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toMakeHotelPromotionView() {
		MakeHotelPromotionUiService controller = new MakeHotelPromotionController();
		MakeHotelPromotionView view = new MakeHotelPromotionView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

}
