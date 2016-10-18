package orderBuild;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderBuildController=new OrderBuildController();
		OrderBuild_Driver driver=new OrderBuild_Driver();
		driver.drive(orderBuildController);
	}
}
