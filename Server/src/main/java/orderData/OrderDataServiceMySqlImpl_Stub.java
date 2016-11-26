package orderData;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import PO.OrderPO;

public class OrderDataServiceMySqlImpl_Stub implements Serializable,dataService.OrderDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<String,OrderPO> map;
    static OrderDataServiceMySqlImpl_Stub orderdataimpl;
    public OrderDataServiceMySqlImpl_Stub(){
    	map=new HashMap<String,OrderPO>();
    	OrderPO po1=new OrderPO(3,"000", "110", "001", 2,300,3,true,"总统套房",301, Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),"很好",5);
    	OrderPO po2=new OrderPO(1,"001", "110", "002", 2,400,4,true,"套房",302, Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),"一般",4);
    	OrderPO po3=new OrderPO(1,"001", "110", "003", 3,500,4,true,"套房",303, Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),"一般",4);
        map.put("001", po1);
        map.put("002", po2);
        map.put("003", po3);
        System.out.println("22222222222222222222"+map.get("001").getComment());
    }
    public static OrderDataServiceMySqlImpl_Stub getInstance(){
    	if(orderdataimpl==null){
    		orderdataimpl=new OrderDataServiceMySqlImpl_Stub();
    		return orderdataimpl;
    	}
    	else{
    		return orderdataimpl;
    	}
    }
	@Override
	public OrderPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find OrderID :"+id+" is userID:" +map.get(id).getUserID());
		System.out.println("find OrderID :"+id+" is userID:" +map.get(id).getUserID());
		System.out.println("find OrderID :"+id+" is userID:" +map.get(id).getUserID());
		
		return map.get(id);
	}

	@Override
	public void insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		map.put(po.getOrderNumber(), po);
	}

	@Override
	public void delete(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!");
	}

	@Override
	public void update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		map.put(po.getOrderNumber(), po);
		System.out.println("update! Order id:"+po.getOrderNumber());
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Succeed!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish Succeed!");
	}

	@Override
	public ArrayList<OrderPO> findByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!");
		ArrayList<OrderPO> x=new ArrayList<OrderPO>();
		OrderPO po=new OrderPO(3,"xxx", "110", "111", 1,500,5,true,"总统套房",302, Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance(),"xxx",5);
		x.add(po);
		return x;
	}

}
