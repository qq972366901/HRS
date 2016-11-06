package TestHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.OrderLineItem;
import List.OrderList;
import Object.Hotel;
import Object.Order;

public class GetHistoryOrderTester {

	@Test
	public void test() {

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
		
		Hotel hotel = new Hotel();
		
		hotel.addOrderList(orderList);
		
		assertEquals(4, hotel.getHistoryOrder());
		
	}

}
