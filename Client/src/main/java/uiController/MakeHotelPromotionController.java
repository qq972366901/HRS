package uiController;

import java.rmi.RemoteException;
import java.util.Calendar;

import common.DES;
import hotelWorkerView.HotelMainView;
import hotelWorkerView.MakeHotelPromotionView;
import promotionBLService.PromotionBLService;
import promotionBLService.PromotionController;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.MakeHotelPromotionUiService;
import userBLServiceImpl.Log;

/**
 * 制定酒店营销策略界面的控制器
 * @author 刘宗侃
 *
 */
public class MakeHotelPromotionController implements MakeHotelPromotionUiService {
	
	private MakeHotelPromotionView view;
	
	private String hotelID;
	
	private PromotionBLService promotion;
	
	private String key=null;
	
	/**
	 * 制定酒店营销策略界面的控制器构造方法
	 * @param id
	 * @throws RemoteException
	 */
	public MakeHotelPromotionController (String id) throws RemoteException {
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
		init();
	}
	/**
	 * 初始化控制器
	 * @throws RemoteException
	 */
	private void init() throws RemoteException {
		promotion = new PromotionController();
	}

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(MakeHotelPromotionView view) {
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
	 * 系统添加酒店营销策略
	 * @param hotelid
	 * @param promotionname
	 * @param promotionbegintime
	 * @param promotionendtime
	 * @param promotiondiscount
	 * @param birthdaydiscount
	 * @param roomdiscount
	 * @param enterprisediscount
	 */
	public void makeHotelPromotion(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount) {
		promotion.madebyhotel(hotelid, promotionname, promotionbegintime, promotionendtime, promotiondiscount, birthdaydiscount, roomdiscount, enterprisediscount);
	}

}
