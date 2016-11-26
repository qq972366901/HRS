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
 * @author 刘宇翔
 * @version 1.1
 * @see
 */
public class Test_showdetail {
	Calendar time1=Calendar.getInstance();
	Calendar time2=Calendar.getInstance();
	Calendar time3=Calendar.getInstance();
	Calendar time4=Calendar.getInstance();
	Calendar time5=Calendar.getInstance();
	Calendar time6=Calendar.getInstance();
    MockOrder a=new MockOrder("000001","00101","000", 2, 100, 3, false, "double", 303, time1, time2, time3,time3,time4, "good", 100);
    MockOrder b=new MockOrder("000001","00101","023", 1, 155, 4, true, "one", 305, time4, time5, time1,time3,time4, "very good", 98);
    MockOrder c=new MockOrder("000001","00101","025", 1, 155, 3, true, "three", 307, time4, time5, time1,time3,time4, "just so so", 70);
	@Test
	public void test() {
		OrderList list=new OrderList();
		OrderLineItem item=new OrderLineItem(a);
		OrderLineItem item2=new OrderLineItem(b);
		list.addOrderLineItems(item);
		list.addOrderLineItems(item2);
		Order order=new Order();
		order.addorderlist(list);
		assertNotEquals(b.getOrderNumber(),order.showDetail("000").getvo().orderNumber);
		assertEquals(a.getOrderNumber(),order.showDetail("000").getvo().orderNumber);
		assertEquals(b.getChild(),order.showDetail("023").getvo().child);
	}

}
