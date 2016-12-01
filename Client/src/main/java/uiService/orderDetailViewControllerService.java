package uiService;

import java.util.List;

import UserView.orderDetailView;

public interface orderDetailViewControllerService {
	 public void setView(orderDetailView view);
     public void exit();
     public String getUserID();
     public List<String> getDetail();
     public String getHotelID();
     public String getOrderID();
}
