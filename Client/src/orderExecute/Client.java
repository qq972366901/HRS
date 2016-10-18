package orderExecute;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderExecuteController=new OrderExecuteController();
		OrderExecute_Driver driver=new OrderExecute_Driver();
		driver.drive(orderExecuteController);
	}
}

