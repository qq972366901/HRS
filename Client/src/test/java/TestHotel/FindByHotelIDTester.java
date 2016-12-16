package TestHotel;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import rmi.RemoteHelper;

public class FindByHotelIDTester {
	
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
		
		HotelVO hvo = hotel.findByHotelID("60ee8e522f2e992b");
		assertEquals("60ee8e522f2e992b", hvo.hotelAccount);
		assertEquals("重庆", hvo.hotelCity);
		assertEquals(5, hvo.hotelStar);
		
	}

}
