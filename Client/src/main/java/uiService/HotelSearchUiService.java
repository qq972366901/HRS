package uiService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import UserView.HotelSearchView;
import VO.HotelPromotionVO;
import VO.HotelVO;
import VO.OrderVO;

public interface HotelSearchUiService {
	public String getUserID();
	public void setView(HotelSearchView view);
	public void toUserView(String id);
	public void toHotelBrowseView(String userid,String hotelid) throws RemoteException;
	public void toOrderBuildView(String userid,String hotelid) throws RemoteException;
	public List<String> getCity();
	public Vector<String> getCircle(String city);
	public List<String> getHotelID(String city, String businessCircle, String roomType, int roomNumber,
			int priceLow, int priceHigh, int hotelStar, int scoreLow, int scoreHigh, String everBooked,String userid);
	public HotelVO findByHotelID(String hotelID);
	public int getRoomLowestPrice(String hotelID);
	public HotelPromotionVO getHotelPromotionByHotelID(String hotelid);
	public List<OrderVO> findByHotelIDAndUserID (String userid,String hotelid);
}
