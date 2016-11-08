package TestRoom;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.OrderLineItem;
import List.OrderList;
import Object.Order;
import Object.Room;
import VO.OrderVO;

public class GetOrderInfoTester {

	@Test
	public void testGetOrderInfo() {
		
		OrderVO order1 = new OrderVO();
		OrderVO order2 = new OrderVO();
		OrderVO order3 = new OrderVO();
		OrderVO order4 = new OrderVO();
		
		OrderLineItem orderLineItem1 = new OrderLineItem(order1);
		OrderLineItem orderLineItem2 = new OrderLineItem(order2);
		OrderLineItem orderLineItem3 = new OrderLineItem(order3);
		OrderLineItem orderLineItem4 = new OrderLineItem(order4);
		
		OrderList orderList = new OrderList();
		
		orderList.addOrderLineItems(orderLineItem1);
		orderList.addOrderLineItems(orderLineItem2);
		orderList.addOrderLineItems(orderLineItem3);
		orderList.addOrderLineItems(orderLineItem4);
		
		Room room = new Room();
		
		room.addOrderList(orderList);
		
		assertEquals(4, room.getOrderInfo());
		
		
		
	}

}
