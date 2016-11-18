package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import VO.UserVO;
import runner.ClientRunner;
import userBLImpl.Account;
@FixMethodOrder(MethodSorters.JVM)
public class AccountTest {
	private Account account;
	UserVO user1;
	UserVO user2;
	UserVO user3;
	@Before
	public void setUp(){
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar time1=Calendar.getInstance();
		time1.set(2016,11,11);
		Calendar time2=Calendar.getInstance();
		time2.set(2016,11,11);
		Calendar time3=Calendar.getInstance();
		time3.set(2016,11,11);
		user1=new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,time1,"");
		user2=new UserVO("2","2@nju.edu.cn","3415641","1",false,5,41780,"企业会员",1,time2,"Goldman Sachs");
		user3=new UserVO("3","3@nju.edu.cn","9414141","1",false,3,4178,"普通会员",1,time3,"");
		account=new Account(user1.type);
	}
	@Test
	public void testAdd() throws RemoteException {
		account.add(user1);
		assertEquals(user1,account.getUser("1@nju.edu.cn"));
		account.add(user2);
		assertEquals(user2,account.getUser("2@nju.edu.cn"));
		account.add(user3);
		assertEquals(user3,account.getUser("3@nju.edu.cn"));// TODO
	}
	@Test
	public void testUpdate() throws RemoteException {
		account.add(user1);
		user1.username="user1";// TODO
		account.update(user1);
		assertEquals(user1,account.getUser(user1.useraccount));
	}

	@Test
	public void testDelete() throws RemoteException {
		 account.delete(user2);// TODO
		 assertNull(account.getUser(user2.useraccount));
	}

}
