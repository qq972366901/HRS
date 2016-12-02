package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.HotelMainView;
import HotelWorkerView.MakeHotelPromotionView;
import HotelWorkerView.ProcessOrderView;
import HotelWorkerView.UpdateHotelInfoView;
import common.UserType;
import UserView.LogView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.HotelMainUiService;
import uiService.LoginViewControllerService;
import uiService.MakeHotelPromotionUiService;
import uiService.ProcessOrderUiService;
import uiService.UpdateHotelInfoUiService;

public class HotelMainUiController implements HotelMainUiService {

	private HotelMainView view;
	
	private String hotelID;
	
	public HotelMainUiController(String id) {
		hotelID = id;
	}
	
	public void setView(HotelMainView view){
		this.view = view;
	}
	
	public void toLogView() {
		//跳转到初始登录界面
		LoginViewControllerService controller =  new LoginViewControllerImpl();
    	LogView view = new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	
	public void toUpdateHotelInfoView() {
		UpdateHotelInfoUiService controller = new UpdateHotelInfoUiController(hotelID);
		UpdateHotelInfoView view = new UpdateHotelInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(hotelID);
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
		
	}

	public void toMakeHotelPromotionView() {
		MakeHotelPromotionUiService controller;
		try {
			controller = new MakeHotelPromotionController(hotelID);
			MakeHotelPromotionView view = new MakeHotelPromotionView(controller,hotelID);
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void toProcessOrderOrderView() {
		ProcessOrderUiService controller;
		try {
			controller = new ProcessOrderUiController(hotelID,UserType.HotelWorker);
			ProcessOrderView view=new ProcessOrderView(controller);
			view.disableCancel();
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
