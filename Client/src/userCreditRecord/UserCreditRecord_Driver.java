package userCreditRecord;
import java.rmi.RemoteException;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserCreditRecord_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			long result2=userBLService.showCredit("12");
			if(result2 ==200) System.out.println("showCredit success");
			CreditRecordVO result3=userBLService.showCreditRecord(new UserVO());
			if(result3 ==new CreditRecordVO()) System.out.println("showCreditRecord success");
			UserType result4=userBLService.login("12","12");
			if(result4 ==UserType.Customer) System.out.println("login success");
			ResultMessage result5=userBLService.logout("12");
			if(result5 ==ResultMessage.Exist) System.out.println("logout success");
	 }
}