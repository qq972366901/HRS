 package TestPromotion;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import PromotionBLServiceImpl.GetHotelPromotionByHotelIDAndTime;
import PromotionBLServiceImpl.GetHotelPromotionDiscount;
import VO.HotelPromotionVO;
import rmi.RemoteHelper;

public class HotelPromotionTester {
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
	public void testGetHotelPromotionByHotelIDAndTime() {
		Calendar cal1=Calendar.getInstance();
		cal1.set(Calendar.YEAR,2016);
		cal1.set(Calendar.MONTH,10);
		cal1.set(Calendar.DAY_OF_MONTH,12);
		cal1.set(Calendar.HOUR_OF_DAY,11);
		cal1.set(Calendar.MINUTE,11);
		cal1.set(Calendar.SECOND,1);
		Calendar cal2=Calendar.getInstance();
		cal2.set(Calendar.YEAR,2017);
		cal2.set(Calendar.MONTH,0);
		cal2.set(Calendar.DAY_OF_MONTH,31);
		cal2.set(Calendar.HOUR_OF_DAY,11);
		cal2.set(Calendar.MINUTE,11);
		cal2.set(Calendar.SECOND,1);
		Calendar cal3=Calendar.getInstance();
		cal3.set(Calendar.YEAR,2016);
		cal3.set(Calendar.MONTH,11);
		cal3.set(Calendar.DAY_OF_MONTH,30);
		HotelPromotionVO vo=new HotelPromotionVO("ff5b036f06cb0e0cf6c5cca27ec17949","酒店策略1",cal1,cal2,10,8,8,10);
		assertEquals(vo,GetHotelPromotionByHotelIDAndTime.getHotelPromotionByHotelIDInstance().getHotelPromotionByHotelIDAndTime("ff5b036f06cb0e0cf6c5cca27ec17949",cal3));
	}
	@Test
	public void testGetHotelPromotionDiscount() throws RemoteException {
		Calendar cal1=Calendar.getInstance();
		cal1.set(Calendar.YEAR,2016);
		cal1.set(Calendar.MONTH,10);
		cal1.set(Calendar.DAY_OF_MONTH,12);
		cal1.set(Calendar.HOUR_OF_DAY,11);
		cal1.set(Calendar.MINUTE,11);
		cal1.set(Calendar.SECOND,1);
		Calendar cal2=Calendar.getInstance();
		cal2.set(Calendar.YEAR,2017);
		cal2.set(Calendar.MONTH,0);
		cal2.set(Calendar.DAY_OF_MONTH,31);
		cal2.set(Calendar.HOUR_OF_DAY,11);
		cal2.set(Calendar.MINUTE,11);
		cal2.set(Calendar.SECOND,1);
		Calendar cal3=Calendar.getInstance();
		cal3.set(Calendar.YEAR,2016);
		cal3.set(Calendar.MONTH,11);
		cal3.set(Calendar.DAY_OF_MONTH,30);
		int discount=(int)(GetHotelPromotionDiscount.getGetHotelPromotionDiscountInstance().getHotelPromotionDiscount("ff5b036f06cb0e0cf6c5cca27ec17949","84da1cbf3a41ae26",4,cal3,cal1,cal2)*100);
		assertEquals(81,discount);
	}
	

}
