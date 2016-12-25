package uiService;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import UserView.OrderBuildView;
import VO.HotelVO;
import VO.OrderVO;

public interface OrderBuildUiService {
	public void setView(OrderBuildView view);
	public void toHotelBrowseView(String id1,String id2,int from) throws RemoteException;
	public  void saveOrderInfo(OrderVO vo);
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID);
	public String getUserID();
	public String getHotelID();
	public void updateRoomState(String hotelID, String roomType,int roomNumber);
	public List<String> getRoomType(String hotelid);
	public int getMaxRoomNumber(String hotelid, String roomType);
	public int getOrderPrice(String hotelid, String roomType, int roomNumber);
	public double getWebPromotionDiscount(String userID,String city,String bussinesscircle,Calendar orderbuildtime) throws RemoteException;
	public double getHotelPromotionDiscount(String hotelid,String userID,int roomNumber,Calendar orderbuildtime,Calendar begintime,Calendar endtime) throws RemoteException;
	public HotelVO findByHotelID(String hotelID);
	public long showCredit(String userID);
	public int getfrom();
}
