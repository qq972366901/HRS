package uiService;

import java.util.List;

import HotelWorkerView.ProcessOrderView;
import VO.OrderVO;
import common.UserType;

public interface ProcessOrderUiService {
	public String getHotelId();
	
	public void setView(ProcessOrderView view);
	
	public List<OrderVO> getAllOrders(String hotelId);
	
	public List<OrderVO> getUnfinishedOrders(String hotelId);
	
	public List<OrderVO> getFinishedOrders(String hotelId);
	
	public List<OrderVO> getAbnormalOrders(String hotelId);
	
	public boolean processUnfinishedOrder(int orderId);
	
	public boolean processAbnormalOrder(int orderId,String delayTime);
	
	public void updateListModel(String comboboxValue);
	
	public void processOrderButtonClicked();
	
	public void delayOrderButtonClicked();

	public void back();

	public void cancelAbnormalOrder();

	public void searchOrderByID();

	public OrderVO getOrderByID(String orderID);
}
