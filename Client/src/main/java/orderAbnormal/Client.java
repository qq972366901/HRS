package orderAbnormal;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderAbnormalController=new OrderBLServiceController();
		OrderAbnormal_Driver driver=new OrderAbnormal_Driver();
		driver.drive(orderAbnormalController);
	}
}
