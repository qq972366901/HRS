package uiService;

import HotelWorkerView.InputRoomInfoView;

/**
 * 负责实现录入客房界面的服务
 * @author 刘宗侃
 */
public interface InputRoomInfoUiService {

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(InputRoomInfoView view);
	
	/**
	 * 返回管理客房界面
	 */
	public void toAdminRoomView();
	
	/**
	 * 系统更新酒店拥有的房间信息
	 * @param roomType String型，房型
	 * @param roomNumber int型，房间数量
	 * @param roomPrice int型，房间原始价格
	 * @param roomNNN String型，房间号
	 */
	public void inputRoomInfo(String roomType, int roomNumber, int roomPrice, String roomNNN);
	
}
