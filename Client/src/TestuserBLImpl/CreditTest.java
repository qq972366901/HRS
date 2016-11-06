package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import VO.CreditRecordVO;
import runner.ClientRunner;
import userBLImpl.Credit;

public class CreditTest {
	private Credit credit;
	CreditRecordVO cr1;
	CreditRecordVO cr2;
	CreditRecordVO cr3;
	@Before
	public void setUp(){
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cr1=new CreditRecordVO("1@nju.edu.cn","2016/2/2 12/4/6","4728",0,50,3000);
	    cr2=new CreditRecordVO("2@nju.edu.cn","2016/2/6 12/7/6","4738",2,-50,8900);
		cr3=new CreditRecordVO("3@nju.edu.cn","2016/2/22 13/4/6","4228",3,100,4000);
		credit=new Credit();
	}
	@Test
	public void testUpdateCredit() throws RemoteException {
		credit.updateCredit("1", cr1);
		assertEquals(cr1.currentcredit,credit.showCredit("1"));// TODO
	}
	@Test
	public void testShowCredit() throws RemoteException {
		credit.updateCredit("1", cr1);
		credit.updateCredit("2", cr2);
		credit.updateCredit("3", cr3);
		long c1=credit.showCredit("1");
		long c2=credit.showCredit("2");
		long c3=credit.showCredit("3");
		assertEquals(cr1.currentcredit,c1);
		assertEquals(cr2.currentcredit,c2);
		assertEquals(cr3.currentcredit,c3);// TODO
	}
}
