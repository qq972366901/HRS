package uiService;

import java.util.List;

import UserView.HotelBrowseView;
import VO.HotelVO;
import VO.OrderVO;

public interface HotelBrowseUiService {
	public void setView(HotelBrowseView view);
	public void toHotelSearchView(String id);
	public void toOrderBuildView(String id);
	public HotelVO findByHotelID(String hotelID);
	public List<OrderVO> findByHotelID (String userID,String hotelID);
	public boolean getroominfo(HotelVO vo);
}
