package orderBLImpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import PO.OrderPO;
import dataService.DataFactoryService;
import dataService.OrderDataService;
import rmi.RemoteHelper;
/**
 * 订单状态信息的处理
 * @author Administrator
 *
 */
public class Orderstate {
	private DataFactoryService DataFactory;
    private OrderDataService orderData;
    private OrderPO order;
    private OrderStateInfo state;
    public Orderstate(String orderID) {
 	 try {   
 		 DataFactory=RemoteHelper.getInstance().getDataFactoryService();   
 	     orderData= (OrderDataService) DataFactory.getDataService("Order");  
		 order=orderData.find(orderID);
 	     state=new OrderStateInfo(order);
 	   } catch (RemoteException e) {
		e.printStackTrace();
	}
    }
	/**
     * 客户撤销订单(将订单状态改为已撤销，增加信用值请使用updateCredit方法)
     * 
     * @return boolean 如果需要扣除信用值则返回true，否则返回false
	 * @ 
     */
	public boolean cancel() {
		try {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		state.orderState=4;
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(state.latest.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.HOUR, -6);
		Calendar rightnow=Calendar.getInstance();		
		state.cancel=Calendar.getInstance();
		state.generationTime=Calendar.getInstance();
		state.Update();		
		orderData.update(state.po);		
		if(cal.compareTo(rightnow)==-1){
			return true;
		}
		else{
			return false;
		}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
     * 处理未执行订单(将订单状态改为已执行，增加信用值请使用updateCredit方法)
     * 
     * @return boolean值,处理成功返回true，否则返回false
	 * @ 
     * @see bussinesslogic.Order
     */
	public boolean processUnfinishedOrder()  {
		try {
		state.orderState=1;
		state.generationTime=Calendar.getInstance();
		state.Update();
	    orderData.update(state.po);
		return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	/**
     * 酒店人员处理异常订单，延迟入住(将订单状态改为未 执行，增加信用值请使用updateCredit方法)
     * 
     * @param String delayTime,延时入住的时间
     * @return boolean值,处理成功返回true，否则返回false
	 * @ 
     * @see bussinesslogic.Order
     */
	public boolean processAbnormalOrder(Calendar delayTime)  {
		try {
		state.orderState=2;
		state.latest=delayTime;
		state.generationTime=Calendar.getInstance();
		state.Update();
		orderData.update(state.po);
		return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
     * 网站营销人员撤销异常订单(将订单状态改为已撤销，增加信用值请使用updateCredit方法)
     * 
	 * @ 
     * @see bussinesslogic.Order
     */
	public void cancelAbnormalOrder()  {
		state.orderState=4;
		state.cancel=Calendar.getInstance();
		state.Update();
		try {
			orderData.update(state.po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
