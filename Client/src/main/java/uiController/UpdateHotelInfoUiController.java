package uiController;

import java.rmi.RemoteException;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.UpdateHotelInfoView;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.UpdateHotelInfoUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class UpdateHotelInfoUiController implements UpdateHotelInfoUiService {
	
	private UpdateHotelInfoView view;
	
	private HotelBLService hotel = new HotelBLServiceController();
	
	private String hotelID;
	
	private String key=null;
	
	public UpdateHotelInfoUiController(String id) {
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

	public void setView(UpdateHotelInfoView view) {
		this.view = view;
	}

	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(DES.decryptDES(hotelID, key));
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void updateHotelInfo(String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone) {
		//数据库更新酒店信息
		hotel.updateHotelInfo(hotelID, hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar, hotelPhone);
	}

}
