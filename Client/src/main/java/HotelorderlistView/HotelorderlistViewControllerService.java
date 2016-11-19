package HotelorderlistView;

import java.util.List;

import VO.OrderVO;

public interface HotelorderlistViewControllerService {
        public void setView(HotelorderlistView view);
        public void exit();
        public List<OrderVO> getOrderList();
        public String getUserID();
}
