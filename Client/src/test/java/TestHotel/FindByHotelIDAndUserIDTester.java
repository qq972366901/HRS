package TestHotel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;

public class FindByHotelIDAndUserIDTester {

	@Test
	public void test() {

		HotelBLService hotel = new HotelBLServiceController();
		
		List<OrderVO> list = hotel.findByHotelIDAndUserID("01", "001");
		
		assertEquals(0, list.size());
	}

}
