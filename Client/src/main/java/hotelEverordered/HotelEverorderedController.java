package hotelEverordered;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import HotelBLServiceImpl.HotelInfoListByUser;
import VO.HotelVO;
import VO.OrderVO;
import orderBLImpl.OrderList;
public class HotelEverorderedController{
	
	/**
     * 查找用户的历史酒店并返回历史酒店列表
     * 
     * @param userID String型，客户id
     * @return 返回酒店的一个列表
     */
	public  List<HotelVO> getHistoryHotel(String  userID) {
		HotelInfoListByUser hotelInfoListByUser = HotelInfoListByUser.getHotelInfoListByUserInstance(userID);
		return hotelInfoListByUser.getHistoryHotel();
	}
	
	
	/**
     * 根据用户id和酒店id查找该用户在该酒店的所有订单
     * 
     * @param String UserID，客户的id
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，客户的订单列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> findByHotelID (String userID,String hotelID){
		OrderList list;
		try {
			list = new OrderList();
			return list.findByHotelID(userID, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
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

