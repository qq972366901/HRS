 package TestuserBLImpl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import VO.UserVO;
import common.UserType;
import rmi.RemoteHelper;
import userBLServiceImpl.Account;
import userBLServiceImpl.AccountInfo;
import userBLServiceImpl.Credit;

public class AccountTest {
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
	public void testGetUser() throws RemoteException {
		Account a=new Account();
		AccountInfo info=a.getUser(UserType.WebManagementWorker, "ac4410375dd760d1");
		assertNotNull(info);
	}

	@Test
	public void testUpdateContactway() throws RemoteException {
		String id="ac4410375dd760d1";
		String phone="ru29290t2t2d2c";
		Account a=new Account();
		a.updateContactway(id, phone);
		assertEquals(phone,a.getUser(UserType.WebManagementWorker,id).contactway);
	}

	@Test
	public void testDelete() throws RemoteException {
		String id="xx";
		Account a=new Account();
		a.delete(id);
		assertEquals(false,a.judgeAccount(id));
	}

	@Test
	public void testAdd() throws RemoteException {
		UserVO vo=new UserVO("0","0","0","普通会员",UserType.Customer,Calendar.getInstance(),"");
		String password="0";
		Account a=new Account();
		boolean result=a.add(vo, password);
		assertEquals(true,result);
	}

}
