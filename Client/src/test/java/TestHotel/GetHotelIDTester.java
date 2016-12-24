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
 * 测试搜索得到酒店ID列表
 * @author 刘宗侃
 */
public class GetHotelIDTester {

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
		
		List<String> list = hotel.getHotelID("南京", "新街口", "大床房", 1, 0, 300, 2, 0, 5, "全部", "b0eae4275d0e31a5", "1号酒店");
		
		assertEquals(1, list.size());
		
	}

}
