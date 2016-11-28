package uiController;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.ProcessOrderView;
import VO.OrderVO;
import WebPromotionView.WebPromotionUserView;
import common.UserType;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.ProcessOrderUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;

public class ProcessOrderUiController implements ProcessOrderUiService{
	private String hotelId;
	
	private OrderBLService orderService;
	
	private UserBLService userService;
	
	private ProcessOrderView view;
	
	private UserType usertype;
	public ProcessOrderUiController(String hotelId,UserType type) throws RemoteException{ 
		this.hotelId = hotelId;
		this.usertype=type;
		orderService = new OrderBLServiceController();
		userService = new UserBLServiceController();
	}

	@Override
	public String getHotelId() {
		return hotelId;
	}

	@Override
	public void setView(ProcessOrderView view) {
		this.view = view;
	}

	@Override
	public List<OrderVO> getAllOrders(String hotelId) {
		//return orderService.show(hotelId);
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}

	@Override
	public List<OrderVO> getUnfinishedOrders(String hotelId) {
		return orderService.getUnfinishedOrders(hotelId);
	}

	@Override
	public List<OrderVO> getFinishedOrders(String hotelId) {
		return orderService.getFinishedOrders(hotelId);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelId) {
		return orderService.getAbnormalOrders(hotelId);
	}

	@Override
	public boolean processUnfinishedOrder(int orderId) {
		return false;
	}

	@Override
	public boolean processAbnormalOrder(int orderId, String delayTime) {
		return false;
	}

	@Override
	public void updateListModel(String comboboxValue) {
		view.updateListModel(comboboxValue);
	}

	@Override
	public void processOrderButtonClicked() {
		view.processOrderButtonClicked();
	}

	@Override
	public void delayOrderButtonClicked() {
		view.delayOrderButtonClicked();
	}
	@Override
	public void back() {
		switch(usertype){
			case Customer:{
				break;
			}
			case Hotelworker:{
				HotelMainUiService controller=new HotelMainUiController(hotelId);
	    		HotelMainView view=new HotelMainView(controller,hotelId);
	    		controller.setView(view);
				ClientRunner.change(view);
				break;
			}
			case WebPromotionWorker:{
				webPromotionUserUiService controller=new webPromotionUserUiController();
				WebPromotionUserView view=new WebPromotionUserView(controller);
				controller.setView(view);
				ClientRunner.change(view);
				break;
			}
			case WebManagementWorker:{
				break;
			}
		}
	}
	@Override
	public void cancelAbnormalOrder() {
		view.cancelAbnormalOrder();
	}

}
