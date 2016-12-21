package TestPromotion;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import PromotionBLServiceImpl.GetMemberLevelSystem;
import rmi.RemoteHelper;

public class MemberLevelSystemTester {
	private RemoteHelper remoteHelper;
	@Before
	public void init(){		
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			System.out.println("success");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("failue");
			e.printStackTrace();
		}
	}
	@Test
	public void testGetMemberLevelSystem() {
		int discount=(int)( 10*GetMemberLevelSystem.getMemberLevelSystemInstance().getDiscountOfLevel(1));
		assertEquals(95,discount);
	}

}
