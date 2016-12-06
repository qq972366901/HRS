 package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Test;

import VO.UserVO;
import common.UserType;
import userBLServiceImpl.Account;
import userBLServiceImpl.AccountInfo;

public class AccountTest {

	@Test
	public void testGetUser() throws RemoteException {
		AccountInfo info=Account.getInstance().getUser(UserType.WebManagementWorker, "ac4410375dd760d1");
		assertNotNull(info);
	}

	@Test
	public void testUpdateContactway() throws RemoteException {
		String id="ac4410375dd760d1";
		String phone="ru29290t2t2d2c";
		Account.getInstance().updateContactway(id, phone);
		assertEquals(phone,Account.getInstance().getUser(UserType.WebManagementWorker,id).contactway);
	}

	@Test
	public void testDelete() throws RemoteException {
		String id="ac4410375dd760d1";
		Account.getInstance().delete(id);
		assertEquals(false,Account.getInstance().judgeAccount(id));
	}

	@Test
	public void testAdd() throws RemoteException {
		UserVO vo=new UserVO("0","0","0","普通会员",UserType.Customer,Calendar.getInstance(),"");
		String password="0";
		boolean result=Account.getInstance().add(vo, password);
		assertEquals(true,result);
	}

}
