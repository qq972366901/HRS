package orderBLImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.HotelPO;
import PO.OrderPO;
import PO.UserPO;
import VO.OrderVO;
import dataService.DataFactoryService;
import dataService.HotelDataService;
import dataService.OrderDataService;
import dataService.UserDataService;
import rmi.RemoteHelper;
/**
 * 订单列表信息的处理
 * @author Administrator
 *
 */
public class OrderList {
       private DataFactoryService DataFactory;
       private RemoteHelper remote;
       private OrderDataService orderData;
       private HotelDataService hotelData;
       private UserDataService userData;
       private String[] type={"ALL","UnDone","Done","Abnormal","Cancel"};
       public OrderList() {
    	   remote=remote.getInstance();
    	   DataFactory=remote.getDataFactoryService();
    	   try {
			orderData= (OrderDataService) DataFactory.getDataService("Order");
			userData= (UserDataService) DataFactory.getDataService("User");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
       
       /**
        * 内部方法，针对不同类型的需求，返回客户不同类型的订单列表
        * 
        * @param String type;订单类型
        * @param String UserID，客户的id
        * @return List<OrderVO> ，订单的一个列表
        * @see bussinesslogic.Order
        */
   	private List<OrderVO>  showTypeorderList(String userid,String Type) {
   		try {
   			List<OrderPO> polist=new ArrayList<OrderPO>();
   		    List<OrderVO> volist=new ArrayList<OrderVO>();
   		/*switch(Type){
   		case "ALL":polist=orderData.findByType("All");
   				   break;
   		case "ALL":polist=orderData.findByType("All");
		           break;
   		case "ALL":polist=orderData.findByType("All");
		   break;
   		case "Cancel":polist=orderData.findByType("All");
		   break;
   		case "Abnormal":polist=orderData.findByType("All");
		   break;
   		}*/
   		
		
   		 UserPO user = userData.find(userid);
		
   		for(OrderPO order:polist){
   			volist.add(new OrderVO(user,order));
   		}
		return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
   		/*switch(Type){
   		case "ALL":polist=orderData.findByType("All");
   				   break;
   		case "Unfinished":polist=orderData.findByType("Unfinished");
		           break;
   		case "Finished":polist=orderData.findByType("Finished");
		   break;
   		case "Abnormal":polist=orderData.findByType("Abnormal");
		   break;
   		}*/
   		
		
   		HotelPO hotel= hotelData.find(hotelID);
		
   		for(OrderPO order:polist){
   			volist.add(new OrderVO(hotel,order));
   		}
		return volist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
		return showTypeorderList(userid,"All");
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
		return showTypeorderList(userid,"Undone");
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
		return showTypeHotelOrderList(hotelId,"All");
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
			//List<OrderPO> order=orderData.findByHotelID(userID,hotelID);
		List<OrderPO> order=new ArrayList<OrderPO>();		
		UserPO	user = userData.find(userID);	
		List<OrderVO> orderlist=new ArrayList<OrderVO>();
		for(OrderPO a:order){
			orderlist.add(new OrderVO(user,a));
		}
		return orderlist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
