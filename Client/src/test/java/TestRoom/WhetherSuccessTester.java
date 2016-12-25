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
 * 测试能否得到足够房间
 * @author 刘宗侃
 */
public class WhetherSuccessTester {
/*
	private RemoteHelper remoteHelper;
	
	@Test
	public void testWhetherSuccess() {
		
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
		
		boolean test1 = room.whetherSuccess("60ee8e522f2e992b", "大床房", 2);
		assertEquals(true, test1);
		
		boolean test2 = room.whetherSuccess("f4ca32de6c2048c0", "三人间", 3);
		assertEquals(false, test2);
		
	}
*/
}
