package uiService;

import UserView.HotelDetailView;
import VO.HotelVO;

public interface HotelDetailUiService {
      public void setView(HotelDetailView view);
      public HotelVO findByhotelID(String hotelID);
      public String getHotelID();
      public String getUserID();
      public void intoOrderList();
      public void exit();
}
