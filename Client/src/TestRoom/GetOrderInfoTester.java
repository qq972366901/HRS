package TestRoom;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.OrderLineItem;
import List.OrderList;
import Object.Order;
import Object.Room;

public class GetOrderInfoTester {

	@Test
	public void testGetOrderInfo() {
		
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		
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
