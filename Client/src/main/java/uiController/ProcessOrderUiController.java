package uiController;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import HotelWorkerView.HotelMainView;
import HotelWorkerView.ProcessOrderView;
import VO.CreditRecordVO;
import VO.OrderVO;
import WebPromotionView.WebPromotionUserView;
import common.Operate;
import common.UserType;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import runner.ClientRunner;
import uiService.HotelMainUiService;
import uiService.ProcessOrderUiService;
import uiService.webPromotionUserUiService;
import userBLService.UserBLService;
import userBLService.UserBLServiceController;
import userBLServiceImpl.Credit;

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
		return orderService.getAllOrders(hotelId);
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
			case HotelWorker:{
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
	/**
	 * 恢复客户信用值
	 * @throws RemoteException 
	 */
	@Override
	public void recover(Calendar calendar, String orderNo, Operate appeal, String strategy, int value, String userID) {
		long currentcredit=0;
		try {
			currentcredit = Credit.getInstance().showCredit(userID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(strategy.equals("全部")){
			currentcredit+=value;
		}
		else{
			currentcredit+=(value/2);
		}
		CreditRecordVO vo=new CreditRecordVO(userID,calendar,orderNo,appeal,value,currentcredit);
		try {
			Credit.getInstance().updateCredit(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取一个酒店所有已撤销订单
	 */
	@Override
	public List<OrderVO> getCanceledOrders(String hotelId) {
		return orderService.getCanceledOrders(hotelId);
	}
	/**
	 * 根据订单编号获取用户账号
	 */
	@Override
	public String getUserID(String orderNo) {
		return orderService.getUserID(orderNo);
	}

}
