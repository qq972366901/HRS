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
		cr1=new CreditRecordVO("1@nju.edu.cn","2016/2/2 12/4/6","4728",0,50,3000);
	    cr2=new CreditRecordVO("2@nju.edu.cn","2016/2/6 12/7/6","4738",2,-50,8900);
		cr3=new CreditRecordVO("3@nju.edu.cn","2016/2/22 13/4/6","4228",3,100,4000);
	}
	@Test
	public void testAdd() throws RemoteException {
		CreditRecord.getInstance().add("1", cr1);
		CreditRecord.getInstance().add("2", cr2);
		CreditRecord.getInstance().add("3", cr3);
		assertEquals(cr1,CreditRecord.getInstance().getCreditRecord("1", cr1.orderID));
		assertEquals(cr2,CreditRecord.getInstance().getCreditRecord("2", cr2.orderID));
		assertEquals(cr3,CreditRecord.getInstance().getCreditRecord("3", cr3.orderID));// TODO
	}
	@Test
	public void testShowCreditRecord() throws RemoteException {
		CreditRecord.getInstance().add("1", cr1);
		CreditRecord.getInstance().add("2", cr2);
		CreditRecord.getInstance().add("3", cr3);
		HashMap<String,CreditRecordVO> h1=CreditRecord.getInstance().showCreditRecord("1");
		HashMap<String,CreditRecordVO> h2=CreditRecord.getInstance().showCreditRecord("2");
		HashMap<String,CreditRecordVO> h3=CreditRecord.getInstance().showCreditRecord("3");
		assertEquals(cr1,h1.get(cr1.orderID));
		assertEquals(cr2,h2.get(cr2.orderID));
		assertEquals(cr3,h3.get(cr3.orderID));// TODO
	}
}
