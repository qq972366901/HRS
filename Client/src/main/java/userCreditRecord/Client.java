package userCreditRecord;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userCreditRecordController=new UserCreditRecordController();
		UserCreditRecord_Driver driver=new UserCreditRecord_Driver();
		driver.drive(userCreditRecordController);
	}
}