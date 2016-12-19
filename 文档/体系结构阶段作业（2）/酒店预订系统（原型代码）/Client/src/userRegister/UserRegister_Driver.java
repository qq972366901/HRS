package userRegister;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Object.User;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserRegister_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
			ResultMessage result=userBLService.register(new UserVO());
			if(result ==ResultMessage.Exist) System.out.println("register success");
	 }
}