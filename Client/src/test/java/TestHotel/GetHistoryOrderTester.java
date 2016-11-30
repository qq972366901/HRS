package TestHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.OrderLineItem;
import List.OrderList;
import Object.Hotel;
import VO.OrderVO;

public class GetHistoryOrderTester {

	@Test
	public void test() {

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
		
		Hotel hotel = new Hotel();
		
		hotel.addOrderList(orderList);
		
		assertEquals(4, hotel.getHistoryOrder());
		
	}

}
