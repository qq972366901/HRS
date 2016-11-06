package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import VO.UserVO;
import runner.ClientRunner;
import userBLImpl.Register;

public class RegisterTest {
	private Register register;
	UserVO user1;
	@Before
	public void setUp(){
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user1=new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"∆’Õ®ª·‘±",1,"1981/2/2","");
		register=new Register();
	}
	@Test
	public void testAdd() throws RemoteException {
		register.add(user1);
		assertEquals(user1,register.getUser(user1.id));// TODO
	}

}
