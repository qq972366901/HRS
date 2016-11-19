package hotelEverordered;
import java.util.ArrayList;

import VO.HotelVO;
import hotelBLService.HotelBLService_realize;
public class HotelEverorderedController extends HotelBLService_realize{
	/**
     * 查找用户的历史订单的酒店并返回历史酒店列表
     * 
     * @param id String型，客户id
     * @return 返回HotelVO的一个列表
     * @see bussinesslogic.Hotel
     */
	public  ArrayList<HotelVO> historylook(String  id) {
	    ArrayList<HotelVO> array=new  ArrayList<HotelVO>();
		return array;
	}
	/**
     * 显示客户的历史预订酒店
     * 
     * @return 一个ArrayList<HotelVO>，酒店值对象列表
     * @see bussinesslogic.Hotel
     */
	public ArrayList<HotelVO> gethistoryhotel() {
		ArrayList<HotelVO> array=new  ArrayList<HotelVO>();
		return array;
	}
}

