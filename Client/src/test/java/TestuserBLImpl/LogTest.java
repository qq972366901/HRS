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
	public void testLogout() throws RemoteException {
		String id="ac4410375dd760d1";
		Log log=new Log();
		log.logout(id);
		boolean result=log.logstate(id);
		assertEquals(false,result);
	}

	@Test
	public void testLogin() throws RemoteException {
		String id="ac4410375dd760d1";
		String password="ac4410375dd760d1";
		Log log=new Log();
		log.login(id, password);
		boolean result=log.logstate(id);
		assertEquals(true,result);
	}

	@Test
	public void testRevisepassword() throws RemoteException {
		String id="ac4410375dd760d1";
		String password="ac4410375dd760d1";
		Log log=new Log();
		log.revisepassword(id, password);
		assertEquals(password,log.getPassword(id));
	}

	@Test
	public void testDelete() throws RemoteException {
		String id="xxxxxxx";
		Log log=new Log();
		log.delete(id);
		assertEquals(null,log.getKey(id));
	}

	@Test
	public void testAdd() throws RemoteException {
		String id="11";
		String password="11";
		Log log=new Log();
		log.add(id, new LogVO(id,password,false));
		assertEquals(password,log.getPassword(id));
	}

	@Test
	public void testAddKey() throws RemoteException {
		String id="11";
		String key="111111111111";
		String sid="00f7ce98c8cde2f2";
		Log log=new Log();
		log.addKey(id, key,sid);
		assertEquals(key,log.getKey(id));
	}
*/
}
