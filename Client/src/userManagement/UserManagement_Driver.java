package userManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.User;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserManagement_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			ResultMessage result2=userBLService.update(new UserVO());
			if(result2 ==ResultMessage.Exist) System.out.println("update success");
			ResultMessage result3=userBLService.add(new UserVO());
			if(result3 ==ResultMessage.Exist) System.out.println("add success");
			ResultMessage result4=userBLService.delete(new UserVO());
			if(result4 ==ResultMessage.Exist) System.out.println("delete success");
			UserType result5=userBLService.login("12","12");
			if(result5 ==UserType.Customer) System.out.println("login success");
			ResultMessage result6=userBLService.logout("12");
			if(result6 ==ResultMessage.Exist) System.out.println("logout success");
	 }
}