package uiController;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 * 浏览订单界面的控制器
 * @author 刘宗侃
 *
 */
public class ProcessOrderUiController implements ProcessOrderUiService{
	private String hotelId;
	
	private OrderBLService orderService;
	
	private ProcessOrderView view;
	private UserBLService user;
	
	private UserType usertype;
	
	private String key;
	/**
	 * 浏览订单界面的控制器构造方法
	 * @param hotelId
	 * @param type
	 * @throws RemoteException
	 */
	public ProcessOrderUiController(String hotelId,UserType type) throws RemoteException{
		Log log=new Log();
		key=log.getSKey(hotelId);
		this.hotelId =hotelId;
		this.usertype=type;
		user= new UserBLServiceController();
		orderService = new OrderBLServiceController();
		new UserBLServiceController();
	}

	/**
	 * 得到酒店帐号的方法
	 */
	public String getHotelId() {
		return hotelId;
	}

	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(ProcessOrderView view) {
		this.view = view;
	}

	/**
	 * 得到所有订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getAllOrders(String hotelId) {
		return translate(orderService.getAllOrders(hotelId));
	}

	/**
	 * 得到所有未执行订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getUnfinishedOrders(String hotelId) {
		return translate(orderService.getUnfinishedOrders(hotelId));
	}

	/**
	 * 得到已执行订单
	 * 
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getFinishedOrders(String hotelId) {
		return translate(orderService.getFinishedOrders(hotelId));
	}

	/**
	 * 得到异常订单
	 * @param hotelId
	 * @return
	 */
	public List<OrderVO> getAbnormalOrders(String hotelId) {
		return translate(orderService.getAbnormalOrders(hotelId));
	}

	/**
	 * 处理未执行订单
	 * @param orderId
	 * @return
	 */
	public boolean processUnfinishedOrder(String orderId) {
		OrderVO vo=orderService.showDetail(orderId);
		orderService.updateCredit(vo.userID, orderId, vo.orderValue, Operate.Done);
		return orderService.processUnfinishedOrder(orderId);
	}

	/**
	 * 处理异常订单
	 * @param orderId
	 * @param delayTime
	 * @return
	 */
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

	/**
	 * 更新所选列表
	 * @param comboboxValue
	 */
	public void updateListModel(String comboboxValue) {
		view.updateListModel(comboboxValue);
	}

	/**
	 * 订单状态置为已执行
	 */
	public void processOrderButtonClicked() {
		view.processOrderButtonClicked();
	}

	/**
	 * 延时订单执行时间
	 */
	public void delayOrderButtonClicked() {
		view.delayOrderButtonClicked();
	}
	/**
	 * 返回上一界面
	 */
	public void back() {
		switch(usertype){
			case Customer:{
				break;
			}
			case HotelWorker:{
				HotelMainUiService controller=new HotelMainUiController(DES.decryptDES(hotelId, key));
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
	/**
	 * 撤销异常订单
	 */
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
		currentcredit = user.showCredit(userID);
		if(strategy.equals("全部")){
			currentcredit+=value;
		}
		else{
			value/=value;
			currentcredit+=value;
		}
		CreditRecordVO vo=new CreditRecordVO(null,userID,calendar,orderNo,appeal,value,currentcredit);
		user.updateCreditRecord(vo);
	}
	/**
	 * 获取一个酒店所有已撤销订单
	 */
	public List<OrderVO> getCanceledOrders(String hotelId) {
		return translate(orderService.getCanceledOrders(hotelId));
	}
	/**
	 * 根据订单编号获取用户账号
	 */
	public String getUserID(String orderNo) {
		return orderService.getUserID(orderNo);
	}

	/**
	 * 处理用户的异常订单
	 * @param userID
	 */
	public void dealwithAbnormalOrder(String orderNo) {
		orderService.cancelAbnormalOrder(orderNo);
	}
    private List<OrderVO> translate(List<OrderVO> list){
		for(OrderVO vo:list){
			vo.addorderNumber();
			vo.adddetail();
			String skey="";
			try {
				Log log=new Log();
				skey = log.getSKey(vo.userID);
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

    /**
	 * 得到使用的用户类型
	 * @return
	 */
	public UserType getUserType() {
		return usertype;
	}
}
