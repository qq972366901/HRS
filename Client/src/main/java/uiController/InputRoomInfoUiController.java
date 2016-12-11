package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.InputRoomInfoView;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.InputRoomInfoUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class InputRoomInfoUiController implements InputRoomInfoUiService {
	
	private InputRoomInfoView view;
	
	private HotelBLService hotel = new HotelBLServiceController();
	
	private String hotelID;
	
	private String key=null;
	
	public InputRoomInfoUiController(String id) {
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

	public void setView(InputRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller, hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void inputRoomInfo(String roomType, int roomNumber, int roomPrice, String roomNNN) {
		//系统更新酒店拥有的房间信息
		hotel.updateHotelRooms(hotelID, roomType, roomNumber, roomPrice, roomNNN);
	}

}
