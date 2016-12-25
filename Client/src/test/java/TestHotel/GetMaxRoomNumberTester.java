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
 * 测试得到所选房型最大数量
 * @author 刘宗侃
 */
public class GetMaxRoomNumberTester {
/*
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
		
		int roomNum = hotel.getMaxRoomNumber("60ee8e522f2e992b", "大床房");
		
		assertEquals(5, roomNum);
		
		
	}
*/
}
