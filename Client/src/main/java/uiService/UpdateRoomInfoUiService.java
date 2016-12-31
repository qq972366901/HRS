package uiService;

import HotelWorkerView.UpdateRoomInfoView;

/**
 * 更新房间信息的界面的服务
 * @author 刘宗侃
 *
 */
public interface UpdateRoomInfoUiService {

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(UpdateRoomInfoView view);
	
	/**
	 * 返回管理客房界面
	 */
	public void toAdminRoomView();

	/**
     * 酒店工作人员更新单个房间的状态
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     * @param roomState String型，房间状态
     */
	public void updateRoomInfo(String hotelID, String roomNumber, String roomState);//系统更新房间入住信息
	
	/**
     * 房间是否存在
     * 
     * @param hotelID String型，酒店帐号
     * @param roomNumber String型，房间号
     */
	public boolean exist(String hotelID, String roomNumber);
	
}
