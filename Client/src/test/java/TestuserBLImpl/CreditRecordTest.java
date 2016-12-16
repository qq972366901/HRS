package TestuserBLImpl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import VO.CreditRecordVO;
import common.Operate;
import rmi.RemoteHelper;
import userBLServiceImpl.CreditRecord;

public class CreditRecordTest {
	private RemoteHelper remoteHelper;
	@Before
	public void setup(){
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			System.out.println("linked");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("failue");
			e.printStackTrace();
		}
	}
	@Test
	public void testShowCreditRecord() throws RemoteException, ParseException {
		HashMap<String,CreditRecordVO> map=CreditRecord.getInstance().showCreditRecord("737e975f762214a1");
		assertNotNull(map);
	}

	@Test
	public void testAdd() throws RemoteException, ParseException {
		CreditRecordVO vo=new CreditRecordVO("kkkkk","737e975f762214a1",Calendar.getInstance(),"1",Operate.Recharge,0,31700);
		String id="737e975f762214a1";
		int size=CreditRecord.getInstance().sizeOfRecord(id);
		CreditRecord.getInstance().add(id, vo);
		assertEquals(++size,CreditRecord.getInstance().sizeOfRecord(id));
	}
}
