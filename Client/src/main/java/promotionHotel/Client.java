package promotionHotel;
import java.rmi.RemoteException;
import promotionBLService.*;
public class Client {
	public static void main(String[] args) throws RemoteException{
		PromotionBLService promotionHotelController=new PromotionHotelController();
		PromotionHotel_Driver driver=new PromotionHotel_Driver();
		driver.drive(promotionHotelController);
	}
}
