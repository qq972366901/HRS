package userInformationMaintenance;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userInformationMaintenanceController=new UserBLServiceController();
		UserInformationMaintenance_Driver driver=new UserInformationMaintenance_Driver();
		driver.drive(userInformationMaintenanceController);
	}
}
