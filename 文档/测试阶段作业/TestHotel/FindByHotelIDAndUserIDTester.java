package TestHotel;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import VO.OrderVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import rmi.RemoteHelper;

public class FindByHotelIDAndUserIDTester {
	
	private RemoteHelper remoteHelper;

	@Test
	public void test() {
		
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		HotelBLService hotel = new HotelBLServiceController();
		
		List<OrderVO> list1 = hotel.findByHotelIDAndUserID("b0eae4275d0e31a5", "60ee8e522f2e992b");
		List<OrderVO> list2 = hotel.findByHotelIDAndUserID("737e975f762214a1", "f4ca32de6c2048c0");
		
		assertEquals(2, list1.size());
		assertEquals(1, list2.size());
	}

}
