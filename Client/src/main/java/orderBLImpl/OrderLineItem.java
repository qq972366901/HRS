package orderBLImpl;

import java.rmi.RemoteException;

import dataService.DataFactoryService;
import dataService.OrderDataService;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.OrderVO;
/**
 * 单件订单数据的梳理
 * @author Administrator
 *
 */
public class OrderLineItem {
	private DataFactoryService DataFactory;
    private OrderDataService orderData;
    public OrderLineItem() {
 	   DataFactory=RemoteHelper.getInstance().getDataFactoryService();
	   try {
		orderData= (OrderDataService) DataFactory.getDataService("Order");
	} catch (RemoteException e) {
		e.printStackTrace();
	}
	   
 	   
    }
   
    /**
     * 显示订单的详细信息
     * 
     * @param String OrderID，订单的id
     * @return OrderVO ,一个订单
     * @ 
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String OrderID) {
		try {
			OrderPO order=orderData.find(OrderID);
			if(order!=null){
				return new OrderVO(order);
			}
			else{
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
     * 保存订单信息
     * 
     * @param OrderVO vo,一个Order的值对象
	 * @ 
     * @see bussinesslogic.Order
     */
	public  void saveOrderInfo(OrderVO vo) {
		try {
			OrderPO order=new OrderPO(vo.userID,vo.hotelID,vo.orderNumber,vo.orderState,vo.orderValue,vo.numOfPerson,vo.child,vo.roomType,vo.roomNumber,vo.expectedCheckIn
					,vo.expectedCheckOut,vo.latest,vo.cancel,vo.generationTime,vo.comment,vo.score);
			orderData.insert(order);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据订单编号返回相应的客户账号
	 * @param OrderID String，订单编号
	 * @return String 客户账号
	 */
	public String getUserID(String OrderID){
		try {
			return orderData.find(OrderID).getUserID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
