package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.AdminRoomView;
import HotelWorkerView.UpdateRoomInfoView;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.UpdateRoomInfoUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class UpdateRoomInfoUiController implements UpdateRoomInfoUiService {

	private UpdateRoomInfoView view;
	
	private String hotelID;
	
	private RoomBLService room = new RoomBLServiceController();
	
	private String key=null;
	
	public UpdateRoomInfoUiController(String id) {
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
	
	public void setView(UpdateRoomInfoView view) {
		this.view = view;
	}

	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateRoomInfo(String hotelID, String roomNumber,String roomType, String roomState) {
		//系统更新房间状态信息
		room.updateRoomInfo(hotelID, roomNumber,roomType, roomState);
	}

}
