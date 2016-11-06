package userInformationMaintenance;
import java.rmi.RemoteException;
import VO.*;
import common.*;
import userBLService.UserBLService;
public class UserInformationMaintenance_Driver {
	 public void drive(UserBLService userBLService) throws RemoteException{
		 ResultMessage result1=userBLService.findByID("12");
			if(result1 ==ResultMessage.Exist) System.out.println("findByID success");
			ResultMessage result2=userBLService.update(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,"1981/2/2",""));
			if(result2 ==ResultMessage.Exist) System.out.println("update success");
			long result3=userBLService.showCredit("12");
			if(result3 ==200) System.out.println("showCredit success");
			ResultMessage result4=userBLService.maintainPeersonalInfo(new UserVO("1","1@nju.edu.cn","3414141","1",false,1,78,"普通会员",1,"1981/2/2",""));
			if(result4 ==ResultMessage.Exist) System.out.println("maintainPeersonalInfo success");
			UserType result5=userBLService.login("12","12");
			if(result5 ==UserType.Customer) System.out.println("login success");
			ResultMessage result6=userBLService.logout("12");
			if(result6 ==ResultMessage.Exist) System.out.println("logout success");
	 }
}