package userCreditRecharge;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userCreditRechargeController=new UserCreditRechargeController();
		UserCreditRecharge_Driver driver=new UserCreditRecharge_Driver();
		driver.drive(userCreditRechargeController);
	}
}