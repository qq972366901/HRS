package promotionWeb;
import java.rmi.RemoteException;
import promotionBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		PromotionBLService promotionWebController=new PromotionWebController();
		PromotionWeb_Driver driver=new PromotionWeb_Driver();
		driver.drive(promotionWebController);
	}
}
