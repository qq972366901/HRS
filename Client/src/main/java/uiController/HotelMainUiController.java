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
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class HotelMainUiController implements HotelMainUiService {

	private HotelMainView view;
	
	private String hotelID;
	
	private String key=null;
	
	public HotelMainUiController(String id) {
		try {
			key=Log.getLogInstance().getKey(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(key!=null){
			hotelID = DES.encryptDES(id, key);
		}
		else{
			System.out.println("加密失败");
		}
	}
	
	public void setView(HotelMainView view){
		this.view = view;
	}
	
	public void toLogView() {
		//跳转到初始登录界面
		LoginViewControllerService controller =  new LoginViewController();
    	LogView view = new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	
	public void toUpdateHotelInfoView() {
		UpdateHotelInfoUiService controller = new UpdateHotelInfoUiController(DES.decryptDES(hotelID, key));
		UpdateHotelInfoView view = new UpdateHotelInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
		
	}

	public void toMakeHotelPromotionView() {
		MakeHotelPromotionUiService controller;
		try {
			controller = new MakeHotelPromotionController(DES.decryptDES(hotelID, key));
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
