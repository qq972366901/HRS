package uiService;

import java.util.Calendar;

import HotelWorkerView.MakeHotelPromotionView;

/**
 * 制定酒店营销策略界面的服务
 * @author 刘宗侃
 *
 */
public interface MakeHotelPromotionUiService {

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(MakeHotelPromotionView view);
	
	/**
	 * 返回酒店工作人员主界面
	 */
	public void toHotelMainView();
	
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
	public void makeHotelPromotion(String hotelid,String promotionname,Calendar promotionbegintime,Calendar promotionendtime,double promotiondiscount,double birthdaydiscount,double roomdiscount,double enterprisediscount);//系统更新酒店营销策略
	
}
