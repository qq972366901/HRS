package uiController;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import UserView.OrderView;
import VO.OrderVO;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.OrderViewControllerService;

public class OrderViewControllerImpl implements OrderViewControllerService {
	private OrderView view;
	private OrderBLService order;
	private String id;
	public OrderViewControllerImpl(String UserID) throws RemoteException{
		id=UserID;
		order=new OrderBLServiceController();
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
		List<OrderVO> orderlist=new ArrayList<OrderVO>();
		switch(type){
		case"所有类型": orderlist=order.showAllorder(id);break;
		case"未执行订单":orderlist=order.showUndoneorder(id);break;
		case"已执行订单":orderlist=order.showDoneorder(id);break;
		case"异常订单":orderlist=order.showAbnormalorder(id);break;
		case"撤销订单":orderlist=order.showCancelorder(id);break;
		}
		Vector<OrderVO> list=new Vector<OrderVO>();
		for(OrderVO vo:orderlist){
			vo.addorderNumber();
			vo.addorderState();
			vo.addorderValue();
			vo.addroomType();
			vo.addscore();
			list.add(vo);
		}
		view.updateList(list,type);
	}
	@Override
	public void comment() {
		try {
			view.comment();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void cancel(String orderID) {
	    order.cancel(id, orderID);
		view.cancel();
	}
	public String getUserID(){
		return id;
	}
	@Override
	public void showDetail(String orderID) {
		try {
			view.showDetail(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Vector<OrderVO> getAllOrder() {
		System.out.println(id);
		List<OrderVO> orderlist=order.showAllorder(id);
		System.out.println(orderlist.size());
		Vector<OrderVO> list=new Vector<OrderVO>();
		for(OrderVO vo:orderlist){
			System.out.println(vo.orderNumber);
			System.out.println(vo.orderState);
			vo.addorderNumber();
			vo.addorderState();
			vo.addorderValue();
			vo.addroomType();
			vo.addscore();
			list.add(vo);
		}
		return list;
	}
}
