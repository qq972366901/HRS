package uiController;

import java.rmi.RemoteException;

import common.DES;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import hotelWorkerView.HotelMainView;
import hotelWorkerView.UpdateHotelInfoView;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.UpdateHotelInfoUiService;
import userBLServiceImpl.Log;

/**
 * 维护酒店基本信息的界面的控制器
 * @author 刘宗侃
 *
 */
public class UpdateHotelInfoUiController implements UpdateHotelInfoUiService {
	
	private UpdateHotelInfoView view;
	
	private HotelBLService hotel = new HotelBLServiceController();
	
	private String hotelID;
	
	private String key=null;
	
	/**
	 * 维护酒店基本信息界面的控制器构造方法
	 * @param id
	 */
	public UpdateHotelInfoUiController(String id) {
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
	public void setView(UpdateHotelInfoView view) {
		this.view = view;
	}

	/**
	 * 返回酒店工作人员主界面
	 */
	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(DES.decryptDES(hotelID, key));
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	/**
     * 更新酒店的基本信息
     * 
     * @param hotelName String型，酒店名称
     * @param hotelLocation String型，酒店地址
     * @param hotelService String型，酒店设施服务
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelIntroduce String型，酒店简介
     * @param hotelStar int型，酒店星级
     * @param hotelPhone String型，酒店联系电话
     */
	public void updateHotelInfo(String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone) {
		hotel.updateHotelInfo(hotelID, hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar, hotelPhone);
	}

}
