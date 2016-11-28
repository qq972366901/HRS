package orderBLImpl;

import java.rmi.RemoteException;
import PO.CreditPO;
import PO.OrderPO;
import PO.UserPO;
import VO.OrderVO;
import dataService.CreditDataService;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import dataService.OrderDataService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 单件订单数据的梳理
 * @author Administrator
 *
 */
public class OrderLineItem {
	private DataFactoryService DataFactory;
    private OrderDataService orderData;
    private HotelDataService hotelData;
    private UserDataService userData;
    private CreditDataService creditData;
    public OrderLineItem() {
 	   DataFactory=RemoteHelper.getInstance().getDataFactoryService();
	   //try {
		//orderData= (OrderDataService) DataFactory.getDataService("Order");
		//userData= (UserDataService) DataFactory.getDataService("User");
		//creditData=(CreditDataService) DataFactory.getDataService("Credit");
	//} catch (RemoteException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	   
 	   
    }
   
    /**
     * 显示订单的详细信息
     * 
     * @param String UserID，客户的id
     * @param String OrderID，订单的id
     * @return OrderVO ,一个订单
     * @ 
     * @see bussinesslogic.Order
     */
	public OrderVO showDetail(String userID,String OrderID) {
		try {
			OrderPO order=orderData.find(OrderID);
			UserPO user = userData.find(userID);
			CreditPO credit=creditData.find(userID);
			return new OrderVO(credit,user,order);		
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
			OrderPO order=new OrderPO(vo.numberOfroom,vo.userID,vo.hotelID,vo.orderNumber,vo.orderState,vo.orderValue,vo.numOfPerson,vo.child,vo.roomType,vo.roomNumber,vo.expectedCheckIn
					,vo.expectedCheckOut,vo.latest,vo.cancel,vo.generationTime,vo.comment,vo.score);
			orderData.update(order);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
