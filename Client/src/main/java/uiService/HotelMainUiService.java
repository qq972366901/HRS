package uiService;

import HotelWorkerView.HotelMainView;

/**
 * 负责实现酒店管理系统的酒店工作人员的初始界面
 * @author 刘宗侃
 */
public interface HotelMainUiService {

	public void setView(HotelMainView view);
	public void toLogView();//返回登录界面
	public void toUpdateHotelInfoView();
	public void toAdminRoomView();
	public void toProcessOrderOrderView();
	public void toMakeHotelPromotionView();
	
	
}
