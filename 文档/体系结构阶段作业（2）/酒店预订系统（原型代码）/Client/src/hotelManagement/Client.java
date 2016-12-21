package hotelManagement;
import java.rmi.RemoteException;
import hotelBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		HotelBLService hotelManagementController=new HotelManagementController();
		HotelManagement_Driver driver=new HotelManagement_Driver();
		driver.drive(hotelManagementController);
	}
}