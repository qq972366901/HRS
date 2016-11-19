package hotelInformationOverview;
import java.rmi.RemoteException;
import hotelBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		HotelBLService hotelInformationOverviewController=new HotelInformationOverviewController();
		HotelInformationOverview_Driver driver=new HotelInformationOverview_Driver();
		driver.drive(hotelInformationOverviewController);
	}
}