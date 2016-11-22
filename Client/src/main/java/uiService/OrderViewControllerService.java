package uiService;

import UserView.HistroyHotelView;
import UserView.OrderView;

public interface OrderViewControllerService {

	public void exit();
    public void setView(OrderView view);
    public void updateList(String type);
    public void comment();
    public void cancel(String orderID);
    public String getUserID();
    public void showDetail(String orderID);
}
