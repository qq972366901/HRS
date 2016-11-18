package orderManagement;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderManagementController=new OrderManagementController(1);
		OrderManagement_Driver driver=new OrderManagement_Driver();
		driver.drive(orderManagementController);
	}
}
