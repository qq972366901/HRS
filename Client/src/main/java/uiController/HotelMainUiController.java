package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.MakeHotelPromotionView;
import HotelWorkerView.ProcessOrderView;
import HotelWorkerView.UpdateHotelInfoView;
import common.UserType;
import UserView.AdminRoomView;
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

	public void toMakeHotelPromotionView() {
		MakeHotelPromotionUiService controller = new MakeHotelPromotionController();
		MakeHotelPromotionView view = new MakeHotelPromotionView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}

	@Override
	public void toProcessOrderOrderView() {
		// TODO Auto-generated method stub
		ProcessOrderUiService controller;
		try {
			controller = new ProcessOrderUiController("1",UserType.Hotelworker);
			ProcessOrderView view=new ProcessOrderView(controller);
			view.disableCancel();
			controller.setView(view);
			ClientRunner.change(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//系统自动获取酒店工作人员账号，这里用1代替
	}

}
