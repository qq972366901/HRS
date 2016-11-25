package userManagement;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userManagementController=new UserBLServiceController();
		UserManagement_Driver driver=new UserManagement_Driver();
		driver.drive(userManagementController);
	}
}
