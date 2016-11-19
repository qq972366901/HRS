package userRegister;
import java.rmi.RemoteException;
import userBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		UserBLService userRegisterController=new UserRegisterController();
		UserRegister_Driver driver=new UserRegister_Driver();
		driver.drive(userRegisterController);
	}
}
