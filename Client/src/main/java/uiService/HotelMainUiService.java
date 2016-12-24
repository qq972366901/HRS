package uiService;

import HotelWorkerView.HotelMainView;

/**
 * 负责实现酒店管理系统的酒店工作人员的初始界面的服务
 * @author 刘宗侃
 */
public interface HotelMainUiService {

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(HotelMainView view);
	
	/**
	 * 返回登录界面
	 */
	public void toLogView();
	
	/**
	 * 进入维护酒店基本信息界面
	 */
	public void toUpdateHotelInfoView();
	
	/**
	 * 进入管理房间界面
	 */
	public void toAdminRoomView();
	
	/**
	 * 进入浏览订单界面
	 */
	public void toProcessOrderOrderView();
	
	/**
	 * 进入制定酒店营销策略界面
	 */
	public void toMakeHotelPromotionView();
	
	
}
