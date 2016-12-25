package TestOrder;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Test;

import orderBLImpl.OrderLineItem;
import orderBLImpl.OrderState;
import rmi.RemoteHelper;

public class TestOrderState {
	/*
	private RemoteHelper remoteHelper;
	private OrderLineItem item;
	private OrderState state;
	private void init(){		
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			item=new OrderLineItem();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testCancel(){
		init();
		state=new OrderState("2");
		assertEquals(2,item.showDetail("2").orderState);
		state.cancel();
		assertEquals(4,item.showDetail("2").orderState);
		assertEquals(Calendar.getInstance().get(Calendar.MINUTE),item.showDetail("2").cancel.get(Calendar.MINUTE));
	}
	@Test
	public void testCancelAbnormal(){
		init();
		state=new OrderState("3");
		assertEquals(3,item.showDetail("3").orderState);
		state.cancelAbnormalOrder();
		assertEquals(4,item.showDetail("3").orderState);
	}
	@Test
	public void testProcess(){
		init();
		state=new OrderState("6");
		assertEquals(2,item.showDetail("6").orderState);
		state.processUnfinishedOrder();
		assertEquals(1,item.showDetail("6").orderState);
	}
	@Test
	public void testDelay(){
		init();
		state=new OrderState("7");
		assertEquals(3,item.showDetail("7").orderState);
		Calendar cal=Calendar.getInstance();
		state.processAbnormalOrder(cal);
		assertEquals(2,item.showDetail("7").orderState);
		assertEquals(cal,item.showDetail("7").latest);
	}
	*/
}
