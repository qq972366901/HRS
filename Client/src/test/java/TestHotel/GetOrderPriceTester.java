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
 * 测试得到订单原始价格
 * @author 刘宗侃
 */
public class GetOrderPriceTester {
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
		
		int price = hotel.getOrderPrice("60ee8e522f2e992b", "标准双人间", 2);
		
		assertEquals(800, price);
		
	}
*/
}
