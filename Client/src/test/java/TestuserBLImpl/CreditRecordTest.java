package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;

import org.junit.Test;

import VO.CreditRecordVO;
import common.Operate;
import userBLServiceImpl.CreditRecord;
import userBLServiceImpl.Customer;

public class CreditRecordTest {

	@Test
	public void testShowCreditRecord() throws RemoteException, ParseException {
		HashMap<String,CreditRecordVO> map=CreditRecord.getInstance().showCreditRecord("737e975f762214a1");
		assertNotNull(map);
	}

	@Test
	public void testAdd() throws RemoteException, ParseException {
		CreditRecordVO vo=new CreditRecordVO("737e975f762214a1",Calendar.getInstance(),"1",Operate.Recharge,50,1000);
		String id="737e975f762214a1";
		int size=CreditRecord.getInstance().sizeOfRecord(id);
		CreditRecord.getInstance().add(id, vo);
		assertEquals(++size,CreditRecord.getInstance().sizeOfRecord(id));
	}
}
