package uiService;

import UserView.OrderBuildView;
import VO.OrderVO;

public interface OrderBuildUiService {
	public void setView(OrderBuildView view);
	public void toHotelBrowseView(String id);
	public  void saveOrderInfo(OrderVO vo);
	public boolean whetherMake(int numsOfRoom,String RoomType,String hotelID);
}
