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

/**
 * 更新房间信息的界面的控制器
 * @author 刘宗侃
 *
 */
public class UpdateRoomInfoUiController implements UpdateRoomInfoUiService {

	private UpdateRoomInfoView view;
	
	private String hotelID;
	
	private RoomBLService room = new RoomBLServiceController();
	
	private String key=null;
	/**
	 * 更新房间信息界面的控制器构造方法
	 * @param id
	 */
	public UpdateRoomInfoUiController(String id) {
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
	public void setView(UpdateRoomInfoView view) {
		this.view = view;
	}

	/**
	 * 返回管理客房界面
	 */
	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber,String roomState) {
		room.updateRoomInfo(hotelID, roomNumber, roomState);
	}

	/**
     * 房间是否存在
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     */
	public boolean exist(String hotelID, String roomNumber) {
		return room.exist(hotelID, roomNumber);
	}
	
}
