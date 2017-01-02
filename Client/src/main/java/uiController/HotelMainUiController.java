package uiController;

import java.rmi.RemoteException;

import common.DES;
import common.UserType;
import hotelWorkerView.AdminRoomView;
import hotelWorkerView.HotelMainView;
import hotelWorkerView.MakeHotelPromotionView;
import hotelWorkerView.ProcessOrderView;
import hotelWorkerView.UpdateHotelInfoView;
import runner.ClientRunner;
import uiService.AdminRoomUiService;
import uiService.HotelMainUiService;
import uiService.LoginViewControllerService;
import uiService.MakeHotelPromotionUiService;
import uiService.ProcessOrderUiService;
import uiService.UpdateHotelInfoUiService;
import userBLServiceImpl.Log;
import userView.LogView;

/**
 * 负责实现酒店管理系统的酒店工作人员的初始界面的控制器
 * @author 刘宗侃
 */
public class HotelMainUiController implements HotelMainUiService {

	private HotelMainView view;
	
	private String hotelID;
	
	private String key=null;
	/**
	 * 酒店工作人员主界面控制器构造方法
	 * @param id
	 */
	public HotelMainUiController(String id) {
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
	public void setView(HotelMainView view){
		this.view = view;
	}
	
	/**
	 * 返回登录界面
	 */
	public void toLogView() {
		//跳转到初始登录界面
		LoginViewControllerService controller =  new LoginViewController();
    	LogView view = new LogView(controller);
		controller.setView(view);
		ClientRunner.change(view);
	}
	
	/**
	 * 进入维护酒店基本信息界面
	 */
	public void toUpdateHotelInfoView() {
		UpdateHotelInfoUiService controller = new UpdateHotelInfoUiController(DES.decryptDES(hotelID, key));
		UpdateHotelInfoView view = new UpdateHotelInfoView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
	 * 进入管理房间界面
	 */
	public void toAdminRoomView() {
		AdminRoomUiService controller = new AdminRoomUiController(DES.decryptDES(hotelID, key));
		AdminRoomView view = new AdminRoomView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
		
	}

	/**
	 * 进入制定酒店营销策略界面
	 */
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

	/**
	 * 进入浏览订单界面
	 */
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
