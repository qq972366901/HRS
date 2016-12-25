package TestHotel;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import rmi.RemoteHelper;

/**
 * 测试得到酒店空闲房型列表
 * @author 刘宗侃
 */
public class GetRoomTypeTester {
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
		
		List<String> list = hotel.getRoomType("60ee8e522f2e992b");
		
		assertEquals(5, list.size());
		
	}
*/
}
