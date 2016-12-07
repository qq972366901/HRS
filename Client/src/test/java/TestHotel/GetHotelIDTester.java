package TestHotel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;

public class GetHotelIDTester {

	@Test
	public void test() {

		HotelBLService hotel = new HotelBLServiceController();
		
		List<String> list = hotel.getHotelID("南京", "新街口", "大床房", 1, 0, 200, 3, 0, 5, "全部", "01");
		
		assertEquals(2, list.size());
		
	}

}
