package uiService;

import java.util.Vector;

import UserView.OrderView;
import VO.OrderVO;

public interface OrderViewControllerService {

	public void exit();
    public void setView(OrderView view);
    public void updateList(String type);
    public void comment();
    public void cancel(String orderID);
    public String getUserID();
    public void showDetail(String orderID);
	public Vector<OrderVO> getAllOrder();
}
