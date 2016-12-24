package uiService;

import HotelWorkerView.UpdateHotelInfoView;

/**
 * 维护酒店基本信息的界面的服务
 * @author 刘宗侃
 *
 */
public interface UpdateHotelInfoUiService {

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(UpdateHotelInfoView view);
	
	/**
	 * 返回酒店工作人员主界面
	 */
	public void toHotelMainView();
	
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
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone);//更新酒店信息
	
}
