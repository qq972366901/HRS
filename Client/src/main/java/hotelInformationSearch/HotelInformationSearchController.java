package hotelInformationSearch;
import java.util.ArrayList;
import java.util.List;

import HotelBLServiceImpl.HotelSearch;
import VO.HotelVO;
import common.MessageInput;
import common.ResultMessage;
import hotelBLService.HotelBLServiceController;
public class HotelInformationSearchController extends HotelBLServiceController{
	
	/**
     * 查找符合客户选择条件的酒店列表
     * 
     * @param city String型，酒店城市，若未选择，值为null
     * @param businessCircle String型，商圈，若未选择，值为null
     * @param roomType String型，房型，若未选择，值为null
     * @param roomNumber int型，房间数量，若未选择，值为-1
     * @param priceLow int型，房间最低价格，若未选择，值为-1
     * @param priceHigh int型，房间最高价格，若未选择，值为-1
     * @param hotelStar int型，酒店星级，若未选择，值为-1
     * @param scoreLow int型，搜索选择的最低评分，若未选择，值为-1
     * @param scoreHigh int型，搜索选择的最高评分，若未选择，值为-1
     * @param everBooked String型，选择搜索的范围：全部，预定过，未预定过，若未选择，值为null
     * @param userid String型，客户的id
     * 
     * @return 返回符合条件的酒店ID列表
     */
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid) {
		HotelSearch hotelSearch = HotelSearch.getHotelSearchInstance();
		return hotelSearch.getHotelIDList(city, businessCircle, roomType, roomNumber, priceLow, priceHigh, hotelStar, scoreLow, scoreHigh, everBooked,userid);
	}
	
	
	
	
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
