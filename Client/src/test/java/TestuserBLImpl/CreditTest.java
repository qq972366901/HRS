package TestuserBLImpl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import common.Operate;
import rmi.RemoteHelper;
import userBLServiceImpl.Credit;
import userBLServiceImpl.Customer;
import vo.CreditRecordVO;

public class CreditTest {
	/*
	private RemoteHelper remoteHelper;
	@Before
	public void setup(){
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			System.out.println("linked");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("failue");
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdateCredit() throws RemoteException, ParseException {
		Credit c=new Credit();
		CreditRecordVO vo=new CreditRecordVO("000000","737e975f762214a1",Calendar.getInstance(),"1",Operate.Recharge,0,31700);
		c.updateCredit(vo);
		assertEquals(31700,c.showCredit("737e975f762214a1"));
	}

	@Test
	public void testUpdateLevel() throws RemoteException {
		Credit c=new Credit();
		c.updateLevel("737e975f762214a1", 0);
		assertEquals(0,c.showLevel("737e975f762214a1"));
	}

	@Test
	public void testUpdateAllLevel() throws RemoteException {
		Credit c=new Credit();
		assertEquals(true,c.updateAllLevel());
	}
*/
}
