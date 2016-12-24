package TestHotel;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import rmi.RemoteHelper;

/**
 * 测试得到酒店评分
 * @author 刘宗侃
 */
public class GetHotelScoreTester {

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
		
		double score = hotel.getHotelScore("60ee8e522f2e992b");
		boolean equal = false;
		if(score - 4.5 < 0.001 && 4.5 - score < 0.001) {
			equal = true;
		}
		
		assertEquals(true, equal);
	
	}

}
