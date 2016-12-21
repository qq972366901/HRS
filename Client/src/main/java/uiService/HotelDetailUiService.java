package uiService;

import java.util.List;

import UserView.HotelDetailView;
import VO.HotelVO;
import VO.OrderVO;

public interface HotelDetailUiService {
      public void setView(HotelDetailView view);
      public HotelVO findByhotelID(String hotelID);
      public String getHotelID();
      public String getUserID();
      public void exit();
      public List<OrderVO> getOrderList();
}
