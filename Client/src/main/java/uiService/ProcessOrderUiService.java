package uiService;

import java.util.List;

import HotelWorkerView.ProcessOrderView;
import VO.OrderVO;
import common.UserType;

public interface ProcessOrderUiService {
	public int getHotelId();
	
	public void setView(ProcessOrderView view);
	
	public List<OrderVO> getAllOrders(int hotelId);
	
	public List<OrderVO> getUnfinishedOrders(int hotelId);
	
	public List<OrderVO> getFinishedOrders(int hotelId);
	
	public List<OrderVO> getAbnormalOrders(int hotelId);
	
	public boolean processUnfinishedOrder(int orderId);
	
	public boolean processAbnormalOrder(int orderId,String delayTime);
	
	public void updateListModel(String comboboxValue);
	
	public void processOrderButtonClicked();
	
	public void delayOrderButtonClicked();

	public void back();

	public void cancelAbnormalOrder();
}
