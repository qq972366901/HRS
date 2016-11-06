package TestOrder;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.OrderLineItem;
import List.OrderList;

import java.util.*;
import java.time.*;

import Mock.*;
import Object.*;
import VO.HotelVO;
import common.*;
/**
 * Test_Order
 * @author ¡ı”ÓœË
 * @version 1.0
 * @see
 */
public class Test_findbyType {
	Date time1=new Date(2016,10,2,11,15,30);
	Date time2=new Date(2017,11,3,20,13,20);
	Date time4=new Date(2016,9,3,4,13,29);
	Date time5=new Date(2017,12,3,23,16,0);
	Date time3=null;
    MockOrder a=new MockOrder("000", 2, 100, 3, false, "double", 303, time1, time2, time3, "good", 100, time3);
    MockOrder b=new MockOrder("023", 1, 155, 4, true, "one", 305, time4, time5, time1, "very good", 98, time3);
	@Test
	public void test() {
		OrderList list=new OrderList();
		OrderLineItem item=new OrderLineItem(a);
		OrderLineItem item2=new OrderLineItem(b);
		list.addOrderLineItems(item);
		list.addOrderLineItems(item2);
		Order order=new Order();
		order.addorderlist(list);
		assertEquals(b.getOrderNumber(),order.findByType("one").get(0).getorder().getOrderNumber());
	}

}