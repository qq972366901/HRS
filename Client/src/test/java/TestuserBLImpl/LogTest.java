package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import VO.LogVO;
import userBLServiceImpl.Log;

public class LogTest {

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
		String password="90c7049baf51b9bc";
		Log.getLogInstance().revisepassword(id, password);
		assertEquals(password,Log.getLogInstance().getPassword(id));
	}

	@Test
	public void testDelete() throws RemoteException {
		String id="ac4410375dd760d1";
		Log.getLogInstance().delete(id);
		assertEquals(null,Log.getLogInstance().getKey(id));
	}

	@Test
	public void testAdd() throws RemoteException {
		String id="1";
		String password="1";
		Log.getLogInstance().add(id, new LogVO(id,password,false));
		assertEquals(password,Log.getLogInstance().getPassword(id));
	}

	@Test
	public void testAddKey() throws RemoteException {
		String id="1";
		String key="1";
		String sid="1";
		Log.getLogInstance().addKey(id, key,sid);
		assertEquals(key,Log.getLogInstance().getKey(id));
	}

}
