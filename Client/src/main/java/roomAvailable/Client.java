package roomAvailable;
import java.rmi.RemoteException;
import roomBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		RoomBLService roomAvailableController=new RoomAvailableController();
		RoomAvailable_Driver driver=new RoomAvailable_Driver();
		driver.drive(roomAvailableController);
	}
}
