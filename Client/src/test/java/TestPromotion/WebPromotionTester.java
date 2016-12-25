package TestPromotion;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import PromotionBLServiceImpl.GetWebPromotionDiscount;
import PromotionBLServiceImpl.SearchWebPromotion;
import VO.WebPromotionVO;
import rmi.RemoteHelper;

public class WebPromotionTester {
	/*
	private RemoteHelper remoteHelper;
	@Before
	public void init(){		
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8089/DataFactoryService"));
			System.out.println("success");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("failue");
			e.printStackTrace();
		}
	}
	@Test
	public void testgetWebPromotionByPromotionNumber() throws RemoteException {
		Calendar cal1=Calendar.getInstance();
		cal1.set(Calendar.YEAR,2016);
		cal1.set(Calendar.MONTH,11);
		cal1.set(Calendar.DAY_OF_MONTH,1);
		cal1.set(Calendar.HOUR_OF_DAY,11);
		cal1.set(Calendar.MINUTE,11);
		cal1.set(Calendar.SECOND,1);
		Calendar cal2=Calendar.getInstance();
		cal2.set(Calendar.YEAR,2016);
		cal2.set(Calendar.MONTH,11);
		cal2.set(Calendar.DAY_OF_MONTH,11);
		cal2.set(Calendar.HOUR_OF_DAY,11);
		cal2.set(Calendar.MINUTE,11);
		cal2.set(Calendar.SECOND,1);
		Calendar cal3=Calendar.getInstance();
		cal3.set(Calendar.YEAR,2016);
		cal3.set(Calendar.MONTH,11);
		cal3.set(Calendar.DAY_OF_MONTH,3);
		WebPromotionVO vo=new WebPromotionVO("1","第一个促销活动",cal1,cal2,"南京","新街口",1,9.5);
		assertEquals(vo,SearchWebPromotion.getSearchWebPromotionInstance().getWebPromotionByPromotionNumber("1"));
	}
	@Test
	public void testGetWebPromotionDiscount() throws RemoteException {
		Calendar cal3=Calendar.getInstance();
		cal3.set(Calendar.YEAR,2016);
		cal3.set(Calendar.MONTH,11);
		cal3.set(Calendar.DAY_OF_MONTH,3);
		int discount=(int)(100*GetWebPromotionDiscount.getWebPromotionDiscountInstance().getWebPromotionDiscount("a03b7c8497bbb00458c63328e0052c39","南京","新街口",cal3));
		assertEquals(95,discount);
	}
	*/
}
