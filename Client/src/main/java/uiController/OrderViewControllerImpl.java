package uiController;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import UserView.OrderView;
import VO.OrderVO;
import common.Operate;
import orderBLService.OrderBLService;
import orderBLService.OrderBLServiceController;
import uiService.OrderViewControllerService;

public class OrderViewControllerImpl implements OrderViewControllerService {
	private OrderView view;
	private OrderBLService order;
	private String id;
	public OrderViewControllerImpl(String UserID){
		id=UserID;
		try {
			order=new OrderBLServiceController();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		id=UserID;
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
			vo.addexpectedCheckIn();
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
	    if(order.cancel(id, orderID)){
	    	order.updateCredit(id, orderID, order.showDetail(orderID).orderValue, Operate.Cancel);
	    }
		view.cancel();
	}
	public String getUserID(){
		return id;
	}
	@Override
	public void showDetail(String orderID) {
		try {
			view.showDetail(orderID,order.showDetail(orderID).hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Vector<OrderVO> getAllOrder() {
		List<OrderVO> orderlist=order.showAllorder(id);
		Vector<OrderVO> list=new Vector<OrderVO>();
		for(OrderVO vo:orderlist){
			vo.addorderNumber();
			vo.addorderState();
			vo.addorderValue();
			vo.addroomType();
			vo.addexpectedCheckIn();
			vo.addscore();
			list.add(vo);
		}
		return list;
	}
}
