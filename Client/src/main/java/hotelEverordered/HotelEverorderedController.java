package hotelEverordered;
import java.rmi.RemoteException;
import java.util.List;

import hotelBLServiceImpl.HotelInfoListByUser;
import orderBLImpl.OrderList;
import vo.HotelVO;
import vo.OrderVO;

/**负责实现查看酒店历史订单的控制器
 * @author 刘宗侃
 */
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
			e.printStackTrace();
			return null;
		}	
	}
}

