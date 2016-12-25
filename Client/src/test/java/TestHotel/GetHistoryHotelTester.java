package TestHotel;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;

import VO.HotelVO;
import hotelBLService.HotelBLService;
import hotelBLService.HotelBLServiceController;
import rmi.RemoteHelper;

/**
 * 测试得到用户的历史酒店
 * @author 刘宗侃
 */
public class GetHistoryHotelTester {
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
		
		List<HotelVO> list = hotel.getHistoryHotel("b0eae4275d0e31a5");
		
		assertEquals(1, list.size());
	
	}
*/
}
