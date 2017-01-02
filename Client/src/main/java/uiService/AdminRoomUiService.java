package uiService;

import hotelWorkerView.AdminRoomView;

/**
 * 管理客房界面的服务
 * @author 刘宗侃
 *
 */
public interface AdminRoomUiService {

	/**
	 * 设置界面
	 */
	public void setView(AdminRoomView view);
	
	/**
	 * 跳转至酒店工作人员主界面的方法
	 */
	public void toHotelMainView();
	
	/**
	 * 跳转至添加房间的界面
	 */
	public void toInputRoomInfoView();
	
	/**
	 * 跳转至更新房间状态的类
	 */
	public void toUpdateRoomInfoView();
	
}
