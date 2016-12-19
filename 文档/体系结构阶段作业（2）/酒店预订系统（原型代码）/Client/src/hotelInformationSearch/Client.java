package hotelInformationSearch;
import java.rmi.RemoteException;
import hotelBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		HotelBLService hotelInformationSearchController=new HotelInformationSearchController();
		HotelInformationSearch_Driver driver=new HotelInformationSearch_Driver();
		driver.drive(hotelInformationSearchController);
	}
}
