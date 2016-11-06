package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import VO.CreditRecordVO;
import runner.ClientRunner;
import userBLImpl.CreditRecord;

public class CreditRecordTest {
	private CreditRecord cr;
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
		cr=new CreditRecord();
	}
	@Test
	public void testAdd() throws RemoteException {
		cr.add("1", cr1);
		cr.add("2", cr2);
		cr.add("3", cr3);
		assertEquals(cr1,cr.getCreditRecord("1", cr1.orderID));
		assertEquals(cr2,cr.getCreditRecord("2", cr2.orderID));
		assertEquals(cr3,cr.getCreditRecord("3", cr3.orderID));// TODO
	}
	@Test
	public void testShowCreditRecord() throws RemoteException {
		cr.add("1", cr1);
		cr.add("2", cr2);
		cr.add("3", cr3);
		HashMap<String,CreditRecordVO> h1=cr.showCreditRecord("1");
		HashMap<String,CreditRecordVO> h2=cr.showCreditRecord("2");
		HashMap<String,CreditRecordVO> h3=cr.showCreditRecord("3");
		assertEquals(cr1,h1.get(cr1.orderID));
		assertEquals(cr2,h2.get(cr2.orderID));
		assertEquals(cr3,h3.get(cr3.orderID));// TODO
	}
	@Test
	public void testUpdateCreditRecord() throws RemoteException {
		cr.add("1", cr1);
		cr.add("2", cr2);
		cr.add("3", cr3);
		cr1.currentcredit=60;
		cr2.creditchange=-900;
		cr3.action=0;
		cr.updateCreditRecord("1", cr1);
		cr.updateCreditRecord("2", cr2);
		cr.updateCreditRecord("3", cr3);
		assertEquals(cr1,cr.getCreditRecord("1", cr1.orderID));
		assertEquals(cr2,cr.getCreditRecord("2", cr2.orderID));
		assertEquals(cr3,cr.getCreditRecord("3", cr3.orderID));// TODO
	}
}
