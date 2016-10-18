package userCreditRecharge;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.User;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserCreditRecharge_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			CreditRecordVO result2=userBLService.showCreditRecord(new UserVO());
			if(result2 ==new CreditRecordVO()) System.out.println("showCreditRecord success");
			ResultMessage result3=userBLService.updateCredit(new UserVO(),200);
			if(result3 ==ResultMessage.Exist) System.out.println("updateCredit success");
			UserType result4=userBLService.login("12","12");
			if(result4 ==UserType.Customer) System.out.println("login success");
			ResultMessage result5=userBLService.logout("12");
			if(result5 ==ResultMessage.Exist) System.out.println("logout success");
	 }
}