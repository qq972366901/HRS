package hotelManagement;

import common.MessageInput;
import common.ResultMessage;

public class HotelManagementController{
	/**
     * 维护酒店的基本信息，更新酒店数据
     * 
     * @param in MessageInput型，界面输入的修改信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage messagemaintain(MessageInput  in) {
		return ResultMessage.Exist;
	}
}
