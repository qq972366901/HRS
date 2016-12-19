package roomUpdate;
import java.rmi.RemoteException;
import roomBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		RoomBLService roomUpdateController=new RoomUpdateController();
		RoomUpdate_Driver driver=new RoomUpdate_Driver();
		driver.drive(roomUpdateController);
	}
}
