package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import VO.UserVO;
import runner.ClientRunner;
import userBLImpl.User;
public class UserTest {
	private User user;
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
		user2=new UserVO("2","2@nju.edu.cn","3415641","2",true,5,41780,"企业会员",1,time2,"Goldman Sachs");
		user3=new UserVO("3","3@nju.edu.cn","9414141","3",false,2,4178,"普通会员",1,time3,"");
		user=new User();
		
	}

	@Test
	public void testCreate() throws RemoteException {
		user.create(user1);
		assertEquals(user1,user.findByID(user1.id));
		user.create(user2);
		assertEquals(user2,user.findByID(user2.id));
		user.create(user3);
		assertEquals(user3,user.findByID(user3.id));// TODO
	}
	
	@Test
	public void testFindByID() throws RemoteException {
		user.create(user1);
		user.create(user2);
		user.create(user3);
		String id=user1.id;
		UserVO vo=user.findByID(id);
		assertEquals(user1,vo);// TODO
	}

	@Test
	public void testUpdateLevel() throws RemoteException {
		user.create(user1);
		user.create(user2);
		user.create(user3);
		user.updateLevel(user3);
		assertEquals(user.findByID(user3.id).level,3);// TODO
	}

	@Test
	public void testLogout() throws RemoteException {
		user.create(user1);
		user.create(user2);
		user.create(user3);
		user.logout(user2.id);
		assertEquals(false,user.findByID(user2.id).inorout);// TODO
	}

	@Test
	public void testLogin() throws RemoteException {
		user.create(user1);
		user.create(user2);
		user.create(user3);
		user.login(user1.id);
		assertEquals(true,user.findByID(user1.id).inorout);// TODO
	}

	@Test
	public void testUpdateUserInfo() throws RemoteException {
		user.create(user1);
		user.create(user2);
		user.create(user3);
		Calendar time=Calendar.getInstance();
		time.set(1988,4,5);
		user2.birthday=time;
		user.updateUserInfo(user2);
		assertEquals(user2,user.findByID(user2.id));// TODO
	}
}
