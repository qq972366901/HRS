package TestuserBLImpl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import VO.LogVO;
import rmi.RemoteHelper;
import userBLServiceImpl.Log;

public class LogTest {
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
	public void testLogout() throws RemoteException {
		String id="ac4410375dd760d1";
		Log.getLogInstance().logout(id);
		boolean result=Log.getLogInstance().logstate(id);
		assertEquals(false,result);
	}

	@Test
	public void testLogin() throws RemoteException {
		String id="ac4410375dd760d1";
		String password="ac4410375dd760d1";
		Log.getLogInstance().login(id, password);
		boolean result=Log.getLogInstance().logstate(id);
		assertEquals(true,result);
	}

	@Test
	public void testRevisepassword() throws RemoteException {
		String id="ac4410375dd760d1";
		String password="ac4410375dd760d1";
		Log.getLogInstance().revisepassword(id, password);
		assertEquals(password,Log.getLogInstance().getPassword(id));
	}

	@Test
	public void testDelete() throws RemoteException {
		String id="xxxxxxx";
		Log.getLogInstance().delete(id);
		assertEquals(null,Log.getLogInstance().getKey(id));
	}

	@Test
	public void testAdd() throws RemoteException {
		String id="11";
		String password="11";
		Log.getLogInstance().add(id, new LogVO(id,password,false));
		assertEquals(password,Log.getLogInstance().getPassword(id));
	}

	@Test
	public void testAddKey() throws RemoteException {
		String id="11";
		String key="111111111111";
		String sid="00f7ce98c8cde2f2";
		Log.getLogInstance().addKey(id, key,sid);
		assertEquals(key,Log.getLogInstance().getKey(id));
	}

}
