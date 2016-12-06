package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Test;

import VO.UserVO;
import common.UserType;
import userBLServiceImpl.Customer;

public class CustomerTest {

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
