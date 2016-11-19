package userRegister;
import java.rmi.RemoteException;
import java.util.Calendar;

import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserRegister_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 Calendar time1=Calendar.getInstance();
			time1.set(2016,11,11);
			ResultMessage result=userBLService.register(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"∆’Õ®ª·‘±",1,time1,""));
			if(result ==ResultMessage.Exist) System.out.println("register success");
	 }
}