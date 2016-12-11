package uiController;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import userBLServiceImpl.DES;
import userBLServiceImpl.Log;

public class ProcessOrderUiController implements ProcessOrderUiService{
	private String hotelId;
	
	private OrderBLService orderService;
	
	private ProcessOrderView view;
	private UserBLService user;
	
	private UserType usertype;
	public ProcessOrderUiController(String hotelId,UserType type) throws RemoteException{
		String key=Log.getLogInstance().getSKey(hotelId);
		this.hotelId =hotelId;
		this.usertype=type;
		user= new UserBLServiceController();
		orderService = new OrderBLServiceController();
		new UserBLServiceController();
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
		return translate(orderService.getAllOrders(hotelId));
	}

	@Override
	public List<OrderVO> getUnfinishedOrders(String hotelId) {
		return translate(orderService.getUnfinishedOrders(hotelId));
	}

	@Override
	public List<OrderVO> getFinishedOrders(String hotelId) {
		return translate(orderService.getFinishedOrders(hotelId));
	}

	@Override
	public List<OrderVO> getAbnormalOrders(String hotelId) {
		return translate(orderService.getAbnormalOrders(hotelId));
	}

	@Override
	public boolean processUnfinishedOrder(String orderId) {
		OrderVO vo=orderService.showDetail(orderId);
		orderService.updateCredit(vo.userID, orderId, vo.orderValue, Operate.Done);
		return orderService.processUnfinishedOrder(orderId);
	}

	@Override
	public boolean processAbnormalOrder(String orderId, String delayTime) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date;
		Calendar calendar= Calendar.getInstance();
		try {
			date = sdf.parse(delayTime);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		OrderVO vo=orderService.showDetail(orderId);
		orderService.updateCredit(vo.userID, orderId, vo.orderValue, Operate.Delayed);
		return orderService.processAbnormalOrder(orderId, calendar);
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
			value/=value;
			currentcredit+=value;
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
		return translate(orderService.getCanceledOrders(hotelId));
	}
	/**
	 * 根据订单编号获取用户账号
	 */
	@Override
	public String getUserID(String orderNo) {
		return orderService.getUserID(orderNo);
	}

	@Override
	public void dealwithAbnormalOrder(String orderNo) {
		orderService.cancelAbnormalOrder(orderNo);
	}
    private List<OrderVO> translate(List<OrderVO> list){
		for(OrderVO vo:list){
			vo.addorderNumber();
			vo.adddetail();
			String skey="";
			try {
				skey = Log.getLogInstance().getSKey(vo.userID);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.addUserInfo(DES.decryptDES(user.findByID(vo.userID).username, skey));
			vo.addexpectedCheckIn();
			vo.addlatest();
			vo.addorderState();
			vo.addorderValue();
		}
    	return list;
    }

	@Override
	public UserType getUserType() {
		return usertype;
	}
}
