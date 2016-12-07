package TestRoom;

import static org.junit.Assert.*;

import org.junit.Test;

import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;

public class WhetherSuccessTester {

	@Test
	public void testWhetherSuccess() {

		RoomBLService room = new RoomBLServiceController();
		
		boolean test1 = room.whetherSuccess("001", "大床房", 2);
		assertEquals(true, test1);
		
		boolean test2 = room.whetherSuccess("001", "大床房", 3);
		assertEquals(true, test2);
		
	}

}
