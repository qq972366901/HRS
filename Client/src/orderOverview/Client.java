package orderOverview;
import java.rmi.RemoteException;
import orderBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		OrderBLService orderOverviewController=new OrderOverviewController();
		OrderOverview_Driver driver=new OrderOverview_Driver();
		driver.drive(orderOverviewController);
	}
}
