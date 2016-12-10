package uiService;

import java.rmi.RemoteException;
import java.util.List;

import UserView.HotelBrowseView;
import VO.HotelPromotionVO;
import VO.HotelVO;
import VO.OrderVO;

public interface HotelBrowseUiService {
	public void setView(HotelBrowseView view);
	public void toHotelSearchView(String id) throws RemoteException;
	public void toOrderBuildView(String userid,String hotelid) throws RemoteException;
	public HotelVO findByHotelID(String hotelID);
	public List<OrderVO> findByHotelIDAndUserID(String userID,String hotelID);
	public String getUserID();
	public String getHotelID();
	public List<String> getRoomType(String hotelid);
	public HotelPromotionVO getHotelPromotionByHotelID(String hotelid);
	public long getRoomPrice(String hotelid,String roomType);
	public List<OrderVO> getFinishedOrders(String hotelId) ;
}
