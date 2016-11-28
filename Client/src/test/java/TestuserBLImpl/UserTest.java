package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import VO.UserVO;
import common.UserType;
import runner.ClientRunner;
import userBLServiceImpl.Customer;

public class UserTest {
	private Customer user;
	UserVO user1;
	UserVO user2;
	UserVO user3;
	@Before
	public void setUp(){
		/*
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Calendar time1=Calendar.getInstance();
		time1.set(2016,11,11);
		Calendar time2=Calendar.getInstance();
		time2.set(2016,11,11);
		Calendar time3=Calendar.getInstance();
		time3.set(2016,11,11);

		user1=new UserVO("1","1","1234567","普通会员",UserType.Customer,time1,"");
		user2=new UserVO("2","1","1234567","企业会员",UserType.Customer,time2,"Goldman Sachs");
		user3=new UserVO("3","1","1234567","普通会员",UserType.Customer,time3,"");
		user=Customer.getUserInstance();	
	}

	@Test
	public void testCreate() throws RemoteException {
		user.create(user1,"1234567");
		assertEquals(user1,user.findByID(user1.id));
		user.create(user2,"1234567");
		assertEquals(user2,user.findByID(user2.id));
		user.create(user3,"1234567");
		assertEquals(user3,user.findByID(user3.id));// TODO
	}
	
	@Test
	public void testFindByID() throws RemoteException {
		user.create(user1,"1234567");
		user.create(user2,"1234567");
		user.create(user3,"1234567");
		String id=user1.id;
		UserVO vo=user.findByID(id);
		assertEquals(user1,vo);// TODO
	}

	@Test
	public void testLogout() throws RemoteException {
		/*
		user.create(user1);
		user.create(user2);
		user.create(user3);
		user.logout(user2.id);
		assertEquals(false,user.findByID(user2.id).inorout);// TODO*/
	}

	@Test
	public void testLogin() throws RemoteException {
		/*user.create(user1);
		user.create(user2);
		user.create(user3);
		user.login(user1.id);
		assertEquals(true,user.findByID(user1.id).inorout);// TODO*/
	}

	@Test
	public void testUpdateUserInfo() throws RemoteException {
		user.create(user1,"1234567");
		user.create(user2,"1234567");
		user.create(user3,"1234567");
		Calendar time=Calendar.getInstance();
		time.set(1988,4,5);
		user2.birthday=time;
		user.updateUserInfo(user2,"1234567");
		assertEquals(user2,user.findByID(user2.id));// TODO
	}
}
