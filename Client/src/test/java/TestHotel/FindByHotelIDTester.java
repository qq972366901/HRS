package TestHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;

public class FindByHotelIDTester {

	@Test
	public void test() {
		
		HotelBLService hotel = new HotelBLServiceController();
		
		HotelVO hvo = hotel.findByHotelID("001");
		assertEquals("001", hvo.hotelAccount);
		
	}

}
