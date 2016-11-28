package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import VO.UserVO;
import common.UserType;
import runner.ClientRunner;
@FixMethodOrder(MethodSorters.JVM)
public class AccountTest {
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
	}
	@Test
	public void testAdd() throws RemoteException {
		/*
		account.add(user1);
		assertEquals(user1,account.getUser("1@nju.edu.cn"));
		account.add(user2);
		assertEquals(user2,account.getUser("2@nju.edu.cn"));
		account.add(user3);
		assertEquals(user3,account.getUser("3@nju.edu.cn"));// TODO
		*/
	}
	@Test
	public void testUpdate() throws RemoteException {
		/*
		account.add(user1);
		user1.username="user1";// TODO
		account.update(user1);
		assertEquals(user1,account.getUser(user1.id));
		*/
	}

	@Test
	public void testDelete() throws RemoteException {
		/*
		 account.delete(user2);// TODO
		 assertNull(account.getUser(user2.id));
		 */
	}

}
