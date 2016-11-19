package OrderManagementView;

import java.util.Calendar;
import java.util.Vector;

import Service.Impl.OrderBLServiceImpl;
import VO.OrderVO;
import orderBLService.OrderBLService;

public class OrderViewControllerImpl implements OrderViewControllerService {
	private OrderView view;
	private OrderBLService order;
	private Calendar Time;
	private String id;
	public OrderViewControllerImpl(String UserID){
		id=UserID;
		order=new OrderBLServiceImpl(id);
	}
	public void setView(OrderView view){
		this.view=view;
	}
	@Override
	public void exit() {
		view.exit();
	}
	@Override
	public void updateList(String type) {
		// TODO Auto-generated method stub
		Vector<OrderVO> list=new Vector<OrderVO>();
		OrderVO a=new OrderVO();
		a.add("123");
		a.add("234");
		a.add("345");
		a.add("456");
		a.add("345");
		a.add("456");
		list.add(a);
		view.updateList(list,type);
	}
	@Override
	public void comment() {
		// TODO Auto-generated method stub
		view.comment();
	}
	@Override
	public void cancel(String orderID) {
		// TODO Auto-generated method stub
		Time=Calendar.getInstance();
		view.cancel();
		//order.cancelOrder(id,Time);
	}
	public String getUserID(){
		return id;
	}
	@Override
	public void showDetail(String orderID) {
		view.showDetail(orderID);
	}
	
}
