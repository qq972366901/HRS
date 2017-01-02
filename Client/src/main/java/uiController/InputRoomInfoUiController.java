package uiController;

import java.rmi.RemoteException;

import common.DES;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import hotelWorkerView.AdminRoomView;
import hotelWorkerView.InputRoomInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.InputRoomInfoUiService;
import userBLServiceImpl.Log;

/**
 * 负责实现录入客房界面的控制器
 * @author 刘宗侃
 */
public class InputRoomInfoUiController implements InputRoomInfoUiService {
	
	private InputRoomInfoView view;
	
	private HotelBLService hotel = new HotelBLServiceController();
	
	private String hotelID;
	
	private String key=null;
	
	/**
	 * 录入客房界面的控制器构造方法
	 * @param id
	 */
	public InputRoomInfoUiController(String id) {
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

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(InputRoomInfoView view) {
		this.view = view;
	}

	/**
	 * 返回管理客房界面
	 */
	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller, hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
	 * 系统更新酒店拥有的房间信息
	 * @param roomType String型，房型
	 * @param roomNumber int型，房间数量
	 * @param roomPrice int型，房间原始价格
	 * @param roomNNN String型，房间号
	 */
	public void inputRoomInfo(String roomType, int roomNumber, int roomPrice, String roomNNN) {
		hotel.updateHotelRooms(hotelID, roomType, roomNumber, roomPrice, roomNNN);
	}

}
