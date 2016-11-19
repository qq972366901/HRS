package promotionMemberGrade;
import java.rmi.RemoteException;
import promotionBLService.*;
public class Client{
	public static void main(String[] args) throws RemoteException{
		PromotionBLService promotionMemberGradeController=new PromotionMemberGradeController();
		PromotionMemberGrade_Driver driver=new PromotionMemberGrade_Driver();
		driver.drive(promotionMemberGradeController);
	}
}
