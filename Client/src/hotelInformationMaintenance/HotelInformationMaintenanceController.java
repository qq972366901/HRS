package hotelInformationMaintenance;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.Hotel;
import VO.HotelVO;
import VO.OrderVO;
import common.MessageInput;
import common.ResultMessage;
import common.UserType;
import hotelBLService.HotelBLService_realize;
public class HotelInformationMaintenanceController  extends HotelBLService_realize{
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
