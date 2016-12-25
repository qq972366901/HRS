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
	/*
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
		CreditRecord cr=new CreditRecord();
		HashMap<String,CreditRecordVO> map=cr.showCreditRecord("737e975f762214a1");
		assertNotNull(map);
	}

	@Test
	public void testAdd() throws RemoteException, ParseException {
		CreditRecordVO vo=new CreditRecordVO("kkkkk","737e975f762214a1",Calendar.getInstance(),"1",Operate.Recharge,0,31700);
		String id="737e975f762214a1";
		CreditRecord cr=new CreditRecord();
		int size=cr.sizeOfRecord(id);
		cr.add(id, vo);
		assertEquals(++size,cr.sizeOfRecord(id));
	}
	*/
}
