package hotelInformationSearch;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.Hotel;
import VO.HotelVO;
import VO.OrderVO;
import common.MessageInput;
import common.ResultMessage;
import common.UserType;
import hotelBLService.HotelBLService_realize;
public class HotelInformationSearchController extends HotelBLService_realize{
	/**
     * 根据地址和商圈获得范围内的酒店信息
     * 
     * @param hvo HotelVO型，界面传递来的hotel值对象
     * @return 返回ResultMessage枚举值中的一项
     * @see bussinesslogic.Hotel
     */
	public ResultMessage messagelook(HotelVO hvo) {
		return ResultMessage.Exist;
	}
	
	
	/**
     * 根据输入的条件返回符合的酒店列表
     * 
     * @param in MessageInput型，界面输入的条件
     * @return 返回HotelVO的一个列表
     * @see bussinesslogic.Hotel 
     */
	public ArrayList<HotelVO> messagesearch(MessageInput in) {
		ArrayList<HotelVO> array=new ArrayList<HotelVO>();
		return array;
	}
	
}
