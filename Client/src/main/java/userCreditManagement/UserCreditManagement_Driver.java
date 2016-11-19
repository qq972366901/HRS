package userCreditManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import Object.User;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserCreditManagement_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			long result2=userBLService.showCredit("12");
			if(result2 ==200) System.out.println("showCredit success");
			Calendar time1=Calendar.getInstance();
			time1.set(2016,11,11);
			ResultMessage result3=userBLService.updateCredit(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,time1,""),200);
			if(result3 ==ResultMessage.Exist) System.out.println("updateCredit success");
			Calendar time2=Calendar.getInstance();
			time2.set(2016,11,11);
			ResultMessage result4=userBLService.updateLevel(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,time2,""));
			if(result4 ==ResultMessage.Exist) System.out.println("updateLevel success");
			Calendar time3=Calendar.getInstance();
			time3.set(2016,11,11);
			ResultMessage result5=userBLService.updateCreditRecord(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,time3,""));
			if(result5 ==ResultMessage.Exist) System.out.println("updateCreditRecord success");
			UserType result16=userBLService.login("12","12");
			if(result16 ==UserType.Customer) System.out.println("login success");
			ResultMessage result7=userBLService.logout("12");
			if(result7 ==ResultMessage.Exist) System.out.println("logout success");
	 }
}
