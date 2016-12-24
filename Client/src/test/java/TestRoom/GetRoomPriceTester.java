package TestRoom;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import rmi.RemoteHelper;
import roomBLService.RoomBLService;
import roomBLService.RoomBLServiceController;

/**
 * 测试得到房间价格
 * @author 刘宗侃
 */
public class GetRoomPriceTester {

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

		RoomBLService room = new RoomBLServiceController();
		
		assertEquals(1000, room.getRoomPrice("60ee8e522f2e992b", "豪华套房"));
	}

}
