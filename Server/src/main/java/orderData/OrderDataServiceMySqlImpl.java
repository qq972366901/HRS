package orderData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import dataHelper.DataHelperFactory;
import dataHelper.OrderDataHelper;
import dataHelperImpl.DataHelperFactoryImpl;
import dataService.OrderDataService;
import po.OrderPO;
/**
 * 职责是将逻辑层面发来的请求转发给后台OrderData处理
 * @author LZ
 * @version 1.0
 * @see businesslogic.Order
 */
public class OrderDataServiceMySqlImpl implements OrderDataService,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static OrderDataServiceMySqlImpl orderDataServiceMySqlImpl;
	private HashMap<String,OrderPO> map;
	private DataHelperFactory datahelper;
	private OrderDataHelper orderdatahelper;
	private OrderDataServiceMySqlImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
		init();
	}
	public static OrderDataServiceMySqlImpl getInstance() throws RemoteException{
		if(orderDataServiceMySqlImpl==null){
			orderDataServiceMySqlImpl=new OrderDataServiceMySqlImpl();
		}
		return orderDataServiceMySqlImpl;
	}
	/**
	 * 按ID进行查找返回相应的OrderPO结果
	 * @param id String型，逻辑层传来的订单编号
	 * @return 返回找到的PO实体
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public OrderPO find(String id) throws RemoteException {
		System.out.println("find");
		if(map.containsKey(id)){
			return map.get(id);
		}
		else{
			return null;
		}
	}
	/**
	 * 在数据库中增加一个po实体
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public void insert(OrderPO po) throws RemoteException {
		map.put(po.getOrderNumber(), po);
		orderdatahelper.insert(po);
	}
	/**
	 * 在数据库中删除一个po
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public void delete(OrderPO po) throws RemoteException {
		map.remove(po.getOrderNumber(), po);
		orderdatahelper.delete(po);
	}
	/**
	 * 在数据库中跟新一个po
	 * @param po OrderPO型，逻辑层传来的PO实体
	 * @return 
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public void update(OrderPO po) throws RemoteException {
		map.put(po.getOrderNumber(), po);
		orderdatahelper.update(po);
	}
	/**
	 * 找到一个客户的所有制定类型的订单（0为全部订单，1为已执行订单，2为未执行订单，3为异常订单，4为撤销订单）
     * @param userID String,客户id
	 * @param orderstate int,订单的状态
	 * @return List<OrderPO> 订单列表
	 */
	@Override
	public List<OrderPO> findByUserID(String userID,int orderstate){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		int state;
		String ID;
		for(Entry<String,OrderPO> entry:map.entrySet()){
			po=entry.getValue();
			ID=po.getUserID();
			state=po.getOrderState();
			if(ID.equals(userID)){
				if(orderstate==0){
					list.add(po);
				}
				else if(state==orderstate){
				    list.add(po);
				}
			}
		}
		return list;
	}
	/**
	 * 找到一家酒店下的所有指定类型的订单（0为全部订单，1为已执行订单，2为未执行订单，3为异常订单，4为撤销订单）
	 * @param hotelID String,酒店id
	 * @param orderstate int,订单的状态
	 * @return List<OrderPO> 订单列表
	 */
	public List<OrderPO> findByHotelID(String hotelID,int orderstate){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		String ID;
		int state;
		for(Entry<String,OrderPO> entry:map.entrySet()){
			po=entry.getValue();
			ID=po.getHotelID();
			state=po.getOrderState();
			if(ID.equals(hotelID)){
				if(orderstate==0){
					list.add(po);
				}
				else if(state==orderstate){
				    list.add(po);
				}
			}
		}
		return list;
	}
	/**
	 * 生成一个随机的订单编号
	 * @return String 订单编号
	 */
	public String generateOrderID(){
		Random random=new Random();
		String ran="";
		boolean flag=true;
		Set<String> set=map.keySet();
		int size=set.size();
		while(flag){
		    ran=String.valueOf(random.nextInt(99999));
		    set.add(ran);
		    if(set.size()!=size){
		    	flag=false;
		    }
		}
		return ran;
	}
	/**
	 * 找到一个客户在一个酒店的历史订单
	 * @param userID String,客户id
	 * @param hotelID String,酒店id
	 * @return List<OrderPO> 一个订单的列表
	 */
	public List<OrderPO> getUserOrderlistinHotel(String userID,String hotelID){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		for(Entry<String,OrderPO> entry:map.entrySet()){
			po=entry.getValue();
			if(po.getUserID().equals(userID)&&po.getHotelID().equals(hotelID)){
				list.add(po);
			}
		}
		return list;
	}
	/**
	 * 按初始化持久化数据库
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public void init() throws RemoteException {
		datahelper=new DataHelperFactoryImpl();
		orderdatahelper=datahelper.getOrderDataHelper();
		ArrayList<OrderPO> list=orderdatahelper.getAllUser();
		map=new HashMap<String,OrderPO>();
		for(OrderPO po:list){
			map.put(po.getOrderNumber(), po);
		}
	}
	/**
	 * 更新订单的状态，将超时的订单设置为异常
	 */
	public List<OrderPO> updateOrderState(){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		for(Entry<String,OrderPO> entry:map.entrySet()){
			po=entry.getValue();
			if(!(po.getLatest().compareTo(Calendar.getInstance())==1)){
				if(po.getOrderState()==2){
					po.setOrderState(3);
					list.add(po);
					orderdatahelper.update(po);
				}	
			}
		}
		return list;
	}
	/**
	 * 结束持久化数据库的使用
	 * @param
	 * @return
	 * @throws RemoteException
	 * @see po.OrderPO
	 */
	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
