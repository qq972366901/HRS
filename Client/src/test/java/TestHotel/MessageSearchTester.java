package TestHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import LineItem.HotelLineItem;
import List.HotelList;
import Object.Hotel;
import VO.HotelVO;

public class MessageSearchTester {

	@Test
	public void testMessageSearch() {

		HotelVO hotel1 = new HotelVO("学海路2号","仙林大学城",2,"酒店简介1","酒店服务1","如家快捷酒店","18022223333","预定状态1","161000001",4.2);
		HotelVO hotel2 = new HotelVO("广州路5号","鼓楼",5,"酒店简介2","酒店服务2","希尔顿酒店","18800006688","预定状态2","161000002",4.8);
		
		HotelList hotelList = new HotelList();
		
		HotelLineItem hotelLineItem1 = new HotelLineItem(hotel1);
		HotelLineItem hotelLineItem2 = new HotelLineItem(hotel2);
		
		hotelList.addHotelLineItems(hotelLineItem1);
		hotelList.addHotelLineItems(hotelLineItem2);
		
		Hotel hotel = new Hotel();
		
		hotel.addHotelList(hotelList);
		
		assertEquals(1, hotel.messageSearch("希尔顿"));
		
	}

}
