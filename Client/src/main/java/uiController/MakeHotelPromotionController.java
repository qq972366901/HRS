package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.MakeHotelPromotionView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.MakeHotelPromotionUiService;
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class MakeHotelPromotionController implements MakeHotelPromotionUiService {
	
	private MakeHotelPromotionView view;
	
	private String hotelID;
	
	private PromotionBLService promotion;
	
	private String key=null;
	
	public MakeHotelPromotionController (String id) throws RemoteException {
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
		init();
	}
	
	private void init() throws RemoteException {
		promotion = new PromotionController();
	}

	public void setView(MakeHotelPromotionView view) {
		this.view = view;
	}

	public void toHotelMainView() {
		HotelMainUiService controller = new HotelMainUiController(DES.decryptDES(hotelID, key));
		HotelMainView view = new HotelMainView(controller,hotelID);
		controller.setView(view);
		ClientRunner.change(view);
	}

	public void makeHotelPromotion(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount) {
		//系统添加酒店营销策略
		promotion.madebyhotel(hotelid, promotionname, promotionbegintime, promotionendtime, promotiondiscount, birthdaydiscount, roomdiscount, enterprisediscount);
	}

}
