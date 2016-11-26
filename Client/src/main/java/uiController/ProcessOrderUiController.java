package uiController;

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
import userBLService.UserBLService_realize;

public class ProcessOrderUiController implements ProcessOrderUiService{
	private int hotelId;
	
	private OrderBLService orderService;
	
	private UserBLService userService;
	
	private ProcessOrderView view;
	
	private UserType usertype;
	public ProcessOrderUiController(int hotelId,UserType type){ 
		this.hotelId = hotelId;
		this.usertype=type;
		orderService = new OrderBLServiceController();
		userService = new UserBLService_realize();
	}
	@Override
	public int getHotelId() {
		// TODO Auto-generated method stub
		return hotelId;
	}

	@Override
	public void setView(ProcessOrderView view) {
		// TODO Auto-generated method stub
		this.view = view;
	}

	@Override
	public List<OrderVO> getAllOrders(String hotelId) {
		// TODO Auto-generated method stub
		//return orderService.show(hotelId);
		List<OrderVO> list=new ArrayList<OrderVO>();
		return list;
	}

	@Override
	public List<OrderVO> getUnfinishedOrders(String hotelId) {
		// TODO Auto-generated method stub
		return orderService.getUnfinishedOrders(hotelId);
	}

	@Override
	public List<OrderVO> getFinishedOrders(String hotelId) {
		// TODO Auto-generated method stub
		return orderService.getFinishedOrders(hotelId);
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelId) {
		// TODO Auto-generated method stub
		return orderService.getAbnormalOrders(hotelId);
	}

	@Override
	public boolean processUnfinishedOrder(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean processAbnormalOrder(int orderId, String delayTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateListModel(String comboboxValue) {
		// TODO Auto-generated method stub
		view.updateListModel(comboboxValue);
	}

	@Override
	public void processOrderButtonClicked() {
		// TODO Auto-generated method stub
		view.processOrderButtonClicked();
	}

	@Override
	public void delayOrderButtonClicked() {
		// TODO Auto-generated method stub
		view.delayOrderButtonClicked();
	}
	@Override
	public void back() {
		// TODO Auto-generated method stub
		switch(usertype){
			case Customer:{
				break;
			}
			case Hotelworker:{
				HotelMainUiService controller=new HotelMainUiController();
	    		HotelMainView view=new HotelMainView(controller);
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
		// TODO Auto-generated method stub
		view.cancelAbnormalOrder();
	}

}
