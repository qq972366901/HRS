package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import VO.UserVO;
import common.UserType;
import userBLServiceImpl.Register;

public class RegisterTest {
	Calendar c=Calendar.getInstance();
	UserVO vo;
	Register register;
	@Before
	public void setUp() throws RemoteException{
		vo=new UserVO("张三","2","11111111111","普通会员",UserType.Customer,c,"");
		register=new Register();
	}
	
	@Test
	public void testAdd() throws RemoteException {
		boolean result=register.add(vo,"1"); 
		assertEquals(false,result); 
	}

	@Test
	public void testGetUser() {
		String id="ac4410375dd760d1";
		UserVO vo=register.getUser(id);
		assertEquals("3fc094e5553cf",vo.username);
	}

}
