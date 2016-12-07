package TestHotel;

import static org.junit.Assert.*;

import org.junit.Test;

import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;

public class GetHotelScoreTester {

	@Test
	public void test() {

		HotelBLService hotel = new HotelBLServiceController();
		
		double score = hotel.getHotelScore("001");
		boolean equal = false;
		if(score - 0 < 0.001 && 0 - score < 0.001) {
			equal = true;
		}
		
		assertEquals(true, equal);
	
	}

}
