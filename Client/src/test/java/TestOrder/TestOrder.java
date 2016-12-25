package TestOrder;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import VO.OrderVO;
import orderBLImpl.Comment;
import orderBLImpl.CommentInfo;
import orderBLImpl.OrderLineItem;
import orderBLImpl.OrderList;
import rmi.RemoteHelper;

public class TestOrder {
	/*
	private RemoteHelper remoteHelper;
	private OrderLineItem item;
	private Comment comment;
	private OrderList list;
	private void init(){		
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			list=new OrderList();
			item=new OrderLineItem();
			comment=new Comment();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testShowOrderList(){
		init();
		assertEquals(0,list.showAbnormalorder("737e975f762214a1").size());
		assertEquals(1,list.showCancelorder("737e975f762214a1").size());
		assertEquals(2,list.showUndoneorder("737e975f762214a1").size());
		assertEquals(1,list.showDoneorder("737e975f762214a1").size());
		assertEquals(4,list.showAllorder("737e975f762214a1").size());
		assertEquals(2,list.getAbnormalOrders("60ee8e522f2e992b").size());
		assertEquals(0,list.getCancelOrders("60ee8e522f2e992b").size());
		assertEquals(0,list.getUnfinishedOrders("60ee8e522f2e992b").size());
		assertEquals(2,list.getFinishedOrders("60ee8e522f2e992b").size());
		assertEquals(4,list.getAllOrders("60ee8e522f2e992b").size());
	}
	@Test
	public void testUpdateComment() {
		init();
		String str="非常不错的环境和服务。";
		comment.updatecomment(str, 4, "1");
		assertEquals(str, item.showDetail("1").comment);
		assertEquals(4,item.showDetail("1").score);
	}
	
	@Test
	public void testGetHotelComment(){
		init();
		List<CommentInfo> info=comment.getHotelComment("60ee8e522f2e992b");
		assertEquals(2,info.size());
		assertEquals("非常不错的环境和服务。",info.get(0).comment);
		List<CommentInfo> info1=comment.getHotelComment("f4ca32de6c2048c0");
		assertEquals(0,info1.size());
	}
    @Test
    public void testSaveOrderInfo(){
    	init();
    	Calendar cal=Calendar.getInstance();
    	OrderVO vo=new OrderVO("3","5","8",2,400,3,true,"家庭标准间",103,cal
				,cal,cal,cal,cal,null,0);
    	item.saveOrderInfo(vo);
    	OrderVO v=item.showDetail("7");
    	assertEquals(400,v.orderValue);
    }

	@Test
	public void testShowDetail(){
		init();
		assertEquals("三人间",item.showDetail("1").roomType);
	}
	@Test
	public void testGetUserID(){
		init();
		assertEquals("b0eae4275d0e31a5",item.getUserID("3"));
	}
	
	@Test
	public void testUserInHotel(){
		init();
		assertEquals(3,list.findByHotelID("737e975f762214a1","f4ca32de6c2048c0").size());
	}
	*/
}
