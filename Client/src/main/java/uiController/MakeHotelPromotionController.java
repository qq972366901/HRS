package uiController;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.MakeHotelPromotionView;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.MakeHotelPromotionUiService;

public class MakeHotelPromotionController implements MakeHotelPromotionUiService {
	
	private MakeHotelPromotionView view;
	
	private String hotelID;
	
	public MakeHotelPromotionController (String id) {
		hotelID = id;
	}

	public void setView(MakeHotelPromotionView view) {
		this.view = view;
	}

	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(hotelID);
		HotelMainView view = new HotelMainView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void makeHotelPromotion() {
		//系统添加酒店营销策略
	}

}
