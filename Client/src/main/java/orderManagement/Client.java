package orderManagement;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderManagementController=new OrderBLServiceController();
		OrderManagement_Driver driver=new OrderManagement_Driver();
		driver.drive(orderManagementController);
	}
}
