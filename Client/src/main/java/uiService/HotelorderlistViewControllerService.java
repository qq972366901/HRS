package uiService;

import java.util.List;

import UserView.HotelorderlistView;
import VO.OrderVO;

public interface HotelorderlistViewControllerService {
        public void setView(HotelorderlistView view);
        public void exit();
        public List<OrderVO> getOrderList();
        public String getUserID();
}
