package hotelInformationMaintenance;

import HotelBLServiceImpl.HotelInfo;
import common.MessageInput;
import common.ResultMessage;
import hotelBLService.HotelBLServiceController;
public class HotelInformationMaintenanceController  extends HotelBLServiceController{
	
	/**
     * 更新酒店的基本信息
     * 
     * @param id String型，酒店帐号
     * @param hotelName String型，酒店名称
     * @param hotelLocation String型，酒店地址
     * @param hotelService String型，酒店设施服务
     * @param hotelCity String型，酒店城市
     * @param hotelArea String型，酒店商圈
     * @param hotelIntroduction String型，酒店简介
     * @param hotelStar int型，酒店星级
     * @param hotelPhone String型，酒店联系电话
     */
	public void updateHotelInfo(String id,String hotelName, String hotelLocation, String hotelService, String hotelCity,
			String hotelArea, String hotelIntroduce, int hotelStar, String hotelPhone){
		HotelInfo hotelInfo = HotelInfo.getHotelInfoInstance(id);
		hotelInfo.updateHotelInfo(hotelName, hotelLocation, hotelService, hotelCity, hotelArea, hotelIntroduce, hotelStar,hotelPhone);
	}
	
	
	
	
	
	
	//-----------------------------------------------------
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
	
	
	/**
     * 增加酒店账号名称并且创建一个该酒店工作人员的账号
     * 
     * @param in MessageInput型，界面输入的酒店相关信息
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage accuntadmin(MessageInput  in) {
		return ResultMessage.Exist;
	}
}
