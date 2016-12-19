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
import userBLServiceImpl.Register;

public class RegisterTest {
	Calendar c=Calendar.getInstance();
	UserVO vo;
	Register register;
	private RemoteHelper remoteHelper;
	@Before
	public void setUp() throws RemoteException{
			remoteHelper = RemoteHelper.getInstance();
			try {
				remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
				System.out.println("linked");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("failue");
				e.printStackTrace();
			}
		vo=new UserVO("张","2","11111111111","普通会员",UserType.Customer,c,"");
		register=new Register();
	}
	
	@Test
	public void testAdd() throws RemoteException {
		boolean result=register.add(vo,"1"); 
		assertEquals(false,result); 
	}

}
