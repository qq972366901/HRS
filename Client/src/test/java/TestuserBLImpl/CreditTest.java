package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import VO.CreditRecordVO;
import common.Operate;
import runner.ClientRunner;
import userBLServiceImpl.Credit;

public class CreditTest {
	CreditRecordVO cr1;
	CreditRecordVO cr2;
	CreditRecordVO cr3;
	@Before
	public void setUp(){
		/*
		try {
			ClientRunner cr = new ClientRunner();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Calendar c1 = Calendar.getInstance();
		c1.set(1,1,1);
		Calendar c2 = Calendar.getInstance();
		c2.set(1,1,1);
		Calendar c3 = Calendar.getInstance();
		c3.set(1,1,1);
		cr1=new CreditRecordVO("1@nju.edu.cn",c1,"4728",Operate.Done,50,3000);
	    cr2=new CreditRecordVO("2@nju.edu.cn",c2,"4738",Operate.Abnormal,-50,8900);
		cr3=new CreditRecordVO("3@nju.edu.cn",c3,"4228",Operate.Done,100,4000);
	}
	@Test
	public void testUpdateCredit() throws RemoteException {
		Credit.getInstance().updateCredit(cr1);
		assertEquals(cr1.currentcredit,Credit.getInstance().showCredit("1"));// TODO
	}
	@Test
	public void testShowCredit() throws RemoteException {
		Credit.getInstance().updateCredit(cr1);
		Credit.getInstance().updateCredit(cr2);
		Credit.getInstance().updateCredit(cr3);
		long c1=Credit.getInstance().showCredit("1");
		long c2=Credit.getInstance().showCredit("2");
		long c3=Credit.getInstance().showCredit("3");
		assertEquals(cr1.currentcredit,c1);
		assertEquals(cr2.currentcredit,c2);
		assertEquals(cr3.currentcredit,c3);// TODO
	}
}
