package hotelEverordered;
import java.rmi.RemoteException;
import hotelBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		HotelBLService hotelEverorderedController=new HotelEverorderedController();
		HotelEverordered_Driver driver=new HotelEverordered_Driver();
		driver.drive(hotelEverorderedController);
	}
}
