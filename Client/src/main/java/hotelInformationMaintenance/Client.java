package hotelInformationMaintenance;
import java.rmi.RemoteException;
import hotelBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		HotelBLService hotelInformationMaintenanceController=new HotelInformationMaintenanceController();
		HotelInformationMaintenance_Driver driver=new HotelInformationMaintenance_Driver();
		driver.drive(hotelInformationMaintenanceController);
	}
}
