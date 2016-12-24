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

/**
 * 管理客房界面的控制器
 * @author 刘宗侃
 *
 */
public class AdminRoomUiController implements AdminRoomUiService {
	
	private AdminRoomView view;
	
	private String hotelID;
	
	private String key=null;
	/**
	 * 管理客房界面的控制器构造方法
	 * @param id
	 */
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
	/**
	 * 设置界面
	 */
	public void setView(AdminRoomView view) {
		this.view = view;
	}
	/**
	 * 跳转至酒店工作人员主界面的方法
	 */
	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(DES.decryptDES(hotelID, key));
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
	 * 跳转至添加房间的界面
	 */
	public void toInputRoomInfoView() {
		InputRoomInfoUiService controller = new InputRoomInfoUiController(DES.decryptDES(hotelID, key));
		InputRoomInfoView view = new InputRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
	 * 跳转至更新房间状态的类
	 */
	public void toUpdateRoomInfoView() {
		UpdateRoomInfoUiService controller = new UpdateRoomInfoUiController(DES.decryptDES(hotelID, key));
		UpdateRoomInfoView view = new UpdateRoomInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	

}
