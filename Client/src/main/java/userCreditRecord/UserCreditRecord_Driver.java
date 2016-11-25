package userCreditRecord;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserCreditRecord_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			long result2=userBLService.showCredit("12");
			if(result2 ==200) System.out.println("showCredit success");
			Calendar time1=Calendar.getInstance();
			time1.set(2016,11,11);
			List<CreditRecordVO> result3=userBLService.showCreditRecord("1"); 
			if(result3 ==userBLService.showCreditRecord("1")) System.out.println("showCreditRecord success");
			userBLService.login("12","12");
			userBLService.logout("12");
	 }
}