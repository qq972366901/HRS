package orderBLImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.CreditPO;
import PO.OrderPO;
import VO.OrderVO;
import dataService.CreditDataService;
import dataService.DataFactoryService;
import dataService.OrderDataService;
import rmi.RemoteHelper;
/**
 * 订单列表信息的处理
 * @author Administrator
 *
 */
public class OrderList {
       private DataFactoryService DataFactory;
       private CreditDataService creditData;
       private OrderDataService orderData;
       public OrderList() throws RemoteException {   	   
            DataFactory=RemoteHelper.getInstance().getDataFactoryService();
			orderData= (OrderDataService) DataFactory.getDataService("Order");
			System.out.println("Order run");
			creditData=(CreditDataService) DataFactory.getDataService("Credit");
       }
       
       /**
        * 内部方法，针对不同类型的需求，返回客户不同类型的订单列表
        * 
        * @param String type;订单类型
        * @param String UserID，客户的id
        * @return List<OrderVO> ，订单的一个列表
        * @see bussinesslogic.Order
        */
   	private List<OrderVO>  showTypeorderList(String userID,String Type) {
   		try {
   			List<OrderPO> polist=new ArrayList<OrderPO>();
   		    List<OrderVO> volist=new ArrayList<OrderVO>();
   		switch(Type){
   		case "ALL":polist=orderData.findByUserID(userID, 0);
   		           System.out.println(polist.size());
   				   break;
   		case "UnDone":polist=orderData.findByUserID(userID, 2);
		           break;
   		case "Done":polist=orderData.findByUserID(userID, 1);
		            break;
   		case "Cancel":polist=orderData.findByUserID(userID, 4);
		            break;
   		case "Abnormal":polist=orderData.findByUserID(userID, 3);
		            break;
   		}
		CreditPO credit=creditData.find(userID);
   		for(OrderPO order:polist){
   			volist.add(new OrderVO(credit,order));
   		}
		return volist;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
   	}
       
       /**
        * 内部方法，针对不同类型的需求，返回酒店不同类型的订单列表
        * 
        * @param String type;订单类型
        * @param String hotelID，酒店的id
        * @return List<OrderVO> ，订单的一个列表
        * @see bussinesslogic.Order
        */
   	private List<OrderVO>  showTypeHotelOrderList(String hotelID,String Type) {
   		try {
   		List<OrderPO> polist=new ArrayList<OrderPO>();
   		List<OrderVO> volist=new ArrayList<OrderVO>();
   		switch(Type){
   		case "ALL":polist=orderData.findByHotelID(hotelID, 0);
   				   break;
   		case "Unfinished":polist=orderData.findByHotelID(hotelID, 2);
		           break;
   		case "Finished":polist=orderData.findByHotelID(hotelID, 1);
		   break;
   		case "Abnormal":polist=orderData.findByHotelID(hotelID, 3);
		   break;
   		}
   		for(OrderPO order:polist){
   			volist.add(new OrderVO(order));
   		}
		return volist;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
   	}
   	
   	/**
     * 获得一个客户的所有未执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAllorder(String userid) {
		System.out.println("ShowAll" + "id:" +userid);
		return showTypeorderList(userid,"ALL");
	}
   	
	/**
     * 获得一个客户的所有未执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showUndoneorder(String userid) {
		return showTypeorderList(userid,"UnDone");
	}
	
	/**
     * 获得一个客户的所有已执行订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showDoneorder(String userid) {
		return showTypeorderList(userid,"Done");
	}
	
	
	/**
     * 获得一个客户的所有异常订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showAbnormalorder(String userid) {
		return showTypeorderList(userid,"Abnormal");
	}
	
	
	/**
     * 获得一个客户的所有撤销订单
     * 
     * @param String UserID，客户的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO>  showCancelorder(String userid) {
		return showTypeorderList(userid,"Cancel");
	}
	
	/**
     * 获得一个酒店的所有订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAllOrders(String hotelId) {
		return showTypeHotelOrderList(hotelId,"ALL");
	}
	/**
     * 获得一个酒店的所有未执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getUnfinishedOrders(String hotelId)  {
		return showTypeHotelOrderList(hotelId,"Unfinished");
	}
	
	
	
	/**
     * 获得一个酒店的所有已执行订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getFinishedOrders(String hotelId)  {
		return showTypeHotelOrderList(hotelId,"Finished");
	}
	
	
	/**
     * 获得一个酒店的所有异常订单
     * 
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，订单的一个列表
	 * @ 
     * @see bussinesslogic.Order
     */
	public List<OrderVO> getAbnormalOrders(String hotelId)  {
		return showTypeHotelOrderList(hotelId,"Abnormal");
	}
	
	/**
     * 根据用户id和酒店id查找该用户在该酒店的所有订单
     * 
     * @param String UserID，客户的id
     * @param String HotelID，酒店的id
     * @return List<OrderVO> ，客户的订单列表
     * @see bussinesslogic.Order
     */
	public List<OrderVO> findByHotelID (String userID,String hotelID) {
		try {
	    List<OrderPO> order=orderData.getUserOrderlistinHotel(userID, hotelID);	
		CreditPO credit=creditData.find(userID);
		List<OrderVO> orderlist=new ArrayList<OrderVO>();
		for(OrderPO a:order){
			orderlist.add(new OrderVO(credit,a));
		}
		return orderlist;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
