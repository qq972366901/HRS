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
import userBLServiceImpl.Customer;

public class CustomerTest {
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
	public void testHasCustomer() throws RemoteException {
		String id="ac4410375dd760d1";
		boolean result=Customer.getUserInstance().hasCustomer(id);
		assertEquals(true,result);
	}

	@Test
	public void testDeleteCustomer() throws RemoteException {
		String id="ac4410375dd760d1";
		Customer.getUserInstance().deleteCustomer(id);
		assertEquals(null,Customer.getUserInstance().findByID(id));
	}

	@Test
	public void testFindByID() throws RemoteException {
		String id="ac4410375dd760d1";
		assertEquals(id,Customer.getUserInstance().findByID(id).id);
	}

	@Test
	public void testUpdateUserInfo() throws RemoteException {
		String id="ac4410375dd760d1";
		UserVO vo=Customer.getUserInstance().findByID(id);
		vo.contactway="1";
		Customer.getUserInstance().updateUserInfo(vo);
		assertEquals("1",Customer.getUserInstance().findByID(id).contactway);
	}

	@Test
	public void testCreate() throws RemoteException {
		UserVO vo=new UserVO("0","0","0","普通会员",UserType.Customer,Calendar.getInstance(),"");
		String password="0";
		Customer.getUserInstance().create(vo, password);
		assertEquals(vo,Customer.getUserInstance().findByID(vo.id));
	}

}
