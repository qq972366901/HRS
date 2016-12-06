package TestuserBLImpl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Test;

import VO.CreditRecordVO;
import common.Operate;
import userBLServiceImpl.Credit;

public class CreditTest {

	@Test
	public void testUpdateCredit() throws RemoteException, ParseException {
		CreditRecordVO vo=new CreditRecordVO("737e975f762214a1",Calendar.getInstance(),"1",Operate.Recharge,50,1000);
		Credit.getInstance().updateCredit(vo);
		assertEquals(1000,Credit.getInstance().showCredit("737e975f762214a1"));
	}

	@Test
	public void testUpdateLevel() throws RemoteException {
		Credit.getInstance().updateLevel("737e975f762214a1", 0);
		assertEquals(0,Credit.getInstance().showLevel("737e975f762214a1"));
	}

	@Test
	public void testUpdateAllLevel() throws RemoteException {
		assertEquals(true,Credit.getInstance().updateAllLevel());
	}

}
