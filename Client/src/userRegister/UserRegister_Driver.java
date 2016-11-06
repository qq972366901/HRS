package userRegister;
import java.rmi.RemoteException;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserRegister_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
			ResultMessage result=userBLService.register(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"∆’Õ®ª·‘±",1,"1981/2/2",""));
			if(result ==ResultMessage.Exist) System.out.println("register success");
	 }
}