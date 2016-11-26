package userCreditManagement;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userCreditManagementController=new UserCreditManagementController();
		UserCreditManagement_Driver driver=new UserCreditManagement_Driver();
		driver.drive(userCreditManagementController);
	}
}