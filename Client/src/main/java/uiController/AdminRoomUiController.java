package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.HotelMainView;
import HotelWorkerView.InputRoomInfoView;
import HotelWorkerView.UpdateRoomInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.HotelMainUiService;
import uiService.InputRoomInfoUiService;
import uiService.UpdateRoomInfoUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class AdminRoomUiController implements AdminRoomUiService {
	
	private AdminRoomView view;
	
	private String hotelID;
	
	private String key=null;
	
	public AdminRoomUiController(String id) {
		try {
			Log log=new Log();
			key=log.getKey(id);
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
	
	public void setView(AdminRoomView view) {
		this.view = view;
	}
	
	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(DES.decryptDES(hotelID, key));
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toInputRoomInfoView() {
		InputRoomInfoUiService controller = new InputRoomInfoUiController(DES.decryptDES(hotelID, key));
		InputRoomInfoView view = new InputRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void toUpdateRoomInfoView() {
		UpdateRoomInfoUiService controller = new UpdateRoomInfoUiController(DES.decryptDES(hotelID, key));
		UpdateRoomInfoView view = new UpdateRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	

}
